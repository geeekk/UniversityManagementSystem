package university.management.system;

import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Add_Student extends JFrame{

    
	JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;

        public Add_Student(){

            setTitle("ADD STUDENT DETAILS");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            getContentPane().setLayout(null);
			
            JButton Next = new JButton("SAVE");
            Next.setBounds(200, 420, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            add(Next);
			
            JLabel Enrno = new JLabel("ENROLLMENT NO");
            Enrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Enrno.setBounds(60, 120, 150, 27);
            add(Enrno);
			
            textField_1 = new JTextField();
            textField_1.setBounds(200, 120, 150, 27);
            add(textField_1);
            
            JLabel Course = new JLabel("COURSE");
            Course.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Course.setBounds(60, 200, 150, 27);
            add(Course);
			
            textField_2 = new JTextField();
            textField_2.setBounds(200, 200, 150, 27);
            add(textField_2);
	
            JLabel Name = new JLabel("NAME");
            Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Name.setBounds(60, 270, 150, 27);
            add(Name);
	
            textField_4 = new JTextField();
            textField_4.setBounds(200, 270, 150, 27);
            add(textField_4);
	
            JLabel Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Gender.setBounds(60, 320, 150, 27);
            add(Gender);
		
            JRadioButton NewRadioButton = new JRadioButton("MALE");
            NewRadioButton.setBackground(Color.WHITE);
            NewRadioButton.setBounds(200, 320, 70, 27);
            add(NewRadioButton);
	
            JRadioButton Female = new JRadioButton("FEMALE");
            Female.setBackground(Color.WHITE);
            Female.setBounds(280, 320, 70, 27);
            add(Female);
            
            JLabel Phno = new JLabel("PH NO");
            Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Phno.setBounds(60, 370, 150, 27);
            add(Phno);
			
            textField_5 = new JTextField();
            textField_5.setBounds(200, 370, 150, 27);
            add(textField_5);
	
            setVisible(true);
	
            JLabel AddStudent = new JLabel("ADD STUDENT DETAILS");
            AddStudent.setForeground(Color.RED);
            AddStudent.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddStudent.setBounds(60, 24, 442, 35);
            add(AddStudent);

            
            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String enr_no = textField_1.getText();
                    String course =  textField_2.getText();
                    String name = textField_4.getText();
                   
                    String gender = null;
                    String ph_no = textField_5.getText();
                    
                    if(NewRadioButton.isSelected()){
                        gender = "male";
                    
                    }else if(Female.isSelected()){
                        gender = "female";
                    }
                    
                    try {
                        conn c = new conn();
                        String str = "INSERT INTO student values( '"+enr_no+"', '"+course+"','"+name+"', '"+gender+"', '"+ph_no+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Student Added");
                        setVisible(false);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}
            });
			
            setSize(500,600);
            setVisible(true);
            setLocation(600,200);
			
	}
        
    public static void main(String[] args){
        new Add_Student();
    }   
}