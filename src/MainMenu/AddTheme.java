package MainMenu;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.CathedraDao;
import dao.ScientificThemeDao;
import domain.Cathedra;
import domain.ScientificTheme;

import javax.swing.JComboBox;

public class AddTheme extends JFrame {

	private JPanel contentPane;
	private JTextField TitleField;
	private JTextField CustomerField;
	private JTextField StartField;
	private JTextField EndField;

	//private Statement s; 
	//private PreparedStatement ps;
	//private ResultSet rs;
	//private String sql;
	
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddTheme(JFrame parent) throws SQLException 
	{ 	  	
		ScientificThemeDao std = new ScientificThemeDao();
		ScientificTheme st = new ScientificTheme();
		CathedraDao cd = new CathedraDao();
		/*
 	  	String sql_cathedra = "select cathedra_id,name from cathedra";
 	  	PreparedStatement statement_cathedra = MainMenu.conn.prepareStatement(sql_cathedra);
 	  	ResultSet rs_cathedra = statement_cathedra.executeQuery(sql_cathedra);
 	  	String cathedras[] = new String[100];
 	  	int ids[] = new int[100];
 	  	int i = 0;
 	  	while(rs_cathedra.next())
 	  	{
 	  		ids[i] = rs_cathedra.getInt("cathedra_id");
 	  		cathedras[i] = rs_cathedra.getString("name");
 	  		i++;
 	  	}*/
 	  	
		List<Cathedra> cathedras = cd.getAll();
		String[] _names = new String[100];
		int[] _ids = new int[100];
		int i = 0;
		for(Cathedra cathedra : cathedras)
		{
			_names[i] = cathedra.getName();
			_ids[i] = cathedra.getId();
			i++;
		}
 	  	
		
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
		
		JComboBox comboBox = new JComboBox(_names);
		comboBox.setBounds(202, 354, 350, 22);
		contentPane.add(comboBox);
		


		
		JButton btnL = new JButton("Додати");
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int selected_cathedra_id;
				String selected_cathedra_name = String.valueOf(comboBox.getSelectedItem());
				int k = 0;
				while(true)
				{
					selected_cathedra_id = _ids[k];
					if((_names[k]).equals(selected_cathedra_name))
					{
						break;
					}
					k++;
				}
				
				st.setTitle(TitleField.getText());
				st.setCustomer(CustomerField.getText());
				st.setStart(Date.valueOf(StartField.getText()));
	 	  		if(EndField.getText().equals("null"))
	 	  		{
	 	  			st.setEnd(null);
	 	  		}
	 	  		else
	 	  		{
	 	  			st.setEnd(Date.valueOf(EndField.getText()));
	 	  		}
				st.setCathedraId(selected_cathedra_id);
			
	 	  		try {
					std.addTheme(st);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
