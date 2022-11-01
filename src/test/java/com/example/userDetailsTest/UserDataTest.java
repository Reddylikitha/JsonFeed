package com.example.userDetailsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.example.userDetails.entity.UserData;
import com.example.userDetails.restTemplate.UserDataService;
import com.example.userDetails.service.UserDataTask;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UserDataTest {
	
	@Autowired
	ObjectMapper object = new ObjectMapper() ;
	
	@Mock 
	private RestTemplate restTemplate;
	
	
	@InjectMocks
	private UserDataTask UserDataTask;
	
	@InjectMocks
	UserDataService restClient;
	
	@Mock
	List<UserData> userDetails;
	UserData[] user;
	
	
	@Test 
	public void testUpdatedData() throws JsonMappingException, JsonProcessingException{
		
		String reqBody = "{\"userId\":7,\"body\":\"Likitha\"}";
		String resBody = "[{\"userId\":7,\"it\":61,\"title\":\"title\",\"body\":\"Likitha\"}]";
		
		UserData feedDetails = object.readValue(reqBody, UserData.class);
		UserData[] user = new UserData[1];
		user[0] = new UserData(7,61,"title","body");
		
		List<UserData> userDetails = Arrays.asList(user);
		
		//String expectedData = object.writeValueAsString(Arrays.asList(user));
				
		List<String> expected = Arrays.asList(resBody);
		
		String original = object.writeValueAsString(UserDataTask.printUpdatedData(feedDetails,userDetails));
		
		Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", UserData[].class))
		.thenReturn(user);
		
		assertEquals(expected,Arrays.asList(original));
		
	}
	@Test
	public void testUserData() throws JsonMappingException, JsonProcessingException{
		
		UserData[] user = new UserData[1];
		user[0] = new UserData(1,2," title"," body");
		List<UserData> userDetails1 = new ArrayList<>(Arrays.asList(user));
	
		Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", UserData[].class))
		.thenReturn(user);
		
		String reqBody = "{\"userId\" : 1}" ;
		UserData feedDetails = object.readValue(reqBody, UserData.class);
		
		assertEquals(1, UserDataTask.userFeedData(feedDetails,userDetails1).size());
		
		
	}

	
	

}
