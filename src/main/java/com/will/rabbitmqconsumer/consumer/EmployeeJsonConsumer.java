package com.will.rabbitmqconsumer.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.will.rabbitmqconsumer.entity.Employee;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeeJsonConsumer {

	private ObjectMapper objectMapper = new ObjectMapper();

	@RabbitListener(queues = "course.employee")
	public void listen(String message) throws IOException {
		Employee employee = objectMapper.readValue(message, Employee.class);
		System.out.println(employee);
	}

}
