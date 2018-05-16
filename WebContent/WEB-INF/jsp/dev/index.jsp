<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="${pageContext.request.contextPath }/statics/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link
	href="${pageContext.request.contextPath }/statics/css/nprogress.css"
	rel="stylesheet">
<!-- iCheck -->
<link href="${pageContext.request.contextPath }/statics/css/green.css"
	rel="stylesheet">
<!-- bootstrap-progressbar -->
<link
	href="${pageContext.request.contextPath }/statics/css/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet">
<!-- JQVMap -->
<link
	href="${pageContext.request.contextPath }/statics/css/jqvmap.min.css"
	rel="stylesheet" />

<!-- Custom Theme Style -->
<link
	href="${pageContext.request.contextPath }/statics/css/custom.min.css"
	rel="stylesheet">
<script language="javascript" type="text/javascript">

	  
	 function next()
	 {
		 /* var contextPath=${pageContext.request.contextPath }+"";  */
	 		
		 var list;
	 		$.ajax({
	             type: "GET",
	             url: "/AppInfoSystem01/selectappInfo",
	             data: {
	            	 offset:3, 
	            	 line:3,
	             },
	             dataType: "text",
	             success: function(data){
	            	 alert( data  );
	             },
	             error : function(res){
	            	 	alert( "失败"  );
	             }
	         }).then(function name() {
	        	 alert( "成功"  );
			}); 
	 }
	 </script>
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"><i class="fa fa-paw"></i>
							<span>APP信息管理</span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile">
						<div class="profile_pic">
							<img
								src="${pageContext.request.contextPath }/statics/images/img.jpg"
								alt="..." class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>欢迎,</span>
							<h2>${devuser.devName}</h2>
						</div>
					</div>
					<!-- /menu profile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3>{身份}</h3>
							<ul class="nav side-menu">
								<li><a><i class="fa fa-home"></i> APP管理 <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a
											href="${pageContext.request.contextPath}/selectappInfo?offset=0&&line=3">查看APP列表信息</a></li>
										<li><a href="addmessage.jsp">增加APP基础信息</a></li>
										<li><a href="index3.html">修改APP基础信息</a></li>
										<li><a href="index3.html">新增APP版本信息</a></li>
										<li><a href="index3.html">修改APP版本信息</a></li>
										<li><a href="index3.html">查看APP信息</a></li>
										<li><a href="index3.html">删除APP</a></li>
										<li><a href="index3.html">APP上下架管理</a></li>
									</ul></li>


								<li><a href="javascript:void(0)"><i
										class="fa fa-laptop"></i> 主页 <span
										class="label label-success pull-right">点击</span></a></li>
							</ul>
						</div>

					</div>
					<!-- /sidebar menu -->

					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small">
						<a data-toggle="tooltip" data-placement="top" title="Settings">
							<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="FullScreen">
							<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Lock"> <span
							class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="登出"> <span
							class="glyphicon glyphicon-off" aria-hidden="true"></span>
						</a>
					</div>
					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
					<div class="nav toggle">
						<a id="menu_toggle"><i class="fa fa-bars"></i></a>
					</div>

					<ul class="nav navbar-nav navbar-right">
						<li class=""><a href="javascript:;"
							class="user-profile dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false"> <img
								src="${pageContext.request.contextPath }/statics/images/img.jpg"
								alt="">${devuser.devName} <span class=" fa fa-angle-down"></span>
						</a>
							<ul class="dropdown-menu dropdown-usermenu pull-right">
								<li><a href="javascript:;"> Profile</a></li>
								<li><a href="javascript:;"> <span
										class="badge bg-red pull-right">50%</span> <span>Settings</span>
								</a></li>
								<li><a href="javascript:;">Help</a></li>
								<li><a href="login.html"><i
										class="fa fa-sign-out pull-right"></i> 登出</a></li>
							</ul></li>

						<li role="presentation" class="dropdown"><a
							href="javascript:;" class="dropdown-toggle info-number"
							data-toggle="dropdown" aria-expanded="false"> <i
								class="fa fa-envelope-o"></i> <span class="badge bg-green">6</span>
						</a>
							<ul id="menu1" class="dropdown-menu list-unstyled msg_list"
								role="menu">
								<li><a> <span class="image"><img
											src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
												Smith</span> <span class="time">3 mins ago</span>
									</span> <span class="message"> Film festivals used to be
											do-or-die moments for movie makers. They were where... </span>
								</a></li>
								<li><a> <span class="image"><img
											src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
												Smith</span> <span class="time">3 mins ago</span>
									</span> <span class="message"> Film festivals used to be
											do-or-die moments for movie makers. They were where... </span>
								</a></li>
								<li><a> <span class="image"><img
											src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
												Smith</span> <span class="time">3 mins ago</span>
									</span> <span class="message"> Film festivals used to be
											do-or-die moments for movie makers. They were where... </span>
								</a></li>
								<li><a> <span class="image"><img
											src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
												Smith</span> <span class="time">3 mins ago</span>
									</span> <span class="message"> Film festivals used to be
											do-or-die moments for movie makers. They were where... </span>
								</a></li>
								<li>
									<div class="text-center">
										<a> <strong>See All Alerts</strong> <i
											class="fa fa-angle-right"></i>
										</a>
									</div>
								</li>
							</ul></li>
					</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->

			<!-- page content table-andy-->
			<div class="right_col" role="main">

             <table>
				
				<tr>
				    <td>AppID</td>
				     <td>App名字</td>
				      <td>APK名字</td>
				       <td>支持版本</td>
				        <td>语言</td>
				         <td>文件大小</td>
				</tr>
				<c:forEach items="${appinfolist}" var="appinfo" varStatus="vs">
					<tr>
						<td>
							 <c:out value="${appinfo.id}"/>
						</td>
						<td>
							 <c:out value="${appinfo.softwareName}"/>
						</td>
						<td>
							 <c:out value="${appinfo.APKName}"/>
						</td>
						<td>
							 <c:out value="${appinfo.supportROM}"/>
						</td>
						<td>
							 <c:out value="${appinfo.interfaceLanguage}"/>
						</td>
						<td>
							 <c:out value="${appinfo.softwareSize}"/>
						</td>

					</tr>
				</c:forEach>
				</table>
		<a href="">首页</a>
		<a href="">上一页</a>
		<!-- <button id="btnext" onclick="next()">下一页</button> -->
		<a
											href="${pageContext.request.contextPath}/selectappInfo?offset=3&&line=3">下一页</a></li>
										<li>
		<a href="">尾页</a>
		<text>现在是第 0 页</text>

			</div>
		</div>
	</div>
	</div>

	<footer>
	<div class="pull-right">
		Gentelella - Bootstrap Admin Template by <a
			href="https://colorlib.com">Colorlib</a>
	</div>
	<div class="clearfix"></div>
	</footer>
	<!-- /footer content -->
	</div>
	</div>

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="${pageContext.request.contextPath }/statics/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script
		src="${pageContext.request.contextPath }/statics/js/fastclick.js"></script>
	<!-- NProgress -->
	<script
		src="${pageContext.request.contextPath }/statics/js/nprogress.js"></script>

	<!-- bootstrap-daterangepicker -->
	<script
		src="${pageContext.request.contextPath }/statics/js/moment/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/datepicker/daterangepicker.js"></script>

	<!-- Custom Theme Scripts -->
	<script
		src="${pageContext.request.contextPath }/statics/js/custom.min.js"></script>
	
	
	
</body>
</html>