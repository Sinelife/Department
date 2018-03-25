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
import dao.MagisterDao;
import dao.WorkingDao;
import domain.Magister;
import domain.Working;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class WorkerMagisterInformation extends JFrame {

	private JPanel contentPane;
	private JTextField SurnameField;
	private JTextField CathedraNameField;
	private JTextField StartField;
	private JTextField EndField;
	private JTextField ThemeDiplomaField;
	private JTextField PhoneField;
	private JTextField WorkTitleInThemeField;
	private JTextField StartInThemeField;
	private JTextField EndInThemeField;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public WorkerMagisterInformation(JFrame parent) throws SQLException
	{
		MagisterDao md = new MagisterDao();
		Magister m = md.read(WorkersList.m_id_to_look);
		WorkingDao wd = new WorkingDao();
		Working w = wd.readWorker(ChooseTheme.id_to_work, WorkersList.m_id_to_look);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 646);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("Інформація про науковця(магістра)");
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
		
		JLabel lblDiplomaTheme = new JLabel("тема диплому");
		lblDiplomaTheme.setBounds(28, 263, 170, 22);
		contentPane.add(lblDiplomaTheme);
		
		JLabel lblPhone = new JLabel("номер");
		lblPhone.setBounds(28, 313, 170, 22);
		contentPane.add(lblPhone);
		
		JLabel lblWorkTitleInTheme = new JLabel("назва роботи в темі");
		lblWorkTitleInTheme.setBounds(28, 357, 170, 22);
		contentPane.add(lblWorkTitleInTheme);
		
		JLabel lblStartInTheme = new JLabel("початок роботи в темі");
		lblStartInTheme.setBounds(28, 407, 170, 22);
		contentPane.add(lblStartInTheme);
		
		JLabel lblEndInTheme = new JLabel("кінець роботи в темі");
		lblEndInTheme.setBounds(28, 455, 170, 22);
		contentPane.add(lblEndInTheme);
		
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
		MainMenu.DateToString(m.getEnd(), EndField);;
		
		
		ThemeDiplomaField = new JTextField();
		ThemeDiplomaField.setEditable(false);
		ThemeDiplomaField.setColumns(10);
		ThemeDiplomaField.setBounds(210, 263, 350, 22);
		contentPane.add(ThemeDiplomaField);
 	  	ThemeDiplomaField.setText(m.getThemeMagister());
		
		
		PhoneField = new JTextField();
		PhoneField.setEditable(false);
		PhoneField.setColumns(10);
		PhoneField.setBounds(210, 313, 350, 22);
		contentPane.add(PhoneField);
 	  	PhoneField.setText(md.getPhone(m.getId()));
 	  	
 	  	
		WorkTitleInThemeField = new JTextField();
		WorkTitleInThemeField.setText((String) null);
		WorkTitleInThemeField.setEditable(false);
		WorkTitleInThemeField.setColumns(10);
		WorkTitleInThemeField.setBounds(210, 357, 350, 22);
		contentPane.add(WorkTitleInThemeField);
 	  	WorkTitleInThemeField.setText(w.getTitle());
 	  	
		
		StartInThemeField = new JTextField();
		StartInThemeField.setText((String) null);
		StartInThemeField.setEditable(false);
		StartInThemeField.setColumns(10);
		StartInThemeField.setBounds(210, 407, 350, 22);
		contentPane.add(StartInThemeField);
 	  	StartInThemeField.setText(String.valueOf(w.getStart()));
		
		
		EndInThemeField = new JTextField();
		EndInThemeField.setText((String) null);
		EndInThemeField.setEditable(false);
		EndInThemeField.setColumns(10);
		EndInThemeField.setBounds(210, 455, 350, 22);
		contentPane.add(EndInThemeField);
		MainMenu.DateToString(w.getEnd(), EndInThemeField);
 	  	
 	  	
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (parent != null)
					parent.setVisible(true);
				WorkerMagisterInformation.this.setVisible(false);
				WorkerMagisterInformation.this.dispose();
			}
		});
		btnBack.setBounds(506, 561, 97, 25);
		contentPane.add(btnBack);
		

	}
}
