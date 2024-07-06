import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class mini extends JFrame implements ActionListener{
    String pin;
    String cardno;
    JButton button;
    mini(String pin,String cardno){
        this.pin=pin;
        this.cardno=cardno;
        JLabel label1= new JLabel();
        label1.setBounds(20,140,400,200);
        add(label1);

        JLabel label2= new JLabel("PIGGY BANK");
        label2.setFont(new Font("system",Font.BOLD,15));
        label2.setBounds(150,20,200,20);
        add(label2);

        JLabel label3= new JLabel();
        label3.setBounds(20,80,300,20);
        add(label3);

        JLabel label4= new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);

        try{
            Conn c1= new Conn();
            ResultSet r=c1.statement.executeQuery("select * from login where pin = '"+pin+"'");
            while(r.next()){
                label3.setText("CARD NUMBER : "+ r.getString("card_no").substring(0,4)+"XXXXXXXX"+r.getString("card_no").substring(12));
            }
        }
        catch(Exception e){e.printStackTrace();}
        try{int balance=0;
        Conn c1= new Conn();
        ResultSet r=c1.statement.executeQuery("select * from bank where pin='"+pin+"'");
            while(r.next()){
                label1.setText(label1.getText()+"<html>"+r.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+r.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+r.getString("amount")+"<br><br><html>");
                if(r.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(r.getString("amount"));
                }
                else{
                    balance-=Integer.parseInt(r.getString("amount")); 
                }
            }
            label4.setText("Your Total Balance is RS. "+balance);
            
    }
        catch(Exception e){e.printStackTrace();}

        button= new JButton("EXIT");
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        add(button);


        getContentPane().setBackground(new Color(200,250, 204));
        setBounds(20,20,400,600);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    public static void main(String[] args) {
        new mini("","");
    }    
}
