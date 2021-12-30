//Function of this class: attach database to project
//Register mysql drivers
//Give address where mysql is present

package university.management.system;

import java.sql.*;   //sql package: all commands of sql are present in it 

public class conn{
    Connection c; //connection setup with database
    Statement s; // all queries are executed through statement
    public conn(){   //constructor
        //register mysql drivers: only once using method class.forname
        try{  
            Class.forName("com.mysql.jdbc.Driver");    //driver of mysql: com.mysql.jdbc.Driver
            c = DriverManager.getConnection("jdbc:mysql:///project","root","00815602719@Mansi");    //creating connection , 
                                                                            //in brackets : connection url = database name + root + password

            s =c.createStatement();  //statement create
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  