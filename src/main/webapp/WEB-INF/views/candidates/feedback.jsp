<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Candidate Interview</title>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    </head>
    <body>
        <h2>Feedback for Candidate: ${candidate.firstName} ${candidate.lastName}</h2>
        <br/><br/>
        <a href="/spring4/hiring">View Candidate List</a>
        <br/><br/>
        <form:form method = "POST" modelAttribute = "candidate-feedback-model" action="/spring4/hiring/addFeedback">
            <form:input path="key" type="hidden" value="${candidate.id}"/>
            <table>
                <tr>
                   <td><form:label path="feedback">Feedback</form:label></td>
                   <td><form:textarea path="feedback" rows="10" cols="70" /></td>
                   <td align="left"><form:errors path="feedback" cssClass="error"/></td>
                </tr>
                <tr>
                   <td colspan = "2">
                      <input type = "submit" value = "Submit"/>
                   </td>
                </tr>
            </table>
        </form:form>
        <br/><br/>
        <c:if test="${not empty candidate.feedBackList}">
            <table>
                <thead>
                    <th>Date</th>
                    <th>Feed Back</th>
                </thead>
                <tbody>
                    <c:forEach items="${candidate.feedBackList}" var="feedBack">
                        <tr>
                            <td>${feedBack.feedBackDate}</td>
                            <td>${feedBack.feedback}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>