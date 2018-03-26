package ThemesMenu;

import DepartmentMenu.DepartmentMenu;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.ChooseCathedra;
import MenuTheme.ScientificThemeInformation;
import dao.ScientificThemeDao;
import domain.ScientificTheme;
import main.Methods;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
		List<ScientificTheme> themes = std.getAllInCathedra(ChooseCathedra.cathedra_id_to_work);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(39, 107, 439, 34);
		contentPane.add(comboBox);
		for(ScientificTheme theme : themes)
		{
			comboBox.addItem(theme.getTitle());
		}
		
		
		JLabel lblNewLabel = new JLabel("Видалення теми");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(29, 25, 514, 59);
		contentPane.add(lblNewLabel);
		
		
		
		
		JButton deleteButton = new JButton("Видалити");
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				id_to_delete = Methods.getThemeIdByThemeTitle(title_to_delete, id_to_delete, comboBox, themes);
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
				id_to_delete = Methods.getThemeIdByThemeTitle(title_to_delete, id_to_delete, comboBox, themes);
				DepartmentMenu.theme = 3;
				DeleteTheme.this.setVisible(false);
				try {
					new ScientificThemeInformation(DeleteTheme.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		InfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		InfoButton.setBounds(490, 107, 122, 34);
		contentPane.add(InfoButton);
		
		
		
		
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
		

	}
}
