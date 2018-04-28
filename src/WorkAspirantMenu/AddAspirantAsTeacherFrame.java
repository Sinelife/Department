package WorkAspirantMenu;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.AspirantDao;
import dao.CathedraDao;
import domain.Aspirant;
import domain.Cathedra;
import main.Methods;

import java.awt.Color;

public class AddAspirantAsTeacherFrame extends JFrame {

	private JPanel contentPane;
	private JTextField SurnameField;
	private JTextField PositionField;
	private JTextField StatusField;
	private JTextField StartField;
	private JComboBox<String> CathedraComboBox;

	
	public static int cathedra_id;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddAspirantAsTeacherFrame(JFrame parent) throws SQLException 
	{
		setResizable(false);
		AspirantDao ad = new AspirantDao();
		Aspirant a = ad.readAspirant(AddAspirantAsTeacher.id_to_select);
		CathedraDao cd = new CathedraDao();
		List<Cathedra> cathedras = cd.getAll();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Назначення аспіранта на посаду викладача");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(0, 24, 636, 59);
		contentPane.add(lblNewLabel);
		
		JLabel SurnameLabel = new JLabel("Прізвище");
		SurnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SurnameLabel.setBounds(53, 115, 112, 22);
		contentPane.add(SurnameLabel);
		
		JLabel PositionLabel = new JLabel("Посада");
		PositionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PositionLabel.setBounds(53, 174, 112, 22);
		contentPane.add(PositionLabel);
		
		JLabel StatusLabel = new JLabel("Статус");
		StatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		StatusLabel.setBounds(53, 237, 112, 22);
		contentPane.add(StatusLabel);
		
		JLabel StartLabel = new JLabel("Дата початку");
		StartLabel.setHorizontalAlignment(SwingConstants.CENTER);
		StartLabel.setBounds(53, 291, 112, 22);
		contentPane.add(StartLabel);
	
		JLabel label = new JLabel("Назва кафедри");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(53, 344, 112, 22);
		contentPane.add(label);

		
		SurnameField = new JTextField();
		SurnameField.setBackground(Color.WHITE);
		SurnameField.setEditable(false);
		SurnameField.setBounds(177, 115, 375, 22);
		contentPane.add(SurnameField);
		SurnameField.setColumns(10);
		SurnameField.setText(ad.getSurname(a.getId()));
		
		PositionField = new JTextField();
		PositionField.setColumns(10);
		PositionField.setBounds(177, 174, 375, 22);
		contentPane.add(PositionField);
		
		StatusField = new JTextField();
		StatusField.setColumns(10);
		StatusField.setBounds(177, 237, 375, 22);
		contentPane.add(StatusField);
		
		StartField = new JTextField();
		StartField.setColumns(10);
		StartField.setBounds(177, 291, 375, 22);
		contentPane.add(StartField);
		
		CathedraComboBox = new JComboBox<String>();
		CathedraComboBox.setBounds(177, 344, 375, 22);
		contentPane.add(CathedraComboBox);
		for(Cathedra cathedra : cathedras)
		{
			CathedraComboBox.addItem(cathedra.getName());
		}
		
		
		
		JButton AddButton = new JButton("Додати");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				cathedra_id = Methods.getCathedraIdByCathedraName(CathedraComboBox, cathedras);
				Methods.addAspirantAsTeacher(AddAspirantAsTeacher.id_to_select, cathedra_id, PositionField, StatusField, StartField);
				AddAspirantAsTeacherFrame.this.setVisible(false);
				AddAspirantAsTeacherFrame.this.dispose();
				new WorkAspirantMenu().setVisible(true);
			}
		});
		AddButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AddButton.setBounds(53, 410, 125, 32);
		contentPane.add(AddButton);
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				AddAspirantAsTeacherFrame.this.setVisible(false);
				AddAspirantAsTeacherFrame.this.dispose();
			}
		});
		btnBack.setBounds(527, 415, 97, 25);
		contentPane.add(btnBack);
	}
}
