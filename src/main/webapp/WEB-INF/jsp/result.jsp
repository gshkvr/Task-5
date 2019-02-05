<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Result</title>
</head>
<body>
    <%--@elvariable id="parserType" type="String"--%>
    <h1> Parser type: ${parserType} </h1>
    <table border="1">
        <tr>
            <th rowspan="2">#</th>
            <th rowspan="2">Type</th>
            <th rowspan="2">Country</th>
            <th rowspan="2">Date</th>
            <th rowspan="2">Duration</th>
            <th rowspan="2">Transport</th>
            <th rowspan="2">Cost</th>
            <th colspan="6">Hotel characteristics</th>
        </tr>
        <tr>
            <th>Hotel name</th>
            <th>Stars</th>
            <th>Nutrition</th>
            <th>Persons</th>
            <th>TV</th>
            <th>Conditioner</th>
        </tr>
        <%--@elvariable id="vouchers" type="java.util.List"--%>
        <c:forEach items="${vouchers}" var="voucher">
            <tr>
                <td> ${voucher.id} </td>
                <td> ${voucher.type} </td>
                <td> ${voucher.country} </td>
                <td> <fmt:formatDate pattern="dd.MM.yyyy" value="${voucher.date}"/> </td>
                <td> ${voucher.duration.duration} ${voucher.duration.unit} </td>
                <td> ${voucher.transport} </td>
                <td> ${voucher.cost.cost} ${voucher.cost.currency} </td>
                <td> ${voucher.hotelCharacteristics.hotelName} </td>
                <td> ${voucher.hotelCharacteristics.stars} </td>
                <td> ${voucher.hotelCharacteristics.nutrition} </td>
                <td> ${voucher.hotelCharacteristics.persons} </td>
                <td>
                    <c:if test="${empty voucher.hotelCharacteristics.tv}">
                    -
                    </c:if>
                    <c:if test="${not empty voucher.hotelCharacteristics.tv}">
                        ${voucher.hotelCharacteristics.tv}
                    </c:if>
                </td>
                <td>
                    <c:if test="${empty voucher.hotelCharacteristics.conditioner}">
                        -
                    </c:if>
                    <c:if test="${not empty voucher.hotelCharacteristics.conditioner}">
                        ${voucher.hotelCharacteristics.conditioner}
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
