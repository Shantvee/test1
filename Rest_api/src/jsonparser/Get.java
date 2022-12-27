package jsonparser;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get 
{
public static void main(String[] args) 
{
	RestAssured.baseURI="https://reqres.in/";
	RequestSpecification r = RestAssured.given();
	Response response = r.request(Method.GET,"/api/users?page=2");
	String str = response.asString();
	JsonPath path = new JsonPath(str);
	String value = path.getString("data[0].avatar");
	System.out.println(value);	
}
}
