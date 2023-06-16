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


public class Department extends javax.swing.JFrame implements ActionListener{
    public void main(String args[]){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Department().setVisible(true);
            }
        });
    }
    
    Connection con;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model;
    
    public void doconnect(){
        model = new DefaultTableModel();
        model.addColumn("D_Name");
        model.addColumn("Location");
        model.addColumn("Head_ID");
        Table.setModel(model);
        String port = Welcome_Page.port.getText();
        String path = "jdbc:sqlserver://localhost:" + port + ";databaseName=Modern_Tech_Collage_DB;encrypt=false"; 
        String usr = Welcome_Page.usr.getText() ;
        String pass = Welcome_Page.pass.getText();  
        try{
        con = DriverManager.getConnection(path,usr, pass);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from Department  ");
            while(rs.next()){
                model.addRow(new Object[]{ rs.getString("D_Name"), rs.getString("Location"),rs.getString("Head_ID")});
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
    JTextField D_Name_Input;
    JTextField Location_Input;
    JTextField Head_ID_Input;
    JLabel label;
    JLabel D_Name;
    JLabel Location;
    JLabel Head_ID;
    JLabel black_label;
    JLabel black_label1;
    JLabel black_label3;
    Font fn18;
    Font fn14;
    ImageIcon image;    
    ImageIcon black_image;
    ImageIcon refresh_icon;
    ImageIcon back_icon;
    JTable Table;
    JScrollPane scroll;
    
    Department(){
        String[] columnNames = {"D_Name", "Location","Head_ID"};
        String[][] data = {
            {null, null, null},
            {null, null, null},
            {null, null, null}
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
        
        D_Name_Input = new JTextField();
        D_Name_Input.setBounds(116,320,136,25);


        Location_Input = new JTextField();
        Location_Input.setBounds(116,410,136,25);
        
        Head_ID_Input = new JTextField();
        Head_ID_Input.setBounds(116,500,136,25);
        
        D_Name = new JLabel("D_Name");
        D_Name.setBounds(50, 320, 100, 25);
        D_Name.setFont(fn18);
        D_Name.setForeground(white);
        
        Location = new JLabel("Location");
        Location.setBounds(50, 410, 100, 20);
        Location.setFont(fn18);
        Location.setForeground(white);
        

        Head_ID = new JLabel("Instructor_ID");
        Head_ID.setBounds(45, 500, 100, 20);
        Head_ID.setFont(fn18);
        Head_ID.setForeground(white);

        black_label = new JLabel("",black_image,JLabel.CENTER);
        black_label.setBounds(10, 320, 170, 25);

        black_label1 = new JLabel("",black_image,JLabel.CENTER);
        black_label1.setBounds(10, 410, 170, 25);

        black_label3 = new JLabel("",black_image,JLabel.CENTER);
        black_label3.setBounds(10, 500, 170, 25);

        fn18 = new Font("Arial",Font.BOLD,18);
        
        fn14 = new Font("Arial",Font.BOLD,14);

        label = new JLabel("", image,JLabel.CENTER);
        label.setSize(733, 540);

        this.setBounds(0, 0, 733, 575);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Modern Tech Collage(Department DB)");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(D_Name);
        this.add(Location);
        this.add(Head_ID);
        this.add(back);
        this.add(refresh);
        this.add(scroll);
        this.add(insert);
        this.add(delete);
        this.add(update);
        this.add(D_Name_Input);
        this.add(Location_Input);
        this.add(Head_ID_Input);
        this.add(black_label);
        this.add(black_label1);
        this.add(black_label3);
        this.add(search);
        this.add(label);
        
        doconnect();
    }
    
    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == delete) {
        String id = D_Name_Input.getText();

        try {
            // create a DELETE statement and execute it
            String query = "DELETE FROM Department WHERE D_Name = '" + id + "'";
            stmt.executeUpdate(query);

            // remove the row from the table model
            int index = Table.getSelectedRow();
            if (index >= 0) {
                model.removeRow(index);
            }

            // clear the input fields
            D_Name_Input.setText("");
            Location_Input.setText("");
            Head_ID_Input.setText("");
            JOptionPane.showMessageDialog(null, "Department record deleted successfully!");
            this.setVisible(false);
            Department d = new Department();
            d.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error deleting department record: " + ex.getMessage());
        }
    } else if (e.getSource() == insert) {
        String Location = Location_Input.getText();
        String D_Name = D_Name_Input.getText();
        String Head_ID = Head_ID_Input.getText();
        String query = "INSERT INTO Department VALUES ('" + D_Name + "', '" + Location + "', '" + Head_ID + "')";
        try {
            stmt.executeUpdate(query);
            model.addRow(new Object[]{D_Name, Location, Head_ID});
            Location_Input.setText("");
            D_Name_Input.setText("");
            Head_ID_Input.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(Department.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error inserting department record: " + ex.getMessage());
        }
    } else if (e.getSource() == refresh) {
        this.setVisible(false);
        Department d = new Department();
        d.setVisible(true);
    } else if (e.getSource() == back) {
        this.setVisible(false);
        Main_Page m = new Main_Page();
        m.setVisible(true);
    } else if (e.getSource() == update) {
        String Location = Location_Input.getText();
        String D_Name = D_Name_Input.getText();
        String Head_ID = Head_ID_Input.getText();
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM Department WHERE D_Name = '" + D_Name + "'");

            if (rs.next()) {
                if (Location != null && !Location.equals("")) {
                    rs.updateString("Location", Location);
                }
                if (D_Name != null && !D_Name.equals("")) {
                    rs.updateString("D_Name", D_Name);
                }
                if (Head_ID != null && !Head_ID.equals("")) {
                    rs.updateString("Head_ID", Head_ID);
                }
                rs.updateRow();
                Location_Input.setText("");
                D_Name_Input.setText("");
                Head_ID_Input.setText("");
                JOptionPane.showMessageDialog(null, "Department record updated successfully!");
                this.setVisible(false);
                Department d = new Department();
                d.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Department record with ID " + D_Name + " does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Department.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error updating department record: " + ex.getMessage());
        }
        D_Name_Input.setText("");
        Location_Input.setText("");
        Head_ID_Input.setText("");
    } else if (e.getSource() == search) {
        String searchValue = D_Name_Input.getText();
        if (searchValue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a search term");
            return;
        }
       try {
    String sql = "SELECT * FROM Department WHERE D_Name = ?";
    PreparedStatement statement = con.prepareStatement(sql);
    statement.setString(1, searchValue);
    ResultSet resultSet = statement.executeQuery();
    DefaultTableModel model = (DefaultTableModel) Table.getModel();
    model.setRowCount(0);
    while (resultSet.next()) {
        String column1 = resultSet.getString("D_Name");
        String column2 = resultSet.getString("Location");
        int column3 = resultSet.getInt("Head_ID");
        Object[] rowData = {column1, column2, column3};
        model.addRow(rowData);
    }
} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error searching department record: " + ex.getMessage());
}
D_Name_Input.setText("");


    
}
}
}
