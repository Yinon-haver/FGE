package emplyee;

import java.util.*;

public class Maneger extends Employee implements Iinfo {

    private String car;
    private String phone;
    List<Integer> employees;


    public Maneger(int ID , emplyee.name name, Date date, int salary, String car, String phone, List<Integer> employees) {
        super(ID,name, date, salary);
        this.car = car;
        this.phone = phone;
        this.employees = employees;
    }

    public Maneger() {
        super();
        this.car = "";
        this.phone = "";
        this.employees = new ArrayList<>();
    }
    public void input(){
        int hasEmployees;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Menager details ");
        super.input();
        System.out.println("Enter Menager car ");
        car=in.nextLine();
        System.out.println("Enter Menager phone ");
        phone=in.nextLine();
    }

    public void print(){
        System.out.println("Manager details :");
        super.print();
        System.out.println("car :" + car);
        System.out.println("phone :" + phone);
        System.out.println();

        for (int i = 0; i <employees.size() ; i++) {
            System.out.println();
            System.out.println("employe number" + i + "details");

        }
    }
    @Override
    public boolean isManager() {
        return true;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Integer> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Integer> employees) {
        this.employees = employees;
    }
}
