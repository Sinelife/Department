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
import domain.Scientist;
import domain.Teacher;

public class TeacherDao 
{
	public void addTeacher(Teacher t, Scientist s) throws SQLException 
    {
		String sql1 = "INSERT INTO scientist (scientist_id, surname, sex, phone) VALUES (?,?,?,?)";
		PreparedStatement stm1 = Main.conn.prepareStatement(sql1);
		
		String sql2 = "INSERT INTO teacher (scientist_id, cathedra_id, position, status, start_date) VALUES (?,?,?,?,?)";
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
    	stm2.setInt(1,i+1);
    	stm2.setInt(2, t.getCathedraId());
    	stm2.setString(3, t.getPosition());
    	stm2.setString(4, t.getStatus());
    	stm2.setDate(5, t.getStart());
    	stm2.executeUpdate();
    	JOptionPane.showMessageDialog (null, "����� �������� ������ �������!" );
	}
    
    
	public void updateTeacher(Teacher t, Scientist s) throws SQLException 
	{
		String sql1 = "update scientist set surname = ?, sex = ?, phone = ? where scientist_id = " + s.getId();
		PreparedStatement stm1 = Main.conn.prepareStatement(sql1);
		
		String sql2 = "update teacher set position = ?, status = ?, start_date = ? where scientist_id = " + s.getId();
 	  	PreparedStatement stm2 = Main.conn.prepareStatement(sql2);

		stm1.setString(1, s.getSurname());
    	stm1.setBoolean(2, s.getSex());
    	stm1.setString(3, s.getPhone());
    	stm1.executeUpdate();
    	
    	stm2.setString(1, t.getPosition());
    	stm2.setString(2, t.getStatus());
    	stm2.setDate(3, t.getStart());
    	stm2.executeUpdate();
    	JOptionPane.showMessageDialog (null, "���������� ��� ��������� ������ ������������!" );
	}
	

    /** @throws SQLException */
    public Teacher readTeacher(int key) throws SQLException 
    {
        String sql = "SELECT * FROM teacher WHERE scientist_id = ?";
        Teacher t = new Teacher();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) 
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


    
    public List<Teacher> getAll() throws SQLException 
    {
        String sql = "SELECT * FROM teacher";
        List<Teacher> list = new ArrayList<Teacher>();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) {
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
    
   
    
    public List<Teacher> getAllFromCathedraExceptSupervisor(int scientific_theme_id, int cathedra_id) throws SQLException 
    {
        String sql = "SELECT * FROM teacher WHERE cathedra_id in (SELECT cathedra_id FROM cathedra WHERE cathedra_id = " + cathedra_id + ") and scientist_id not in (select teacher_scientist_id from supervision where ruler = 1 and scientific_theme_id = " + scientific_theme_id + ")";
        List<Teacher> list = new ArrayList<Teacher>();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) {
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
    
    
    public List<Teacher> getAllFromCathedra(int cathedra_id) throws SQLException 
    {
        String sql = "SELECT * FROM teacher WHERE cathedra_id = " + cathedra_id;
        List<Teacher> list = new ArrayList<Teacher>();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) {
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
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) {
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
    
    
    
    public List<Teacher> getAllFromThemeNotAspirant(int key) throws SQLException 
    {
    	String sql = "SELECT * FROM teacher WHERE scientist_id in (SELECT scientist_id FROM working WHERE scientific_theme_id = " + key + ") "
    				+ "and scientist_id not in (select scientist_id from aspirant)";
        List<Teacher> list = new ArrayList<Teacher>();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) {
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
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) {
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
    
    public boolean getSex(int key) throws SQLException
    {
    	String sql = "select sex from scientist where scientist_id = " + key;
		Statement s = Main.conn.createStatement();
 	  	ResultSet rs = s.executeQuery(sql);
 	  	boolean sex = false;
 	  	while (rs.next()) {
 	  		sex = rs.getBoolean("sex");
 	  	}
		return sex; 
    }
    
    
    public List<ScientificTheme> getAllThemesSupervisedByTeacher(int scientist_id) throws SQLException 
    {
    	String sql = "select * from scientifictheme where scientific_theme_id in "
    				+ "(select scientific_theme_id from supervision where ruler = 1 and teacher_scientist_id = " + scientist_id + ")";
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
    
    
    public List<ScientificTheme> getAllThemesOnWhichWorkTeacher(int scientist_id) throws SQLException 
    {
    	String sql = "select * from scientifictheme where scientific_theme_id in "
    				+ "(select scientific_theme_id from working where scientist_id = " + scientist_id + ")";
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
    
    
    public List<Aspirant> getAllAspirantsWhichRulerIs(int scientist_id) throws SQLException 
    {
    	String sql = "select * from aspirant where teacher_scientist_id = " + scientist_id;
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
    
}
