package DepartmentMenu;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DepartmentMenu extends JFrame {

	private JPanel contentPane;
	
	public static int teacherSupervisor;
	public static int teacherWorker;
	public static int theme;
	public static int teacher;
	public static int magister;
	public static int aspirant;
	
	public static int finished_theme;

	/**
	 * Create the frame.
	 */
	public DepartmentMenu() 
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("��������� �����������");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(27, 13, 543, 49);
		contentPane.add(lblNewLabel);
		
		JButton ChooseCathedraButton = new JButton("2)������ ������� ��� �������� ������ � ���");
		ChooseCathedraButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				DepartmentMenu.this.setVisible(false);
				try {
					new ChooseCathedra(DepartmentMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		ChooseCathedraButton.setForeground(Color.BLACK);
		ChooseCathedraButton.setHorizontalAlignment(SwingConstants.LEFT);
		ChooseCathedraButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ChooseCathedraButton.setBounds(27, 191, 531, 42);
		contentPane.add(ChooseCathedraButton);
		
		JButton AllPeopleOnDepartmentButton = new JButton("1)�������� ��� �� ����� ���������");
		AllPeopleOnDepartmentButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				DepartmentMenu.this.setVisible(false);
				try {
					new DepartmentPeopleInfo(DepartmentMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		AllPeopleOnDepartmentButton.setForeground(Color.BLACK);
		AllPeopleOnDepartmentButton.setHorizontalAlignment(SwingConstants.LEFT);
		AllPeopleOnDepartmentButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AllPeopleOnDepartmentButton.setBounds(27, 91, 531, 42);
		contentPane.add(AllPeopleOnDepartmentButton);
	}
}
