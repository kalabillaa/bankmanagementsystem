
import java.sql.*;

public class Conn{
    public Statement statement;
    public Connection connection;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem","root","Ankit!@12");
            statement= connection.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
public static void main(String args[]){
    Conn con= new Conn();
}
}