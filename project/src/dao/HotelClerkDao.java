package dao;

import ConnectDB.DBConnection;
import model.Customer;
import model.HotelClerk;
import model.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HotelClerkDao {
    public HotelClerk loginHotelClerk(int id, String password){
        try {
            if (DBConnection.open()){
                String sqlQuery = "SELECT * FROM HotelClerk Where idClerk=? AND passClerk=?";
                PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    HotelClerk hotelClerk = new HotelClerk(resultSet);
                    return hotelClerk;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return null;
    }
    public ArrayList<Room> getAllRoom() {
        ArrayList<Room> result = new ArrayList<Room>();
        try {
            if (DBConnection.open()) {
                Statement statement = DBConnection.getConnection().createStatement();
                String sqlQuery = "SELECT * FROM Room";
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    Room room = new Room(resultSet);
                    result.add(room);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return result;
    }
    public boolean update(Room room){
        try {
            if (DBConnection.open()) {
                String sqlQuery = "UPDATE Room SET tinhTrang = ? WHERE idRoom = ?";
                PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
                preparedStatement.setString(1, room.getTinhTrang());
                preparedStatement.setInt(2, room.getIdRoom());
                preparedStatement .executeUpdate();
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
