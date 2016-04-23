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
        <script src="../_js/formatoJS.js" type="text/javascript"></script>
        <title>5aBlack - Cadastrar Cliente</title>
    </head>
    <body>
        
        <%-- AQUI EU ESTOU CHAMANDO O MENU NESTA PAGINA --%>
        <jsp:include page="../menu.jsp" />  
        
      
        <h1 id="t">Novo Cliente</h1>
        <form action="NovoClienteServlet" method="post" accept-charset="UTF-8">
            <fieldset id="cliente"> 
                <div class="cliente">
                    <div class="campo nome">
                        <label>Nome</label>
                        <input type="text" name="nome" for="pNome" id="pNome" placeholder=" NOME"/>
                        <input type="text" name="sobrenome" for="sNome" id="sNome" placeholder=" SOBRENOME"/>
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
                    <div class="campo endereco">
                        <label>Endereço</label>
                        <input type="text" name="rua" id="rua" for="rua" placeholder=" Enredeço"/>
                        <input type="number" name="nuemero" id="nuemero" for="nuemero" placeholder=" Numero" />
                        <input type="text" name="cidade" id="cidade" for="cidade" placeholder=" Cidade" />
                        <input type="estado" name="estado" id="estado" for="estado" placeholder=" Estado" />
                        <input type="text" name="cep" id="cep" for="cep" maxlength="9" placeholder=" CEP: ______-___" OnKeyPress="formatar('#####-###', this)" />
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
