package pojo;

public class PartialUpdatePayload {
    private String firstname;

    public PartialUpdatePayload() {

    }

    public PartialUpdatePayload(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    private String lastname;

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

    @Override
    public String toString() {
        return "partialUpdate{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }


}
