package modern_tech_collage;

import static java.awt.Color.white;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class Enrollment extends javax.swing.JFrame implements ActionListener{
    public void main(String args[]){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Enrollment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Enrollment().setVisible(true);
            }
        });
    }
    
    Connection con;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model;
    
    public void doconnect(){
        model = new DefaultTableModel();
        model.addColumn("Student_ID");
        model.addColumn("C_ID");
        Table.setModel(model);
        String port = Welcome_Page.port.getText();
        String path = "jdbc:sqlserver://localhost:" + port + ";databaseName=Modern_Tech_Collage_DB;encrypt=false"; 
        String usr = Welcome_Page.usr.getText() ;
        String pass = Welcome_Page.pass.getText();  
        try{
        con = DriverManager.getConnection(path,usr, pass);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from Enrollment  ");
            while(rs.next()){
                model.addRow(new Object[]{ rs.getInt("Student_ID"),rs.getInt("C_ID")});
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
    JTextField Student_ID_Input;
    JTextField C_ID_Input;
    JLabel label;
    JLabel Student_ID;
    JLabel C_ID;
    JLabel black_label1;
    JLabel black_label3;
    Font fn18;
    Font fn14;
    Font fn5;
    ImageIcon image;    
    ImageIcon black_image;
    ImageIcon refresh_icon;
    ImageIcon back_icon;
    JTable Table;
    JScrollPane scroll;

     Enrollment(){
        String[] columnNames = {"Student_ID","C_ID"};
        String[][] data = {
            {null, null},
            {null, null},
            {null, null}
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

        Student_ID_Input = new JTextField();
        Student_ID_Input.setBounds(116,370,136,25);
        
        C_ID_Input = new JTextField();
        C_ID_Input.setBounds(116,470,136,25);
        
        Student_ID = new JLabel("Student_ID");
        Student_ID.setBounds(50, 370, 100, 20);
        Student_ID.setFont(fn18);
        Student_ID.setForeground(white);
        

        C_ID = new JLabel("C_ID");
        C_ID.setBounds(45, 470, 100, 20);
        C_ID.setFont(fn18);
        C_ID.setForeground(white);

        black_label1 = new JLabel("",black_image,JLabel.CENTER);
        black_label1.setBounds(10, 370, 170, 25);

        black_label3 = new JLabel("",black_image,JLabel.CENTER);
        black_label3.setBounds(10, 470, 170, 25);

        fn18 = new Font("Arial",Font.BOLD,18);
        
        fn14 = new Font("Arial",Font.BOLD,14);
        
        fn5 = new Font("Arial",Font.BOLD,5);

        label = new JLabel("", image,JLabel.CENTER);
        label.setSize(733, 540);

        this.setBounds(0, 0, 733, 575);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Modern Tech Collage(Enrollment DB)");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(Student_ID);
        this.add(C_ID);
        this.add(back);
        this.add(refresh);
        this.add(scroll);
        this.add(insert);
        this.add(delete);
        this.add(update);
        this.add(Student_ID_Input);
        this.add(C_ID_Input);
        this.add(black_label1);
        this.add(black_label3);
        this.add(search);
        this.add(label);
        
        doconnect();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==update){
    int studentID = Student_ID_Input.getText().isEmpty() ? 0 : Integer.parseInt(Student_ID_Input.getText());
    int courseID = C_ID_Input.getText().isEmpty() ? 0 : Integer.parseInt(C_ID_Input.getText());

    try {
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("SELECT * FROM Enrollment WHERE Student_ID = " + studentID);

        if (rs.next()) {
            if (studentID != 0) {
                rs.updateInt("Student_ID", studentID);
            }
            if (courseID != 0) {
                rs.updateInt("C_ID", courseID);
            }
            rs.updateRow();
            Student_ID_Input.setText("");
            C_ID_Input.setText("");
            JOptionPane.showMessageDialog(null, "Enrollment record updated successfully!");
            this.setVisible(false);
            Enrollment  ex = new Enrollment();
            ex.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Enrollment record with ID " + studentID + " does not exist.");
        }
        } catch (SQLException ex) {
            Logger.getLogger(Enrollment.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    
        Student_ID_Input.setText("");
        C_ID_Input.setText("");
        }
        else if(e.getSource()==delete){
            int id = Integer.parseInt(Student_ID_Input.getText());

        try {
            // create a DELETE statement and execute it
            String query = "DELETE FROM Enrollment WHERE (Student_ID =" + id + ")";
            stmt.executeUpdate(query);

            // remove the row from the table model
            int index = Table.getSelectedRow();
            if (index >= 0) {
                model.removeRow(index);
            }

            // clear the input fields
            Student_ID_Input.setText("");
            C_ID_Input.setText("");
            JOptionPane.showMessageDialog(null, "Enrollment record deleted successfully!");
            this.setVisible(false);
            Enrollment  ex = new Enrollment();
            ex.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        }
        else if (e.getSource()==insert){
        int Student_ID = Integer.parseInt(Student_ID_Input.getText());
        int C_ID = Integer.parseInt(C_ID_Input.getText());
        String query= "insert into Enrollment  values(" + Student_ID + "," + C_ID + ")";
        try{
            stmt.executeUpdate(query);
            model.addRow(new Object[]{Student_ID, C_ID});
            Student_ID_Input.setText("");
            C_ID_Input.setText("");
        }
        catch (SQLException ex){
            Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null,ex);
        }
        }
        else if (e.getSource()==refresh){
            this.setVisible(false);
            Enrollment  ex = new Enrollment();
            ex.setVisible(true);
        }
        else if (e.getSource()==back){
            this.setVisible(false);
            Main_Page m = new Main_Page();
            m.setVisible(true);
        }
        else if (e.getSource()==search){
            int searchValue = Integer.parseInt(Student_ID_Input.getText());
        if (searchValue == 0) {
            JOptionPane.showMessageDialog(this, "Please enter a search term");
            return;
        }
        try {
            String sql = "SELECT * FROM Enrollment WHERE Student_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, searchValue);
            ResultSet resultSet = statement.executeQuery();
            model.setRowCount(0);
            while (resultSet.next()) {

                int column2 = resultSet.getInt("Student_ID");
                int column3 = resultSet.getInt("C_ID");
                Object[] rowData = {column2, column3 };
                model.addRow(rowData);
            }
        } catch (Exception eo) {
            eo.printStackTrace();
        }
        Student_ID_Input.setText("");
        }
    }
}
