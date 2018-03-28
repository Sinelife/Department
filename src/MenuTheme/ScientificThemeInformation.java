package MenuTheme;
import DepartmentMenu.DepartmentMenu;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ThemesMenu.ChooseTheme;
import ThemesMenu.DeleteTheme;
import ThemesMenu.WorkThemesMenu;
import WorkTeacherMenu.TeacherSupervisionInfo;
import WorkTeacherMenu.TeacherWorkingInfo;
import dao.ScientificThemeDao;
import domain.ScientificTheme;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ScientificThemeInformation extends JFrame {

	private JPanel contentPane;
	private JTextField NameField;
	private JTextField CustomerField;
	private JTextField StartField;
	private JTextField EndField;
	private JTextField CathedraIdField;


	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ScientificThemeInformation(JFrame parent) throws SQLException 
	{
		ScientificThemeDao std = new ScientificThemeDao();
		ScientificTheme st = new ScientificTheme();
		if(DepartmentMenu.theme == 0)
		{
			st = std.readTheme(TeacherWorkingInfo.id);
		}
		if(DepartmentMenu.theme == 1)
		{
			st = std.readTheme(TeacherSupervisionInfo.id);
		}
		if(DepartmentMenu.theme == 2)
		{
			st = std.readTheme(ChooseTheme.id_to_work);
		}
		if(DepartmentMenu.theme == 3)
		{
			st = std.readTheme(DeleteTheme.id_to_delete);
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 534);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblScientificThemeInformation = new JLabel("Інформація про наукову тему");
		lblScientificThemeInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblScientificThemeInformation.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblScientificThemeInformation.setBounds(0, 13, 622, 37);
		contentPane.add(lblScientificThemeInformation);
		
		JLabel lblTitle = new JLabel("назва теми");
		lblTitle.setBounds(89, 115, 76, 22);
		contentPane.add(lblTitle);
		
		JLabel lblCustomer = new JLabel("замовник");
		lblCustomer.setBounds(89, 167, 76, 22);
		contentPane.add(lblCustomer);
		
		JLabel lblStart = new JLabel("початок");
		lblStart.setBounds(89, 225, 76, 22);
		contentPane.add(lblStart);
		
		JLabel lblEnd = new JLabel("кінець");
		lblEnd.setBounds(89, 288, 76, 22);
		contentPane.add(lblEnd);
		
		JLabel lblCathedraName = new JLabel("назва кафедри");
		lblCathedraName.setBounds(89, 354, 101, 22);
		contentPane.add(lblCathedraName);
		
		NameField = new JTextField();
		NameField.setEditable(false);
		NameField.setBounds(202, 115, 350, 22);
		contentPane.add(NameField);
		NameField.setColumns(10);
		NameField.setText(st.getTitle());
		
		
		CustomerField = new JTextField();
		CustomerField.setEditable(false);
		CustomerField.setBounds(202, 167, 350, 22);
		contentPane.add(CustomerField);
		CustomerField.setColumns(10);
		CustomerField.setText(st.getCustomer());
		
		
		StartField = new JTextField();
		StartField.setEditable(false);
		StartField.setColumns(10);
		StartField.setBounds(202, 225, 350, 22);
		contentPane.add(StartField);
		StartField.setText(String.valueOf(st.getStart()));
		
		
		EndField = new JTextField();
		EndField.setEditable(false);
		EndField.setColumns(10);
		EndField.setBounds(202, 288, 350, 22);
		contentPane.add(EndField);
		WorkThemesMenu.DateToString(st.getEnd(), EndField);
		
		
		CathedraIdField = new JTextField();
		CathedraIdField.setEditable(false);
		CathedraIdField.setColumns(10);
		CathedraIdField.setBounds(202, 354, 350, 22);
		contentPane.add(CathedraIdField);
 	  	CathedraIdField.setText(std.getCathedraName(st.getId()));
		
 	  	
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				ScientificThemeInformation.this.setVisible(false);
				ScientificThemeInformation.this.dispose();
			}
		});
		btnBack.setBounds(489, 427, 97, 25);
		contentPane.add(btnBack);
	}
}
