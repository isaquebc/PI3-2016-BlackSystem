<%-- 
    Document   : cadastrar
    Created on : 18/04/2016, 20:20:04
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
        <title>5aBlack - Cadastrar Cliente</title>
    </head>
    <body>

        <%-- AQUI EU ESTOU CHAMANDO O MENU NESTA PAGINA --%>
        <jsp:include page="../menu.jsp" />  

        <main id="main-layout" class="mdl-layout__content linha-unica" >
            <div class="cliente" id="container">

                <form action="NovoClienteServlet" method="post" accept-charset="UTF-8">
                    <fieldset id="cliente"> 
                        <legend><h4>Novo Cliente</h4></legend>
                        <div class="campo-nome mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label" for="nome">Nome</label>
                            <input type="text" class="mdl-textfield__input" name="nome" for="pNome" id="pNome"/>
                        </div>
                        <div class="campo-sobrenome mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label" for="sobrenome">Sobrenome</label>
                            <input type="text" class="mdl-textfield__input" name="sobrenome" for="sNome" id="sNome" />
                        </div>
                        <div class="campo telefone mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label">Telefone</label>
                            <input type="text" class="mdl-textfield__input" name="tel" maxlength="12" OnKeyPress="formatar('##-####-####', this)" />
                        </div>
                        <div class="campo celular mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label">Celular</label>
                            <input type="text" class="mdl-textfield__input" name="cel" maxlength="12" OnKeyPress="formatar('##-#####-####', this)" />
                        </div>
                        <div class="campo cpf mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label">CPF</label>
                            <input type="text" class="mdl-textfield__input" name="cpf" maxlength="14" OnKeyPress="formatar('###.###.###-##', this)" />
                        </div>
                        <div class="campo email mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label" for="email">E-mail</label>
                            <input type="text" class="mdl-textfield__input" name="email" id="e-mail" for="email" />
                        </div>
                        <div class="campos enderecos linha-unica">
                            <div class="campo endereco mdl-textfield mdl-js-textfield">
                                <label class="mdl-textfield__label" for="endereco">Endereço</label>
                                <input type="text" class="mdl-textfield__input" name="rua" id="rua" for="rua"/>
                            </div>
                            <div class="campo endereco mdl-textfield mdl-js-textfield">
                                <label class="mdl-textfield__label" for="endereco">Numero</label>
                                <input type="number" class="mdl-textfield__input" name="nuemero" id="nuemero" for="nuemero"/>
                            </div>
                            <div class="campo endereco mdl-textfield mdl-js-textfield">
                                <label class="mdl-textfield__label" for="endereco">Cidade</label>
                                <input type="text" class="mdl-textfield__input" name="cidade" id="cidade" for="cidade"/>
                            </div>
                            <div class="campo endereco mdl-textfield mdl-js-textfield">
                                <label class="mdl-textfield__label" for="endereco">Estado</label>
                                <input type="estado" class="mdl-textfield__input" name="estado" id="estado" for="estado"/>
                            </div>
                            <div class="campo endereco mdl-textfield mdl-js-textfield">
                                <label class="mdl-textfield__label" for="endereco">CEP</label>
                                <input type="text" class="mdl-textfield__input" name="cep" id="cep" for="cep" maxlength="9"OnKeyPress="formatar('#####-###', this)" />
                            </div>
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
