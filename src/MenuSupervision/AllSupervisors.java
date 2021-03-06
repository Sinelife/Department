package MenuSupervision;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.DepartmentMenu;
import ThemesMenu.ChooseTheme;
import dao.ScientificThemeDao;
import dao.SupervisionDao;
import domain.Supervision;

public class AllSupervisors extends JFrame {

	private JPanel contentPane;

	
	public static Date supervisor_date;
	public static String supervisor_surname;
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AllSupervisors(JFrame parent) throws SQLException
	{
		setResizable(false);		
		ScientificThemeDao std = new ScientificThemeDao();
		
		SupervisionDao sd = new SupervisionDao();
		List<Supervision> supervisors = std.getAllSupervisors(ChooseTheme.id_to_work);
		Collections.sort(supervisors);
		List<String> supervisor_surnames = new ArrayList<String>();
		int i = 1;
		for(Supervision supervisor : supervisors)
		{
			supervisor_surnames.add(i + ". (" + supervisor.getStart() + ")" + sd.getSurname(supervisor.getScientistId()));
			i++;
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("������� � �������� �������� ����");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(0, 44, 610, 42);
		contentPane.add(lblNewLabel);
		
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		comboBox.setBounds(40, 121, 411, 34);
		contentPane.add(comboBox);
		for(String supervisor : supervisor_surnames)
		{
			comboBox.addItem(supervisor);
		}
		

		
		JButton EverySupervisorInfoButton = new JButton("����������");
		EverySupervisorInfoButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				supervisor_surname = String.valueOf(comboBox.getSelectedItem());
				String str = supervisor_surname;
				str = str.substring(str.indexOf("(") + 1); 
				String str_date = str.substring(0, str.indexOf(")"));
				supervisor_date = Date.valueOf(str_date);
				DepartmentMenu.teacherSupervisor = 3;
				AllSupervisors.this.setVisible(false);
				try {
					new SupervisorInformation(AllSupervisors.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		EverySupervisorInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EverySupervisorInfoButton.setBounds(466, 121, 120, 34);
		contentPane.add(EverySupervisorInfoButton);
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				AllSupervisors.this.setVisible(false);
				AllSupervisors.this.dispose();
			}
		});
		btnBack.setBounds(489, 427, 97, 25);
		contentPane.add(btnBack);
	}

}
