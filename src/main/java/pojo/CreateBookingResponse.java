package pojo;

import java.util.HashMap;
import java.util.Map;

public class CreateBookingResponse {

    public CreateBookingResponse() {

    }

    public CreateBookingResponse(Integer bookingid, CreateBookingPayload booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    private Integer bookingid;
    private CreateBookingPayload booking;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public CreateBookingPayload getBooking() {
        return booking;
    }

    public void setBooking(CreateBookingPayload booking) {
        this.booking = booking;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "createBookingResponse{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}