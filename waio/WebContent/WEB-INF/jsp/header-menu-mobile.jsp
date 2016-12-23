<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <ul class="ct-menuMobile-navbar">
        <li class="active"><a href="index">Home</a> </li>
        <li><a href="aboutus">About Us</a></li>
		<li><a href="courses">Courses</a> </li>
		<li><a href="members">Members</a> </li>
		<li><a href="gallery">Gallery</a> </li>
		<li><a href="syllabus">Syllabus</a> </li>
		<li><a href="contact">Contact</a></li>
		<%= session.getAttribute("userName")!=null?"<li class='dropdown active'><a>Access</a><ul class='dropdown-menu'><li><a href='upload' class='ct-js-login'>Complete Profile</a></li><li><a href='feesDetail' class='ct-js-login'>Fees Detail</a></li></ul></li>":""%>
		<%-- <%= session.getAttribute("userName")!=null?"<li><a href='logout' class='ct-js-login'>Logout</a></li>":""%> --%>
		<!-- <li><a href="registration">Sign up</a></li> -->
		<!-- <li class="active"><a href="index">Home</a> </li> -->
		<!-- <li><a href="aboutus">About Us</a></li> -->
		<%-- <%= session.getAttribute("ROLE_MANAGER")!=null?"<li><a href='submitFees' class='ct-js-login'>Submit Fees</a></li>":""%> --%>
		<%= session.getAttribute("ROLE_MANAGER")!=null?"<li class='dropdown active'><a>Admin Access</a><ul class='dropdown-menu'><li><a href='submitFees' class='ct-js-login'>Submit Fee for Trainee</a></li><li><a href='getFeesDetailForAllTrainee' class='ct-js-login'>All Trainees Fee Details</a></li><li><a href='allMembers' class='ct-js-login'>Activate User</a></li></ul></li>":""%>
    </ul>
</body>
</html>