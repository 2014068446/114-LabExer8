<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>
<s:form action="saveOrUpdateTV">
	<s:push value="TV">
		<s:hidden name="id" />
		<s:textfield name="title" label="Title" />
		<s:textfield name="season" label="Season" />
		<s:textfield name="year" label="Year" />
		
		<s:submit />
	</s:push>
</s:form>

<s:if test="TVList.size() > 0">
	<div class="content">
	<table class="TVTable" cellpadding="5px">
		<tr class="even">
			<th>Title</th>
			<th>Season</th>
			<th>Year</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<s:iterator value="TVList" status="TVStatus">
			<tr
				class="<s:if test="#TVstatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="title" /></td>
				<td><s:property value="season" /></td>
				<td><s:property value="year" /></td>
				
				<td><s:url id="editURL" action="editTV">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{editURL}">Edit</s:a></td>
				<td><s:url id="deleteURL" action="deleteTV">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if>
</body>
</html>