package com.pmi.checker;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckerApplicationTests {
	private final Logger log = Logger.getLogger(this.getClass());

	@Test
	public void contextLoads() {
	}

	@Test
	public void loggingTest() {
		log.info("TEST TO DB");
	}

}
