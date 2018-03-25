package MainMenu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JOptionPane; 

public class MainMenu extends JFrame {

	static JFrame mainframe;
	private JPanel contentPane;
	public static int theme_information;
	
	
	
	public static void DateToString(Date d,JTextField t)
	{
		String res = null;
		if(d == null)
		{
			res = "";
			t.setText(res);
		}
		else
		{
			t.setText(String.valueOf(d));
		}
	}
	

	
	
	public static Connection conn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() 
	{
		try {
		    //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/department", "ya", "euncZ23-");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?useSSL=false", "root", "euncZ23-");
		    if (conn != null) {
		    	//JOptionPane.showMessageDialog (null, "Succesful conection to database!" ); 
		    }
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 628, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Головне Меню");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(164, 31, 316, 64);
		contentPane.add(lblNewLabel);
		
		
		JButton ChooseThemeButton = new JButton("1)Обрати тему");
		ChooseThemeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.setVisible(false);
				try {
					new ChooseTheme(MainMenu.this).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
			}
		});
		ChooseThemeButton.setHorizontalAlignment(SwingConstants.LEFT);
		ChooseThemeButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ChooseThemeButton.setBounds(56, 137, 226, 42);
		contentPane.add(ChooseThemeButton);
		
		JButton AddThemeButton = new JButton("2)Додати тему");
		AddThemeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.setVisible(false);
				try {
					new AddTheme(MainMenu.this).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
			}
		});
		AddThemeButton.setHorizontalAlignment(SwingConstants.LEFT);
		AddThemeButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AddThemeButton.setBounds(56, 214, 226, 42);
		contentPane.add(AddThemeButton);
		
		JButton DeleteThemeButton = new JButton("3)Видалити тему");
		DeleteThemeButton.setForeground(Color.DARK_GRAY);
		DeleteThemeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.setVisible(false);
				try {
					new DeleteTheme(MainMenu.this).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
			}
		});
		DeleteThemeButton.setHorizontalAlignment(SwingConstants.LEFT);
		DeleteThemeButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		DeleteThemeButton.setBounds(56, 289, 226, 42);
		contentPane.add(DeleteThemeButton);
		
		JButton EditThemeButton = new JButton("4)Редагувати тему");
		EditThemeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.setVisible(false);
				try {
					new EditTheme(MainMenu.this).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
			}
		});
		EditThemeButton.setHorizontalAlignment(SwingConstants.LEFT);
		EditThemeButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		EditThemeButton.setBounds(56, 367, 226, 42);
		contentPane.add(EditThemeButton);
	}
}
