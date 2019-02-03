<%--@elvariable id="errorText" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Error</title>
    <style>
        .error {
            color: red;
            font-size: 200%;
        }
    </style>
</head>
<body>
    <p><span class="error"> Error: </span> ${errorText}</p>
</body>
</html>
