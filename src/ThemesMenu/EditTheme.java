package ThemesMenu;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.ChooseCathedra;
import dao.ScientificThemeDao;
import domain.ScientificTheme;
import main.Methods;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

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
		List<ScientificTheme> themes = std.getAllInCathedra(ChooseCathedra.cathedra_id_to_work);
 	  	
 	  	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JComboBox<String> ThemeComboBox = new JComboBox<String>();
		ThemeComboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ThemeComboBox.setBounds(40, 121, 504, 34);
		contentPane.add(ThemeComboBox);
		for(ScientificTheme theme : themes)
		{
			ThemeComboBox.addItem(theme.getTitle());
		}
		
		
		
		JLabel lblNewLabel = new JLabel("Вибір теми для редагування");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(0, 13, 628, 59);
		contentPane.add(lblNewLabel);
		

		
		
		JButton EditButton = new JButton("Редагувати");
		EditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				id_to_edit = Methods.getThemeIdByThemeTitle(title_to_edit, id_to_edit, ThemeComboBox, themes);
				EditTheme.this.setVisible(false);
				try {
					new EditThemeFrame(EditTheme.this).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		EditButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EditButton.setBounds(206, 200, 137, 34);
		contentPane.add(EditButton);

		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				EditTheme.this.setVisible(false);
				EditTheme.this.dispose();
			}
		});
		btnBack.setBounds(485, 268, 97, 25);
		contentPane.add(btnBack);
	}
}
