package DAO;
import java.util.List;
import modeles.Room;



public interface RoomDao {
	
	 List<Room> showRoom();
	List<Room> searchRoom(String searchTerm);
}