package emplyee;

import java.util.Scanner;

public  class Employee implements Iinfo{

    private  int ID;
    private name name;
    private Date date;
    private int salary;

    public Employee(int ID ,emplyee.name name, Date date, int salary) {
        this.ID =ID;
        this.name = new name(name);
        this.date = new Date(date);
        this.salary = salary;
    }

    public Employee() {
        this.ID = 00000000;
        this.name = new name();
        this.date = new Date();
        this.salary = 0;
    }

    @Override
    public String toString() {
        return "emplye: " + name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void input() {
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter Employee details ");
        name.input();
        date.input();
        System.out.println("Enter Employee salary ");
        salary = in.nextInt();
    }


    public void print() {
        System.out.println("Employee details :");
        System.out.println("Name :" + name);
        System.out.println("Date :" + date);
        System.out.println("salary :" + salary);
    }

    @Override
    public boolean isManager() {
        return false;
    }

    public emplyee.name getName() {
        return name;
    }

    public void setName(emplyee.name name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }



}


