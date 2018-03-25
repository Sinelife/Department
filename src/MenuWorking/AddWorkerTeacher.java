package MenuWorking;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainMenu.ChooseTheme;
import dao.ScientificThemeDao;
import dao.TeacherDao;
import dao.WorkingDao;
import domain.ScientificTheme;
import domain.Teacher;
import domain.Working;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class AddWorkerTeacher extends JFrame {

	private JPanel contentPane;
	private JTextField WorkingNameField;
	private JTextField StartField;
	private JTextField EndField;
	public static String t_surname_to_look;
	public static int t_id_to_look;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddWorkerTeacher(JFrame parent) throws SQLException 
	{
		ScientificThemeDao std = new ScientificThemeDao();
		ScientificTheme st = std.readTheme(ChooseTheme.id_to_work);
		
		
		TeacherDao td = new TeacherDao();
		List<Teacher> teachers = td.getAllNotFromThemeNotFromCathedra(ChooseTheme.id_to_work, st.getCathedraId());
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
		comboBox.setBounds(40, 121, 418, 34);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Залучення викладача");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(40, 44, 543, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNameWorking = new JLabel("назва роботи");
		lblNameWorking.setBounds(40, 205, 104, 22);
		contentPane.add(lblNameWorking);
		
		JLabel lblStart = new JLabel("початок роботи");
		lblStart.setBounds(40, 257, 104, 22);
		contentPane.add(lblStart);
		
		JLabel lblEnd = new JLabel("кінець роботи");
		lblEnd.setBounds(40, 315, 104, 22);
		contentPane.add(lblEnd);
		
		WorkingNameField = new JTextField();
		WorkingNameField.setColumns(10);
		WorkingNameField.setBounds(168, 205, 376, 22);
		contentPane.add(WorkingNameField);
		
		StartField = new JTextField();
		StartField.setColumns(10);
		StartField.setBounds(168, 257, 376, 22);
		contentPane.add(StartField);
		
		EndField = new JTextField();
		EndField.setColumns(10);
		EndField.setBounds(168, 315, 376, 22);
		contentPane.add(EndField);
		
		
		
		
		
		
		JButton AddButton = new JButton("Додати");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int selected_teacher_id;
				String selected_teacher_name = String.valueOf(comboBox.getSelectedItem());
				int k = 0;
				while(true)
				{
					selected_teacher_id = teacher_ids[k];
					if((teacher_names[k]).equals(selected_teacher_name))
					{
						break;
					}
					k++;
				}
				
				
				WorkingDao wd = new WorkingDao();
				Working w = new Working();
				
				w.setScientificThemeId(ChooseTheme.id_to_work);
				w.setScientistId(selected_teacher_id);
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
				AddWorkerTeacher.this.setVisible(false);
				AddWorkerTeacher.this.dispose();
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
				t_surname_to_look = String.valueOf(comboBox.getSelectedItem());
				int k = 0;
				while(true)
				{
					
					t_id_to_look = teacher_ids[k];
					if((teacher_names[k]).equals(t_surname_to_look))
					{
						break;
					}
					k++;
				}
				AddWorkerTeacher.this.setVisible(false);
				try {
					new NotWorkerTeacherInformation(AddWorkerTeacher.this).setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		ChooseButton.setBounds(467, 121, 116, 34);
		contentPane.add(ChooseButton);
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				AddWorkerTeacher.this.setVisible(false);
				AddWorkerTeacher.this.dispose();
			}
		});
		btnBack.setBounds(489, 427, 97, 25);
		contentPane.add(btnBack);
		
		
	}

}
