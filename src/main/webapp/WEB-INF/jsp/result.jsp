<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Result</title>
</head>
<body>
    <h1> Parser type: ${parserType} </h1>

    <c:forEach items="${vouchers}" var="voucher">
        ${voucher}<br>
    </c:forEach>

</body>
</html>
