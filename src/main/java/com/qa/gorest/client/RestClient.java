package com.qa.gorest.client;

import java.util.Map;

import com.qa.gorest.FrameworkException.APIFrameworkException;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.http.*;
import io.restassured.response.Response;

public class RestClient {

	private static final String BASE_URI="https://gorest.co.in";
	private static final String BEARER_TOKEN="5637cb7b5cd298ac786fd59b9f004d741f0af10cf59372288638f00ebea47bcc";
	
	private static RequestSpecBuilder specBuilder;
	 static 
	 {
		 specBuilder=new RequestSpecBuilder();
	 }

	private void AddAuthorization() {
		//specBuilder.addHeader("Authorization","Bearer 5637cb7b5cd298ac786fd59b9f004d741f0af10cf59372288638f00ebea47bcc");
		specBuilder.addHeader("Authorization","Bearer "+BEARER_TOKEN);

	}

	private void ContentType(String Contentype) {
		switch (Contentype.toLowerCase()) {
		case "json":
			specBuilder.setContentType(ContentType.JSON);
			break;

		case "xml":
			specBuilder.setContentType(ContentType.XML);
			break;

		case "text":
			specBuilder.setContentType(ContentType.TEXT);
			break;

		case "multipart":
			specBuilder.setContentType(ContentType.MULTIPART);
			break;

		default:
			System.out.println("Please provide correct content type");
			throw new APIFrameworkException("Please provide correct content type");
		// break;
		}

	}

	private RequestSpecification createSpecBuilder() {
		//specBuilder.setBaseUri("https://gorest.co.in");
		specBuilder.setBaseUri(BASE_URI);
		AddAuthorization();
		return specBuilder.build();
	}

	private RequestSpecification createSpecBuilder(Map<String, String> headerparm) {
		//specBuilder.setBaseUri("https://gorest.co.in");
		specBuilder.setBaseUri(BASE_URI);
		AddAuthorization();
		if (headerparm != null) {
			specBuilder.addHeaders(headerparm);
		}
		return specBuilder.build();
	}

	private RequestSpecification createSpecBuilder(Map<String, String> headerparm, Map<String, String> queryParmE) {
		//specBuilder.setBaseUri("https://gorest.co.in");
		specBuilder.setBaseUri(BASE_URI);
		AddAuthorization();
		if (headerparm != null) {
			specBuilder.addHeaders(headerparm);
		}
		if (queryParmE != null) {
			specBuilder.addQueryParams(queryParmE);
		}
		return specBuilder.build();
	}

	private RequestSpecification createSpecBuilder(Object requestBody, String ContenType) {
		//specBuilder.setBaseUri("https://gorest.co.in");
		specBuilder.setBaseUri(BASE_URI);
		AddAuthorization();
		ContentType(ContenType);
		if (requestBody != null) {
			specBuilder.setBody(requestBody);
		}

		return specBuilder.build();
	}

	private RequestSpecification createSpecBuilder(Object requestBody, String ContenType,
			Map<String, String> headerparm) {
		//specBuilder.setBaseUri("https://gorest.co.in");
		specBuilder.setBaseUri(BASE_URI);
		AddAuthorization();
		ContentType(ContenType);
		if (requestBody != null) {
			specBuilder.setBody(requestBody);
		}
		if (headerparm != null) {
			specBuilder.addHeaders(headerparm);
		}

		return specBuilder.build();
	}

	// Http method utils

	public Response get(String serviceUrl,boolean log)
	{
		if (log)
		{
		return RestAssured.given(createSpecBuilder()).log().all()
		// or .spec(createSpecBuilder())
		.when()
		.get(serviceUrl);
		}
		return RestAssured.given(createSpecBuilder())
		// or .spec(createSpecBuilder())
		.when()
		.get(serviceUrl);
	}
	

