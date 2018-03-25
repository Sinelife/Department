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

import MainMenu.ChooseTheme;
import MainMenu.MainMenu;
import dao.SupervisionDao;
import dao.TeacherDao;
import domain.Supervision;
import domain.Teacher;



public class SupervisorInformation extends JFrame {

	private JPanel contentPane;
	private JTextField PositionField;
	private JTextField StatusField;
	private JTextField StartField;
	private JTextField CathedraNameField;
	private JTextField PhoneField;
	private JTextField SurnameField;
	private JTextField StartInThemeField;
	private JTextField EndInThemeField;


	/** 
	 * Create the frame.
	 * @throws SQLException 
	 */
	public SupervisorInformation(JFrame parent) throws SQLException 
	{
		SupervisionDao sd = new SupervisionDao();
		Supervision s = sd.readSupervisor(ChooseTheme.id_to_work);
		TeacherDao td = new TeacherDao();
		Teacher t = td.read(s.getScientistId());
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 546);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSupervisorInformation = new JLabel("Інформація про керівника");
		lblSupervisorInformation.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSupervisorInformation.setBounds(171, 13, 258, 37);
		contentPane.add(lblSupervisorInformation);

		JLabel lblSurname = new JLabel("прізвище");
		lblSurname.setBounds(33, 63, 179, 22);
		contentPane.add(lblSurname);

		JLabel lblPosition = new JLabel("посада");
		lblPosition.setBounds(33, 115, 179, 22);
		contentPane.add(lblPosition);

		JLabel lblStatus = new JLabel("звання");
		lblStatus.setBounds(33, 167, 179, 22);
		contentPane.add(lblStatus);

		JLabel lblStart = new JLabel("початок роботи");
		lblStart.setBounds(35, 207, 177, 22);
		contentPane.add(lblStart);

		JLabel lblCathedraName = new JLabel("назва кафедри");
		lblCathedraName.setBounds(35, 254, 177, 22);
		contentPane.add(lblCathedraName);

		JLabel lblPhone = new JLabel("номер");
		lblPhone.setBounds(35, 300, 177, 22);
		contentPane.add(lblPhone);

		JLabel lblStartInTheme = new JLabel("початок керування темою");
		lblStartInTheme.setBounds(33, 345, 179, 22);
		contentPane.add(lblStartInTheme);

		JLabel lblEndInTheme = new JLabel("кінець керування темою");
		lblEndInTheme.setBounds(33, 387, 179, 22);
		contentPane.add(lblEndInTheme);

		SurnameField = new JTextField();
		SurnameField.setEditable(false);
		SurnameField.setBounds(226, 63, 373, 22);
		contentPane.add(SurnameField);
		SurnameField.setColumns(10);
		SurnameField.setText(td.getSurname(t.getId()));

		PositionField = new JTextField();
		PositionField.setEditable(false);
		PositionField.setBounds(226, 115, 373, 22);
		contentPane.add(PositionField);
		PositionField.setColumns(10);
		PositionField.setText(t.getPosition());

		StatusField = new JTextField();
		StatusField.setEditable(false);
		StatusField.setBounds(226, 167, 373, 22);
		contentPane.add(StatusField);
		StatusField.setColumns(10);
		StatusField.setText(t.getStatus());

		StartField = new JTextField();
		StartField.setEditable(false);
		StartField.setColumns(10);
		StartField.setBounds(226, 207, 373, 22);
		contentPane.add(StartField);
		StartField.setText(String.valueOf(t.getStart()));

		CathedraNameField = new JTextField();
		CathedraNameField.setEditable(false);
		CathedraNameField.setColumns(10);
		CathedraNameField.setBounds(226, 254, 373, 22);
		contentPane.add(CathedraNameField);
		CathedraNameField.setText(td.getCathedraName(t.getId()));

		PhoneField = new JTextField();
		PhoneField.setEditable(false);
		PhoneField.setColumns(10);
		PhoneField.setBounds(226, 300, 373, 22);
		contentPane.add(PhoneField);
		PhoneField.setText(td.getPhone(t.getId()));

		StartInThemeField = new JTextField();
		StartInThemeField.setText((String) null);
		StartInThemeField.setEditable(false);
		StartInThemeField.setColumns(10);
		StartInThemeField.setBounds(224, 346, 375, 22);
		contentPane.add(StartInThemeField);
		StartInThemeField.setText(String.valueOf(s.getStart()));

		EndInThemeField = new JTextField();
		EndInThemeField.setText((String) null);
		EndInThemeField.setEditable(false);
		EndInThemeField.setColumns(10);
		EndInThemeField.setBounds(224, 386, 375, 22);
		contentPane.add(EndInThemeField);
		MainMenu.DateToString(s.getEnd(), EndInThemeField);
		
		

		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(526, 465, 97, 25);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				SupervisorInformation.this.setVisible(false);
				SupervisorInformation.this.dispose();
			}
		});
		contentPane.add(btnBack);
	}
}
