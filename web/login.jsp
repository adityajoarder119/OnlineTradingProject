<%-- 
    Document   : login
    Created on : 25 Jan, 2022, 12:10:51 AM
    Author     : Suraj Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="css/registration.css" rel="stylesheet" crossorigin="anonymous">
    </head>
    <body>

        <div class="container">
            <form action="dashboard.jsp">
                <center><h1 style="font-size: 50px; color: black">Login Here</h1></center>
                <div class="row omb_row-sm-offset-3">

                    <div class="col-xs-12 col-sm-6" style="color: red">                    
                        <span class="omb_spanOr">
                            <!-- here I want to display my error msg after 
                            extracting from request object. Also I need to format the 
                            text in red color. 
                            In order to use request object ( Java object) we need to use 
                            something call jstl - java server tag lib - why? Because 
                            it helps us reduce number of lines of code. 
                            -->                            
                            <s:out value='${requestScope.ErrorMsg}'/>
                        </span>
                    </div>
                    <label for='emailid'> Email Id<sup>*</sup> : </label>   
                    <input type="text" id="emailid" name="email Id" placeholder="Enter your Email Id" required/>
                    <label for='password'> Password<sup>*</sup> : </label>    
                    <input type="password" id='password' name="password" placeholder="Enter Password" required/>
                    <input type="checkbox" value="remember-me" required> I accept all <a href="termsAndCondition.jsp">Terms and Condition</a>
                    <div>
                        <button type="submit" class="btn">Register</button>    
                        <button type="reset" class="btn">Reset</button>
                        <hr>
                        <center style="font-size: 30px">
                            Have you forgotten your password? Don't worry.<br> Click Here
                            <a href="forgotPassword.jsp">Forgot Password </a>
                        </center>
                    </div>
            </form>            
        </div><hr>
    <center>
        <b style="font-size: 50px; color: black"> Don't have an account <br><a href="register.jsp"> Register here </a></b>
    </center>
</body>
</html>
