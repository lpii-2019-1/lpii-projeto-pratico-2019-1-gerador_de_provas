package gerador_provas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import gerador_provas.conexao.Conexao;
import gerador_provas.model.Origem;



public class OrigemDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public OrigemDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	// Cadastrar
	public void cadastrar(Origem origem) {
		String sql = "insert into origem (origem, ano) values (?, ?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, origem.getOrigem());
			stmt.setInt(2, origem.getAno());
			stmt.execute();
			stmt.close();
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// Buscar origem
	public Origem pesquisar(Origem origem) {
		String sql = "select * from origem where origem = ? and ano = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, origem.getOrigem());
			stmt.setInt(2, origem.getAno());
			ResultSet rs = stmt.executeQuery();
            Origem novaOrigem = new Origem();
            
            if (rs.next()) {
                novaOrigem.setIdorigem(rs.getInt("idorigem"));
                novaOrigem.setOrigem(rs.getString("origem"));
                novaOrigem.setAno(rs.getInt("ano"));
            }
            stmt.close();
            return novaOrigem;
            	
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// Lista todas as areas
	 public ArrayList<Origem> listarTudo() {
		String sql = "select * from origem";
		try {
			stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Origem> lista = new ArrayList<Origem>();
            
            while (rs.next()) {
                Origem origem = new Origem();
                origem.setIdorigem(rs.getInt("idorigem"));
                origem.setOrigem(rs.getString("origem"));
                origem.setAno(rs.getInt("ano"));

                lista.add(origem);
            }
            stmt.close();
            return lista;
            
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	} 
	 
	 // Apagar 
	 public void apagar(Origem origem) {
		 String sql = "delete from origem where idorigem= ?";
		 try {
			  stmt = conexao.prepareStatement(sql);
			  stmt.setInt(1, origem.getIdorigem());
			  stmt.execute();
			  stmt.close();
			 
		 }catch(Exception e) {
			 throw new RuntimeException(e);
		 }
	 }
	 
	
}
