package WorkAspirantMenu;

import DepartmentMenu.ChooseCathedra;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.TeacherDao;
import domain.Teacher;
import main.Methods;

import javax.swing.JComboBox;

public class AddAspirant extends JFrame {

	private JPanel contentPane;
	private JTextField SurnameField;
	private JTextField StartField;
	private JTextField EndField;
	private JTextField ProtectionField;
	private JTextField DiplomaField;
	private JTextField PhoneField;


	public static int ruler_id;
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddAspirant(JFrame parent) throws SQLException 
	{
		TeacherDao td = new TeacherDao();
		List<Teacher> teachers = td.getAll();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Додавання аспіранта");
		label.setBounds(0, 13, 570, 42);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(label);
		
		JLabel SurnameLabel = new JLabel("Прізвище");
		SurnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SurnameLabel.setBounds(12, 85, 162, 22);
		panel.add(SurnameLabel);
		
		JLabel StartLabel = new JLabel("Дата початку");
		StartLabel.setHorizontalAlignment(SwingConstants.CENTER);
		StartLabel.setBounds(12, 138, 162, 22);
		panel.add(StartLabel);
		
		JLabel EndLabel = new JLabel("Дата закінчення");
		EndLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EndLabel.setBounds(12, 184, 162, 22);
		panel.add(EndLabel);
		
		JLabel ProtectionLabel = new JLabel("Дата захисту");
		ProtectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ProtectionLabel.setBounds(12, 236, 162, 22);
		panel.add(ProtectionLabel);
		
		JLabel DiplomaLabel = new JLabel("Тема диплому");
		DiplomaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DiplomaLabel.setBounds(12, 286, 162, 22);
		panel.add(DiplomaLabel);
		
		JLabel PhoneLabel = new JLabel("Номер");
		PhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneLabel.setBounds(12, 335, 162, 22);
		panel.add(PhoneLabel);
		
		JLabel SexLabel = new JLabel("Стать");
		SexLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SexLabel.setBounds(12, 387, 162, 22);
		panel.add(SexLabel);
		
		JLabel RulerLabel = new JLabel("Керівник теми");
		RulerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		RulerLabel.setBounds(12, 422, 162, 27);
		panel.add(RulerLabel);
		
		
		SurnameField = new JTextField();
		SurnameField.setText((String) null);
		SurnameField.setColumns(10);
		SurnameField.setBounds(198, 85, 350, 22);
		panel.add(SurnameField);
		
		StartField = new JTextField();
		StartField.setColumns(10);
		StartField.setBounds(198, 138, 350, 22);
		panel.add(StartField);
		
		EndField = new JTextField();
		EndField.setColumns(10);
		EndField.setBounds(198, 184, 350, 22);
		panel.add(EndField);
		
		ProtectionField = new JTextField();
		ProtectionField.setColumns(10);
		ProtectionField.setBounds(198, 236, 350, 22);
		panel.add(ProtectionField);
		
		DiplomaField = new JTextField();
		DiplomaField.setText((String) null);
		DiplomaField.setColumns(10);
		DiplomaField.setBounds(198, 286, 350, 22);
		panel.add(DiplomaField);
		
		PhoneField = new JTextField();
		PhoneField.setText((String) null);
		PhoneField.setColumns(10);
		PhoneField.setBounds(198, 335, 350, 22);
		panel.add(PhoneField);
		
		JCheckBox SexCheckBox = new JCheckBox("");
		SexCheckBox.setBounds(198, 386, 113, 25);
		panel.add(SexCheckBox);
		
		JComboBox<String> TeacherComboBox = new JComboBox<String>();
		TeacherComboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		TeacherComboBox.setBounds(198, 422, 350, 27);
		panel.add(TeacherComboBox);
		for(Teacher teacher : teachers)
		{
			TeacherComboBox.addItem(td.getSurname(teacher.getId()));
		}

		
		
		JButton AddButton = new JButton("Додати");
		AddButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					ruler_id = Methods.getTeacherIdBySurname(TeacherComboBox, teachers);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				Methods.addAspirant(ChooseCathedra.cathedra_id_to_work, ruler_id, SurnameField, PhoneField, StartField, EndField, ProtectionField, DiplomaField, SexCheckBox);
				if (parent != null)
					parent.setVisible(true);
				AddAspirant.this.setVisible(false);
				AddAspirant.this.dispose();
			}
		});
		AddButton.setBounds(31, 515, 113, 25);
		panel.add(AddButton);
		
		
		
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (parent != null)
					parent.setVisible(true);
				AddAspirant.this.setVisible(false);
				AddAspirant.this.dispose();
			}
		});
		button.setBounds(495, 515, 97, 25);
		panel.add(button);
		
	}
}
