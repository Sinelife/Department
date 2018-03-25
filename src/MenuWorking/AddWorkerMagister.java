package MenuWorking;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainMenu.ChooseTheme;
import dao.MagisterDao;
import dao.WorkingDao;
import domain.Magister;
import domain.Working;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class AddWorkerMagister extends JFrame {

	private JPanel contentPane;
	private JTextField WorkingNameField;
	private JTextField StartField;
	private JTextField EndField;
	public static String m_surname_to_look;
	public static int m_id_to_look;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddWorkerMagister(JFrame parent) throws SQLException 
	{
		MagisterDao md = new MagisterDao();
		List<Magister> magisters = md.getAllNotFromTheme(ChooseTheme.id_to_work);
		String[] magister_names = new String[100];
		int[] magister_ids = new int[100];
		int i = 0;
		for(Magister magister : magisters)
		{
			magister_names[i] = md.getSurname(magister.getId());
			magister_ids[i] = magister.getId();
			i++;
		}
 	  	
 	  	
 	  	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox(magister_names);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		comboBox.setBounds(40, 121, 418, 34);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Додати нового науковця-магістра до теми");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(40, 44, 543, 42);
		contentPane.add(lblNewLabel);	
		

		
		JLabel lblNameWorking = new JLabel("назва роботи");
		lblNameWorking.setBounds(40, 206, 104, 22);
		contentPane.add(lblNameWorking);
		
		JLabel lblStart = new JLabel("початок роботи");
		lblStart.setBounds(40, 258, 104, 22);
		contentPane.add(lblStart);
		
		JLabel lblEnd = new JLabel("кінець роботи");
		lblEnd.setBounds(40, 316, 104, 22);
		contentPane.add(lblEnd);
		
		WorkingNameField = new JTextField();
		WorkingNameField.setColumns(10);
		WorkingNameField.setBounds(168, 206, 376, 22);
		contentPane.add(WorkingNameField);
		
		StartField = new JTextField();
		StartField.setColumns(10);
		StartField.setBounds(168, 258, 376, 22);
		contentPane.add(StartField);
		
		EndField = new JTextField();
		EndField.setColumns(10);
		EndField.setBounds(168, 316, 376, 22);
		contentPane.add(EndField);
		
		
		
		
		JButton AddButton = new JButton("Додати");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int selected_worker_id;
				String selected_worker_name = String.valueOf(comboBox.getSelectedItem());
				int k = 0;
				while(true)
				{
					selected_worker_id = magister_ids[k];
					if((magister_names[k]).equals(selected_worker_name))
					{
						break;
					}
					k++;
				}
				
				
				WorkingDao wd = new WorkingDao();
				Working w = new Working();
				
				w.setScientificThemeId(ChooseTheme.id_to_work);
				w.setScientistId(selected_worker_id);
				w.setTitle(WorkingNameField.getText());
				w.setStart(Date.valueOf(StartField.getText()));
				if(EndField.getText().equals(""))
				{
					w.setEnd(null);
				}
				else
				{
					w.setEnd(Date.valueOf(EndField.getText()));
				}
				try {
					wd.addWorker(w);
				} catch (SQLException e6) {
					// TODO Auto-generated catch block
					e6.printStackTrace();
				}
				if (parent != null)
					parent.setVisible(true);
				AddWorkerMagister.this.setVisible(false);
				AddWorkerMagister.this.dispose();
			}
		});
		AddButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AddButton.setBounds(40, 410, 104, 34);
		contentPane.add(AddButton);
		
		
		
		
		
		JButton ChooseButton = new JButton("Інформація");
		ChooseButton.setForeground(Color.BLACK);
		ChooseButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ChooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				m_surname_to_look = String.valueOf(comboBox.getSelectedItem());
				int k = 0;
				while(true)
				{
					
					m_id_to_look = magister_ids[k];
					if((magister_names[k]).equals(m_surname_to_look))
					{
						break;
					}
					k++;
				}
				AddWorkerMagister.this.setVisible(false);
				try {
					new NotWorkerMagisterInformation(AddWorkerMagister.this).setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		ChooseButton.setBounds(470, 121, 116, 34);
		contentPane.add(ChooseButton);
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				AddWorkerMagister.this.setVisible(false);
				AddWorkerMagister.this.dispose();
			}
		});
		btnBack.setBounds(489, 427, 97, 25);
		contentPane.add(btnBack);	
		
	}
}
