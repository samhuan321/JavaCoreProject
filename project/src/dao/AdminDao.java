package dao;

import ConnectDB.DBConnection;
import model.Admin;
import model.Customer;
import model.HotelClerk;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AdminDao {
    Scanner sc = new Scanner(System.in);
    
    public Admin loginAdmin(int id, String password){
        try {
            if (DBConnection.open()){
                String sqlQuery = "SELECT * FROM AdminHotel Where idAdmin=? AND passAdmin=?";
                PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                	Admin admin = new Admin(resultSet);
                    return admin;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return null;
    }
    public ArrayList<Admin> getAllAdmin() {
        ArrayList<Admin> result = new ArrayList<Admin>();
        try {
            if (DBConnection.open()) {
                Statement statement = DBConnection.getConnection().createStatement();
                String sqlQuery = "SELECT * FROM AdminHotel";
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    Admin admin = new Admin(resultSet);
                    result.add(admin);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return result;
    }

    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> result = new ArrayList<Customer>();
        try {
            if (DBConnection.open()) {
                Statement statement = DBConnection.getConnection().createStatement();
                String sqlQuery = "SELECT * FROM Customer";
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    Customer customer = new Customer(resultSet);
                    result.add(customer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return result;
    }

    public ArrayList<HotelClerk> getAllClerk() {
        ArrayList<HotelClerk> result = new ArrayList<HotelClerk>();
        try {
            if (DBConnection.open()) {
                Statement statement = DBConnection.getConnection().createStatement();
                String sqlQuery = "SELECT * FROM HotelClerk";
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    HotelClerk clerk = new HotelClerk(resultSet);
                    result.add(clerk);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return result;
    }

    public boolean addAdmin(Admin Admin) {
        try {
            if (DBConnection.open()) {
                String sqlQuery = "INSERT INTO AdminHotel " + "(idAdmin,nameAdmin,passAdmin) VALUES " + "(?,?,?)";
                PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
                preparedStatement.setInt(1, Admin.getIdAdmin());
                preparedStatement.setString(2, Admin.getNameAdmin());
                preparedStatement.setString(3, Admin.getPassAdmin());
                preparedStatement.executeUpdate();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Loi nhap !!");
//            e.printStackTrace();
            return false;
        } finally {
            DBConnection.close();
        }
    }

    public boolean addHotelClerk(HotelClerk Ho) {
        try {
            if (DBConnection.open()) {
                String sqlQuery = "INSERT INTO HotelClerk " + "(idClerk,nameClerk,passClerk,phoneClerk) VALUES " + "(?,?,?,?)";
                PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
                preparedStatement.setInt(1, Ho.getIdClerk());
                preparedStatement.setString(2, Ho.getNameClerk());
                preparedStatement.setString(3, Ho.getPassClerk());
                preparedStatement.setInt(4, Ho.getPhoneClerk());
                preparedStatement.executeUpdate();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Loi nhap !!");
            return false;
        } finally {
            DBConnection.close();
        }
    }

    public boolean addCustomer(Customer Cu) {
        try {
            if (DBConnection.open()) {
                String sqlQuery = "INSERT INTO Customer " + "(idCustomer,nameCustomer,passCustomer,addressCustomer,phoneCustomer) VALUES " + "(?,?,?,?,?)";
                PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
                preparedStatement.setInt(1, Cu.getIdCustomer());
                preparedStatement.setString(2, Cu.getNameCustomer());
                preparedStatement.setString(3, Cu.getPassCustomer());
                preparedStatement.setString(4, Cu.getAddressCustomer());
                preparedStatement.setInt(5, Cu.getPhoneCustomer());
                preparedStatement.executeUpdate();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Loi nhap !!");
            return false;
        } finally {
            DBConnection.close();
        }
    }

//    public boolean login() {
//        int id;
//        String pass;
//        ArrayList<Admin> adminList = getAllAdmin();
//        System.out.println("------------------Ä�Äƒng nháº­p vÃ o tÃ i khoáº£n--------------");
//        System.out.print("ID dang nhap : ");
//        id = sc.nextInt();
//        sc.nextLine();
//        System.out.print("Máº­t kháº©u : ");
//        pass = sc.nextLine();
//        if (DBConnection.open()) {
//            for (int i = 0; i < adminList.size(); i++) {
//                    if (adminList.get(i).getIdAdmin() == id && adminList.get(i).getPassAdmin().equals(pass)) {
//                        System.out.println("------------Dang nhap thanh cong !!!--------------");
//                        return true;
//                    }
//                }
//            }
//        System.out.println("-------------Dang nhap that bai !!!--------------");
//        return false;
//    }
    
    public boolean updateAdmin(Admin Admin){
        try {
            if (DBConnection.open()) {
                String sqlQuery = "UPDATE AdminHotel SET nameAdmin= ?,passAdmin = ?  WHERE idAdmin = ?";
                PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
                preparedStatement.setString(1, Admin.getNameAdmin());
                preparedStatement.setString(2, Admin.getPassAdmin());
                preparedStatement.setInt(3, Admin.getIdAdmin());
                preparedStatement.executeUpdate();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBConnection.close();
        }
    }
    
    public boolean updateHotelClerk(HotelClerk Hotel){
        try {
            if (DBConnection.open()) {
                String sqlQuery = "UPDATE HotelClerk SET nameClerk= ?,passClerk = ?,phoneClerk= ?  WHERE idClerk = ?";
                PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
                preparedStatement.setString(1, Hotel.getNameClerk());
                preparedStatement.setString(2, Hotel.getPassClerk());
                preparedStatement.setInt(3, Hotel.getPhoneClerk());
                preparedStatement.setInt(4, Hotel.getIdClerk());
                preparedStatement.executeUpdate();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBConnection.close();
        }
    }
    
    public boolean updateCustomer(Customer Customer){
        try {
            if (DBConnection.open()) {
                String sqlQuery = "UPDATE Customer SET nameCustomer= ?,passCustomer = ?,addressCustomer = ?,phoneCustomer = ?  WHERE idCustomer = ?";
                PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
                preparedStatement.setString(1, Customer.getNameCustomer());
                preparedStatement.setString(2, Customer.getPassCustomer());
                preparedStatement.setString(3, Customer.getAddressCustomer());
                preparedStatement.setInt(4, Customer.getPhoneCustomer());
                preparedStatement.setInt(5, Customer.getIdCustomer());
                preparedStatement.executeUpdate();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBConnection.close();
        }
    }

}

