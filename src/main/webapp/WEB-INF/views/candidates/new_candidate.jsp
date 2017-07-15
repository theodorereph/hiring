<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <title>Spring MVC Form Handling</title>
      <style>
          .error {
              color: red; font-weight: bold;
          }
      </style>
   </head>

   <body>
      <h2>Candidate Information</h2>
      <form:form method = "POST" modelAttribute = "candidate-model" action="/spring4/hiring/addCandidate">
         <table>
            <tr>
               <td><form:label path="firstName">First Name</form:label></td>
               <td><form:input path="firstName" size="30"/></td>
               <td align="left"><form:errors path="firstName" cssClass="error"/></td>
            </tr>
            <tr>
               <td><form:label path="lastName">Last Name</form:label></td>
               <td><form:input path="lastName" size="30"/></td>
               <td align="left"><form:errors path="lastName" cssClass="error"/></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>
      </form:form>
   </body>
</html>