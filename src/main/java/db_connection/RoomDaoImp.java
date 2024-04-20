package db_connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAOmodeles.octest.RoomDAO;
import modeles.octest.Room;


	public class RoomDaoImp implements RoomDAO {

		@Override
		public List<Room> showRoom() {
		    List<Room> rooms = new ArrayList<>();
		    String sql = "SELECT * FROM rooms";

		    try (Connection connection = DBConnection.getConnection();
		         PreparedStatement statement = connection.prepareStatement(sql);
		         ResultSet resultSet = statement.executeQuery()) {

		        while (resultSet.next()) {
		            int roomId = resultSet.getInt("room_id");
		            String roomType = resultSet.getString("room_type");
		            double roomPrice = resultSet.getDouble("room_price");
		            String equipment = resultSet.getString("room_equipment");
		            boolean availability = resultSet.getBoolean("room_availability");

		            Room room = new Room(roomId, roomType, roomPrice, equipment, availability);
		            rooms.add(room);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return rooms;
		}


		@Override
		public List<Room> searchRoom(String searchTerm) {
		    List<Room> rooms = new ArrayList<>();
		    String sql = "SELECT * FROM rooms WHERE room_type LIKE ?";
		    try {
		        Connection connection = DBConnection.getConnection();
		        PreparedStatement statement = connection.prepareStatement(sql);
		        statement.setString(1, "%" + searchTerm + "%");
		        ResultSet resultSet = statement.executeQuery();
		        while (resultSet.next()) {
		            Room room = new Room(
		                    resultSet.getInt("room_id"),
		                    resultSet.getString("room_type"),
		                    resultSet.getDouble("room_price"),
		                    resultSet.getString("room_equipment"),
		                    resultSet.getBoolean("room_availability")
		            );
		            rooms.add(room);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return rooms;
		}



	}

}
