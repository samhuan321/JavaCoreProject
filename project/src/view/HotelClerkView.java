package view;

import model.HotelClerk;
import model.Room;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelClerkView {
    Scanner scanner = new Scanner(System.in);
    public HotelClerk loginHotelClerk(){
        System.out.println("-----------Login Customer-----------");
        System.out.print("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Pass: ");
        String pass  = scanner.nextLine();
        HotelClerk clerk = new HotelClerk(id,pass);
        return clerk;
    }
    public static void showAllRoom(ArrayList<Room> list){
        System.out.println("-----------SHOW ALL-----------");
        for(Room room : list){
            System.out.println(room);
        }
    }
    public Room findRoombyID(int id, ArrayList<Room> list){
        for (Room room : list) {
            if (room.getIdRoom() == id) {
                return room;
            }
        }
        return null;
    }
    public Room updateRoom(){
        System.out.println("-----------UPDATE ROOM-----------");
        System.out.print("ID room: ");
        int idRoom = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tinh Trang: ");
        String tinhTrang = scanner.nextLine();
        Room room = new Room(idRoom, tinhTrang);
        return room;
    }
}
