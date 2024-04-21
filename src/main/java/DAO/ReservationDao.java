package DAO;
import java.util.List;
import modeles.Reservation;




public interface ReservationDao {
	
    List<Reservation> getReservations();
    void createReservation(Reservation reservation);
	void cancelReservation(int reservationId);
    
}
