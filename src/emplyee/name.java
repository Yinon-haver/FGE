package emplyee;

import java.util.Scanner;

public class name  {

    private String firstName ;
    private String lastName;

    public name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public name() {
        this.firstName = "";
        this.lastName = "";
    }
    public name(name name) {
        this.firstName = name.firstName;
        this.lastName = name.lastName;
    }

    @Override
    public String toString() {
        return firstName  +" "+ lastName ;
    }

    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first name:");
        firstName = in.nextLine();
        System.out.print("Enter last name :");
        lastName = in.nextLine();
    }



    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
