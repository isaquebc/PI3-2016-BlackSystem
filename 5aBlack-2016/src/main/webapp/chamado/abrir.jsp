<%-- 
    Document   : abrir
    Created on : 18/04/2016, 20:21:00
    Author     : Isaque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../_css/estilo-formulario.css" rel="stylesheet"/>
        
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"/>
        <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.blue_grey-light_blue.min.css" />  

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
        <script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>
        <script src="../_js/formatoJS.js" type="text/javascript"></script>
        <title>5aBlack - Buscar Pedido</title>
    </head>
    <body>
        
        <%-- AQUI EU ESTOU CHAMANDO O MENU NESTA PAGINA --%>
        <jsp:include page="../menu.jsp" />  
        
      <main id="main-layout" class="mdl-layout__content linha-unica" >
          <div id="container">
        <form action="NovoChamadoServlet" method="post" accept-charset="UTF-8">
            <fieldset id="chamado"> 
                <legend><h4>Abrir Chamado</h4></legend>
                    <div class="campo filial mdl-textfield mdl-js-textfield">
                        <label class="mdl-textfield__label" for="filial">Filial de trabalho</label>
                        <select class="mdl-textfield__input" name="filial" id="filial">
                            <option value=""></option>
                            <option value="santos">Santos</option>
                            <option value="sao-paulo">São Paulo</option>
                            <option value="minas-gerais">Minas Gerais</option>
                            <option value="rio-de-janeiro">Rio de Janeiro</option>
                        </select>
                    </div>
                    <div class="campo tipo-solicitacao mdl-textfield mdl-js-textfield">
                        <label class="mdl-textfield__label" for="solicitacao">Tipo de Solicitação</label>
                        <select class="mdl-textfield__input" name="solicitacao" id="solicitacao">
                            <option value=""></option>
                            <option value="resetar-senha">Esqueci minha senha</option>
                            <option value="dado-incorreto">Dado incorreto</option>
                        </select>
                    </div>
                    <div class="campo descricao mdl-textfield mdl-js-textfield">
                        <label class="mdl-textfield__label" for="descricao">Descrição do problema</label>
                        <textarea name="descricao" class="mdl-textfield__input" form="dercricao"/></textarea>
                    </div>                    
            </fieldset>
            <button type="submit" id="inserir" class="mdl-button mdl-js-button mdl-js-ripple-effect">Abrir</button>

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
