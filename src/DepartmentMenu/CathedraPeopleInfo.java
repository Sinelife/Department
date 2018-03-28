package DepartmentMenu;

import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import MenuWorking.NotWorkerAspirantInformation;
import MenuWorking.NotWorkerMagisterInformation;
import MenuWorking.NotWorkerTeacherInformation;
import dao.AspirantDao;
import dao.CathedraDao;
import dao.MagisterDao;
import dao.TeacherDao;
import domain.Aspirant;
import domain.Cathedra;
import domain.Magister;
import domain.Teacher;
import main.Methods;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CathedraPeopleInfo extends JFrame 
{

	private JPanel contentPane;

	public static int m_id = 0;
	public static String m_name;
	public static int a_id = 0;
	public static String a_name;
	public static int t_id = 0;
	public static String t_name;
	
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CathedraPeopleInfo(JFrame parent) throws SQLException 
	{
		CathedraDao cd = new CathedraDao();
		TeacherDao td = new TeacherDao();
		MagisterDao md = new MagisterDao();
		AspirantDao ad = new AspirantDao();
		Cathedra c = cd.readCathedra(ChooseCathedra.cathedra_id_to_work);
		List<Teacher> teachers = td.getAllFromCathedra(ChooseCathedra.cathedra_id_to_work);
		List<Aspirant> aspirants = ad.getAllFromCathedra(ChooseCathedra.cathedra_id_to_work);
		List<Aspirant> aspirants_finish = ad.getAllFromCathedraWhoFinished(ChooseCathedra.cathedra_id_to_work);
		List<Magister> magisters = md.getAllFromCathedra(ChooseCathedra.cathedra_id_to_work);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Люди на ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 27));
		label.setBounds(0, 13, 539, 42);
		contentPane.add(label);
		
		String l = "''";
		String res = l.concat(c.getName()).concat(l);
		JLabel label1 = new JLabel(res);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label1.setBounds(0, 68, 539, 42);
		contentPane.add(label1);
		
		JLabel lblNewLabel = new JLabel("Викладачі");
		lblNewLabel.setBounds(32, 134, 87, 25);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("Аспіранти");
		label_1.setBounds(32, 231, 87, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Магістри");
		label_2.setBounds(32, 334, 87, 25);
		contentPane.add(label_2);
		
		JComboBox<String> TeacherComboBox = new JComboBox<String>();
		TeacherComboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		TeacherComboBox.setBounds(131, 131, 237, 31);
		contentPane.add(TeacherComboBox);
		for(Teacher teacher : teachers)
		{
			TeacherComboBox.addItem(td.getSurname(teacher.getId()));
		}
		
		JComboBox<String> AspirantComboBox = new JComboBox<String>();
		AspirantComboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AspirantComboBox.setBounds(131, 231, 237, 31);
		contentPane.add(AspirantComboBox);
		for(Aspirant aspirant : aspirants)
		{
			AspirantComboBox.addItem(ad.getSurname(aspirant.getId()));
		}
		
		JComboBox<String> MagisterComboBox = new JComboBox<String>();
		MagisterComboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		MagisterComboBox.setBounds(131, 334, 237, 31);
		contentPane.add(MagisterComboBox);
		for(Magister magister : magisters)
		{
			MagisterComboBox.addItem(md.getSurname(magister.getId()));
		}
		
		
		
		
	
		
		JButton TeacherInfoButton = new JButton("Інформація");
		TeacherInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					t_id = Methods.getTeacherIdBySurname(t_name, t_id, TeacherComboBox, teachers);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DepartmentMenu.teacher = 2;
				CathedraPeopleInfo.this.setVisible(false);
				try {
					new NotWorkerTeacherInformation(CathedraPeopleInfo.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		TeacherInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TeacherInfoButton.setBounds(380, 128, 122, 34);
		contentPane.add(TeacherInfoButton);
		
		
		JButton AspirantInfoButton = new JButton("Інформація");
		AspirantInfoButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					a_id = Methods.getAspirantIdBySurname(a_name, a_id, AspirantComboBox, aspirants);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DepartmentMenu.aspirant = 2;
				CathedraPeopleInfo.this.setVisible(false);
				try {
					new NotWorkerAspirantInformation(CathedraPeopleInfo.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		AspirantInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AspirantInfoButton.setBounds(380, 231, 122, 34);
		contentPane.add(AspirantInfoButton);
		
		
		JButton MagisterInfoButton = new JButton("Інформація");
		MagisterInfoButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					m_id = Methods.getMagisterIdBySurname(m_name, m_id, MagisterComboBox, magisters);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DepartmentMenu.magister = 2;
				CathedraPeopleInfo.this.setVisible(false);
				try {
					new NotWorkerMagisterInformation(CathedraPeopleInfo.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		MagisterInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MagisterInfoButton.setBounds(380, 334, 122, 34);
		contentPane.add(MagisterInfoButton);
		
		
		
		
		
		JButton FinishedButton = new JButton("Закінчили навчання");
		FinishedButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				AspirantComboBox.removeAllItems();
				for(Aspirant aspirant : aspirants_finish)
				{
					try {
						AspirantComboBox.addItem(ad.getSurname(aspirant.getId()));
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		FinishedButton.setBounds(131, 275, 168, 25);
		contentPane.add(FinishedButton);
		
		
		JButton AllButton = new JButton("Усі");
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
		AllButton.setBounds(302, 275, 66, 25);
		contentPane.add(AllButton);
		
		
		
		
		
		JButton btnback = new JButton("BACK");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (parent != null)
					parent.setVisible(true);
				CathedraPeopleInfo.this.setVisible(false);
				CathedraPeopleInfo.this.dispose();
			}
		});
		btnback.setBounds(412, 410, 97, 25);
		contentPane.add(btnback);
	}
}
