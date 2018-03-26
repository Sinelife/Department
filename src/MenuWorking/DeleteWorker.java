package MenuWorking;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ThemesMenu.ChooseTheme;
import dao.WorkingDao;
import domain.Working;
import main.Methods;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class DeleteWorker extends JFrame {

	private JPanel contentPane;

	public static String surname_to_delete;
	public static int id_to_delete;

	/** 
	 * Create the frame.
	 * @throws SQLException 
	 */
	public DeleteWorker(JFrame parent) throws SQLException 
	{
		WorkingDao wd = new WorkingDao();
		List<Working> workers = wd.getAllFromTheme(ChooseTheme.id_to_work);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		comboBox.setBounds(40, 121, 416, 34);
		contentPane.add(comboBox);
		for(Working worker : workers)
		{
			comboBox.addItem(wd.getSurname(worker.getScientistId()));
		}
		
		
		JLabel lblNewLabel = new JLabel("Видалити науковця з теми");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(40, 44, 543, 42);
		contentPane.add(lblNewLabel);
		

		
		JButton DeleteButton = new JButton("Видалити");
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	 	  	
				try {
					id_to_delete = Methods.getWorkerIdBySurname(surname_to_delete, id_to_delete, comboBox, workers);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				Methods.deleteWorking(ChooseTheme.id_to_work, id_to_delete);
				if (parent != null)
					parent.setVisible(true);
				DeleteWorker.this.setVisible(false);
				DeleteWorker.this.dispose();

			}
		});
		DeleteButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DeleteButton.setBounds(40, 410, 104, 34);
		contentPane.add(DeleteButton);
		
		
		
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
	}

}
