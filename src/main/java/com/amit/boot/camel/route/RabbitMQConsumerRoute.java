package com.amit.boot.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import com.amit.boot.camel.model.Employee;

@Component
public class RabbitMQConsumerRoute extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		
		from("rabbitmq:test.exchange?connectionFactory=#rabbitMQConnectionFactory&queue=test.queue&autoDelete=false")
			.id("rabbitMQConsumer")
			.log("${body}")
			.unmarshal().json(JsonLibrary.Jackson, Employee.class)
			.log("${body}")
			.end();
	}
}
