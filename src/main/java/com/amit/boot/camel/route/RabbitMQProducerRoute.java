package com.amit.boot.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

import com.amit.boot.camel.model.Employee;

@Component
public class RabbitMQProducerRoute extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		
		from("direct:startRabbitMQPoint").id("rabbitMQProducer").marshal(new JacksonDataFormat(Employee.class))
			.log("${body}")
			.to("rabbitmq:test.exchange?connectionFactory=#rabbitMQConnectionFactory&queue=test.queue&autoDelete=false")
			.end();
	}
}
