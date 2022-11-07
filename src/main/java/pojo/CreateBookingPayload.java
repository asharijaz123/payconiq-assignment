package pojo;

public class CreateBookingPayload {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private String additionalneeds;
    BookingDatesPayload bookingdates;

    public CreateBookingPayload() {

    }

    public CreateBookingPayload(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public CreateBookingPayload(String firstname, String lastname, int totalprice, boolean depositpaid, BookingDatesPayload bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.additionalneeds = additionalneeds;
        this.bookingdates = bookingdates;
    }

    public String getfirstname() {
        return firstname;
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getlastname() {
        return lastname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public int gettotalprice() {
        return totalprice;
    }

    public void settotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isdepositpaid() {
        return depositpaid;
    }

    public void setdepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getadditionalneeds() {
        return additionalneeds;
    }

    public void setadditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public BookingDatesPayload getbookingdates() {
        return bookingdates;
    }

    public void setbookingdates(BookingDatesPayload bookingdates) {
        this.bookingdates = bookingdates;
    }

    @Override
    public String toString() {
        return "CreateBookingAPI{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", additionalneeds='" + additionalneeds + '\'' +
                ", bookingdates=" + bookingdates +
                '}';
    }
}
