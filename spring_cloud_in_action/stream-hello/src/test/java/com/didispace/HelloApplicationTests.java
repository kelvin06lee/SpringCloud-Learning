package com.didispace;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HelloApplication.class)
@WebAppConfiguration
//@DirtiesContext
public class HelloApplicationTests {

	@Autowired
	private SinkOut sinkOut;

	@Autowired @Qualifier("input")
	private MessageChannel output;

	@Test
	public void contextLoads() {
//		sinkOut.output().send(MessageBuilder.withPayload("From sinkOut").build());
		output.send(MessageBuilder.withPayload("From MessageChannel").build());
	}

}
