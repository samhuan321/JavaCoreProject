package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelClerk {
    private int idClerk;
    private String passClerk;
    private String nameClerk;
    private int phoneClerk;

    public HotelClerk(ResultSet resultSet){
        try {
            idClerk = resultSet.getInt("idClerk");
            passClerk = resultSet.getString("passClerk");
            nameClerk = resultSet.getString("nameClerk");
            phoneClerk = resultSet.getInt("phoneClerk");
        } catch (SQLException e) {
            System.out.println("Hotel Clerk - ResultSet Error: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "HotelClerk{" +
                "idClerk=" + idClerk +
                ", passClerk='" + passClerk + '\'' +
                ", nameClerk='" + nameClerk + '\'' +
                ", phoneClerk=" + phoneClerk +
                '}';
    }

    public HotelClerk(int idClerk, String passClerk, String nameClerk, int phoneClerk) {
        this.idClerk = idClerk;
        this.passClerk = passClerk;
        this.nameClerk = nameClerk;
        this.phoneClerk = phoneClerk;
    }

    public HotelClerk(int idClerk,String passClerk) {
        this.idClerk= idClerk;
        this.passClerk = passClerk;
    }

    public int getIdClerk() {
        return idClerk;
    }

    public void setIdClerk(int idClerk) {
        this.idClerk = idClerk;
    }

    public String getPassClerk() {
        return passClerk;
    }

    public void setPassClerk(String passClerk) {
        this.passClerk = passClerk;
    }

    public String getNameClerk() {
        return nameClerk;
    }

    public void setNameClerk(String nameClerk) {
        this.nameClerk = nameClerk;
    }

    public int getPhoneClerk() {
        return phoneClerk;
    }

    public void setPhoneClerk(int phoneClerk) {
        this.phoneClerk = phoneClerk;
    }
}

