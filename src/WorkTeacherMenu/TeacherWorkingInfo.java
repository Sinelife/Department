package WorkTeacherMenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.ChooseCathedra;
import dao.TeacherDao;
import domain.ScientificTheme;
import domain.Teacher;
import main.Methods;

public class TeacherWorkingInfo extends JFrame {

	private JPanel contentPane;

	public static String surname_to_choose;
	public static int id_to_choose;
	
	List<ScientificTheme> themes = new ArrayList<ScientificTheme>();

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public TeacherWorkingInfo(JFrame parent) throws SQLException 
	{
		TeacherDao td = new TeacherDao();
		List<Teacher> teachers = td.getAllFromCathedra(ChooseCathedra.cathedra_id_to_work);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel label = new JLabel("Теми, на яких працює викладач");
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
		
		
		
		
		
		JButton btnNewButton = new JButton("Вибрати");
		btnNewButton.addActionListener(new ActionListener() 
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
					themes = td.getAllThemesOnWhichWorkTeacher(id_to_choose);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				for(ScientificTheme theme : themes)
				{
					ScientificThemeComboBox.addItem(theme.getTitle());
				}
				
			}
		});
		btnNewButton.setBounds(183, 176, 103, 30);
		contentPane.add(btnNewButton);
		
		
		
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (parent != null)
					parent.setVisible(true);
				TeacherWorkingInfo.this.setVisible(false);
				TeacherWorkingInfo.this.dispose();
			}
		});
		button.setBounds(471, 404, 97, 25);
		contentPane.add(button);
	}
}
