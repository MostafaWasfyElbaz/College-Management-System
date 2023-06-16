package modern_tech_collage ;


import static java.awt.Color.white;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Welcome_Page extends JFrame implements ActionListener {
    JButton button = new JButton("Sign in");
    ImageIcon image_Main_TECH = new ImageIcon("Main_TECH.png");
    ImageIcon black1_icon = new ImageIcon("black.png");
    JLabel mylabel;
    public static JTextField usr;
    public static JPasswordField pass;
    public static JTextField port;
    JLabel USR;
    JLabel PASS;
    JLabel PORT;
    JLabel black;
    JLabel black1;
    JLabel black2;
    Connection con;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model;

    Welcome_Page() {
        PORT = new JLabel("Port");
        PORT.setBounds(180, 100, 60, 30);
        PORT.setForeground(white);

        USR = new JLabel("User");
        USR.setBounds(180, 200, 60, 30);
        USR.setForeground(white);

        PASS = new JLabel("Password");
        PASS.setBounds(180, 300, 60, 30);
        PASS.setForeground(white);

        black = new JLabel("", black1_icon, JLabel.CENTER);
        black.setBounds(170, 100, 80, 30);

        black1 = new JLabel("", black1_icon, JLabel.CENTER);
        black1.setBounds(170, 200, 80, 30);

        black2 = new JLabel("", black1_icon, JLabel.CENTER);
        black2.setBounds(170, 300, 80, 30);

        port = new JTextField();
        port.setBounds(250, 100, 200, 30);
        port.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    doConnect();
                }
            }
        });

        usr = new JTextField();
        usr.setBounds(250, 200, 200, 30);
        usr.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    doConnect();
                }
            }
        });

        pass = new JPasswordField();
        pass.setBounds(250, 300, 200, 30);
        pass.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    doConnect();
                }
            }
        });

        mylabel = new JLabel("", image_Main_TECH, JLabel.CENTER);
        mylabel.setBounds(0, 0, 733, 540);

        button.setBounds(280, 400, 170, 50);
        button.setFocusable(false);
        button.addActionListener(this);

        this.setTitle("Modern Tech Collage");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(733, 540);
        this.setLayout(null);
        this.setResizable(false);
        this.add(pass);
        this.add(PASS);
        this.add(USR);
        this.add(PORT);
        this.add(port);
        this.add(usr);
        this.add(black);
        this.add(black1);
        this.add(black2);
        this.add(button);
        this.add(mylabel);
        this.setLocationRelativeTo(null);}
    
public void doConnect() {
    int Port = Integer.parseInt(port.getText());
    String path = "jdbc:sqlserver://localhost:" + Port + ";databaseName=Modern_Tech_Collage_DB;encrypt=false";
    String user = usr.getText();
    String passw = pass.getText();
    try {
        con = DriverManager.getConnection(path, user, passw);
        this.setVisible(false);
        Main_Page m = new Main_Page();
        m.setVisible(true);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
        this.setVisible(false);
        Welcome_Page w = new Welcome_Page();
        w.setVisible(true);
    }
}

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button) {
        doConnect();
    }
}}


