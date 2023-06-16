package modern_tech_collage ;

import static java.awt.Color.white;
import java.sql.Statement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Student extends javax.swing.JFrame implements ActionListener{
    public static void main(String args[]){
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Student().setVisible(true);
        });
    }
    
    Connection con;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model;
    
    public void doconnect(){
        model = new DefaultTableModel();
        model.addColumn("Student_ID");
        model.addColumn("F_Name");
        model.addColumn("L_Name");
        model.addColumn("Phone");
        Table.setModel(model);
        String port = Welcome_Page.port.getText();
        String path = "jdbc:sqlserver://localhost:" + port + ";databaseName=Modern_Tech_Collage_DB;encrypt=false"; 
        String usr = Welcome_Page.usr.getText() ;
        String pass = Welcome_Page.pass.getText();
        try{
            con = DriverManager.getConnection(path,usr, pass);
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery("select * from Student");
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt("Student_ID"),rs.getString("F_Name"),rs.getString("L_Name"),rs.getString("Phone")});
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
    JTextField F_Name_Input;
    JTextField L_Name_Input;
    JTextField Phone_Input;
    JLabel label;
    JLabel S_ID;
    JLabel F_N;
    JLabel L_N;
    JLabel P;
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
    
    @SuppressWarnings("empty-statement")
    public Student(){ 
        String[] columnNames = {"Student_ID", "F_Name", "L_Name","Phone"};
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

        Student_ID_Input = new JTextField();
        Student_ID_Input.setBounds(116,320,136,25);

        L_Name_Input = new JTextField();
        L_Name_Input.setBounds(116,450,136,25);

        F_Name_Input = new JTextField();
        F_Name_Input.setBounds(116,390,136,25);
        
        S_ID = new JLabel("Student_ID");
        S_ID.setBounds(50, 320, 100, 25);
        S_ID.setFont(fn14);
        S_ID.setForeground(white);
        
        F_N = new JLabel("F_Name");
        F_N.setBounds(50, 390, 100, 20);
        F_N.setFont(fn18);
        F_N.setForeground(white);
        
        L_N = new JLabel("L_Name");
        L_N.setBounds(50, 450, 100, 20);
        L_N.setFont(fn18);
        L_N.setForeground(white);

        P = new JLabel("Phone");
        P.setBounds(50, 500, 100, 20);
        P.setFont(fn18);
        P.setForeground(white);

        Phone_Input = new JTextField();
        Phone_Input.setBounds(116,500,136,25);

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
        this.setTitle("Modern Tech Collage(Student DB)");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(S_ID);
        this.add(F_N);
        this.add(L_N);
        this.add(P);
        this.add(back);
        this.add(refresh);
        this.add(scroll);
        this.add(insert);
        this.add(delete);
        this.add(update);
        this.add(Student_ID_Input);
        this.add(F_Name_Input);
        this.add(L_Name_Input);
        this.add(Phone_Input);
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
        if(e.getSource()==refresh){
        this.setVisible(false);
        Student s = new Student();
        s.setVisible(true);
        }
        else if (e.getSource()==insert){
        int Student_ID = Integer.parseInt(Student_ID_Input.getText());
        String F_Name = F_Name_Input.getText();
        String L_Name = L_Name_Input.getText();
        String Phone = Phone_Input.getText();
        String query= "insert into Student values(" + Student_ID + ",'" + F_Name + "','" + L_Name + "','" + Phone + "')";
        try{
            stmt.executeUpdate(query);
            model.addRow(new Object[]{Student_ID, F_Name, L_Name, Phone});
            Student_ID_Input.setText("");
            F_Name_Input.setText("");
            L_Name_Input.setText("");
            Phone_Input.setText("");
        }
        catch (SQLException ex){
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null,ex);
        }
        }
        else if (e.getSource()==back){
        this.setVisible(false);
        Main_Page m = new Main_Page();
        m.setVisible(true);
        }
        else if(e.getSource()==update){
            int Student_ID = Integer.parseInt(Student_ID_Input.getText());
        String F_Name = F_Name_Input.getText();
        String L_Name = L_Name_Input.getText() ;
        String Phone = Phone_Input.getText();

        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM Student WHERE Student_ID = " + Student_ID);

            if (rs.next()) {
                if (F_Name != null && !F_Name.equals("")) {
                    rs.updateString("F_Name", F_Name);
                }
                if (L_Name != null && !L_Name.equals("")) {
                    rs.updateString("L_Name", L_Name);
                }
                if (Phone != null && !Phone.equals("")) {
                    rs.updateString("Phone", Phone);
                }
                rs.updateRow();
                Student_ID_Input.setText("");
                F_Name_Input.setText("");
                L_Name_Input.setText("");
                Phone_Input.setText("");
                this.setVisible(false);
                Student s = new Student();
                s.setVisible(true);
                JOptionPane.showMessageDialog(null, "Student record updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Student record with ID " + Student_ID + " does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

        Student_ID_Input.setText("");
        F_Name_Input.setText("");
        L_Name_Input.setText("");
        Phone_Input.setText("");
        }
        else if (e.getSource()==delete){
            int id = Integer.parseInt(Student_ID_Input.getText());

        try {
        // create a DELETE statement and execute it
        String query = "DELETE FROM Student WHERE Student_ID=" + id;
        stmt.executeUpdate(query);

        // remove the row from the table model
        int index = Table.getSelectedRow();
        if (index >= 0) {
            model.removeRow(index);
        }

        // clear the input fields
        Student_ID_Input.setText("");
        F_Name_Input.setText("");
        L_Name_Input.setText("");
        Phone_Input.setText("");
        this.setVisible(false);
        Student s = new Student();
        s.setVisible(true);
        JOptionPane.showMessageDialog(null, "Student record deleted successfully!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        }
        else if(e.getSource()==search){
            String searchValue = Student_ID_Input.getText();
        if (searchValue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a search term");
            return;
        }
        try {
            String sql = "SELECT * FROM Student WHERE Student_ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, searchValue);
            ResultSet resultSet = statement.executeQuery();
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                int column1 = resultSet.getInt("Student_ID");
                String column2 = resultSet.getString("F_Name");
                String column3 = resultSet.getString("L_Name");
                String column4 = resultSet.getString("Phone");
                Object[] rowData = { column1, column2, column3, column4 };
                model.addRow(rowData);
            }
        }   catch (SQLException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
        Student_ID_Input.setText("");
        }
    }
}
    

