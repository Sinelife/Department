package MainMenu;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ScientificThemeDao;
import domain.ScientificTheme;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.awt.event.ActionEvent;

public class EditThemeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField TitleField;
	private JTextField CustomerField;
	private JTextField StartField;
	private JTextField EndField;
	private JTextField CathedraIdField;


	
	
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public EditThemeFrame(JFrame parent) throws SQLException 
	{
 	  	ScientificThemeDao std = new ScientificThemeDao();
 	  	ScientificTheme st = std.readTheme(EditTheme.id_to_edit);
 	  	
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 534);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblScientificThemeInformation = new JLabel("Редагування наукової теми");
		lblScientificThemeInformation.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblScientificThemeInformation.setBounds(171, 13, 258, 37);
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
		
		
		TitleField = new JTextField();
		TitleField.setBounds(202, 115, 350, 22);
		contentPane.add(TitleField);
		TitleField.setColumns(10);
		TitleField.setText(st.getTitle());
		
		
		CustomerField = new JTextField();
		CustomerField.setBounds(202, 167, 350, 22);
		contentPane.add(CustomerField);
		CustomerField.setColumns(10);
		CustomerField.setText(st.getCustomer());
		
		
		StartField = new JTextField();
		StartField.setColumns(10);
		StartField.setBounds(202, 225, 350, 22);
		contentPane.add(StartField);
		StartField.setText(String.valueOf(st.getStart()));
		
		
		EndField = new JTextField();
		EndField.setColumns(10);
		EndField.setBounds(202, 288, 350, 22);
		contentPane.add(EndField);
		EndField.setText(String.valueOf(st.getEnd()));
		
		
		
		
		
		JButton button = new JButton("Зберегти");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				st.setTitle(TitleField.getText());
				st.setCustomer(CustomerField.getText());
				st.setStart(Date.valueOf(StartField.getText()));
	 	  		if(EndField.getText().equals("null"))
	 	  		{
	 	  			st.setEnd(null);
	 	  		}
	 	  		else
	 	  		{
	 	  			st.setEnd(Date.valueOf(EndField.getText()));
	 	  		}
				try {
					std.updateTheme(st);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				EditThemeFrame.this.setVisible(false);
				EditThemeFrame.this.dispose();
				new MainMenu().setVisible(true);
			
			}
		});
		button.setBounds(78, 427, 113, 25);
		contentPane.add(button);
		
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				EditThemeFrame.this.setVisible(false);
				EditThemeFrame.this.dispose();
			}
		});
		btnBack.setBounds(489, 427, 97, 25);
		contentPane.add(btnBack);
	}
}
