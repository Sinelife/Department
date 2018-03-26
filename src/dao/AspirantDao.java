package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.Main;
import domain.Aspirant;
import domain.ScientificTheme;

public class AspirantDao 
{

    

    /** @throws SQLException */
    public Aspirant readAspirant(int key) throws SQLException 
    {
        String sql = "SELECT * FROM aspirant WHERE scientist_id = ?";
        Aspirant a = new Aspirant();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) 
        {
            stm.setInt(1, key);
            ResultSet rs = stm.executeQuery();
            rs.next();
            a.setId(rs.getInt("scientist_id"));
            a.setThemeAspirant(rs.getString("theme_aspirant"));
            a.setProtection(rs.getDate("protection_date"));
            a.setStart(rs.getDate("start"));
            a.setEnd(rs.getDate("end"));
            a.setCathedraId(rs.getInt("cathedra_id"));
            a.setTeacherScientistId(rs.getInt("teacher_scientist_id"));
        }
        return a;
	}

    
    
    public void update(ScientificTheme st) 
    {

	}

    
    public void delete(ScientificTheme st) throws SQLException 
    {

	}

   
    public List<Aspirant> getAll() throws SQLException 
    {
        String sql = "SELECT * FROM aspirant;";
        List<Aspirant> list = new ArrayList<Aspirant>();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Aspirant a = new Aspirant();
                a.setId(rs.getInt("scientist_id"));
                a.setThemeAspirant(rs.getString("theme_aspirant"));
                a.setProtection(rs.getDate("protection_date"));
                a.setStart(rs.getDate("start"));
                a.setEnd(rs.getDate("end"));
                a.setCathedraId(rs.getInt("cathedra_id"));
                a.setTeacherScientistId(rs.getInt("teacher_scientist_id"));
                list.add(a);
            }
        }
        return list;
    }
    
    
    public List<Aspirant> getAllFromTheme(int key) throws SQLException 
    {
    	String sql = "SELECT * FROM aspirant WHERE scientist_id in (SELECT scientist_id FROM working WHERE scientific_theme_id = " + key + ")";
        List<Aspirant> list = new ArrayList<Aspirant>();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Aspirant a = new Aspirant();
                a.setId(rs.getInt("scientist_id"));
                a.setThemeAspirant(rs.getString("theme_aspirant"));
                a.setProtection(rs.getDate("protection_date"));
                a.setStart(rs.getDate("start"));
                a.setEnd(rs.getDate("end"));
                a.setCathedraId(rs.getInt("cathedra_id"));
                a.setTeacherScientistId(rs.getInt("teacher_scientist_id"));
                list.add(a);
            }
        }
        return list;
    }
    
    
    public List<Aspirant> getAllNotFromTheme(int key) throws SQLException 
    {
    	String sql = "SELECT * FROM aspirant WHERE scientist_id not in (SELECT scientist_id FROM working WHERE scientific_theme_id = " + key + ")";
        List<Aspirant> list = new ArrayList<Aspirant>();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Aspirant a = new Aspirant();
                a.setId(rs.getInt("scientist_id"));
                a.setThemeAspirant(rs.getString("theme_aspirant"));
                a.setProtection(rs.getDate("protection_date"));
                a.setStart(rs.getDate("start"));
                a.setEnd(rs.getDate("end"));
                a.setCathedraId(rs.getInt("cathedra_id"));
                a.setTeacherScientistId(rs.getInt("teacher_scientist_id"));
                list.add(a);
            }
        }
        return list;
    }
    
    
    public List<Aspirant> getAllFromCathedra(int cathedra_id) throws SQLException 
    {
    	String sql = "SELECT * FROM aspirant WHERE cathedra_id = " + cathedra_id ;
        List<Aspirant> list = new ArrayList<Aspirant>();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Aspirant a = new Aspirant();
                a.setId(rs.getInt("scientist_id"));
                a.setThemeAspirant(rs.getString("theme_aspirant"));
                a.setProtection(rs.getDate("protection_date"));
                a.setStart(rs.getDate("start"));
                a.setEnd(rs.getDate("end"));
                a.setCathedraId(rs.getInt("cathedra_id"));
                a.setTeacherScientistId(rs.getInt("teacher_scientist_id"));
                list.add(a);
            }
        }
        return list;
    }
    
    
    
    public String getCathedraName(int key) throws SQLException
    {
    	String sql = "select name from cathedra where cathedra_id in (select cathedra_id from aspirant where scientist_id = " + key + ")";
		Statement s = Main.conn.createStatement();
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
		Statement s = Main.conn.createStatement();
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
		Statement s = Main.conn.createStatement();
 	  	ResultSet rs = s.executeQuery(sql);
 	  	String phone = null;
 	  	while (rs.next()) {
 	  		phone = rs.getString("phone");
 	  	}
		return phone; 
    }
    
    

}
