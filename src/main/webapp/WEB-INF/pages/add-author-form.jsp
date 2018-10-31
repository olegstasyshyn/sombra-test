<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Add author page</title>
</head>
<body>
<h1>Add author page</h1>
<p>Here you can add a new author.</p>
<form:form method="POST" th:commandName="author" th:action="/author/add">
    <table>
        <tbody>
        <tr>
            <td>Name:</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td><form:input path="gender" /></td>
        </tr>
        <tr>
            <td>Born(yyyy-mm-dd):</td>
            <td><form:input path="born" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add" /></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>