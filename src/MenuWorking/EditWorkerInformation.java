package MenuWorking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainMenu.ChooseTheme;
import MainMenu.MainMenu;
import MenuTheme.ThemeMenu;

import javax.swing.JComboBox;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditWorkerInformation extends JFrame {

	private JPanel contentPane;
	public static String surname_to_edit;
	public static int id_to_edit;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public EditWorkerInformation(JFrame parent) throws SQLException 
	{
		String sql_listofworkers = "select scientist_id,surname from scientist where scientist_id in (select scientist_id from working where scientific_theme_id = " + ChooseTheme.id_to_work + ")";
		Statement statement = MainMenu.conn.createStatement();
		ResultSet rs = statement.executeQuery(sql_listofworkers);
 	  	String workers[] = new String[100];
 	  	int ids[] = new int[100];
 	  	int i = 0;
 	  	while(rs.next())
 	  	{
 	  		workers[i] = rs.getString("surname");
 	  		ids[i] = rs.getInt("scientist_id");
 	  		i++;
 	  	}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox(workers);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		comboBox.setBounds(12, 107, 475, 34);
		contentPane.add(comboBox);
		
		JLabel label = new JLabel("Вибір науковця для редагування інформації");
		label.setFont(new Font("Tahoma", Font.PLAIN, 27));
		label.setBounds(0, 31, 570, 42);
		contentPane.add(label);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
				{
					if (parent != null)
						parent.setVisible(true);
					EditWorkerInformation.this.setVisible(false);
					EditWorkerInformation.this.dispose();
				}
		});
		button.setBounds(461, 414, 97, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Вибрати");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				surname_to_edit = String.valueOf(comboBox.getSelectedItem());
				int k = 0;
				while(true)
				{
					
					id_to_edit = ids[k];
					if((workers[k]).equals(surname_to_edit))
					{
						break;
					}
					k++;
				}
				EditWorkerInformation.this.setVisible(false);
				try {
					new EditWorkerInformationFrame(EditWorkerInformation.this).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_1.setBounds(12, 397, 97, 34);
		contentPane.add(button_1);
		
	}
}
