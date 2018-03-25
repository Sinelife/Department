package MenuWorking;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainMenu.ChooseTheme;
import dao.AspirantDao;
import dao.MagisterDao;
import dao.TeacherDao;
import domain.Aspirant;
import domain.Magister;
import domain.Teacher;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class WorkersList extends JFrame {

	private JPanel contentPane;
	public static String a_surname_to_look;
	public static int a_id_to_look;
	public static String m_surname_to_look;
	public static int m_id_to_look;
	public static String t_surname_to_look;
	public static int t_id_to_look;


	
	
	
	
	
	
	/**
	 * Create the frame.
	 * @throws SQLException
	 */
	public WorkersList(JFrame parent) throws SQLException 
	{
		MagisterDao md = new MagisterDao();
		List<Magister> magisters = md.getAllFromTheme(ChooseTheme.id_to_work);
		String[] magister_names = new String[100];
		int[] magister_ids = new int[100];
		int i = 0;
		for(Magister magister : magisters)
		{
			magister_names[i] = md.getSurname(magister.getId());
			magister_ids[i] = magister.getId();
			i++;
		}
		
		
		
		AspirantDao ad = new AspirantDao();
		List<Aspirant> aspirants = ad.getAllFromTheme(ChooseTheme.id_to_work);
		String[] aspirant_names = new String[100];
		int[] aspirant_ids = new int[100];
		i = 0;
		for(Aspirant aspirant : aspirants)
		{
			aspirant_names[i] = ad.getSurname(aspirant.getId());
			aspirant_ids[i] = aspirant.getId();
			i++;
		}
		
		
		
		
		TeacherDao td = new TeacherDao();
		List<Teacher> teachers = td.getAllFromTheme(ChooseTheme.id_to_work);
		String[] teacher_names = new String[100];
		int[] teacher_ids = new int[100];
		i = 0;
		for(Teacher teacher : teachers)
		{
			teacher_names[i] = td.getSurname(teacher.getId());
			teacher_ids[i] = teacher.getId();
			i++;
		}
		
 	  	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox MagistercomboBox = new JComboBox(magister_names);
		MagistercomboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		MagistercomboBox.setBounds(38, 119, 409, 34);
		contentPane.add(MagistercomboBox);
		
		JComboBox AspirantcomboBox = new JComboBox(aspirant_names);
		AspirantcomboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		AspirantcomboBox.setBounds(38, 220, 409, 34);
		contentPane.add(AspirantcomboBox);
		
		JComboBox TeachercomboBox = new JComboBox(teacher_names);
		TeachercomboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		TeachercomboBox.setBounds(38, 327, 409, 34);
		contentPane.add(TeachercomboBox);
		
		JLabel lblNewLabel = new JLabel("Список науковців,що працюють над темою");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(27, 13, 543, 42);
		contentPane.add(lblNewLabel);
		
		JLabel MagisterLabel = new JLabel("Магістри");
		MagisterLabel.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		MagisterLabel.setBounds(38, 81, 97, 25);
		contentPane.add(MagisterLabel);
		
		JLabel AspirantLabel = new JLabel("Аспіранти");
		AspirantLabel.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		AspirantLabel.setBounds(38, 187, 97, 25);
		contentPane.add(AspirantLabel);
		
		JLabel TeacherLabel = new JLabel("Викладачі");
		TeacherLabel.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		TeacherLabel.setBounds(38, 294, 97, 25);
		contentPane.add(TeacherLabel);
		
		
		JButton AspirantChooseButton = new JButton("Інформація");
		AspirantChooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				a_surname_to_look = String.valueOf(AspirantcomboBox.getSelectedItem());
				int k = 0;
				while(true)
				{
					
					a_id_to_look = aspirant_ids[k];
					if((aspirant_names[k]).equals(a_surname_to_look))
					{
						break;
					}
					k++;
				}
				WorkersList.this.setVisible(false);
				try {
					new WorkerAspirantInformation(WorkersList.this).setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		AspirantChooseButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AspirantChooseButton.setBounds(459, 220, 127, 34);
		contentPane.add(AspirantChooseButton);
		
		
		JButton MagisterChooseButton = new JButton("Інформація");
		MagisterChooseButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				m_surname_to_look = String.valueOf(MagistercomboBox.getSelectedItem());
				int k = 0;
				while(true)
				{
					m_id_to_look = magister_ids[k];
					if((magister_names[k]).equals(m_surname_to_look))
					{
						break;
					}
					k++;
				}
				WorkersList.this.setVisible(false);
				try {
					new WorkerMagisterInformation(WorkersList.this).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		MagisterChooseButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MagisterChooseButton.setBounds(459, 119, 127, 34);
		contentPane.add(MagisterChooseButton);

		
		
		
		JButton TeacherChooseButton = new JButton("Інформація");
		TeacherChooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				t_surname_to_look = String.valueOf(TeachercomboBox.getSelectedItem());
				int k = 0;
				while(true)
				{
					t_id_to_look = teacher_ids[k];
					if((teacher_names[k]).equals(t_surname_to_look))
					{
						break;
					}
					k++;
				}
				WorkersList.this.setVisible(false);
				try {
					new WorkerTeacherInformation(WorkersList.this).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		TeacherChooseButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TeacherChooseButton.setBounds(459, 327, 127, 34);
		contentPane.add(TeacherChooseButton);
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				WorkersList.this.setVisible(false);
				WorkersList.this.dispose();
			}
		});
		btnBack.setBounds(489, 427, 97, 25);
		contentPane.add(btnBack);
	}
}
