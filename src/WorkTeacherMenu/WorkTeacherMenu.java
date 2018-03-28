package WorkTeacherMenu;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.CathedraMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class WorkTeacherMenu extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public WorkTeacherMenu() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Меню роботи з викладачами");
		label.setBounds(0, 13, 570, 42);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(label);
		
		
		JButton AddTeacherButton = new JButton("1)Додати викладача");
		AddTeacherButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				WorkTeacherMenu.this.setVisible(false);
				try {
					new AddTeacher(WorkTeacherMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		AddTeacherButton.setBounds(37, 111, 456, 42);
		AddTeacherButton.setHorizontalAlignment(SwingConstants.LEFT);
		AddTeacherButton.setForeground(Color.BLACK);
		AddTeacherButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(AddTeacherButton);
		
		JButton EditTeacherButton = new JButton("2)Редагувати викладача");
		EditTeacherButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				WorkTeacherMenu.this.setVisible(false);
				try {
					new EditTeacher(WorkTeacherMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		EditTeacherButton.setBounds(37, 201, 456, 42);
		EditTeacherButton.setHorizontalAlignment(SwingConstants.LEFT);
		EditTeacherButton.setForeground(Color.BLACK);
		EditTeacherButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(EditTeacherButton);
		
		JButton TeacherSupervisionButton = new JButton("3)Переглянути, якими темами керують викладачі");
		TeacherSupervisionButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				WorkTeacherMenu.this.setVisible(false);
				try {
					new TeacherSupervisionInfo(WorkTeacherMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		TeacherSupervisionButton.setBounds(37, 294, 456, 42);
		TeacherSupervisionButton.setHorizontalAlignment(SwingConstants.LEFT);
		TeacherSupervisionButton.setForeground(Color.BLACK);
		TeacherSupervisionButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(TeacherSupervisionButton);
		
		
		JButton TeacherWorkingButtom = new JButton("4)Переглянути на, яких темах працюють викладачі");
		TeacherWorkingButtom.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				WorkTeacherMenu.this.setVisible(false);
				try {
					new TeacherWorkingInfo(WorkTeacherMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		TeacherWorkingButtom.setBounds(37, 381, 456, 42);
		TeacherWorkingButtom.setHorizontalAlignment(SwingConstants.LEFT);
		TeacherWorkingButtom.setForeground(Color.BLACK);
		TeacherWorkingButtom.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(TeacherWorkingButtom);
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				WorkTeacherMenu.this.setVisible(false);
				WorkTeacherMenu.this.dispose();
				try {
					new CathedraMenu().setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnBack.setBounds(459, 455, 97, 25);
		panel.add(btnBack);
	}

}
