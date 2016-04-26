<%-- 
    Document   : cadastrarProduto
    Created on : 18/04/2016, 20:19:07
    Author     : Isaque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../_css/estilo-menu.css" rel="stylesheet"/>
        <link href="../_css/estilo-formulario.css" rel="stylesheet"/>
        <script src="../_js/home-menu.js" type="text/javascript"></script>
        <script src="../_js/formatoJS.js" type="text/javascript"></script>
        
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"/>
        <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.blue_grey-light_blue.min.css" />  

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
        <script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>
        <script src="../_js/formatoJS.js" type="text/javascript"></script>
        <title>5aBlack - Cadastrar Produto</title>
    </head>
    <body>
        
        <%-- AQUI EU ESTOU CHAMANDO O MENU NESTA PAGINA --%>
        <jsp:include page="../menu.jsp" />  
        
      <main id="main-layout" class="mdl-layout__content">
          <div class="produto" id="container">
        <form action="NovoProdutoServlet" method="post" accept-charset="UTF-8">
            <fieldset id="produto"> 
                <legend><h4>Cadastrar Produto</h4></legend>
                    <div class="campo nome mdl-textfield mdl-js-textfield">
                        <label class="mdl-textfield__label" for="nome">Nome</label>
                        <input type="text" class="mdl-textfield__input" name="nome" for="pNome" id="pNome"/>
                    </div>
            </fieldset>
            
            <button type="submit" id="inserir" class="mdl-button mdl-js-button mdl-js-ripple-effect">Cadastrar</button>

        </form>
        </div> 
      </main>
       <%--
       
       AQUI A GENTE VAI GERAR A LISTA DE PEDIDOS COM O ID INDICADO!!
        <c:forEach items="${lista}" var="pessoa">
        <h1>${pessoa.nome}</h1>
        <p>id: ${pessoa.id}</p>
        <p>e-mail: ${pessoa.email}</p>
        <p>Telefone: ${pessoa.telefone}</p>
        <p>Data Nascimento: <fmt:formatDate value="${pessoa.dtNascimento}" pattern="dd/MM/yyyy" /></p>
        </c:forEach>
       
       --%>
       
    </body>
</html>