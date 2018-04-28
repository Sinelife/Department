package WorkAspirantMenu;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ScientificWorkDao;
import domain.ScientificWork;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ScientificWorkInformation extends JFrame {

	private JPanel contentPane;
	private JTextField TitleField;
	private JTextField TypeField;
	private JTextField YearField;
	private JTextField AuthorSurnameField;


	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ScientificWorkInformation(JFrame parent) throws SQLException 
	{
		setResizable(false);
		ScientificWorkDao swd = new ScientificWorkDao();
		ScientificWork sw = new ScientificWork();
		sw = swd.readWork(ScientificWorkOfAspirant.work_id);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 446);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblScientificWorkInformation = new JLabel("Інформація про наукову роботу");
		lblScientificWorkInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblScientificWorkInformation.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblScientificWorkInformation.setBounds(0, 13, 622, 37);
		contentPane.add(lblScientificWorkInformation);
		
		JLabel TitleLabel = new JLabel("назва нвуковох роботи");
		TitleLabel.setBounds(89, 115, 76, 22);
		contentPane.add(TitleLabel);
		
		JLabel TypeLabel = new JLabel("тип");
		TypeLabel.setBounds(89, 167, 76, 22);
		contentPane.add(TypeLabel);
		
		JLabel Yearlabel = new JLabel("рік");
		Yearlabel.setBounds(89, 225, 76, 22);
		contentPane.add(Yearlabel);
		
		JLabel AuthorSurnameLabel = new JLabel("прізвище автора");
		AuthorSurnameLabel.setBounds(89, 288, 76, 22);
		contentPane.add(AuthorSurnameLabel);
		
		TitleField = new JTextField();
		TitleField.setEditable(false);
		TitleField.setBounds(202, 115, 350, 22);
		contentPane.add(TitleField);
		TitleField.setColumns(10);
		TitleField.setText(sw.getTitle());
		
		
		TypeField = new JTextField();
		TypeField.setEditable(false);
		TypeField.setBounds(202, 167, 350, 22);
		contentPane.add(TypeField);
		TypeField.setColumns(10);
		TypeField.setText(sw.getType());
		
		
		YearField = new JTextField();
		YearField.setEditable(false);
		YearField.setColumns(10);
		YearField.setBounds(202, 225, 350, 22);
		contentPane.add(YearField);
		YearField.setText(String.valueOf(sw.getYear()));
		
		
		AuthorSurnameField = new JTextField();
		AuthorSurnameField.setEditable(false);
		AuthorSurnameField.setColumns(10);
		AuthorSurnameField.setBounds(202, 288, 350, 22);
		contentPane.add(AuthorSurnameField);
		AuthorSurnameField.setText(swd.getSurname(sw.getScientistId()));
		
 	  	
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				ScientificWorkInformation.this.setVisible(false);
				ScientificWorkInformation.this.dispose();
			}
		});
		btnBack.setBounds(489, 360, 97, 25);
		contentPane.add(btnBack);
	}
}
