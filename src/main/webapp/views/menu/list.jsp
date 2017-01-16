<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!-- Listing grid -->

<display:table pagesize="5" class="displaytag" keepStatus="true" name="menus" requestURI="${requestURI}" id="row">
	
	<!-- Action links -->
	
	<!-- Attributes -->
	
	<spring:message code="menu.random" var="randomHeader" />
	<display:column property="random" title="${random}" sortable="true" />
	
	<spring:message code="menu.random" var="randomHeader" />
	<display:column property="user.name" title="${random}" sortable="true" />

	
</display:table>