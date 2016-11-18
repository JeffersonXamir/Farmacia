<%-- 
    Document   : clienteAlterar
    Created on : 10/11/2016, 11:04:46
    Author     : Michael Facul
--%>

<%@page import="br.sp.senac.programeros.model.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="br.sp.senac.programeros.dao.ClienteDAO"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Cadastro de Clientes</title>
    </head>
    <body>
        <%
            ConexaoBD conn = new ConexaoBD();
            Connection conexao = conn.obterConexao();

            ClienteDAO dao = new ClienteDAO(conexao);

            Cliente cliente = dao.selecionar(Integer.parseInt(request.getParameter("id")));

            conn.fecharConexao();

        %>        
        <nav>
            <h1>Altera��o de Cliente</h1>
            <div class="imagem"></div>
        </nav>
        <aside>
            <div>

                <form action ="AlterarCliente" method="post">
                    <input type=hidden name="id" value="<%=cliente.getCodigo()%>" size="6" /><br/>                    
                    Nome: <input type="text" size="40" name="nome" value="<%=cliente.getNome()%>"/>
                    Endere�o: <input type="text" size="30" name="endereco" value="<%=cliente.getEndereco()%>"/><br/>
                    Bairro: <input type="text" name="bairro" value="<%=cliente.getBairro()%>"/>
                    Cidade: <input type="text" name="cidade" value="<%=cliente.getCidade()%>"/>
                    Estado: <input type="text" name="estado" value="<%=cliente.getEstado()%>"/><br/>
                    CEP: <input type="text" name="cep" value="<%=cliente.getCep()%>" />

                    Tel.: <input type="text" name="telefone" value="<%=cliente.getTelefone()%>"/>
                    Cel.: <input type="text" name="celular" value="<%=cliente.getCelular()%>"/><br/>                                                                      
                    Ativo: <select name="ativo" id="selectAtivo">
                        <option value = "1">Sim</option>
                        <option value = "2">N�o</option>
                        <script type="text/javascript">
                            var selected = document.getElementById("selectAtivo");
                            switch ("<%=cliente.getAtivo()%>") {
                                case '1':
                                    selected.selectedIndex = 0;
                                    break;
                                case '2':
                                    selected.selectedIndex = 1;
                                    break;
                            }
                        </script>                 
                    </select><br/><br/>

                    <input type="submit" value="Confirmar" />
                    <input type="reset" value="Limpar" />
                    <input type="button" value="Voltar" onClick="history.go(-1)"> 
                </form>
            </div>
        </aside>
    </body>
</html>