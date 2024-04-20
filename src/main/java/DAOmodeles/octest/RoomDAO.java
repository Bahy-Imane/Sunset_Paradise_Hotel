package DAOmodeles.octest;
import java.util.List;
import modeles.octest.Room;




public interface RoomDAO {
	
	 List<Room> showRoom();
	List<Room> searchRoom(String searchTerm);
}