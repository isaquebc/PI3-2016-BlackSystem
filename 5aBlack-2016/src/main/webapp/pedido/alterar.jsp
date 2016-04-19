<%-- 
    Document   : alterar
    Created on : 18/04/2016, 19:50:23
    Author     : Isaque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../_css/estilo-menu.css" rel="stylesheet"/>
        <link href="../_css/estilo-buscar.css" rel="stylesheet"/>
        <script src="../_js/home-menu.js" type="text/javascript"></script>
        <title>5aBlack - Buscar Pedido</title>
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
        <form action="BuscarPedidoServlet" method="post" accept-charset="UTF-8">
            <fieldset id="pesquisa"> 
                <div class="campo pesquisa">
                    <input type="number" for="campo-pesquisa" id="campo-pesquisa" placeholder="Digite o numero do pedido">
                    <input type="submit" value="Pesquisar"  />
                </div> 
                
            </fieldset>

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