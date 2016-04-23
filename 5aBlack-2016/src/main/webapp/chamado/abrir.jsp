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
        <title>5aBlack - Buscar Pedido</title>
    </head>
    <body>
        
        <%-- AQUI EU ESTOU CHAMANDO O MENU NESTA PAGINA --%>
        <jsp:include page="../menu.jsp" />  
        
      
        <h1 id="t">Novo Chamado</h1>
        <form action="NovoChamadoServlet" method="post" accept-charset="UTF-8">
            <fieldset id="chamado"> 
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
                    <div class="campo tipo-solicitacao">
                        <label>Tipo de Solicitação</label>
                        <select name="cargo" id="cargo">
                            <option value="">Selecione</option>
                            <option value="resetar-senha">Esqueci minha senha</option>
                            <option value="dado-incorreto">Dado incorreto</option>
                        </select>
                    </div>
                    <div class="campo descricao">
                        <label>Descrição</label>
                        <textarea name="descricao" form="dercricao" placeholder="Descreva o seu problema..."></textarea>
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
