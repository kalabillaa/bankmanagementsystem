import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class signup extends JFrame implements ActionListener {
    private JButton nextButton;
    private JTextField nameField, mobileField, salaryField, fatherNameField, addressField;
    private JDateChooser dobField;
    private JRadioButton maleRadio, femaleRadio;
    private Random rand = new Random();
    private int appNumber = rand.nextInt(9000) + 1000;
    private String formNumber = " " + appNumber;

    public signup() {
        super("Application Form");

        setLayout(null);

        // Header Section
        JLabel imageLabel = createImageLabel();
        imageLabel.setBounds(350, 10, 100, 100);
        add(imageLabel);

        JLabel titleLabel = new JLabel("Page 1: Personal Details");
        titleLabel.setBounds(100, 50, 300, 40);
        titleLabel.setFont(new Font("Raleway", Font.ITALIC, 20));
        add(titleLabel);

        JLabel appNumberLabel = new JLabel("Application No.: " + formNumber);
        appNumberLabel.setBounds(600, 5, 300, 40);
        appNumberLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        add(appNumberLabel);

        // Form Fields Section
        JPanel formPanel = createFormPanel();
        formPanel.setBounds(50, 150, 750, 300);
        add(formPanel);

        // Next Button
        nextButton = new JButton("NEXT ->");
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.setBounds(600, 500, 200, 40);
        nextButton.addActionListener(this);
        add(nextButton);

        // Frame settings
        getContentPane().setBackground(new Color(222, 255, 240));
        setSize(850, 600);
        setLocation(450, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JLabel createImageLabel() {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/piggybank.jpg"));
        Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        return new JLabel(new ImageIcon(img));
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY);

        // Labels
        JLabel nameLabel = createLabel("Name:");
        JLabel mobileLabel = createLabel("Mobile No.:");
        JLabel salaryLabel = createLabel("Salary:");
        JLabel fatherNameLabel = createLabel("Father Name:");
        JLabel dobLabel = createLabel("D.O.B:");
        JLabel addressLabel = createLabel("Address:");
        JLabel sexLabel = createLabel("Sex:");

        // Input Fields
        nameField = new JTextField();
        mobileField = new JTextField();
        salaryField = new JTextField();
        fatherNameField = new JTextField();
        dobField = new JDateChooser();
        dobField.setForeground(Color.WHITE);
        addressField = new JTextField();

        // Gender Radio Buttons
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);

        // Add components to panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(mobileLabel);
        panel.add(mobileField);
        panel.add(salaryLabel);
        panel.add(salaryField);
        panel.add(fatherNameLabel);
        panel.add(fatherNameField);
        panel.add(dobLabel);
        panel.add(dobField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(sexLabel);
        panel.add(genderPanel);

        return panel;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Raleway", Font.BOLD, 18));
        label.setForeground(Color.BLACK);
        return label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formNo = formNumber.trim();
        String name = nameField.getText();
        String mobile = mobileField.getText();
        String salary = salaryField.getText();
        String fatherName = fatherNameField.getText();
        String dob = ((JTextField) dobField.getDateEditor().getUiComponent()).getText();
        String gender = maleRadio.isSelected() ? "Male" : femaleRadio.isSelected() ? "Female" : null;
        String address = addressField.getText();

        if (name.isEmpty() || mobile.isEmpty() || salary.isEmpty() || fatherName.isEmpty() || dob.isEmpty() || gender == null || address.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
        } else {
            try {
                Conn con = new Conn();
                String query = "INSERT INTO signup1 VALUES('" + formNo + "', '" + name + "', '" + mobile + "', '" + salary + "', '" + fatherName + "', '" + dob + "', '" + gender + "', '" + address + "')";
                con.statement.executeUpdate(query);
                new signup2(formNumber);
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new signup();
    }
}

/*import java.util.Calendar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.chrono.JapaneseDate;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import java.util.*;

public class signup extends JFrame implements ActionListener{
        JButton nextb;
        JTextField ansname;
        JTextField ansmno;
        JTextField anssalary;
        JTextField ansfname;
        JDateChooser ansdob;
        JTextField ansaddr;
        JRadioButton r1,r2;
        Random rand= new Random();
        int ano=rand.nextInt()%9000+1000;
        String first=" "+Math.abs(ano);
    signup(){
        super("application form");
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/piggybank.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        JLabel label2= new JLabel("page1 : personal details");
        label2.setBounds(100,50,300,40);
        label2.setFont(new Font("raleway",Font.ITALIC,20));
        add(label2);
        
        JLabel name= new JLabel("NAME :");
        name.setFont(new Font("raleway",Font.BOLD,18));
        name.setForeground(Color.BLACK);

        JLabel fname= new JLabel("FATHER NAME :");
        fname.setFont(new Font("raleway",Font.BOLD,18));
        fname.setForeground(Color.BLACK);

        JLabel salary= new JLabel("SALARY :");
        salary.setFont(new Font("raleway",Font.BOLD,18));
        salary.setForeground(Color.BLACK);
        
        JLabel dob= new JLabel("D.O.B :");
        dob.setFont(new Font("raleway",Font.BOLD,18));
        dob.setForeground(Color.BLACK);
        
        JLabel mno= new JLabel("MOBILE NO. :");
        mno.setFont(new Font("raleway",Font.BOLD,18));
        mno.setForeground(Color.BLACK); 

        JLabel addr= new JLabel("ADDRESS :");
        addr.setFont(new Font("raleway",Font.BOLD,18));
        addr.setForeground(Color.BLACK);
        
        JLabel sex= new JLabel("SEX :");
        sex.setFont(new Font("raleway",Font.BOLD,18));
        sex.setForeground(Color.BLACK); 

        ansname=new JTextField();
        ansname.setFont(new Font("raleway",Font.BOLD,18));

        ansmno=new JTextField();
        ansmno.setFont(new Font("raleway",Font.BOLD,18));

        anssalary=new JTextField();
        anssalary.setFont(new Font("raleway",Font.BOLD,18));

        ansfname=new JTextField();
        ansfname.setFont(new Font("raleway",Font.BOLD,18));

        ansdob=new JDateChooser();
        ansdob.setForeground(Color.WHITE);

        ansaddr=new JTextField();
        ansaddr.setFont(new Font("raleway",Font.BOLD,18));

        r1= new JRadioButton("male");
        r2= new JRadioButton("female");
        ButtonGroup bgrp= new ButtonGroup();
        bgrp.add(r1);
        bgrp.add(r2);

        JPanel sexpanel= new JPanel();
        sexpanel.add(r1);
        sexpanel.add(r2);

        Panel table= new Panel();
        table.setLayout(new GridLayout(7,2,1,0));
        table.add(name);
        table.add(ansname);
        table.add(mno);
        table.add(ansmno);
        table.add(salary);
        table.add(anssalary);
        table.add(fname);
        table.add(ansfname);
        table.add(dob);
        table.add(ansdob);
        table.add(addr);
        table.add(ansaddr);
        table.add(sex);
        table.add(sexpanel);
        table.setBackground(Color.lightGray);
        table.setBounds(250,150,600,400);
        add(table);

        JLabel label1= new JLabel("application no. :"+first);
        label1.setBounds(600,05,300,40);
        label1.setFont(new Font("raleway",Font.BOLD,20));
        add(label1);

        nextb = new JButton("NEXT->");
        nextb.setBackground(Color.BLACK);
        nextb.setForeground(Color.WHITE);
        nextb.setBounds(650,600,200,40);
        nextb.addActionListener(this);
        add(nextb);


        getContentPane().setBackground(new Color(222,255,240));
        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String formno=first;
        String dname=ansname.getText();
        String dmno=ansmno.getText();
        String dsalary=anssalary.getText();
        String dfname=ansfname.getText();
        String ddob=((JTextField)ansdob.getDateEditor().getUiComponent()).getText();
        String dgender=null;
        if(r1.isSelected()){dgender="male";}
        else if(r2.isSelected()){dgender="female";}
        String daddr=ansaddr.getText();
        try{
            if(ansname.getText().equals("")){JOptionPane.showMessageDialog(null,"fill all the fields first");}
            else{Conn con1=new Conn();
            String q="insert into signup1 values('"+formno+"','"+dname+"','"+dmno+"','"+dsalary+"','"+dfname+"','"+ddob+"','"+dgender+"','"+daddr+"')";
                con1.statement.executeUpdate(q);
                //excecuteupdate is used for insertion in table
                new signup2(first);
                setVisible(false);
            }
        }
        catch(Exception E){E.printStackTrace();}
    }
    public static void main(String args[]){
        new signup();
    }
}*/