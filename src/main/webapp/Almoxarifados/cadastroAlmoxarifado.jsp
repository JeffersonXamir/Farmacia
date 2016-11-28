<%-- 
    Document   : cadastroAlmoxarifado
    Created on : 05/11/2016, 21:49:58
    Author     : Michael Facul
--%>

<%@page import="br.sp.senac.programeros.model.Filiais"%>
<%@page import="java.util.List"%>
<%@page import="br.sp.senac.programeros.dao.FilialDAO"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="br.sp.senac.programeros.connection.ConexaoBD"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>        
        <title>Cadastro Almoxarifado</title>
    </head>
    <body>
        <div class="cabecalho">
            <img src="../images/logo_1.png" width="75" height="71" alt=""/>            
        </div>
        <hr/> 
        <h2>Dados do Almoxarifado</h2>
        <form action ="../AdicionarAlmoxarifado" method="get">                    
            Descri��o: <input type="text" size="60" name="descricao" /><br/><br/>                    
            Filial: <select name="filial">  
                <option>Selecione a filial</option>
                <%
                    ConexaoBD conn = new ConexaoBD();
                    Connection conexao = conn.obterConexao();
                    FilialDAO dao = new FilialDAO(conexao);
                    List<Filiais> filiais = dao.listarFiliais();
                    conn.fecharConexao();
                    for (Filiais f : filiais) {
                %>
                <option value="<%=f.getCodigo()%>"><%=f.getNome()%></option>
                <%}%>
            </select><br/><br/>                                                                    
            <input type="submit" value="Gravar" />
            <input type="reset" value="Limpar" />                    
            <input type="button" value="Voltar" onClick="history.go(-1)"> 
        </form>                   
    </body>
</html>
