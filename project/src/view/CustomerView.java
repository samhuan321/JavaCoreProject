package view;

import java.util.Scanner;

import model.Customer;

public class CustomerView {


    Scanner scanner = new Scanner(System.in);
    public Customer newCustomer(){
        System.out.println("-----------add Customer-----------");
        System.out.print("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("pass: ");
        String pass  = scanner.nextLine();
        System.out.print("address: ");
        String address  = scanner.nextLine();
        System.out.print("phone: ");
        int phone  = scanner.nextInt();

        Customer customer = new Customer(id,name,pass,address,phone);
        return customer;
    }
    public Customer loginCustomer(){
        System.out.println("-----------Login Customer-----------");
        System.out.print("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Pass: ");
        String pass  = scanner.nextLine();
        Customer customer = new Customer(id,pass);
        return customer;
    }

    public int bookingRoom(){
        System.out.println("-----------Booking Room-----------");
        System.out.print("Nhap so phong: ");
        int idRoom = scanner.nextInt();
        scanner.nextLine();
        return idRoom;
    }
}
