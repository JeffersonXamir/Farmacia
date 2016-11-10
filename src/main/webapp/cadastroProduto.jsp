<%-- 
    Document   : cadastroProduto
    Created on : 05/11/2016, 20:36:01
    Author     : Michael Facul
--%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Cadastro de Produtos</title>
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a href="#">Pesquisar</a>
                    <ul>
                        <li><a href="produto.jsp">Produtos Cadastrados</a></li>                        
                    </ul>
                </li> 
                <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        Usu�rio: ${nome}</a></li>
            </ul>
            <div class="imagem"></div>
        </nav>
        <aside>
            <div>
                
                    <legend><h2>Dados do Produto</h2></legend>
                <form class="formulario" action ="AdicionarProduto" method="get">
                    C�digo: <input type="text" size="40" name="codigo" />
                    Descri��o: <input type="text" size="60" name="descricao" /><br/>
                    Pre�o: <input type="float" placeholder="0,00" name="preco" />
                    Marca: <input type="text" size="40" name="marca" /><br/>                   
                    Categoria: <select name="categoria"> 
                        <option value="1"></option>
                          </select>
                    Fornecedor: <select name="fornecedor">                            
                        <option value="1"></option>
                          </select>  <br/>
                    <br/><input type="submit" value="Gravar" />
                    <input type="reset" value="Limpar" />                    
                    <input type="button" value="Voltar" onClick="history.go(-1)"> 
                </form>
            </div>
        </aside>  
    </body>
</html>
