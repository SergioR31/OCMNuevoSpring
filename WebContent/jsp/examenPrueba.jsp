
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
    
    <title>examen</title>
    
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
                        <h3 class="animated fadeInLeft">Ver Eventos</h3>                    
                    </div>
                </div>
            </div>
			
			<div class="col-md-12 top-20 padding-0">
				<div class="col-md-12">
					<div class="panel">
						<div class="panel-heading">
                            <div style="position:absolute; right:30px; top:10px;">
                                <button class="btn btn-success" style="font-size:20px!important;" onclick="window.location.href='<%=request.getContextPath()%>/crear-evento.do?opcion=inicioAltaEvento'">+</button>
                            </div>
							<h3>Examen</h3>
						</div>
						
						<div class="panel-body">
							<div class="responsive-table">
								<div id="datatables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
									<div class="row">
										<div class="col-sm-12">
										<form:form action="ver-inscritos.do" method="post" modelAttribute="pregunta">
											<table id="datatables-example" class="table table-striped table-bordered dataTable no-footer" role="grid" aria-describedby="datatables-example_info" style="width: 100%;">
												<thead>
													<tr role="row">
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 20px; text-align: center;">
															Nombre del evento
														</th>
														
													</tr>
												</thead>
												<tbody>
													<c:if test="${not empty listaPreguntas}">
														<c:forEach items="${listaPreguntas}" var="Pregunta">
														
															<tr>
																<td style="text-align: center;">${Pregunta.pregunta}<form:hidden path="id_pregunta" id="idPregunta"></form:hidden></td>
															
 																<td style="text-align: center;"><input type="button" class="btn btn-info" onclick="verListaInscripcionesInstructor(${Pregunta.pregunta})" name="detallesListaEvento" value="Ver Detalles"/></td>
 																
															</tr>
														</c:forEach>
													</c:if>		
												</tbody>
											</table>
											
											<td style="text-align: center;"><button class="btn btn-warning" name="modificarEvento" value="${Pregunta.pregunta}">Modificar</button></td>
																<td style="text-align: center;"><button class="btn btn-danger" name="eliminarEvento" value="${Pregunta.pregunta}">Eliminar</button></td>
											
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
	
	function verListaInscripcionesInstructor(id){
		document.getElementById("idEvento").value = id;
		document.forms[0].action = "<%=request.getContextPath()%>/instructor/ver-inscritos.do";
		document.forms[0].submit();
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