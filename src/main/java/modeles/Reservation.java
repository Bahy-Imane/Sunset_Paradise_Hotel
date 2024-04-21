package modeles;

import java.util.Date;

public class Reservation {
    private int reservation_id;
    private int room_id;
    private Date start_date;
    private Date end_date;
	
	
	public Reservation(int reservation_id, int room_id, Date start_date, Date end_date) {
		super();
		this.reservation_id = reservation_id;
		this.room_id = room_id;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	public int getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
    
    
    
}
