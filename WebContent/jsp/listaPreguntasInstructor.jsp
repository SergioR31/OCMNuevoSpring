
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
                        <h3 class="animated fadeInLeft">Ver Preguntas</h3>                    
                    </div>
                </div>
            </div>
			
			<div class="col-md-12 top-20 padding-0">
				<div class="col-md-12">
					<div class="panel">
						<div class="panel-heading">
							<h3>Preguntas</h3>
						</div>
						
						<div class="panel-body">
							<div class="responsive-table">
								<div id="datatables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
									<div class="row">
										<div class="col-sm-12">
										
										<form:form action="lista-preguntas-instructor.do" method="post" modelAttribute="pregunta">
										
													<c:if test="${not empty listaPreguntas}">
														<c:forEach items="${listaPreguntas}" var="Pregunta">
																${Pregunta.id_pregunta}<form path="id_pregunta" id="idPregunta"></form>
																${Pregunta.pregunta}<br><br>
														
																
 																
 																															
														</c:forEach>
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