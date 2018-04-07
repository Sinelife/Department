package main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import ThemesMenu.ChooseTheme;
import dao.AspirantDao;
import dao.MagisterDao;
import dao.ScientificThemeDao;
import dao.SupervisionDao;
import dao.TeacherDao;
import dao.WorkingDao;
import domain.Aspirant;
import domain.Cathedra;
import domain.Magister;
import domain.ScientificTheme;
import domain.ScientificWork;
import domain.Scientist;
import domain.Supervision;
import domain.Teacher;
import domain.Working;

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
	
	
	
	
	@SuppressWarnings("deprecation")
	public static String getCurrentDate()
	{
		java.util.Date date = new java.util.Date();
		String result = "";
		String day = String.valueOf(date.getDate());
		String year = String.valueOf(date.getYear() + 1900);
		String month = "";
		String s = String.valueOf(date.getMonth() + 1);
		if((Integer.valueOf(s)) < 10)
		{
			String s1 = "0";
			month = s1.concat(s);
		}
		else
		{
			month = s;
		} 
		result = year.concat("-").concat(month).concat("-").concat(day);
		return result;
	}
	
	
	
	//МЕТОДИ ДЛЯ ОТРИМАННЯ АЙДІШНИКА ОБ'ЄКТА ЧЕРЕЗ І'МЯ
	
	
	//Метод для отримання айдішника наукової роботи через назву 
	
	public static int getWorkIdByWorkTitle(JComboBox<String> ComboBox,List<ScientificWork> works)
	{
		String title = String.valueOf(ComboBox.getSelectedItem());
		int id = 0;
		for(ScientificWork work : works) 
		{
			id = work.getId();
			if(work.getTitle().equals(title))
			{
				break;
			}
		}
		return id;
	}
	
	
	//Метод для отримання айдішника наукової теми через назву теми
	
	public static int getThemeIdByThemeTitle(JComboBox<String> ComboBox,List<ScientificTheme> themes)
	{
		String title = String.valueOf(ComboBox.getSelectedItem());
		int id = 0;
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
	
	public static int getCathedraIdByCathedraName(JComboBox<String> ComboBox,List<Cathedra> cathedras)
	{
		String name = String.valueOf(ComboBox.getSelectedItem());
		int id = 0;
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
	
	
	
	
	//Метод для отримання айдішника керівника за прізвищем
	
	public static int getSupervisorIdBySurname(JComboBox<String> ComboBox,List<Supervision> supervisors) throws SQLException
	{
		SupervisionDao sd = new SupervisionDao();
		String surname = String.valueOf(ComboBox.getSelectedItem());
		int id = 0;
		System.out.println(surname);
		if(surname.contains(id + "6)"));
		{
			surname = surname.replace(id + "6)", "");
			System.out.println(surname);
			for (Supervision supervisor : supervisors) 
			{
				id = supervisor.getScientistId();
				if (sd.getSurname(supervisor.getScientistId()).equals(surname)) 
				{
					break;
				}
			}
			return id;
		}
	}
	
	
	
	//Метод для отримання айдішника викладача за прізвищем
	
	public static int getTeacherIdBySurname(JComboBox<String> ComboBox,List<Teacher> teachers) throws SQLException
	{
		TeacherDao td = new TeacherDao();
		int id = 0;
		String surname = String.valueOf(ComboBox.getSelectedItem());
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
	
	public static int getAspirantIdBySurname(JComboBox<String> ComboBox,List<Aspirant> aspirants) throws SQLException
	{
		AspirantDao ad = new AspirantDao();
		String surname = String.valueOf(ComboBox.getSelectedItem());
		int id = 0;
		for(Aspirant aspirant : aspirants) 
		{
			id = aspirant.getId();
			if(ad.getSurname(aspirant.getId()).equals(surname))
			{
				break;
			}
		}
		return id;
	}
	
	
	
	//Метод для отримання айдішника магістра за прізвищем
	
	public static int getMagisterIdBySurname(JComboBox<String> ComboBox,List<Magister> magisters) throws SQLException
	{
		MagisterDao md = new MagisterDao();
		String surname = String.valueOf(ComboBox.getSelectedItem());
		int id = 0;
		for(Magister magister : magisters) 
		{
			id = magister.getId();
			if(md.getSurname(magister.getId()).equals(surname))
			{
				break;
			}
		}
		return id;
	}
	
	
	//Метод для отримання айдішника працівника за прізвищем
	
	public static int getWorkerIdBySurname(JComboBox<String> ComboBox,List<Working> workers) throws SQLException
	{
		WorkingDao wd = new WorkingDao();
		String surname = String.valueOf(ComboBox.getSelectedItem());
		int id = 0;
		for(Working worker : workers) 
		{
			id = worker.getScientistId();
			if(wd.getSurname(worker.getScientistId()).equals(surname))
			{
				break;
			}
		}
		return id;
	}
	
	
	
	

	// МЕТОДИ ДЛЯ ДОДАВАННЯ РІЗНИХ ОБЄКТІВ ДО БД

	// Метод додавання аспіранта

	public static void addAspirant(int cathedra_id, int ruler_id, JTextField SurnameField, JTextField PhoneField, JTextField StartField,
			JTextField EndField, JTextField ProtectionField, JTextField DiplomaField, JCheckBox SexCheckBox)
	{
		AspirantDao ad = new AspirantDao();
		Aspirant a = new Aspirant();
		Scientist s = new Scientist();
		s.setSurname(SurnameField.getText());
		s.setPhone(PhoneField.getText());
		if(SexCheckBox.isSelected())
		{
			s.setSex(true);
		}
		else
		{
			s.setSex(false);
		}
		a.setCathedraId(cathedra_id);
		a.setStart(Date.valueOf(StartField.getText()));
	  	if(EndField.getText().equals(""))
	  	{
	  		a.setEnd(null);
	  	}
	  	else
	  	{
	  		a.setEnd(Date.valueOf(EndField.getText()));
	  	}
	  	if(EndField.getText().equals(""))
	  	{
	  		a.setProtection(null);
	  	}
	  	else
	  	{
	  		a.setProtection(Date.valueOf(EndField.getText()));
	  	}
		a.setThemeAspirant(DiplomaField.getText());
		a.setTeacherScientistId(ruler_id);
		try {
			ad.addAspirant(a,s);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	
	//Метод оновлення аспіранта
	
	public static void updateAspirant(int scientist_id, int ruler_id, JTextField SurnameField, JTextField PhoneField, JTextField StartField,
			JTextField EndField, JTextField ProtectionField, JTextField DiplomaField, JCheckBox SexCheckBox)
	{
		AspirantDao ad = new AspirantDao();
		Aspirant a = new Aspirant();
		Scientist s = new Scientist();
		s.setId(scientist_id);
		s.setSurname(SurnameField.getText());
		s.setPhone(PhoneField.getText());
		if(SexCheckBox.isSelected())
		{
			s.setSex(true);
		}
		else
		{
			s.setSex(false);
		}
		a.setStart(Date.valueOf(StartField.getText()));
	  	if(EndField.getText().equals(""))
	  	{
	  		a.setEnd(null);
	  	}
	  	else
	  	{
	  		a.setEnd(Date.valueOf(EndField.getText()));
	  	}
	  	if(ProtectionField.getText().equals(""))
	  	{
	  		a.setProtection(null);
	  	}
	  	else
	  	{
	  		a.setProtection(Date.valueOf(EndField.getText()));
	  	}
		a.setThemeAspirant(DiplomaField.getText());
		a.setTeacherScientistId(ruler_id);
		try {
			ad.updateAspirant(a,s);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	
	// Метод додавання викладача

		public static void addTeacher(int cathedra_id, JTextField SurnameField, JTextField PhoneField, JTextField PositionField,
				JTextField StatusField, JTextField StartField, JCheckBox CheckBox)
		{
			TeacherDao td = new TeacherDao();
			Teacher t = new Teacher();
			Scientist s = new Scientist();
			s.setSurname(SurnameField.getText());
			s.setPhone(PhoneField.getText());
			if(CheckBox.isSelected())
			{
				s.setSex(true);
			}
			else
			{
				s.setSex(false);
			}
			t.setCathedraId(cathedra_id);
			t.setPosition(PositionField.getText());
			t.setStatus(StatusField.getText());
			t.setStart(Date.valueOf(StartField.getText()));
			try {
				td.addTeacher(t,s);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		// Метод оновлення викладача
		
		public static void updateTeacher(int scientist_id,  JTextField SurnameField, JTextField PhoneField, JCheckBox CheckBox, JTextField PositionField,
				JTextField StatusField, JTextField StartField)
		{
			TeacherDao td = new TeacherDao();
			Scientist s = new Scientist();
			Teacher t = new Teacher();
			s.setId(scientist_id);
			s.setSurname(SurnameField.getText());
			s.setPhone(PhoneField.getText());
			if(CheckBox.isSelected())
			{
				s.setSex(true);
			}
			else
			{
				s.setSex(false);
			}
			t.setId(scientist_id);
			t.setPosition(PositionField.getText());
			t.setStatus(StatusField.getText());
			t.setStart(Date.valueOf(StartField.getText()));
			try {
				td.updateTeacher(t, s);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	
	// Метод додавання теми

	public static void addTheme(int cathedra_id, JTextField TitleField, JTextField CustomerField, JTextField StartField)
	{
		ScientificThemeDao std = new ScientificThemeDao();
		ScientificTheme st = new ScientificTheme();
		st.setTitle(TitleField.getText());
		st.setCustomer(CustomerField.getText());
		st.setStart(Date.valueOf(StartField.getText()));
		st.setCathedraId(cathedra_id);
	  		try {
			std.addTheme(st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// Метод оновлення теми
	
	public static void updateTheme(int theme_id, JTextField TitleField, JTextField CustomerField) throws SQLException
	{
		ScientificThemeDao std = new ScientificThemeDao();
		ScientificTheme st = std.readTheme(theme_id);
		st.setTitle(TitleField.getText());
		st.setCustomer(CustomerField.getText());
		try {
			std.updateTheme(st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	//Додати керівника теми якщо його нема
	
	public static void addSupervisor(int theme_id, int teacher_id, JTextField StartSupervisionField)
	{
		SupervisionDao sd = new SupervisionDao();
		Supervision s = new Supervision();
		s.setScientificThemeId(theme_id);
		s.setScientistId(teacher_id);
		s.setStart(Date.valueOf(StartSupervisionField.getText()));
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
	
		
	//Додати працівника теми
	
	public static void addWorking(int theme_id, int worker_id, JTextField WorkingNameField, JTextField StartField,JTextField EndField)
	{
		WorkingDao wd = new WorkingDao();
		Working w = new Working();
		
		w.setScientificThemeId(theme_id);
		w.setScientistId(worker_id);
		w.setTitle(WorkingNameField.getText());
		w.setStart(Date.valueOf(StartField.getText()));
		if(EndField.getText().equals(""))
		{
			w.setEnd(null);
		}
		else
		{
			w.setEnd(Date.valueOf(EndField.getText()));
		}
		try {
			wd.addWorker(w);
		} catch (SQLException e6) {
			e6.printStackTrace();
		}
	}
	
	
	
	//Видалити працівника теми

	public static void deleteWorking(int theme_id, int worker_id) 
	{
		WorkingDao wd = new WorkingDao();
		Working w = null;
		try {
			w = wd.readWorker(theme_id, worker_id);
		} catch (SQLException e3) {
			e3.printStackTrace();
		} 
		try {
			wd.deleteWorker(w);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	
	
	//Редагувати працівника теми

	public static void editWorking(int theme_id, int worker_id, JTextField WorkingInThemeField, JTextField StartInThemeField,
			JTextField EndInThemeField) throws SQLException 
	{
		WorkingDao wd = new WorkingDao();
		Working w = wd.readWorker(theme_id, worker_id);
		w.setTitle(WorkingInThemeField.getText());
		w.setStart(Date.valueOf(StartInThemeField.getText()));
		if(EndInThemeField.getText().equals(""))
		{
			w.setEnd(null);
		}
		else
		{
			w.setEnd(Date.valueOf(EndInThemeField.getText()));
		}
		try {
			wd.updateWorker(w);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	
	
	
	
	
	//Метод вибору інфи з магістрів,аспірантів і викладачів
	public static int infoDesition(int worker_id, String worker_surname, JComboBox WorkersComboBox) throws SQLException
	{
		MagisterDao md = new MagisterDao();
		AspirantDao ad = new AspirantDao();
		TeacherDao td = new TeacherDao();
		List<Magister> magisters = md.getAllFromTheme(ChooseTheme.id_to_work);
		List<Aspirant> aspirants = ad.getAllFromTheme(ChooseTheme.id_to_work);
		List<Teacher> teachers = td.getAllFromTheme(ChooseTheme.id_to_work);
		
		if(worker_surname.contains("(Магістр)"))
		{
			worker_surname = worker_surname.replace("(Магістр)", "");
			for(Magister magister : magisters) 
			{
				worker_id = magister.getId();
				if(md.getSurname(magister.getId()).equals(worker_surname))
				{
					break;
				}
			}
			return 1;
		}
		if(worker_surname.contains("(Аспірант)"))
		{
			worker_surname = worker_surname.replace("(Аспірант)", "");
			for(Aspirant aspirant : aspirants) 
			{
				worker_id = aspirant.getId();
				if(ad.getSurname(aspirant.getId()).equals(worker_surname))
				{
					break;
				}
			}
			return 2;
		}
		if(worker_surname.contains("(Викладач)"))
		{
			worker_surname = worker_surname.replace("(Викладач)", "");
			for(Teacher teacher : teachers) 
			{
				worker_id = teacher.getId();
				if(td.getSurname(teacher.getId()).equals(worker_surname))
				{
					break;
				}
			}
			return 3;
		}
		return 0;
	}
	
	
	//Метод вибору інфи з магістрів,аспірантів і викладачів
	public static int infoDecitionId(int worker_id, String worker_surname, JComboBox WorkersComboBox) throws SQLException
	{
		MagisterDao md = new MagisterDao();
		AspirantDao ad = new AspirantDao();
		TeacherDao td = new TeacherDao();
		List<Magister> magisters = md.getAllFromTheme(ChooseTheme.id_to_work);
		List<Aspirant> aspirants = ad.getAllFromTheme(ChooseTheme.id_to_work);
		List<Teacher> teachers = td.getAllFromTheme(ChooseTheme.id_to_work);
		
		if(worker_surname.contains("(Магістр)"))
		{
			worker_surname = worker_surname.replace("(Магістр)", "");
			for(Magister magister : magisters) 
			{
				worker_id = magister.getId();
				if(md.getSurname(magister.getId()).equals(worker_surname))
				{
					break;
				}
			}
			return worker_id;
		}
		if(worker_surname.contains("(Аспірант)"))
		{
			worker_surname = worker_surname.replace("(Аспірант)", "");
			for(Aspirant aspirant : aspirants) 
			{
				worker_id = aspirant.getId();
				if(ad.getSurname(aspirant.getId()).equals(worker_surname))
				{
					break;
				}
			}
			return worker_id;
		}
		if(worker_surname.contains("(Викладач)"))
		{
			worker_surname = worker_surname.replace("(Викладач)", "");
			for(Teacher teacher : teachers) 
			{
				worker_id = teacher.getId();
				if(td.getSurname(teacher.getId()).equals(worker_surname))
				{
					break;
				}
			}
			return worker_id;
		}
		return 0;
	}
	
	
	
	//Метод для звільнення аспіранта з посади викладача
	
	public static void addAspirantAsTeacher(int scientist_id, int cathedra_id, JTextField PositionField,
			JTextField StatusField, JTextField StartField)
	{
		AspirantDao ad = new AspirantDao();
		Teacher t = new Teacher();
		t.setId(scientist_id);
		t.setCathedraId(cathedra_id);
		t.setPosition(PositionField.getText());
		t.setStatus(StatusField.getText());
		t.setStart(Date.valueOf(StartField.getText()));
		try {
			ad.addAspirantAsTeacher(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
