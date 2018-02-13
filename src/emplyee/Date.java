package emplyee;

import java.util.Scanner;

public class Date  {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(){
        this.day = 0;
        this.month = 0;
        this.year = 0;

    }

    public Date(Date date) {
        this.day = date.day;
        this.month = date.month;
        this.year = date.year;
    }

    @Override
    public String toString() {
        return day+"/"+ month+"/"+year;

    }
    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the emplyee Date");
        System.out.print("Enter the Year :");
        year=in.nextInt();
        System.out.print("Enter the mounth :");
        month=in.nextInt();
        System.out.print("Enter the day :");
        day=in.nextInt();


    }


}
