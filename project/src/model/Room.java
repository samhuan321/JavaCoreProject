package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Room {
    private int idRoom;
    private String tinhTrang;

    public Room(ResultSet resultSet){
        try {
            idRoom = resultSet.getInt("idRoom");
            tinhTrang = resultSet.getString("tinhTrang");
        } catch (SQLException e) {
            System.out.println("Room - ResultSet Error: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "idRoom=" + idRoom +
                ", tinhTrang='" + tinhTrang + '\'' +
                '}';
    }

    public Room(int idRoom, String tinhTrang) {
        this.idRoom = idRoom;
        this.tinhTrang = tinhTrang;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}

