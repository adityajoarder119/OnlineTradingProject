<%-- 
    Document   : register
    Created on : 25 Jan, 2022, 12:20:18 AM
    Author     : Suraj Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <title>Register</title>
        <link href="css/registration.css" rel="stylesheet" crossorigin="anonymous">
    </head>
    <body>
        <form>  
            
            <div class="container">  
                <center>  <h1> User Registeration Form</h1> </center>
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
                <hr>  
                <label for='name'> Name<sup>*</sup> : </label>   
                <input type="text" id="name" name="name" placeholder= "Enter your name" required />   
                <div>  
                    <label>   
                        Gender<sup>*</sup> :  
                    </label><br>  
                    <input type="radio" value="Male" name="gender" checked > Male   
                    <input type="radio" value="Female" name="gender"> Female   
                    <input type="radio" value="Other" name="gender"> Other  

                </div>
                <label for='address'>Current Address<sup>*</sup> :  </label>
                       <textarea cols="80" rows="5" id='address' name='address' placeholder="Current Address" value="address" required/>  
                </textarea>
                <label for='emailid'> Email Id<sup>*</sup> : </label>   
                <input type="text" id="emailid" name="email Id" placeholder="Enter your Email Id" required/>   
                <label for='phoneNumber'> Phone Number<sup>*</sup> : </label>    
                <input type="text" id='phoneNumber' name="phoneNumber" placeholder="Enter your Mobile Number" required/>
                <label for='password'> Password<sup>*</sup> : </label>    
                <input type="password" id='password' name="password" placeholder="Enter Password" required/>
                  
                  
                <label for="psw-repeat"><b>Re-type Password<sup>*</sup> :</b></label>  
                <input type="password" id="psw-repeat" placeholder="Retype Password" name="psw-repeat" required>
                <input type="checkbox"> I accept all <a href="termsAndCondition.jsp">Terms and Condition</a>
                <div>
                    <button type="submit" class="btn">Register</button>    
                <button type="reset" class="btn">Reset</button> 
                
                </div>
            </div>
        </form>
    <center><h3>Already have an account. Login here</h3></center>
        <center><a class="login" href="login.jsp">Login Here </a></center>
    </body>  
</html>
