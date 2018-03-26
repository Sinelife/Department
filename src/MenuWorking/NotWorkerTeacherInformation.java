package MenuWorking;

import DepartmentMenu.CathedraPeopleInfo;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.DepartmentMenu;
import DepartmentMenu.DepartmentPeopleInfo;
import dao.TeacherDao;
import domain.Teacher;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class NotWorkerTeacherInformation extends JFrame {

	private JPanel contentPane;
	private JTextField SurnameField;
	private JTextField PositionField;
	private JTextField StatusField;
	private JTextField StartField;
	private JTextField CathedraNameField;
	private JTextField PhoneField;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public NotWorkerTeacherInformation(JFrame parent) throws SQLException
	{
		TeacherDao td = new TeacherDao();
		Teacher t = new Teacher();
		
		if(DepartmentMenu.teacher == 1)
		{
			t = td.readTeacher(DepartmentPeopleInfo.t_id);
		}
		if(DepartmentMenu.teacher == 2)
		{
			t = td.readTeacher(CathedraPeopleInfo.t_id);
		}
		if(DepartmentMenu.teacher == 3)
		{
			t = td.readTeacher(AddWorkerTeacher.t_id_to_look);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 473);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JLabel lbl = new JLabel("Інформація про викладача");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbl.setBounds(171, 13, 397, 37);
		contentPane.add(lbl);
		
		JLabel lblSurname = new JLabel("прізвище");
		lblSurname.setBounds(26, 83, 165, 22);
		contentPane.add(lblSurname);
		
		JLabel lblPosition = new JLabel("посада");
		lblPosition.setBounds(26, 135, 165, 22);
		contentPane.add(lblPosition);
		
		JLabel lblStatus = new JLabel("статус");
		lblStatus.setBounds(26, 187, 165, 22);
		contentPane.add(lblStatus);
		
		JLabel lblStart = new JLabel("початок роботи");
		lblStart.setBounds(26, 233, 165, 22);
		contentPane.add(lblStart);
		
		JLabel lblCathedraName = new JLabel("назва кафедри");
		lblCathedraName.setBounds(26, 286, 165, 22);
		contentPane.add(lblCathedraName);
		
		JLabel lblPhone = new JLabel("телефон");
		lblPhone.setBounds(26, 333, 165, 22);
		contentPane.add(lblPhone);
		
		
		SurnameField = new JTextField();
		SurnameField.setText((String) null);
		SurnameField.setEditable(false);
		SurnameField.setColumns(10);
		SurnameField.setBounds(218, 83, 350, 22);
		contentPane.add(SurnameField);
 	  	SurnameField.setText(td.getSurname(t.getId()));
 	  	
		
		PositionField = new JTextField();
		PositionField.setText((String) null);
		PositionField.setEditable(false);
		PositionField.setColumns(10);
		PositionField.setBounds(218, 135, 350, 22);
		contentPane.add(PositionField);
 	  	PositionField.setText(t.getPosition());
 	  	
		
		StatusField = new JTextField();
		StatusField.setText((String) null);
		StatusField.setEditable(false);
		StatusField.setColumns(10);
		StatusField.setBounds(218, 187, 350, 22);
		contentPane.add(StatusField);
 	  	StatusField.setText(t.getStatus());
		
		
		StartField = new JTextField();
		StartField.setText((String) null);
		StartField.setEditable(false);
		StartField.setColumns(10);
		StartField.setBounds(218, 233, 350, 22);
		contentPane.add(StartField);
 	  	StartField.setText(String.valueOf(t.getStart()));
 	  	
		
		CathedraNameField = new JTextField();
		CathedraNameField.setText((String) null);
		CathedraNameField.setEditable(false);
		CathedraNameField.setColumns(10);
		CathedraNameField.setBounds(218, 286, 350, 22);
		contentPane.add(CathedraNameField);
 	  	CathedraNameField.setText(td.getCathedraName(t.getId()));
		
		
		
		PhoneField = new JTextField();
		PhoneField.setText((String) null);
		PhoneField.setEditable(false);
		PhoneField.setColumns(10);
		PhoneField.setBounds(218, 333, 350, 22);
		contentPane.add(PhoneField);
 	  	PhoneField.setText(td.getPhone(t.getId()));
 	  	
 	  	
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (parent != null)
					parent.setVisible(true);
				NotWorkerTeacherInformation.this.setVisible(false);
				NotWorkerTeacherInformation.this.dispose();
			}
		});
		btnBack.setBounds(509, 398, 97, 25);
		contentPane.add(btnBack);
	}
}
