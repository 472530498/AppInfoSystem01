<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong> <span>App信息列表</span>
	</div>
	<div class="search">
		<form method="post"
			action="${pageContext.request.contextPath}/selectappInfo">
			<input name="method" value="query" class="input-text" type="hidden">
			<span>用户名：</span> <input name="userName" class="input-text"
				type="text" value="${param.userName }"> <span>用户角色：</span> <select
				name="userRole">
				<option value="0">--请选择--</option>
				<c:if test="${roleList != null }">

					<c:forEach var="role" items="${roleList}">
						<option
							<c:if test="${role.id == param.userRole }">selected="selected"</c:if>
							value="${role.id}">${role.roleName}</option>
					</c:forEach>
				</c:if>
			</select> 
			<input type="hidden" name="currentPageNo" value="1" />
			 <input	type="hidden" name="pageSize" value="5" /> <input value="查 询"
				type="submit" id="searchbutton">--> <a
				href="${pageContext.request.contextPath}/user/add">添加用户</a>
		</form>
	</div>
	<!--用户-->
	<table class="providerTable" cellpadding="0" cellspacing="0">
		<tr class="firstTr">
			<th width="10%">AppID</th>
			<th width="20%">app名称</th>
			<th width="10%">APK</th>
			<th width="10%">支持版本</th>
			<th width="10%">语言</th>
			<th width="10%">文件大小</th>
			<th width="30%">简介</th>
		</tr>
		<c:forEach var="appinfo" items="${pageSupport.list}" varStatus="vs">
			<tr>
				<td><span>${appinfo.id}</span></td>
				<td><span>${appinfo.softwareName}</span></td>
				<td><span>${appinfo.APKName}</span></td>
				<td><span>${appinfo.supportROM}</span></td>
				<td><span>${appinfo.interfaceLanguage}</span></td>
				<td><span>${appinfo.softwareSize}</span></td>
				<td><span>${appinfo.appInfo}</span></td>
			</tr>
		</c:forEach>
	</table>
	<input type="hidden" id="totalPageCount"
		value="${pageSupport.totalPageCount}" />
	<c:import url="rollpage.jsp">
		<c:param name="totalCount" value="${pageSupport.totalCount}" />
		<c:param name="currentPageNo" value="${pageSupport.currentPageNo}" />
		<c:param name="totalPageCount" value="${pageSupport.totalPageCount}" />
	</c:import>
</div>
</section>


<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/userlist.js"></script>
