<!DOCTYPE html>

<head>
    <title>JSP</title>
</head>

<body>
    <%! int x=10;
    int y=20;
    int sum()
    {

        return x+y;
    }
    %>
        <%="Sum is "+sum() %>
</body>

</html>