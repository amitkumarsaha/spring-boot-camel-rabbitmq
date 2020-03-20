package com.amit.boot.camel.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "spring.rabbitmq")
@Getter
@Setter
public class RabbitMQProps {
	
	private String host;
	private Integer port;
	private String username;
	private String password;
	private String virtualHost;

}
