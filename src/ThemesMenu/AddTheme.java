package ThemesMenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.ChooseCathedra;
import dao.CathedraDao;
import domain.Cathedra;
import main.Methods;

public class AddTheme extends JFrame {

	private JPanel contentPane;
	private JTextField TitleField;
	private JTextField CustomerField;
	private JTextField StartField;
	
	public static String cathedra_name;
	public static int cathedra_id;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddTheme(JFrame parent) throws SQLException 
	{ 	  	
		CathedraDao cd = new CathedraDao();
		Cathedra c = cd.readCathedra(ChooseCathedra.cathedra_id_to_work);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Додавання теми");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(202, 24, 272, 59);
		contentPane.add(lblNewLabel);
		
		JLabel lblTitle = new JLabel("назва теми");
		lblTitle.setBounds(89, 115, 76, 22);
		contentPane.add(lblTitle);
		
		JLabel lblCustomer = new JLabel("замовник");
		lblCustomer.setBounds(89, 167, 76, 22);
		contentPane.add(lblCustomer);
		
		JLabel lblStart = new JLabel("початок");
		lblStart.setBounds(89, 225, 76, 22);
		contentPane.add(lblStart);
		
		TitleField = new JTextField();
		TitleField.setBounds(202, 115, 350, 22);
		contentPane.add(TitleField);
		TitleField.setColumns(10);
		
		CustomerField = new JTextField();
		CustomerField.setBounds(202, 167, 350, 22);
		contentPane.add(CustomerField);
		CustomerField.setColumns(10);
		
		StartField = new JTextField();
		StartField.setColumns(10);
		StartField.setBounds(202, 225, 350, 22);
		contentPane.add(StartField);

		
		JButton btnL = new JButton("Додати");
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Methods.addTheme(ChooseCathedra.cathedra_id_to_work, TitleField, CustomerField, StartField);
				if (parent != null)
					parent.setVisible(true);
				AddTheme.this.setVisible(false);
				AddTheme.this.dispose();
			}
		});
		btnL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnL.setBounds(76, 300, 108, 32);
		contentPane.add(btnL);
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				AddTheme.this.setVisible(false);
				AddTheme.this.dispose();
			}
		});
		btnBack.setBounds(493, 305, 97, 25);
		contentPane.add(btnBack);
	}
}
