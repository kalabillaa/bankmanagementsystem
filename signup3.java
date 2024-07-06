import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signup3 extends JFrame implements ActionListener{
    String formno="1000";
    JRadioButton savingaccount,currentaccount, fdaccount;
    JCheckBox atmcard, netbanking, mobilebanking, alert, chequebook, estatement, declaration;
    JButton submit,cancel;

    signup3(String formno) {
        super("form no:"+formno+" ");
        this.formno = formno;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/piggybank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 10, 100, 100);

        JLabel page3 = new JLabel("PAGE 3 Account details :");

        JLabel fno = new JLabel("FORM NO:"+formno);

        JPanel north = new JPanel();
        north.setLayout(new BorderLayout());
        north.setBackground(new Color(150,190,200));

        JPanel formNoPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        formNoPanel.setOpaque(false); // Transparent background
        formNoPanel.add(fno);

        north.add(image, BorderLayout.WEST);
        north.add(page3, BorderLayout.CENTER);
        north.add(formNoPanel, BorderLayout.EAST);

        JLabel acctype = new JLabel("ACCOUNT TYPE");

        savingaccount = new JRadioButton("SAVING ACCOUNT");
        fdaccount = new JRadioButton("FIXED DEPOSIT ACCOUNT");
        currentaccount = new JRadioButton("CURRENT ACCOUNT");

        savingaccount.setBackground(new Color(150,190,200));
        fdaccount.setBackground(new Color(150,190,200));
        currentaccount.setBackground(new Color(150,190,200));

        ButtonGroup bg = new ButtonGroup();
        bg.add(savingaccount);
        bg.add(fdaccount);
        bg.add(currentaccount);

        JPanel type = new JPanel();
        type.setBackground(new Color(150,190,200));
        type.add(savingaccount);
        type.add(fdaccount);
        type.add(currentaccount);

        JLabel cardno = new JLabel("CARD NUMBER :");

        JLabel cardans = new JLabel("XXXX-XXXX-XXXX-8402");

        JLabel pin = new JLabel("PIN :");
        JLabel anspin = new JLabel("X-X-X-X");

        JLabel service = new JLabel("SERVICES REQUIRED");

        atmcard = new JCheckBox("ATM CARD");
        netbanking = new JCheckBox("NET BANKING");
        mobilebanking = new JCheckBox("MOBILE BANKING");
        alert = new JCheckBox("EMAIL ALERTS");
        chequebook = new JCheckBox("CHEQUE BOOK");
        estatement = new JCheckBox("E-STATEMENT");

        atmcard.setBackground(new Color(150,190,200));
        netbanking.setBackground(new Color(150,190,200));
        mobilebanking.setBackground(new Color(150,190,200));
        alert.setBackground(new Color(150,190,200));
        chequebook.setBackground(new Color(150,190,200));
        estatement.setBackground(new Color(150,190,200));

        JPanel checkans = new JPanel();
        checkans.setBackground(new Color(150,190,200));
        checkans.add(atmcard);
        checkans.add(netbanking);
        checkans.add(mobilebanking);
        checkans.add(alert);
        checkans.add(chequebook);
        checkans.add(estatement);

        declaration = new JCheckBox("I hereby declare that the above information is correct to my knowledge", true);
        declaration.setBackground(new Color(150,190,200));
        declaration.setFont(new Font("raleway", Font.ITALIC, 12));

        JPanel centre = new JPanel();
        centre.setLayout(new GridBagLayout());
        centre.setBackground(new Color(150,190,200));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        centre.add(acctype, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        centre.add(type, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        centre.add(cardno, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        centre.add(cardans, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        centre.add(pin, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        centre.add(anspin, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        centre.add(service, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        centre.add(checkans, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        centre.add(declaration, gbc);

        submit = new JButton("SUBMIT");
        submit.setForeground(Color.white);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);

        cancel = new JButton("CANCEL");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);

        JPanel south = new JPanel();
        south.setLayout(new FlowLayout());
        south.add(submit);
        south.add(cancel);
        south.setBackground(new Color(150,190,200));

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        main.add(north, BorderLayout.NORTH);
        main.add(centre, BorderLayout.CENTER);
        main.add(south, BorderLayout.SOUTH);
        main.setBackground(new Color(150, 190, 200)); // Set the background color of the main panel
        main.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

        add(main);

        setBounds(400, 200, 850, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits correctly
    }
    @Override
    public void actionPerformed(ActionEvent e3) {
        String dacctype="";
        if(savingaccount.isSelected()){dacctype="savings account";}
        else if(currentaccount.isSelected()){dacctype="current account";}
        else if(fdaccount.isSelected()){dacctype="fd account";}
        Random ran = new Random();
        Long firstseven= Math.abs(ran.nextLong()%90000000)+1409963000000000L;
        String dcardno=""+firstseven;
        Long firstthree=Math.abs(ran.nextLong()%9000)+1000L;
        String dpin=""+firstthree;
        String dservices="";
        if(atmcard.isSelected()){dservices=dservices+"atm card ,";}
        if(netbanking.isSelected()){dservices=dservices+"net banking ,";}
        if(mobilebanking.isSelected()){dservices=dservices+"mobile banking ,";}
        if(alert.isSelected()){dservices=dservices+"SMS alerts ,";}
        if(chequebook.isSelected()){dservices=dservices+"cheque book ,";}
        if(estatement.isSelected()){dservices=dservices+"E-Statements ,";};

        try{
            if (e3.getSource() == submit) {
                if (dacctype.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please select account type");
                } else if (!declaration.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please select declaration before proceeding");
                } else {
                    Conn cc3 = new Conn();
                    String q1 = "INSERT INTO signup3 VALUES('" + formno + "','" + dacctype + "','" + dcardno + "','" + dpin + "','" + dservices + "')";
                    String q2 = "INSERT INTO login VALUES('" + formno + "','" + dcardno + "','" + dpin + "')";
                    cc3.statement.executeUpdate(q1);
                    cc3.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "CARD NO: " + dcardno + "\nPIN no: " + dpin);
                    new Deposit(dpin, dcardno);
                    setVisible(false);
                }
            }
            if (e3.getSource() == cancel) {
                System.exit(0);
            }
        }
        catch(Exception ee3){ee3.printStackTrace();}
    }

    public static void main(String args[]) {
        new signup3("");
    }
}

