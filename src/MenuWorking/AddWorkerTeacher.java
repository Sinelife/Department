package MenuWorking;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.DepartmentMenu;
import ThemesMenu.ChooseTheme;
import dao.ScientificThemeDao;
import dao.TeacherDao;
import domain.ScientificTheme;
import domain.Teacher;
import main.Methods;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class AddWorkerTeacher extends JFrame {

	private JPanel contentPane;
	private JTextField WorkingNameField;
	private JTextField StartField;
	private JTextField EndField;

	public static int t_id_to_look;
	public static int t_id_to_select;
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddWorkerTeacher(JFrame parent) throws SQLException 
	{
		setResizable(false);
		ScientificThemeDao std = new ScientificThemeDao();
		ScientificTheme st = std.readTheme(ChooseTheme.id_to_work);
		
		
		TeacherDao td = new TeacherDao();
		List<Teacher> teachers = td.getAllNotFromThemeNotFromCathedra(ChooseTheme.id_to_work, st.getCathedraId());
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		comboBox.setBounds(40, 121, 418, 34);
		contentPane.add(comboBox);
		for(Teacher teacher : teachers)
		{
			comboBox.addItem(td.getSurname(teacher.getId()));
		}
		
		
		JLabel lblNewLabel = new JLabel("Залучення викладача");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(0, 44, 622, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNameWorking = new JLabel("назва роботи");
		lblNameWorking.setBounds(40, 205, 104, 22);
		contentPane.add(lblNameWorking);
		
		JLabel lblStart = new JLabel("початок роботи");
		lblStart.setBounds(40, 257, 104, 22);
		contentPane.add(lblStart);
		
		JLabel lblEnd = new JLabel("кінець роботи");
		lblEnd.setBounds(40, 315, 104, 22);
		contentPane.add(lblEnd);
		
		WorkingNameField = new JTextField();
		WorkingNameField.setColumns(10);
		WorkingNameField.setBounds(168, 205, 376, 22);
		contentPane.add(WorkingNameField);
		
		StartField = new JTextField();
		StartField.setColumns(10);
		StartField.setBounds(168, 257, 376, 22);
		contentPane.add(StartField);
		
		EndField = new JTextField();
		EndField.setColumns(10);
		EndField.setBounds(168, 315, 376, 22);
		contentPane.add(EndField);
		
		
		
		JButton AddButton = new JButton("Додати");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					t_id_to_select = Methods.getTeacherIdBySurname(comboBox, teachers);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				Methods.addWorking(ChooseTheme.id_to_work, t_id_to_select, WorkingNameField, StartField, EndField);
				if (parent != null)
					parent.setVisible(true);
				AddWorkerTeacher.this.setVisible(false);
				AddWorkerTeacher.this.dispose();
			}
		});
		AddButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AddButton.setBounds(40, 410, 104, 34);
		contentPane.add(AddButton);
		
		
		
		
		
		JButton ChooseButton = new JButton("Інформація");
		ChooseButton.setForeground(Color.BLACK);
		ChooseButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ChooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					t_id_to_look = Methods.getTeacherIdBySurname(comboBox, teachers);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}		
				DepartmentMenu.teacher = 3;
				AddWorkerTeacher.this.setVisible(false);
				try {
					new NotWorkerTeacherInformation(AddWorkerTeacher.this).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		ChooseButton.setBounds(467, 121, 116, 34);
		contentPane.add(ChooseButton);
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				AddWorkerTeacher.this.setVisible(false);
				AddWorkerTeacher.this.dispose();
			}
		});
		btnBack.setBounds(489, 427, 97, 25);
		contentPane.add(btnBack);
		
		
	}

}
