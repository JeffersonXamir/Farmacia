package br.sp.senac.programeros.dao;

import br.sp.senac.programeros.connection.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.sp.senac.programeros.model.ContasReceber;
import java.sql.Date;

public class ContasReceberDAO implements br.sp.senac.programeros.interfaces.ContasReceberInterface {

    //Conexao Banco
    Connection conexao;

    //Construtor 
    public ContasReceberDAO(Connection conexao) {
        this.conexao = conexao;
    }
    //Inserir

    public void ContasReceber(ContasReceber contasReceber) {
        //Comando do banco
        String sql = "INSERT INTO contasreceber"
                + "(serie,titulo,parcela,cliente,dada_emissao,valor,valor_baixado,data_baixa,pedido,notassaida_chave,usuario) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement p;
        try {
            //Setando os valores
            p = this.conexao.prepareStatement(sql);
            p.setString(1, contasReceber.getSerie());
            p.setString(2, contasReceber.getTitulo());
            p.setString(3, contasReceber.getParcela());
            p.setInt(4, contasReceber.getCliente());
            p.setDate(5, new java.sql.Date(System.currentTimeMillis())); 
            p.setFloat(6, contasReceber.getValor());
            p.setFloat(7, contasReceber.getValorBaixado());
            p.setDate(8, (Date) contasReceber.getDataBaixa()); 
            p.setInt(9, contasReceber.getPedido());
            p.setInt(10, contasReceber.getNotasSaida());
            p.setInt(11, contasReceber.getUsuario());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Alterar
    @Override
    public void alterar(ContasReceber contasReceber) {

        try {
            //Comando do banco
            String sql = "UPDATE contasreceber"
                    + " SET serie = ?, titulo = ?, parecela = ?, cliente = ?, dada_emissao = ?,"
                    + "valor = ?, valor_baixado = ?, data_baixa = ?, pedido = ?, notassaida_chave = ?, usuario = ?"
                    + " WHERE chave = ?";
            //Setando os valores
            PreparedStatement p;
            p = this.conexao.prepareStatement(sql);
            p.setString(1, contasReceber.getSerie());
            p.setString(2, contasReceber.getTitulo());
            p.setString(3, contasReceber.getParcela());
            p.setInt(4, contasReceber.getCliente());
            p.setDate(5, new java.sql.Date(System.currentTimeMillis())); 
            p.setFloat(6, contasReceber.getValor());
            p.setFloat(7, contasReceber.getValorBaixado());
            p.setDate(8, (Date) contasReceber.getDataBaixa());
            p.setInt(9, contasReceber.getPedido());
            p.setInt(10, contasReceber.getNotasSaida());
            p.setInt(11, contasReceber.getUsuario());
            p.setInt(12, contasReceber.getChave());
            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Listar 
    @Override
    public List<ContasReceber> listarContasReceber() {
        //Lista
        List<ContasReceber> contasReceber = new ArrayList<ContasReceber>();
        //Comando do banco
        try {
            String sql = "SELECT * FROM contasreceber";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            //Setando os valores
            while (rs.next()) {
                ContasReceber contaReceber = new ContasReceber();

                int chave = rs.getInt("chave");
                String serie = rs.getString("serie");
                String titulo = rs.getString("titulo");
                String parcela = rs.getString("parcela");
                int cliente = rs.getInt("cliente");
                Date dataEmissao = rs.getDate("data_emissao");
                Float valor = rs.getFloat("valor");
                Float valorBaixado = rs.getFloat("valor_baixado");
                Date dataBaixa = rs.getDate("data_baixa");
                int pedido = rs.getInt("pedido");
                int notasSaida = rs.getInt("notassaida_chave");                
                int usuario = rs.getInt("usuario");                  

                contaReceber.setChave(chave);
                contaReceber.setSerie(serie);
                contaReceber.setTitulo(titulo);
                contaReceber.setParcela(parcela);
                contaReceber.setCliente(cliente);
                contaReceber.setDataEmissao(dataEmissao);
                contaReceber.setValor(valor);
                contaReceber.setValorBaixado(valorBaixado);
                contaReceber.setDataBaixa(dataBaixa);
                contaReceber.setPedido(pedido);
                contaReceber.setNotasSaida(notasSaida);                
                contaReceber.setUsuario(usuario);                

                contasReceber.add(contaReceber);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return contasReceber;
    }

    @Override
    public ContasReceber selecionar(int chave) {
        //Criando o objeto contas receber  
        ContasReceber contasReceber = new ContasReceber();
        ConexaoBD conn = new ConexaoBD();
        //Comando do banco
        String sql = "SELECT * FROM contasreceber WHERE chave= " + chave;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            //Setando os valores
                contasReceber.setChave(chave);
                contasReceber.setSerie(rs.getString("serie"));
                contasReceber.setTitulo(rs.getString("titulo"));
                contasReceber.setParcela(rs.getString("parcela"));
                contasReceber.setCliente(rs.getInt("cliente"));
                contasReceber.setDataEmissao(rs.getDate("data_emissao"));
                contasReceber.setValor(rs.getFloat("valor"));
                contasReceber.setValorBaixado(rs.getFloat("valor_baixado"));
                contasReceber.setDataBaixa(rs.getDate("data_baixa"));
                contasReceber.setPedido(rs.getInt("pedido"));
                contasReceber.setNotasSaida(rs.getInt("notassaida_chave"));
                contasReceber.setUsuario(rs.getInt("usuario"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return contasReceber;

    }

    //Remove
    @Override
    public ContasReceber Remove(int chave) {
        //Comando do banco
        String sql = "DELETE contasreceber WHERE chave = ?";

        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setInt(1, chave);

            p.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    //Inserir
    @Override
    public void inserir(ContasReceber contasReceber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
