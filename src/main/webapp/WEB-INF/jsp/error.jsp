<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Error</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h1><span class="error"> Something went wrong </span></h1>
    <p> Request from ${pageContext.errorData.requestURI} is failed </p>
    <p> Servlet name: ${pageContext.errorData.servletName} </p>
    <p> Status code: ${pageContext.errorData.statusCode} </p>
</body>
</html>
