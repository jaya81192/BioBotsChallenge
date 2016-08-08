<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<title>User Print Data Statistics</title>
</head>
<body>
	<form method = "get" class="form" action="UserStat">
		<div>
			<h2> The number of prints by user is ${stat.printCounts}</h2>
			<h3> Statistics on the data printed </h3>
			<table>
				<tr>
					<th></th>
					<th>Minimum</th>
					<th>Maximum</th>
					<th>Average</th>
				</tr>
        		<tr>
        			<td><b>Dead data percent</b></td>
        			<td>${stat.minValues.dataDeadPercent}</td>
        			<td>${stat.maxValues.dataDeadPercent}</td>
        			<td>${Math.round(stat.avgValues.dataDeadPercent*100)/100}</td>
        		</tr>
        		<tr>
        			<td><b>Data live percent</b></td>
        			<td>${stat.minValues.dataLivePercent}</td>
        			<td>${stat.maxValues.dataLivePercent}</td>
        			<td>${Math.round(stat.avgValues.dataLivePercent*100)/100}</td>        		
        		</tr>
        		<tr>
        			<td><b>Data elasticity</b></td>
        			<td>${stat.minValues.dataElasticity}</td>
        			<td>${stat.maxValues.dataElasticity}</td>
        			<td>${Math.round(stat.avgValues.dataElasticity*100)/100}</td>        		
        		</tr>
        	</table>
		</div>
		<div>
			<h3>Cross linking information of the prints</h3>
			<p>Print by User with cross link enabled is ${stat.countOfCrossLinkEnabled}</p>
        	<p>Print by User with cross link disabled is ${stat.printCounts - stat.countOfCrossLinkEnabled}</p>
        	<table>
        		<tr>
					<th></th>
					<th>Minimum</th>
					<th>Maximum</th>
					<th>Average</th>
        		</tr>	
        		<tr>
        			<td><b>Cross Link Duration</b></td>
        			<td>${stat.minValues.crosslinkDuration}</td>
        			<td>${stat.maxValues.crosslinkDuration}</td>
        			<td>${Math.round(stat.avgValues.crosslinkDuration*100)/100}</td>
        		</tr>
        		<tr>
        			<td><b>Cross Link Intensity</b></td>
        			<td>${stat.minValues.crosslinkIntensity}</td>
        			<td>${stat.maxValues.crosslinkIntensity}</td>
        			<td>${Math.round(stat.avgValues.crosslinkIntensity*100)/100}</td>
        		</tr>
			</table>	
		</div>
		
        <div>
        	<h3>Other information about the prints</h3>
			<table>
				<tr>
					<th></th>
					<th>Minimum</th>
					<th>Maximum</th>
					<th>Average</th>
				</tr>
        		<tr>
        			<td><b>Pressure of Extruder 1</b></td>
        			<td>${stat.minValues.pressureExtruder1}</td>
        			<td>${stat.maxValues.pressureExtruder1}</td>
        			<td>${Math.round(stat.avgValues.pressureExtruder1*100)/100}</td>
        		</tr>
        		
        		
        		<tr>
        			<td><b>Pressure of Extruder 2</b></td>
        			<td>${stat.minValues.pressureExtruder2}</td>
        			<td>${stat.maxValues.pressureExtruder2}</td>
        			<td>${Math.round(stat.avgValues.pressureExtruder2*100)/100}</td>
        		</tr>
        		
        		
        		<tr>
        			<td><b>Layer Height</b></td>
        			<td>${stat.minValues.layerHeight}</td>
        			<td>${stat.maxValues.layerHeight}</td>
        			<td>${Math.round(stat.avgValues.layerHeight*100)/100}</td>
        		</tr>
        		
        		<tr>
        			<td><b>Number of Layers</b></td>
        			<td>${stat.minValues.layerNum}</td>
        			<td>${stat.maxValues.layerNum}</td>
        			<td>${Math.round(stat.avgValues.layerNum*100)/100}</td>
        		</tr>
		</table>        
        </div>		
	</form>
	<form method = "post" class="form" action="UserStat">
		<div style="text-align:center;">
			<input type="submit" class="button1" name = "first" value="Go back to Home Page">
		</div>
	</form>
</body>
</html>