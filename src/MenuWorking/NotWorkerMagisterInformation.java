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
import dao.MagisterDao;
import domain.Magister;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class NotWorkerMagisterInformation extends JFrame {

	private JPanel contentPane;
	private JTextField SurnameField;
	private JTextField CathedraNameField;
	private JTextField StartField;
	private JTextField EndField;
	private JTextField ReasonField;
	private JTextField ThemeDiplomaField;
	private JTextField PhoneField;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public NotWorkerMagisterInformation(JFrame parent) throws SQLException
	{
		setResizable(false);
		MagisterDao md = new MagisterDao();
		Magister m = new Magister();
		
		
		if(DepartmentMenu.magister == 1)
		{
			m = md.readMagister(DepartmentPeopleInfo.m_id);
		}
		if(DepartmentMenu.magister == 2)
		{
			m = md.readMagister(CathedraPeopleInfo.m_id);
		}
		if(DepartmentMenu.magister == 3)
		{
			m = md.readMagister(AddWorkerMagister.m_id_to_look);
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 492);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("Інформація про магістра");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbl.setBounds(171, 13, 397, 37);
		contentPane.add(lbl);
		
		JLabel lblSurname = new JLabel("прізвище");
		lblSurname.setBounds(28, 63, 170, 22);
		contentPane.add(lblSurname);
		
		JLabel lblCathedraName = new JLabel("назва кафедри");
		lblCathedraName.setBounds(28, 115, 170, 22);
		contentPane.add(lblCathedraName);
		
		JLabel lblStart = new JLabel("початок навчання");
		lblStart.setBounds(28, 173, 170, 22);
		contentPane.add(lblStart);
		
		JLabel lblEnd = new JLabel("кінець навчання");
		lblEnd.setBounds(28, 217, 170, 22);
		contentPane.add(lblEnd);
		
		JLabel lblReason = new JLabel("причина випуску");
		lblReason.setBounds(28, 264, 170, 22);
		contentPane.add(lblReason);
		
		JLabel lblDiplomaTheme = new JLabel("тема диплому");
		lblDiplomaTheme.setBounds(28, 310, 170, 22);
		contentPane.add(lblDiplomaTheme);
		
		JLabel lblPhone = new JLabel("номер");
		lblPhone.setBounds(28, 360, 170, 22);
		contentPane.add(lblPhone);
		
		
		SurnameField = new JTextField();
		SurnameField.setEditable(false);
		SurnameField.setBounds(210, 63, 350, 22);
		contentPane.add(SurnameField);
		SurnameField.setColumns(10);
		SurnameField.setText(md.getSurname(m.getId()));
		
		
		CathedraNameField = new JTextField();
		CathedraNameField.setEditable(false);
		CathedraNameField.setBounds(210, 115, 350, 22);
		contentPane.add(CathedraNameField);
		CathedraNameField.setColumns(10);
		CathedraNameField.setText(md.getCathedraName(m.getId()));
		
		
		StartField = new JTextField();
		StartField.setEditable(false);
		StartField.setColumns(10);
		StartField.setBounds(210, 173, 350, 22);
		contentPane.add(StartField);
		StartField.setText(String.valueOf(m.getStart()));
		
		
		EndField = new JTextField();
		EndField.setEditable(false);
		EndField.setColumns(10);
		EndField.setBounds(210, 217, 350, 22);
		contentPane.add(EndField);
		WorkThemesMenu.DateToString(m.getEnd(), EndField);
		
		
		ReasonField = new JTextField();
		ReasonField.setEditable(false);
		ReasonField.setColumns(10);
		ReasonField.setBounds(210, 264, 350, 22);
		contentPane.add(ReasonField);
		ReasonField.setText(m.getReason());
		
		
		ThemeDiplomaField = new JTextField();
		ThemeDiplomaField.setEditable(false);
		ThemeDiplomaField.setColumns(10);
		ThemeDiplomaField.setBounds(210, 310, 350, 22);
		contentPane.add(ThemeDiplomaField);
 	  	ThemeDiplomaField.setText(m.getThemeMagister());
		
		
		PhoneField = new JTextField();
		PhoneField.setEditable(false);
		PhoneField.setColumns(10);
		PhoneField.setBounds(210, 360, 350, 22);
		contentPane.add(PhoneField);
 	  	PhoneField.setText(md.getPhone(m.getId()));
 	  	
 	  	
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (parent != null)
					parent.setVisible(true);
				NotWorkerMagisterInformation.this.setVisible(false);
				NotWorkerMagisterInformation.this.dispose();
			}
		});
		btnBack.setBounds(513, 407, 97, 25);
		contentPane.add(btnBack);

	}
}
