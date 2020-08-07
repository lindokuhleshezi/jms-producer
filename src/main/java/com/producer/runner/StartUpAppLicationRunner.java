package com.producer.runner;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.producer.model.Message;
import com.producer.service.RabbitMQSender;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(2)
@Component
public class StartUpAppLicationRunner implements ApplicationRunner {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		String str = "";
		// Obtaining a reference to the console.
		Console con = System.console();

		// Checking If there is no console available, then exit.
		if (con == null) {
			System.out.print("No console available");
			return;
		}
		// quit if input is q
		while (!str.equalsIgnoreCase("q")) {
			// Read a string and then display it.
			str = con.readLine("Enter your Message or (q to quit): ");
			// check if the input is not equal to q for quiting or not empty
			if (str.isEmpty()) {
				log.info("Message cannot be blank");
			} else if (!str.equalsIgnoreCase("q") && !str.isEmpty()) {
				this.rabbitMQSender.send(new Message(str));
			}
		}
	}

}
