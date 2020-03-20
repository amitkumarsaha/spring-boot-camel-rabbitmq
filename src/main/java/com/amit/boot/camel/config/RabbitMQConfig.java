package com.amit.boot.camel.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amit.boot.camel.props.RabbitMQProps;
import com.rabbitmq.client.ConnectionFactory;

@Configuration
public class RabbitMQConfig {

	@Autowired
	private RabbitMQProps rabbitMQProps;
	
	@Bean
	public ConnectionFactory rabbitMQConnectionFactory() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost(rabbitMQProps.getHost());
		connectionFactory.setPort(rabbitMQProps.getPort());
		connectionFactory.setUsername(rabbitMQProps.getUsername());
		connectionFactory.setPassword(rabbitMQProps.getPassword());
		connectionFactory.setVirtualHost(rabbitMQProps.getVirtualHost());
		return connectionFactory;
	}
	
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
	
}

