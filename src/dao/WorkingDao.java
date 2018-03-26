package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import main.Main;
import domain.Working;

public class WorkingDao 
{
	
    public void addWorker(Working w) throws SQLException 
    {
		String sql = "INSERT INTO working (scientific_theme_id,scientist_id, title, start, end) VALUES (?,?,?,?,?)";
 	  	PreparedStatement stm = Main.conn.prepareStatement(sql);
 	  	stm.setInt(1, w.getScientificThemeId());
 	  	stm.setInt(2, w.getScientistId());
 	  	stm.setString(3, w.getTitle());
 	  	stm.setDate(4, w.getStart());
 	  	stm.setDate(5, w.getEnd());
    	stm.executeUpdate();
    	JOptionPane.showMessageDialog (null, "Новий науковець успішно доданий до роботи над темою!" );
	}
	
	
    public Working readWorker(int scientific_theme_id, int scientist_id) throws SQLException 
    {
        String sql = "SELECT * FROM working WHERE scientific_theme_id = ? and scientist_id = ?";
        Working w = new Working();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) 
        {
            stm.setInt(1, scientific_theme_id);
            stm.setInt(2, scientist_id);
            ResultSet rs = stm.executeQuery();
            rs.next();
            w.setScientificThemeId(rs.getInt("scientific_theme_id"));
            w.setScientistId(rs.getInt("scientist_id"));
            w.setTitle(rs.getString("title"));
            w.setStart(rs.getDate("start"));
            w.setEnd(rs.getDate("end"));
        }
        return w;
	}
    
    
    
    public void updateWorker(Working w) throws SQLException 
    {
    	String sql = "update working set title = ?, start = ?, end = ? where scientific_theme_id = " +  w.getScientificThemeId() + " and scientist_id = " + w.getScientistId();
    	PreparedStatement stm = Main.conn.prepareStatement(sql);
    	stm.setString(1, w.getTitle());
    	stm.setDate(2, w.getStart());
    	stm.setDate(3, w.getEnd());
    	stm.executeUpdate();
    	JOptionPane.showMessageDialog (null, "Дані про роботу науковця на темі відредаговано успішно!" ); 
	}
    
    
    public void deleteWorker(Working w) throws SQLException 
    {
    	String sql = "DELETE FROM working WHERE scientific_theme_id = " + w.getScientificThemeId() + " and scientist_id = " + w.getScientistId();
    	try (Statement stm = Main.conn.createStatement())
    	{
            stm.executeUpdate(sql);
    	}
    	JOptionPane.showMessageDialog (null, "Науковець успішно видалений з роботи над темою!" );
	}
    
    
    
    public List<Working> getAllFromTheme(int scientific_theme_id) throws SQLException
    {
        String sql = "SELECT * FROM working WHERE scientific_theme_id = " + scientific_theme_id;
        List<Working> list = new ArrayList<Working>();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Working w = new Working();
            	w.setScientificThemeId(rs.getInt("scientific_theme_id"));
            	w.setScientistId(rs.getInt("scientist_id"));
            	w.setTitle(rs.getString("title"));
            	w.setStart(rs.getDate("start"));
            	w.setEnd(rs.getDate("end"));
            	list.add(w);
            }
        }
        return list;
    }
    
    
    public String getSurname(int scientist_id) throws SQLException
    {
    	String sql = "SELECT surname FROM scientist WHERE scientist_id IN "
    				+ "(SELECT scientist_id FROM working WHERE scientist_id = " + scientist_id + ")";
		Statement s = Main.conn.createStatement();
 	  	ResultSet rs = s.executeQuery(sql);
 	  	String surname = null;
 	  	while (rs.next()) {
 	  		surname = rs.getString("surname");
 	  	}
		return surname; 
    }
    
    
    
    
    
    public String getRole(int scientist_id, String table) throws SQLException
    {
    	String role = "";
    	String sql1 = "SELECT surname FROM scientist WHERE scientist_id IN "
    			+ "(SELECT scientist_id FROM " + table + " WHERE scientist_id = " + scientist_id + ")";
    	Statement s1 = Main.conn.createStatement();
 	  	ResultSet rs1 = s1.executeQuery(sql1);
 	  	String surname1 = "not ";
 	  	while (rs1.next()) {
 	  		surname1 = rs1.getString("surname");
 	  	}
 	  	
	    if(surname1.equals(""))
	    {

	    }
	    else
	    {
	    	role = table;
	    	return role;
	    }
		return " ";
 	  	
    }

    
}
