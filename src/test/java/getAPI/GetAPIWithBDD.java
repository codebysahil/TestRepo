package getAPI;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAPIWithBDD {
	// chain pattern --> builder pattern
	@Test
	public void getProductTest() {
		
		given().log().all()
			.when().log().all()
				.get("https://fakestoreapi.com/products")
					.then().log().all()
						.assertThat()
							.statusCode(200) // hard assertions
								.contentType(ContentType.JSON)
									.header("Connection","keep-alive");
		
		
	}
	
	
	

}
