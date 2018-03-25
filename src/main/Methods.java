package main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import dao.ScientificThemeDao;
import domain.Cathedra;
import domain.ScientificTheme;

public class Methods 
{
	public static void DateToString(Date d,JTextField t)
	{
		String res = null;
		if(d == null)
		{
			res = "";
			t.setText(res);
		}
		else
		{
			t.setText(String.valueOf(d));
		}
	}
	
	
	
	
	//МЕТОДИ ДЛЯ ОТРИМАННЯ АЙДІШНИКА ОБ'ЄКТА ЧЕРЕЗ І'МЯ
	
	//Метод для отримання айдішника постачальника через ім'я постачальника
	
	public static int getThemeIdByThemeTitle(String title, int id, JComboBox<String> ComboBox,List<ScientificTheme> themes)
	{
		title = String.valueOf(ComboBox.getSelectedItem());
		for(ScientificTheme theme : themes) 
		{
			id = theme.getId();
			if(theme.getTitle().equals(title))
			{
				break;
			}
		}
		return id;
	}
	
	
	public static int getCathedraIdByCathedraName(String name, int id, JComboBox<String> ComboBox,List<Cathedra> cathedras)
	{
		name = String.valueOf(ComboBox.getSelectedItem());
		for(Cathedra cathedra : cathedras) 
		{
			id = cathedra.getId();
			if(cathedra.getName().equals(name))
			{
				break;
			}
		}
		return id;
	}
	
	
	

	// МЕТОДИ ДЛЯ ДОДАВАННЯ РІЗНИХ ОБЄКТІВ ДО БД

	// Метод додавання теми

	public static void addTheme(int cathedra_id, JTextField TitleField, JTextField CustomerField, JTextField StartField,
			JTextField EndField)
	{
		ScientificThemeDao std = new ScientificThemeDao();
		ScientificTheme st = new ScientificTheme();
		st.setTitle(TitleField.getText());
		st.setCustomer(CustomerField.getText());
		st.setStart(Date.valueOf(StartField.getText()));
	  	if(EndField.getText().equals("null"))
	  	{
	  		st.setEnd(null);
	  	}
	  	else
	  	{
	  		st.setEnd(Date.valueOf(EndField.getText()));
	  	}
		st.setCathedraId(cathedra_id);
	  		try {
			std.addTheme(st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// Метод оновлення теми
	
	public static void updateTheme(JTextField TitleField, JTextField CustomerField, JTextField StartField,
			JTextField EndField)
	{
		ScientificThemeDao std = new ScientificThemeDao();
		ScientificTheme st = new ScientificTheme();
		st.setTitle(TitleField.getText());
		st.setCustomer(CustomerField.getText());
		st.setStart(Date.valueOf(StartField.getText()));
	  		if(EndField.getText().equals("null"))
	  		{
	  			st.setEnd(null);
	  		}
	  		else
	  		{
	  			st.setEnd(Date.valueOf(EndField.getText()));
	  		}
		try {
			std.updateTheme(st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
