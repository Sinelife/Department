package MenuWorking;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ThemesMenu.ChooseTheme;
import ThemesMenu.WorkThemesMenu;
import dao.AspirantDao;
import dao.WorkingDao;
import domain.Aspirant;
import domain.Working;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class WorkerAspirantInformation extends JFrame {

	private JPanel contentPane;
	private JTextField SurnameField;
	private JTextField CathedraNameField;
	private JTextField StartField;
	private JTextField EndField;
	private JTextField ProtectionField;
	private JTextField ThemeDiplomaField;
	private JTextField PhoneField;
	private JTextField WorkTitleInThemeField;
	private JTextField StartInThemeField;
	private JTextField EndInThemeField;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public WorkerAspirantInformation(JFrame parent) throws SQLException
	{
		setResizable(false);
		AspirantDao ad = new AspirantDao();
		Aspirant a = ad.readAspirant(WorkersList.worker_id_to_look);
		WorkingDao wd = new WorkingDao();
		Working w = wd.readWorker(ChooseTheme.id_to_work, WorkersList.worker_id_to_look);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 718);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("Інформація про науковця(аспіранта)");
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
		lblProtection.setBounds(24, 265, 162, 22);
		contentPane.add(lblProtection);
		
		JLabel lblDiplomaTheme = new JLabel("тема диплому");
		lblDiplomaTheme.setBounds(24, 306, 162, 22);
		contentPane.add(lblDiplomaTheme);
		
		JLabel lblPhone = new JLabel("номер");
		lblPhone.setBounds(24, 356, 162, 22);
		contentPane.add(lblPhone);
		
		JLabel lblWorkTitleInTheme = new JLabel("назва роботи в темі");
		lblWorkTitleInTheme.setBounds(24, 399, 162, 22);
		contentPane.add(lblWorkTitleInTheme);
		
		JLabel lblStartInTheme = new JLabel("початок роботи в темі");
		lblStartInTheme.setBounds(24, 449, 162, 22);
		contentPane.add(lblStartInTheme);
		
		JLabel lblEndInTheme = new JLabel("кінець роботи в темі");
		lblEndInTheme.setBounds(24, 497, 162, 22);
		contentPane.add(lblEndInTheme);
		
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
		ProtectionField.setBounds(210, 265, 350, 22);
		contentPane.add(ProtectionField);
		WorkThemesMenu.DateToString(a.getProtection(), ProtectionField);
		
		
		ThemeDiplomaField = new JTextField();
		ThemeDiplomaField.setEditable(false);
		ThemeDiplomaField.setColumns(10);
		ThemeDiplomaField.setBounds(210, 306, 350, 22);
		contentPane.add(ThemeDiplomaField);
 	  	ThemeDiplomaField.setText(a.getThemeAspirant());
		
		
		PhoneField = new JTextField();
		PhoneField.setEditable(false);
		PhoneField.setColumns(10);
		PhoneField.setBounds(210, 356, 350, 22);
		contentPane.add(PhoneField);
 	  	PhoneField.setText(ad.getPhone(a.getId()));
 	  	
 	  	
		WorkTitleInThemeField = new JTextField();
		WorkTitleInThemeField.setText((String) null);
		WorkTitleInThemeField.setEditable(false);
		WorkTitleInThemeField.setColumns(10);
		WorkTitleInThemeField.setBounds(210, 399, 350, 22);
		contentPane.add(WorkTitleInThemeField);
 	  	WorkTitleInThemeField.setText(w.getTitle());
 	  	
		
		StartInThemeField = new JTextField();
		StartInThemeField.setText((String) null);
		StartInThemeField.setEditable(false);
		StartInThemeField.setColumns(10);
		StartInThemeField.setBounds(210, 449, 350, 22);
		contentPane.add(StartInThemeField);
 	  	StartInThemeField.setText(String.valueOf(w.getStart()));
		
		
		EndInThemeField = new JTextField();
		EndInThemeField.setText((String) null);
		EndInThemeField.setEditable(false);
		EndInThemeField.setColumns(10);
		EndInThemeField.setBounds(210, 497, 350, 22);
		contentPane.add(EndInThemeField);
		WorkThemesMenu.DateToString(w.getEnd(), EndInThemeField);
		

		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (parent != null)
					parent.setVisible(true);
				WorkerAspirantInformation.this.setVisible(false);
				WorkerAspirantInformation.this.dispose();
			}
		});
		btnBack.setBounds(508, 609, 97, 25);
		contentPane.add(btnBack);
	}
}
