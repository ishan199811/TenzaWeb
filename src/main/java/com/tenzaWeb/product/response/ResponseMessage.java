package com.tenzaWeb.product.response;

import java.util.List;
import java.util.Map;



import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMessage  {
	
	private String status;
	private Object message;
	Object data;
	
	

}
