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

import DepartmentMenu.ChooseCathedra;
import WorkAspirantMenu.EditAspirant;
import WorkAspirantMenu.EditAspirantFrame;
import dao.AspirantDao;
import domain.Aspirant;
import main.Methods;

public class EditAspirant extends JFrame {

	private JPanel contentPane;
	
	public static int id_to_edit;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public EditAspirant(JFrame parent) throws SQLException 
	{
		setResizable(false);
		AspirantDao ad = new AspirantDao();
		List<Aspirant> aspirants = ad.getAllFromCathedra(ChooseCathedra.cathedra_id_to_work);
 	  	
 	  	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Вибір аспіранта для редагування");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(0, 13, 628, 59);
		contentPane.add(lblNewLabel);
		
		JComboBox<String> AspirantComboBox = new JComboBox<String>();
		AspirantComboBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
		AspirantComboBox.setBounds(40, 121, 504, 34);
		contentPane.add(AspirantComboBox);
		for(Aspirant aspirant : aspirants)
		{
			AspirantComboBox.addItem(ad.getSurname(aspirant.getId()));
		}
		
		
		
		
		
		JButton EditButton = new JButton("Редагувати");
		EditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					id_to_edit = Methods.getAspirantIdBySurname(AspirantComboBox, aspirants);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				EditAspirant.this.setVisible(false);
				try {
					new EditAspirantFrame(EditAspirant.this).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		EditButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EditButton.setBounds(206, 200, 137, 34);
		contentPane.add(EditButton);

		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				EditAspirant.this.setVisible(false);
				EditAspirant.this.dispose();
			}
		});
		btnBack.setBounds(485, 268, 97, 25);
		contentPane.add(btnBack);
	}

}
