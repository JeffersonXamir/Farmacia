package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.dao.AlmoxarifadoDAO;
import br.sp.senac.programeros.model.Almoxarifado;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionarAlmoxarifado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Variaveis
        String descricao = request.getParameter("descricao");
        String filial = request.getParameter("filial");        
        String ativo = "S";
        //Objeto e valores
        Almoxarifado novo = new Almoxarifado();
        novo.setDescricao(descricao);
        novo.setFilial(Integer.parseInt(filial));        
        novo.setAtivo(ativo);
        //Comando do banco
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();
        //Objeto
        AlmoxarifadoDAO dao = new AlmoxarifadoDAO(conexao);
        dao.inserir(novo);

        conn.fecharConexao();
        //Diretorio
        response.sendRedirect("/Farmacia/Almoxarifados/almoxarifado.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}