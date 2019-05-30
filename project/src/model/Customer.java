package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
    private int idCustomer;
    private String nameCustomer;
    private String passCustomer;
    private String addressCustomer;
    private int phoneCustomer;

    public Customer(ResultSet resultSet){
        try {
            idCustomer = resultSet.getInt("idCustomer");
            nameCustomer = resultSet.getString("nameCustomer");
            passCustomer = resultSet.getString("passCustomer");
            addressCustomer = resultSet.getString("addressCustomer");
            phoneCustomer = resultSet.getInt("phoneCustomer");
        } catch (SQLException e) {
            System.out.println("Customer - ResultSet Error: " + e.getMessage());
        }
    }



    @Override
    public String toString() {
        return "Customer [idCustomer=" + idCustomer + ", nameCustomer=" + nameCustomer + ", passCustomer="
                + passCustomer + ", addressCustomer=" + addressCustomer + ", phoneCustomer=" + phoneCustomer + "]";
    }



    public Customer(int idCustomer, String nameCustomer, String passCustomer, String addressCustomer, int phoneCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.passCustomer = passCustomer;
        this.addressCustomer = addressCustomer;
        this.phoneCustomer = phoneCustomer;
    }

    public Customer(int idCustomer,String passCustomer) {
        this.idCustomer= idCustomer;
        this.passCustomer = passCustomer;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getPassCustomer() {
        return passCustomer;
    }

    public void setPassCustomer(String passCustomer) {
        this.passCustomer = passCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public int getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(int phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }
}
