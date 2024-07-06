import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Main_class extends JFrame implements ActionListener{
    String pin,cardno;
    JButton depositButton,cashwithdrawButton,fastcashButton,ministatementButton,pinchangeButton,balanceenquiryButton,exiButton;
    Main_class(String pin,String cardno){
        this.pin=pin;
        this.cardno=cardno;

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(850, 600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,850,600);
        add(image);
        
        JLabel l1= new JLabel("ENTER THE TRANSACTION U WANT");
        l1.setFont(new Font("system", Font.BOLD, 14));
        l1.setBounds(210,80,325,25);
        image.add(l1);
        
        cashwithdrawButton= new JButton("CASH WITHDRAWL");
        cashwithdrawButton.setForeground(Color.WHITE);
        cashwithdrawButton.setBackground(new Color(160,210,190));
        cashwithdrawButton.setBounds(220,195,100,25);
        cashwithdrawButton.addActionListener(this);
        image.add(cashwithdrawButton);

        depositButton= new JButton("DEPOSIT");
        depositButton.setForeground(Color.WHITE);
        depositButton.setBackground(new Color(160,210,190));
        depositButton.setBounds(220,230,100,25);
        depositButton.addActionListener(this);
        image.add(depositButton);

        fastcashButton= new JButton("FAST CASH");
        fastcashButton.setForeground(Color.WHITE);
        fastcashButton.setBackground(new Color(160,210,190));
        fastcashButton.setBounds(220,265,100,25);
        fastcashButton.addActionListener(this);
        image.add(fastcashButton);

        ministatementButton= new JButton("MINI STATEMENT");
        ministatementButton.setForeground(Color.WHITE);
        ministatementButton.setBackground(new Color(160,210,190));
        ministatementButton.setBounds(220,300,100,25);
        ministatementButton.addActionListener(this);
        image.add(ministatementButton);

        pinchangeButton= new JButton("PIN CHANGE");
        pinchangeButton.setForeground(Color.WHITE);
        pinchangeButton.setBackground(new Color(160,210,190));
        pinchangeButton.setBounds(370,195,100,25);
        pinchangeButton.addActionListener(this);
        image.add(pinchangeButton);

        balanceenquiryButton= new JButton("BALANCE ENQUIRY");
        balanceenquiryButton.setForeground(Color.WHITE);
        balanceenquiryButton.setBackground(new Color(160,210,190));
        balanceenquiryButton.setBounds(370,230,100,25);
        balanceenquiryButton.addActionListener(this);
        image.add(balanceenquiryButton);

        exiButton= new JButton("EXIT");
        exiButton.setForeground(Color.WHITE);
        exiButton.setBackground(new Color(160,210,190));
        exiButton.setBounds(370,265,100,25);
        exiButton.addActionListener(this);
        image.add(exiButton);


        setLayout(null);
        setBounds(400,200,850,600);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==depositButton){
            new Deposit(pin,cardno);
        }
        else if(e.getSource()==exiButton){
            System.exit(0);
        }
        else if(e.getSource()==cashwithdrawButton){
            new withdrawl(pin, cardno);
            setVisible(false);
        }
        else if(e.getSource()==balanceenquiryButton){
            new balanceenquiry(pin, cardno);
            setVisible(false);
        }
        else if(e.getSource()==fastcashButton){
            new fastcash(pin, cardno);
            setVisible(false);
        }
        else if(e.getSource()==pinchangeButton){
            new changepin(pin, cardno);
            setVisible(false);
        }
        else if(e.getSource()==ministatementButton){
            new mini(pin,cardno);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Main_class("","");
    }
    
}
