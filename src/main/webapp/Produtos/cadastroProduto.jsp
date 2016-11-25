<%-- 
    Document   : cadastroProduto
    Created on : 05/11/2016, 20:36:01
    Author     : Michael Facul
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Cadastro Produto</title>
    </head>
    <body> 
        <div class="cabecalho">
            <img src="../images/logo_1.png" width="75" height="71" alt=""/>            
        </div>
            <hr/>
                    <h2>Dados do Produto</h2>
                <form action ="../AdicionarProduto" method="get">
                    C�digo: <input type="text" size="40" name="codigo" />
                    Descri��o: <input type="text" size="60" name="descricao" /><br/><br/> 
                    Pre�o: <input type="float" placeholder="0.00" name="preco" />
                    Marca: <input type="text" size="40" name="marca" /><br/><br/>                     
                    Categoria: <select name="categoria"> 
                        <option value = "1">Teste</option>
                          </select>
                    Fornecedor: <select name="fornecedor">  
                        <option value = "1">Teste</option>
                          </select>
                    
                    <br/><br/><input type="submit" value="Gravar" />
                    <input type="reset" value="Limpar" />                    
                    <input type="button" value="Voltar" onClick="history.go(-1)"> 
                </form>
            </div>
        </aside>  
    </body>
</html>
