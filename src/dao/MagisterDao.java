package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MainMenu.MainMenu;
import domain.Magister;

public class MagisterDao 
{
    /** @throws SQLException */
    public Magister read(int key) throws SQLException 
    {
        String sql = "SELECT * FROM magister WHERE scientist_id = ?";
        Magister m = new Magister();
        try (PreparedStatement stm1 = MainMenu.conn.prepareStatement(sql)) 
        {
            stm1.setInt(1, key);
            ResultSet rs = stm1.executeQuery();
            rs.next();
            m.setId(rs.getInt("scientist_id"));
            m.setThemeMagister(rs.getString("theme_magister"));
            m.setReason(rs.getString("reason"));
            m.setStart(rs.getDate("start"));
            m.setEnd(rs.getDate("end"));
            m.setCathedraId(rs.getInt("cathedra_id"));
            m.setTeacherScientistId(rs.getInt("teacher_scientist_id"));
        }
        /*
        try (PreparedStatement stm2 = MainMenu.conn.prepareStatement(sql_cathedra)) 
        {
        	stm2.setInt(1, key);
        	ResultSet rs = stm2.executeQuery();
        	m.getCathedra().getName()
        }*/
        return m;
	}

   
    public List<Magister> getAllFromTheme(int key) throws SQLException 
    {
        String sql = "SELECT * FROM magister WHERE scientist_id in (SELECT scientist_id FROM working WHERE scientific_theme_id = " + key + ");";
        List<Magister> list = new ArrayList<Magister>();
        try (PreparedStatement stm = MainMenu.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Magister m = new Magister();
                m.setId(rs.getInt("scientist_id"));
                m.setThemeMagister(rs.getString("theme_magister"));
                m.setReason(rs.getString("reason"));
                m.setStart(rs.getDate("start"));
                m.setEnd(rs.getDate("end"));
                m.setCathedraId(rs.getInt("cathedra_id"));
                m.setTeacherScientistId(rs.getInt("teacher_scientist_id"));
                list.add(m);
            }
        }
        return list;
    }
    
    
    public List<Magister> getAllNotFromTheme(int key) throws SQLException 
    {
    	String sql = "SELECT * FROM magister WHERE scientist_id not in (SELECT scientist_id FROM working WHERE scientific_theme_id = " + key + ")";
        List<Magister> list = new ArrayList<Magister>();
        try (PreparedStatement stm = MainMenu.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Magister m = new Magister();
                m.setId(rs.getInt("scientist_id"));
                m.setThemeMagister(rs.getString("theme_magister"));
                m.setReason(rs.getString("reason"));
                m.setStart(rs.getDate("start"));
                m.setEnd(rs.getDate("end"));
                m.setCathedraId(rs.getInt("cathedra_id"));
                m.setTeacherScientistId(rs.getInt("teacher_scientist_id"));
                list.add(m);
            }
        }
        return list;
    }
    
    
    public List<Magister> getAllNotFromThisCathedra(int cathedra_id) throws SQLException 
    {
        String sql = "SELECT * FROM magister WHERE cathedra_id <> " + cathedra_id;
        List<Magister> list = new ArrayList<Magister>();
        try (PreparedStatement stm = MainMenu.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Magister m = new Magister();
                m.setId(rs.getInt("scientist_id"));
                m.setThemeMagister(rs.getString("theme_magister"));
                m.setReason(rs.getString("reason"));
                m.setStart(rs.getDate("start"));
                m.setEnd(rs.getDate("end"));
                m.setCathedraId(rs.getInt("cathedra_id"));
                m.setTeacherScientistId(rs.getInt("teacher_scientist_id"));
            }
        }
        return list;
    }
    
    
    public String getCathedraName(int key) throws SQLException
    {
    	String sql = "select name from cathedra where cathedra_id in (select cathedra_id from magister where scientist_id = " + key + ")";
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
