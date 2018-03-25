package MainMenu;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MenuTheme.ScientificThemeInformation;
import MenuTheme.ThemeMenu;
import dao.ScientificThemeDao;
import domain.ScientificTheme;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ChooseTheme extends JFrame {

	private JPanel contentPane;
	public static String title_to_work;
	public static int id_to_work;
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ChooseTheme(JFrame parent) throws SQLException 
	{
		/*String sql_list = "select scientific_theme_id,title from scientifictheme";
 	  	Statement statement_list = MainMenu.conn.createStatement();
 	  	ResultSet rs = statement_list.executeQuery(sql_list);
 	  	String titles[] = new String[100];
 	  	int ids[] = new int[100];
 	  	int i = 0;
 	  	while(rs.next())
 	  	{
 	  		titles[i] = rs.getString("title");
 	  		ids[i] = rs.getInt("scientific_theme_id");
 	  		i++;
 	  	}*/
		
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
		
		
		JLabel lblNewLabel = new JLabel("Меню вибору теми");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(63, 25, 272, 59);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				ChooseTheme.this.setVisible(false);
				ChooseTheme.this.dispose();
			}
		});
		btnBack.setBounds(489, 427, 97, 25);
		contentPane.add(btnBack);
		
		
		JButton ChooseButton = new JButton("Вибрати");
		ChooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				title_to_work = String.valueOf(comboBox.getSelectedItem());
				int k = 0;
				while(true)
				{
					
					id_to_work = _ids[k];
					if((_titles[k]).equals(title_to_work))
					{
						break;
					}
					k++;
				}
				ChooseTheme.this.setVisible(false);
				new ThemeMenu(ChooseTheme.this).setVisible(true);
			}
		});
		ChooseButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ChooseButton.setBounds(40, 418, 104, 34);
		contentPane.add(ChooseButton);
			
	}
}
