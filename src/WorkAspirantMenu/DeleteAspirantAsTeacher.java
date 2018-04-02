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
import MenuWorking.NotWorkerTeacherInformation;
import dao.AspirantDao;
import domain.Aspirant;
import main.Methods;

public class DeleteAspirantAsTeacher extends JFrame {

	private JPanel contentPane;

	
	public static String surname_to_select;
	public static int id_to_select;
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public DeleteAspirantAsTeacher(JFrame parent) throws SQLException 
	{
		AspirantDao ad = new AspirantDao();
		List<Aspirant> aspirants = ad.getAllWhoTeachers();
 	  	
 	  	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Вибір аспіранта звільнення як викладача");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(0, 13, 553, 59);
		contentPane.add(lblNewLabel);
		
		JComboBox<String> AspirantComboBox = new JComboBox<String>();
		AspirantComboBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
		AspirantComboBox.setBounds(40, 121, 431, 34);
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
				try {
					ad.deleteAspirantAsTeacher(id_to_select);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (parent != null)
					parent.setVisible(true);
				DeleteAspirantAsTeacher.this.setVisible(false);
				DeleteAspirantAsTeacher.this.dispose();

			}
		});
		EditButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EditButton.setBounds(189, 286, 137, 34);
		contentPane.add(EditButton);

		
		
		
		
		JButton AspirantAsAspirantInfoButton = new JButton("Інформація про аспіранта");
		AspirantAsAspirantInfoButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					id_to_select = Methods.getAspirantIdBySurname(surname_to_select, id_to_select, AspirantComboBox, aspirants);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DepartmentMenu.aspirant = 6;
				DeleteAspirantAsTeacher.this.setVisible(false);
				try {
					new NotWorkerAspirantInformation(DeleteAspirantAsTeacher.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		AspirantAsAspirantInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		AspirantAsAspirantInfoButton.setBounds(40, 189, 198, 34);
		contentPane.add(AspirantAsAspirantInfoButton);
		
		
		
		JButton AspirantAsTeacherinfoButton = new JButton("Інформація про викладача");
		AspirantAsTeacherinfoButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					id_to_select = Methods.getAspirantIdBySurname(surname_to_select, id_to_select, AspirantComboBox, aspirants);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DepartmentMenu.teacher = 5;
				DeleteAspirantAsTeacher.this.setVisible(false);
				try {
					new NotWorkerTeacherInformation(DeleteAspirantAsTeacher.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		AspirantAsTeacherinfoButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		AspirantAsTeacherinfoButton.setBounds(273, 189, 198, 34);
		contentPane.add(AspirantAsTeacherinfoButton);
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				DeleteAspirantAsTeacher.this.setVisible(false);
				DeleteAspirantAsTeacher.this.dispose();
			}
		});
		btnBack.setBounds(444, 349, 97, 25);
		contentPane.add(btnBack);
	}
}
