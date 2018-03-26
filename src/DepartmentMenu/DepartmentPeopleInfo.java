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

import dao.AspirantDao;
import dao.MagisterDao;
import dao.TeacherDao;
import domain.Aspirant;
import domain.Magister;
import domain.Teacher;

public class DepartmentPeopleInfo extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public DepartmentPeopleInfo(JFrame parent) throws SQLException 
	{
		TeacherDao td = new TeacherDao();
		MagisterDao md = new MagisterDao();
		AspirantDao ad = new AspirantDao();
		List<Teacher> teachers = td.getAll();
		List<Aspirant> aspirants = ad.getAll();
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
		lblNewLabel.setBounds(72, 133, 87, 25);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("Аспіранти");
		label_1.setBounds(72, 230, 87, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Магістри");
		label_2.setBounds(72, 333, 87, 25);
		contentPane.add(label_2);
		
		JComboBox<String> TeacherComboBox = new JComboBox<String>();
		TeacherComboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		TeacherComboBox.setBounds(171, 130, 237, 31);
		contentPane.add(TeacherComboBox);
		for(Teacher teacher : teachers)
		{
			TeacherComboBox.addItem(td.getSurname(teacher.getId()));
		}
		
		JComboBox<String> AspirantComboBox = new JComboBox<String>();
		AspirantComboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AspirantComboBox.setBounds(171, 230, 237, 31);
		contentPane.add(AspirantComboBox);
		for(Aspirant aspirant : aspirants)
		{
			AspirantComboBox.addItem(ad.getSurname(aspirant.getId()));
		}
		
		JComboBox<String> MagisterComboBox = new JComboBox<String>();
		MagisterComboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		MagisterComboBox.setBounds(171, 333, 237, 31);
		contentPane.add(MagisterComboBox);
		for(Magister magister : magisters)
		{
			MagisterComboBox.addItem(md.getSurname(magister.getId()));
		}
		
		
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (parent != null)
					parent.setVisible(true);
				DepartmentPeopleInfo.this.setVisible(false);
				DepartmentPeopleInfo.this.dispose();
			}
		});
		button.setBounds(412, 410, 97, 25);
		contentPane.add(button);
	}

}
