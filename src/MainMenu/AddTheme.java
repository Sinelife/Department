package MainMenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.CathedraDao;
import domain.Cathedra;
import main.Methods;

import javax.swing.JComboBox;

public class AddTheme extends JFrame {

	private JPanel contentPane;
	private JTextField TitleField;
	private JTextField CustomerField;
	private JTextField StartField;
	private JTextField EndField;
	
	public static String cathedra_name;
	public static int cathedra_id;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddTheme(JFrame parent) throws SQLException 
	{ 	  	
		CathedraDao cd = new CathedraDao();
		List<Cathedra> cathedras = cd.getAll();
 	  	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Додавання теми");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(63, 25, 272, 59);
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
		
		JLabel lblEnd = new JLabel("кінець");
		lblEnd.setBounds(89, 288, 76, 22);
		contentPane.add(lblEnd);
		
		JLabel lblCathedraName = new JLabel("назва кафедри");
		lblCathedraName.setBounds(89, 354, 101, 22);
		contentPane.add(lblCathedraName);
		
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
		
		EndField = new JTextField();
		EndField.setColumns(10);
		EndField.setBounds(202, 288, 350, 22);
		contentPane.add(EndField);
		
		JComboBox<String> CathedraComboBox = new JComboBox<String>();
		CathedraComboBox.setBounds(202, 354, 350, 22);
		contentPane.add(CathedraComboBox);
		for(Cathedra cathedra : cathedras)
		{
			CathedraComboBox.addItem(cathedra.getName());
		}

		
		JButton btnL = new JButton("Додати");
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				cathedra_id = Methods.getCathedraIdByCathedraName(cathedra_name, cathedra_id, CathedraComboBox, cathedras);
				Methods.addTheme(cathedra_id, TitleField, CustomerField, StartField, EndField);
				if (parent != null)
					parent.setVisible(true);
				AddTheme.this.setVisible(false);
				AddTheme.this.dispose();
			}
		});
		btnL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnL.setBounds(68, 420, 108, 32);
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
		btnBack.setBounds(489, 427, 97, 25);
		contentPane.add(btnBack);
	}
}
