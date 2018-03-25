package MenuWorking;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import MainMenu.MainMenu;
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
	private JTextField ThemeDiplomaField;
	private JTextField PhoneField;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public NotWorkerMagisterInformation(JFrame parent) throws SQLException
	{
		MagisterDao md = new MagisterDao();
		Magister m = md.read(AddWorkerMagister.m_id_to_look);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 492);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("���������� ��� �������");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbl.setBounds(171, 13, 397, 37);
		contentPane.add(lbl);
		
		JLabel lblSurname = new JLabel("�������");
		lblSurname.setBounds(28, 63, 170, 22);
		contentPane.add(lblSurname);
		
		JLabel lblCathedraName = new JLabel("����� �������");
		lblCathedraName.setBounds(28, 115, 170, 22);
		contentPane.add(lblCathedraName);
		
		JLabel lblStart = new JLabel("������� ��������");
		lblStart.setBounds(28, 173, 170, 22);
		contentPane.add(lblStart);
		
		JLabel lblEnd = new JLabel("����� ��������");
		lblEnd.setBounds(28, 217, 170, 22);
		contentPane.add(lblEnd);
		
		JLabel lblDiplomaTheme = new JLabel("���� �������");
		lblDiplomaTheme.setBounds(28, 263, 170, 22);
		contentPane.add(lblDiplomaTheme);
		
		JLabel lblPhone = new JLabel("�����");
		lblPhone.setBounds(28, 313, 170, 22);
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
		btnBack.setBounds(504, 395, 97, 25);
		contentPane.add(btnBack);

	}
}