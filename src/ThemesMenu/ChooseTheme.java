package ThemesMenu;
import javax.swing.JFrame;
import DepartmentMenu.DepartmentMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.ChooseCathedra;
import MenuTheme.ThemeMenu;
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
import javax.swing.SwingConstants;

public class ChooseTheme extends JFrame {

	private JPanel contentPane;

	public static int id_to_work;
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ChooseTheme(JFrame parent) throws SQLException 
	{
		setResizable(false);	
		ScientificThemeDao std = new ScientificThemeDao();
		List<ScientificTheme> themes = std.getAllInCathedra(ChooseCathedra.cathedra_id_to_work);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Меню вибору теми");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(0, 25, 628, 59);
		contentPane.add(lblNewLabel);
		
		
		JComboBox<String> ThemeComboBox = new JComboBox<String>();
		ThemeComboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ThemeComboBox.setBounds(12, 121, 652, 34);
		contentPane.add(ThemeComboBox);
		for(ScientificTheme theme : themes)
		{
			ThemeComboBox.addItem(theme.getTitle());
		}
		

		
		
		JButton ChooseButton = new JButton("Вибрати");
		ChooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				id_to_work = Methods.getThemeIdByThemeTitle(ThemeComboBox, themes);
				ChooseTheme.this.setVisible(false);
				try {
					new ThemeMenu(ChooseTheme.this).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		ChooseButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ChooseButton.setBounds(232, 187, 104, 34);
		contentPane.add(ChooseButton);
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				ChooseTheme.this.setVisible(false);
				ChooseTheme.this.dispose();
			}
		});
		btnBack.setBounds(567, 272, 97, 25);
		contentPane.add(btnBack);
			
	}
}
