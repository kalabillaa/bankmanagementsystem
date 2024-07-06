import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;
public class balanceenquiry extends JFrame implements ActionListener{
    JButton backbutton;
    String pin;
    String cardno;
    JLabel blb;


    balanceenquiry(String pin,String cardno){

        this.pin=pin;
        this.cardno=cardno;

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(850, 600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,850,600);
        add(image);

        JLabel l1= new JLabel("YOUR BALANCE IS :");
        l1.setFont(new Font("system", Font.BOLD, 14));
        l1.setBounds(260,80,325,25);
        image.add(l1);

        backbutton= new JButton("BACK");
        backbutton.setBackground(new Color(160,210,190));
        backbutton.setFont(new Font("raleway",Font.BOLD,12));
        backbutton.setBounds(220,230,100,25);
        backbutton.addActionListener(this);
        image.add(backbutton);

        int balance=0;
        try{Conn c1= new Conn();
            ResultSet r= c1.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while(r.next()){
                if(r.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(r.getString("amount"));
                }
                else{balance-=Integer.parseInt(r.getString("amount"));}
            }
        }
        catch(Exception E){E.printStackTrace();}
        blb= new JLabel("RS."+balance);
        image.add(blb);
        blb.setBounds(325,150,100,30);
        blb.setForeground(Color.WHITE);

        setLayout(null);
        setBounds(400,200,850,600);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==backbutton){
                setVisible(false);
                new Main_class(pin, cardno);
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }
    public static void main(String args[]){
        new balanceenquiry("","");
    }
}
