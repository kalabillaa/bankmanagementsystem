import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class login extends JFrame implements ActionListener{
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JTextField jtf1;
    JPasswordField jpf1;
    JButton b1;
    JButton b2;
    JButton b3;    

    login(){
        super("hii welcome to bank login page ");
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/piggybank.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        label1 =new JLabel("welcome to the ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde",Font.BOLD,40));
        label1.setBounds(220,125,450,40);
        add(label1);

        label2 =new JLabel("Enter Card no.");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("AvantGarde",Font.ITALIC,28));
        label2.setBounds(150,190,375,30);
        add(label2);

        jtf1 = new JTextField(14);
        jtf1.setBounds(370,190,230,30);
        add(jtf1);
        

        label3 =new JLabel("Enter password");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("AvantGarde",Font.ITALIC,28));
        label3.setBounds(150,250,375,30);
        add(label3);

        jpf1= new JPasswordField(14);
        jpf1.setBounds(370,250,230,30);
        add(jpf1);

        ImageIcon bg= new ImageIcon(ClassLoader.getSystemResource("images/background.jpg"));
        Image bg2= bg.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon bg3=new ImageIcon(bg2);
        JLabel ibg= new JLabel(bg3);
        ibg.setBounds(0,0,850,480);
        add(ibg);

        b1= new JButton("sign in");
        b1.setFont(new Font("Arial",Font.BOLD,14));
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.setBounds(300,300,100,30);
        b1.addActionListener(this);
        add(b1);

        b2= new JButton("sign up");
        b2.setFont(new Font("Arial",Font.BOLD,14));
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.setBounds(425,300,100,30);
        b2.addActionListener(this);
        add(b2);

        b3= new JButton("clear");
        b3.setFont(new Font("Arial",Font.BOLD,14));
        b3.setForeground(Color.BLACK);
        b3.setBackground(Color.WHITE);
        b3.setBounds(300,350,225,30);
        b3.addActionListener(this);
        add(b3);

        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==b1){ Conn c1= new Conn();
            String cardno=jtf1.getText();

            char[] passwordChars = jpf1.getPassword();
            String pin = new String(passwordChars);
            String q="select * from login where card_no ='"+cardno+"' and pin ='"+pin+"'";
            ResultSet r=c1.statement.executeQuery(q);
            if(r.next()){
                setVisible(false);
                new Main_class(pin,cardno);
            }
            else{
                JOptionPane.showMessageDialog(null,"incorrect cardno/pin");
            }

            }
            else if(e.getSource()==b2){ new signup();setVisible(false);}
            else if(e.getSource()==b3){
            jtf1.setText("");
            jpf1.setText("");
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }
    public static void main (String args[]){
        new login();
    }
}
