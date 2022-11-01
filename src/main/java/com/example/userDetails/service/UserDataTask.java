package com.example.userDetails.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.userDetails.entity.UserData;

@Service
public class UserDataTask {
	
 
	boolean update = false;
 

	   public List<UserData> updateData(UserData feedDetails,List<UserData> userDetails) {
	                        update = false;
	                    userDetails.stream().forEach(i -> {
	                        if (i.getUserId() == feedDetails.getUserId()) {
	                            i.setBody(feedDetails.getBody());
	                            update = true;
	                        }
	                    });
	                    if (update == true) {
	                        return userDetails;
	                    } 
	                    else {
	                        throw new RuntimeException("No changes made as userId not found!");
	                        }    
	            }
	                    
	          public List<UserData> printUpdatedData(UserData feedDetails, List<UserData> userDetails) {
	                		
	        	
	        	if (feedDetails.getUserId() == 0) {
	        		throw new RuntimeException("Enter UserId is Null");
	        		
	        	}
	        	else {
	        		return updateData(feedDetails,userDetails);
	        	}
	                	}
	                
	   
	   public List<UserData> userFeedData(UserData feedDetails,List<UserData> userDetails) {
	      
	                
	                if (userDetails == null) {
	                    throw new RuntimeException("No Data found from DataBase");
	                } else {
	                     List<UserData> list = userDetails
	                    		 
	                    		.stream()
	                    		.filter(i -> (i.getUserId() == feedDetails.getUserId()))
	                    		.collect(Collectors.toList());
	                     
	                     if (list.size() == 0) {
	                    		throw new RuntimeException("Enter Valid Userid");
	                    		 }
	                    		else {
	                    			return list;
	                    			
	                }
	                }
	            }
		
	}

	




	        
	    


	

	

	
	



