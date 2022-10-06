<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Expenses</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Vendor</th>
        <th scope="col">Amount</th>
        <th scope="col">Options</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="expense" items="${expenses}">
    <tr>
        <th scope="row"><a href="/expenses/${expense.id}"><c:out value="${expense.name}" /></a></th>
        <th scope="row"><c:out value="${expense.vendor}" /></th>
        <th scope="row">$<c:out value="${expense.amount}" /></th>
        <td><a href="/expenses/${expense.id}/edit">Edit</a></td>
        <td>
            <form action="/expenses/${expense.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" value="Delete">
            </form>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<h1>New Expense</h1>
<form:form action="/expenses" method="post" modelAttribute="expense">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:textarea path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>
        <form:input path="amount"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>