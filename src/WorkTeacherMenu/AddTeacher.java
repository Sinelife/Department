package WorkTeacherMenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.ChooseCathedra;
import main.Methods;

import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class AddTeacher extends JFrame {

	private JPanel contentPane;

	private JTextField SurnameField;
	private JTextField PhoneField;
	private JTextField PositionField;
	private JTextField StatusField;
	private JTextField StartField;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddTeacher(JFrame parent) throws SQLException 
	{
		setResizable(false); 	  	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Додавання викладача");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(0, 24, 636, 59);
		contentPane.add(lblNewLabel);
		
		JLabel SurnameLabel = new JLabel("Прізвище");
		SurnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SurnameLabel.setBounds(53, 115, 112, 22);
		contentPane.add(SurnameLabel);
		
		JLabel PhoneLabel = new JLabel("Телефон");
		PhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneLabel.setBounds(53, 167, 112, 22);
		contentPane.add(PhoneLabel);
		
		JLabel PositionLabel = new JLabel("Посада");
		PositionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PositionLabel.setBounds(53, 225, 112, 22);
		contentPane.add(PositionLabel);
		
		JLabel StatusLabel = new JLabel("Статус");
		StatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		StatusLabel.setBounds(53, 288, 112, 22);
		contentPane.add(StatusLabel);
		
		JLabel StartLabel = new JLabel("Дата початку");
		StartLabel.setHorizontalAlignment(SwingConstants.CENTER);
		StartLabel.setBounds(53, 342, 112, 22);
		contentPane.add(StartLabel);
		
		JLabel SexLabel = new JLabel("Стать");
		SexLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SexLabel.setBounds(53, 390, 112, 22);
		contentPane.add(SexLabel);
	
		
		SurnameField = new JTextField();
		SurnameField.setBounds(177, 115, 375, 22);
		contentPane.add(SurnameField);
		SurnameField.setColumns(10);
		
		PhoneField = new JTextField();
		PhoneField.setBounds(177, 167, 375, 22);
		contentPane.add(PhoneField);
		PhoneField.setColumns(10);
		
		PositionField = new JTextField();
		PositionField.setColumns(10);
		PositionField.setBounds(177, 225, 375, 22);
		contentPane.add(PositionField);
		
		StatusField = new JTextField();
		StatusField.setColumns(10);
		StatusField.setBounds(177, 288, 375, 22);
		contentPane.add(StatusField);
		
		StartField = new JTextField();
		StartField.setColumns(10);
		StartField.setBounds(177, 342, 375, 22);
		contentPane.add(StartField);

		JCheckBox CheckBox = new JCheckBox("");
		CheckBox.setBounds(173, 389, 62, 25);
		contentPane.add(CheckBox);
		
		
		
		
		
		JButton AddButton = new JButton("Додати");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Methods.addTeacher(ChooseCathedra.cathedra_id_to_work, SurnameField, PhoneField, PositionField, StatusField, StartField, CheckBox);
				if (parent != null)
					parent.setVisible(true);
				AddTeacher.this.setVisible(false);
				AddTeacher.this.dispose();
			}
		});
		AddButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AddButton.setBounds(53, 461, 108, 32);
		contentPane.add(AddButton);
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				AddTeacher.this.setVisible(false);
				AddTeacher.this.dispose();
			}
		});
		btnBack.setBounds(527, 481, 97, 25);
		contentPane.add(btnBack);
		
	}
}
