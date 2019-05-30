package view;

import model.Admin;
import model.Customer;
import model.HotelClerk;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminView {
    private Scanner scanner;

    public AdminView(){
        scanner = new Scanner(System.in);
    }

    public static <E> void showAll(ArrayList<E> list){
        System.out.println("-----------SHOW ALL-----------");
        for(E e : list){
            System.out.println(e);
        }
    }
    public Admin loginAdmin(){
        System.out.println("-----------Login Admin-----------");
        System.out.print("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Pass: ");
        String pass  = scanner.nextLine();
        Admin admin = new Admin(id,pass);
        return admin;
    }
    public Admin newAdmin(){
        System.out.println("-----------add Admin-----------");
        System.out.print("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("pass: ");
        String pass  = scanner.nextLine();
        scanner.nextLine();
        Admin admin = new Admin(id,name,pass);
        return admin;
    }

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
        scanner.nextLine();
        Customer cu = new Customer(id,name,pass,address,phone);
        return cu;
    }

    public HotelClerk newHotelClerk(){
        System.out.println("-----------add HotelClerk-----------");
        System.out.print("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("pass: ");
        String pass  = scanner.nextLine();
        System.out.print("phone: ");
        int phone  = scanner.nextInt();
        scanner.nextLine();
        HotelClerk ho = new HotelClerk(id,name,pass,phone);
        return ho;
    }

    public Admin findAdminByid(int id, ArrayList<Admin> list){
        for (Admin admin : list) {
            if (admin.getIdAdmin() == id) {
                return admin;
            }
        }
        return null;
    }
    public Customer findCustomerByid(int id, ArrayList<Customer> list){
        for (Customer customer : list) {
            if (customer.getIdCustomer() == id) {
                return customer;
            }
        }
        return null;
    }
    public HotelClerk findClerkByid(int id, ArrayList<HotelClerk> list){
        for (HotelClerk clerk : list) {
            if (clerk.getIdClerk() == id) {
                return clerk;
            }
        }
        return null;
    }
    
    public Admin updateAdmin(){
        System.out.println("-----------UPDATE Admin-----------");
        System.out.print("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("pass: ");
        String pass  = scanner.nextLine();
        scanner.nextLine();
        Admin admin = new Admin(id,name,pass);
        return admin;
      }
    
    public Customer updateCustomer(){
        System.out.println("-----------UPDATE Customer-----------");
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
        scanner.nextLine();
        Customer cu = new Customer(id,name,pass,address,phone);
        return cu;
      }
    
    public HotelClerk updateHotelClerk(){
        System.out.println("-----------add HotelClerk-----------");
        System.out.print("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("pass: ");
        String pass  = scanner.nextLine();
        System.out.print("phone: ");
        int phone  = scanner.nextInt();
        scanner.nextLine();
        HotelClerk ho = new HotelClerk(id,name,pass,phone);
        return ho;
      }
}
