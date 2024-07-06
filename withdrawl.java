import java.awt.*;
import javax.swing.*;
import java.sql.*;
//import com.mysql.cj.protocol.Resultset;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;

public class withdrawl extends JFrame implements ActionListener{
    String pin;
    String cardno;
    JTextField amount;
    JButton withdrawbutton,backbutton;
    
    withdrawl(String pin,String cardno){
        this.pin=pin;
        this.cardno=cardno;

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(850, 600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,850,600);
        add(image);

        JLabel l1= new JLabel("ENTER THE AMOUNT U WANT TO WITHDRAW");
        l1.setFont(new Font("system", Font.BOLD, 14));
        l1.setBounds(190,80,325,25);
        image.add(l1);

        amount= new JTextField();
        amount.setFont(new Font("raleway",Font.BOLD,12));
        amount.setBounds(220,110,250,25);
        amount.setBackground(new Color(160,210,190));
        image.add(amount);

        backbutton= new JButton("BACK");
        backbutton.setBackground(new Color(160,210,190));
        backbutton.setFont(new Font("raleway",Font.BOLD,12));
        backbutton.setBounds(220,230,100,25);
        backbutton.addActionListener(this);
        image.add(backbutton);

        withdrawbutton= new JButton("WITHDRAW");
        withdrawbutton.setBackground(new Color(160,210,190));
        withdrawbutton.setFont(new Font("raleway",Font.BOLD,12));
        withdrawbutton.setBounds(220,195,100,25);
        withdrawbutton.addActionListener(this);
        image.add(withdrawbutton);


        setLayout(null);
        setBounds(400,200,850,600);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==withdrawbutton){try{
            String damount= amount.getText();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = formatter.format(new Date());
            if(damount.equals("")){
                JOptionPane.showMessageDialog(null,"enter amount first");
            }
            else{
                Conn c1= new Conn();
                String q="select * from bank where pin ='"+pin+"'";
                int balance=0;
                ResultSet r=c1.statement.executeQuery(q);
                while(r.next()){
                    if(r.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(r.getString("amount"));
                    }
                    else{balance-=Integer.parseInt(r.getString("amount"));}
                }
                if(balance<Integer.parseInt(damount)){JOptionPane.showMessageDialog(null,"insufficient balance");return;}
                c1.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawl','"+damount+"')");
                JOptionPane.showMessageDialog(null,"RS. "+damount+" WITHDRAWL succesfully");
                setVisible(false);
                new Main_class(pin,cardno);
            }
        }
        catch(Exception E){
           E.printStackTrace(); 
        }}
        else if(e.getSource()==backbutton){
            setVisible(false);
            new Main_class(pin,cardno);
        }
    }
    
 public static void main(String[] args) {
    new withdrawl("","");
 }   
}
