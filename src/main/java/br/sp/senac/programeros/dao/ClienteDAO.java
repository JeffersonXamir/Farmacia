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
import br.sp.senac.programeros.model.Cliente;
import java.sql.Date;

public class ClienteDAO implements br.sp.senac.programeros.interfaces.ClienteInterface {
    //Conexao Banco
    Connection conexao;
    //Construtor
    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }
    //Inserir
    @Override
    public void inserir(Cliente cliente) {
        //Comando do banco
        String sql = "insert into clientes "
                + "(nome, endereco, bairro, cidade, estado, cep, sexo, telefone, celular,"
                + " cadastro, ativo, deletado) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?,?,'')";
        PreparedStatement p;
        try {
            //Setando valores
            p = this.conexao.prepareStatement(sql);
            p.setString(1, cliente.getNome());
            p.setString(2, cliente.getEndereco());
            p.setString(3, cliente.getBairro());
            p.setString(4, cliente.getCidade());
            p.setString(5, cliente.getEstado());
            p.setString(6, cliente.getCep());
            p.setString(7, cliente.getSexo());
            p.setString(8, cliente.getTelefone());
            p.setString(9, cliente.getCelular());
            p.setDate(10, new java.sql.Date(System.currentTimeMillis()));            
            p.setString(11, "S");

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Alterar
    @Override
    public void alterar(Cliente cliente) {
        //Comando do banco
        try {
            String sql = "UPDATE clientes "
                    + " SET nome = ?, endereco = ?, bairro = ?, cidade = ?, "
                    + " estado = ?, cep = ?, sexo = ?,telefone = ?, celular = ?, ativo = ?"                   
                    + " WHERE codigo = ?";

            PreparedStatement p;
            //Setando valores
            p = this.conexao.prepareStatement(sql);
            p.setString(1, cliente.getNome());
            p.setString(2, cliente.getEndereco());
            p.setString(3, cliente.getBairro());
            p.setString(4, cliente.getCidade());
            p.setString(5, cliente.getEstado());
            p.setString(6, cliente.getCep());
            p.setString(7, String.valueOf(cliente.getSexo()));
            p.setString(8, cliente.getTelefone());
            p.setString(9, cliente.getCelular());             
            p.setString(10, cliente.getAtivo());             
            p.setInt(11, cliente.getCodigo());

            p.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Lista
    @Override
    public List<Cliente> listarClientes() {
        //Lista
        List<Cliente> clientes = new ArrayList<>();
        //Comando do banco
        try {
            String sql = "SELECT * FROM clientes WHERE deletado <> '*'";
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Cliente cliente = new Cliente();
                //Setando valores
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String cep = rs.getString("cep");
                String sexo = rs.getString("sexo");
                String telefone = rs.getString("telefone");
                String celular = rs.getString("celular");
                Date cadastro = rs.getDate("cadastro");                
                String ativo = rs.getString("ativo");                

                cliente.setCodigo(codigo);
                cliente.setNome(nome);
                cliente.setEndereco(endereco);
                cliente.setBairro(bairro);
                cliente.setCidade(cidade);
                cliente.setEstado(estado);
                cliente.setCep(cep);
                cliente.setSexo(sexo);
                cliente.setTelefone(telefone);
                cliente.setCelular(celular);
                cliente.setCadastro(cadastro);
                cliente.setAtivo(ativo);                

                clientes.add(cliente);
            }

        } catch (SQLException e) {
        }
        return clientes;
    }
    //Selecionar
    @Override
    public Cliente selecionar(int codigo) {
        //Criando o obejeto cliente
        Cliente cliente = new Cliente();
        ConexaoBD conn = new ConexaoBD();
        //Comando do banco
        String sql = "SELECT * FROM clientes WHERE deletado <> '*' AND codigo= "+codigo;

        try {
            Statement stmt = (Statement) conn.obterConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            //Setando Valores
            cliente.setCodigo(codigo);
            cliente.setNome(rs.getString("nome"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setBairro(rs.getString("bairro"));
            cliente.setCidade(rs.getString("cidade"));
            cliente.setEstado(rs.getString("estado"));
            cliente.setCep(rs.getString("cep"));
            cliente.setSexo(rs.getString("sexo"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setCelular(rs.getString("celular"));
            cliente.setCadastro(rs.getDate("cadastro"));
            cliente.setAtivo(rs.getString("ativo"));            
        } catch (SQLException e) {
        }

        return cliente;

    }
    //Remover
    @Override
    public Cliente Remove(int codigo) {
        //Comando do banco
        String sql = "UPDATE clientes set deletado = '*' WHERE codigo=?";
        
        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            p.setInt(1, codigo);

            p.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

//    @Override
//    public void inserir(Cliente cliente) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
