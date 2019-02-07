<%@ page contentType="text/html;charset=UTF-8"%>
<head>
    <script type="text/javascript">
        function validate(form) {
            var fileName = form.elements["uploadFile"].value;
            if (fileName === "") {
                alert("Choose file!");
                return false;
            } else {
                var fileFormat = fileName.substring(fileName.length - 4);
                if (fileFormat !== ".xml") {
                    alert("File format should be .xml!");
                    form.elements["uploadFile"].value = "";
                    return false;
                }
            }
        }
    </script>
</head>
<body>
<form action="uploadXML" method="post" enctype="multipart/form-data" onsubmit="return validate(this)">
    <h2>Parsing XML</h2>
    <input type="file" accept=".xml" name="file" id="uploadFile"/>
    <input type="submit" value="Parse"/>
    <br>
    <p>Select parsing type:</p>
    <div>
        <input type="radio" id="parser1"
               name="parserType" value="DOM" checked>
        <label for="parser1">DOM</label>
        <input type="radio" id="parser2"
               name="parserType" value="SAX">
        <label for="parser2">SAX</label>
        <input type="radio" id="parser3"
               name="parserType" value="StAX">
        <label for="parser3">StAX</label>
    </div>
</form>
</body>
</html>
