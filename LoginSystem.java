package loginSystemDemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class LoginSystem {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSystem window = new LoginSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbLogin = new JLabel("LOGIN SYSTEM");
		lbLogin.setBounds(194, 11, 158, 14);
		frame.getContentPane().add(lbLogin);
		
		JLabel lbUsername = new JLabel("Username");
		lbUsername.setBounds(66, 76, 68, 14);
		frame.getContentPane().add(lbUsername);
		
		JLabel lbPassword = new JLabel("Password");
		lbPassword.setBounds(66, 130, 89, 14);
		frame.getContentPane().add(lbPassword);
		
		textField = new JTextField();
		textField.setBounds(194, 73, 143, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(194, 127, 143, 20);
		frame.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				String password = txtPassword.getText();
				String username = textField.getText();
				
				if(password.contains("demo") && username.contains("karan")) {
					txtPassword.setText(null);
					textField.setText(null);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid login Details!!","Login Error",JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					textField.setText(null);
				}
			}
		});
		btnLogin.setBounds(39, 213, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				txtPassword.setText(null);
				
			}
		});
		btnReset.setBounds(204, 213, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Login Systems",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
				
			}
		});
		btnExit.setBounds(360, 213, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 174, 464, 14);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 36, 464, 14);
		frame.getContentPane().add(separator_1);
	}
}
