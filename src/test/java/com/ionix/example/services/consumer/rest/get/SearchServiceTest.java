package com.ionix.example.services.consumer.rest.get;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ionix.example.util.EncryptUtil;
import com.ionix.example.vo.ExampleRS;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceTest {

	private static Logger logger = LogManager.getLogger(SearchServiceTest.class);

	@Autowired
	SearchService searchService;
	
	@Test
	public void getRutTest() {
		ExampleRS exampleRS = searchService.getRut(EncryptUtil.getEncryptDES("1-9"));
		logger.info(exampleRS.toString());
	}

}
