<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Add author-book page</title>
</head>
<body>
<h1>Add author-book page</h1>
<p>Here you can add a new author-book.</p>
<form:form method="POST" commandName="authorBook" action="${pageContext.request.contextPath}/author/add-author-book.html">
    <table>
        <tbody>
        <tr>
            <td>Book-id:</td>
            <td><form:input path="bookId" /></td>
        </tr>
        <tr>
            <td>Author-id:</td>
            <td><form:input path="authorId" /></td>
        </tr>
        <tr>
            <td>Born(mm-dd-yyyy):</td>
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
