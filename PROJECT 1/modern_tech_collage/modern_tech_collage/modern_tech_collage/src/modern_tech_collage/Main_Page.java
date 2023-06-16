package modern_tech_collage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Main_Page extends javax.swing.JFrame implements ActionListener{
    JButton student = new JButton();
    JButton instructor = new JButton();
    JButton courses = new JButton();
    JButton department = new JButton();
    JButton enrollment  = new JButton();
    JButton logout  = new JButton("Logout");
    ImageIcon image_student = new ImageIcon("student.png");
    ImageIcon image_instructor = new ImageIcon("instructor.png");
    ImageIcon image_courses = new ImageIcon("courses.png");
    ImageIcon image_department = new ImageIcon("department.png");
    ImageIcon image_enrollment = new ImageIcon("enrollment.png");
    ImageIcon image_Main_TECH = new ImageIcon("Main_TECH.png");
    JLabel mylabel;
    JLabel mylabel1;
    
    
    Main_Page(){    
        Font fn = new Font("Arial",Font.BOLD,20);        
        mylabel = new JLabel("", image_Main_TECH,JLabel.CENTER);
        mylabel.setBounds(0, 0, 733, 540);
        
        mylabel1 = new JLabel("Choose One From Those DatabBases");
        mylabel1.setBounds(170, 10, 400, 100);
        mylabel1.setFont(fn);
        mylabel1.setForeground(Color.black);
        mylabel.add(mylabel1);
        
        student.setBounds(603,220,100,100);
        student.setFocusable(false);
        student.setIcon(image_student);
        
        student.addActionListener(this);
        student.setBackground(Color.white);
        
        instructor.setBounds(316,220,100,100);
        instructor.setFocusable(false);
        instructor.setIcon(image_instructor);
        
        instructor.addActionListener(this);
        instructor.setBackground(Color.white);
        
        courses.setBounds(463,220,100,100);
        courses.setFocusable(false);
        courses.setIcon(image_courses);
        
        courses.addActionListener(this);
        courses.setBackground(Color.white);

        department.setBounds(170,220,100,100);
        department.setFocusable(false);
        department.setIcon(image_department);
        
        department.addActionListener(this);
        department.setBackground(Color.white);
        
        enrollment.setBounds(20,220,100,100);
        enrollment.setFocusable(false);
        enrollment.setIcon(image_enrollment);
     
        enrollment.addActionListener(this);
        enrollment.setBackground(Color.white);
        
        logout.setBounds(600,30,100,40);
        logout.setFocusable(false);
        logout.addActionListener(this);
        
        this.setTitle("Modern Tech Collage DB");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0,0,733,540);
        this.setSize(733,540);
        this.setLayout(null);
        this.setResizable(false);
        this.add(student);
        this.add(instructor);
        this.add(courses);
        this.add(department);
        this.add(enrollment);
        this.add(logout);
        this.add(mylabel);
        this.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent a) {
         if(a.getSource()==student){
            Student s = new Student();
            s.setVisible(true);
            this.setVisible(false);
        }  
         else if (a.getSource()==instructor){
             try {
                 this.setVisible(false);
                 Instructor i = new Instructor();
                 i.setVisible(true);
             } catch (SQLException ex) {
                 Logger.getLogger(Main_Page.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         else if(a.getSource()==courses){
             this.setVisible(false);
             Course c;
             try {
                 c = new Course();
                 c.setVisible(true);
             } catch (SQLException ex) {
                 Logger.getLogger(Main_Page.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         else if(a.getSource()==department){
             this.setVisible(false);
             Department d = new Department();
             d.setVisible(true);
         }
         else if(a.getSource()==enrollment){
             this.setVisible(false);
             Enrollment e = new Enrollment();
             e.setVisible(true);
         }
         else if (a.getSource()==logout){
             this.setVisible(false);
             Welcome_Page w =new Welcome_Page();
             w.setVisible(true);
         }
    }
}
