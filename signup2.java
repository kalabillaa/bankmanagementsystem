import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class signup2 extends JFrame implements ActionListener{
    String formno;
    JComboBox<String> ansincomerange;
    JComboBox<String> ansreligion;
    JComboBox<String> anscatgory;
    JRadioButton e1, e2, s1, s2;
    JTextField ansaadhar, anspan;
    JButton next;

    public signup2(String formno) {
        super("Sign Up Form"+formno);
        this.formno = formno;
        setLayout(new BorderLayout());

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/piggybank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setHorizontalAlignment(JLabel.CENTER);
        add(image, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBackground(Color.LIGHT_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel page2 = new JLabel("Fill Your Other Details");
        page2.setFont(new Font("Raleway", Font.BOLD, 30));
        page2.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(page2, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel incomerange = new JLabel("INCOME RANGE:");
        incomerange.setFont(new Font("Raleway", Font.BOLD, 20));
        formPanel.add(incomerange, gbc);

        gbc.gridx = 1;
        String[] ir = {"Less than 100,000", "100,000-500,000", "500,000+"};
        ansincomerange = new JComboBox<>(ir);
        formPanel.add(ansincomerange, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel religion = new JLabel("RELIGION:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        formPanel.add(religion, gbc);

        gbc.gridx = 1;
        String[] re = {"Hindu", "Muslim", "Sikh", "Christian"};
        ansreligion = new JComboBox<>(re);
        formPanel.add(ansreligion, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel category = new JLabel("CATEGORY:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        formPanel.add(category, gbc);

        gbc.gridx = 1;
        String[] cat = {"Gen", "SC", "ST"};
        anscatgory = new JComboBox<>(cat);
        formPanel.add(anscatgory, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel existing = new JLabel("ARE YOU EXISTING CITIZEN:");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        formPanel.add(existing, gbc);

        gbc.gridx = 1;
        JPanel pe = new JPanel();
        e1 = new JRadioButton("Yes");
        e2 = new JRadioButton("No");
        pe.add(e1);
        pe.add(e2);
        ButtonGroup bge = new ButtonGroup();
        bge.add(e1);
        bge.add(e2);
        formPanel.add(pe, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel senior = new JLabel("ARE YOU A SENIOR CITIZEN:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        formPanel.add(senior, gbc);

        gbc.gridx = 1;
        JPanel ps = new JPanel();
        s1 = new JRadioButton("Yes");
        s2 = new JRadioButton("No");
        ps.add(s1);
        ps.add(s2);
        ButtonGroup bgs = new ButtonGroup();
        bgs.add(s1);
        bgs.add(s2);
        formPanel.add(ps, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel aadhar = new JLabel("AADHAR NO:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        formPanel.add(aadhar, gbc);

        gbc.gridx = 1;
        ansaadhar = new JTextField();
        ansaadhar.setFont(new Font("Raleway", Font.PLAIN, 20));
        formPanel.add(ansaadhar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        JLabel pan = new JLabel("PAN NO:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        formPanel.add(pan, gbc);

        gbc.gridx = 1;
        anspan = new JTextField();
        anspan.setFont(new Font("Raleway", Font.PLAIN, 20));
        formPanel.add(anspan, gbc);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        next = new JButton("NEXT ->");
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFocusPainted(false);
        next.setBorderPainted(false);
        next.setContentAreaFilled(true);
        next.setOpaque(true);
        next.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        next.addActionListener(this);
        buttonPanel.add(next);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(850, 600);
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String dincomerange=(String)ansincomerange.getSelectedItem();
        String dreligion=(String)ansreligion.getSelectedItem();
        String dcategory=(String)anscatgory.getSelectedItem();
        String dexisting="";
        if(e1.isSelected()){dexisting="yes";}
        else if(e2.isSelected()){dexisting="no";}
        String dsenior="";
        if(s1.isSelected()){dsenior="yes";}
        else if(s2.isSelected()){dsenior="no";}
        String daadhar=ansaadhar.getText();
        String dpan=anspan.getText();
        try{
            if(dincomerange == null || dreligion == null || dcategory == null ||
            dexisting == null || dexisting.equals("") ||
            dsenior == null || dsenior.equals("") ||
            daadhar == null || daadhar.isEmpty() ||
            dpan == null || dpan.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);

            }
            else{
                Conn cc2= new Conn();
                String q= new String("insert into signup2 values('"+formno+"','"+dincomerange+"','"+dreligion+"','"+dcategory+"','"+dexisting+"','"+dsenior+"','"+daadhar+"','"+dpan+"')");
                cc2.statement.executeUpdate(q);
                new signup3(formno);
                setVisible(false);
            }
        }
        catch(Exception ee2){
            ee2.printStackTrace();
        }
        
        
    }

    public static void main(String[] args) {
        new signup2("Form Number");
    }
}


/*import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.Image;

public class signup2 extends JFrame implements ActionListener{
        String formno;
        JComboBox ansincomerange;
        JComboBox ansreligion;
        JComboBox anscatgory;
        JButton e1,e2,s1,s2;
        JTextField ansaadhar,anspan;
        JButton next;

    public signup2(String first){
        super(first);
        this.formno=formno;

        JPanel main= new JPanel();
        main.setLayout(new BorderLayout());

        JLabel fno= new JLabel(formno);
        fno.setFont(new Font("raleway",Font.BOLD,20));
        add(fno);
        
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/piggybank.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(450,10,100,100);
        main.add(image,BorderLayout.NORTH);
        

        JLabel page2= new JLabel("fill your other details");
        page2.setFont(new Font("raleway",Font.BOLD,30));
        main.add(page2,BorderLayout.CENTER);

        JLabel incomerange= new JLabel("INCOME RANGE :");
        incomerange.setFont(new Font("raleway",Font.BOLD,20));

        String ir[]={"less than 100000","100000-500000","500000+"};
        ansincomerange= new JComboBox(ir);

        JLabel religion= new JLabel("RELIGION");
        religion.setFont(new Font("raleway",Font.BOLD,20));

        String re[]= {"hindu","muslim","sikh","christian"};
        ansreligion= new JComboBox(re);

        JLabel category= new JLabel("CATEGORY");
        category.setFont(new Font("raleway",Font.BOLD,20));

        String cat[]= {"gen","SC","ST"};
        anscatgory= new JComboBox(cat);

        JLabel existing= new JLabel("ARE U EXISTING CITIZEN :");
        existing.setFont(new Font("raleway",Font.BOLD,20));

        JLabel senior= new JLabel("ARE U SENIOR CITIZEN :");
        senior.setFont(new Font("raleway",Font.BOLD,20));

        e1= new JButton("yes");
        e2= new JButton("no");

        s1= new JButton("yes");
        s2= new JButton("no");
        
        JLabel aadhar = new JLabel("AADHAR NO :");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));

        ansaadhar= new JTextField();
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
                
        JLabel pan = new JLabel("PAN NO :");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        
        anspan= new JTextField();
        anspan.setFont(new Font("Raleway", Font.BOLD, 20));


        JPanel pe= new JPanel();
        pe.add(e1);
        pe.add(e2);

        ButtonGroup bge= new ButtonGroup();
        bge.add(e1);
        bge.add(e2);

        ButtonGroup bgs= new ButtonGroup();
        bgs.add(s1);
        bgs.add(s2);

        JPanel ps= new JPanel();
        ps.add(s1);
        ps.add(s2);

        JPanel p2= new JPanel();
        p2.setBounds(400,350,200,200);
        p2.setLayout(new GridLayout(7,2,0,10));
        p2.add(incomerange);
        p2.add(ansincomerange);
        p2.add(religion);
        p2.add(ansreligion);
        p2.add(category);
        p2.add(anscatgory);
        p2.add(existing);
        p2.add(pe);
        p2.add(senior);
        p2.add(ps);
        p2.add(aadhar);
        p2.add(ansaadhar);
        p2.add(pan);
        p2.add(anspan);
        p2.setBackground(Color.LIGHT_GRAY);
        main.add(p2,BorderLayout.SOUTH);
        add(main);
        next= new JButton("NEXT->");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(300,200,100,40);
        add(next);
        setSize(500,500);
        setLocation(400,200);
        setVisible(true);
    }
        @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    public static void main(String[] args) {
        new signup2("");
    }
}
*/