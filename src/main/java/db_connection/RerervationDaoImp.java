package Db_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import DAO.ReservationDao;
import modeles.Reservation;

public class RerervationDaoImp implements ReservationDao {

    @Override
    public List<Reservation> getReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservation";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int reservation_id = resultSet.getInt("reserv_id");    
                int room_id = resultSet.getInt("room_id");
                Date start_date =  resultSet.getDate("start_date");
                Date end_date =  resultSet.getDate("end_date");
                Reservation reservation = new Reservation(reservation_id, room_id, start_date, end_date);
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    @Override
    public void createReservation(Reservation reservation) {
        String sql = "INSERT INTO reservation (room_id, start_date, end_date) VALUES (?, ?, ?)";
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

    @Override
    public void cancelReservation(int reservationId) {
        String sql = "DELETE FROM reservation WHERE reservation_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reservationId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
