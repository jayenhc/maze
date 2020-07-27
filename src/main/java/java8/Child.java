package java8;

public class Child {
    public String firstName;
    public String lastName;
    int id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Child(final String firstName, final String lastName, final int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String toString() {
        return id + " : " + firstName + " " + lastName;
    }

}
