<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
	
<title>User Print Data</title>
</head>
<body>
	<form method = "get" class="form" action="DataRead">
		<table>
			<tr>
				<td>Enter a filter on any of the columns</td>
				<td><input type="text" name="filter"></td>
			</tr>
		</table>
		<table>
			<tr>
				<th>Input File Name</th>
		        <th>Output File Name</th>
				<th>Data Dead Percent</th>
            	<th>Data Elasticity</th>
            	<th>Data Live Percent</th>
            	<th>Cross link Duration</th>
		        <th>Cross link Enabled</th>
		        <th>Cross link Intensity</th>
		        <th>Pressure of Extruder1</th>
		        <th>Pressure of Extruder2</th>
				<th>Layer Height</th>
				<th>Number of Layers</th>
				<th>Wellplate</th>
			</tr>
			<c:forEach var="element" items="${data}">
				<c:if test = "${fn:contains(element.inputFileName, param.filter) || fn:contains(element.outputFileName, param.filter) || fn:contains(element.crosslinkEnabled, param.filter)}">
				<tr>
		            	<td>${element.inputFileName}</td>
		            	<td>${element.outputFileName}</td>
	            		<td>${element.dataDeadPercent}</td>
	            		<td>${element.dataElasticity}</td>
	            		<td>${element.dataLivePercent}</td>
	            		<td>${element.crosslinkDuration}</td>
			            <td>${element.crosslinkEnabled}</td>
			            <td>${element.crosslinkIntensity}</td>
			            <td>${element.pressureExtruder1}</td>
			            <td>${element.pressureExtruder2}</td>
			            <td>${element.layerHeight}</td>
			            <td>${element.layerNum}</td>
			            <td>${element.wellplate}</td>
        		</tr> 
        		</c:if>
    		</c:forEach>
		</table>
	</form>
	<form method = "post" class="form-signin" action="DataRead">
		<input type="submit" class="button1" name = "first" value="Go back to Home Page">
	</form>
</body>
</html>