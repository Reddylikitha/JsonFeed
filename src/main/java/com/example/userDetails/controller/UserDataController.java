package com.example.userDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userDetails.entity.UserData;
import com.example.userDetails.restTemplate.UserDataService;



@RestController
@RequestMapping("/JsonFeedDetails")
public class UserDataController {
	
	@Autowired
	UserDataService restClient;
	
	@PostMapping("/FeedData")
	public List<UserData> userdetails(@RequestBody UserData feedDetails){
		return restClient.userData(feedDetails);
	}
	
	@PutMapping("/update")
	public List<UserData> updatedata(@RequestBody UserData feedDetails) {
		return restClient.updateDetails(feedDetails);
	}

}
