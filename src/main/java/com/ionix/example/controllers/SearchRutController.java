package com.ionix.example.controllers;

import javax.validation.Valid;

import org.apache.commons.lang3.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ionix.example.services.consumer.rest.get.SearchService;
import com.ionix.example.util.EncryptUtil;
import com.ionix.example.vo.ExampleRS;

@RestController
@RequestMapping(path="/api", method=RequestMethod.POST)
public class SearchRutController {

	@Autowired
	SearchService searchService;
	
	private ExampleRS exampleRS;
	
	@PostMapping(path="/searchRut")
	public @ResponseBody ResponseEntity<ExampleRS> searchRut (@Valid @RequestParam(name = "param") String param) {
		StopWatch elapsedTime = new StopWatch();
		elapsedTime.start();
		exampleRS = searchService.getRut(EncryptUtil.getEncryptDES(param));
		if (exampleRS == null) {
			elapsedTime.stop();
			exampleRS.setElapsedTime(elapsedTime.getTime());
			return new ResponseEntity<>(exampleRS, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (exampleRS.getResult() == null) {
			elapsedTime.stop();
			exampleRS.setElapsedTime(elapsedTime.getTime());
			return new ResponseEntity<>(exampleRS, HttpStatus.NOT_FOUND);
		}
		if (exampleRS.getResult() != null && exampleRS.getResult().getRegisterCount() == 0) {
			elapsedTime.stop();
			exampleRS.setElapsedTime(elapsedTime.getTime());
			return new ResponseEntity<>(exampleRS, HttpStatus.NOT_FOUND);
		}
		elapsedTime.stop();
		exampleRS.setElapsedTime(elapsedTime.getTime());
		return new ResponseEntity<>(exampleRS, HttpStatus.OK);
	}

}
