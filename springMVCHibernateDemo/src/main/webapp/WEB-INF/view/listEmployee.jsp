<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> ${requestScope.Title } </title>
</head>
<body>
<div>
			<table>
				<thead>
					<tr>
						<th width="30%">Id</th>
						<th width="30%">Employee Name</th>
						<th width="30%">Salary</th>
						<th width="10%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${employee}" var="e">
						<tr>
							<td>${e.id}</td>
							<td>${e.employeeName}</td>
							<td>${e.salary}</td>
							<td><a type="button"  href="deleteEmployee?id=${e.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
</div>
</body>
</html>