package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MainMenu.MainMenu;
import domain.Teacher;
import domain.ScientificTheme;

public class TeacherDao 
{
	public void create(ScientificTheme st) 
    {

	}
    
    

    /** @throws SQLException */
    public Teacher read(int key) throws SQLException 
    {
        String sql = "SELECT * FROM teacher WHERE scientist_id = ?";
        Teacher t = new Teacher();
        try (PreparedStatement stm = MainMenu.conn.prepareStatement(sql)) 
        {
            stm.setInt(1, key);
            ResultSet rs = stm.executeQuery();
            rs.next();
            t.setId(rs.getInt("scientist_id"));
            t.setPosition(rs.getString("position"));
            t.setStatus(rs.getString("status"));
            t.setStart(rs.getDate("start_date"));
            t.setCathedraId(rs.getInt("cathedra_id"));
        }
        return t;
	}


   
    
    public List<Teacher> getAllFromCathedraExceptSupervisor(int scientific_theme_id, int cathedra_id) throws SQLException 
    {
        String sql = "SELECT * FROM teacher WHERE cathedra_id in (SELECT cathedra_id FROM cathedra WHERE cathedra_id = " + cathedra_id + ") and scientist_id not in (SELECT teacher_scientist_id FROM supervision WHERE scientific_theme_id = " + scientific_theme_id + ")";
        List<Teacher> list = new ArrayList<Teacher>();
        try (PreparedStatement stm = MainMenu.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Teacher t = new Teacher();
                t.setId(rs.getInt("scientist_id"));
                t.setPosition(rs.getString("position"));
                t.setStatus(rs.getString("status"));
                t.setStart(rs.getDate("start_date"));
                t.setCathedraId(rs.getInt("cathedra_id"));
                list.add(t);
            }
        }
        return list;
    }
    
    
    public List<Teacher> getAllFromCathedra(int key) throws SQLException 
    {
        String sql = "SELECT * FROM teacher WHERE cathedra_id in (SELECT cathedra_id FROM cathedra WHERE cathedra_id = " + key + ")";
        List<Teacher> list = new ArrayList<Teacher>();
        try (PreparedStatement stm = MainMenu.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Teacher t = new Teacher();
                t.setId(rs.getInt("scientist_id"));
                t.setPosition(rs.getString("position"));
                t.setStatus(rs.getString("status"));
                t.setStart(rs.getDate("start_date"));
                t.setCathedraId(rs.getInt("cathedra_id"));
                list.add(t);
            }
        }
        return list;
    }
    
    
    public List<Teacher> getAllFromTheme(int key) throws SQLException 
    {
    	String sql = "SELECT * FROM teacher WHERE scientist_id in (SELECT scientist_id FROM working WHERE scientific_theme_id = " + key + ")";
        List<Teacher> list = new ArrayList<Teacher>();
        try (PreparedStatement stm = MainMenu.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Teacher t = new Teacher();
                t.setId(rs.getInt("scientist_id"));
                t.setPosition(rs.getString("position"));
                t.setStatus(rs.getString("status"));
                t.setStart(rs.getDate("start_date"));
                t.setCathedraId(rs.getInt("cathedra_id"));
                list.add(t);
            }
        }
        return list;
    }
    
    
    public List<Teacher> getAllNotFromThemeNotFromCathedra(int scientific_theme_id, int cathedra_id) throws SQLException 
    {
    	String sql = "SELECT * FROM teacher WHERE scientist_id not in (SELECT scientist_id FROM working WHERE scientific_theme_id = " + scientific_theme_id + ") and cathedra_id <> " + cathedra_id;
        List<Teacher> list = new ArrayList<Teacher>();
        try (PreparedStatement stm = MainMenu.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Teacher t = new Teacher();
                t.setId(rs.getInt("scientist_id"));
                t.setPosition(rs.getString("position"));
                t.setStatus(rs.getString("status"));
                t.setStart(rs.getDate("start_date"));
                t.setCathedraId(rs.getInt("cathedra_id"));
                list.add(t);
            }
        }
        return list;
    }
    
    
    public String getCathedraName(int key) throws SQLException
    {
    	String sql = "select name from cathedra where cathedra_id in (select cathedra_id from teacher where scientist_id = " + key + ")";
		Statement s = MainMenu.conn.createStatement();
 	  	ResultSet rs = s.executeQuery(sql);
 	  	String name = null;
 	  	while (rs.next()) {
 	  		name = rs.getString("name");
 	  	}
		return name; 
    }
    
    public String getSurname(int key) throws SQLException
    {
    	String sql = "select surname from scientist where scientist_id = " + key;
		Statement s = MainMenu.conn.createStatement();
 	  	ResultSet rs = s.executeQuery(sql);
 	  	String surname = null;
 	  	while (rs.next()) {
 	  		surname = rs.getString("surname");
 	  	}
		return surname; 
    }
    
    public String getPhone(int key) throws SQLException
    {
    	String sql = "select phone from scientist where scientist_id = " + key;
		Statement s = MainMenu.conn.createStatement();
 	  	ResultSet rs = s.executeQuery(sql);
 	  	String phone = null;
 	  	while (rs.next()) {
 	  		phone = rs.getString("phone");
 	  	}
		return phone; 
    }
}
