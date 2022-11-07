package pojo;

public class BookingDatesPayload {
    private String checkin;
    private String checkout;

    public BookingDatesPayload() {

    }

    public BookingDatesPayload(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getcheckin() {
        return checkin;
    }

    public void setcheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getcheckout() {
        return checkout;
    }

    public void setcheckout(String checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "bookingdatesAPI{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
