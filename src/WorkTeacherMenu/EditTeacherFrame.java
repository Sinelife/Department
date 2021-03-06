package WorkTeacherMenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.TeacherDao;
import domain.Teacher;
import main.Methods;

public class EditTeacherFrame extends JFrame {

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
	public EditTeacherFrame(JFrame parent) throws SQLException 
	{
		setResizable(false);
		TeacherDao td = new TeacherDao();
		Teacher t = td.readTeacher(EditTeacher.id_to_edit);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("����������� ���������");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(0, 24, 636, 59);
		contentPane.add(lblNewLabel);
		
		JLabel SurnameLabel = new JLabel("�������");
		SurnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SurnameLabel.setBounds(53, 115, 112, 22);
		contentPane.add(SurnameLabel);
		
		JLabel PhoneLabel = new JLabel("�������");
		PhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneLabel.setBounds(53, 167, 112, 22);
		contentPane.add(PhoneLabel);
		
		JLabel PositionLabel = new JLabel("������");
		PositionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PositionLabel.setBounds(53, 225, 112, 22);
		contentPane.add(PositionLabel);
		
		JLabel StatusLabel = new JLabel("������");
		StatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		StatusLabel.setBounds(53, 288, 112, 22);
		contentPane.add(StatusLabel);
		
		JLabel StartLabel = new JLabel("���� �������");
		StartLabel.setHorizontalAlignment(SwingConstants.CENTER);
		StartLabel.setBounds(53, 342, 112, 22);
		contentPane.add(StartLabel);
		
		JLabel SexLabel = new JLabel("�����");
		SexLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SexLabel.setBounds(53, 390, 112, 22);
		contentPane.add(SexLabel);
	
		
		SurnameField = new JTextField();
		SurnameField.setBounds(177, 115, 375, 22);
		contentPane.add(SurnameField);
		SurnameField.setColumns(10);
		SurnameField.setText(td.getSurname(t.getId()));
		
		PhoneField = new JTextField();
		PhoneField.setBounds(177, 167, 375, 22);
		contentPane.add(PhoneField);
		PhoneField.setColumns(10);
		PhoneField.setText(td.getPhone(t.getId()));
		
		PositionField = new JTextField();
		PositionField.setColumns(10);
		PositionField.setBounds(177, 225, 375, 22);
		contentPane.add(PositionField);
		PositionField.setText(t.getPosition());
		
		StatusField = new JTextField();
		StatusField.setColumns(10);
		StatusField.setBounds(177, 288, 375, 22);
		contentPane.add(StatusField);
		StatusField.setText(t.getStatus());
		
		StartField = new JTextField();
		StartField.setColumns(10);
		StartField.setBounds(177, 342, 375, 22);
		contentPane.add(StartField);
		StartField.setText(String.valueOf(t.getStart()));

		JCheckBox CheckBox = new JCheckBox("");
		CheckBox.setBounds(173, 389, 62, 25);
		contentPane.add(CheckBox);
		if(td.getSex(t.getId()) == true)
		{
			CheckBox.setSelected(true);
		}
		else
		{
			CheckBox.setSelected(false);
		}
		
		
		
		
		JButton AddButton = new JButton("����������");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Methods.updateTeacher(EditTeacher.id_to_edit, SurnameField, PhoneField, CheckBox, PositionField, StatusField, StartField);
				EditTeacherFrame.this.setVisible(false);
				EditTeacherFrame.this.dispose();
				new WorkTeacherMenu().setVisible(true);
			}
		});
		AddButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AddButton.setBounds(53, 461, 125, 32);
		contentPane.add(AddButton);
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				EditTeacherFrame.this.setVisible(false);
				EditTeacherFrame.this.dispose();
			}
		});
		btnBack.setBounds(527, 481, 97, 25);
		contentPane.add(btnBack);
	}

}
