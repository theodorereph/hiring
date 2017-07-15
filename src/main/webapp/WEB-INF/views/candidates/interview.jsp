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

        <script>
            $(function() {
                $("#startDatePicker").datepicker();
            });
            $(function() {
                $("#endDatePicker").datepicker();
            });
        </script>
    </head>
    <body>
        <h2>Interviews for Candidate: ${candidate.firstName} ${candidate.lastName}</h2>
        <br/><br/>
        <a href="/spring4/hiring">View Candidate List</a>
        <br/><br/>
        <form:form method = "POST" modelAttribute = "candidate-interview-model" action="/spring4/hiring/addInterview">
            <form:input path="key" type="hidden" value="${candidate.id}"/>
            <table>
                <tr>
                   <td><form:label path="interviewerFirstName">First Name</form:label></td>
                   <td><form:input path="interviewerFirstName" size="30"/></td>
                   <td align="left"><form:errors path="interviewerFirstName" cssClass="error"/></td>
                </tr>
                <tr>
                   <td><form:label path="interviewerLastName">Last Name</form:label></td>
                   <td><form:input path="interviewerLastName" size="30"/></td>
                   <td align="left"><form:errors path="interviewerLastName" cssClass="error"/></td>
                </tr>
                <tr>
                   <td><form:label path="startDate">Start Date</form:label></td>
                   <td><form:input path="startDate" type="text" id="startDatePicker"/></td>
                   <td align="left"><form:errors path="startDate" cssClass="error"/></td>
                </tr>
                <tr>
                   <td><form:label path="endDate">End Date</form:label></td>
                   <td><form:input path="endDate" type="text" id="endDatePicker"/></td>
                   <td align="left"><form:errors path="endDate" cssClass="error"/></td>
                </tr>
                <tr>
                   <td colspan = "2">
                      <input type = "submit" value = "Submit"/>
                   </td>
                </tr>
            </table>
        </form:form>
        <br/><br/>
        <c:if test="${not empty candidate.interviewList}">
            <table>
                <thead>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                </thead>
                <tbody>
                    <c:forEach items="${candidate.interviewList}" var="interview">
                        <tr>
                            <td>${interview.interviewerFirstName}</td>
                            <td>${interview.interviewerLastName}</td>
                            <td>${interview.startDate}</td>
                            <td>${interview.endDate}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>