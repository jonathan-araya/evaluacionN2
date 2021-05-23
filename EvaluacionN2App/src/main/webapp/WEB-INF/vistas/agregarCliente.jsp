<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header.jsp"></jsp:include>
	<main class="container mt-7">
	
		
		<c:if test="${errores != null}">
			<div class="columns is-centered mt-5">
				<div class="column is-5">
					<div class="notification is-danger">
						<p>Existen errores en el formulario</p>
						<div class="content">
							<ul>
								<c:forEach var="error" items="${errores}">
									<li>${error}</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		
		
		<div class="columns is-centered mt-5">
			<div class="column is-6">
				<form method="POST"action="AgregarClienteController.do">
					<div class="card">
						<div class="card-header has-background-primary">
							<span class="card-header-title">Ingreso de solicitud</span>
						</div>
						<div class="card-content">
							<div class="field">
								<label class="label" for="rut-txt">Ingrese su rut</label>
								<div class="control">
									<input type="text" class="input" id="rut-txt" name="rut-txt">
								</div>
							</div>
							<div class="field">
								<label class="label" for="nombre-txt">Ingrese su nombre y apellido</label>
								<div class="control">
									<input type="text" class="input" id="nombre-txt" name="nombre-txt">
								</div>
							</div>
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
								<button  type="submit" class="button is-primary">Ingresar solicitud</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</main>
</body>
</html>