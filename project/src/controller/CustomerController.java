package controller;

import dao.CustomerDao;
import model.Admin;
import model.Customer;
import model.Room;
import view.CustomerView;

import java.util.ArrayList;

public class CustomerController {
    private CustomerDao customerDao;
    private CustomerView customerView;

    public CustomerController() {
        customerDao = new CustomerDao();
        customerView = new CustomerView();

    }
//    public boolean login() {
//        return customerDao.login();
//    }
//    public void register() {
//        Customer cu = customerView.newCustomer();
//        if (cu != null) {
//            customerDao.register(cu);
//        }
//    }
//    public void showAll() {
//        ArrayList<Room> room = customerDao.getAllRoomTrong();
//        if (room != null && !room.isEmpty()) {
//            customerView.showAllRoom(room);
//        }
//    }
public void newCustomer() {
    Customer customer = customerView.newCustomer();
    if (customer != null) {
        customerDao.addCustomer(customer);
    }
}
    public Customer loginCustomer() {
        Customer customer = customerView.loginCustomer();
        if (customer != null) {
            return customerDao.loginCustomer(customer.getIdCustomer(), customer.getPassCustomer());
        }
        return null;
    }

    public boolean bookingRoom(int idCustomer){
        int idRoom = customerView.bookingRoom();
        return customerDao.bookingRoom(idCustomer, idRoom);
    }

}
