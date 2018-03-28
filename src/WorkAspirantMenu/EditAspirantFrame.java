package WorkAspirantMenu;

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

import WorkAspirantMenu.EditAspirant;
import dao.AspirantDao;
import dao.TeacherDao;
import main.Methods;
import domain.Aspirant;
import domain.Teacher;

import javax.swing.JComboBox;

public class EditAspirantFrame extends JFrame {

	private JPanel contentPane;
	private JTextField SurnameField;
	private JTextField StartField;
	private JTextField EndField;
	private JTextField ProtectionField;
	private JTextField DiplomaField;
	private JTextField PhoneField;
	private JTextField RulerField;
	
	public static int ruler_id;
	public static String ruler_surname;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public EditAspirantFrame(JFrame parent) throws SQLException 
	{
		AspirantDao ad = new AspirantDao();
		TeacherDao td = new TeacherDao();
		Aspirant a = ad.readAspirant(EditAspirant.id_to_edit);
		List<Teacher> rulers = td.getAll();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Редагування аспіранта");
		label.setBounds(0, 13, 570, 42);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(label);
		
		JLabel SurnameLabel = new JLabel("Прізвище");
		SurnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SurnameLabel.setBounds(12, 85, 162, 22);
		contentPane.add(SurnameLabel);
		
		JLabel StartLabel = new JLabel("Дата початку");
		StartLabel.setHorizontalAlignment(SwingConstants.CENTER);
		StartLabel.setBounds(12, 138, 162, 22);
		contentPane.add(StartLabel);
		
		JLabel EndLabel = new JLabel("Дата закінчення");
		EndLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EndLabel.setBounds(12, 184, 162, 22);
		contentPane.add(EndLabel);
		
		JLabel ProtectionLabel = new JLabel("Дата захисту");
		ProtectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ProtectionLabel.setBounds(12, 236, 162, 22);
		contentPane.add(ProtectionLabel);
		
		JLabel DiplomaLabel = new JLabel("Тема диплому");
		DiplomaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DiplomaLabel.setBounds(12, 286, 162, 22);
		contentPane.add(DiplomaLabel);
		
		JLabel PhoneLabel = new JLabel("Номер");
		PhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneLabel.setBounds(12, 335, 162, 22);
		contentPane.add(PhoneLabel);
		
		JLabel SexLabel = new JLabel("Стать");
		SexLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SexLabel.setBounds(12, 387, 162, 22);
		contentPane.add(SexLabel);
		
		JLabel RulerLabel = new JLabel("Керівник теми");
		RulerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		RulerLabel.setBounds(12, 422, 162, 27);
		contentPane.add(RulerLabel);
		
		
		SurnameField = new JTextField();
		SurnameField.setText((String) null);
		SurnameField.setColumns(10);
		SurnameField.setBounds(198, 85, 350, 22);
		contentPane.add(SurnameField);
		SurnameField.setText(ad.getSurname(a.getId()));
		
		StartField = new JTextField();
		StartField.setColumns(10);
		StartField.setBounds(198, 138, 350, 22);
		contentPane.add(StartField);
		StartField.setText(String.valueOf(a.getStart()));
		
		EndField = new JTextField();
		EndField.setColumns(10);
		EndField.setBounds(198, 184, 350, 22);
		contentPane.add(EndField);
		Methods.DateToString(a.getEnd(), EndField);
		
		ProtectionField = new JTextField();
		ProtectionField.setColumns(10);
		ProtectionField.setBounds(198, 236, 350, 22);
		contentPane.add(ProtectionField);
		Methods.DateToString(a.getProtection(), ProtectionField);
		
		
		DiplomaField = new JTextField();
		DiplomaField.setText((String) null);
		DiplomaField.setColumns(10);
		DiplomaField.setBounds(198, 286, 350, 22);
		contentPane.add(DiplomaField);
		DiplomaField.setText(a.getThemeAspirant());
		
		PhoneField = new JTextField();
		PhoneField.setText((String) null);
		PhoneField.setColumns(10);
		PhoneField.setBounds(198, 335, 350, 22);
		contentPane.add(PhoneField);
		PhoneField.setText(ad.getPhone(a.getId()));
		
		
		JCheckBox SexCheckBox = new JCheckBox("");
		SexCheckBox.setBounds(198, 386, 25, 25);
		contentPane.add(SexCheckBox);
		if(ad.getSex(a.getId()) == true)
		{
			SexCheckBox.setSelected(true);
		}
		else
		{
			SexCheckBox.setSelected(false);
		}
		
		RulerField = new JTextField();
		RulerField.setBounds(198, 424, 350, 22);
		contentPane.add(RulerField);
		RulerField.setColumns(10);
		RulerField.setText(ad.getRuler(a.getId()));
		
		JComboBox<String> RulerComboBox = new JComboBox<String>();
		RulerComboBox.setBounds(198, 451, 350, 22);
		contentPane.add(RulerComboBox);
		for(Teacher teacher : rulers)
		{
			RulerComboBox.addItem(td.getSurname(teacher.getId()));
		}
		
		
		
		JButton AddButton = new JButton("Редагувати");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					ruler_id = Methods.getTeacherIdBySurname(ruler_surname, ruler_id, RulerComboBox, rulers);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				Methods.updateAspirant(EditAspirant.id_to_edit, ruler_id, SurnameField, PhoneField, StartField, EndField, ProtectionField, DiplomaField, SexCheckBox);
				EditAspirantFrame.this.setVisible(false);
				EditAspirantFrame.this.dispose();
				new WorkAspirantMenu().setVisible(true);
			}
		});
		AddButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AddButton.setBounds(46, 494, 125, 32);
		contentPane.add(AddButton);
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				EditAspirantFrame.this.setVisible(false);
				EditAspirantFrame.this.dispose();
			}
		});
		btnBack.setBounds(527, 499, 97, 25);
		contentPane.add(btnBack);
		

	}

}
