<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
* {box-sizing: border-box}
body {font-family: "Lato", sans-serif;}

/* Style the tab */
.tab {
    float: left;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
    width: 18%;
    height: 600px;
}

/* Style thebuttons inside the tab */
.tab button {
    display: block;
    background-color: inherit;
    color: black;
    padding: 18px 14px;
    width: 100%;
    border: none;
    outline: none;
    text-align: left;
    cursor: pointer;
    transition: 0.3s;
    font-size: 15px;
}

/* Change background color of buttons on hover */
.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current "tab button" class */
.tab button.active {
    background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
    float: left;
    padding: 0px 12px;
    border: 1px solid #ccc;
    width: 100%;
    border-left: none;
    height: 600px;
}

* {
    box-sizing: border-box;
}

input[type=text], select, textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    resize: vertical;
}

label {
    padding: 12px 12px 12px 0;
    display: inline-block;
}

input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    float: right;
}

input[type=submit]:hover {
    background-color: #45a049;
}

.container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}

.col-25 {
    float: left;
    width: 25%;
    margin-top: 6px;
}

.col-75 {
    float: left;
    width: 75%;
    margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
    .col-25, .col-75, input[type=submit] {
        width: 100%;
        margin-top: 0;
    }
}

.btncancel1{
		margin-right:5px;

}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
	height:70px;
}



li a {
    display: block;
    color: white;
    text-align: center;
	text-size:10px;
    padding: 24px 18px;
    text-decoration: none;

}

li a:hover {
    background-color: #111;
	height:70px;
}
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}

</style>
</head>
<body>

<ul>
<li style="margin-left:10px; color:white; margin-top:7px; float:left;"><h3>Notification...!!!</h3></li>
<li style="margin-right:10px; float:right;"><a class="active" href="http://localhost:8080/HotelOrderManagement/waiter.html">Back</a></li>
</ul>


<div id="Porders" class="tabcontent">
  
  
  <form action="pendingorders" method="post" class="form-container" >
	<input type="submit" class="btncancel" value="Show" Style="margin-top:0.5cm;">  
  </form>
  <h1>Ready Order to Serve </h1>
  
  
 <% if(request.getAttribute("arr1")!=null){ %>
 	
 	<% int arr2[]; %>
 	<% arr2=(int[])request.getAttribute("arr1"); %>
 	
 	<%-- Arraylist only for while iteration 
 	<% ArrayList<String> al2=new ArrayList<>();%>
 	<% al2=(ArrayList<String>)request.getAttribute("al1"); %>
 	<%  ListIterator<String> itr1=al2.listIterator(); %>
 	--%>
 	<table>
 		<% int i=0; %>
 		
 		<% while(i<arr2.length) {%>
 				<tr>
 					
 						<td><%  out.println(arr2[i]); %></td>
 							<% i++; %>	
 									
 				
 				</tr>
 		<% } %>
 			
 	</table>
 
 <% } %>
 
 
 
</div>
  


</body>
</html>