package MenuWorking;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.DepartmentMenu;
import ThemesMenu.ChooseTheme;
import dao.ScientificThemeDao;
import domain.ScientificTheme;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class MenuWorking extends JFrame {

	private JPanel contentPane;

	/** 
	 * Create the frame .
	 * @throws SQLException 
	 */
	public MenuWorking(JFrame parent) throws SQLException 
	{
		ScientificThemeDao std = new ScientificThemeDao();
		ScientificTheme st = std.readTheme(ChooseTheme.id_to_work);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Меню науковців наукової теми");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(83, 13, 415, 42);
		contentPane.add(lblNewLabel);
		
		String l = "''";
		String res = l.concat(st.getTitle()).concat(l);
		JLabel label = new JLabel(res);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label.setBounds(12, 68, 574, 42);
		contentPane.add(label);
		
		
		JButton WorkersListButton = new JButton("1)Переглянути список науковців");
		WorkersListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuWorking.this.setVisible(false);
				try {
					new WorkersList(MenuWorking.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		WorkersListButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		WorkersListButton.setHorizontalAlignment(SwingConstants.LEFT);
		WorkersListButton.setBounds(56, 135, 442, 42);
		contentPane.add(WorkersListButton);
		
		
		JButton AddWorkerButton = new JButton("2)Додати нового науковця до теми");
		AddWorkerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (DepartmentMenu.finished_theme == 1)
				{
					JOptionPane.showMessageDialog (null, "Робота з темою завершена і вносити зміни до теми неможливо." );
				}
				else
				{
					MenuWorking.this.setVisible(false);
					new AddWorker(MenuWorking.this).setVisible(true);
				}
			}
		});
		AddWorkerButton.setHorizontalAlignment(SwingConstants.LEFT);
		AddWorkerButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AddWorkerButton.setBounds(56, 215, 442, 42);
		contentPane.add(AddWorkerButton);
		
		
		JButton DeleteWorkerButton = new JButton("3)Видалити науковця з теми");
		DeleteWorkerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (DepartmentMenu.finished_theme == 1)
				{
					JOptionPane.showMessageDialog (null, "Робота з темою завершена і вносити зміни до теми неможливо." );
				}
				else
				{
					MenuWorking.this.setVisible(false);
					try {
						new DeleteWorker(MenuWorking.this).setVisible(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		DeleteWorkerButton.setHorizontalAlignment(SwingConstants.LEFT);
		DeleteWorkerButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		DeleteWorkerButton.setBounds(56, 301, 442, 42);
		contentPane.add(DeleteWorkerButton);
		
		
		JButton AddWorkerTeacherButton = new JButton("4)Залучити викладача");
		AddWorkerTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (DepartmentMenu.finished_theme == 1)
				{
					JOptionPane.showMessageDialog (null, "Робота з темою завершена і вносити зміни до теми неможливо." );
				}
				else
				{
					MenuWorking.this.setVisible(false);
					try {
						new AddWorkerTeacher(MenuWorking.this).setVisible(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		AddWorkerTeacherButton.setHorizontalAlignment(SwingConstants.LEFT);
		AddWorkerTeacherButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AddWorkerTeacherButton.setBounds(56, 383, 442, 42);
		contentPane.add(AddWorkerTeacherButton);
		
		
		JButton button = new JButton("5)Редагувати інформацію про роботи науковців");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (DepartmentMenu.finished_theme == 1)
				{
					JOptionPane.showMessageDialog (null, "Робота з темою завершена і вносити зміни до теми неможливо." );
				}
				else
				{
					MenuWorking.this.setVisible(false);
					try {
						new EditWorkerInformation(MenuWorking.this).setVisible(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		button.setForeground(Color.BLACK);
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button.setBounds(56, 464, 442, 42);
		contentPane.add(button);
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				MenuWorking.this.setVisible(false);
				MenuWorking.this.dispose();
			}
		});
		btnBack.setBounds(517, 541, 97, 25);
		contentPane.add(btnBack);
	}
}