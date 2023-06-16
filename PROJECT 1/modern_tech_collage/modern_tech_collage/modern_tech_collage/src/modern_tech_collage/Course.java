/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modern_tech_collage;

import static java.awt.Color.white;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author test
 */
public class Course extends javax.swing.JFrame implements ActionListener{
     public void main(String args[]){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new Course().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
     
    Connection con;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model;
    
    public void doconnect() throws SQLException{
        model = new DefaultTableModel();
        model.addColumn("C_ID");
        model.addColumn("C_Name");
        model.addColumn("Duration");
        model.addColumn("Instructor_ID");
        Table.setModel(model);
        String port = Welcome_Page.port.getText();
        String path = "jdbc:sqlserver://localhost:" + port + ";databaseName=Modern_Tech_Collage_DB;encrypt=false"; 
        String usr = Welcome_Page.usr.getText() ;
        String pass = Welcome_Page.pass.getText();  
        try{
        con = DriverManager.getConnection(path,usr, pass);
        stmt = con.createStatement();
        rs = stmt.executeQuery("select * from Course ");
        while(rs.next()){
            model.addRow(new Object[]{rs.getInt("C_ID"), rs.getString("C_Name"), rs.getInt("Duration"),rs.getInt("Instructor_ID")});
        }
    }
    catch (SQLException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
            }

    }
    
    JButton update;
    JButton insert;
    JButton delete;
    JButton search;
    JButton refresh;
    JButton back;
    JTextField C_ID_Input;
    JTextField C_Name_Input;
    JTextField Duration_Input;
    JTextField Instructor_ID_Input;
    JLabel label;
    JLabel C_ID;
    JLabel C_N;
    JLabel D;
    JLabel I_ID;
    JLabel black_label;
    JLabel black_label1;
    JLabel black_label2;
    JLabel black_label3;
    Font fn18;
    Font fn14;
    ImageIcon image;    
    ImageIcon black_image;
    ImageIcon refresh_icon;
    ImageIcon back_icon;
    JTable Table;
    JScrollPane scroll;
    
    public Course() throws SQLException{
        String[] columnNames = {"C_ID", "C_Name", "Duration","Instructor_ID"};
        String[][] data = {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
            };
        Table = new JTable(data,columnNames);
        
        scroll = new JScrollPane(Table);
        scroll.setBounds(110,0,500,270);
        
        image = new ImageIcon("Main_TECH.png");
        
        black_image = new ImageIcon("black.png");
        
        refresh_icon = new ImageIcon("refresh.png");
        
        back_icon = new ImageIcon("back.png");

        insert = new JButton("Insert");
        insert.setBounds(440,340,171,43);
        insert.setFont(fn18);
        insert.setFocusable(false);
        insert.addActionListener(this);
        
        refresh = new JButton();
        refresh.setBounds(650,0,80,30);
        refresh.setIcon(refresh_icon);
        refresh.setFocusable(false);
        refresh.addActionListener(this);

        back = new JButton();
        back.setBounds(0,0,80,30);
        back.setIcon(back_icon);
        back.setFocusable(false);
        back.addActionListener(this);
        
        delete = new JButton("Delete");
        delete.setBounds(440,410,171,43);
        delete.setFont(fn18);
        delete.setFocusable(false);
        delete.addActionListener(this);

        update = new JButton("Update");
        update.setBounds(440,480,171,43);
        update.setFont(fn18);
        update.setFocusable(false);
        update.addActionListener(this);

        search = new JButton("Search");
        search.setBounds(440,280,170,40);
        search.setFont(fn18);
        search.setFocusable(false);
        search.addActionListener(this);
        
        C_ID_Input = new JTextField();
        C_ID_Input.setBounds(116,320,136,25);

        Duration_Input = new JTextField();
        Duration_Input.setBounds(116,450,136,25);

        C_Name_Input = new JTextField();
        C_Name_Input.setBounds(116,390,136,25);
        
        C_ID = new JLabel("C_ID");
        C_ID.setBounds(50, 320, 100, 25);
        C_ID.setFont(fn18);
        C_ID.setForeground(white);
        
        C_N = new JLabel("C_Name");
        C_N.setBounds(50, 390, 100, 20);
        C_N.setFont(fn18);
        C_N.setForeground(white);
        
        D = new JLabel("Duration");
        D.setBounds(50, 450, 100, 20);
        D.setFont(fn18);
        D.setForeground(white);

        I_ID = new JLabel("Instructor_ID");
        I_ID.setBounds(45, 500, 100, 20);
        I_ID.setFont(fn14);
        I_ID.setForeground(white);

        Instructor_ID_Input = new JTextField();
        Instructor_ID_Input.setBounds(116,500,136,25);

        black_label = new JLabel("",black_image,JLabel.CENTER);
        black_label.setBounds(10, 320, 170, 25);

        black_label1 = new JLabel("",black_image,JLabel.CENTER);
        black_label1.setBounds(10, 390, 170, 25);

        black_label2 = new JLabel("",black_image,JLabel.CENTER);
        black_label2.setBounds(10, 450, 170, 25);

        black_label3 = new JLabel("",black_image,JLabel.CENTER);
        black_label3.setBounds(10, 500, 170, 25);

        fn18 = new Font("Arial",Font.BOLD,18);
        
        fn14 = new Font("Arial",Font.BOLD,14);

        label = new JLabel("", image,JLabel.CENTER);
        label.setSize(733, 540);

        this.setBounds(0, 0, 733, 575);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Modern Tech Collage(Course DB)");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(C_ID);
        this.add(C_N);
        this.add(D);
        this.add(I_ID);
        this.add(back);
        this.add(refresh);
        this.add(scroll);
        this.add(insert);
        this.add(delete);
        this.add(update);
        this.add(C_ID_Input);
        this.add(C_Name_Input);
        this.add(Duration_Input);
        this.add(Instructor_ID_Input);
        this.add(black_label);
        this.add(black_label1);
        this.add(black_label2);
        this.add(black_label3);
        this.add(search);
        this.add(label);
        
        doconnect();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==delete){
             int id = Integer.parseInt(C_ID_Input.getText());

        try {
            // create a DELETE statement and execute it
            String query = "DELETE FROM Course WHERE C_ID =" + id;
            stmt.executeUpdate(query);

            // remove the row from the table model
            int index = Table.getSelectedRow();
            if (index >= 0) {
                model.removeRow(index);
            }

            // clear the input fields
            C_ID_Input.setText("");
            C_Name_Input.setText("");
            Duration_Input.setText("");
            Instructor_ID_Input.setText("");
            JOptionPane.showMessageDialog(null, "Course record deleted successfully!");
            this.setVisible(false);
        Course c = new Course();
        c.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        }
        else if (e.getSource()==refresh){
            this.setVisible(false);
        Course c;
            try {
                c = new Course();
                c.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource()==back){
            this.setVisible(false);
        Main_Page m = new Main_Page();
        m.setVisible(true);
        }
        else if(e.getSource()==update){
            int C_ID = Integer.parseInt(C_ID_Input.getText());
        String C_Name = C_Name_Input.getText();
        int Duration = Duration_Input.getText().isEmpty() ? 0 : Integer.parseInt(Duration_Input.getText());
        int Instructor_ID  = Instructor_ID_Input.getText().isEmpty() ? 0 : Integer.parseInt(Instructor_ID_Input.getText());
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM Course WHERE C_ID = " + C_ID);

            if (rs.next()) {
                if (C_Name != null && !C_Name.equals("")) {
                    rs.updateString("C_Name", C_Name);
                }
                if (Duration != 0 ) {
                    rs.updateInt("Duration", Duration);
                }
                if (Instructor_ID != 0) {
                    rs.updateInt("Instructor_ID", Instructor_ID);
                }
                rs.updateRow();
                C_ID_Input.setText("");
                C_Name_Input.setText("");
                Duration_Input.setText("");
                Instructor_ID_Input.setText("");
                JOptionPane.showMessageDialog(null, "Course record updated successfully!");
                this.setVisible(false);
        Course c = new Course();
        c.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Course record with ID " + C_ID + " does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
            C_ID_Input.setText("");
            C_Name_Input.setText("");
            Duration_Input.setText("");
            Instructor_ID_Input.setText("");
        }
        else if(e.getSource()==search){
            String searchValue = C_ID_Input.getText();
    if (searchValue.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a search term");
        return;
    }
    try {
        String sql = "SELECT * FROM Course WHERE C_ID = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, searchValue);
        ResultSet resultSet = statement.executeQuery();
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setRowCount(0);
        while (resultSet.next()) {
            int column1 = resultSet.getInt("C_ID");
            String column2 = resultSet.getString("C_Name");
            int column3 = resultSet.getInt("Duration");
            int column4 = resultSet.getInt("Instructor_ID");
            Object[] rowData = { column1, column2, column3, column4 };
            model.addRow(rowData);
        }
    } catch (Exception eo) {
    }
    C_ID_Input.setText("");
        }
        else if(e.getSource()==insert){
            int C_ID = Integer.parseInt(C_ID_Input.getText());
        String C_Name = C_Name_Input.getText();
        int Duration = Integer.parseInt(Duration_Input.getText());
        int Instructor_ID  = Integer.parseInt(Instructor_ID_Input.getText());
        String query= "insert into Course  values(" + C_ID + ",'" + C_Name + "'," + Duration + "," + Instructor_ID + ")";
        try{
            stmt.executeUpdate(query);
            model.addRow(new Object[]{C_ID, C_Name, Duration, Instructor_ID});
            C_ID_Input.setText("");
            C_Name_Input.setText("");
            Duration_Input.setText("");
            Instructor_ID_Input.setText("");
        }
        catch (SQLException ex){
            Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null,ex);
        }
        }
    }
}
