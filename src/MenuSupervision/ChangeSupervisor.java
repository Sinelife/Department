package MenuSupervision;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ThemesMenu.ChooseTheme;
import dao.ScientificThemeDao;
import dao.SupervisionDao;
import dao.TeacherDao;
import domain.ScientificTheme;
import domain.Supervision;
import domain.Teacher;
import main.Methods;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ChangeSupervisor extends JFrame {

	private JPanel contentPane;

	public static int id_to_look;
	public static int id_to_select;
	
	private JTextField StartField;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ChangeSupervisor(JFrame parent) throws SQLException 
	{
		setResizable(false);
		SupervisionDao sd = new SupervisionDao();
		Supervision s_old = sd.readSupervisor(ChooseTheme.id_to_work);
		Supervision s_new = new Supervision();
		
		
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
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(0, 44, 610, 42);
		contentPane.add(lblNewLabel);
		
		
		JLabel StartLabel = new JLabel("Початок керування темою");
		StartLabel.setBounds(32, 298, 179, 22);
		contentPane.add(StartLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Над темою почали працювати " + st.getStart());
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(220, 219, 311, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Попередній керівник почав керувати " + s_old.getStart());
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(220, 264, 311, 22);
		contentPane.add(lblNewLabel_2);
		
		
		StartField = new JTextField();
		StartField.setText("null");
		StartField.setColumns(10);
		StartField.setBackground(Color.WHITE);
		StartField.setBounds(223, 299, 375, 22);
		contentPane.add(StartField);
		
		

		
		JButton SaveButton = new JButton("Зберегти");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					id_to_select = Methods.getTeacherIdBySurname(comboBox, teachers);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				s_new.setScientificThemeId(st.getId());
				s_new.setScientistId(id_to_select);
				s_new.setStart(Date.valueOf(StartField.getText()));
				try {
					sd.changeSupervisor(s_old, s_new);
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
		
		
		
		JButton InfoButton = new JButton("Інформація");
		InfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		InfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				MenuSupervision.teacher_change_or_add = 2;
				try {
					id_to_look = Methods.getTeacherIdBySurname(comboBox, teachers);
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
		InfoButton.setBounds(463, 121, 120, 34);
		contentPane.add(InfoButton);
		
		
		
		
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
