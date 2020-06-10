package com.ionix.example.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ionix.example.vo.ExampleRS;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchRutControllerTest {

	@Autowired
	SearchRutController searchRutController;
	
	@Test
	public void testSearchRut() {
		ResponseEntity<ExampleRS> exampleRS = searchRutController.searchRut("1-9");
		exampleRS.getStatusCode().is2xxSuccessful();
	}

}
