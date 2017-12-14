
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>

    <c:import url="/fragments/metaLinks.jsp"></c:import>
    
    <title>Inicio</title>

</head>

 <body id="mimin" class="dashboard">
 
    <c:import url="/fragments/nav.jsp"/>
    
    <c:import url="/fragments/leftMenuAdmin.jsp"/>
    
    <div class="container-fluid mimin-wrapper">

        <!-- start: content -->
        <div id="content">
        
			<div class="panel box-shadow-none content-header">
				<div class="panel-body">
					<div class="col-sm-12">
						<h3 class="animated fadeInLeft">${listaInscritos[1].nombre_curso}</h3>                    
					</div>
				</div>
			</div>
			
			<div class="col-md-12 top-20 padding-0">
				<div class="col-md-12">
					<div class="panel">
						<div class="panel-heading">
							<h3>Inscritos</h3>
						</div>
						
						<div class="panel-body">
							<div class="responsive-table">
								<div id="datatables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
									<div class="row">
										<div class="col-sm-12">
										<form:form action="ver-inscritos.do" method="post" modelAttribute="evento">
											<table id="datatables-example" class="table table-striped table-bordered dataTable no-footer" role="grid" aria-describedby="datatables-example_info" style="width: 100%;">
												<thead>
													<tr role="row">
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Nombre del Alumno
														</th>
														<!-- <th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Instructor
														</th> -->
														<!-- <th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Curso
														</th> --> 
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Apellido Paterno
														</th>
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Apellido Materno
														</th>
														
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															
														</th>
														<!-- <th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															
														</th>
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															
														</th> -->
														
													</tr>
												</thead>
												<tbody>
													<c:if test="${not empty listaInscritos}">
														<c:forEach items="${listaInscritos}" var="Inscripcion">
															<tr>
																<td style="text-align: center;">${Inscripcion.nombre}</td>
																<td style="text-align: center;">${Inscripcion.apellido_paterno}</td>
																<td style="text-align: center;">${Inscripcion.apellido_materno}</td>
																
																<%-- <td style="text-align: center;">${Inscripcion.id_inscripcion}</td> --%>
																<%-- <td style="text-align: center;">${Evento.fecha_inicio}</td>
																<td style="text-align: center;">${Evento.fecha_fin}</td>
																<td style="text-align: center;">${Evento.nombre_curso}</td> --%>
																<c:if test="${Inscripcion.id_examen == 0}">
																<td style="text-align: center;"><button class="btn btn-danger" disabled>Examen no asignado</button></td>
 																</c:if>
 																<c:if test="${Inscripcion.id_examen != 0}">
 																<td style="text-align: center;"><form:button path="id" class="btn btn-info" name="detallesListaEvento" value="${Inscripcion.id_inscripcion }">Ver Detalles</form:button></td>
 																
 																</c:if>
 																<%-- <td style="text-align: center;"><button class="btn btn-warning" name="modificarEvento" value="${Evento.id_evento }">Modificar</button></td>
																<td style="text-align: center;"><button class="btn btn-danger" name="eliminarEvento" value="${Evento.id_evento }">Eliminar</button></td> --%>
																
																
																
															</tr>
														</c:forEach>
													</c:if>		
												</tbody>
											</table>
											<c:if test="${listaInscritos[0].id_examen == 0}">
											
											<p style="color: white;">.</p>
											<div class="col-md-11" style="text-align: center;">
											<h3>Asignar examen</h3></div>
											
											
											
											</c:if>
											</form:form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">

	function listarEventos(){
		document.forms["form"].action = "<%=request.getContextPath()%>/listar-evento.do";
		document.forms["form"].submit();
 	}
	
	function verInscripciones(){
		document.forms["form"].action = "<%=request.getContextPath()%>/listar-inscripciones.do";
		document.forms["form"].submit();
	}
</script>

<script>

function eliminarEvento(){
	alert("Se va a eliminar un evento");
	document.forms["formaLista"].action = "<%=request.getContextPath()%>/listar-evento.do?opcion=verListadoEventos";
	document.forms["formaLista"].submit();
}

</script>

<script type="text/javascript">
window.onload = function(){
    var activarMenu = 'menu-paises';
    var respuesta = '${respuesta}';
    
    document.getElementById(activarMenu).className = 'active ripple';
    
    if (respuesta != null && respuesta != ""){
        alert(respuesta);
    }
};
</script>

<c:import url="/fragments/scripts.jsp"/>

</html>