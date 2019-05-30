package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ConnectDB.DBConnection;
import model.Customer;

public class CustomerDao {
    public boolean addCustomer(Customer Cu) {
        try {
            if (DBConnection.open()) {
                String sqlQuery = "INSERT INTO Customer " + "(idCustomer,nameCustomer,passCustomer,addressCustomer,phoneCustomer) VALUES " + "(?,?,?,?,?)";
                PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
                preparedStatement.setInt(1,Cu.getIdCustomer());
                preparedStatement.setString(2,Cu.getNameCustomer());
                preparedStatement.setString(3,Cu.getPassCustomer());
                preparedStatement.setString(4,Cu.getAddressCustomer());
                preparedStatement.setInt(5,Cu.getPhoneCustomer());
                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return false;
    }

    public Customer loginCustomer(int id, String password){
        try {
            if (DBConnection.open()){
                String sqlQuery = "SELECT * FROM Customer Where idCustomer=? AND passCustomer=?";
                PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Customer customer = new Customer(resultSet);
                    return customer;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return null;
    }

    public boolean bookingRoom(int idCustomer, int idRoom) {
        try {
            if (DBConnection.open()) {
                String sqlQuery = "INSERT INTO BookingRoom " + "(idCustomer,idRoom,dateBooking) VALUES " + "(?,?,?)";
                PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
                preparedStatement.setInt(1,idCustomer);
                preparedStatement.setInt(2,idRoom);
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
                String strDate= formatter.format(date);
                preparedStatement.setString(3, strDate);
                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return false;
    }
}
