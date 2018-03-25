package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import MainMenu.MainMenu;
import domain.Cathedra;
import domain.ScientificTheme;

public class CathedraDao 
{
    public List<Cathedra> getAll() throws SQLException 
    {
        String sql = "SELECT * FROM cathedra;";
        List<Cathedra> list = new ArrayList<Cathedra>();
        try (PreparedStatement stm = MainMenu.conn.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Cathedra c = new Cathedra();
                c.setId(rs.getInt("cathedra_id"));
                c.setName(rs.getString("name"));
                c.setPhone(rs.getString("phone"));
                list.add(c);
            }
        }
        return list;
    }
}
