package DepartmentMenu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ThemesMenu.WorkThemesMenu;
import WorkAspirantMenu.WorkAspirantMenu;
import WorkTeacherMenu.WorkTeacherMenu;
import dao.CathedraDao;
import domain.Cathedra;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CathedraMenu extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CathedraMenu() throws SQLException 
	{
		setResizable(false);
		CathedraDao cd = new CathedraDao();
		Cathedra c = cd.readCathedra(ChooseCathedra.cathedra_id_to_work);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Меню кафедри");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 27));
		label.setBounds(0, 13, 571, 42);
		contentPane.add(label);
		
		String l = "''";
		String res = l.concat(c.getName()).concat(l);
		JLabel label1 = new JLabel(res);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label1.setBounds(0, 68, 571, 42);
		contentPane.add(label1);
		
		
		JButton CathedraPeopleInfoButton = new JButton("1)Перегляд людей на кафедрі");
		CathedraPeopleInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				CathedraMenu.this.setVisible(false);
				try {
					new CathedraPeopleInfo(CathedraMenu.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		CathedraPeopleInfoButton.setForeground(Color.BLACK);
		CathedraPeopleInfoButton.setHorizontalAlignment(SwingConstants.LEFT);
		CathedraPeopleInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		CathedraPeopleInfoButton.setBounds(37, 129, 487, 42);
		contentPane.add(CathedraPeopleInfoButton);
		
		
		JButton WorkTeacherMenuButton = new JButton("2)Меню роботи з викладачами");
		WorkTeacherMenuButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CathedraMenu.this.setVisible(false);
				new WorkTeacherMenu().setVisible(true);
			}
		});
		WorkTeacherMenuButton.setForeground(Color.BLACK);
		WorkTeacherMenuButton.setHorizontalAlignment(SwingConstants.LEFT);
		WorkTeacherMenuButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		WorkTeacherMenuButton.setBounds(37, 209, 487, 42);
		contentPane.add(WorkTeacherMenuButton);
		
		
		JButton WorkThemesMenuButton = new JButton("4)Меню роботи з науковими темами");
		WorkThemesMenuButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CathedraMenu.this.setVisible(false);
				try {
					new WorkThemesMenu().setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		WorkThemesMenuButton.setForeground(Color.BLACK);
		WorkThemesMenuButton.setHorizontalAlignment(SwingConstants.LEFT);
		WorkThemesMenuButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		WorkThemesMenuButton.setBounds(37, 377, 487, 42);
		contentPane.add(WorkThemesMenuButton);
		
		
		JButton WorkAspirantMenuButton = new JButton("3)Меню роботи з аспірантами");
		WorkAspirantMenuButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CathedraMenu.this.setVisible(false);
				new WorkAspirantMenu().setVisible(true);
			}
		});
		WorkAspirantMenuButton.setHorizontalAlignment(SwingConstants.LEFT);
		WorkAspirantMenuButton.setForeground(Color.BLACK);
		WorkAspirantMenuButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		WorkAspirantMenuButton.setBounds(37, 295, 487, 42);
		contentPane.add(WorkAspirantMenuButton);
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CathedraMenu.this.setVisible(false);
				CathedraMenu.this.dispose();
				try {
					new ChooseCathedra(new DepartmentMenu()).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBack.setBounds(474, 445, 97, 25);
		contentPane.add(btnBack);
	}

}
