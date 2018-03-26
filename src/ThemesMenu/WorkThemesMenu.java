package ThemesMenu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.CathedraMenu;
import DepartmentMenu.ChooseCathedra;
import MenuTheme.ThemeMenu;
import dao.CathedraDao;
import domain.Cathedra;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;

import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Color; 

public class WorkThemesMenu extends JFrame {

	static JFrame mainframe;
	private JPanel contentPane;
	public static int theme_information;
	
	
	
	public static void DateToString(Date d,JTextField t)
	{
		String res = null;
		if(d == null)
		{
			res = "";
			t.setText(res);
		}
		else
		{
			t.setText(String.valueOf(d));
		}
	}
	




	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public WorkThemesMenu() throws SQLException 
	{
		CathedraDao cd = new CathedraDao();
		Cathedra c = cd.readCathedra(ChooseCathedra.cathedra_id_to_work);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 628, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Меню роботи з темами кафедри");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(0, 13, 610, 64);
		contentPane.add(lblNewLabel);
		
		String l = "''";
		String res = l.concat(c.getName()).concat(l);
		JLabel label1 = new JLabel(res);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label1.setBounds(0, 82, 610, 42);
		contentPane.add(label1);
		
		
		JButton ChooseThemeButton = new JButton("1)Обрати тему");
		ChooseThemeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkThemesMenu.this.setVisible(false);
				try {
					new ChooseTheme(WorkThemesMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
			}
		});
		ChooseThemeButton.setHorizontalAlignment(SwingConstants.LEFT);
		ChooseThemeButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ChooseThemeButton.setBounds(185, 141, 226, 42);
		contentPane.add(ChooseThemeButton);
		
		JButton AddThemeButton = new JButton("2)Додати тему");
		AddThemeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkThemesMenu.this.setVisible(false);
				try {
					new AddTheme(WorkThemesMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
			}
		});
		AddThemeButton.setHorizontalAlignment(SwingConstants.LEFT);
		AddThemeButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AddThemeButton.setBounds(185, 218, 226, 42);
		contentPane.add(AddThemeButton);
		
		JButton DeleteThemeButton = new JButton("3)Видалити тему");
		DeleteThemeButton.setForeground(Color.DARK_GRAY);
		DeleteThemeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkThemesMenu.this.setVisible(false);
				try {
					new DeleteTheme(WorkThemesMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
			}
		});
		DeleteThemeButton.setHorizontalAlignment(SwingConstants.LEFT);
		DeleteThemeButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		DeleteThemeButton.setBounds(185, 293, 226, 42);
		contentPane.add(DeleteThemeButton);
		
		JButton EditThemeButton = new JButton("4)Редагувати тему");
		EditThemeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkThemesMenu.this.setVisible(false);
				try {
					new EditTheme(WorkThemesMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
			}
		});
		EditThemeButton.setHorizontalAlignment(SwingConstants.LEFT);
		EditThemeButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		EditThemeButton.setBounds(185, 371, 226, 42);
		contentPane.add(EditThemeButton);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				WorkThemesMenu.this.setVisible(false);
				WorkThemesMenu.this.dispose();	
				try {
					new CathedraMenu().setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(501, 451, 97, 25);
		contentPane.add(button);
	}
}
