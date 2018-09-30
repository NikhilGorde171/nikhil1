<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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

li {
    float: left;
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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<ul>
  <li><a >Table Summary</a></li>
  <li><a class="active" href="http://localhost:8080/HotelOrderManagement/login.jsp">Back</a></li>
</ul>




<div  class="tabcontent">
  
  
  <form action="tabs" method="post" class="form-container" >
  
<h4>Enter Table Number:	</h4><input type="text" name="tableno" value="0" pattern="[1-9]{1}[0-9]{}" >
    <input type="submit" class="btncancel1" value="Display order" style="margin-top:0.3cm;">
  </form>
	
			
	<%if(request.getAttribute("al")!=null){ %>

			<%if(request.getAttribute("arr1")!=null) {%>
	
					<%if(request.getAttribute("arr2")!=null) {%>
					
					
					
				<% ArrayList<String> ar1=new ArrayList<>(); %>
			<%ar1=(ArrayList<String>)request.getAttribute("al"); %>
			<%  ListIterator<String> itr1=ar1.listIterator(); %>

			
				<%int arr1[]=new int[50]; %>

			<%arr1=(int[])request.getAttribute("arr1"); %>



				<%int arr2[]=new int[50]; %>
			<%arr2=(int[])request.getAttribute("arr2"); %>


			<%-- 	<% Map<String,Integer> map1=new HashMap<String,Integer>(); %>
			<%map1=(Map<String,Integer>)request.getAttribute("map"); %>
			<% Set<Map.Entry<String,Integer>> set=map1.entrySet();%>
		<% Iterator<Map.Entry<String,Integer>> itr=set.iterator(); %>
		--%>
			<table style="margin-top:1.5cm;">
				<tr>
					<th>Menu</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Total</th>
			    </tr>
			
			<% int i=0; %>
			<% int j=0; %>
			<% int sum=0; %>
			<% while(itr1.hasNext()){ %>
			
				
				<tr>
				<td><% out.println(itr1.next()); %></td>
				<td><%   out.println(arr1[i]); %></td>
				<td><% out.println(arr2[j]); %></td>
					
					<%int mul=arr1[i]*arr2[j]; %>
					
					<%sum = sum+mul; %>
				<td><% out.println(mul);   %></td>	
					<%i++; %>
					<%j++; %>
					
				</tr>
				<% } %>
			
		<tr>			
			<td></td>
			<td></td>
			<td><%out.println("Total Bill ="); %></td>
			<td><%out.println(sum); %></td>
			</tr>
			</table>
			
		
		<form action="print" method="post" class="form-container" >
 	 		<input type="submit" class="btncancel1" value="Generate Bill" style="margin-top:0.3cm;">
  		</form>	
		
		
		<%  } %>
		
		<% }  %>
		
		<%  }  %>
		
		
		
		
		
</div>

</body>
</html>