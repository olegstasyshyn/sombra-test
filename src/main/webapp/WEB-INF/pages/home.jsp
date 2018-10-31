<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Home page</title>
</head>
<body>
<h1>Home page</h1>
<p>
${message}<br/>
    <a href="${pageContext.request.contextPath}/author/add.html">Add new author</a><br/>
    <a href="${pageContext.request.contextPath}/book/add-book.html">Add new book</a><br/>
    <a href="${pageContext.request.contextPath}/author-book/add-author-book.html">Add new author-book</a><br/>
    <a href="${pageContext.request.contextPath}/author/list.html">Author list</a><br/>
    <a href="${pageContext.request.contextPath}/book/list.html">Book list</a><br/>
    <a href="${pageContext.request.contextPath}/author-book/list.html">Author-book list</a><br/>
</p>
</body>
</html>