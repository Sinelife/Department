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
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class DeleteTheme extends JFrame {

	private JPanel contentPane;
	public static String title_to_delete;
	public static int id_to_delete;
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public DeleteTheme(JFrame parent) throws SQLException 
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
		comboBox.setBounds(39, 107, 439, 34);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Видалення теми");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(29, 25, 514, 59);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				DeleteTheme.this.setVisible(false);
				DeleteTheme.this.dispose();
			}
		});
		btnBack.setBounds(489, 427, 97, 25);
		contentPane.add(btnBack);
		
		
		
		
		JButton deleteButton = new JButton("Видалити");
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				title_to_delete = String.valueOf(comboBox.getSelectedItem());
				int k = 0;
				while(true)
				{
					
					id_to_delete = _ids[k];
					if((_titles[k]).equals(title_to_delete))
					{
						break;
					}
					k++;
				}
				ScientificTheme d = new ScientificTheme();
				for(ScientificTheme theme : themes)
				{
					if(theme.getId() == id_to_delete)
					{
						d = theme;
						break;
					}
				}
				try {
					std.deleteTheme(d);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				if (parent != null)
					parent.setVisible(true);
				DeleteTheme.this.setVisible(false);
				DeleteTheme.this.dispose();
			}
		});
		deleteButton.setBounds(39, 421, 109, 34);
		contentPane.add(deleteButton);
		
		
		
		
		JButton InfoButton = new JButton("Іноформація");
		InfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				title_to_delete = String.valueOf(comboBox.getSelectedItem());
				int k = 0;
				while(true)
				{
					
					id_to_delete = _ids[k];
					if((_titles[k]).equals(title_to_delete))
					{
						break;
					}
					k++;
				}
				MainMenu.theme_information = 1;
				DeleteTheme.this.setVisible(false);
				try {
					new ScientificThemeInformation(DeleteTheme.this).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		InfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		InfoButton.setBounds(490, 107, 122, 34);
		contentPane.add(InfoButton);
		

	}
}
