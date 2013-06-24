<!-- 
    Autor: Thiago Daher (tdahers@gmail.com)
 -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">


<div id="ChartId" align="center">O gráfico irá ser carregado aqui.</div>

<script type="text/javascript">
    var myChartAT = new FusionCharts("../images/Bar2D.swf", "ChartId-BS2013", "400", "160", "0", "0");
    myChartAT.setDataXML("<chart caption='Filme(s) Votado(s)' yAxisName='' xAxisName='' bgColor='F1F1F1' showValues='1' canvasBorderThickness='1' canvasBorderColor='999999' "+ 
    		" plotFillAngle='110' plotBorderColor='999999' showAlternateVGridColor='1' divLineAlpha='0' > " +

    			<c:forEach items="${sessionScope.votoscomputados}" var="v">		
    			 "<set label='${v.filme.filmeNome}' value='${v.quantidade}'/>" +
    			</c:forEach> 	

    		"</chart>");

    myChartAT.setTransparent(false);
    myChartAT.render("ChartId");

</script>

<div id="ChartId"></div>
