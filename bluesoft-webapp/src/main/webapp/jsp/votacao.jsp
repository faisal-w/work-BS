<!-- 
    Autor: Thiago Daher (tdahers@gmail.com)
 -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<html>
<head>
	<link href="../css/main.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript">
		require(["dojo/parser", "dijit/form/Form", "dijit/form/RadioButton", "dijit/Dialog", "dijit/form/Button", "dijit/layout/ContentPane"]);
		
		function init() {
			
			//dojo.parser.parse();
 		   
		}
		dojo.addOnLoad(init);
		
		function dialogConfirmacao(id, filmeNome){
			myDialog = new dijit.Dialog({
				title: "Confirmação",
				content:"<br/>Você escolheu o filme: <font color='#AA0000'><b>"+filmeNome+"</b></font> <br/> " 
							+"<br/>Pode votar quantas vezes quiser.<br/> "
							+"<br/>Confirmar Voto? <br/><br/> "
							+ " <button data-dojo-type=\"dijit/form/Button\" onClick=\"confirmarVoto("+id+",'SIM');\" type=\"button\">Sim</button>"
							+ " <button data-dojo-type=\"dijit/form/Button\" onClick=\"confirmarVoto("+id+",'NAO');\" type=\"button\">Não</button>"
			});
			myDialog.show();
		}
		
		function confirmarVoto(id, tipoConfirmacao){
			
			if (tipoConfirmacao == "SIM"){
				computarVoto(id);
				myDialog.hide();
				limpaCheckbox();
			}else{
				myDialog.hide();
				//Reset Form e limpa mensagem
				dojo.byId("votoResp").innerHTML = "";
				limpaCheckbox();
			}
		}
		
		function computarVoto(id){
					
					// Dados para atualiar.
					var data = {filmeId: id, quantidade: 50};
					// Configurando informacoes
					var xhrArgs = {
					  url: "${pageContext.request.contextPath}/vote/computarVotoAction.action",
				      content: data,
				      handleAs: "text"
				    }
					// Chamada asynchronous
				    dojo.xhrPost(xhrArgs);
					//Reset Form
				    // Chamada asynchronous
					dojo.byId("votoResp").innerHTML = "<b> - voto computado!</b>";
					dijit.byId("myFormV").reset();
					
				}
		
		
		function sendGNG(id, tipo){
			
			//Trabalha com reload de content.
			//var cp = dijit.byId("votacoGNG");
			//var url = "${pageContext.request.contextPath}/vote/gostarNaoGostarFilmeAction.action";
			//cp.set("href", url+ "?filmeId="+id+"&tipo="+tipo);
			//dojo.byId("votoResp").innerHTML = "";
			//dojoType="dijit/layout/ContentPane"
			
			// Dados para atualiar.
			var data = {filmeId: id, tipo: tipo};
			// Target
			var target = dojo.byId("votacoGNG");
			// Configurando informacoes
			var xhrArgs = {
			  url: "${pageContext.request.contextPath}/vote/gostarNaoGostarFilmeAction.action",
		      content: data,
		      handleAs: "text",
		      load: function(data){
			        dojo.byId(target).innerHTML = data;
			      },
			  error: function(error){
			        dojo.byId(target).innerHTML = error;
			      }
		    }
			// Chamada asynchronous
		    dojo.xhrPost(xhrArgs);
			dojo.byId("votoResp").innerHTML = "";
		}
		
		function limpaCheckbox(){
			for(var i=0; i<document.getElementsByName("filmeEscolhido").length; i++) {
				document.getElementsByName("filmeEscolhido")[i].checked = false;
			}
		}
	</script>	
		
</head>
<body>
	<div class="wrap">
		<div class="col">
		</div>
			
			<div class="col">
				<h3>Vota<span class="red">ndo</span> <span id="votoResp"></span></h3>
				
					<div id="votacoGNG" >
						<%@include file="/conteudo/votacao-g-ng-conteudo.jsp" %> 
					</div>
			</div>
		
		<div class="col last">
		</div>
	</div>
</body>
</html>

