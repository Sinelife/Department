package ThemesMenu;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DepartmentMenu.ChooseCathedra;
import dao.ScientificThemeDao;
import domain.ScientificTheme;
import main.Methods;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class EditThemeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField TitleField;
	private JTextField CustomerField;
	
	
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public EditThemeFrame(JFrame parent) throws SQLException 
	{
 	  	ScientificThemeDao std = new ScientificThemeDao();
 	  	ScientificTheme st = std.readTheme(EditTheme.id_to_edit);
 	  	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblScientificThemeInformation = new JLabel("Редагування наукової теми");
		lblScientificThemeInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblScientificThemeInformation.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblScientificThemeInformation.setBounds(0, 23, 622, 37);
		contentPane.add(lblScientificThemeInformation);
	
		JLabel lblTitle = new JLabel("назва теми");
		lblTitle.setBounds(89, 115, 76, 22);
		contentPane.add(lblTitle);
		
		JLabel lblCustomer = new JLabel("замовник");
		lblCustomer.setBounds(89, 167, 76, 22);
		contentPane.add(lblCustomer);
		
		
		TitleField = new JTextField();
		TitleField.setBounds(202, 115, 350, 22);
		contentPane.add(TitleField);
		TitleField.setColumns(10);
		TitleField.setText(st.getTitle());
		
		
		CustomerField = new JTextField();
		CustomerField.setBounds(202, 167, 350, 22);
		contentPane.add(CustomerField);
		CustomerField.setColumns(10);
		CustomerField.setText(st.getCustomer());
		
		
		
		JButton EditButton = new JButton("Редагувати");
		EditButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Methods.updateTheme(EditTheme.id_to_edit,ChooseCathedra.cathedra_id_to_work, TitleField, CustomerField);
				EditThemeFrame.this.setVisible(false);
				EditThemeFrame.this.dispose();
				try {
					new WorkThemesMenu().setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			}
		});
		EditButton.setBounds(34, 229, 113, 25);
		contentPane.add(EditButton);
		
		
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				EditThemeFrame.this.setVisible(false);
				EditThemeFrame.this.dispose();
			}
		});
		btnBack.setBounds(478, 229, 97, 25);
		contentPane.add(btnBack);
	}
}