	public Response get(String serviceUrl, Map<String,String> HeaderMap,boolean log)
	{
		if (log)
		{
		return RestAssured.given(createSpecBuilder(HeaderMap)).log().all()
		// or .spec(createSpecBuilder())
		.when()
		.get(serviceUrl);
		}
		return RestAssured.given(createSpecBuilder())
		// or .spec(createSpecBuilder())
		.when()
		.get(serviceUrl);
	}
	
	public Response get(String serviceUrl, Map<String,String> HeaderMap,Map<String,String> queryParm,boolean log)
	{
		if (log)
		{
		return RestAssured.given(createSpecBuilder(HeaderMap, queryParm)).log().all()
		// or .spec(createSpecBuilder())
		.when()
		.get(serviceUrl);
		}
		return RestAssured.given(createSpecBuilder())
		// or .spec(createSpecBuilder())
		.when()
		.get(serviceUrl);
	}
	
	public Response post(String serviceUrl, String contentType,Object object,Map<String,String> HeaderMap,boolean log)
	{
		if (log)
		{
		return RestAssured.given(createSpecBuilder(object, contentType, HeaderMap)).log().all()
		// or .spec(createSpecBuilder())
		.when()
		.post(serviceUrl);
		}
		return RestAssured.given(createSpecBuilder(object, contentType, HeaderMap))
				// or .spec(createSpecBuilder())
				.when()
				.post(serviceUrl);
	}
	
	public Response post(String serviceUrl, String contentType,Object object,boolean log)
	{
		if (log)
		{
		return RestAssured.given(createSpecBuilder(object, contentType)).log().all()
		// or .spec(createSpecBuilder())
		.when()
		.post(serviceUrl);
		}
		return RestAssured.given(createSpecBuilder(object, contentType))
				// or .spec(createSpecBuilder())
				.when()
				.post(serviceUrl);
	}
	
	public Response put(String serviceUrl, String contentType,Object object,Map<String,String> HeaderMap,boolean log)
	{
		if (log)
		{
		return RestAssured.given(createSpecBuilder(object, contentType, HeaderMap)).log().all()
		// or .spec(createSpecBuilder())
		.when()
		.put(serviceUrl);
		}
		return RestAssured.given(createSpecBuilder(object, contentType, HeaderMap))
				// or .spec(createSpecBuilder())
				.when()
				.post(serviceUrl);
	}
	
	public Response put(String serviceUrl, String contentType,Object object,boolean log)
	{
		if (log)
		{
		return RestAssured.given(createSpecBuilder(object, contentType)).log().all()
		// or .spec(createSpecBuilder())
		.when()
		.put(serviceUrl);
		}
		return RestAssured.given(createSpecBuilder(object, contentType))
				// or .spec(createSpecBuilder())
				.when()
				.put(serviceUrl);
	}
	
	public Response patch(String serviceUrl, String contentType,Object object,Map<String,String> HeaderMap,boolean log)
	{
		if (log)
		{
		return RestAssured.given(createSpecBuilder(object, contentType, HeaderMap)).log().all()
		// or .spec(createSpecBuilder())
		.when()
		.patch(serviceUrl);
		}
		return RestAssured.given(createSpecBuilder(object, contentType, HeaderMap))
				// or .spec(createSpecBuilder())
				.when()
				.patch(serviceUrl);
	}
	
	public Response patch(String serviceUrl, String contentType,Object object,boolean log)
	{
		if (log)
		{
		return RestAssured.given(createSpecBuilder(object, contentType)).log().all()
		// or .spec(createSpecBuilder())
		.when()
		.patch(serviceUrl);
		}
		return RestAssured.given(createSpecBuilder(object, contentType))
				// or .spec(createSpecBuilder())
				.when()
				.patch(serviceUrl);
	}
	
	public Response delete(String serviceUrl,boolean log)
	{
		if (log)
		{
		return RestAssured.given(createSpecBuilder()).log().all()
		// or .spec(createSpecBuilder())
		.when()
		.delete(serviceUrl);
		}
		return RestAssured.given(createSpecBuilder()).log().all()
				// or .spec(createSpecBuilder())
				.when()
				.delete(serviceUrl);
	}
}
