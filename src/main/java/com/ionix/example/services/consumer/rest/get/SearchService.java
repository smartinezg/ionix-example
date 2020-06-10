package com.ionix.example.services.consumer.rest.get;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ionix.example.config.Config;
import com.ionix.example.services.consumer.rest.get.vo.SearchRS;
import com.ionix.example.vo.ExampleRS;
import com.ionix.example.vo.Registers;

@Service
public class SearchService {

	private static final Logger logger = LogManager.getLogger(SearchService.class);
	
	@Autowired
	private Config config;
	
	public ExampleRS getRut(String encryptedRut) {
		ExampleRS exampleRS = new ExampleRS();
		
		String getUrl =	config.propertiesSearch().getEndpoint();
		getUrl+=encryptedRut;
		HttpResponse response = null;
		HttpGet getMethod = new HttpGet(getUrl);		
		logger.info("getRut URL: " + getUrl);
		SearchRS searchRS = null;
		try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
			response = client.execute(getMethod);
			String result = EntityUtils.toString(response.getEntity());
			Gson gson = new Gson();
			
			searchRS = gson.fromJson(result, SearchRS.class);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		logger.info("getRut Response: " + searchRS);
		
		if (searchRS != null) {
			exampleRS.setDescription(searchRS.getDescription());
			exampleRS.setResponseCode(searchRS.getResponseCode());
			if (searchRS.getResult() != null && !searchRS.getResult().getItems().isEmpty()) {
				Registers registers = new Registers();
				registers.setRegisterCount(searchRS.getResult().getItems().size());
				exampleRS.setResult(registers);
			}
		}
		logger.info("ExampleRS : " + exampleRS);
		return exampleRS;
	}

}
