<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ticket booking result</title>
</head>
<body style="background-color: rgb(200, 240, 300)">
	<br>
	<br>
	
	<!--Add code here  -->
	
	<h3 id="ticket">Congratulations, your ticket got booked!!</h3>
	
	<table border="1">
	<tr style="background-color: yellow">
	<td>PNR Number:</td>
	<td>${pnr}</td>
	</tr>
	<tr>
	<td>Train Number:</td>
	<td>${tno}</td>
	</tr>
	<tr>
	<td>Train Name:</td>
	<td>${tname}</td>
	</tr>
	<tr>
	<td>Date of Travel:</td>
	<td>${dot}</td>
	</tr>
	<tr>
	<td>Departure:</td>
	<td>${dept}</td>
	</tr>
	<tr>
	<td>Duration</td>
	<td>${duration}</td>
	</tr>
	<tr>
	<td>Arrival:</td>
	<td>${a}</td>
	</tr>
	<tr>
	<td>Total Fare Amount:</td>
	<td>${price}</td>
	</tr>
	
	
	
	</table>
	<br>
	<a href="showTicketBookingForm" id="bookTicket">Book Another Ticket</a>
	
</body>
</html>