package WorkAspirantMenu;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.DepartmentMenu;
import MenuWorking.NotWorkerAspirantInformation;
import MenuWorking.NotWorkerTeacherInformation;
import dao.AspirantDao;
import dao.TeacherDao;
import domain.Aspirant;
import domain.Teacher;
import main.Methods;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AspirantThemeRulers extends JFrame {

	private JPanel contentPane;

	public static int ruler_id;
	
	public static int a_id;

	public static List<Aspirant> aspirants = new ArrayList<Aspirant>();

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AspirantThemeRulers(JFrame parent) throws SQLException 
	{
		TeacherDao td = new TeacherDao();
		AspirantDao ad = new AspirantDao();
		List<Teacher> rulers = td.getAll();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Керівники дипломних робіт в аспірантів");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label.setBounds(0, 24, 622, 37);
		contentPane.add(label);
		
		JComboBox<String> RulerComboBox = new JComboBox<String>();
		RulerComboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		RulerComboBox.setBounds(55, 115, 318, 29);
		contentPane.add(RulerComboBox);
		for(Teacher ruler : rulers)
		{
			RulerComboBox.addItem(td.getSurname(ruler.getId()));
		}
		
		JComboBox<String> AspirantComboBox = new JComboBox<String>();
		AspirantComboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		AspirantComboBox.setBounds(55, 289, 318, 29);
		contentPane.add(AspirantComboBox);
		
		
		
		
		JButton SelectButton = new JButton("Вибрати");
		SelectButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				AspirantComboBox.removeAllItems();
				try {
					ruler_id = Methods.getTeacherIdBySurname(RulerComboBox, rulers);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					aspirants = td.getAllAspirantsWhichRulerIs(ruler_id);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				for(Aspirant aspirant : aspirants)
				{
					try {
						AspirantComboBox.addItem(ad.getSurname(aspirant.getId()));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		SelectButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SelectButton.setBounds(159, 193, 106, 29);
		contentPane.add(SelectButton);
		
		
		
		JButton RulerInfoButton = new JButton("Інформація");
		RulerInfoButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					ruler_id = Methods.getTeacherIdBySurname(RulerComboBox, rulers);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DepartmentMenu.teacher = 4;
				AspirantThemeRulers.this.setVisible(false);
				try {
					new NotWorkerTeacherInformation(AspirantThemeRulers.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		RulerInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RulerInfoButton.setBounds(395, 110, 122, 34);
		contentPane.add(RulerInfoButton);
		
		
		
		JButton AspirantInfoButton = new JButton("Інформація");
		AspirantInfoButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					a_id = Methods.getAspirantIdBySurname(AspirantComboBox, aspirants);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DepartmentMenu.aspirant = 4;
				AspirantThemeRulers.this.setVisible(false);
				try {
					new NotWorkerAspirantInformation(AspirantThemeRulers.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		AspirantInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AspirantInfoButton.setBounds(395, 284, 122, 34);
		contentPane.add(AspirantInfoButton);
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (parent != null)
					parent.setVisible(true);
				AspirantThemeRulers.this.setVisible(false);
				AspirantThemeRulers.this.dispose();
			}
		});
		btnBack.setBounds(513, 419, 97, 25);
		contentPane.add(btnBack);
		
	}

}
