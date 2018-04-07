package WorkAspirantMenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.ChooseCathedra;
import DepartmentMenu.DepartmentMenu;
import MenuWorking.NotWorkerAspirantInformation;
import dao.AspirantDao;
import domain.Aspirant;
import domain.ScientificWork;
import main.Methods;

public class ScientificWorkOfAspirant extends JFrame {

	private JPanel contentPane;
	
	public static int aspirant_id;
	
	public static int work_id;

	public static List<ScientificWork> works = new ArrayList<ScientificWork>();



	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ScientificWorkOfAspirant(JFrame parent) throws SQLException 
	{
		AspirantDao ad = new AspirantDao();
		List<Aspirant> aspirants = ad.getAllFromCathedra(ChooseCathedra.cathedra_id_to_work);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Наукові праці аспірантів");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label.setBounds(0, 24, 622, 37);
		contentPane.add(label);
		
		
		JComboBox<String> AspirantComboBox = new JComboBox<String>();
		AspirantComboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		AspirantComboBox.setBounds(55, 115, 318, 29);
		contentPane.add(AspirantComboBox);
		for(Aspirant aspirant : aspirants)
		{
			AspirantComboBox.addItem(ad.getSurname(aspirant.getId()));
		}
		
		
		JComboBox<String> ScientificWorkComboBox = new JComboBox<String>();
		ScientificWorkComboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ScientificWorkComboBox.setBounds(55, 289, 318, 29);
		contentPane.add(ScientificWorkComboBox);
		
		
		
		
		JButton SelectButton = new JButton("Вибрати");
		SelectButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				ScientificWorkComboBox.removeAllItems();
				try {
					aspirant_id = Methods.getAspirantIdBySurname(AspirantComboBox, aspirants);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					works = ad.getAllAspirantWorks(aspirant_id);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				for(ScientificWork work : works)
				{
					ScientificWorkComboBox.addItem(work.getTitle());
				}
			}
		});
		SelectButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SelectButton.setBounds(159, 193, 106, 29);
		contentPane.add(SelectButton);
		
		
		
		JButton AspirantInfoButton = new JButton("Інформація");
		AspirantInfoButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					aspirant_id = Methods.getAspirantIdBySurname(AspirantComboBox, aspirants);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DepartmentMenu.aspirant = 5;
				ScientificWorkOfAspirant.this.setVisible(false);
				try {
					new NotWorkerAspirantInformation(ScientificWorkOfAspirant.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		AspirantInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AspirantInfoButton.setBounds(395, 110, 122, 34);
		contentPane.add(AspirantInfoButton);
		
		
		
		
		JButton ScientificWorkInfoButton = new JButton("Інформація");
		ScientificWorkInfoButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				work_id = Methods.getWorkIdByWorkTitle(ScientificWorkComboBox, works);
				ScientificWorkOfAspirant.this.setVisible(false);
				try {
					new ScientificWorkInformation(ScientificWorkOfAspirant.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		ScientificWorkInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ScientificWorkInfoButton.setBounds(395, 284, 122, 34);
		contentPane.add(ScientificWorkInfoButton);
		
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (parent != null)
					parent.setVisible(true);
				ScientificWorkOfAspirant.this.setVisible(false);
				ScientificWorkOfAspirant.this.dispose();
			}
		});
		btnBack.setBounds(513, 419, 97, 25);
		contentPane.add(btnBack);
		
	}
}
