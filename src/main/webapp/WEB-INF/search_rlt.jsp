<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Room</title>
</head>
<body>
    <h2>Search Room</h2>
    <form action="SearchServlet" method="GET">
        <label for="roomType">Room Type:</label>
        <input type="text" id="roomType" name="roomType" required>
        <button type="submit">Search</button>
    </form>
     <h2>Search Results</h2>
    <c:if test="${not empty rooms}">
        <table border="1">
            <tr>
                <th>Room ID</th>
                <th>Room Type</th>
                <th>Price</th>
                <th>Equipments</th>
                <th>Availability</th>
            </tr>
            <c:forEach var="room" items="${rooms}">
                <tr>
                    <td>${room.roomId}</td>
                    <td>${room.roomType}</td>
                    <td>${room.roomPrice}</td>
                    <td>${room.equipment}</td>
                    <td>${room.availability}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
