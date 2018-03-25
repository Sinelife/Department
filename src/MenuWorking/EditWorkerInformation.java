package MenuWorking;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainMenu.ChooseTheme;
import dao.WorkingDao;
import domain.Working;
import main.Methods;

import javax.swing.JComboBox;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class EditWorkerInformation extends JFrame {

	private JPanel contentPane;
	public static String surname_to_edit;
	public static int id_to_edit;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public EditWorkerInformation(JFrame parent) throws SQLException 
	{
		WorkingDao wd = new WorkingDao();
		List<Working> workers = wd.getAllFromTheme(ChooseTheme.id_to_work);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		comboBox.setBounds(44, 108, 475, 34);
		contentPane.add(comboBox);
		for(Working worker : workers)
		{
			comboBox.addItem(wd.getSurname(worker.getScientistId()));
		}
		
		
		JLabel label = new JLabel("Вибір науковця для редагування інформації");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(0, 31, 570, 42);
		contentPane.add(label);
		
		
		
		JButton SelectButton = new JButton("Вибрати");
		SelectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				try {
					id_to_edit = Methods.getWorkerIdBySurname(surname_to_edit, id_to_edit, comboBox, workers);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				EditWorkerInformation.this.setVisible(false);
				try {
					new EditWorkerInformationFrame(EditWorkerInformation.this).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		SelectButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SelectButton.setBounds(224, 172, 97, 34);
		contentPane.add(SelectButton);
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
				{
					if (parent != null)
						parent.setVisible(true);
					EditWorkerInformation.this.setVisible(false);
					EditWorkerInformation.this.dispose();
				}
		});
		btnBack.setBounds(461, 414, 97, 25);
		contentPane.add(btnBack);
	}
}
