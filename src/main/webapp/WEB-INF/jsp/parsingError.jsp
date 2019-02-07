<%--@elvariable id="errorText" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Parsing error</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h1><span class="error"> Error: </span> ${errorText}</h1>
</body>
</html>
