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

		require(["dojo/parser", "dijit/form/Form", "dijit/form/Button", "dijit/form/ValidationTextBox", "dijit/Dialog"]);
	
		function init() {
				
			var filmeNome = new dijit.form.ValidationTextBox({
            	name: "filmeNome",
            	style: "width:300px;",
            	maxLength: 100,
            	required: true
		   }, dojo.byId("filmeNome"));
			
			
			dojo.parser.parse();
		}
		dojo.addOnLoad(init);
	
	//Funcao generica para ser usada nas acoes de controle do filme.	
	function controleGenerico(data, target, url, form){
			
			// Configurando informacoes
		    var configurar = {
		      url: url,
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
		    dojo.byId("response").innerHTML = "<b> - ação realizada com sucesso!</b>";
		    dojo.xhrPost(configurar);
		    form.reset();
	};
	
	function sendForm(){
		
		//Valida form
		if (!dijit.byId("myForm").validate()){
			return false;
		}else{
			// Dados para atualiar.
			var data = {filmeNome: dojo.trim(dojo.byId("filmeNome").value), filmeId: dojo.byId("editarFilmeId").value};
			// Altera o conteudo atualizado
			var target = dojo.byId("filme");
			// Url
			var url = "${pageContext.request.contextPath}/vote/novoFilmeAction.action";
			// Form
			var form = dojo.byId("myForm");
			//Envia os dados
			controleGenerico(data, target, url, form);
			//Limpa o id para editar o nome do filme
			dojo.byId("editarFilmeId").value = "";
		}
	};
	
	function excluir(id, filmeNome){
		
		myDialog = new dijit.Dialog({
			title: "Confirmação",
			content:"<br/>Você deseja excluir o filme: <font color='#AA0000'><b>"+filmeNome+"</b></font> <br/><br/> " 
						+ " <button data-dojo-type=\"dijit/form/Button\" onClick=\"confirmarExclusao("+id+",'SIM');\" type=\"button\">Sim</button>"
						+ " <button data-dojo-type=\"dijit/form/Button\" onClick=\"confirmarExclusao("+id+",'NAO');\" type=\"button\">Não</button>"
		});
		myDialog.show();
	}
	
	function confirmarExclusao(id, tipoConfirmacao){
		
		if (tipoConfirmacao == "SIM"){
			executarExclusao(id);
			myDialog.hide();
		}else{
			myDialog.hide();
		}
		//Reset Form
		dijit.byId("myForm").reset();
	}
	
	function executarExclusao(id){
			// Dados para atualiar.
			var data = {filmeId: id};
			// Altera o conteudo atualizado
			var target = dojo.byId("filme");
			// Url
			var url = "${pageContext.request.contextPath}/vote/excluirFilmeAction.action";
			// Form
			var form = dojo.byId("myForm");
			//Envia os dados
			controleGenerico(data, target, url, form);
	};
	
	function editar(id, filmeNome){
		dojo.byId("editarFilmeId").value = id;
		dojo.byId("filmeNome").value = filmeNome;
	}	
	
	
	</script>

</head>
<body>

	<div class="wrap">
		<div class="col">
		</div>
			
			<div class="col">
				<h3>Cadastr<span class="red">ando</span> <span id="response"></span></h3>
				
				<div dojoType="dijit.form.Form" id="myForm" encType="multipart/form-data" method="">
						 <table class="ibm-data-table-simpleForm">
						    <tr align="center">
						    	<td colspan="2"></td>
						    </tr>
						    <tr >
						        <td >Nome:</td>
						        <td><div id="filmeNome"></div></td>
						    </tr>
						    <tr>
						    	<td></td>
						    	<td><input type="button" onclick="sendForm();" title="Confirmar" value="Confirmar" name="Confirmar"/></td>
						    </tr>
						</table>
						
						<!-- Ajuda na edicao do nome do filme -->
						<input type="hidden" id="editarFilmeId">
			    </div>	
			    
			    <div id="filme">
					<%@include file="/conteudo/filme-conteudo.jsp" %>
				</div>		
					
			</div>
			
		<div class="col last">
		</div>
	</div>
	
</body>
</html>

