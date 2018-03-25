package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import MainMenu.EditTheme;
import MainMenu.MainMenu;
import domain.ScientificTheme;

public class ScientificThemeDao 
{
	
    /** @throws SQLException */
    public void addTheme(ScientificTheme st) throws SQLException 
    {
		String sql = "INSERT INTO scientifictheme (scientific_theme_id, title, customer, start, end, cathedra_id) VALUES (?,?,?,?,?,?)";
 	  	PreparedStatement stm = MainMenu.conn.prepareStatement(sql);
 	  	
		int i = -1;
		String sql_for_id = "SELECT MAX(scientific_theme_id) from scientifictheme";
		PreparedStatement statement_for_id = MainMenu.conn.prepareStatement(sql_for_id);
		statement_for_id.executeQuery();
		ResultSet result = statement_for_id.getResultSet();
		if((result!=null) && (result.next()))i = result.getInt(1);
		stm.setInt(1,i+1);
    	stm.setString(2, st.getTitle());
    	stm.setString(3, st.getCustomer());
    	stm.setDate(4, st.getStart());
    	stm.setDate(5, st.getEnd());
    	stm.setInt(6, st.getCathedraId());
    	stm.executeUpdate();
    	JOptionPane.showMessageDialog (null, "Нова наукова тема успішно створена!" );
	}

    /** @throws SQLException */
    public ScientificTheme readTheme(int key) throws SQLException 
    {
        String sql = "SELECT * FROM scientifictheme WHERE scientific_theme_id = ?";
        ScientificTheme st = new ScientificTheme();
        try (PreparedStatement stm = MainMenu.conn.prepareStatement(sql)) 
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
    	String sql = "update scientifictheme set title = ?, customer = ?, start = ?, end = ? where scientific_theme_id = " +  st.getId();
    	PreparedStatement stm = MainMenu.conn.prepareStatement(sql);
    	stm.setString(1, st.getTitle());
    	stm.setString(2, st.getCustomer());
    	stm.setDate(3, st.getStart());
    	stm.setDate(4, st.getEnd());
    	stm.executeUpdate();
    	JOptionPane.showMessageDialog (null, "Научна тема успішно відредагована!" ); 
	}

    /** @throws SQLException */ 
    public void deleteTheme(ScientificTheme st) throws SQLException 
    {
    	String sql = "DELETE FROM scientifictheme WHERE scientific_theme_id = " + st.getId();
    	try (Statement stm = MainMenu.conn.createStatement())
    	{
            stm.executeUpdate(sql);
    	}
    	JOptionPane.showMessageDialog (null, "Научна тема успішно видалена!" );
	}

   
    public List<ScientificTheme> getAll() throws SQLException 
    {
        String sql = "SELECT * FROM scientifictheme;";
        List<ScientificTheme> list = new ArrayList<ScientificTheme>();
        try (PreparedStatement stm = MainMenu.conn.prepareStatement(sql)) {
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
		Statement s = MainMenu.conn.createStatement();
 	  	ResultSet rs = s.executeQuery(sql);
 	  	String name = null;
 	  	while (rs.next()) {
 	  		name = rs.getString("name");
 	  	}
		return name; 
    }

}


