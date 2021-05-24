<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header.jsp"></jsp:include>
	<main class="container mt-6">
	
	<div class="columns is-centered">
		<div class="column is 5">
			<div class="card">
				<div class="card-header has-background-primary">
					<span class="card-header-title">filtrador</span>
				</div>
				<div class="card-content">
					<div class="field">
								<label class="label" for="tipo-select">ingrese el tipo de solicitud</label>
								<div class="control">
								<div class="select">
								<select name="tipo-select" id="tipo-select">
									<option>Solicitud de cedula de identidad</option>
									<option>Retiro de cedula de identidad</option>
									<option>Solicitud de certificado de nacimiento</option>
									<option>Solicitud de certificado de defuncion</option>
								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="card-footer">
					<div class="card-footer-item">
						<button  type="submit" class="button is-primary">filtrar</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
		<div class="columns is-centered">
			<div class="column is-7">
				<table class="table is-hovered is-bordered is-fullwidth">
					<thead class="has-background-primary">
						<tr>
							<th>Nro de atencion</th>
							<th>Nombre del cliente</th>
							<th>Tipo de solicitud</th>
							<th>(boton atender)</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cliente" items="${clientes}">
							<tr>
								<td></td>
								<td>${cliente.nombre}</td>
								<td>${cliente.tipo_solicitud}</td>
								<td>
									<a href="VerClienteController.do?nombreEliminar=${cliente.nombre}" class="button has-text-primary">Atender</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</main>
	</body>
	</html>