package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import domain.ScientificWork;
import main.Main;

public class ScientificWorkDao 
{
    /** @throws SQLException */
    public void addWork(ScientificWork sw) throws SQLException 
    {
		String sql = "INSERT INTO scientificwork (scientific_work_id, title, type, scientist_id, year) VALUES (?,?,?,?,?)";
 	  	PreparedStatement stm = Main.conn.prepareStatement(sql);
 	  	
		int i = -1;
		String sql_for_id = "SELECT MAX(scientific_work_id) from scientificwork";
		PreparedStatement statement_for_id = Main.conn.prepareStatement(sql_for_id);
		statement_for_id.executeQuery();
		ResultSet result = statement_for_id.getResultSet();
		if((result!=null) && (result.next()))i = result.getInt(1);
		stm.setInt(1,i+1);
		stm.setString(2, sw.getTitle());
		stm.setString(3, sw.getType());
		stm.setInt(4, sw.getScientistId());
		stm.setInt(5, sw.getYear());
    	JOptionPane.showMessageDialog (null, "Нова наукова робота успішно створена!" );
	}
    
    

    /** @throws SQLException */
    public ScientificWork readWork(int key) throws SQLException 
    {
        String sql = "SELECT * FROM scientificwork WHERE scientific_work_id = ?";
        ScientificWork sw = new ScientificWork();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) 
        {
            stm.setInt(1, key);
            ResultSet rs = stm.executeQuery();
            rs.next();
            sw.setId(rs.getInt("scientific_work_id"));
            sw.setTitle(rs.getString("title"));
            sw.setType(rs.getString("type"));
            sw.setScientistId(rs.getInt("scientist_id"));
            sw.setYear(rs.getInt("year"));
        }
        return sw;
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
