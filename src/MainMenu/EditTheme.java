package MainMenu;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MenuTheme.ScientificThemeInformation;
import dao.ScientificThemeDao;
import domain.ScientificTheme;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import java.awt.SystemColor;

public class EditTheme extends JFrame {

	private JPanel contentPane;
	public static String title_to_edit;
	public static int id_to_edit;



	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public EditTheme(JFrame parent) throws SQLException 
	{
		ScientificThemeDao std = new ScientificThemeDao();
		List<ScientificTheme> themes = std.getAll();
		String[] _titles = new String[100];
		int[] _ids = new int[100];
		int i = 0;
		for(ScientificTheme theme : themes)
		{
			_titles[i] = theme.getTitle();
			_ids[i] = theme.getId();
			i++;
		}
 	  	
 	  	
 	  	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JComboBox comboBox = new JComboBox(_titles);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		comboBox.setBounds(40, 121, 504, 34);
		contentPane.add(comboBox);
		
		
		JLabel lblNewLabel = new JLabel("Меню вибору теми для редагування");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(46, 25, 484, 59);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				EditTheme.this.setVisible(false);
				EditTheme.this.dispose();
			}
		});
		btnBack.setBounds(489, 427, 97, 25);
		contentPane.add(btnBack);
		
		
		JButton EditButton = new JButton("Редагувати");
		EditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				title_to_edit = String.valueOf(comboBox.getSelectedItem());
				System.out.println(title_to_edit);
				int k = 0;
				while(true)
				{
					
					id_to_edit = _ids[k];
					if((_titles[k]).equals(title_to_edit))
					{
						break;
					}
					k++;
				}
				EditTheme.this.setVisible(false);
				try {
					new EditThemeFrame(EditTheme.this).setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		EditButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EditButton.setBounds(40, 421, 137, 34);
		contentPane.add(EditButton);

	}
}
