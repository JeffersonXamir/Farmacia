package br.sp.senac.programeros.actions;

import br.sp.senac.programeros.connection.ConexaoBD;
import br.sp.senac.programeros.dao.FilialDAO;
import br.sp.senac.programeros.model.Filiais;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarFilial extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Variavel do id
        String id = request.getParameter("id");
        request.setAttribute("id", id);        
        //Request diretorio
        request.getRequestDispatcher("Filiais/filialAlterar.jsp").forward(request, response); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Variaves
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String cep = request.getParameter("cep");
        String telefone = request.getParameter("telefone");
        String responsavel = request.getParameter("responsavel");
        String email = request.getParameter("email");
        String ativo = request.getParameter("ativo");
        //Objetos e variaveis
        Filiais novaFilial = new Filiais();
        novaFilial.setCodigo(id);
        novaFilial.setNome(nome);
        novaFilial.setEndereco(endereco);
        novaFilial.setBairro(bairro);
        novaFilial.setCidade(cidade);
        novaFilial.setEstado(estado);
        novaFilial.setCep(cep);
        novaFilial.setTelefone(telefone);
        novaFilial.setResponsavel(responsavel);
        novaFilial.setEmail(email);
        novaFilial.setAtivo(ativo);
        //Comando do banco
        ConexaoBD conn = new ConexaoBD();
        Connection conexao = conn.obterConexao();
        //Obejto
        FilialDAO dao = new FilialDAO(conexao);
        dao.alterar(novaFilial);

        conn.fecharConexao();
        //Diretorio
        response.sendRedirect("/Farmacia/Filiais/filial.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
