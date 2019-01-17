<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
    <head>To Do List Application</head>
    <body>
        <table>
            <tr><td>Items </td></tr>
            <c:forEach items="${toDoItems}" var="item">
                <tr><td>${item.name}</td></tr>
            </c:forEach>
        </table>                
    </body>
</html>