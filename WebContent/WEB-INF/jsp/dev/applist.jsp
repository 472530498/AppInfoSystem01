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
			<span>App关键字：</span>
			 <input name="softwareName" class="input-text"type="text" value="${param.softwareName }"> 
			 <span>语言：</span> 
			 <select name="interfaceLanguage">
				<option value="">${param.interfaceLanguage }</option>
                <option value="中文">中文</option>
                <option value="英文">英文</option> 	
			</select>  
			<input type="hidden" name="currentPageNo" value="1" />
			 <input	type="hidden" name="pageSize" value="5" /> 
  		 <input value="查 询"	type="submit" id="searchbutton">
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
				<td>
				<span><a class="viewUser"   id=${appinfo.id } softwareName=${appinfo.softwareName }><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
				<span><a class="modifyUser" id=${appinfo.id } softwareName=${appinfo.softwareName }><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
				<span><a class="deleteUser" id=${appinfo.id } softwareName=${appinfo.softwareName }><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
				</td>
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
