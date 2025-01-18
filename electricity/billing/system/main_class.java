package  electricity.billing.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class main_class extends JFrame implements  ActionListener {
    String accType,meter_pass;

    public main_class(String accType,String meter_pass) {
        this.accType=accType;
        this.meter_pass=meter_pass;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/background.jpg"));
        Image image=imageIcon.getImage().getScaledInstance(1530, 830,  Image.SCALE_DEFAULT);
        ImageIcon fimage=new ImageIcon(image);
        JLabel imageLabel=new JLabel(fimage);
        add(imageLabel);

        

        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);


        JMenu menu=new JMenu("Menu");
        menu.setFont(new Font("serif",Font.PLAIN, 15));
      

        JMenuItem newcustomer=new  JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN , 14));
        ImageIcon customerImg=new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
        Image customerImage=customerImg.getImage().getScaledInstance(20, 20,  Image.SCALE_DEFAULT);
       newcustomer.setIcon(new ImageIcon(customerImage));
       newcustomer.addActionListener(this);
        menu.add(newcustomer);
        

        
        JMenuItem customerdetails=new  JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced",Font.PLAIN , 14));
        ImageIcon customerdetailsImg=new ImageIcon(ClassLoader.getSystemResource("icon/customerDetails.png"));
        Image customerdetailsImage=customerdetailsImg.getImage().getScaledInstance(20, 20,  Image.SCALE_DEFAULT);
       customerdetails.setIcon(new ImageIcon(customerdetailsImage));
       customerdetails.addActionListener(this);
        menu.add(customerdetails);
        
        JMenuItem depositedetails=new  JMenuItem("Deposite Details");
        depositedetails.setFont(new Font("monospaced",Font.PLAIN , 14));
        ImageIcon depositedetailsImg=new ImageIcon(ClassLoader.getSystemResource("icon/depositdetails.png"));
        Image depositedetailsImage=depositedetailsImg.getImage().getScaledInstance(20, 20,  Image.SCALE_DEFAULT);
        depositedetails.setIcon(new ImageIcon(depositedetailsImage));
        depositedetails.addActionListener(this);
        menu.add(depositedetails);

         
        JMenuItem calculatebill=new  JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospaced",Font.PLAIN , 14));
        ImageIcon calculateImg=new ImageIcon(ClassLoader.getSystemResource("icon/calculatorbills.png"));
        Image calculateImage=calculateImg.getImage().getScaledInstance(20, 20,  Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(calculateImage));
        calculatebill.addActionListener(this);
        menu.add(calculatebill);

        JMenu info=new JMenu("Information");
        info.setFont(new Font("serif",Font.PLAIN, 15));
        

        JMenuItem upinfo=new  JMenuItem("Update Information");
        upinfo.setFont(new Font("monospaced",Font.PLAIN , 14));
        ImageIcon infoImg=new ImageIcon(ClassLoader.getSystemResource("icon/refresh.png"));
        Image infoImage=infoImg.getImage().getScaledInstance(20, 20,  Image.SCALE_DEFAULT);
        upinfo.setIcon(new ImageIcon(infoImage));
        upinfo.addActionListener(this);
        info.add(upinfo);

        JMenuItem viewinfo=new  JMenuItem("View Information");
        viewinfo.setFont(new Font("monospaced",Font.PLAIN , 14));
        ImageIcon viewinfoImg=new ImageIcon(ClassLoader.getSystemResource("icon/information.png"));
        Image viewinfoImage=viewinfoImg.getImage().getScaledInstance(20, 20,  Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(viewinfoImage));
        viewinfo.addActionListener(this);
        info.add(viewinfo);

        JMenu user=new JMenu("User");
        user.setFont(new Font("serif",Font.PLAIN, 15));
     
        
        JMenuItem paybill=new  JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced",Font.PLAIN , 14));
        ImageIcon payImg=new ImageIcon(ClassLoader.getSystemResource("icon/pay.png"));
        Image payImage=payImg.getImage().getScaledInstance(20, 20,  Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(payImage));
        paybill.addActionListener(this);
        user.add(paybill);

        JMenuItem billdetails=new  JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospaced",Font.PLAIN , 14));
        ImageIcon billdetailsImg=new ImageIcon(ClassLoader.getSystemResource("icon/detail.png"));
        Image billdetailsImage=billdetailsImg.getImage().getScaledInstance(20, 20,  Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(billdetailsImage));
        billdetails.addActionListener(this);
        user.add(billdetails);

        JMenu bill=new JMenu("Bill");
        bill.setFont(new Font("serif",Font.PLAIN, 15));
       

        JMenuItem genbill=new  JMenuItem("Genrate Bill");
        genbill.setFont(new Font("monospaced",Font.PLAIN , 14));
        ImageIcon genbillImg=new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image genbillImage=genbillImg.getImage().getScaledInstance(20, 20,  Image.SCALE_DEFAULT);
        genbill.setIcon(new ImageIcon(genbillImage));
        genbill.addActionListener(this);
        bill.add( genbill);
        
        JMenu utility=new JMenu("Utility");
        utility.setFont(new Font("serif",Font.PLAIN, 15));
        

        JMenuItem notepad=new  JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced",Font.PLAIN , 14));
        ImageIcon notepadImg=new ImageIcon(ClassLoader.getSystemResource("icon/notepad.png"));
        Image notepadImage=notepadImg.getImage().getScaledInstance(20, 20,  Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepadImage));
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem Calculator=new  JMenuItem("Calculator");
        Calculator.setFont(new Font("monospaced",Font.PLAIN , 14));
        ImageIcon CalculatorImg=new ImageIcon(ClassLoader.getSystemResource("icon/calculator.png"));
        Image CalculatorImage=CalculatorImg.getImage().getScaledInstance(20, 20,  Image.SCALE_DEFAULT);
        Calculator.setIcon(new ImageIcon(CalculatorImage));
        Calculator.addActionListener(this);
        utility.add(Calculator);

        JMenu exit=new JMenu("Exit");
        exit.setFont(new Font("serif",Font.PLAIN, 15));
        

        JMenuItem eexit=new  JMenuItem("Exit");
        eexit.setFont(new Font("monospaced",Font.PLAIN , 14));
        ImageIcon  eexitImg=new ImageIcon(ClassLoader.getSystemResource("icon/exit.png"));
        Image  eexitImage= eexitImg.getImage().getScaledInstance(20, 20,  Image.SCALE_DEFAULT);
        eexit.setIcon(new ImageIcon( eexitImage));
        eexit.addActionListener(this);
        exit.add( eexit);
    if(accType.equals("Admin")){
   
        menuBar.add(menu);
    }else{
        menuBar.add(bill);
        menuBar.add(user);
        menuBar.add(info);
    }
       
      
        menuBar.add(utility);
        menuBar.add( exit);
        




        setLayout(new FlowLayout());
        setVisible(true);

    }
    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e) {
     String msg=e.getActionCommand();
     if(msg.equals("New Customer")){
        new new_customer();
     }else if(msg.equals("Customer Details")){
        new customer_datails();
     }else if(msg.equals("Deposite Details")){
        new deposit_details();
     }else if(msg.equals("Calculate Bill")){
        new calculator();
     }else if(msg.equals("View Information")){
        new view_information(meter_pass);
    
     }else if(msg.equals("Update Information")){
        new update_information(meter_pass);
     }else if(msg.equals("Bill Details")){
        new bill_detail(msg);
     }else if(msg.equals("Calculator")){
         try {
          Runtime.getRuntime().exec("calc.exe");

             
         } catch (Exception E) {
            E.printStackTrace();
         }
     }else if(msg.equals("Notepad")){
        try {
            Runtime.getRuntime().exec("notepad.exe");
        } catch (Exception E) {
            E.printStackTrace();
        }
        
    }else if(msg.equals("Exit")){
        setVisible(false);
        new Login();
}else if(msg.equals("Pay Bill")){
    new pay_bill(meter_pass);
}else if(msg.equals("Genrate Bill")){
    new generate_bill(meter_pass);
}
}


    public static void main(String[] args) {
        new  main_class("","");
    }

}
