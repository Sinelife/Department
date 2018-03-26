package DepartmentMenu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.CathedraDao;
import domain.Cathedra;
import main.Methods;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class ChooseCathedra extends JFrame {

	private JPanel contentPane;

	public static String cathedra_name_to_work;
	public static int cathedra_id_to_work;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ChooseCathedra(JFrame parent) throws SQLException 
	{
		CathedraDao cd = new CathedraDao();
		List<Cathedra> cathedras = cd.getAll();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Меню вибору кафедри");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 28));
		label.setBounds(0, 0, 633, 59);
		contentPane.add(label);
		
		JComboBox<String> CathedraComboBox = new JComboBox<String>();
		CathedraComboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		CathedraComboBox.setBounds(67, 96, 504, 34);
		contentPane.add(CathedraComboBox);
		for(Cathedra cathedra : cathedras)
		{
			CathedraComboBox.addItem(cathedra.getName());
		}
		
		
		
		JButton Selectbutton = new JButton("Вибрати");
		Selectbutton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cathedra_id_to_work = Methods.getCathedraIdByCathedraName(cathedra_name_to_work, cathedra_id_to_work, CathedraComboBox, cathedras);
				
				ChooseCathedra.this.setVisible(false);
				try {
					new CathedraMenu().setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		});
		Selectbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Selectbutton.setBounds(250, 170, 104, 34);
		contentPane.add(Selectbutton);
		
		
		
		
		
		JButton btnback = new JButton("BACK");
		btnback.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (parent != null)
					parent.setVisible(true);
				ChooseCathedra.this.setVisible(false);
				ChooseCathedra.this.dispose();
			}
		});
		btnback.setBounds(492, 248, 97, 25);
		contentPane.add(btnback);
	}
}
