package com.example.userbankaccount.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountCommandControllerTester {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void retrieveSingleAccountDetails() throws Exception {
		mockMvc.perform(get("/customers/100/accounts/1837440")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void retrieveSingleAccountDetails_wrong_accid() throws Exception {
		mockMvc.perform(get("/customers/100/accounts/18370")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
}
	
	
	@Test
	public void retrieveSingleAccountDetails_wrong_cusid() throws Exception {
		mockMvc.perform(get("/customers/10/accounts/1837440")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void updateAccount() throws Exception {
		String postData = "{\"request_type\": \"DEBIT\",\"amount\": 20054.45,\"transaction_id\": \"123456\"}";
		mockMvc.perform(put("/accounts/1837440")
				.contentType(MediaType.APPLICATION_JSON)
				.content(postData))
				.andExpect(status().isOk());
	}
	
}
