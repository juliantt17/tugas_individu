

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="get" modelAttribute="emp" action="login/save.html" >
            <table align="center" >
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username" ></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" ></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login" ></td>
                </tr>
                <tr>
                    <td colspan="2" >${message}</td>
                </tr>
            </table>
        </form>
    </body>
</html>
