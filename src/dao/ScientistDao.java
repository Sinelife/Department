package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Scientist;
import main.Main;

public class ScientistDao 
{
	public void addScientist(Scientist s) throws SQLException 
    {
		String sql = "INSERT INTO scientist (scientist_id, surname, sex, phone) VALUES (?,?,?,?)";
		PreparedStatement stm = Main.conn.prepareStatement(sql);
		int i = -1;
		String sql_for_id = "SELECT MAX(scientist_id) from scientist";
		PreparedStatement statement_for_id = Main.conn.prepareStatement(sql_for_id);
		statement_for_id.executeQuery();
		ResultSet result = statement_for_id.getResultSet();
		if((result!=null) && (result.next()))i = result.getInt(1);
		stm.setInt(1,i+1);
    	stm.setString(2, s.getSurname());
    	stm.setBoolean(3, s.getSex());
    	stm.setString(4, s.getPhone());
    	stm.executeUpdate();
	}

	
    public Scientist readScientist(int scientist_id) throws SQLException 
    {
        String sql = "SELECT * FROM scientist WHERE scientist_id = ?";
        Scientist s = new Scientist();
        try (PreparedStatement stm = Main.conn.prepareStatement(sql)) 
        {
            stm.setInt(1, scientist_id);
            ResultSet rs = stm.executeQuery();
            rs.next();
            s.setSurname(rs.getString("surname"));
            s.setPhone(rs.getString("phone"));
            s.setSex(rs.getBoolean("sex"));
        }
        return s;
	}
}
