package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import domain.ScientificTheme;
import domain.Supervision;
import main.Main;
public class ScientificThemeDao 
{
	
    /** @throws SQLException */
    public void addTheme(ScientificTheme st) throws SQLException 
    {
		String sql = "INSERT INTO scientifictheme (scientific_theme_id, title, customer, start, cathedra_id) VALUES (?,?,?,?,?)";
 	  	PreparedStatement stm = Main.conn.prepareStatement(sql);
 	  	
		int i = -1;
		String sql_for_id = "SELECT MAX(scientific_theme_id) from scientifictheme";
		PreparedStatement statement_for_id = Main.conn.prepareStatement(sql_for_id);
		statement_for_id.executeQuery();
		ResultSet result = statement_for_id.getResultSet();
		if((result!=null) && (result.next()))i = result.getInt(1);
		stm.setInt(1,i+1);
    	stm.setString(2, st.getTitle());
    	stm.setString(3, st.getCustomer());
    	stm.setDate(4, st.getStart());
    	stm.setInt(5, st.getCathedraId());
    	stm.executeUpdate();
    	JOptionPane.showMessageDialog (null, "Нова наукова тема успішно створена!" );
	}

    /** @throws SQLException */
    public ScientificTheme readTheme(int key) throws SQLException 
    {
        String sql = "SELECT * FROM scientifictheme WHERE scientific_theme_id = ?";
        ScientificTheme st = new ScientificTheme();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) 
        {
            stm.setInt(1, key);
            ResultSet rs = stm.executeQuery();
            rs.next();
            st.setId(rs.getInt("scientific_theme_id"));
            st.setTitle(rs.getString("title"));
            st.setCustomer(rs.getString("customer"));
            st.setStart(rs.getDate("start"));
            st.setEnd(rs.getDate("end"));
            st.setCathedraId(rs.getInt("cathedra_id"));
        }
        return st;
	}

    
    /**@throws SQLException */
    public void updateTheme(ScientificTheme st) throws SQLException 
    {
    	String sql = "update scientifictheme set title = ?, customer = ? where scientific_theme_id = " +  st.getId();
    	PreparedStatement stm = Main.conn.prepareStatement(sql);
    	stm.setString(1, st.getTitle());
    	stm.setString(2, st.getCustomer());
    	stm.executeUpdate();
    	JOptionPane.showMessageDialog (null, "Научна тема успішно відредагована!" ); 
	}
    
    
    public void finishTheme(ScientificTheme st) throws SQLException 
    {
    	String sql = "update scientifictheme set end = ? where scientific_theme_id = " +  st.getId();
    	PreparedStatement stm = Main.conn.prepareStatement(sql);
    	stm.setDate(1, st.getEnd());
    	stm.executeUpdate();
    	
    	String sql1 = "update supervision set end = ? where ruler = 1 and scientific_theme_id = " +  st.getId();
    	PreparedStatement stm1 = Main.conn.prepareStatement(sql1);
    	stm1.setDate(1, st.getEnd());
    	stm1.executeUpdate();
    	
    	String sql2 = "update working set end = ? where end is null and scientific_theme_id = " +  st.getId();
    	PreparedStatement stm2 = Main.conn.prepareStatement(sql2);
    	stm2.setDate(1, st.getEnd());
    	stm2.executeUpdate();
    	
    	JOptionPane.showMessageDialog (null, "Робота з темою закінчена!" ); 
	}

    /** @throws SQLException */ 
    public void deleteTheme(ScientificTheme st) throws SQLException 
    {
    	String sql = "DELETE FROM scientifictheme WHERE scientific_theme_id = " + st.getId();
    	try (Statement stm = Main.conn.createStatement())
    	{
            stm.executeUpdate(sql);
    	}
    	JOptionPane.showMessageDialog (null, "Научна тема успішно видалена!" );
	}

   
    public List<ScientificTheme> getAll() throws SQLException 
    {
        String sql = "SELECT * FROM scientifictheme;";
        List<ScientificTheme> list = new ArrayList<ScientificTheme>();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	ScientificTheme st = new ScientificTheme();
                st.setId(rs.getInt("scientific_theme_id"));
                st.setTitle(rs.getString("title"));
                st.setCustomer(rs.getString("customer"));
                st.setStart(rs.getDate("start"));
                st.setEnd(rs.getDate("end"));
                st.setCathedraId(rs.getInt("cathedra_id"));
                list.add(st);
            }
        }
        return list;
    }
    
    
    
    public List<ScientificTheme> getAllInCathedra(int cathedra_id) throws SQLException 
    {
        String sql = "SELECT * FROM scientifictheme WHERE cathedra_id IN"
        		+ "(SELECT cathedra_id FROM cathedra WHERE cathedra_id = " + cathedra_id + ");";
        List<ScientificTheme> list = new ArrayList<ScientificTheme>();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	ScientificTheme st = new ScientificTheme();
                st.setId(rs.getInt("scientific_theme_id"));
                st.setTitle(rs.getString("title"));
                st.setCustomer(rs.getString("customer"));
                st.setStart(rs.getDate("start"));
                st.setEnd(rs.getDate("end"));
                st.setCathedraId(rs.getInt("cathedra_id"));
                list.add(st);
            }
        }
        return list;
    }
    
    
    
    public String getCathedraName(int key) throws SQLException
    {
    	String sql = "select name from cathedra where cathedra_id in (select cathedra_id from scientifictheme where scientific_theme_id = " + key + ")";
		Statement s = Main.conn.createStatement();
 	  	ResultSet rs = s.executeQuery(sql);
 	  	String name = null;
 	  	while (rs.next()) {
 	  		name = rs.getString("name");
 	  	}
		return name; 
    }

    
    
    
    public List<Supervision> getAllSupervisors(int scientific_theme_id) throws SQLException 
    {
        String sql = "SELECT * FROM supervision WHERE scientific_theme_id = " + scientific_theme_id;
        List<Supervision> list = new ArrayList<Supervision>();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Supervision s = new Supervision();
	            s.setSupervisorId(rs.getInt("supervisor_id"));
	            s.setScientificThemeId(rs.getInt("scientific_theme_id"));
	            s.setScientistId(rs.getInt("teacher_scientist_id"));
	            s.setStart(rs.getDate("start"));
	            s.setEnd(rs.getDate("end"));
	            s.setRuler(rs.getBoolean("ruler"));
                list.add(s);
            }
        }
        return list;
    }
}


