<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listagem de contas</title>
</head>
<body>
	<h3>Lista de contas</h3>
	
	<table>
		<tr>
			<th>Código</th>
			<th>Descrição</th>
			<th>Tipo</th>
			<th>Valor</th>
			<th>Situação</th>
			<th>Data Pagamento</th>
			<!--   <th>Remover</th>-->
		</tr>
		
		<c:forEach items="${todasContas}" var="conta"> 
			<tr>
				<td>${conta.id}</td>
				<td>${conta.descricao}</td>
				<td>${conta.tipo}</td>
				<td>${conta.valor}</td>
				<td>
					<c:if test="${conta.paga eq true}">Paga</c:if>
					<c:if test="${conta.paga eq false}">Não paga</c:if>
				</td>
				<td><fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy"/></td>
				<td><a href="removeConta?id=${conta.id}">Remover</a></td>
				<td><a href="mostraConta?id=${conta.id}">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>