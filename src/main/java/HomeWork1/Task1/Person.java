package HomeWork1.Task1;


public class Person {

    public Person firstName (String firstName) {
        System.out.println("First name: " + firstName);
        return this;
    }

    public Person lastName( String lastName) {
        System.out.println("Last name: " + lastName);
        return this;
    }

    public Person middleName(String middleName) {
        System.out.println("Middle name: " + middleName);
        return this;
    }

    public Person country (String country) {
        System.out.println("Country: " + country);
        return this;
    }

    public Person address (String address) {
        System.out.println("Address: "+ address);
        return this;
    }

    public Person phone (String phone) {
        System.out.println("Phone: "+ phone);
        return this;
    }

    public Person age (int age) {
        System.out.println("Age: "+ age);
        return this;
    }

    public Person gender (String gender) {
        System.out.println("Gender: "+ gender);
        return this;
    }

}
