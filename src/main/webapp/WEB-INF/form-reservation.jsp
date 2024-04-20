<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
    <title>Hotel Reservation System</title>
   
</head>

<body>
    <!-- Form for searching rooms -->
    <!-- Form for making reservation -->
    
    <h1>Reservation</h1>
    
    <form action="reserve" method="post">
        <label for="userId">User id :</label>
        <input type="text" id="userId" name="userId" required><br><br>
        
        <label for="rsvId">Reservation id :</label>
        <input type="text" id="rsvId" name="rsvId" required><br><br>
        
        <label for="reservedRoomId">Reserved room id:</label>
        <input type="text" id="reservedRoomId" name="reservedRoomId" required><br><br>
        
        <label for="checkInDate">check In Date:</label>
        <input type="date" id="checkInDate" name="checkInDate" required><br><br>
        
        <label for="checkOutDate">check Out Date:</label>
        <input type="date" id="checkOutDate" name="checkOutDate" required><br><br>
        
        <label for="numGuests">Number of persons:</label>
        <input type="number" id="numGuests" name="numGuests" required><br><br>
        
        <label for="roomType">Room's type:</label>
        <select id="roomType" name="roomType">
            <option value="standard">Standard</option>
            <option value="suite">Suite</option>
            <option value="family">Family</option>
            <option value="with view">With View</option>
        </select><br><br>
        
        <input type="submit" value="Réserver">
    </form>
    <!-- Display user reservations -->
</body>
</html>

</body>
</html>