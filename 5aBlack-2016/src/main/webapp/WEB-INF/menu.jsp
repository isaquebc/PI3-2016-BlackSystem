<%-- 
    Document   : home
    Created on : 17/04/2016, 13:22:43
    Author     : Isaque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../_css/estilo-menu.css" rel="stylesheet"/>
        <script src="../_js/home-menu.js" type="text/javascript"></script>
        <title>5aBlack - Home</title>
    </head>
    <body>

        <div class="cabecalho">
            <div class="menu superior config" > 
                <div class="menu">
                    <div class="pedido">
                        <div class="menu opcoes link" id="pedido">Pedido</div>
                        <div class="esconder menu-secundario">
                            <a href="../pedido/Buscar-alterar-invalidar.jsp"><div class="opcoes-secundarias link" id="buscarPedido">Buscar/Alterar/Invalidar</div></a>
                            <a href="../pedido/Gerar.jsp"><div class="opcoes-secundarias link" id="gerarPedido">Gerar</div></a>
                        </div>
                    </div>
                    <div class="funcionario">
                        <div class="menu opcoes link" id="funcionario">Funcionario</div>
                        <div class="esconder menu-secundario">
                            <a href="../funcionario/Cadastrar.jsp"><div class="opcoes-secundarias link" id="cadastrarFuncionario">Cadastrar</div></a>
                            <a href="../funcionario/Alterar-invalidar.jsp"><div class="opcoes-secundarias link" id="alterarFuncionario">Alterar/Invalidar</div></a>
                        </div>
                    </div>
                    <div class="servicoProduto">
                        <div class="menu opcoes link" id="servicoProduto">Serviço/Produto</div>
                        <div class="esconder menu-secundario">
                            <a href="../servicoProduto/CadastrarServico.jsp"><div class="opcoes-secundarias link" id="cadastrarServico">Cadastar Serviço</div></a>
                            <a href="../servicoProduto/AlterarServico.jsp"><div class="opcoes-secundarias link" id="alterarServico">Alterar Serviço</div></a>
                            <div class="opcoes-secundarias" id="emBranco"></div>
                            <a href="../servicoProduto/CadastrarProduto.jsp"><div class="opcoes-secundarias link" id="cadastrarProduto">Cadastar Produto</div></a>
                            <a href="../servicoProduto/AlterarProduto.jsp"><div class="opcoes-secundarias link" id="alterarProduto">Alterar Produto</div></a>
                        </div>
                    </div>
                    <div class="cliente">
                        <div class="menu opcoes link" id="cliente">Cliente</div>
                        <div class="esconder menu-secundario">
                            <a href="../cliente/Buscar-alterar.jsp"><div class="opcoes-secundarias link" id="buscarCliente">Buscar/Alterar</div></a>
                            <a href="../cliente/Cadastrar.jsp"><div class="opcoes-secundarias link" id="cadastrarCliente">Cadastrar</div></a>
                        </div>
                    </div>
                    <div class="relatorio">
                        <div class="menu opcoes link" id="relatorio">Relatório</div>
                        <div class="esconder menu-secundario">
                            <a href="../relatorio/Gerar.jsp"><div class="opcoes-secundarias link" id="gerarRelatorio">Gerar</div></a>
                        </div>
                    </div>
                    <div class="chamado">
                        <div class="menu opcoes link" id="chamado">Chamado</div>
                        <div class="esconder menu-secundario">
                            <a href="../chamado/Abrir.jsp"><div class="opcoes-secundarias link" id="abrirChamado">Abrir</div></a>
                            <a href="../chamado/Acompanhar.jsp"><div class="opcoes-secundarias link" id="acompanharChamado">Acompanhar</div></a>
                            <a href="../chamado/Fechar.jsp"><div class="opcoes-secundarias link" id="fecharChamado">Fechar</div></a>
                        </div>
                    </div>

                </div>
            </div>
            <a href="../inicial/home.jsp"><div class="menu superior logo link"> <img id="logo" src="../_img/logotipo-pequeno.png">5aBlack</div></a>
            <div class="menu superior help">Help</div>
            <div class="menu-direita">
                <img  id="config" src="../_img/icone-configuracoes.png"/> 
                <div class="esconder menu">
                    <a class="link"><label id="perfil">Perfil</label></a>
                    <a class="link"><label id="alterar-senha">Alterar Senha</label></a>
                    <a class="link"><label id="sair">Sair</label></a>
                    
                </div>
            </div>
            <div id="l"> </div>
        </div>
    </body>
</html>
