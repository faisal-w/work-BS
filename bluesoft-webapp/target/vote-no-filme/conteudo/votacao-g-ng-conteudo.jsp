<!-- 
    Autor: Thiago Daher (tdahers@gmail.com)
 -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<p>
	<c:choose>
			<c:when test="${empty sessionScope.filmes}">
				<div id="msgInfo">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Filmes não liberados para votação.
				</div>	
			</c:when>
			<c:otherwise>
		
		    <div dojoType="dijit.form.Form" id="myFormV" encType="multipart/form-data" method=""> 
		    	
		    	<table cellspacing="6" cellpadding="0" border="0">
		                <thead>
		                  <tr>
		                    <th></th>
		                  </tr>
		                </thead>
		                
		          <tbody>  
		                  	<c:forEach begin="0" end="${fn:length(sessionScope.filmes)}" step="3" varStatus="loop" items="${sessionScope.filmes}">
			                  <tr>
			                  	<td width="192px;">
			                  		<c:if test="${not empty sessionScope.filmes[loop.index].id}"> 
					                  		<img src="../images/imagem-filme-II.jpg"/><br/>
					                  		<input type="radio" name="filmeEscolhido" value="${sessionScope.filmes[loop.index].filmeNome}" id="${sessionScope.filmes[loop.index].filmeNome}" onclick="dialogConfirmacao('${sessionScope.filmes[loop.index].id}', '${sessionScope.filmes[loop.index].filmeNome}');"/><b>${sessionScope.filmes[loop.index].filmeNome}</b><br/>
							               	<a href="#" onclick="sendGNG('${sessionScope.filmes[loop.index].id}','gostar')"><img src="../images/good-mark.bmp"/></a> ${sessionScope.filmes[loop.index].gostar}
						                    <a href="#" onclick="sendGNG('${sessionScope.filmes[loop.index].id}','naoGostar')"><img src="../images/bad-mark.bmp"/></a> ${sessionScope.filmes[loop.index].naoGostar}
					                  </c:if>
				                </td>
				                 <td width="192px;">
			                  		<c:if test="${not empty sessionScope.filmes[loop.index+1].id}"> 
					                  		<img src="../images/imagem-filme-II.jpg"/><br/>
					                  		<input type="radio" name="filmeEscolhido" value="${sessionScope.filmes[loop.index+1].filmeNome}" id="${sessionScope.filmes[loop.index+1].filmeNome}" onclick="dialogConfirmacao('${sessionScope.filmes[loop.index+1].id}', '${sessionScope.filmes[loop.index+1].filmeNome}');"/><b>${sessionScope.filmes[loop.index+1].filmeNome}</b><br/>
							                <a href="#" onclick="sendGNG('${sessionScope.filmes[loop.index+1].id}','gostar')"><img src="../images/good-mark.bmp"/></a> ${sessionScope.filmes[loop.index+1].gostar}
						                    <a href="#" onclick="sendGNG('${sessionScope.filmes[loop.index+1].id}','naoGostar')"><img src="../images/bad-mark.bmp"/></a> ${sessionScope.filmes[loop.index+1].naoGostar}
					                  </c:if>
				                 </td>
				                 <td width="192px;">
			                  		<c:if test="${not empty sessionScope.filmes[loop.index+2].id}"> 
					                  		<img src="../images/imagem-filme-II.jpg"/><br/>
					                  		<input type="radio" name="filmeEscolhido" value="${sessionScope.filmes[loop.index+2].filmeNome}" id="${sessionScope.filmes[loop.index+2].filmeNome}" onclick="dialogConfirmacao('${sessionScope.filmes[loop.index+2].id}', '${sessionScope.filmes[loop.index+2].filmeNome}');"/><b>${sessionScope.filmes[loop.index+2].filmeNome}</b><br/>
							                <a href="#" onclick="sendGNG('${sessionScope.filmes[loop.index+2].id}','gostar')"><img src="../images/good-mark.bmp"/></a> ${sessionScope.filmes[loop.index+2].gostar}
						                    <a href="#" onclick="sendGNG('${sessionScope.filmes[loop.index+2].id}','naoGostar')"><img src="../images/bad-mark.bmp"/></a> ${sessionScope.filmes[loop.index+2].naoGostar}
					                  </c:if>
				                 </td>  
				               </tr>   		
			            	 </c:forEach>
			       </tbody>      
		             
		              </table>
		    </div>
		              
		       </c:otherwise>
		</c:choose>	
		
	
				
</p>		 