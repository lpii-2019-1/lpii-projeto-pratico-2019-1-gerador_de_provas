package gerador_provas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import gerador_provas.conexao.Conexao;
import gerador_provas.model.Area;




public class AreaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public AreaDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	
	public Area cadastrar(Area area) {
		String sql = "insert into area (area) values (?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, area.getArea());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			area.setIdarea(rs.getInt(1));
			stmt.close();
			
			return area; 
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public Area pesquisar(Area area) {
		String sql = "select * from area where area = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, area.getArea());
			ResultSet rs = stmt.executeQuery();
            Area areaResul = new Area();
            
            if (rs.next()) {
            	areaResul.setIdarea(rs.getInt("idarea"));
            	areaResul.setArea(rs.getString("area"));   
            }
            stmt.close();
            return areaResul;
            	
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Area pesquisarId(int Idarea) {
		String sql = "select * from area where idarea = ?";
		try {
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, Idarea);
			ResultSet rs = stmt.executeQuery();
			Area area = new Area();
			if (rs.next()) {
				area.setIdarea(rs.getInt("idArea"));
				area.setArea(rs.getString("area"));
			}
			return area;
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	 public ArrayList<Area> listarTudo() {
		String sql = "select * from area";
		try {
			stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Area> lista = new ArrayList<Area>();
            
            while (rs.next()) {
                Area area = new Area();
                area.setIdarea(rs.getInt("idarea"));
                area.setArea(rs.getString("area"));

                lista.add(area);
            }
            stmt.close();
            return lista;
            
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	} 
	 
	 
	 public void apagar(Area area) {
		 String sql = "delete from area where idarea= ?";
		 try {
			  stmt = conexao.prepareStatement(sql);
			  stmt.setInt(1, area.getIdarea());
			  stmt.execute();
			  stmt.close();
			 
		 }catch(Exception e) {
			 throw new RuntimeException(e);
		 }
	 }
	
}