package MenuSupervision;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ThemesMenu.ChooseTheme;
import ThemesMenu.EditTheme;
import ThemesMenu.EditThemeFrame;
import ThemesMenu.WorkThemesMenu;
import dao.SupervisionDao;
import dao.TeacherDao;
import domain.Supervision;
import domain.Teacher;
import main.Methods;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class EditSupervisorInformationFrame extends JFrame {

	private JPanel contentPane;
	private JTextField StartInThemeField;
	private JTextField EndInThemeField;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public EditSupervisorInformationFrame(JFrame parent) throws SQLException 
	{
		SupervisionDao sd = new SupervisionDao();
		Supervision s = sd.readSupervisor(ChooseTheme.id_to_work);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 534);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Редагування інформації про керівника теми");
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label.setBounds(81, 48, 472, 37);
		contentPane.add(label);
		
		JLabel lblStartInTheme = new JLabel("початок керування темою");
		lblStartInTheme.setBounds(12, 167, 155, 22);
		contentPane.add(lblStartInTheme);
		
		JLabel lblEndInTheme = new JLabel("кінець керування темою");
		lblEndInTheme.setBounds(12, 225, 155, 22);
		contentPane.add(lblEndInTheme);
		
		
		
		StartInThemeField = new JTextField();
		StartInThemeField.setText((String) null);
		StartInThemeField.setColumns(10);
		StartInThemeField.setBounds(179, 167, 374, 22);
		contentPane.add(StartInThemeField);
 	  	StartInThemeField.setText(String.valueOf(s.getStart()));
		
		
		EndInThemeField = new JTextField();
		EndInThemeField.setText((String) null);
		EndInThemeField.setColumns(10);
		EndInThemeField.setBounds(179, 225, 374, 22);
		contentPane.add(EndInThemeField);
		Methods.DateToString(s.getEnd(), EndInThemeField);
 	  	
		
		
		JButton SaveButton = new JButton("Зберегти");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					Methods.updateSupervision(ChooseTheme.id_to_work, StartInThemeField, EndInThemeField);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				if (parent != null)
					parent.setVisible(true);
				EditSupervisorInformationFrame.this.setVisible(false);
				EditSupervisorInformationFrame.this.dispose();
			}
		});
		SaveButton.setBounds(31, 427, 113, 25);
		contentPane.add(SaveButton);
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (parent != null)
					parent.setVisible(true);
				EditSupervisorInformationFrame.this.setVisible(false);
				EditSupervisorInformationFrame.this.dispose();
			}
		});
		btnBack.setBounds(442, 427, 97, 25);
		contentPane.add(btnBack);
		
		
		
		
	}

}
