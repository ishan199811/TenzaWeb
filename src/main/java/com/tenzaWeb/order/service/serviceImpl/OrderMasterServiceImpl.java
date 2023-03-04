package com.tenzaWeb.order.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.tenzaWeb.address.model.entity.Address;
import com.tenzaWeb.address.repository.AddressRepository;
import com.tenzaWeb.address.service.AdderessService;
import com.tenzaWeb.cart.model.request.CartDTO;
import com.tenzaWeb.cart.model.request.CartItemDto;
import com.tenzaWeb.cart.service.CartService;
import com.tenzaWeb.order.exception.OrderNotFoundException;
import com.tenzaWeb.order.model.dto.checkout.CheckoutItemDto;
import com.tenzaWeb.order.model.entity.OrderItems;
import com.tenzaWeb.order.model.entity.OrderMaster;
import com.tenzaWeb.order.repository.OrderItemsRepository;
import com.tenzaWeb.order.repository.OrderMasterRepository;
import com.tenzaWeb.order.service.OrderMasterService;
import com.tenzaWeb.user.model.User;
import com.tenzaWeb.user.service.SecurityService;
import com.tenzaWeb.user.service.UserService;





@Service
public class OrderMasterServiceImpl implements OrderMasterService {
	@Autowired
	AddressRepository addressRepo;

	
	@Autowired 
	CartService cartService ;
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrderMasterRepository orderRepository;
	
	@Autowired
	OrderItemsRepository orderItemsRepository;
	
	

	@Autowired
	SecurityService securityService;
	
	  String baseURL;

	    
	    String apiKey;

	    
	    // create total price
	    SessionCreateParams.LineItem.PriceData createPriceData(CheckoutItemDto checkoutItemDto) {
	        return SessionCreateParams.LineItem.PriceData.builder()
	                .setCurrency("INR")
	                .setUnitAmount( ((long) checkoutItemDto.getPrice()) * 100)
	                .setProductData(
	                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
	                                .setName(checkoutItemDto.getProductName())
	                                .build())
	                .build();
	    }

	    // build each product in the stripe checkout page
	    SessionCreateParams.LineItem createSessionLineItem(CheckoutItemDto checkoutItemDto) {
	        return SessionCreateParams.LineItem.builder()
	                // set price for each product
	                .setPriceData(createPriceData(checkoutItemDto))
	                // set quantity for each product
	                .setQuantity(Long.parseLong(String.valueOf(checkoutItemDto.getQuantity())))
	                .build();
	    }

	    // create session from list of checkout items
	    public Session createSession(List<CheckoutItemDto> checkoutItemDtoList) throws StripeException {

	        // supply success and failure url for stripe
	        String successURL = baseURL + "payment/success";
	        String failedURL = baseURL + "payment/failed";

	        // set the private key
	        Stripe.apiKey = apiKey;

	        List<SessionCreateParams.LineItem> sessionItemsList = new ArrayList<>();

	        // for each product compute SessionCreateParams.LineItem
	        for (CheckoutItemDto checkoutItemDto : checkoutItemDtoList) {
	            sessionItemsList.add(createSessionLineItem(checkoutItemDto));
	        }

	        // build the session param
	        SessionCreateParams params = SessionCreateParams.builder()
	                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
	                .setMode(SessionCreateParams.Mode.PAYMENT)
	                .setCancelUrl(failedURL)
	                .addAllLineItem(sessionItemsList)
	                .setSuccessUrl(successURL)
	                .build();
	        return Session.create(params);
	    }

	    public long placeOrder(String userId,Address address) {
	        // first let get cart items for the user
	    	
			
	    	String userId1 = securityService.findLoggedInUsername();
	    	User user=userService.findByUserId( userId1);
	    	address.setUserId(user);			
	    	addressRepo.save(address);
			
	    	
	    	address.setUserId(user);
           
	    	
	    	CartDTO cartDto = cartService.listCartItems(user);

	    	
	        List<CartItemDto> cartItemDtoList = cartDto.getCartItems();

	        // create the order and save it
	        OrderMaster newOrder = new OrderMaster();
	        newOrder.setCreatedDate(new Date());
	        newOrder.setAddressId(address);
	        newOrder.setUser(user);
	        newOrder.setTotalPrice(cartDto.getTotalCost());
	        orderRepository.save(newOrder);
	        
	        for (CartItemDto cartItemDto : cartItemDtoList) {
	            // create orderItem and save each one
	            OrderItems orderItem = new OrderItems();
	            orderItem.setCreatedDate(new Date());
	            orderItem.setPrice(cartItemDto.getProduct().getProductPrice());
	            orderItem.setProduct(cartItemDto.getProduct());
	            orderItem.setQuantity(cartItemDto.getProductQuatity());
	            orderItem.setOrder(newOrder);
	            // add to order item list
	            orderItemsRepository.save(orderItem);
	        }
	        //
	         cartService.deleteUserCartItems(user);
	         return  newOrder.getOrderId();

	    }

	    public List<OrderMaster> getOrderByUserId(User userId) {
	        return orderRepository.findAllByUserOrderByCreatedDateDesc(userId);
	    }
	    
	    @Override
	    public List<OrderMaster> getByUser(User user) {
	        return orderRepository.findAllByUser(user);
	    }


	    public OrderMaster getOrder(long orderId) throws OrderNotFoundException {
	        Optional<OrderMaster> order = orderRepository.findById(orderId);
	        if (order.isPresent()) {
	            return order.get();
	        }
	        throw new OrderNotFoundException("Order not found");
	    }

		@Override
		public List<OrderItems> getOrderItemsByOrder(OrderMaster order) {
			// TODO Auto-generated method stub
			return orderItemsRepository.getByOrder(order);
		}

		@Override
		public List<OrderMaster> getAllOrders() {
			// TODO Auto-generated method stub
			return orderRepository.findAll();
		}
		@Override
		public List<OrderItems> getAllOrdersItems(OrderMaster order) {
			// TODO Auto-generated method stub
			return orderItemsRepository.getByOrder(order);
		}
		
		
		
	}






		

	    
	