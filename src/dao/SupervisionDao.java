package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import MainMenu.MainMenu;
import domain.Supervision;

public class SupervisionDao 
{
	
    public void addSupervisor(Supervision s) throws SQLException 
    {
		String sql = "INSERT INTO supervision (scientific_theme_id, teacher_scientist_id, start, end) VALUES (?,?,?,?)";
 	  	PreparedStatement stm = MainMenu.conn.prepareStatement(sql);
    	stm.setInt(1, s.getScientificThemeId());
    	stm.setInt(2, s.getScientistId());
    	stm.setDate(3, s.getStart());
    	stm.setDate(4, s.getEnd());
    	stm.executeUpdate();
    	JOptionPane.showMessageDialog (null, "Керівник теми успішно доданий!" );
	}
    
    
    public void changeSupervisor(int new_id ,Supervision s) throws SQLException
    {
    	String sql = "update supervision set teacher_scientist_id = ? where scientific_theme_id = " + s.getScientificThemeId();
    	PreparedStatement stm = MainMenu.conn.prepareStatement(sql);
    	stm.setInt(1, new_id);
    	stm.executeUpdate();
    	JOptionPane.showMessageDialog (null, "Керівника теми успішно змінено!" );
    }
	
	
	
	public Supervision readSupervisor(int key) throws SQLException 
    {
		SupervisionDao sd = new SupervisionDao();
		if(sd.hasSupervisor(key))
		{
	        String sql = "SELECT * FROM supervision WHERE scientific_theme_id = ?";
	        Supervision s = new Supervision();
	        try (PreparedStatement stm = MainMenu.conn.prepareStatement(sql)) 
	        {
	            stm.setInt(1, key);
	            ResultSet rs = stm.executeQuery();
	            rs.next();
	            s.setScientificThemeId(rs.getInt("scientific_theme_id"));
	            s.setScientistId(rs.getInt("teacher_scientist_id"));
	            s.setStart(rs.getDate("start"));
	            s.setEnd(rs.getDate("end"));
	        }
	        return s;
		}
		else
		{
			return null;
		}
	}


    
    public void updateSupervisor(Supervision s) throws SQLException 
    {
    	String sql = "update supervision set start = ?, end = ? where scientific_theme_id = " +  s.getScientificThemeId();
    	PreparedStatement stm = MainMenu.conn.prepareStatement(sql);
    	stm.setDate(1, s.getStart());
    	stm.setDate(2, s.getEnd());
    	stm.executeUpdate();
    	JOptionPane.showMessageDialog(null, "Інформація про керівника успішно відредагована!" ); 
	}
    
    
    public boolean hasSupervisor(int scientific_theme_id) throws SQLException
    {
    	String sql = "SELECT scientific_theme_id FROM scientifictheme WHERE scientific_theme_id IN (SELECT scientific_theme_id FROM supervision)";
    	PreparedStatement stm = MainMenu.conn.prepareStatement(sql);
    	ResultSet rs = stm.executeQuery();
    	int ids[] = new int[100];
    	for(int i = 0; i < 100;i++)
    	{
    		ids[i] = 0;
    	}
    	int i = 0;
        while (rs.next()) 
        {
            ids[i] = rs.getInt("scientific_theme_id");
            i++;
        }
        i = 0;
        while(ids[i] != 0)
        {
        	if(ids[i] == scientific_theme_id)
        	{
        		return true;
        	}
        	i++;
        }
        return false;
    }
}
