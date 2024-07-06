import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class changepin extends JFrame implements ActionListener{
    String pin;
    String cardno;
    JTextField newpin;
    JButton changepinButton,backbutton;

    changepin(String pin,String cardno){
        this.cardno=cardno;
        this.pin=pin;

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(850, 600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,850,600);
        add(image);

        JLabel l1= new JLabel("ENTER THE NEW PIN");
        l1.setFont(new Font("system", Font.BOLD, 14));
        l1.setBounds(270,80,325,25);
        image.add(l1);

        newpin= new JTextField();
        newpin.setFont(new Font("raleway",Font.BOLD,12));
        newpin.setBounds(220,110,250,25);
        newpin.setBackground(new Color(160,210,190));
        image.add(newpin);

        changepinButton= new JButton("CHANGE PIN");
        changepinButton.setBackground(new Color(160,210,190));
        changepinButton.setFont(new Font("raleway",Font.BOLD,12));
        changepinButton.setBounds(220,195,100,25);
        changepinButton.addActionListener(this);
        image.add(changepinButton);

        backbutton= new JButton("BACK");
        backbutton.setBackground(new Color(160,210,190));
        backbutton.setFont(new Font("raleway",Font.BOLD,12));
        backbutton.setBounds(220,230,100,25);
        backbutton.addActionListener(this);
        image.add(backbutton);


        setLayout(null);
        setBounds(400,200,850,600);
        setVisible(true);
        
    }    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String np= newpin.getText();
            if(e.getSource()==changepinButton){System.out.println("Change PIN button clicked");if(np.equals("")){JOptionPane.showMessageDialog(null,"ENTER PIN FIRST");}
            
            else{Conn c1= new Conn();
                String q1="update bank set pin = '"+np+"' where pin = '"+pin+"'";
                String q2="update login set pin = '"+np+"' where pin = '"+pin+"'";
                String q3="update signup3 set pin = '"+np+"' where pin = '"+pin+"'";
                
            c1.statement.executeUpdate(q1);
            c1.statement.executeUpdate(q2);
            c1.statement.executeUpdate(q3);

            JOptionPane.showMessageDialog(null,"PIN CHANGED SUCCESSFULLY");
            setVisible(false);
            new Main_class(np,cardno);
            }
        }
        else if(e.getSource()==backbutton){
            setVisible(false);
            new Main_class(pin,cardno);
        }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        new changepin("", "");
    }
}
