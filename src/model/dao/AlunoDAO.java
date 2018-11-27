package model.dao;

import connection.GerenciadorBD;
import connection.ProgramaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Aluno;


public class AlunoDAO {
    
    //Create
    public void create(Aluno p) throws SQLException {
        Connection con = GerenciadorBD.getConnection();       
        PreparedStatement stmt = null;
        /* if( ra digitado é int, nome digitado é String, previsaoFormatura digitado é String){ */
            try {
                stmt = con.prepareStatement("INSERT INTO aluno (ra, nome, previsaoFormatura) VALUES (?,?,?)");
                stmt.setInt(1, p.getRa());
                stmt.setString(2, p.getNome());
                stmt.setString(3, p.getPrevisaoFormatura());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar: " +ex);
            } finally {
                if(stmt != null) {                
                    stmt.close();
                    //GerenciadorBD.closeConnection(con, stmt);
                }
            }
       /* }else{
            JOptionPane.showMessageDialog(null, "Por favor digite valores válidos para os campos");
        }   */
    }
    
    //Update
    public void alterar(Aluno p) throws SQLException{
        Connection con = GerenciadorBD.getConnection();
        PreparedStatement stmt = null;  
        try{
            stmt = con.prepareStatement("update aluno set  nome = ?, ra = ?, previsaoFormatura = ? where id = ?"); 
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getRa());
            stmt.setString(3, p.getPrevisaoFormatura());
            stmt.setInt(4, p.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " +ex);
        } 
    }
    
    //Delete
    public void delete(Aluno p) throws SQLException{
        Connection con = GerenciadorBD.getConnection();
        PreparedStatement stmt = null;        
        try{
            stmt = con.prepareStatement("delete from aluno where id = ?");
            stmt.setInt(1, p.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " +ex);
        } finally {
            stmt.close();
            //GerenciadorBD.closeConnection(con, stmt);
        }
    }
    
    
    //Pesquisar
    public List<Aluno> pesquisar(String nome) throws SQLException{
        Connection con = GerenciadorBD.getConnection();
        PreparedStatement stmt = null;  
        List<Aluno> alunos = new ArrayList<>();
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("select * from Aluno where nome = ?");
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setRa(rs.getInt("ra"));
                aluno.setNome(rs.getString("nome"));
                aluno.setPrevisaoFormatura(rs.getString("previsaoFormatura"));
                //System.out.println(aluno.id, aluno.ra, aluno.nome, aluno.previsaoFormatura);               
                alunos.add(aluno);
            }
        }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao pesquisar: " +ex);
        } finally {
            if(rs != null) {
                    rs.close();
                    stmt.close();
                    //GerenciadorBD.closeConnection(con, stmt);
            }
                
        }
                
        return alunos;
    }
    
    //Pesquisar
    public List<Aluno> pesquisar() throws SQLException{
        Connection con = GerenciadorBD.getConnection();
        PreparedStatement stmt = null;  
        List<Aluno> alunos = new ArrayList<>();
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("select * from Aluno");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setRa(rs.getInt("ra"));
                aluno.setNome(rs.getString("nome"));
                aluno.setPrevisaoFormatura(rs.getString("previsaoFormatura"));
                //System.out.println(aluno.id, aluno.ra, aluno.nome, aluno.previsaoFormatura);               
                alunos.add(aluno);
            }
        }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao pesquisar: " +ex);
        } finally {
            if(rs != null) {
                    rs.close();
                    stmt.close();
                    //GerenciadorBD.closeConnection(con, stmt);
            }
                
        }
                
        return alunos;
    }
}