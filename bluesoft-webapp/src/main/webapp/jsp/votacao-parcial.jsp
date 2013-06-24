<!-- 
    Autor: Thiago Daher (tdahers@gmail.com)
 -->
<%@page import="org.apache.struts2.components.Include"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html>
<head>
	
	 <link href="../css/main.css" rel="stylesheet" type="text/css" /> 
	 <script language="JavaScript" src="../js/FusionCharts.js"></script>
	 
	 <script type="text/javascript">
	 </script>

</head>
<body>

	<div class="wrap">
		<div class="col">
		</div>
			
			<div class="col">
				<h3>Estatí<span class="red">stica</span></h3>
				
				<table cellspacing="6" cellpadding="0" border="0">
					<tr>
			            <td> 
			            	<%@include file="/conteudo/votacao-parcial-conteudo.jsp" %>
			            </td>
			         </tr>   
		        </table>

			</div>
		
		<div class="col last">
		</div>
	</div>

</body>
</html>

