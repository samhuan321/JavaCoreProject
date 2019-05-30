package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;

public class Admin implements Comparable<Admin>{
    private int idAdmin;
    private String nameAdmin;
    private String passAdmin;


    public Admin(){

    }

    public Admin(ResultSet resultSet){
        try {
            idAdmin = resultSet.getInt("idAdmin");
            nameAdmin = resultSet.getString("nameAdmin");
            passAdmin = resultSet.getString("passAdmin");

        } catch (SQLException e) {
            System.out.println("Admin - ResultSet Error: " + e.getMessage());
        }
    }

    public Admin( int idAdmin,String passAdmin) {
        this.idAdmin = idAdmin;
        this.passAdmin = passAdmin;

    }

    public Admin(int idAdmin, String nameAdmin, String passAdmin) {
        this.idAdmin = idAdmin;
        this.nameAdmin = nameAdmin;
        this.passAdmin = passAdmin;

    }

    @Override
    public String toString() {
        return "Admin [idAdmin=" + idAdmin + ", nameAdmin=" + nameAdmin + ", passAdmin=" + passAdmin + "]";
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNameAdmin() {
        return nameAdmin;
    }

    public void setNameAdmin(String nameAdmin) {
        this.nameAdmin = nameAdmin;
    }

    public String getPassAdmin() {
        return passAdmin;
    }

    public void setPassAdmin(String passAdmin) {
        this.passAdmin = passAdmin;
    }

    @Override
    public int compareTo(Admin o) {
        return 0;
    }
}
