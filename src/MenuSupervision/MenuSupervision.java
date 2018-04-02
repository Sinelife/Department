package MenuSupervision;

import DepartmentMenu.DepartmentMenu;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ThemesMenu.ChooseTheme;
import dao.ScientificThemeDao;
import dao.SupervisionDao;
import domain.ScientificTheme;
import domain.Supervision;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MenuSupervision extends JFrame {

	private JPanel contentPane;
	public static int teacher_change_or_add;
	//public static int supervisor_id;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MenuSupervision(JFrame parent) throws SQLException 
	{
		ScientificThemeDao std = new ScientificThemeDao();
		ScientificTheme st = std.readTheme(ChooseTheme.id_to_work);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Меню керівника наукової теми");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(0, 13, 610, 42);
		contentPane.add(lblNewLabel);
		
		String l = "''";
		String res = l.concat(st.getTitle()).concat(l);
		JLabel label = new JLabel(res);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label.setBounds(12, 68, 574, 42);
		contentPane.add(label);
		
		
		JButton SupervisorInfoButton = new JButton("1)Інформація про керівника");
		SupervisorInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SupervisionDao sd = new SupervisionDao();
				Supervision s = null;
				try {
					s = sd.readSupervisor(ChooseTheme.id_to_work);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				if(s == null)
				{
					JOptionPane.showMessageDialog (null, "В данної теми нема керівника!" );
				}
				else
				{
					DepartmentMenu.teacherSupervisor = 2;
					MenuSupervision.this.setVisible(false);
					try {
						new SupervisorInformation(MenuSupervision.this).setVisible(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		SupervisorInfoButton.setHorizontalAlignment(SwingConstants.LEFT);
		SupervisorInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		SupervisorInfoButton.setBounds(56, 127, 367, 36);
		contentPane.add(SupervisorInfoButton);
		
		JButton SupervisorChangeButton = new JButton("2)Змінити керівника");
		SupervisorChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (DepartmentMenu.finished_theme == 1)
				{
					JOptionPane.showMessageDialog (null, "Робота з темою завершена і вносити зміни до теми неможливо." );
				}
				else
				{
					SupervisionDao sd = new SupervisionDao();
					Supervision s = null;
					try {
						s = sd.readSupervisor(ChooseTheme.id_to_work);
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					if(s == null)
					{
						JOptionPane.showMessageDialog (null, "В данної теми нема керівника!"
								+ "Тому змінити неможна.Можна лише додати" );
					}
					else
					{
						MenuSupervision.this.setVisible(false);
						try {
							new ChangeSupervisor(MenuSupervision.this).setVisible(true);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		SupervisorChangeButton.setHorizontalAlignment(SwingConstants.LEFT);
		SupervisorChangeButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		SupervisorChangeButton.setBounds(56, 208, 367, 36);
		contentPane.add(SupervisorChangeButton);
		
		
		
		
		JButton SupervisorAddButton = new JButton("3)Додати керівника(якщо його немає)");
		SupervisorAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (DepartmentMenu.finished_theme == 1)
				{
					JOptionPane.showMessageDialog (null, "Робота з темою завершена і вносити зміни до теми неможливо." );
				}
				else
				{
					SupervisionDao sd = new SupervisionDao();
					Supervision s = null;
					try {
						s = sd.readSupervisor(ChooseTheme.id_to_work);
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					if(s != null)
					{
						JOptionPane.showMessageDialog (null, "В теми є керівник.Тому його можна змінити,але не можна додати." );
					}
					else
					{
						MenuSupervision.this.setVisible(false);
						try {
							new AddSupervisor(MenuSupervision.this).setVisible(true);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		SupervisorAddButton.setHorizontalAlignment(SwingConstants.LEFT);
		SupervisorAddButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		SupervisorAddButton.setBounds(56, 288, 367, 36);
		contentPane.add(SupervisorAddButton);
		
		
		
		JButton AllSupervisorsButton = new JButton("4)Показати всіх хто керував темою");
		AllSupervisorsButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				MenuSupervision.this.setVisible(false);
				try {
					new AllSupervisors(MenuSupervision.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		AllSupervisorsButton.setHorizontalAlignment(SwingConstants.LEFT);
		AllSupervisorsButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AllSupervisorsButton.setBounds(56, 368, 367, 36);
		contentPane.add(AllSupervisorsButton);
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				MenuSupervision.this.setVisible(false);
				MenuSupervision.this.dispose();
			}
		});
		btnBack.setBounds(489, 411, 97, 25);
		contentPane.add(btnBack);
	}
}