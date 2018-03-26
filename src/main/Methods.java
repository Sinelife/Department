package main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import DepartmentMenu.ChooseCathedra;
import ThemesMenu.ChooseTheme;
import ThemesMenu.EditTheme;
import WorkTeacherMenu.EditTeacher;
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
	
	
	
	
	//������ ��� ��������� ��Ĳ����� ��'���� ����� �'��
	
	//����� ��� ��������� �������� ������� ���� ����� ����� ����
	
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
	
	
	//����� ��� ��������� �������� ������� ����� ����� �������
	
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
	
	
	//����� ��� ��������� �������� ��������� �� ��������
	
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
	
	
	//����� ��� ��������� �������� �������� �� ��������
	
	public static int getAspirantIdBySurname(String surname, int id, JComboBox<String> ComboBox,List<Aspirant> aspirants) throws SQLException
	{
		AspirantDao ad = new AspirantDao();
		surname = String.valueOf(ComboBox.getSelectedItem());
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
	
	
	//����� ��� ��������� �������� ������� �� ��������
	
	public static int getMagisterIdBySurname(String surname, int id, JComboBox<String> ComboBox,List<Magister> magisters) throws SQLException
	{
		MagisterDao md = new MagisterDao();
		surname = String.valueOf(ComboBox.getSelectedItem());
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
	
	
	//����� ��� ��������� �������� ���������� �� ��������
	
	public static int getWorkerIdBySurname(String surname, int id, JComboBox<String> ComboBox,List<Working> workers) throws SQLException
	{
		WorkingDao wd = new WorkingDao();
		surname = String.valueOf(ComboBox.getSelectedItem());
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
	
	
	
	

	// ������ ��� ��������� в���� ����Ҳ� �� ��

	// ����� ��������� ���������

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
		
		
		// ����� ��������� ���������
		
		public static void updateTeacher(int scientist_id, int cathedra_id, JTextField SurnameField, JTextField PhoneField, JCheckBox CheckBox, JTextField PositionField,
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
			t.setCathedraId(cathedra_id);
			t.setPosition(PositionField.getText());
			t.setStatus(StatusField.getText());
			t.setStart(Date.valueOf(StartField.getText()));
			try {
				td.updateTeacher(t, s);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	
	// ����� ��������� ����

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
	
	
	// ����� ��������� ����
	
	public static void updateTheme(int theme_id, int cathedra_id, JTextField TitleField, JTextField CustomerField,
			JTextField StartField, JTextField EndField)
	{
		ScientificThemeDao std = new ScientificThemeDao();
		ScientificTheme st = new ScientificTheme();
		st.setId(theme_id);
		st.setCathedraId(cathedra_id);
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

	
	
	//������ �������� ���� ���� ���� ����
	
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
	
	
	// ����� ��������� ���������� ��� ��������
	
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
	
		
	//������ ���������� ����
	
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
	
	
	
	//�������� ���������� ����

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
	
	
	
	//���������� ���������� ����

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

	
	
	
	
	
	//����� ������ ���� � �������,�������� � ����������
	public static int infoDesition(int worker_id, String worker_surname, JComboBox WorkersComboBox) throws SQLException
	{
		MagisterDao md = new MagisterDao();
		AspirantDao ad = new AspirantDao();
		TeacherDao td = new TeacherDao();
		List<Magister> magisters = md.getAllFromTheme(ChooseTheme.id_to_work);
		List<Aspirant> aspirants = ad.getAllFromTheme(ChooseTheme.id_to_work);
		List<Teacher> teachers = td.getAllFromTheme(ChooseTheme.id_to_work);
		
		if(worker_surname.contains("(������)"))
		{
			worker_surname = worker_surname.replace("(������)", "");
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
		if(worker_surname.contains("(�������)"))
		{
			worker_surname = worker_surname.replace("(�������)", "");
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
		if(worker_surname.contains("(��������)"))
		{
			worker_surname = worker_surname.replace("(��������)", "");
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
	
	
	//����� ������ ���� � �������,�������� � ����������
	public static int infoDecitionId(int worker_id, String worker_surname, JComboBox WorkersComboBox) throws SQLException
	{
		MagisterDao md = new MagisterDao();
		AspirantDao ad = new AspirantDao();
		TeacherDao td = new TeacherDao();
		List<Magister> magisters = md.getAllFromTheme(ChooseTheme.id_to_work);
		List<Aspirant> aspirants = ad.getAllFromTheme(ChooseTheme.id_to_work);
		List<Teacher> teachers = td.getAllFromTheme(ChooseTheme.id_to_work);
		
		if(worker_surname.contains("(������)"))
		{
			worker_surname = worker_surname.replace("(������)", "");
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
		if(worker_surname.contains("(�������)"))
		{
			worker_surname = worker_surname.replace("(�������)", "");
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
		if(worker_surname.contains("(��������)"))
		{
			worker_surname = worker_surname.replace("(��������)", "");
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

}
