<!-- 
    Autor: Thiago Daher (tdahers@gmail.com)
 -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<p>
	<c:choose>
			<c:when test="${empty sessionScope.filmes}">
				<div id="msgInfo">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Não há filmes cadastrados.
				</div>	
			</c:when>
			<c:otherwise>
		
		    <div dojoType="dijit.form.Form" id="myFormV" encType="multipart/form-data" method=""> 
		    	
		    	<table cellspacing="6" cellpadding="0" border="0">
		                <thead>
		                  <tr>
		                    <th>Filme</th>
		                    <th>Editar</th>
		                    <th>Excluir</th>
		                  </tr>
		                </thead>
		                
		          <tbody>  
		           		<c:forEach items="${sessionScope.filmes}" var="f">     
			                  <tr>
			                    <td> ${f.filmeNome}</td>
			                    <td> <a href="#" onclick="editar('${f.id}', '${f.filmeNome}')"><img src="../images/editar.bmp"></a> </td>
			                    <td> <a href="#" onclick="excluir('${f.id}', '${f.filmeNome}')"><img src="../images/excluir.bmp"></a> </td>
			                  </tr>
			             </c:forEach>
			       </tbody>      
		             
		              </table>
		    </div>
		              
		       </c:otherwise>
		</c:choose>
</p>		 