package MenuWorking;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainMenu.ChooseTheme;
import MainMenu.MainMenu;
import MenuTheme.ScientificThemeInformation;
import dao.WorkingDao;
import domain.Working;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DeleteWorker extends JFrame {

	private JPanel contentPane;



	/** 
	 * Create the frame.
	 * @throws SQLException 
	 */
	public DeleteWorker(JFrame parent) throws SQLException 
	{
		String sql_listofworkers = "select scientist_id,surname from scientist where scientist_id in (select scientist_id from working where scientific_theme_id = " + ChooseTheme.id_to_work + ")";
		PreparedStatement statement = MainMenu.conn.prepareStatement(sql_listofworkers);
		ResultSet rs = statement.executeQuery(sql_listofworkers);
 	  	String workers[] = new String[100];
 	  	int ids[] = new int[100];
 	  	int i = 0;
 	  	while(rs.next())
 	  	{
 	  		workers[i] = rs.getString("surname");
 	  		ids[i] = rs.getInt("scientist_id");
 	  		i++;
 	  	} 
		
 	  	
 	  	
 	  	
 	  	String sql_delete = "delete from working where scientist_id = ? and scientific_theme_id = " + ChooseTheme.id_to_work;
 	  	PreparedStatement statement_delete = MainMenu.conn.prepareStatement(sql_delete);
 	  	
 	
 	  	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox(workers);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		comboBox.setBounds(40, 121, 416, 34);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Видалити науковця з теми");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(40, 44, 543, 42);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (parent != null)
					parent.setVisible(true);
				DeleteWorker.this.setVisible(false);
				DeleteWorker.this.dispose();
			}
		});
		btnBack.setBounds(489, 427, 97, 25);
		contentPane.add(btnBack);
		
		JButton DeleteButton = new JButton("Видалити");
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	 	  	
				int selected_worker_id;
				String selected_worker_name = String.valueOf(comboBox.getSelectedItem());
				int k = 0;
				while(true)
				{
					selected_worker_id = ids[k];
					if((workers[k]).equals(selected_worker_name))
					{
						break;
					}
					k++;
				}
				
				WorkingDao wd = new WorkingDao();
				Working w = null;
				try {
					w = wd.readWorker(ChooseTheme.id_to_work, selected_worker_id);
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				} 
				try {
					wd.deleteWorker(w);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (parent != null)
					parent.setVisible(true);
				DeleteWorker.this.setVisible(false);
				DeleteWorker.this.dispose();

			}
		});
		DeleteButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DeleteButton.setBounds(40, 410, 104, 34);
		contentPane.add(DeleteButton);
	}

}
