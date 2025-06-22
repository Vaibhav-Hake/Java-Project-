package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class new_customer extends  JFrame implements ActionListener {
    JLabel heading ,customername,meterno,address,city,state,email,phoneNo;
    TextField nameText,addressText,cityText,stateText,emailText,phoneText,  meterText;
    JButton next,cancel;
    Choice LoginChoice;

     new_customer() {
        super("New Customer");

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(255,186,3));
        add(panel);

         heading =new JLabel("New Customer");
        heading.setBounds(180, 10, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(heading);

         customername =new JLabel("Customer Name");
        customername.setBounds(50, 80, 100, 20);
        panel.add(customername);

        nameText=new  TextField();
        nameText.setBounds(180, 80, 150, 20);
        panel.add(nameText);

        meterno =new JLabel("Meter No");
        meterno.setBounds(50, 120, 100, 20);
        panel.add(meterno);

       meterText=new  TextField();
       meterText.setBounds(180, 120, 150, 20);
        panel.add(  meterText);
     

     

        address =new JLabel("Address");
        address.setBounds(50, 160, 100, 20);
        panel.add(address);

        addressText=new  TextField();
        addressText.setBounds(180, 160, 150, 20);
        panel.add(addressText);

        city =new JLabel("City");
        city.setBounds(50, 200, 100, 20);
        panel.add(city);

        cityText=new  TextField();
        cityText.setBounds(180, 200, 150, 20);
        panel.add(cityText);

        state =new JLabel("State");
        state.setBounds(50, 240, 100, 20);
        panel.add(state);

       LoginChoice=new Choice();
      LoginChoice.add("--Select--");
      LoginChoice.add("Andhra Pradesh");
      LoginChoice.add("Arunachal Pradesh");
      LoginChoice.add( "Assam");
      LoginChoice.add("Bihar");
      LoginChoice.add("Chhattisgarh");
      LoginChoice.add( "Goa");
      LoginChoice.add("Gujarat");
      LoginChoice.add("Haryana");
      LoginChoice.add( "Himachal Pradesh");
      LoginChoice.add( "Jharkhand");
      LoginChoice.add(

                "Karnataka");
      LoginChoice.add(

                "Kerala");
      LoginChoice.add("Madhya Pradesh");
      LoginChoice.add("Maharashtra");
      LoginChoice.add( "Manipur");
      LoginChoice.add("Meghalaya");
      LoginChoice.add( "Mizoram");
      LoginChoice.add("Nagaland");
      LoginChoice.add("Odisha (Orissa)");
      LoginChoice.add( "Punjab");
      LoginChoice.add( "Rajasthan");
      LoginChoice.add("Sikkim");
      LoginChoice.add("Tamil Nadu");
      LoginChoice.add("Telangana");
      LoginChoice.add("Tripura");
      LoginChoice.add( "Uttar Pradesh");
      LoginChoice.add("Uttarakhand");
      LoginChoice.add(  "West Bengal");
      LoginChoice.setBounds(410, 240, 150, 20);
      add(LoginChoice);

        email =new JLabel("Email");
        email.setBounds(50, 280, 100, 20);
        panel.add(email);

        emailText=new  TextField();
        emailText.setBounds(180, 280, 150, 20);
        panel.add(emailText);

        phoneNo =new JLabel("Phone Number");
        phoneNo.setBounds(50, 320, 100, 20);
        panel.add(phoneNo);

        phoneText=new  TextField();
        phoneText.setBounds(180, 320, 150, 20);
        panel.add(phoneText);
        
        next=new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
       panel. add( next);

        cancel=new JButton("Cancel");
        cancel.setBounds(230,390,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
       panel. add(cancel);

       setLayout(new BorderLayout());
       add(panel,"Center");

       ImageIcon newcustomer=new ImageIcon(ClassLoader.getSystemResource("icon/fg.png"));
       Image newcustomer2=newcustomer.getImage().getScaledInstance(230, 200,  Image.SCALE_DEFAULT);
       ImageIcon fnewcustomer=new ImageIcon(newcustomer2);
       JLabel newcustomerLabel=new JLabel(fnewcustomer);
       add( newcustomerLabel,"West");
    





       
        setSize(700, 500);
        setLocation(400, 200);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==next){
           String sname=nameText.getText();
           String smeter=meterText.getText();
           String saddress=addressText.getText();
           String scity=cityText.getText();
           String sstate=LoginChoice.getSelectedItem();
           String eemail=emailText.getText();
           String sphone=phoneText.getText();



           String query_customer="Insert Into new_customer values('"+ sname+"','"+smeter+"','"+saddress+"','"+scity+"','"+sstate+"','"+eemail+"','"+sphone+"')";
           String query_signup="Insert Into name values('"+smeter+"','','"+sname+"','','')";
           try{
            database c=new database();
            c.statement.executeUpdate(query_customer);
            c.statement.executeUpdate(query_signup);
            JOptionPane.showMessageDialog(null, "Customer details Added Successfully");
            setVisible(false);
            new meter_info(smeter);

           }catch(Exception E){
            E.printStackTrace();
           }
      }
      else{
        setVisible(false);
      }
        
    }
    
    public static void main(String[] args) {
        new new_customer();
    }

}
