package com.example.userDetails.restTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.userDetails.entity.UserData;
import com.example.userDetails.service.UserDataTask;


@Service
public class UserDataService {
	
	RestTemplate  restTemplate = new RestTemplate();
	
	@Autowired
	UserDataTask serviceClass;
	
	
	
	@Value ("${JsonFeed:http://localhost:}")
	String FeedLink;
	
	public List<UserData> updateDetails(UserData feedDetails) {
	      
	       
        UserData[] user = restTemplate.getForObject(FeedLink, UserData[].class);
        List<UserData> userDetails;
       userDetails = new ArrayList<>(Arrays.asList(user));
       return serviceClass.printUpdatedData(feedDetails,userDetails);

}
	
	public List<UserData> userData(UserData feedDetails) {
	       
        UserData[] user = restTemplate.getForObject(FeedLink, UserData[].class);
        List<UserData> userDetails;
        userDetails = new ArrayList<>(Arrays.asList(user));
        return serviceClass.userFeedData(feedDetails,userDetails);
}
}
