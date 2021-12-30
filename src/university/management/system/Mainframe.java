package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Mainframe extends JFrame{
    Button b2,b3,b4;
    Font f1;
    public static void main(String[] args) {
        new Mainframe().setVisible(true);
    }
    
    public Mainframe() {
        super("UNIVERSITY MANAGEMENT SYSTEM");
        f1 = new Font("Courier",Font.ITALIC,20);
	b2 = new Button("Add Student");
        b2.setFont(f1);
        
        setLayout(null); 
        
        b2.setBounds(90, 100, 200, 100); 
	add(b2);
        
	b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Add_Student();
		} catch (Exception e) {
                    e.printStackTrace();
		} 
            }
	});
		
        setSize(400,400);
        setLocation(400,200);  
	setVisible(true);
    }
}
