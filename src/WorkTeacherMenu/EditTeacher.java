package WorkTeacherMenu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.ChooseCathedra;
import dao.TeacherDao;
import domain.Teacher;
import main.Methods;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class EditTeacher extends JFrame {

	private JPanel contentPane;

	public static int id_to_edit;



	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public EditTeacher(JFrame parent) throws SQLException 
	{
		TeacherDao td = new TeacherDao();
		List<Teacher> teachers = td.getAllFromCathedra(ChooseCathedra.cathedra_id_to_work);
 	  	
 	  	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JComboBox<String> TeacherComboBox = new JComboBox<String>();
		TeacherComboBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
		TeacherComboBox.setBounds(40, 121, 504, 34);
		contentPane.add(TeacherComboBox);
		for(Teacher teacher : teachers)
		{
			TeacherComboBox.addItem(td.getSurname(teacher.getId()));
		}
		
		
		
		JLabel lblNewLabel = new JLabel("Вибір викладача для редагування");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(0, 13, 628, 59);
		contentPane.add(lblNewLabel);
		

		
		
		JButton EditButton = new JButton("Редагувати");
		EditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					id_to_edit = Methods.getTeacherIdBySurname(TeacherComboBox, teachers);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				EditTeacher.this.setVisible(false);
				try {
					new EditTeacherFrame(EditTeacher.this).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		EditButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EditButton.setBounds(206, 200, 137, 34);
		contentPane.add(EditButton);

		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				EditTeacher.this.setVisible(false);
				EditTeacher.this.dispose();
			}
		});
		btnBack.setBounds(485, 268, 97, 25);
		contentPane.add(btnBack);
	}
}
