package MenuSupervision;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainMenu.ChooseTheme;
import MainMenu.MainMenu;
import dao.ScientificThemeDao;
import dao.SupervisionDao;
import dao.TeacherDao;
import domain.ScientificTheme;
import domain.Supervision;
import domain.Teacher;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.awt.event.ActionEvent;

public class ChangeSupervisor extends JFrame {

	private JPanel contentPane;
	public static String surname_to_look;
	public static int id_to_look;



	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ChangeSupervisor(JFrame parent) throws SQLException 
	{
		SupervisionDao sd = new SupervisionDao();
		Supervision s = sd.readSupervisor(ChooseTheme.id_to_work);
		
		
		ScientificThemeDao std = new ScientificThemeDao();
		ScientificTheme st = std.readTheme(ChooseTheme.id_to_work);
		
		TeacherDao td = new TeacherDao();
		List<Teacher> teachers = td.getAllFromCathedraExceptSupervisor(ChooseTheme.id_to_work, st.getCathedraId());
		String[] teacher_names = new String[100];
		int[] teacher_ids = new int[100];
		int i = 0;
		for(Teacher teacher : teachers)
		{
			teacher_names[i] = td.getSurname(teacher.getId());
			teacher_ids[i] = teacher.getId();
			i++;
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox(teacher_names);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 23));
		comboBox.setBounds(40, 121, 411, 34);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Вибір нового керівника");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(40, 44, 543, 42);
		contentPane.add(lblNewLabel);
		

		
		JButton SaveButton = new JButton("Зберегти");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String selected_teacher = (String) comboBox.getSelectedItem();
				int selected_id = 0;
				int i = 0;
				while(true)
				{
					if(selected_teacher.equals(teacher_names[i]))
					{
						selected_id = teacher_ids[i];
						break;
					}
					i++;
				}
				try {
					sd.changeSupervisor(selected_id,s);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (parent != null)
					parent.setVisible(true);
				ChangeSupervisor.this.setVisible(false);
				ChangeSupervisor.this.dispose();
			}
		});
		SaveButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SaveButton.setBounds(40, 410, 104, 34);
		contentPane.add(SaveButton);
		
		
		
		JButton ChooseButton_1 = new JButton("Інформація");
		ChooseButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ChooseButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				MenuSupervision.teacher_change_or_add = 2;
				surname_to_look = String.valueOf(comboBox.getSelectedItem());
				int k = 0;
				while(true)
				{
					
					id_to_look = teacher_ids[k];
					if((teacher_names[k]).equals(surname_to_look))
					{
						break;
					}
					k++;
				}
				ChangeSupervisor.this.setVisible(false);
				try {
					new TeacherInformation(ChangeSupervisor.this).setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		ChooseButton_1.setBounds(463, 121, 120, 34);
		contentPane.add(ChooseButton_1);
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				ChangeSupervisor.this.setVisible(false);
				ChangeSupervisor.this.dispose();
			}
		});
		btnBack.setBounds(489, 427, 97, 25);
		contentPane.add(btnBack);
	}

}
