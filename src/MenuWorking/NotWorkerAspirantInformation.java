package MenuWorking;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.CathedraPeopleInfo;
import DepartmentMenu.DepartmentMenu;
import DepartmentMenu.DepartmentPeopleInfo;
import ThemesMenu.WorkThemesMenu;
import WorkAspirantMenu.AddAspirantAsTeacher;
import WorkAspirantMenu.AspirantThemeRulers;
import WorkAspirantMenu.DeleteAspirantAsTeacher;
import WorkAspirantMenu.ScientificWorkOfAspirant;
import dao.AspirantDao;
import domain.Aspirant;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class NotWorkerAspirantInformation extends JFrame {

	private JPanel contentPane;
	private JTextField SurnameField;
	private JTextField CathedraNameField;
	private JTextField StartField;
	private JTextField EndField;
	private JTextField ProtectionField;
	private JTextField ThemeDiplomaField;
	private JTextField PhoneField;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public NotWorkerAspirantInformation(JFrame parent) throws SQLException
	{
		AspirantDao ad = new AspirantDao();
		Aspirant a = new Aspirant();
		
		
		if(DepartmentMenu.aspirant == 1)
		{
			a = ad.readAspirant(DepartmentPeopleInfo.a_id);
		}
		if(DepartmentMenu.aspirant == 2)
		{
			a = ad.readAspirant(CathedraPeopleInfo.a_id);
		}
		if(DepartmentMenu.aspirant == 3)
		{
			a = ad.readAspirant(AddWorkerAspirant.a_id_to_look);
		}
		if(DepartmentMenu.aspirant == 4)
		{
			a = ad.readAspirant(AspirantThemeRulers.a_id);
		}
		if(DepartmentMenu.aspirant == 5)
		{
			a = ad.readAspirant(ScientificWorkOfAspirant.aspirant_id);
		}
		if(DepartmentMenu.aspirant == 6)
		{
			a = ad.readAspirant(DeleteAspirantAsTeacher.id_to_select);
		}
		if(DepartmentMenu.aspirant == 7)
		{
			a = ad.readAspirant(AddAspirantAsTeacher.id_to_select);
		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 534);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("Інформація про аспіранта");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbl.setBounds(171, 13, 382, 37);
		contentPane.add(lbl);
		
		JLabel lblSurname = new JLabel("прізвище");
		lblSurname.setBounds(24, 63, 162, 22);
		contentPane.add(lblSurname);
		
		JLabel lblCathedraName = new JLabel("назва кафедри");
		lblCathedraName.setBounds(24, 115, 162, 22);
		contentPane.add(lblCathedraName);
		
		JLabel lblStart = new JLabel("початок навчання");
		lblStart.setBounds(24, 173, 162, 22);
		contentPane.add(lblStart);
		
		JLabel lblEnd = new JLabel("кінець навчання");
		lblEnd.setBounds(24, 219, 162, 22);
		contentPane.add(lblEnd);
		
		JLabel lblProtection = new JLabel("дата захисту");
		lblProtection.setBounds(24, 271, 162, 22);
		contentPane.add(lblProtection);
		
		JLabel lblDiplomaTheme = new JLabel("тема диплому");
		lblDiplomaTheme.setBounds(24, 321, 162, 22);
		contentPane.add(lblDiplomaTheme);
		
		JLabel lblPhone = new JLabel("номер");
		lblPhone.setBounds(24, 370, 162, 22);
		contentPane.add(lblPhone);
		
		SurnameField = new JTextField();
		SurnameField.setEditable(false);
		SurnameField.setBounds(210, 63, 350, 22);
		contentPane.add(SurnameField);
		SurnameField.setColumns(10);
		SurnameField.setText(ad.getSurname(a.getId()));
		
		
		CathedraNameField = new JTextField();
		CathedraNameField.setEditable(false);
		CathedraNameField.setBounds(210, 115, 350, 22);
		contentPane.add(CathedraNameField);
		CathedraNameField.setColumns(10);
		CathedraNameField.setText(ad.getCathedraName(a.getId()));
		
		
		StartField = new JTextField();
		StartField.setEditable(false);
		StartField.setColumns(10);
		StartField.setBounds(210, 173, 350, 22);
		contentPane.add(StartField);
		StartField.setText(String.valueOf(a.getStart()));
		
		
		EndField = new JTextField();
		EndField.setEditable(false);
		EndField.setColumns(10);
		EndField.setBounds(210, 219, 350, 22);
		contentPane.add(EndField);
		WorkThemesMenu.DateToString(a.getEnd(), EndField);
		
		
		ProtectionField = new JTextField();
		ProtectionField.setEditable(false);
		ProtectionField.setColumns(10);
		ProtectionField.setBounds(210, 271, 350, 22);
		contentPane.add(ProtectionField);
		WorkThemesMenu.DateToString(a.getProtection(), ProtectionField);
		
		
		ThemeDiplomaField = new JTextField();
		ThemeDiplomaField.setEditable(false);
		ThemeDiplomaField.setColumns(10);
		ThemeDiplomaField.setBounds(210, 321, 350, 22);
		contentPane.add(ThemeDiplomaField);
 	  	ThemeDiplomaField.setText(a.getThemeAspirant());
		
		
		PhoneField = new JTextField();
		PhoneField.setEditable(false);
		PhoneField.setColumns(10);
		PhoneField.setBounds(210, 370, 350, 22);
		contentPane.add(PhoneField);
 	  	PhoneField.setText(ad.getPhone(a.getId())); 	  	
 	  	
 	  	
		

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (parent != null)
					parent.setVisible(true);
				NotWorkerAspirantInformation.this.setVisible(false);
				NotWorkerAspirantInformation.this.dispose();
			}
		});
		btnBack.setBounds(501, 449, 97, 25);
		contentPane.add(btnBack);
	}
}
