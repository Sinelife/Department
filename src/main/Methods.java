package main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import MainMenu.ChooseTheme;
import dao.ScientificThemeDao;
import dao.SupervisionDao;
import dao.TeacherDao;
import domain.Aspirant;
import domain.Cathedra;
import domain.Magister;
import domain.ScientificTheme;
import domain.Supervision;
import domain.Teacher;

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
	
	//Метод для отримання айдішника наукової теми через назву теми
	
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
	
	
	//Метод для отримання айдішника кафедри через назву кафедри
	
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
	
	
	//Метод для отримання айдішника викладача за прізвищем
	
	public static int getTeacherIdBySurname(String surname, int id, JComboBox<String> ComboBox,List<Teacher> teachers) throws SQLException
	{
		TeacherDao td = new TeacherDao();
		surname = String.valueOf(ComboBox.getSelectedItem());
		for(Teacher teacher : teachers) 
		{
			id = teacher.getId();
			if(td.getSurname(teacher.getId()).equals(surname))
			{
				break;
			}
		}
		return id;
	}
	
	
	//Метод для отримання айдішника аспіранта за прізвищем
	
	public static int getAspirantIdBySurname(String surname, int id, JComboBox<String> ComboBox,List<Aspirant> aspirants)
	{
		surname = String.valueOf(ComboBox.getSelectedItem());
		for(Aspirant aspirant : aspirants) 
		{
			id = aspirant.getId();
			if(aspirant.getSurname().equals(surname))
			{
				break;
			}
		}
		return id;
	}
	
	
	//Метод для отримання айдішника магістра за прізвищем
	
	public static int getMagisterIdBySurname(String surname, int id, JComboBox<String> ComboBox,List<Magister> magisters)
	{
		surname = String.valueOf(ComboBox.getSelectedItem());
		for(Magister magister : magisters) 
		{
			id = magister.getId();
			if(magister.getSurname().equals(surname))
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

	
	
	//Додати керівника теми якщо його нема
	
	public static void addSupervisor(int theme_id, int teacher_id, JTextField StartSupervisionField,JTextField EndSupervisionField)
	{
		SupervisionDao sd = new SupervisionDao();
		Supervision s = new Supervision();
		s.setScientificThemeId(theme_id);
		s.setScientistId(teacher_id);
		s.setStart(Date.valueOf(StartSupervisionField.getText()));
		if(EndSupervisionField.getText().equals(""))
		{
			s.setEnd(null);
		}
		else
		{
			s.setEnd(Date.valueOf(EndSupervisionField.getText()));
		}
		try {
			sd.addSupervisor(s);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	
	// Метод оновлення інформації про керівника
	
	public static void updateSupervision(int theme_id,JTextField StartInThemeField, JTextField EndInThemeField) throws SQLException
	{
		SupervisionDao sd = new SupervisionDao();
		Supervision s = sd.readSupervisor(theme_id);
		s.setStart(Date.valueOf(StartInThemeField.getText()));
		if(EndInThemeField.getText().equals(""))
		{
			s.setEnd(null);
		}
		else
		{
			s.setEnd(Date.valueOf(EndInThemeField.getText()));
		}
		try {
			sd.updateSupervisor(s);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}


}
