package MenuWorking;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import MainMenu.ChooseTheme;
import MainMenu.MainMenu;
import dao.TeacherDao;
import dao.WorkingDao;
import domain.Teacher;
import domain.Working;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class WorkerTeacherInformation extends JFrame {

	private JPanel contentPane;
	private JTextField SurnameField;
	private JTextField PositionField;
	private JTextField StatusField;
	private JTextField StartField;
	private JTextField CathedraNameField;
	private JTextField PhoneField;
	private JTextField WorkTitleInThemeField;
	private JTextField StartInThemeField;
	private JTextField EndInThemeField;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public WorkerTeacherInformation(JFrame parent) throws SQLException
	{
		TeacherDao td = new TeacherDao();
		Teacher t = td.read(WorkersList.t_id_to_look);
		WorkingDao wd = new WorkingDao();
		Working w = wd.readWorker(ChooseTheme.id_to_work, WorkersList.t_id_to_look);
 	  	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 625);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JLabel lbl = new JLabel("Інформація про науковця(викладача)");
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
		
		JLabel lblWorkTitleInTheme = new JLabel("назва роботи в темі");
		lblWorkTitleInTheme.setBounds(26, 379, 165, 22);
		contentPane.add(lblWorkTitleInTheme);
		
		JLabel lblStartInTheme = new JLabel("початок роботи в темі");
		lblStartInTheme.setBounds(26, 429, 165, 22);
		contentPane.add(lblStartInTheme);
		
		JLabel lblEndInTheme = new JLabel("кінець роботи в темі");
		lblEndInTheme.setBounds(26, 477, 165, 22);
		contentPane.add(lblEndInTheme);
		
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

		
		WorkTitleInThemeField = new JTextField();
		WorkTitleInThemeField.setText((String) null);
		WorkTitleInThemeField.setEditable(false);
		WorkTitleInThemeField.setColumns(10);
		WorkTitleInThemeField.setBounds(218, 379, 350, 22);
		contentPane.add(WorkTitleInThemeField);
 	  	WorkTitleInThemeField.setText(w.getTitle());
 	  	
		
		StartInThemeField = new JTextField();
		StartInThemeField.setText((String) null);
		StartInThemeField.setEditable(false);
		StartInThemeField.setColumns(10);
		StartInThemeField.setBounds(218, 429, 350, 22);
		contentPane.add(StartInThemeField);
 	  	StartInThemeField.setText(String.valueOf(w.getStart()));
		
		
		EndInThemeField = new JTextField();
		EndInThemeField.setText((String) null);
		EndInThemeField.setEditable(false);
		EndInThemeField.setColumns(10);
		EndInThemeField.setBounds(218, 477, 350, 22);
		contentPane.add(EndInThemeField);
		MainMenu.DateToString(w.getEnd(), EndInThemeField);
 	  	
 	  	
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (parent != null)
					parent.setVisible(true);
				WorkerTeacherInformation.this.setVisible(false);
				WorkerTeacherInformation.this.dispose();
			}
		});
		btnBack.setBounds(492, 524, 97, 25);
		contentPane.add(btnBack);
	}
}
