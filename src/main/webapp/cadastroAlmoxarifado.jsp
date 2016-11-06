<%-- 
    Document   : cadastroAlmoxarifado
    Created on : 05/11/2016, 21:49:58
    Author     : Michael Facul
--%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="cadastro.css"/>
        <title>Cadastro Almoxarifado</title>
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a href="#">Pesquisar</a>
                    <ul>
                        <li><a href="almoxarifado.jsp">Almoxarifados Cadastrados</a></li>                        
                    </ul>
                </li> 
                <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        Usu�rio: ${nome}</a></li>
            </ul>
            <div class="imagem"></div>
        </nav>
        <aside>
            <div>
                <fieldset>
                    <legend><h2>Dados do Almoxarifado</h2></legend>
                <form class="formulario" action ="AdicionarAlmoxarifado" method="post">
                    C�digo: <input type="text" size="40" name="codigo" />
                    Descri��o: <input type="text" size="60" name="descricao" /><br/>                    
                    Unidade: <select name="unidade">                            
                          </select><br/><br/>                                                    
                </fieldset>
                    <br/><input type="submit" value="Gravar" />
                    <input type="reset" value="Limpar" />                    
                    <input type="button" value="Voltar" onClick="history.go(-1)"> 
                </form>
            </div>
        </aside>  
    </body>
</html>
