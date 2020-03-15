package com.amit.boot.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.amit.boot.camel.model.Employee;

@Component
public class EmployeeRestRouteProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		Message message = exchange.getIn();
		Employee emp = new Employee();
		emp.setName(message.getHeader("name", String.class));
		emp.setDesignation(message.getHeader("designation", String.class));
		emp.setEmpId(message.getHeader("id", Integer.class));
		message.setBody(emp);
	}

}
