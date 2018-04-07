package MenuSupervision;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ThemesMenu.ChooseTheme;
import dao.ScientificThemeDao;
import dao.TeacherDao;
import domain.ScientificTheme;
import domain.Teacher;
import main.Methods;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class AddSupervisor extends JFrame {

	private JPanel contentPane;
	
	public static int id_to_look;
	public static int id_to_select;
	
	private JTextField StartSupervisionField;
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddSupervisor(JFrame parent) throws SQLException 
	{	
		ScientificThemeDao std = new ScientificThemeDao();
		ScientificTheme st = std.readTheme(ChooseTheme.id_to_work);
		
		TeacherDao td = new TeacherDao();
		List<Teacher> teachers = td.getAllFromCathedra(st.getCathedraId());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Додавання керівника(якщо його немає)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(0, 44, 610, 42); 
		contentPane.add(lblNewLabel);
	
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		comboBox.setBounds(40, 121, 415, 34);
		contentPane.add(comboBox);
		for(Teacher teacher : teachers)
		{
			comboBox.addItem(td.getSurname(teacher.getId()));
		}
		

		
		JLabel lblStartSupervisition = new JLabel("початок керування темою");
		lblStartSupervisition.setBounds(17, 230, 179, 22);
		contentPane.add(lblStartSupervisition);

		
		StartSupervisionField = new JTextField();
		StartSupervisionField.setBackground(Color.WHITE);
		StartSupervisionField.setEditable(false);
		StartSupervisionField.setColumns(10);
		StartSupervisionField.setBounds(208, 231, 375, 22);
		contentPane.add(StartSupervisionField);
		StartSupervisionField.setText(String.valueOf(st.getStart()));
		

		
		JButton AddButton = new JButton("Додати");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					id_to_select = Methods.getTeacherIdBySurname(comboBox, teachers);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				Methods.addSupervisor(ChooseTheme.id_to_work, id_to_select, StartSupervisionField);
				if (parent != null)
					parent.setVisible(true);
				AddSupervisor.this.setVisible(false);
				AddSupervisor.this.dispose();
			}
		});
		AddButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AddButton.setBounds(40, 318, 104, 34);
		contentPane.add(AddButton);
		
		
		
		
		JButton InfoButton = new JButton("Інформація");
		InfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				MenuSupervision.teacher_change_or_add = 3;
				try {
					id_to_look = Methods.getTeacherIdBySurname(comboBox, teachers);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				AddSupervisor.this.setVisible(false);
				try {
					new TeacherInformation(AddSupervisor.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		InfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		InfoButton.setBounds(461, 121, 122, 34);
		contentPane.add(InfoButton);
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				AddSupervisor.this.setVisible(false);
				AddSupervisor.this.dispose();
			}
		});
		btnBack.setBounds(486, 324, 97, 25);
		contentPane.add(btnBack);
	}
}
