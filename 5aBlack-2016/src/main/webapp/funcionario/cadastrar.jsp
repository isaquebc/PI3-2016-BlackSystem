<%-- 
    Document   : cadastrar
    Created on : 18/04/2016, 20:17:20
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
        <title>5aBlack - Cadastrar Funcionario</title>
    </head>
    <body>

        <%-- AQUI EU ESTOU CHAMANDO O MENU NESTA PAGINA --%>

        <jsp:include page="../menu.jsp" />  

        <main id="main-layout" class="mdl-layout__content">

            <div class="funcionario" id="container">
                <form action="NovoFuncionarioServlet" method="post" accept-charset="UTF-8">
                    <fieldset id="funcionario"> 
                        <legend><h4>Novo Funcionario</h4></legend>
                        <div class="campo-nome mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label" for="nome">Nome</label>
                            <input type="text" class="mdl-textfield__input" name="nome" for="pNome" id="pNome"/>
                        </div>
                        <div class="campo-sobrenome mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label" for="sobrenome">Sobrenome</label>
                            <input type="text" class="mdl-textfield__input" name="sobrenome" for="sNome" id="sNome" />
                        </div>
                        <div class="campo cargo mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label" for="cargo">Cargo</label>
                            <select class="mdl-textfield__input" name="cargo" id="cargo">
                                <option value=""></option>
                                <option value="backoffice">Backoffice</option>
                                <option value="atendimento">Atendimento</option>
                                <option value="suporteTecnico">Suporte Técnico</option>
                                <option value="gerenteTI">Gerente de TI</option>
                                <option value="gerenteAtendimento">Gerente de Atendimento</option>
                                <option value="gerenteProduto">Gerente de Produto</option>
                                <option value="diretor">Diretor</option>
                            </select>
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
                        <div class="campo filial mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label" for="filial">Filial de trabalho</label>
                            <select class="mdl-textfield__input" for="filial" name="filial" id="filial">
                                <option value=""></option>
                                <option value="santos">Santos</option>
                                <option value="sao-paulo">São Paulo</option>
                                <option value="minas-gerais">Minas Gerais</option>
                                <option value="rio-de-janeiro">Rio de Janeiro</option>
                            </select>
                        </div>
                        <div class="campo data-entrada mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label" for="data-entrada">Data de Contratação</label>
                            <input  type="date" class="mdl-textfield__input" name="data-entrada" id="data-entrada" for="data-entrada" />
                        </div>
                        <div class="campo salario mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label">Sarario R$</label>
                            <input type="number" class="mdl-textfield__input" name="salario" id="salario" for="salario"/>
                        </div>
                        <div class="campo Senha mdl-textfield mdl-js-textfield">
                            <label class="mdl-textfield__label" for="senha">Senha</label>
                            <input type="password" class="mdl-textfield__input" name="senha" id="senha" for="senha"/>
                        </div>



                    </fieldset>
                    <button type="submit" id="inserir" class="mdl-button mdl-js-button mdl-js-ripple-effect">Inserir</button>

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
