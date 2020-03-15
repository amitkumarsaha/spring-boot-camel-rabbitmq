package com.amit.boot.camel.route.rabbit;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import com.amit.boot.camel.model.Employee;

@Component
public class RabbitMQRoute extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		
		/**
		 * RabbitMQ Producer Route
		 */
		from("direct:startRabbitMQPoint").id("rabbitMQProducer").marshal(new JacksonDataFormat(Employee.class))
			.log(LoggingLevel.INFO, "${body}")
			.to("rabbitmq:test.exchange?connectionFactory=#rabbitMQConnectionFactory&queue=test.queue&autoDelete=false")
		.end();
		
		/**
		 * RabbitMQ Consumer Route
		 */
		from("rabbitmq:test.exchange?connectionFactory=#rabbitMQConnectionFactory&queue=test.queue&autoDelete=false")
			.id("rabbitMQConsumer")
			.log(LoggingLevel.INFO, "${body}")
			.unmarshal().json(JsonLibrary.Jackson, Employee.class)
			.log(LoggingLevel.INFO, "${body}")
		.end();
	}
}
