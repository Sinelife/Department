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
	public static int theme;

	/**
	 * Create the frame.
	 */
	public DepartmentMenu() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Факультет інформатики");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(27, 13, 543, 49);
		contentPane.add(lblNewLabel);
		
		JButton ChooseCathedraButton = new JButton("1)Обрати кафедру для подальшої роботи з нею");
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
		ChooseCathedraButton.setBounds(27, 111, 531, 42);
		contentPane.add(ChooseCathedraButton);
		
		JButton EditCathedraButton = new JButton("2)Редагувати кафедру");
		EditCathedraButton.setForeground(Color.RED);
		EditCathedraButton.setHorizontalAlignment(SwingConstants.LEFT);
		EditCathedraButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		EditCathedraButton.setBounds(27, 191, 531, 42);
		contentPane.add(EditCathedraButton);
		
		JButton AllPeopleOnDepartmentButton = new JButton("3)Перегляд всіх людей факультеті");
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
		AllPeopleOnDepartmentButton.setBounds(27, 272, 531, 42);
		contentPane.add(AllPeopleOnDepartmentButton);
	}
}
