<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Candidate Hiring</title>
        <h1>Candidate List</h1>
    </head>
    <body>
        <form action="<c:url value="/hiring/add" />" method="GET">
            <input type="submit" name="action" value="Add New Candidate" />
        </form>

        <c:if test="${not empty candidates}">
            <table>
                <thead>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Delete</th>
                    <th>Interview</th>
                </thead>
                <tbody>
                    <c:forEach items="${candidates}" var="candidate">
                        <tr>
                            <td>${candidate.id}</td>
                            <td>${candidate.firstName}</td>
                            <td>${candidate.lastName}</td>
                            <td><a href="/spring4/hiring/delete?selectedItem=${candidate.getId()}">Delete</a></td>
                            <td><a href="/spring4/hiring/interview?selectedItem=${candidate.getId()}">Interview</a></td>
                            <td><a href="/spring4/hiring/feedback?selectedItem=${candidate.getId()}">FeedBack</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>