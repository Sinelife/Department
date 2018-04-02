package WorkTeacherMenu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.ChooseCathedra;
import DepartmentMenu.DepartmentMenu;
import MenuSupervision.SupervisorInformation;
import MenuTheme.ScientificThemeInformation;
import dao.TeacherDao;
import domain.ScientificTheme;
import domain.Teacher;
import main.Methods;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TeacherSupervisionInfo extends JFrame {

	private JPanel contentPane;

	public static String surname_to_choose;
	public static int id_to_choose;
	
	public static String title;
	public static int id = 0;
	
	
	List<ScientificTheme> themes = new ArrayList<ScientificTheme>();
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public TeacherSupervisionInfo(JFrame parent) throws SQLException 
	{
		TeacherDao td = new TeacherDao();
		List<Teacher> teachers = td.getAllFromCathedra(ChooseCathedra.cathedra_id_to_work);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel label = new JLabel("Теми, якими керує викладач");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(0, 25, 580, 42);
		contentPane.add(label);
		
		
		JComboBox<String> TeacherComboBox = new JComboBox<String>();
		TeacherComboBox.setFont(new Font("Tahoma", Font.PLAIN, 19));
		TeacherComboBox.setBounds(45, 114, 427, 30);
		contentPane.add(TeacherComboBox);
		for(Teacher teacher : teachers)
		{
			TeacherComboBox.addItem(td.getSurname(teacher.getId()));
		}
		
		
		JComboBox<String> ScientificThemeComboBox = new JComboBox<String>();
		ScientificThemeComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ScientificThemeComboBox.setBounds(45, 288, 427, 30);
		contentPane.add(ScientificThemeComboBox);
		
		
		
		
		
		JButton SelectButton = new JButton("Вибрати");
		SelectButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ScientificThemeComboBox.removeAllItems();
				try {
					id_to_choose = Methods.getTeacherIdBySurname(surname_to_choose, id_to_choose, TeacherComboBox, teachers);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					themes = td.getAllThemesSupervisedByTeacher(id_to_choose);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				for(ScientificTheme theme : themes)
				{
					ScientificThemeComboBox.addItem(theme.getTitle());
				}
				
			}
		});
		SelectButton.setBounds(183, 176, 103, 30);
		contentPane.add(SelectButton);
		
		
		JButton TeacherInfoButton = new JButton("Інформація");
		TeacherInfoButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				id = Methods.getThemeIdByThemeTitle(title, id, ScientificThemeComboBox, themes);
				DepartmentMenu.teacherSupervisor = 1;
				TeacherSupervisionInfo.this.setVisible(false);
				try {
					new SupervisorInformation(TeacherSupervisionInfo.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		TeacherInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TeacherInfoButton.setBounds(478, 110, 122, 34);
		contentPane.add(TeacherInfoButton);
		
		
		
		JButton ThemeInfoButton = new JButton("Інформація");
		ThemeInfoButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				id = Methods.getThemeIdByThemeTitle(title, id, ScientificThemeComboBox, themes);
				DepartmentMenu.theme = 1;
				TeacherSupervisionInfo.this.setVisible(false);
				try {
					new ScientificThemeInformation(TeacherSupervisionInfo.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		ThemeInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ThemeInfoButton.setBounds(478, 284, 122, 34);
		contentPane.add(ThemeInfoButton);
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (parent != null)
					parent.setVisible(true);
				TeacherSupervisionInfo.this.setVisible(false);
				TeacherSupervisionInfo.this.dispose();
			}
		});
		btnBack.setBounds(503, 406, 97, 25);
		contentPane.add(btnBack);
	}
}
