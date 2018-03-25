package MenuWorking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainMenu.ChooseTheme;
import MainMenu.EditTheme;
import MainMenu.EditThemeFrame;
import MainMenu.MainMenu;
import dao.WorkingDao;
import domain.Working;

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

public class EditWorkerInformationFrame extends JFrame {

	private JPanel contentPane;
	private JTextField WorkInThemeField;
	private JTextField StartInThemeField;
	private JTextField EndInThemeField;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public EditWorkerInformationFrame(JFrame parent) throws SQLException 
	{
		WorkingDao wd = new WorkingDao();
		Working w = wd.readWorker(ChooseTheme.id_to_work, EditWorkerInformation.id_to_edit);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 534);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Редагування інформації про роботу науковця в темі");
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label.setBounds(81, 13, 472, 37);
		contentPane.add(label);
		
		JLabel lblWorkInTheme = new JLabel("назва роботи в темі");
		lblWorkInTheme.setBounds(12, 115, 155, 22);
		contentPane.add(lblWorkInTheme);
		
		JLabel lblStartInTheme = new JLabel("початок роботи в темі");
		lblStartInTheme.setBounds(12, 167, 155, 22);
		contentPane.add(lblStartInTheme);
		
		JLabel lblEndInTheme = new JLabel("кінець роботи в темі");
		lblEndInTheme.setBounds(12, 225, 155, 22);
		contentPane.add(lblEndInTheme);
		
		WorkInThemeField = new JTextField();
		WorkInThemeField.setText((String) null);
		WorkInThemeField.setColumns(10);
		WorkInThemeField.setBounds(179, 115, 374, 22);
		contentPane.add(WorkInThemeField);
		WorkInThemeField.setText(w.getTitle());
		
		
		StartInThemeField = new JTextField();
		StartInThemeField.setText((String) null);
		StartInThemeField.setColumns(10);
		StartInThemeField.setBounds(179, 167, 374, 22);
		contentPane.add(StartInThemeField);
 	  	StartInThemeField.setText(String.valueOf(w.getStart()));
		
		
		EndInThemeField = new JTextField();
		EndInThemeField.setText((String) null);
		EndInThemeField.setColumns(10);
		EndInThemeField.setBounds(179, 225, 374, 22);
		contentPane.add(EndInThemeField);
		MainMenu.DateToString(w.getEnd(), EndInThemeField);;
 	  	
		
		
		JButton SaveButton = new JButton("Зберегти");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				w.setTitle(WorkInThemeField.getText());
				w.setStart(Date.valueOf(StartInThemeField.getText()));
				if(EndInThemeField.getText().equals(""))
				{
					w.setEnd(null);
				}
				else
				{
					w.setEnd(Date.valueOf(EndInThemeField.getText()));
				}
				try {
					wd.updateWorker(w);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (parent != null)
					parent.setVisible(true);
				EditWorkerInformationFrame.this.setVisible(false);
				EditWorkerInformationFrame.this.dispose();
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
				EditWorkerInformationFrame.this.setVisible(false);
				EditWorkerInformationFrame.this.dispose();
			}
		});
		btnBack.setBounds(442, 427, 97, 25);
		contentPane.add(btnBack);
	}

}
