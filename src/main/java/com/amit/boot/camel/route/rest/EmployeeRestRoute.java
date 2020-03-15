package com.amit.boot.camel.route.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amit.boot.camel.model.Employee;
import com.amit.boot.camel.processor.EmployeeProcessor;

@Component
public class EmployeeRestRoute extends RouteBuilder {

		@Autowired
		EmployeeProcessor employeeRestRouteProcessor;

		@Override
		public void configure() throws Exception {

			restConfiguration()
		      .component("servlet")
		      .bindingMode(RestBindingMode.json)
		      .dataFormatProperty("prettyPrint", "true");

		    rest("/employee")
		    	.get().id("employee")
			    	.route()
			    	.process(employeeRestRouteProcessor)
			    	.to("direct:startRabbitMQPoint");
			    	
	    	rest("/employee")
		    	.post().id("createEmployee")
		    	.outType(Employee.class)
		    	.to("direct:startRabbitMQPoint");

		}
	}
