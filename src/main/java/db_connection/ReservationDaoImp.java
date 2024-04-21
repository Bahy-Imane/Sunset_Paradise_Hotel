package db_connection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAOmodeles.octest.ReservationDAO;
import modeles.octest.Reservation;



public  class ReservationDaoImp implements ReservationDAO {
	
	
	    @Override
	    public List<Reservation> getReservations() {
	     List<Reservation> reservations = new ArrayList<>();
	     String sql = "SELECT * FROM reservations";
	     try (Connection connection = DBConnection.getConnection();
		         PreparedStatement statement = connection.prepareStatement(sql);
		         ResultSet resultSet = statement.executeQuery()) {
	    	 while (resultSet.next()) {
	    		    int reservation_id = resultSet.getInt("reservation_id");
	    		    
	    		    int room_id = resultSet.getInt("room_id");
	    		    Date start_date =  resultSet.getDate("start_date");
	    		    Date end_date =  resultSet.getDate("end_date");
	    		    Reservation reservation = new Reservation(reservation_id,end_date,start_date,room_id);
		           reservations.add(reservation);
	    	       }
	     } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return reservations;
	     }

		@Override
		public void createReservation(Reservation reservation) {
			 String sql = "INSERT INTO Reservations ( room_id, start_date, end_date) VALUES (?, ?, ?)";
		        try (Connection connection = DBConnection.getConnection();
		             PreparedStatement statement = connection.prepareStatement(sql)) {
		            
		            statement.setInt(1, reservation.getRoom_id());
		            statement.setDate(2, new java.sql.Date(reservation.getStart_date().getTime()));
		            statement.setDate(3, new java.sql.Date(reservation.getEnd_date().getTime()));
		            statement.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			
		}

		public void cancelReservation(int reservationId) {
	        String sql = "DELETE FROM Reservations WHERE reservation_id = ?";
	        try (Connection connection = DBConnection.getConnection();
	                PreparedStatement statement = connection.prepareStatement(sql)) {
	               
	            statement.setInt(1, reservationId);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	    
	}

