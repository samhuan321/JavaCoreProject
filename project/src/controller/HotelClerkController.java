package controller;

import dao.HotelClerkDao;
import model.Admin;
import model.Customer;
import model.HotelClerk;
import model.Room;
import view.HotelClerkView;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelClerkController {
    private HotelClerkDao hotelClerkDao;
    private HotelClerkView hotelClerkView;

    public HotelClerkController() {
        hotelClerkDao = new HotelClerkDao();
        hotelClerkView = new HotelClerkView();
    }
    public HotelClerk loginHotelClerk() {
        HotelClerk clerk = hotelClerkView.loginHotelClerk();
        if (clerk != null) {
            return hotelClerkDao.loginHotelClerk(clerk.getIdClerk(), clerk.getPassClerk());
        }
        return null;
    }
    public void showAllRoom() {
        ArrayList<Room> roomList = hotelClerkDao.getAllRoom();
        if (roomList != null && !roomList.isEmpty()) {
            hotelClerkView.showAllRoom(roomList);
        }
    }
    public void searchRoom(){
        ArrayList<Room> roomList = hotelClerkDao.getAllRoom();
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------SEARCH------------------");
        int idSearchRoom;
        System.out.print("Nhap id room muon search : ");
        idSearchRoom = sc.nextInt();
        sc.nextLine();
        Room ad = hotelClerkView.findRoombyID(idSearchRoom,roomList);
        System.out.println(ad);
    }
    public void update(){
        Room room = hotelClerkView.updateRoom();
        if (room != null) {
            hotelClerkDao.update(room);
        }
    }
}
