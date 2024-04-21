package Db_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.RoomDao;
import modeles.Room;


public class RoomDaoImp implements RoomDao {

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
	            double roomprice = resultSet.getDouble("room_price");
	            String equipment = resultSet.getString("room_equipment");
	            boolean availability = resultSet.getBoolean("room_availability");

	            Room room = new Room(roomId,roomType,roomprice,equipment,availability);
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

	        // Execute the query
	        ResultSet resultSet = statement.executeQuery();

	        // Process the result set and populate the list of searched rooms
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
