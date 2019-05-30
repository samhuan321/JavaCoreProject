package main;

import java.util.Scanner;

import controller.AdminController;
import controller.CustomerController;
import controller.HotelClerkController;
import model.Admin;
import model.Customer;
import model.HotelClerk;

public class CustomerMain {

    public static void showMenu() {
        System.out.println("---------- MENU -----------");
        System.out.println("Customer");
        System.out.println("1. Register");
        System.out.println("2. Login Customer");
        System.out.println("3. Booking Room For User");
        System.out.println("HotelClerk");
        System.out.println("4. Show Info Customer"	);
        System.out.println("5. Login Clerk");
        System.out.println("6. Views All Room");
        System.out.println("7. Search/Filter Room");
        System.out.println("8. Update Status Room");
        System.out.println("Admin");
        System.out.println("9. Login Admin");
        System.out.println("10. Show All Users");
        System.out.println("11. Create new Users");
        System.out.println("12. Search Users");
        System.out.println("13. Update infomation");
        System.out.println(". Exit");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminController adminController = new AdminController();
        CustomerController customerController = new CustomerController();
        HotelClerkController hotelClerkController = new HotelClerkController();
        HotelClerk hotelClerk = null;
        Admin admin = null;
        Customer customer = null;
        boolean exit = true;
        while (exit) {
            showMenu();
            System.out.print("Choosing: ");
            int choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1:
                    if(customer == null) {
                        customerController.newCustomer();
                    } else {
                        System.out.println("Ban Da Dang Nhap");
                    }
                    break;
                case 2:
                    if(customer == null) {
                        customer = customerController.loginCustomer();
                        if(customer != null) {
                            System.out.println("Login Successful");
                        } else {
                            System.out.println("Login Fail");
                        }
                    } else {
                        System.out.println("Ban Da Dang Nhap");
                    }
                    break;
                case 3:
                    if(customer != null) {
                        if(customerController.bookingRoom(customer.getIdCustomer())) {
                            System.out.println("Booking Room Successful");
                        } else {
                            System.out.println("Booking Room Fail");
                        }
                    } else {
                        System.out.println("Ban Chua Dang Nhap. Khong The Booking");
                    }
                    break;
                case 4:
                    if (customer != null) {
                        System.out.println("ID : " + customer.getIdCustomer());
                        System.out.println("Name : " + customer.getNameCustomer());
                        System.out.println("Phone : " + customer.getPhoneCustomer());
                        System.out.println("Address : " + customer.getAddressCustomer());
                    } else {
                        System.out.println("Ban Phai Dang Nhap Moi Co Thong Tin.");
                    }
                    break;
                case 5:
                    if(hotelClerk == null) {
                        hotelClerk = hotelClerkController.loginHotelClerk();
                        if(hotelClerk != null) {
                            System.out.println("Login Successful");
                        } else {
                            System.out.println("Login Fail");
                        }
                    } else {
                        System.out.println("Ban Da Dang Nhap");
                    }
                    break;
                case 6:
                    if(hotelClerk != null) {
                        hotelClerkController.showAllRoom();
                    } else {
                        System.out.println("Ban Khong Quyen Vao Chuc Nang Nay");
                    }
                    break;
                case 7:
                    if(hotelClerk != null) {
                        hotelClerkController.searchRoom();
                    } else {
                        System.out.println("Ban Khong Quyen Vao Chuc Nang Nay");
                    }
                    break;
                case 8:
                    if(hotelClerk != null) {
                        hotelClerkController.update();
                    } else {
                        System.out.println("Ban Khong Quyen Vao Chuc Nang Nay");
                    }
                    break;
                case 9:
                	if(admin == null) {
                        admin = adminController.loginAdmin();
                        if(admin != null) {
                            System.out.println("Login Successful");
                        } else {
                            System.out.println("Login Fail");
                        }
                    } else {
                        System.out.println("Ban Da Dang Nhap");
                    }
                	break;
                case 10:
                	 if(admin != null) {
                         adminController.showAllAdmin();
                         adminController.showAllCustomer();
                         adminController.showAllClerk();
                     } else {
                         System.out.println("Ban Khong Quyen Vao Chuc Nang Nay");
                     }
                    break;
                case 11:
                	if(admin != null) {
                	System.out.println("-------------Tạo người dùng mới-----------");
                	System.out.println("");
                	System.out.println("Nhấn 1:Tạo Admin");
                	System.out.println("Nhấn 2:Tạo HotelClerk");
                	System.out.println("Nhấn 3:Tạo Customer");
                	int n = 0;
                	System.out.println("Xin Chon :");
                	n = scanner.nextInt();
                	switch(n) {
                	case 1:
                		System.out.println("1.Nhập Admin");
                		adminController.newAdmin();
                		break;
                	case 2:
                		System.out.println("2.Nhập HotelClerk");
                		adminController.newHotelClerk();
                		break;
                	case 3:
                		System.out.println("3.Nhập Customer");
                		adminController.newCustomer();
                		break;
                		default :
                			System.out.println("Số nhập vào không hợp lệ:");
                			break;
                	}
                	}else {
                        System.out.println("Ban Khong Quyen Vao Chuc Nang Nay");
                	}
                	break;
                case 12:
                	if(admin != null) {
                		System.out.println("-------------Search Nguoi dung-----------");
                    	System.out.println("");
                    	System.out.println("Nhấn 1:Search Admin");
                    	System.out.println("Nhấn 2:Search HotelClerk");
                    	System.out.println("Nhấn 3:Search Customer");
                    	int n = 0;
                    	System.out.println("Xin Chon :");
                    	n = scanner.nextInt();
                    	switch(n) {
                    	case 1:
                    		System.out.println("1.Search Admin");
                    		adminController.searchAdmin();
                    		break;
                    	case 2:
                    		System.out.println("2.Search HotelClerk");
                    		adminController.searchClerk();
                    		break;
                    	case 3:
                    		System.out.println("3.Search Customer");
                    		adminController.searchCustomer();
                    		break;
                    		default :
                    			System.out.println("Số nhập vào không hợp lệ:");
                    			break;
                    }} else {
                        System.out.println("Ban Khong Quyen Vao Chuc Nang Nay");
                    }
                    break;
                case 13:
                	if(admin != null) {
                	System.out.println("-------------Cập nhập thông tin người dùng-----------");
                	System.out.println("");
                	System.out.println("Nhấn 1:Cập nhập Admin");
                	System.out.println("Nhấn 2:Cập nhập HotelClerk");
                	System.out.println("Nhấn 3:Cập nhập Customer");
                	int n1 = 0;
                	System.out.println("Xin Chon :");
                	n1 = scanner.nextInt();
                	switch(n1) {
                	case 1:
                		System.out.println("1.Nhập Admin");
                		adminController.updateAdmin();
                		break;
                	case 2:
                		System.out.println("2.Nhập HotelClerk");
                		adminController.updateHotelClerk();
                		break;
                	case 3:
                		System.out.println("3.Nhập Customer");
                		adminController.updateCustomer();
                		break;
                		default :
                			System.out.println("Số nhập vào không hợp lệ:");
                			break;
                	}
                	}else {
                        System.out.println("Ban Khong Quyen Vao Chuc Nang Nay");
                    }
                	break;
                case 14:
                    exit = false;
                    System.out.println("Exit Application !!");
                    break;

                default:
                    System.out.println("Invalid function !!");
                    exit = false;
                    break;
            }
            System.out.println();
        }
    }

}
