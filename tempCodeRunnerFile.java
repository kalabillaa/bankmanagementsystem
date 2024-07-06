ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/piggybank.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(450,10,100,100);
        main.add(image,BorderLayout.NORTH);