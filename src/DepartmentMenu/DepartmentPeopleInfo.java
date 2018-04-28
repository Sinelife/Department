package DepartmentMenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import MenuWorking.NotWorkerAspirantInformation;
import MenuWorking.NotWorkerMagisterInformation;
import MenuWorking.NotWorkerTeacherInformation;
import dao.AspirantDao;
import dao.MagisterDao;
import dao.TeacherDao;
import domain.Aspirant;
import domain.Magister;
import domain.Teacher;
import main.Methods;

public class DepartmentPeopleInfo extends JFrame {

	private JPanel contentPane;

	public static int m_id;
	public static int a_id;
	public static int t_id;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public DepartmentPeopleInfo(JFrame parent) throws SQLException 
	{
		setResizable(false);
		TeacherDao td = new TeacherDao();
		MagisterDao md = new MagisterDao();
		AspirantDao ad = new AspirantDao();
		List<Teacher> teachers = td.getAll();
		List<Aspirant> aspirants = ad.getAll();
		List<Aspirant> aspirants_finish = ad.getAllWhoFinished();
		List<Magister> magisters = md.getAll();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Люди на факультеті");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 27));
		label.setBounds(0, 13, 539, 42);
		contentPane.add(label);
		
		
		JLabel lblNewLabel = new JLabel("Викладачі");
		lblNewLabel.setBounds(36, 118, 87, 25);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("Аспіранти");
		label_1.setBounds(36, 215, 87, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Магістри");
		label_2.setBounds(36, 318, 87, 25);
		contentPane.add(label_2);
		
		JComboBox<String> TeacherComboBox = new JComboBox<String>();
		TeacherComboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		TeacherComboBox.setBounds(135, 115, 237, 31);
		contentPane.add(TeacherComboBox);
		for(Teacher teacher : teachers)
		{
			TeacherComboBox.addItem(td.getSurname(teacher.getId()));
		}
		
		JComboBox<String> AspirantComboBox = new JComboBox<String>();
		AspirantComboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AspirantComboBox.setBounds(135, 215, 237, 31);
		contentPane.add(AspirantComboBox);
		for(Aspirant aspirant : aspirants)
		{
			AspirantComboBox.addItem(ad.getSurname(aspirant.getId()));
		}
		
		JComboBox<String> MagisterComboBox = new JComboBox<String>();
		MagisterComboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		MagisterComboBox.setBounds(135, 318, 237, 31);
		contentPane.add(MagisterComboBox);
		for(Magister magister : magisters)
		{
			MagisterComboBox.addItem(md.getSurname(magister.getId()));
		}
		
		

		
		JButton TeacherInfoButton = new JButton("Інформація");
		TeacherInfoButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					t_id = Methods.getTeacherIdBySurname(TeacherComboBox, teachers);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DepartmentMenu.teacher = 1;
				DepartmentPeopleInfo.this.setVisible(false);
				try {
					new NotWorkerTeacherInformation(DepartmentPeopleInfo.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		TeacherInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TeacherInfoButton.setBounds(387, 115, 122, 34);
		contentPane.add(TeacherInfoButton);
		
		
		JButton AspirantInfoButton = new JButton("Інформація");
		AspirantInfoButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					a_id = Methods.getAspirantIdBySurname(AspirantComboBox, aspirants);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DepartmentMenu.aspirant = 1;
				DepartmentPeopleInfo.this.setVisible(false);
				try {
					new NotWorkerAspirantInformation(DepartmentPeopleInfo.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		AspirantInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AspirantInfoButton.setBounds(387, 215, 122, 34);
		contentPane.add(AspirantInfoButton);
		
		
		JButton MagisterInfoButton = new JButton("Інформація");
		MagisterInfoButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					m_id = Methods.getMagisterIdBySurname(MagisterComboBox, magisters);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DepartmentMenu.magister = 1;
				DepartmentPeopleInfo.this.setVisible(false);
				try {
					new NotWorkerMagisterInformation(DepartmentPeopleInfo.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		MagisterInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MagisterInfoButton.setBounds(384, 318, 122, 34);
		contentPane.add(MagisterInfoButton);
		
		
		
		
		JButton FinishedButton = new JButton("Закінчили навчання");
		FinishedButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				AspirantComboBox.removeAllItems();
				for(Aspirant aspirant : aspirants_finish)
				{
					try {
						AspirantComboBox.addItem(ad.getSurname(aspirant.getId()));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		FinishedButton.setBounds(135, 259, 168, 25);
		contentPane.add(FinishedButton);
		
		JButton AllButton = new JButton("Всі");
		AllButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				AspirantComboBox.removeAllItems();
				for(Aspirant aspirant : aspirants)
				{
					try {
						AspirantComboBox.addItem(ad.getSurname(aspirant.getId()));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		AllButton.setBounds(306, 259, 66, 25);
		contentPane.add(AllButton);
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (parent != null)
					parent.setVisible(true);
				DepartmentPeopleInfo.this.setVisible(false);
				DepartmentPeopleInfo.this.dispose();
			}
		});
		btnBack.setBounds(412, 410, 97, 25);
		contentPane.add(btnBack);
	}

}
