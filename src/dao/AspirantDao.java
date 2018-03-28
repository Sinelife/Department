package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import main.Main;
import domain.Aspirant;
import domain.ScientificTheme;
import domain.ScientificWork;
import domain.Scientist;

public class AspirantDao 
{

	public void addAspirant(Aspirant a, Scientist s) throws SQLException 
    {
		String sql1 = "INSERT INTO scientist (scientist_id, surname, sex, phone) VALUES (?,?,?,?)";
		PreparedStatement stm1 = Main.conn.prepareStatement(sql1);
		
		String sql2 = "INSERT INTO aspirant (scientist_id, cathedra_id, start, end, protection_date, theme_aspirant, teacher_scientist_id) VALUES (?,?,?,?,?,?,?)";
 	  	PreparedStatement stm2 = Main.conn.prepareStatement(sql2);
		int i = -1;
		String sql_for_id = "SELECT MAX(scientist_id) from scientist";
		PreparedStatement statement_for_id = Main.conn.prepareStatement(sql_for_id);
		statement_for_id.executeQuery();
		ResultSet result = statement_for_id.getResultSet();
		if((result!=null) && (result.next()))i = result.getInt(1);
		stm1.setInt(1,i+1);
    	stm1.setString(2, s.getSurname());
    	stm1.setBoolean(3, s.getSex());
    	stm1.setString(4, s.getPhone());
    	stm1.executeUpdate();
    	stm2.setInt(1, i+1);
    	stm2.setInt(2, a.getCathedraId());
    	stm2.setDate(3, a.getStart());
    	stm2.setDate(4, a.getEnd());
    	stm2.setDate(5, a.getProtection());
    	stm2.setString(6, a.getThemeAspirant());
    	stm2.setInt(7, a.getTeacherScientistId());
    	stm2.executeUpdate();
    	JOptionPane.showMessageDialog (null, "Новий аспірант успішно доданий!" );
	}
	
	
	public void updateAspirant(Aspirant a, Scientist s) throws SQLException 
	{
		String sql1 = "update scientist set surname = ?, sex = ?, phone = ? where scientist_id = " + s.getId();
		PreparedStatement stm1 = Main.conn.prepareStatement(sql1);
		
		String sql2 = "update aspirant set start = ?, end = ?, protection_date = ?, theme_aspirant = ?, teacher_scientist_id = ? where scientist_id = " + s.getId();
 	  	PreparedStatement stm2 = Main.conn.prepareStatement(sql2);

		stm1.setString(1, s.getSurname());
    	stm1.setBoolean(2, s.getSex());
    	stm1.setString(3, s.getPhone());
    	stm1.executeUpdate();
    	
    	stm2.setDate(1, a.getStart());
    	stm2.setDate(2, a.getEnd());
    	stm2.setDate(3, a.getProtection());
    	stm2.setString(4, a.getThemeAspirant());
    	stm2.setInt(5, a.getTeacherScientistId());
    	stm2.executeUpdate();
    	JOptionPane.showMessageDialog (null, "Інформація про аспіранта успішно відредагована!" );
	}
	
	
	

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
    
    
    public List<Aspirant> getAllWhoFinished() throws SQLException 
    {
        String sql = "SELECT * FROM aspirant where end is not null";
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
    
    
    public List<Aspirant> getAllFromCathedraWhoFinished(int cathedra_id) throws SQLException 
    {
    	String sql = "SELECT * FROM aspirant WHERE end is not null and cathedra_id = " + cathedra_id ;
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
    
    
    public String getCathedraName(int scientist_id) throws SQLException
    {
    	String sql = "select name from cathedra where cathedra_id in (select cathedra_id from aspirant where scientist_id = " + scientist_id + ")";
		Statement s = Main.conn.createStatement();
 	  	ResultSet rs = s.executeQuery(sql);
 	  	String name = null;
 	  	while (rs.next()) {
 	  		name = rs.getString("name");
 	  	}
		return name; 
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
    
    public String getPhone(int scientist_id) throws SQLException
    {
    	String sql = "select phone from scientist where scientist_id = " + scientist_id;
		Statement s = Main.conn.createStatement();
 	  	ResultSet rs = s.executeQuery(sql);
 	  	String phone = null;
 	  	while (rs.next()) {
 	  		phone = rs.getString("phone");
 	  	}
		return phone; 
    }
    
    
    public boolean getSex(int scientist_id) throws SQLException
    {
    	String sql = "select sex from scientist where scientist_id = " + scientist_id;
		Statement s = Main.conn.createStatement();
 	  	ResultSet rs = s.executeQuery(sql);
 	  	boolean sex = false;
 	  	while (rs.next()) {
 	  		sex = rs.getBoolean("sex");
 	  	}
		return sex; 
    }
    
    
    
    public String getRuler(int scientist_id) throws SQLException
    {
    	String sql = "select surname from scientist where scientist_id in "
    			+ "(select teacher_scientist_id from aspirant where scientist_id = " + scientist_id + ")";
		Statement s = Main.conn.createStatement();
 	  	ResultSet rs = s.executeQuery(sql);
 	  	String surname = null;
 	  	while (rs.next()) {
 	  		surname = rs.getString("surname");
 	  	}
		return surname; 
    }
    
    
    
    public List<ScientificWork> getAllAspirantWorks(int scientist_id) throws SQLException 
    {
    	String sql = "SELECT * FROM scientificwork WHERE scientist_id = " + scientist_id ;
        List<ScientificWork> list = new ArrayList<ScientificWork>();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	ScientificWork sw = new ScientificWork();
                sw.setId(rs.getInt("scientific_work_id"));
                sw.setTitle(rs.getString("title"));
                sw.setType(rs.getString("type"));
                sw.setScientistId(rs.getInt("scientist_id"));
                sw.setYear(rs.getInt("year"));
                list.add(sw);
            }
        }
        return list;
    }

}
