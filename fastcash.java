import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;

public class fastcash extends JFrame implements ActionListener{
    String pin;
    String cardno;
    JButton hundredButton,fivehundredButton,thousandButton,twothousandButton,fivethousandButton,tenthousandButton,backButton;
    fastcash(String pin,String cardno){
        this.pin=pin;
        this.cardno=cardno;
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(850, 600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,850,600);
        add(image);
        
        JLabel l1= new JLabel("ENTER THE AMOUNT U WANT");
        l1.setFont(new Font("system", Font.BOLD, 14));
        l1.setBounds(210,80,325,25);
        image.add(l1);
        
        hundredButton= new JButton("RS. 100");
        hundredButton.setForeground(Color.WHITE);
        hundredButton.setBackground(new Color(160,210,190));
        hundredButton.setBounds(220,195,100,25);
        hundredButton.addActionListener(this);
        image.add(hundredButton);

        fivehundredButton= new JButton("RS. 500");
        fivehundredButton.setForeground(Color.WHITE);
        fivehundredButton.setBackground(new Color(160,210,190));
        fivehundredButton.setBounds(220,230,100,25);
        fivehundredButton.addActionListener(this);
        image.add(fivehundredButton);

        thousandButton= new JButton("RS. 1000");
        thousandButton.setForeground(Color.WHITE);
        thousandButton.setBackground(new Color(160,210,190));
        thousandButton.setBounds(220,265,100,25);
        thousandButton.addActionListener(this);
        image.add(thousandButton);

        twothousandButton= new JButton("RS. 2000");
        twothousandButton.setForeground(Color.WHITE);
        twothousandButton.setBackground(new Color(160,210,190));
        twothousandButton.setBounds(220,300,100,25);
        twothousandButton.addActionListener(this);
        image.add(twothousandButton);

        fivethousandButton= new JButton("RS. 5000");
        fivethousandButton.setForeground(Color.WHITE);
        fivethousandButton.setBackground(new Color(160,210,190));
        fivethousandButton.setBounds(370,195,100,25);
        fivethousandButton.addActionListener(this);
        image.add(fivethousandButton);

        tenthousandButton= new JButton("RS. 10000");
        tenthousandButton.setForeground(Color.WHITE);
        tenthousandButton.setBackground(new Color(160,210,190));
        tenthousandButton.setBounds(370,230,100,25);
        tenthousandButton.addActionListener(this);
        image.add(tenthousandButton);

        backButton= new JButton("BACK");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(160,210,190));
        backButton.setBounds(370,265,100,25);
        backButton.addActionListener(this);
        image.add(backButton);


        setLayout(null);
        setBounds(400,200,850,600);
        setVisible(true);

    }

@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource()==backButton){
        setVisible(false);
        new Main_class(pin, cardno);
    }
    else{
        String amount=((JButton)e.getSource()).getText().substring(4);
        Conn c1= new Conn();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(new Date());
        try{
            ResultSet r=c1.statement.executeQuery("select * from bank where pin='"+pin+"'");
            int balance= 0;
            while(r.next()){
                if(r.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(r.getString("amount"));
                }
                else{
                    balance-=Integer.parseInt(r.getString("amount")); 
                }
            }
            if(e.getSource()!=backButton && balance<Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null,"Insufficient balance");return;
            }
            else{
                c1.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawl','"+amount+"')");
                JOptionPane.showMessageDialog(null,"RS. "+amount+" WITHDRAWN");
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        setVisible(false);
        new Main_class(pin,cardno);

    }
}    
public static void main(String[] args) {
        new fastcash("","");
    }
}
