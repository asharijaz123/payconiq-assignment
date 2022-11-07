package utils;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * @author MUHAMMAD ASHAR
 * Dated: 30/10/2022
 */
public class SpecBuilder {
    public static RequestSpecification requestBuilder() {
        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com")
                .setContentType(ContentType.JSON).build();
        return req;
    }

    public static ResponseSpecification responseBuilder() {
        ResponseSpecification resspec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
        return resspec;
    }
}
