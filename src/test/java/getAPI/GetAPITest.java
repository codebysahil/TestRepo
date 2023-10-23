package getAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAPITest {
	
	// Rest assured supports two type of approaches BDD and Non BDD approach
	// Below is the non -BDD approach
	RequestSpecification request;

	@BeforeTest
	public void setup() {
		RestAssured.baseURI = "https://gorest.co.in";
		request = RestAssured.given();
		request.header("Authorization", "Bearer 0f3d2ff214da0f31c99f495d1887286d902c8e217a04aea1902d25db9cb9be94");

	}

	@Test
	public void getAllUserAPITest() {
		// Request creation part

		Response res = request.get("/public/v2/users");
		// Response Part
		// status code
		int statusCode = res.statusCode();
		System.out.println("status code " + statusCode);
		// verification point
		Assert.assertEquals(statusCode, 200);

		// status message
		String statusLine = res.statusLine();
		System.out.println("the status line is " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

		// Fetch the body from the response

		// ResponseBody body =res.body();

		String body = res.prettyPrint();
		System.out.println(body);

		// res.prettyPrint();

		// fetch a particular header:

		String contentType = res.header("Content-Type");
		System.out.println("This is the content type " + contentType);

		// fetch all headers

		List<Header> headerList = res.headers().asList();
		System.out.println(headerList.size());
		System.out.println("--------------------------------------------------------");
		for (Header h : headerList) {
			System.out.println(h.getName() + " <--->" + h.getValue());
		}

	}

	@Test
	public void getAllUserWithQueryParameterAPITest() {
		// Request creation part

		request.queryParam("name", "naveen");
		request.queryParam("status", "active");

		Response res = request.get("/public/v2/users");
		// Response Part
		// status code
		int statusCode = res.statusCode();
		System.out.println("status code " + statusCode);
		// verification point
		Assert.assertEquals(statusCode, 200);

		// status message
		String statusLine = res.statusLine();
		System.out.println("the status line is " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

		// Fetch the body from the response

		// ResponseBody body =res.body();

		String body = res.prettyPrint();
		System.out.println(body);

	}

	@Test
	public void getAllUserWithHashMapAPITest() {
		// Request creation part

		Map<String, String> queryParamMap = new HashMap<String, String>();
		queryParamMap.put("name", "naveen");
		queryParamMap.put("status", "active");

		request.queryParams(queryParamMap);

		Response res = request.get("/public/v2/users");
		// Response Part
		// status code
		int statusCode = res.statusCode();
		System.out.println("status code " + statusCode);
		// verification point
		Assert.assertEquals(statusCode, 200);

		// status message
		String statusLine = res.statusLine();
		System.out.println("the status line is " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

		// Fetch the body from the response

		// ResponseBody body =res.body();

		String body = res.prettyPrint();
		System.out.println(body);

	}

}
