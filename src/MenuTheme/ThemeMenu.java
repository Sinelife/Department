package MenuTheme;

import java.awt.Font;
import DepartmentMenu.DepartmentMenu;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MenuSupervision.MenuSupervision;
import MenuWorking.MenuWorking;
import ThemesMenu.ChooseTheme;
import dao.ScientificThemeDao;
import dao.SupervisionDao;
import domain.ScientificTheme;
import domain.Supervision;
import main.Methods;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ThemeMenu extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ThemeMenu(JFrame parent) throws SQLException 
	{
		ScientificThemeDao std = new ScientificThemeDao();
		ScientificTheme st = std.readTheme(ChooseTheme.id_to_work);
		SupervisionDao sd = new SupervisionDao();
		Supervision s = sd.readSupervisor(ChooseTheme.id_to_work);
		
		if(st.getEnd() == null)
		{
			System.out.println("NOT FINISHED");
			DepartmentMenu.finished_theme = 0;
		}
		else
		{
			JOptionPane.showMessageDialog (null, "Робота з темою завершена і вносити зміни до теми неможливо." );
			System.out.println("FINISHED");
			DepartmentMenu.finished_theme = 1;
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Меню роботи з темою");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(0, 13, 645, 42);
		contentPane.add(lblNewLabel);
		
		String l = "''";
		String res = l.concat(st.getTitle()).concat(l);
		JLabel label = new JLabel(res);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(0, 69, 645, 42);
		contentPane.add(label);
		
		
		JButton button1 = new JButton("1)Інформація про тему");
		button1.setHorizontalAlignment(SwingConstants.LEFT);
		button1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				DepartmentMenu.theme = 2;
				ThemeMenu.this.setVisible(false);
				try {
					new ScientificThemeInformation(ThemeMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		button1.setBounds(148, 154, 328, 36);
		contentPane.add(button1);
		
		JButton button2 = new JButton("2)Меню керівника");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ThemeMenu.this.setVisible(false);
				try {
					new MenuSupervision(ThemeMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		button2.setHorizontalAlignment(SwingConstants.LEFT);
		button2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button2.setBounds(148, 227, 328, 36);
		contentPane.add(button2);
		
		JButton button3 = new JButton("3)Меню науковців");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemeMenu.this.setVisible(false);
				try {
					new MenuWorking(ThemeMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		button3.setHorizontalAlignment(SwingConstants.LEFT);
		button3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button3.setBounds(148, 303, 328, 36);
		contentPane.add(button3);
	
		
		JButton button = new JButton("4)Закінчити роботу над темою");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String date = Methods.getCurrentDate();
				st.setEnd(Date.valueOf(date)); 
				try {
					std.finishTheme(st);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button.setBounds(148, 378, 328, 36);
		contentPane.add(button);
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (parent != null)
					parent.setVisible(true);
				ThemeMenu.this.setVisible(false);
				ThemeMenu.this.dispose();

			}
		});
		btnBack.setBounds(513, 461, 97, 25);
		contentPane.add(btnBack);
	}
}
