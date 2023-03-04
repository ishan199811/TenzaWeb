package com.tenzaWeb.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenzaWeb.payment.model.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment , Long> {

}
