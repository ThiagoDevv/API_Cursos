package model.dao;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Pessoa;

public class PessoaDao {
    
    public void criar(Pessoa p){
        Connection con = ConnectionFactory.GetConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("INSERT INTO Pessoa (nome, npf)VALUES(?,?)");
            
            stmt.setString(1 ,p.getNome());
            stmt.setString(2, p.getCpf());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "salvo com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erro ao salvar " + ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }
    
    public List<Pessoa> read(){
        Connection con = ConnectionFactory.GetConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Pessoa pessoa = new Pessoa();
                
                pessoa.setIdPessoa(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoas.add(pessoa);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);
        }
        
        return pessoas;
    }
    
        public void update(Pessoa p){
        Connection con = ConnectionFactory.GetConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("UPDATE pessoa SET nome = ?, cpf = ? WHERE id = ?");
            
            stmt.setString(1 ,p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setInt(3, p.getIdPessoa());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "atualizado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erro ao atualizar " + ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }
    public void delete(Pessoa p){
        Connection con = ConnectionFactory.GetConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("DELETE FROM pessoa WHERE id = ?");
            
            stmt.setInt(3, p.getIdPessoa());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "registro deletado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erro ao deletar " + ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }
}

