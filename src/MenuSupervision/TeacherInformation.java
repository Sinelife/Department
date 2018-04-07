package MenuSupervision;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.TeacherDao;
import domain.Teacher;



public class TeacherInformation extends JFrame 
{

	private JPanel contentPane;
	private JTextField PositionField;
	private JTextField StatusField;
	private JTextField StartField;
	private JTextField CathedraNameField;
	private JTextField PhoneField;
	private JTextField SurnameField;


	/**
	 * Create the frame. 
	 * @throws SQLException 
	 */
	public TeacherInformation(JFrame parent) throws SQLException 
	{
		TeacherDao td = new TeacherDao();
		Teacher t = null;
		
		if(MenuSupervision.teacher_change_or_add == 2)
		{
			t = td.readTeacher(ChangeSupervisor.id_to_look);
		}
		else
		{
			t = td.readTeacher(AddSupervisor.id_to_look);
		}
 	  	
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 534);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSupervisorInformation = new JLabel("Інформація про викладача");
		lblSupervisorInformation.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSupervisorInformation.setBounds(171, 13, 258, 37);
		contentPane.add(lblSupervisorInformation);
		
		JLabel lblSurname = new JLabel("прізвище");
		lblSurname.setBounds(44, 63, 129, 22);
		contentPane.add(lblSurname);
		
		JLabel lblPosition = new JLabel("посада");
		lblPosition.setBounds(44, 115, 129, 22);
		contentPane.add(lblPosition);
		
		JLabel lblStatus = new JLabel("звання");
		lblStatus.setBounds(44, 167, 129, 22);
		contentPane.add(lblStatus);
		
		JLabel lblStart = new JLabel("початок роботи");
		lblStart.setBounds(44, 225, 129, 22);
		contentPane.add(lblStart);
		
		JLabel lblCathedraName = new JLabel("назва кафедри");
		lblCathedraName.setBounds(44, 288, 129, 22);
		contentPane.add(lblCathedraName);
		
		JLabel lblPhone = new JLabel("номер");
		lblPhone.setBounds(44, 352, 129, 22);
		contentPane.add(lblPhone);
		
		SurnameField = new JTextField();
		SurnameField.setEditable(false);
		SurnameField.setBounds(202, 63, 350, 22);
		contentPane.add(SurnameField);
		SurnameField.setColumns(10);
		SurnameField.setText(td.getSurname(t.getId()));
		
		PositionField = new JTextField();
		PositionField.setEditable(false);
		PositionField.setBounds(202, 115, 350, 22);
		contentPane.add(PositionField);
		PositionField.setColumns(10);
		PositionField.setText(t.getPosition());
		
		StatusField = new JTextField();
		StatusField.setEditable(false);
		StatusField.setBounds(202, 167, 350, 22);
		contentPane.add(StatusField);
		StatusField.setColumns(10);
		StatusField.setText(t.getStatus());
		
		StartField = new JTextField();
		StartField.setEditable(false);
		StartField.setColumns(10);
		StartField.setBounds(202, 225, 350, 22);
		contentPane.add(StartField);
		StartField.setText(String.valueOf(t.getStart()));
		
		CathedraNameField = new JTextField();
		CathedraNameField.setEditable(false);
		CathedraNameField.setColumns(10);
		CathedraNameField.setBounds(202, 288, 350, 22);
		contentPane.add(CathedraNameField);
		CathedraNameField.setText(td.getCathedraName(t.getId()));
		
		PhoneField = new JTextField();
		PhoneField.setEditable(false);
		PhoneField.setColumns(10);
		PhoneField.setBounds(202, 352, 350, 22);
		contentPane.add(PhoneField);
 	  	PhoneField.setText(td.getPhone(t.getId()));
		

		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(489, 427, 97, 25);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				TeacherInformation.this.setVisible(false);
				TeacherInformation.this.dispose();
			}
		});
		contentPane.add(btnBack);
	}

}
