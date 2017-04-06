package com.xwq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

import com.xwq.custom.Msg;

/**
 * 消息服务启动后可通过访问:http://localhost:8161/来管理消息
 * @author WQXia
 * @date 2017-04-06 10:06:35
 * @version 1.0
 */
@SpringBootApplication
public class MyJmsActiveMqApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MyJmsActiveMqApplication.class, args);
	}
	
	@Autowired
	JmsTemplate jmsTemplate;

	@Override
	public void run(String... args) throws Exception {
		jmsTemplate.send("my-destination", new Msg());
	}
}
