<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="addEmployee">Add Employee</a>

<form action="addEmployee" method="post">
 Id : <input type="text" name="id"/>
 Employee Name : <input type="text" name="employeeName"/>
 Salary : <input type="text" name="salary"/>
 <input type="submit" value="Add Employee"/>
 
 </form>
 
 

</body>
</html>