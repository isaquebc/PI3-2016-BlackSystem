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
        <link href="../_css/estilo-menu.css" rel="stylesheet"/>
        <link href="../_css/estilo-formulario.css" rel="stylesheet"/>
        <script src="../_js/home-menu.js" type="text/javascript"></script>
        <title>5aBlack - Cadastrar Funcionario</title>
    </head>
    <body>
        <%-- COMEÇO do cabeçado--%>
        <div class="cabecalho">
            <div class="menu superior config" > 
                <div class="esconder menu">
                    <div class="pedido">
                        <div class="menu opcoes link" id="pedido">Pedido</div>
                        <div class="esconder menu-secundario">
                            <a href="../pedido/buscar.jsp"><div class="opcoes-secundarias link" id="buscarPedido">Buscar</div></a>
                            <a href="../pedido/gerar.jsp"><div class="opcoes-secundarias link" id="gerarPedido">Gerar</div></a>
                            <a href="../pedido/alterar.jsp"><div class="opcoes-secundarias link" id="alterarPedido">Alterar</div></a>
                            <a href="../pedido/invalidar.jsp"><div class="opcoes-secundarias link" id="alterarPedido">Invalidar</div></a>
                        </div>
                    </div>
                    <div class="funcionario">
                        <div class="menu opcoes link" id="funcionario">Funcionario</div>
                        <div class="esconder menu-secundario">
                            <a href="../funcionario/cadastrar.jsp"><div class="opcoes-secundarias link" id="cadastrarFuncionario">Cadastrar</div></a>
                            <a href="../funcionario/alterar.jsp"><div class="opcoes-secundarias link" id="alterarFuncionario">Alterar</div></a>
                            <a href="../funcionario/invalidar.jsp"><div class="opcoes-secundarias link" id="invalidarFuncionario">Invalidar</div></a>
                        </div>
                    </div>
                    <div class="servicoProduto">
                        <div class="menu opcoes link" id="servicoProduto">Serviço/Produto</div>
                        <div class="esconder menu-secundario">
                            <a href="../servicoProduto/cadastrarServico.jsp"><div class="opcoes-secundarias link" id="cadastrarServico">Cadastar Serviço</div></a>
                            <a href="../servicoProduto/alterarServico.jsp"><div class="opcoes-secundarias link" id="alterarServico">Alterar Serviço</div></a>
                            <div class="opcoes-secundarias link" id="emBranco"></div>
                            <a href="../servicoProduto/cadastrarProduto.jsp"><div class="opcoes-secundarias link" id="cadastrarProduto">Cadastar Produto</div></a>
                            <a href="../servicoProduto/alterarProduto.jsp"><div class="opcoes-secundarias link" id="alterarProduto">Alterar Produto</div></a>
                        </div>
                    </div>
                    <div class="cliente">
                        <div class="menu opcoes link" id="cliente">Cliente</div>
                        <div class="esconder menu-secundario">
                            <a href="../cliente/buscar.jsp"><div class="opcoes-secundarias link" id="buscarCliente">Buscar</div></a>
                            <a href="../cliente/cadastrar.jsp"><div class="opcoes-secundarias link" id="cadastrarCliente">Cadastrar</div></a>
                            <a href="../cliente/alterar.jsp"><div class="opcoes-secundarias link" id="alterarcliente">Alterar</div></a>
                        </div>
                    </div>
                    <div class="relatorio">
                        <a href="../relatorio/gerar.jsp"><div class="menu opcoes link" id="relatorio">Relatório</div></a>
                    </div>
                    <div class="chamado">
                        <div class="menu opcoes link" id="chamado">Chamado</div>
                        <div class="esconder menu-secundario">
                            <a href="../chamado/abrir.jsp"><div class="opcoes-secundarias link" id="abrirChamado">Abrir</div></a>
                            <a href="../chamado/acompanhar.jsp"><div class="opcoes-secundarias link" id="acompanharChamado">Acompanhar</div></a>
                            <a href="../chamado/fechar.jsp"><div class="opcoes-secundarias link" id="fecharChamado">Fechar</div></a>
                        </div>
                    </div>

                </div>
                <img class="link" id="config" src="../_img/icone-configuracoes.png"/> 
            </div>

            <div class="menu superior logo"> <img id="logo" src="../_img/logotipo-pequeno.png">5aBlack</div>
            <div class="menu superior help">Help</div>
        </div>
        <%-- FIM do cabeçado--%>   

        <h1 id="t">Novo Funcionario</h1>
        <form action="NovoFuncionarioServlet" method="post" accept-charset="UTF-8">
            <fieldset id="funcionario"> 
                <div class="funcionario">
                    <div class="campo nome">
                        <label>Nome</label>
                        <input type="text" name="nome" for="pNome" id="pNome" placeholder=" NOME"/>
                        <input type="text" name="sobrenome" for="sNome" id="sNome" placeholder=" SOBRENOME"/>
                    </div>
                    <div class="campo cargo">
                        <label>Cargo</label>
                        <select name="cargo" id="cargo">
                            <option value="">Selecione</option>
                            <option value="backoffice">Backoffice</option>
                            <option value="atendimento">Atendimento</option>
                            <option value="suporteTecnico">Suporte Técnico</option>
                            <option value="gerenteTI">Gerente de TI</option>
                            <option value="gerenteAtendimento">Gerente de Atendimento</option>
                            <option value="gerenteProduto">Gerente de Produto</option>
                            <option value="diretor">Diretor</option>
                        </select>
                    </div>
                    <div class="campo telefone">
                        <label>Telefone</label>
                        <input type="text" name="tel" maxlength="12" OnKeyPress="formatar('##-####-####', this)" placeholder=" (__) ____-____" />
                    </div>
                    <div class="campo celular">
                        <label>Celular</label>
                        <input type="text" name="cel" maxlength="12" OnKeyPress="formatar('##-#####-####', this)" placeholder=" (__) _____-____" />
                    </div>
                    <div class="campo cpf">
                        <label>CPF</label>
                        <input type="text" name="cpf" maxlength="14" OnKeyPress="formatar('###.###.###-##', this)" placeholder=" ___.___.___-__" />
                    </div>
                    <div class="campo email">
                        <label>E-mail</label>
                        <input type="text" name="email" id="e-mail" for="email" placeholder=" ________@_____.com"/>
                    </div>
                    <div class="campo filial">
                        <label>Filial de trabalho</label>
                        <select name="filial" id="filial">
                            <option value="">Selecione</option>
                            <option value="santos">Santos</option>
                            <option value="sao-paulo">São Paulo</option>
                            <option value="minas-gerais">Minas Gerais</option>
                            <option value="rio-de-janeiro">Rio de Janeiro</option>
                        </select>
                    </div>
                    <div class="campo data-entrada">
                        <label>Data de entrada na empresa</label>
                        <input type="date" name="data-entrada" id="data-entrada" for="data-entrada"/>
                    </div>
                    <div class="campo salario">
                        <label>Sarario R$</label>
                        <input type="number" name="salario" id="salario" for="salario"/>
                    </div>
                    <div class="campo Senha">
                        <label>Senha</label>
                        <input type="password" name="senha" id="senha" for="senha"/>
                    </div>
                    
                </div> 

            </fieldset>
            <input type="submit" value="Inserir" id="inserir"/>

        </form>

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