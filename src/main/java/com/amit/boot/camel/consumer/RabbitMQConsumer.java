package com.amit.boot.camel.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.amit.boot.camel.model.Employee;

@Component
public class RabbitMQConsumer {

	@RabbitListener(queues = "test.queue")
	public void recievedMessage(Employee employee) {
		
		System.out.println("Message From RabbitMQ: " + employee);
	}
}