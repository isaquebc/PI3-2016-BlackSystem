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
        <title>5aBlack - Cadastrar Funcionario</title>
    </head>
    <body>
        
        <%-- AQUI EU ESTOU CHAMANDO O MENU NESTA PAGINA --%>
        <jsp:include page="../menu.jsp" />  
        

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
