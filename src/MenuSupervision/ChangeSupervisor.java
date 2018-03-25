package MenuSupervision;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainMenu.ChooseTheme;
import dao.ScientificThemeDao;
import dao.SupervisionDao;
import dao.TeacherDao;
import domain.ScientificTheme;
import domain.Supervision;
import domain.Teacher;
import main.Methods;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class ChangeSupervisor extends JFrame {

	private JPanel contentPane;
	public static String surname_to_look;
	public static int id_to_look;
	public static String surname_to_select;
	public static int id_to_select;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ChangeSupervisor(JFrame parent) throws SQLException 
	{
		SupervisionDao sd = new SupervisionDao();
		Supervision s = sd.readSupervisor(ChooseTheme.id_to_work);
		
		
		ScientificThemeDao std = new ScientificThemeDao();
		ScientificTheme st = std.readTheme(ChooseTheme.id_to_work);
		
		TeacherDao td = new TeacherDao();
		List<Teacher> teachers = td.getAllFromCathedraExceptSupervisor(ChooseTheme.id_to_work, st.getCathedraId());
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		comboBox.setBounds(40, 121, 411, 34);
		contentPane.add(comboBox);
		for(Teacher teacher : teachers)
		{
			comboBox.addItem(td.getSurname(teacher.getId()));
		}
		
		
		JLabel lblNewLabel = new JLabel("Вибір нового керівника");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(40, 44, 543, 42);
		contentPane.add(lblNewLabel);
		

		
		JButton SaveButton = new JButton("Зберегти");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					id_to_select = Methods.getTeacherIdBySurname(surname_to_select, id_to_select, comboBox, teachers);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					sd.changeSupervisor(id_to_select,s);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (parent != null)
					parent.setVisible(true);
				ChangeSupervisor.this.setVisible(false);
				ChangeSupervisor.this.dispose();
			}
		});
		SaveButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SaveButton.setBounds(40, 410, 104, 34);
		contentPane.add(SaveButton);
		
		
		
		JButton ChooseButton_1 = new JButton("Інформація");
		ChooseButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ChooseButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				MenuSupervision.teacher_change_or_add = 2;
				try {
					id_to_look = Methods.getTeacherIdBySurname(surname_to_look, id_to_look, comboBox, teachers);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				ChangeSupervisor.this.setVisible(false);
				try {
					new TeacherInformation(ChangeSupervisor.this).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		ChooseButton_1.setBounds(463, 121, 120, 34);
		contentPane.add(ChooseButton_1);
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				ChangeSupervisor.this.setVisible(false);
				ChangeSupervisor.this.dispose();
			}
		});
		btnBack.setBounds(489, 427, 97, 25);
		contentPane.add(btnBack);
	}

}
