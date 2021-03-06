package zad1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LogInWindow extends JFrame implements ActionListener{
	
	boolean enter;
	boolean decision;
	JPanel jpanel;
	JLabel username;
	JLabel password;
	JLabel nickname;
	JLabel error;
	JTextField usernameF;
	JPasswordField passwordF;
	JTextField nicknameF;
	JButton LogIn;
	JButton Exit;
	public String guest;
	
	public LogInWindow(String name) {
		guest = "";
		decision = false;
		this.jpanel = new JPanel(new GridLayout(10,0));
		this.username = new JLabel("Username: ");
		this.password = new JLabel("Password: ");
		this.nickname = new JLabel("Default method - guest. Nickname: ");
		this.nicknameF = new JTextField();
		this.error = new JLabel("");
		this.usernameF = new JTextField();
		this.passwordF = new JPasswordField();
		this.LogIn = new JButton("Enter");
		this.Exit = new JButton("Exit");
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jpanel.add(username);
		jpanel.add(usernameF);
		jpanel.add(password);
		jpanel.add(passwordF);
		jpanel.add(nickname);
		jpanel.add(nicknameF);
		jpanel.add(error);
		jpanel.add(LogIn);
		jpanel.add(Exit);
	        
        LogIn.addActionListener(this);
        Exit.addActionListener(this);

        add(jpanel, BorderLayout.CENTER);
        setSize(400,300);
        setVisible(true);
        waitfordecision();
	}
	
	private void waitfordecision() {
		while (decision == false) {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		if(((a.getSource() == LogIn) && (((nicknameF.getText()).length()) > 0)) || 
				(((nicknameF.getText()).length()) > 0)) {
			System.out.println("Enter as a guest");
			guest = nicknameF.getText().trim();
			enter = true;
			close();
			decision = true;
		}
		else if((a.getSource() == LogIn) && ((passwordF.getPassword()).length > 0) || 
				((passwordF.getPassword()).length > 0)) {
			String pass = new String(passwordF.getPassword());
			//System.out.println(usernameF.getText());
			//System.out.println(passwordF.getPassword());
			if (((usernameF.getText()).trim().equals("root")) &&
			(pass.equals("root")) || 
			(((usernameF.getText()).trim().equals("toor")) &&
			(pass.equals("toor")))){
				System.out.println("Enter as a member");
				enter = true;
				close();
				decision = true;
			}
			else {
				error.setText("Wrong username or password. For admin |||| root, root OR toor, toor ||||");
			}
		}
		else if (a.getSource() == Exit) {
			System.out.println("------Exit------");
			close();
			decision = true;
		}
		
	}
	private void close() {
		Window win = SwingUtilities.getWindowAncestor(Exit);
		win.dispose();
	}
	
}