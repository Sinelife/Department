package WorkAspirantMenu;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.CathedraMenu;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class WorkAspirantMenu extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public WorkAspirantMenu() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Меню роботи з аспірантами");
		label.setBounds(0, 13, 570, 42);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(label);
		
		JButton AddAspirantButton = new JButton("1)Додати аспіранта");
		AddAspirantButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				WorkAspirantMenu.this.setVisible(false);
				try {
					new AddAspirant(WorkAspirantMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		AddAspirantButton.setHorizontalAlignment(SwingConstants.LEFT);
		AddAspirantButton.setForeground(Color.BLACK);
		AddAspirantButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AddAspirantButton.setBounds(58, 94, 434, 42);
		panel.add(AddAspirantButton);
		
		JButton EditAspirantButton = new JButton("2)Редагувати аспіранта");
		EditAspirantButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				WorkAspirantMenu.this.setVisible(false);
				try {
					new EditAspirant(WorkAspirantMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		EditAspirantButton.setHorizontalAlignment(SwingConstants.LEFT);
		EditAspirantButton.setForeground(Color.BLACK);
		EditAspirantButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		EditAspirantButton.setBounds(58, 178, 434, 42);
		panel.add(EditAspirantButton);
		
		JButton AspirantDiplomaRulerButton = new JButton("3)Переглянути аспірантів по викладачам");
		AspirantDiplomaRulerButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				WorkAspirantMenu.this.setVisible(false);
				try {
					new AspirantThemeRulers(WorkAspirantMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		AspirantDiplomaRulerButton.setHorizontalAlignment(SwingConstants.LEFT);
		AspirantDiplomaRulerButton.setForeground(Color.BLACK);
		AspirantDiplomaRulerButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AspirantDiplomaRulerButton.setBounds(58, 260, 434, 42);
		panel.add(AspirantDiplomaRulerButton);
		
		
		
		
		
		JButton AspirantScientificWorkButton = new JButton("4)Наукові праці аспірантів");
		AspirantScientificWorkButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				WorkAspirantMenu.this.setVisible(false);
				try {
					new ScientificWorkOfAspirant(WorkAspirantMenu.this).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		AspirantScientificWorkButton.setHorizontalAlignment(SwingConstants.LEFT);
		AspirantScientificWorkButton.setForeground(Color.BLACK);
		AspirantScientificWorkButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AspirantScientificWorkButton.setBounds(58, 340, 434, 42);
		panel.add(AspirantScientificWorkButton);
		
		
		JButton AddAspirantAsteacherButton = new JButton("5)Назначити аспіранта на посаду викладача");
		AddAspirantAsteacherButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				WorkAspirantMenu.this.setVisible(false);
				try {
					new AddAspirantAsTeacher(WorkAspirantMenu.this).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		AddAspirantAsteacherButton.setHorizontalAlignment(SwingConstants.LEFT);
		AddAspirantAsteacherButton.setForeground(Color.BLACK);
		AddAspirantAsteacherButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AddAspirantAsteacherButton.setBounds(58, 423, 434, 42);
		panel.add(AddAspirantAsteacherButton);
		
		
		JButton DeleteAspirantAsTeacherButton = new JButton("6)Звільнити аспіранта з посади викладача");
		DeleteAspirantAsTeacherButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				WorkAspirantMenu.this.setVisible(false);
				try {
					new DeleteAspirantAsTeacher(WorkAspirantMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		DeleteAspirantAsTeacherButton.setHorizontalAlignment(SwingConstants.LEFT);
		DeleteAspirantAsTeacherButton.setForeground(Color.BLACK);
		DeleteAspirantAsTeacherButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		DeleteAspirantAsTeacherButton.setBounds(58, 509, 434, 42);
		panel.add(DeleteAspirantAsTeacherButton);
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				WorkAspirantMenu.this.setVisible(false);
				WorkAspirantMenu.this.dispose();
				try {
					new CathedraMenu().setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBack.setBounds(473, 580, 97, 25);
		panel.add(btnBack);
	}
}
