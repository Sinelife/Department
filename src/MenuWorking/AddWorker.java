package MenuWorking;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddWorker extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public AddWorker(JFrame parent) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Вибір додавання аспіранта чи магістра");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(12, 13, 518, 42);
		contentPane.add(lblNewLabel);
		
		JButton AddMagisterButton = new JButton("Додати магістра");
		AddMagisterButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AddMagisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AddWorker.this.setVisible(false);
				try {
					new AddWorkerMagister(AddWorker.this).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		AddMagisterButton.setBounds(64, 129, 303, 52);
		contentPane.add(AddMagisterButton);
		
		JButton AddAspirantButton = new JButton("Додати аспіранта");
		AddAspirantButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AddWorker.this.setVisible(false);
				try {
					new AddWorkerAspirant(AddWorker.this).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		AddAspirantButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		AddAspirantButton.setBounds(64, 236, 303, 52);
		contentPane.add(AddAspirantButton);
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (parent != null)
					parent.setVisible(true);
				AddWorker.this.setVisible(false);
				AddWorker.this.dispose();
			}
		});
		btnBack.setBounds(428, 388, 97, 25);
		contentPane.add(btnBack);
	}

}
