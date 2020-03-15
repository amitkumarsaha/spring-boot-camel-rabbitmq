package com.amit.boot.camel.controller;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amit.boot.camel.model.Employee;

@RestController
public class RabbitMQController {

		@Produce(value = "direct:startRabbitMQPoint")
		private ProducerTemplate producerTemplate;

		@RequestMapping(value = "/employee", method = RequestMethod.GET)
		public String createEmployee(@RequestParam int id, @RequestParam String name, @RequestParam String designation) {

			Employee emp = new Employee();
			emp.setName(name);
			emp.setDesignation(designation);
			emp.setEmpId(id);

			producerTemplate.asyncSendBody(producerTemplate.getDefaultEndpoint(), emp);
			
			return "Message published to RabbitMQ";
		}
	}
