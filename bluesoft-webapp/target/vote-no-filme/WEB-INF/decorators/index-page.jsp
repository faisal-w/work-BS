<!-- 
	Decorator
    Autor: Thiago Daher (tdahers@gmail.com)
 -->
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><decorator:title default=":: Bluesoft | Vote no Filme ::"/></title>
	
	<!-- DOJO --> 
	<script type="text/javascript">
		dojoConfig = {
			async: true,
			locale: 'pt-br',
            cdn: "//ajax.googleapis.com/ajax/libs/dojo/1.9.0/",
			deps: ["docs/wiki"],
		}
	</script>
	
	<link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/dojo/1.9.0/dijit/themes/claro/claro.css"/>
	
	<script>dojoConfig = {parseOnLoad: true}</script>
	<script src='//ajax.googleapis.com/ajax/libs/dojo/1.9.0/dojo/dojo.js'></script>
		
	<!-- JS -->

	<!-- CSS -->
	
	<!-- Head -->
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="description" content="Web Application" />
	<meta name="keywords" content="web, application" />
	<decorator:head/>

</head>

<body class="claro" <decorator:getProperty property="body.onload" writeEntireProperty="true"/> >
	<div id="header">
		<h1><a href="${pageContext.request.contextPath}">Vote no Filme</a></h1>
	</div>

	<div id="teaser">
		<div class="wrap">
			<div id="image"></div>
			<div class="box">
				<h2> <em title="Sharing, Data Management and Collaboration">Bem-Vindo</em></h2>
				<p>Além de poder votar no filme é possível marcar se você gostou do mesmo ou não, basta apenas clicar sobre o ícone em verde(gostou), veremlho(não gostou).<br/>
				   Para cada voto, será atribuído 50 "votos".
				</p>
			</div>
		</div>
	</div>

	<div id="bar">
		<div class="wrap">
			<span class="step"><a href="${pageContext.request.contextPath}/vote/iniciandoFilmeAction.action">1</a> Controle do(s) Filme(s)</span>
			<span class="step"><a href="${pageContext.request.contextPath}/vote/iniciandoVotacaoAction.action">2</a> Votação</span>
			<span class="step"><a href="${pageContext.request.contextPath}/vote/resultadoParcialAction.action">3</a> Resultado Parcial</span>
		</div>
	</div>
	
	    	<!-- Conteudo -->
	    	<decorator:body />
	    	
</body>
</html>