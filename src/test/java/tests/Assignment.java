package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.ENDPOINTS;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.junit.Test;
import pojo.*;

import static io.restassured.RestAssured.given;

public class Assignment {
    @Test
    public void Regression() throws JsonProcessingException {
        Response response;
        String ress;
        RequestSpecification req = utils.SpecBuilder.requestBuilder();
        ResponseSpecification resspec = utils.SpecBuilder.responseBuilder();
        RequestSpecification request = given().spec(req);
        ObjectMapper obj = new ObjectMapper();

        //Login
        LoginPayload loginBody = new LoginPayload("admin", "password123");
        String payloadLogin = obj.writerWithDefaultPrettyPrinter().writeValueAsString(loginBody);
        System.out.println("payload login" + payloadLogin);
        LoginResponse response10 = request.body(payloadLogin).when().post(ENDPOINTS.LOGIN).then().spec(resspec).extract().response().as(LoginResponse.class);
        System.out.println("Access Token is " + response10.getToken());
        String setToken = String.format("token=%s", response10.getToken());

        //Create Booking
        BookingDatesPayload dates = new BookingDatesPayload("2018-01-01", "2019-01-01");
        CreateBookingPayload booking = new CreateBookingPayload("Jim", "Brown", 111, true, dates, "Breakfast");
        String payloadCreateBooking = obj.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        System.out.println("payload createBooking" + payloadCreateBooking);

        CreateBookingResponse response11 = request.body(payloadCreateBooking).when().post(ENDPOINTS.BOOKING).then().spec(resspec).extract().response().as(CreateBookingResponse.class);
        System.out.println("Response_CreateBooking " + response11.toString());
        System.out.println("BookingID " + response11.getBookingid());
        int bookingID = response11.getBookingid();

        //PartialBookingUpdate
        String firstName = "jon";
        String lastName = "snow";
        PartialUpdatePayload partialUpdate = new PartialUpdatePayload(firstName, lastName);
        String partialUpdatePayload = obj.writerWithDefaultPrettyPrinter().writeValueAsString(partialUpdate);
        System.out.println("partialUpdatePayload " + partialUpdatePayload);

        CreateBookingPayload response12 = request.header("Cookie", setToken).body(partialUpdatePayload).when().patch(ENDPOINTS.BOOKING + "/" + bookingID).then().spec(resspec).extract().response().as(CreateBookingPayload.class);
        System.out.println("Response_PartialUpdateBooking " + response12.toString());
        System.out.println("First Name " + response12.getfirstname());
        System.out.println("Last Name " + response12.getlastname());
        Assert.assertEquals("First name should be same ", firstName, response12.getfirstname());
        Assert.assertEquals("Last name should be same ", lastName, response12.getlastname());

        //DeleteBooking
        response = request.delete(ENDPOINTS.BOOKING + "/" + bookingID).then().extract().response();
        ress = response.asString();
        System.out.println("Response code of Delete Booking is " + response.statusCode());
        System.out.println("Response Body of Delete request is " + ress);
        Assert.assertEquals("Response Code should be ", 201, response.statusCode());
        Assert.assertEquals("Booking should be deleted", "Created", ress);

        //getBookingById
        response = request.get(ENDPOINTS.BOOKING + "/" + bookingID).then().extract().response();
        ress = response.asString();
        System.out.println("Response code of Get Booking By ID is " + response.statusCode());
        System.out.println("Response Body of Get Booking By ID is " + ress);
        Assert.assertEquals("Response Code should be ", 404, response.statusCode());
        Assert.assertEquals("Booking should not be available", "Not Found", ress);

    }
}
