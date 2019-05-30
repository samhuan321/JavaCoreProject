package controller;


import dao.AdminDao;
import model.Admin;
import model.Customer;
import model.HotelClerk;

import view.AdminView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminController {
    private AdminDao adminDao;
    private AdminView adminView;

    public AdminController() {
        adminDao = new AdminDao();
        adminView = new AdminView();

    }

    public void showAllAdmin() {
        ArrayList<Admin> adminList = adminDao.getAllAdmin();
        if (adminList != null && !adminList.isEmpty()) {
            adminView.showAll(adminList);
        }
    }
    public void showAllCustomer() {
        ArrayList<Customer> customerList = adminDao.getAllCustomer();
        if (customerList != null && !customerList.isEmpty()) {
            adminView.showAll(customerList);
        }
    }
    public void showAllClerk() {
        ArrayList<HotelClerk> clerkList = adminDao.getAllClerk();
        if (clerkList != null && !clerkList.isEmpty()) {
            adminView.showAll(clerkList);
        }
    }
    public Admin loginAdmin() {
    	Admin admin = adminView.loginAdmin();
        if (admin != null) {
            return adminDao.loginAdmin(admin.getIdAdmin(), admin.getPassAdmin());
        }
        return null;
    }
    public void sort(){

    }
    public void newAdmin() {
        Admin admin = adminView.newAdmin();
            if (admin != null) {
                adminDao.addAdmin(admin);
            }
    }

    public void newCustomer() {
        Customer cu = adminView.newCustomer();
        if (cu != null) {
            adminDao.addCustomer(cu);
        }
    }

    public void newHotelClerk() {
        HotelClerk ho = adminView.newHotelClerk();
        if (ho != null) {
            adminDao.addHotelClerk(ho);
        }
    }
    public void searchAdmin(){
        ArrayList<Admin> adminList = adminDao.getAllAdmin();
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------SEARCH------------------");
        int idSearch;
        System.out.print("Nhap id muon search : ");
        idSearch = sc.nextInt();
        sc.nextLine();
        Admin ad = adminView.findAdminByid(idSearch,adminList);
        System.out.println(ad);
    }
    public void searchCustomer(){
        ArrayList<Customer> customerList = adminDao.getAllCustomer();
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------SEARCH------------------");
        int idSearch;
        System.out.print("Nhap id muon search : ");
        idSearch = sc.nextInt();
        sc.nextLine();
        Customer cm = adminView.findCustomerByid(idSearch,customerList);
        System.out.println(cm);
    }
    public void searchClerk(){
        ArrayList<HotelClerk> clerkList = adminDao.getAllClerk();
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------SEARCH------------------");
        int idSearch;
        System.out.print("Nhap id muon search : ");
        idSearch = sc.nextInt();
        sc.nextLine();
        HotelClerk clerk = adminView.findClerkByid(idSearch,clerkList);
        System.out.println(clerk);
    }
    
    public void updateAdmin() {
        Admin admin = adminView.newAdmin();
        if (admin != null) {
        	adminDao.updateAdmin(admin);
        }
      }
    
    public void updateCustomer() {
        Customer cu = adminView.newCustomer();
        if (cu != null) {
        	adminDao.updateCustomer(cu);
        }
      }
    
    public void updateHotelClerk() {
        HotelClerk ho = adminView.newHotelClerk();
        if (ho != null) {
        	adminDao.updateHotelClerk(ho);
        }
      }
}
