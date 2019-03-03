package com.will.rabbitmqconsumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class FixedRateConsumer {

	@RabbitListener(queues = "course.fixedrate", concurrency = "4")
	public void listen(String message) throws InterruptedException{
		Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
		System.out.println(Thread.currentThread().getName() + " Consuming :" + message);
	}

}
