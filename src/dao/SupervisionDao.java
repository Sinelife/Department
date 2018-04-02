package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import main.Main;
import domain.Supervision;

public class SupervisionDao 
{
	
    public void addSupervisor(Supervision s) throws SQLException 
    {
		String sql = "INSERT INTO supervision (supervisor_id, scientific_theme_id, teacher_scientist_id, start, ruler) VALUES (?,?,?,?,?)";
 	  	PreparedStatement stm = Main.conn.prepareStatement(sql);
		int i = -1;
		String sql_for_id = "SELECT MAX(supervisor_id) from supervision";
		PreparedStatement statement_for_id = Main.conn.prepareStatement(sql_for_id);
		statement_for_id.executeQuery();
		ResultSet result = statement_for_id.getResultSet();
		if((result!=null) && (result.next()))i = result.getInt(1);
		stm.setInt(1, i+1);
    	stm.setInt(2, s.getScientificThemeId());
    	stm.setInt(3, s.getScientistId());
    	stm.setDate(4, s.getStart());
    	stm.setBoolean(5, true);
    	stm.executeUpdate();
    	JOptionPane.showMessageDialog (null, "Керівник теми успішно доданий!" );
	}
    
    
    public void changeSupervisor(Supervision s_old, Supervision s_new) throws SQLException
    {
    	String sql1 = "update supervision set end = ?, ruler = ? where teacher_scientist_id = " + s_old.getScientistId() + " and scientific_theme_id = " + s_old.getScientificThemeId();
    	PreparedStatement stm1 = Main.conn.prepareStatement(sql1);
    	String sql2 = "INSERT INTO supervision (supervisor_id, scientific_theme_id, teacher_scientist_id, start, ruler) VALUES (?,?,?,?,?)";
    	PreparedStatement stm2 = Main.conn.prepareStatement(sql2); 	
    	stm1.setDate(1, s_new.getStart());
    	stm1.setBoolean(2, false);
    	stm1.executeUpdate();
    	
    	int i = -1;
		String sql_for_id = "SELECT MAX(supervisor_id) from supervision";
		PreparedStatement statement_for_id = Main.conn.prepareStatement(sql_for_id);
		statement_for_id.executeQuery();
		ResultSet result = statement_for_id.getResultSet();
		if((result!=null) && (result.next()))i = result.getInt(1);
		stm2.setInt(1, i+1);
    	stm2.setInt(2, s_new.getScientificThemeId());
    	stm2.setInt(3, s_new.getScientistId());
    	stm2.setDate(4, s_new.getStart());
    	stm2.setBoolean(5, true);
    	stm2.executeUpdate();
    	JOptionPane.showMessageDialog (null, "Керівника теми успішно змінено!" );
    }
	
	
	
	public Supervision readSupervisor(int key) throws SQLException 
    {
		SupervisionDao sd = new SupervisionDao();
		if(sd.hasSupervisor(key))
		{
	        String sql = "SELECT * FROM supervision WHERE scientific_theme_id = ? and ruler = 1";
	        Supervision s = new Supervision();
	        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) 
	        {
	            stm.setInt(1, key);
	            ResultSet rs = stm.executeQuery();
	            rs.next();
	            s.setSupervisorId(rs.getInt("supervisor_id"));
	            s.setScientificThemeId(rs.getInt("scientific_theme_id"));
	            s.setScientistId(rs.getInt("teacher_scientist_id"));
	            s.setStart(rs.getDate("start"));
	            s.setEnd(rs.getDate("end"));
	            s.setRuler(rs.getBoolean("ruler"));
	        }
	        return s;
		}
		else
		{
			return null;
		}
	}
	
	
	public Supervision readOldSupervisor(int supervisor_id) throws SQLException 
    {
		SupervisionDao sd = new SupervisionDao();
		String sql = "SELECT * FROM supervision WHERE supervisor_id = ?";
		Supervision s = new Supervision();
		try (PreparedStatement stm = Main.conn.prepareStatement(sql)) 
		{
			stm.setInt(1, supervisor_id);
			ResultSet rs = stm.executeQuery();
			rs.next();
			s.setSupervisorId(rs.getInt("supervisor_id"));
			s.setScientificThemeId(rs.getInt("scientific_theme_id"));
			s.setScientistId(rs.getInt("teacher_scientist_id"));
			s.setStart(rs.getDate("start"));
			s.setEnd(rs.getDate("end"));
			s.setRuler(rs.getBoolean("ruler"));
		}
		return s;
		
	}


	

    
    public void updateSupervisor(Supervision s) throws SQLException 
    {
    	String sql = "update supervision set end = ? where scientific_theme_id = " +  s.getScientificThemeId();
    	PreparedStatement stm = Main.conn.prepareStatement(sql);
    	stm.setDate(1, s.getEnd());
    	stm.executeUpdate();
    	JOptionPane.showMessageDialog(null, "Інформація про керівника успішно відредагована!" ); 
	}
    
    
    public boolean hasSupervisor(int scientific_theme_id) throws SQLException
    {
    	String sql = "SELECT scientific_theme_id FROM scientifictheme WHERE scientific_theme_id IN (SELECT scientific_theme_id FROM supervision)";
    	PreparedStatement stm = Main.conn.prepareStatement(sql);
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
    
    
    
    public String getSurname(int scientist_id) throws SQLException
    {
    	String sql = "select surname from scientist where scientist_id = " + scientist_id;
		Statement s = Main.conn.createStatement();
 	  	ResultSet rs = s.executeQuery(sql);
 	  	String surname = null;
 	  	while (rs.next()) {
 	  		surname = rs.getString("surname");
 	  	}
		return surname; 
    }
}
