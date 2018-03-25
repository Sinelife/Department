package MenuWorking;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainMenu.ChooseTheme;
import dao.AspirantDao;
import dao.MagisterDao;
import dao.TeacherDao;
import domain.Aspirant;
import domain.Magister;
import domain.Teacher;
import main.Methods;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class WorkersList extends JFrame {

	private JPanel contentPane;
	public static String worker_surname_to_look;
	public static int worker_id_to_look;

	public static int check;
	
	/**
	 * Create the frame.
	 * @throws SQLException
	 */
	public WorkersList(JFrame parent) throws SQLException 
	{
		MagisterDao md = new MagisterDao();
		AspirantDao ad = new AspirantDao();
		TeacherDao td = new TeacherDao();
		List<Magister> magisters = md.getAllFromTheme(ChooseTheme.id_to_work);
		List<Aspirant> aspirants = ad.getAllFromTheme(ChooseTheme.id_to_work);
		List<Teacher> teachers = td.getAllFromTheme(ChooseTheme.id_to_work);
		List<String> list = new ArrayList<String>();
 	  	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Список науковців,що працюють над темою");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(27, 13, 543, 42);
		contentPane.add(lblNewLabel);
		
		
		JComboBox<String> WorkersComboBox = new JComboBox<String>();
		WorkersComboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		WorkersComboBox.setBounds(38, 119, 409, 34);
		contentPane.add(WorkersComboBox);
		for(Magister magister : magisters)
		{
			String elem = md.getSurname(magister.getId()).concat("(Магістр)");
			WorkersComboBox.addItem(elem);
			list.add(elem);
		}
		for(Aspirant aspirant : aspirants)
		{
			String elem = ad.getSurname(aspirant.getId()).concat("(Аспірант)");
			WorkersComboBox.addItem(elem);
			list.add(elem);
		}		
		for(Teacher teacher : teachers)
		{
			String elem = td.getSurname(teacher.getId()).concat("(Викладач)");
			WorkersComboBox.addItem(elem);
			list.add(elem);
		}
		

		
		JButton WorkerInfoButton = new JButton("Інформація");
		WorkerInfoButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				worker_surname_to_look = String.valueOf(WorkersComboBox.getSelectedItem());
				try {
					check = Methods.infoDesition(worker_id_to_look, worker_surname_to_look, WorkersComboBox);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
				try {
					worker_id_to_look = Methods.infoDecitionId(worker_id_to_look, worker_surname_to_look, WorkersComboBox);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
				if(check == 3)
				{
					WorkersList.this.setVisible(false);
					try {
						new WorkerTeacherInformation(WorkersList.this).setVisible(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else if(check == 2)
				{
					WorkersList.this.setVisible(false);
					try {
						new WorkerAspirantInformation(WorkersList.this).setVisible(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else if(check == 1)
				{
					WorkersList.this.setVisible(false);
					try {
						new WorkerMagisterInformation(WorkersList.this).setVisible(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		WorkerInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		WorkerInfoButton.setBounds(459, 119, 127, 34);
		contentPane.add(WorkerInfoButton);
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				WorkersList.this.setVisible(false);
				WorkersList.this.dispose();
			}
		});
		btnBack.setBounds(489, 297, 97, 25);
		contentPane.add(btnBack);
	}
}
