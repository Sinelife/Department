package WorkAspirantMenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.DepartmentMenu;
import MenuWorking.NotWorkerAspirantInformation;
import dao.AspirantDao;
import domain.Aspirant;
import main.Methods;

public class AddAspirantAsTeacher extends JFrame {

	private JPanel contentPane;

	public static String surname_to_select;
	public static int id_to_select;
	
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddAspirantAsTeacher(JFrame parent) throws SQLException 
	{
		AspirantDao ad = new AspirantDao();
		List<Aspirant> aspirants = ad.getAllWhoNotTeachers();
 	  	
 	  	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Вибір аспіранта для назначення викладачем");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(0, 13, 605, 59);
		contentPane.add(lblNewLabel);
		
		JComboBox<String> AspirantComboBox = new JComboBox<String>();
		AspirantComboBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
		AspirantComboBox.setBounds(22, 121, 428, 34);
		contentPane.add(AspirantComboBox);
		for(Aspirant aspirant : aspirants)
		{
			AspirantComboBox.addItem(ad.getSurname(aspirant.getId()));
		}
		
		
		
		
		
		JButton EditButton = new JButton("Вибрати");
		EditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					id_to_select = Methods.getAspirantIdBySurname(surname_to_select, id_to_select, AspirantComboBox, aspirants);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				AddAspirantAsTeacher.this.setVisible(false);
				try {
					new AddAspirantAsTeacherFrame(AddAspirantAsTeacher.this).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		EditButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EditButton.setBounds(206, 200, 137, 34);
		contentPane.add(EditButton);

	
		
		JButton button = new JButton("Інформація");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					id_to_select = Methods.getAspirantIdBySurname(surname_to_select, id_to_select, AspirantComboBox, aspirants);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DepartmentMenu.aspirant = 7;
				AddAspirantAsTeacher.this.setVisible(false);
				try {
					new NotWorkerAspirantInformation(AddAspirantAsTeacher.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(462, 121, 120, 34);
		contentPane.add(button);
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				AddAspirantAsTeacher.this.setVisible(false);
				AddAspirantAsTeacher.this.dispose();
			}
		});
		btnBack.setBounds(485, 268, 97, 25);
		contentPane.add(btnBack);
	}
}
