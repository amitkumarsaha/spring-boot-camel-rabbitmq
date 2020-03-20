package com.amit.boot.camel;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCamelRabbitMQApp {

    private static final String CAMEL_SERVLET_NAME = "CamelServlet";

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCamelRabbitMQApp.class, args);
	}
	
	@Bean
	public ServletRegistrationBean<CamelHttpTransportServlet> servletRegistrationBean() {
	    ServletRegistrationBean<CamelHttpTransportServlet> servlet = new ServletRegistrationBean<>(new CamelHttpTransportServlet(), "/*");
	    servlet.setName(CAMEL_SERVLET_NAME);
	    return servlet;
	}

}
