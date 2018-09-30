<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>

  /* Basics */
       html, body 
        {
        
           padding: 0;
            margin: 0;
            width: 100%;
            height: 100%;
            font-family: "Helvetica Neue" , Helvetica, sans-serif;
            background: Solid Blue;
            background-position: center;
            
           background-origin: border-box;
   			 background-repeat: no-repeat;
    		background-size: cover;
            background-image: url("ho.jpg");
        }
        
        .transbox {
  margin: 30px;
  background-color: #ffffff;
  border: 1px solid black;
  opacity: 0.6;
  filter: alpha(opacity=60); /* For IE8 and earlier */
}
        
        
        
                .logincontent
        {
           <%-- position: fixed;--%>
            width: 350px;
            height: 300px;
            top: 50%;
            left: 50%; 
            float: right;
            margin-top: 2.5cm;
            margin-right: 1cm;
           <%--  background: #07A8C9;--%>
            padding-top: 10px;
        }
        .loginheading
        {
           <%-- border-bottom: solid 1px #ECF2F5;--%>
            padding-left: 18px;
            padding-bottom: 10px;
            color: #ffffff;
            font-size: 20px;
            font-weight: bold;
            font-family: sans-serif;
        }
        label
        {
            color: #ffffff;
            display: inline-block;
            margin-left: 18px;
            padding-top: 10px;
            font-size: 15px;
        }
        input[type=text], input[type=password]
        {
            font-size: 14px;
            padding-left: 10px;
            margin: 10px;
            margin-top: 12px;
            margin-left: 18px;
            width: 300px;
            height: 35px;
            border: 1px solid #ccc;
            border-radius: 2px;
            box-shadow: inset 0 1.5px 3px rgba(190, 190, 190, .4), 0 0 0 5px #f5f5f5;
            font-size: 14px;
        }
        input[type=checkbox]
        {
            margin-left: 18px;
            margin-top: 30px;
        }
        .loginremember
        {
            background: #ECF2F5;
            height: 70px;
            margin-top: 20px;
        }
        .check
        {
            font-family: sans-serif;
            position: relative;
            top: -2px;
            margin-left: 2px;
            padding: 0px;
            font-size: 12px;
            color: #321;
        }
        .loginbtn
        {
            float: right;
            margin-right: 3.5cm;
            margin-top: 20px;
            padding: 6px 20px;
            font-size: 14px;
            font-weight: bold;
            color: #fff;
            background-color: #07A8C3;
            background-image: -webkit-gradient(linear, left top, left bottom, from(#07A8C3), to(#6EE4E8));
            background-image: -moz-linear-gradient(top left 90deg, #07A8C3 0%, #6EE4E8 100%);
            background-image: linear-gradient(top left 90deg, #07A8C3 0%, #6EE4E8 100%);
            border-radius: 30px;
            border: 1px solid #07A8C3;
            cursor: pointer;
        }
        .loginbtn:hover
        {
            background-image: -webkit-gradient(linear, left top, left bottom, from(#b6e2ff), to(#6ec2e8));
            background-image: -moz-linear-gradient(top left 90deg, #b6e2ff 0%, #6ec2e8 100%);
            background-image: linear-gradient(top left 90deg, #b6e2ff 0%, #6ec2e8 100%);
        }
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li button {
    display: block;
    color: white;
     font-size: 20px;
    text-align: center;
    padding: 20px 24px;
    text-decoration: none;
}

li button:hover {
    background-color: #111;
    border:#111 1px;
}
</style>




</head>
<body class="bg">

<ul>
  
  <li style="margin-left:10px; color:white; margin-top:3px; float:left;"><h2>Welcome In Hotel Order Management System..!!!</h2></li>
<li Style="float:right;"><button class="tablinks" onclick="openCity(event, 'Staff')" Style="background-color: #333; border:#333 ;">Staff</button></li>
	<li Style="float:right;"><button class="tablinks" onclick="openCity(event, 'Admin')" id="defaultOpen" Style="background-color: #333; border:#333 ;">Admin</button></li>
</ul>


<div id="Admin" class="tabcontent" >
 <form action="adlogin" method="post" class="form-container" >
    
<div class="logincontent" class="transbox" >
	 <div class="loginheading">
            Login As Admin
        </div>
        
        <label for="txtUserName">
            Username:</label>
        <input type="text" id="txtUserName" name="txtUserName" />
        <label for="txtPassword">
            Password:</label>
        <input type="password" id="txtPassword" name="txtPassword" />
        <div >
           
            <input type="submit" class="loginbtn" value="Login" id="btnSubmit" />
              
        </div>
        
    </div>
  </form>
  
  
  <%if(request.getAttribute("err")!=null) {%>
  
  <%  String err=(String)request.getAttribute("err"); %>
  
<%  out.println("alert('Error In Username Or PassWord..!!!');"); %>			
  <% } %>
  
</div>

<div id="Staff" class="tabcontent">
 <form action="stlogin" method="post" class="form-container" >
    
<div class="logincontent" class="transbox">
	 <div class="loginheading">
            Login As Staff
        </div>
        <label for="txtUserName">
            Username:</label>
        <input type="text" id="txtUserName" name="txtUserName" />
        <label for="txtPassword">
            Password:</label>
        <input type="password" id="txtPassword" name="txtPassword" />
        <div >
            
            <input type="submit" class="loginbtn" value="Login" id="btnSubmit" />
        
        </div>
    </div>
  </form>
</div>

</div>

<script type="text/javascript">
function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();


function error(){
	
	
	alert("Error In Username Or PassWord");
	
}

</script>


</body>
</html>