package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import MainMenu.MainMenu;
import domain.Working;

public class WorkingDao 
{
	
    public void addWorker(Working w) throws SQLException 
    {
		String sql = "INSERT INTO working (scientific_theme_id,scientist_id, title, start, end) VALUES (?,?,?,?,?)";
 	  	PreparedStatement stm = MainMenu.conn.prepareStatement(sql);
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
        try (PreparedStatement stm = MainMenu.conn.prepareStatement(sql)) 
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
    	PreparedStatement stm = MainMenu.conn.prepareStatement(sql);
    	stm.setString(1, w.getTitle());
    	stm.setDate(2, w.getStart());
    	stm.setDate(3, w.getEnd());
    	stm.executeUpdate();
    	JOptionPane.showMessageDialog (null, "Дані про роботу науковця на темі відредаговано успішно!" ); 
	}
    
    
    public void deleteWorker(Working w) throws SQLException 
    {
    	String sql = "DELETE FROM working WHERE scientific_theme_id = " + w.getScientificThemeId() + " and scientist_id = " + w.getScientistId();
    	try (Statement stm = MainMenu.conn.createStatement())
    	{
            stm.executeUpdate(sql);
    	}
    	JOptionPane.showMessageDialog (null, "Науковець успішно видалений з роботи над темою!" );
	}
    
}
