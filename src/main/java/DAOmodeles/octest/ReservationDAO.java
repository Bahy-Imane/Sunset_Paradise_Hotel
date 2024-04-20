package DAOmodeles.octest;
import java.util.List;
import modeles.octest.Reservation;



public interface ReservationDAO {
	
    List<Reservation> getReservations();
    void createReservation(Reservation reservation);
	void cancelReservation(int reservationId);
    
}
