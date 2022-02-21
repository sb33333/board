<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h1>Article ${command.getPostId()}</h1>
<form:form method="POST" action="/update">
    <table >

        <tr>
            <td>NickName : </td>
            <td>${command.getNickName()}</td>
        </tr>
        <tr>
            <td>Title :</td>
            <td>${command.getTitle()}</td>
        </tr>
        <tr>
            <td>Content :</td>
            <td>${command.getContent()}</td>
        </tr>
        <tr>
            <td> </td>
            <td><a href = "/">처음으로</a></td>
        </tr>
    </table>
</form:form>