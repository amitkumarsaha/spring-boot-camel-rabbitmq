package com.amit.boot.camel.config;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestRouteConfig extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		restConfiguration()
			.component("servlet")
			.enableCORS(true)
			.bindingMode(RestBindingMode.json)
			.dataFormatProperty("prettyPrint", "true");
	}

}
