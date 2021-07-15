package gitHubProject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHubSSHTest {
  int sshId;
  String sshKey;
  RequestSpecification requestSpec;
  ResponseSpecification responseSpec;
  
  @BeforeClass
  public void setUp() {
  requestSpec = new RequestSpecBuilder()
			   .setContentType(ContentType.JSON)
			   .setBaseUri("https://api.github.com")
			   .addHeader("Authorization", "token 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").build();
  responseSpec = new ResponseSpecBuilder()
		  .expectStatusCode(200)
          .expectContentType("application/json")
          .build();
  }
  
  @Test(priority=1)//(enabled=false) 
  public void sshPost() {
	  String reqBody="{\"title\": \"TestAPIKey\", \"key\": \"ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIPbxBxKFo+jujYyZdaB/MO0jlEg7CV6zbgxw2BNj527m\"}";
	  System.out.println(reqBody);
	  Response response = given().spec(requestSpec).body(reqBody).when().post("/user/keys");
	 System.out.println(response);
	 String respBody = response.getBody().asPrettyString();
	  System.out.println(respBody);
	  sshId=response.then().extract().path("id");
	  sshKey=response.then().extract().path("key");
	  System.out.println(sshId);
	  System.out.println(sshKey);
	  //Assertion
	  response.then().statusCode(201);
  }
  @Test(priority=2)
  public void sshGet() {
  Response response = given().spec(requestSpec).when().get("/user/keys");
  String res= response.body().asPrettyString();
	  System.out.println(res);
	// Assertion
	  response.then().statusCode(200);
	  
  }
  @Test(priority=3)
  public void sshDelete() {
	  Response response = given().spec(requestSpec).pathParam("keyId", sshId).when().delete("/user/keys"+ "/{keyId}");
	  String resdel = response.getBody().asPrettyString();
	  System.out.println(resdel);
	// Assertion
	  response.then().statusCode(204);
  }
}
