package com.devsuperior.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feignClients.WorkerFeignClient;

@Service
public class PaymentService {
	
	
	@Autowired
	WorkerFeignClient feignClient;
	
	public Payment getPayment(Long workerId, int days) {
		
		Worker worker = feignClient.findById(workerId).getBody();
		
		return new Payment(worker.getName(),worker.getDailyIncome(), days);
	}
	
	
}
