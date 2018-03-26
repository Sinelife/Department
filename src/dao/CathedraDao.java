package dao;

import java.sql.PreparedStatement;
import main.Main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Cathedra;

public class CathedraDao 
{
	
	
    /** @throws SQLException */
    public Cathedra readCathedra(int key) throws SQLException 
    {
        String sql = "SELECT * FROM cathedra WHERE cathedra_id = ?";
        Cathedra c = new Cathedra();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) 
        {
            stm.setInt(1, key);
            ResultSet rs = stm.executeQuery();
            rs.next();
            c.setName(rs.getString("name"));
            c.setPhone(rs.getString("phone"));
        }
        return c;
	}
	
	
	
	
    public List<Cathedra> getAll() throws SQLException 
    {
        String sql = "SELECT * FROM cathedra;";
        List<Cathedra> list = new ArrayList<Cathedra>();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Cathedra c = new Cathedra();
                c.setId(rs.getInt("cathedra_id"));
                c.setName(rs.getString("name"));
                c.setPhone(rs.getString("phone"));
                list.add(c);
            }
        }
        return list;
    }
    
  
}
