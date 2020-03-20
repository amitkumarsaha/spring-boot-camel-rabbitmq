package com.amit.boot.camel.route.rest;

import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.amit.boot.camel.model.Employee;

@Component
public class EmployeeRestRoute extends RouteBuilder {

		@Override
		public void configure() throws Exception {
			
			
		    rest("/employee")
		    	.get().id("employee")
		    	.route()
                .process(exchange -> {
                	Employee employee = new Employee();
                	Message message = exchange.getIn();
            		employee.setName(message.getHeader("name", String.class));
            		employee.setDesignation(message.getHeader("designation", String.class));
            		employee.setEmpId(message.getHeader("id", Integer.class));
            		exchange.getIn().setBody(employee);
                })
		    	.to("direct:startRabbitMQPoint");
			
		    
	    	rest("/employee")
		    	.post().id("createEmployee")
		    	.outType(Employee.class)
		    	.to("direct:startRabbitMQPoint");

		}
	}
