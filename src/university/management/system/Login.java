package university.management.system;

import java.awt.*; //classes of labels, text fields
import java.awt.event.*; //event is subpackage (.* imports all classes not subpackages) , clicking submit performs some event
import javax.swing.*; //import actionPerformed function, addActionListener function
import java.sql.*; // all keywords of sql: update ,insert , select keyword

public class Login extends JFrame implements ActionListener{ //JFrame class(to make frame) present in swing package
                                                             // ActionListener(handles all eventes) interface present in event package 
    
    TextField t1,t2; //boxes in front of username, password
    Label l1,l2;    //username, password
    Button b3; //reset, submit, close
    GridBagLayout gbl;    //Layout
    GridBagConstraints gbc; 
    Font f1,f2; //font objects using font class
    
    public Login(){ //constructor (all frame coding inside constructor)
        super("Login for University");
        f1 = new Font("Courier",Font.ITALIC,30);
        f2 = new Font("Courier",Font.ITALIC,20);
		
        gbl=new GridBagLayout(); 
	gbc=new GridBagConstraints();
        setLayout(gbl); 
	
        l1 = new Label("Username");
        l1.setFont(f1);
	
        l2 = new Label("Password");
        l2.setFont(f1);

	
        t1 = new TextField(30); 
	t2 = new TextField(30); 
        t2.setEchoChar('*'); //should not be visible to user: whatever user types replace it with asterisk(*)
		
        b3 = new Button("Submit");
        b3.setFont(f2);
		
        gbc.gridx=0;
	gbc.gridy=0; 
        gbl.setConstraints(l1,gbc); //l1 --> username, gbc --> both co-ordinates(0,0)
	add(l1);
        
	gbc.gridx=2;
        gbc.gridy=0;
	gbl.setConstraints(t1,gbc); //t1 --> textfield, gbc --> both co-ordinates(2,0)
        add(t1);
		
	gbc.gridx=0;
        gbc.gridy=2;
	gbl.setConstraints(l2,gbc); //l2 --> password, gbc --> both co-ordinates(0,2)
        add(l2);

	gbc.gridx=2;
        gbc.gridy=2;
        gbl.setConstraints(t2,gbc); //t2 --> textfield, gbc --> both co-ordinates(2,2)
	add(t2);

        gbc.gridx=2;
	gbc.gridy=10;
        gbl.setConstraints(b3,gbc); //b3 --> submit, gbc --> both co-ordinates(2,10)
	add(b3);
        
        b3.addActionListener(this); //addActionListener: to perform action after clicking
                
        setVisible(true);   
        setSize(600,600); //(l,b)
        setLocation(400,200);  //(x,y) 
    }

    public void actionPerformed(ActionEvent ae){//override actionPerformed function
                                                 //actionEvent class differentiate which event is called
            // submit is clicked
            // fetch both values and store it in string
            // run a query (select *) matches the database
            // successfully login: then open next frame
            // otherwise: pop up invalid login

        if(ae.getSource()==b3){
            try{
                conn c1 = new conn(); // as we are working with database , make connection class object
                
                String s1 = t1.getText();
                String s2 = t2.getText();
            
                String str = "select * from login where username = '"+s1+"' and password = '"+s2+"'";
                ResultSet rs = c1.s.executeQuery(str);   //execute query using function executeQuery , c1--> conn class object, s-->statement interface
                //resultset stores query's result       //executeQuery for fetching (select)
                                                        //executeUpdate for updating (insert,delete)

                
                if(rs.next()){
                    new Mainframe();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid");
                    setVisible(false); 
                }
            
            }catch(Exception e){}
            
	}
    }        
   
    public static void main(String[] args){
            new Login();
    }
}
