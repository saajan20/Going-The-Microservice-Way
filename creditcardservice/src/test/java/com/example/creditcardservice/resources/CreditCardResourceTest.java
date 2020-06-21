package com.example.creditcardservice.resources;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.creditcardservice.models.CreditCardDetails;
import com.example.creditcardservice.models.UpdateAmount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class CreditCardResourceTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testRetrieveDetails() throws Exception{
		
		mockMvc.perform(get("/customers/pathak510/creditcard/1234567898765432")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
	}
	
	@Test
	public void testRetrieveExceptionWithCustomerId() throws Exception{
		
		mockMvc.perform(get("/customers/pathak430/creditcard/1234567898765432")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
		
	}
	@Test
	public void testRetrieveExceptionWithCardNo() throws Exception{
		
		MvcResult result=mockMvc.perform(get("/customers/pathak510/creditcard/1234567898765438")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound()).andReturn();
		MockHttpServletResponse response=result.getResponse();
		        assertEquals(HttpStatus.NOT_FOUND.value(),response.getStatus());
		
	}
	@Test void testUpdateAmount() throws Exception{
		
		CreditCardDetails mockCreditCard=new CreditCardDetails();
		mockCreditCard.setCardNo("1234567898765432");
		mockCreditCard.setCardBalance(12000.00);
		mockCreditCard.setCustomerId("pathak510");
		mockCreditCard.setCardLimit(50000.00);
		mockCreditCard.setCardExpirey("2029/12/31");
		mockCreditCard.setCreatedBy("ABC");
		mockCreditCard.setCreatedOn("2020/02/06");
		mockCreditCard.setModifiedBy("Orchestrator");
		mockCreditCard.setModifiedOn("2020/02/08");
		
		String jsonInput=this.mapToJsonAns(mockCreditCard);
		
		UpdateAmount mockUpdateAmount=new UpdateAmount("CREDIT",12000.00,"123456789");
		String inputInJson=this.mapToJson(mockUpdateAmount);
		
		
//		MvcResult result=mockMvc.perform(put("/creditcard/1234567898765432",mockUpdateAmount)
//				.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk()).andReturn();
		RequestBuilder requestBuilder=MockMvcRequestBuilders
				.put("/creditcard/1234567898765432")
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		         
		
		MockHttpServletResponse response=result.getResponse();
		String jsonOutput=response.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
        assertEquals(HttpStatus.OK.value(),response.getStatus());
		
	}
	
	
    private String mapToJsonAns(CreditCardDetails mockCreditCard) throws JsonProcessingException {
		
    	ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(mockCreditCard);
		
	}

	//maps an Object into a JSON String. Uses a Jackson ObjectMapper.
	private String mapToJson(UpdateAmount mockUpdateAmount) throws JsonProcessingException {
		
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(mockUpdateAmount);
		
	}
	
	
	

}
