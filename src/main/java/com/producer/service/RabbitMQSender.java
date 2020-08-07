package com.producer.service;

import java.io.Console;
import java.util.Scanner;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.producer.model.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RabbitMQSender {
	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${rabbitmq.exchange}")
	private String exchange;

	@Value("${rabbitmq.routingkey}")
	private String routingkey;

	String kafkaTopic = "Message_send_vai_console";

	public void send(Message message) {
		amqpTemplate.convertAndSend(exchange, routingkey, message);
		System.out.println("Sending this message => " + message);

	}

	
}
