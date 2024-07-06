import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Deposit extends JFrame implements ActionListener{
    String dpin;
    String dcardno;
    JTextField amount;
    JButton depositbutton,backbutton;
    Deposit(String dpin,String dcardno){
        super(dcardno);
        this.dpin=dpin;
        this.dcardno=dcardno;
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(850, 600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,850,600);
        add(image);

        JLabel l1= new JLabel("ENTER THE AMOUNT U WANT TO DEPOSIT");
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

        depositbutton= new JButton("DEPOSIT");
        depositbutton.setBackground(new Color(160,210,190));
        depositbutton.setFont(new Font("raleway",Font.BOLD,12));
        depositbutton.setBounds(220,195,100,25);
        depositbutton.addActionListener(this);
        image.add(depositbutton);


        setLayout(null);
        setBounds(400,200,850,600);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        String damount=amount.getText();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(new Date());
        if(e.getSource()==depositbutton){
            if(damount.equals("")){
                JOptionPane.showMessageDialog(null,"fill the amount first");
            }
            else{
                Conn c1= new Conn();
                String q="insert into bank values('"+dpin+"','"+date+"','Deposit','"+damount+"')";
                c1.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"RS. "+damount+" deposited succesfully");
                setVisible(false);
                new Main_class(dpin, dcardno);
            }
        }
        else if(e.getSource()==backbutton){
            setVisible(false);
            new Main_class(dpin, dcardno);
        }        
    }
        catch(Exception E){
            E.printStackTrace();
        }
        
    }
    public static void main(String args[]){
        new Deposit("", "");
    }
}
