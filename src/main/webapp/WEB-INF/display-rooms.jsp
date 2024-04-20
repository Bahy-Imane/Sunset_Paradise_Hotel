<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rooms List</title>
</head>
<body>
     <h1>Rooms List</h1>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Type</th>
                <th>Price</th>
                <th>Equipment</th>
                <th>Availability</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="room" items="${rooms}">
                <tr>
                    <td>${room.roomId}</td>
                    <td>${room.roomType}</td>
                    <td>${room.roomPrice}</td>
                    <td>${room.roomEquipment}</td>
                    <td>${room.roomAvailability ? 'Oui' : 'Non'}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
