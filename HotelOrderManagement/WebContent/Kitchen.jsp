<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ page import= "java.util.*" %>
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
    width: 82%;
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
<li style="margin-left:10px; color:white; margin-top:7px; float:left;"><h3>Welcome to Kitchen...!!!</h3></li>
<li style="margin-right:10px; float:right;"><a class="active" href="http://localhost:8080/HotelOrderManagement/waiter.html">Back</a></li>
</ul>

<div class="tab">
<button class="tablinks" id="defaultOpen" onclick="openCity(event, 'Porders')">Pending Orders</button>
<button class="tablinks" id="defaultOpen" onclick="openCity(event, 'Dorders')">Display Orders</button>
</div>

<div id="Porders" class="tabcontent">
  
  
  <form action="pendingorders" method="post" class="form-container" >
	<input type="submit" class="btncancel" value="Show" Style="margin-top:0.5cm;">  
  </form>
  <h1>PendingOrders Table Numbers Are</h1>
  
 <%--<%Integer z=(Integer)request.getAttribute("a"); 
 <h1><%if(z==null){out.println("");}else{out.println(z); } %></h1>
  <%Integer y=(Integer)request.getAttribute("b"); %>
 <h1><%if(y==null){out.println("");}else{out.println(y); } %></h1>
 <%Integer x=(Integer)request.getAttribute("c"); %>
 <h1><%if(x==null){out.println("");}else{out.println(x); } %></h1>
 <%Integer v=(Integer)request.getAttribute("d"); %>
 <h1><%if(v==null){out.println("");}else{out.println(v); } %></h1>
 <%Integer w=(Integer)request.getAttribute("e"); %>
 <h1><%if(w==null){out.println("");}else{out.println(w); } %></h1>
<%Integer u=(Integer)request.getAttribute("f"); %>
 <h1><%if(u==null){out.println("");}else{out.println(u); } %></h1>
<%Integer t=(Integer)request.getAttribute("g"); %>
 <h1><%if(t==null){out.println("");}else{out.println(t); } %></h1>
 <%Integer s=(Integer)request.getAttribute("h"); %>
 <h1><%if(s==null){out.println("");}else{out.println(s); } %></h1>
<%Integer r=(Integer)request.getAttribute("i"); %>
 <h1><%if(r==null){out.println("");}else{out.println(r); } %></h1>
<%Integer q=(Integer)request.getAttribute("j"); %>
 <h1><%if(q==null){out.println("");}else{out.println(q); } %></h1>		--%>
 
 
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




<div id="Dorders" class="tabcontent">
    <h2>Show Orders</h2>


<form action="disporder" method="post" class="form-container">
		Enter Table No:<input type="text" pattern="[1-9]{1}[0-9]{}"  id="tn" value="0" name="tn"  >
		<br>        
        <input type="submit" class="btncancel1" value="Display order" style="margin-top:0.5cm;" >
 </form>
 
     




	  <%--    <%if(request.getAttribute("list")!=null) {  %> 
    	 
    	 <% if(request.getAttribute("list1")!=null){ %>
    	 
    	 <%  ArrayList<String> list=new ArrayList<>();%>
    	  <% list=(ArrayList<String>)request.getAttribute("list"); %>
   		<%  ListIterator<String> itr=list.listIterator(); %>
  
     
  			<%ArrayList<Integer> list1=new ArrayList<>(); %>
  			<%list1=(ArrayList<Integer>)request.getAttribute("list1"); %>
 			 
    
    <table style="margin-top:1.5cm;">
   	<tr>
   		<th style="text-align: center;">Menu</th>
   		<th style="text-align: center;">Quantity</th>
   	</tr>
    
    <% while(itr.hasNext()){%>   	
   	<tr>
   		<td style="text-align: center;">
   			<%  out.println(itr.next()); %>
   			</td>
   		<% } %>
   		
   		<td>
   			<%  for(int i=0;i<list1.size();i++) {%>
   				
   			<% out.println((Integer)list1.get(i)); %>
   		
   		<%} %>
   		</td>	
   	</tr>	
    <% } %>
  <%  } %>	
    </table> 
    --%>
    
    		<% if(request.getAttribute("map")!=null) {%>
    
    		<% Map<String,Integer> map=new HashMap<String,Integer>(); %>	
    		<%map=(Map<String,Integer>)request.getAttribute("map"); %>
    
    		<% Set<Map.Entry<String,Integer>> set=map.entrySet();%>
    	<% Iterator<Map.Entry<String,Integer>> itr=set.iterator(); %>
    
    			<table style="margin-top:2.5cm;">
    					<tr>
    					<th>Menu</th>
    					<th>Quantity</th>
    					</tr>
    		<% while(itr.hasNext()){ %>		
    				<%  Map.Entry e=itr.next(); %>
    				<tr>
    					<td><%out.println(e.getKey()); %></td>
    					<td><%out.println(e.getValue()); %></td>
    				</tr>
    				
    	<% } %>
    	
    		 
		</table>
		<form action="done" method="post" class="form-container" >
		<input type="submit" class="btncancel" value="Done" style="margin-top:0.5cm; margin-right:0.5cm;">
    	</form>
    	<% } %>
    
 </div>
 



<script>
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



</script>
</body>
</html>