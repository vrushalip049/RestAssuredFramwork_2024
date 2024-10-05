package com.qa.gorest.testes;

import org.testng.annotations.Test;

import com.qa.gorest.client.RestClient;

public class GetUserTest {
	
	RestClient restClient;
	
	
	@Test
	public void getUserTest()
	{
		restClient=new RestClient();
		
		restClient.get("/public-api/users", true)
				.then().log().all()
				.assertThat().statusCode(200);
	
		
	}
	
	@Test
	public void getUserSpecificaTest()
	{
		restClient=new RestClient();
		
		restClient.get("/public-api/users/7447170", true)
				.then().log().all()
				.assertThat().statusCode(200);
	
		
	}

}
