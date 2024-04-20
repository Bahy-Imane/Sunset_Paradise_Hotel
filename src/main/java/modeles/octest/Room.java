package modeles.octest;



public class Room {
	private int roomId;
	private String roomType;
	private double roomPrice;
	private String equipment;
	private boolean availability;
	
	
	public Room(int roomId, String roomType, double roomPrice, String equipment, boolean availability) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.equipment = equipment;
		this.availability = availability;
	}
	
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	

}
