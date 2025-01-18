package  electricity.billing.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import javax.swing.*;

public class calculator extends  JFrame implements  ActionListener {
    JLabel heading,meterno,name,nameText,address,addressText,unit,month;
    Choice meternocho,monthcho;
    TextField unitText;
    JButton submit,cancel;
    calculator(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(214,195,247));
        add(panel);
         
        heading =new JLabel("Calculate Electricity Bill");
        heading.setBounds(50, 10, 300, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        panel.add(heading);


        meterno =new JLabel("Meter NUmber");
        meterno.setBounds(50, 80, 100, 20);
        panel.add(meterno);

        meternocho=new  Choice();
       try{
        database c=new database();
        ResultSet resultSet=c.statement.executeQuery("select * from new_customer");
        while(resultSet.next()){
            meternocho.add(resultSet.getString("meter_no"));
        }

       }catch(Exception E){
        E.printStackTrace();
       }
        meternocho.setBounds(180, 80, 100, 20);
        panel.add( meternocho);


        name =new JLabel("Name");
        name.setBounds(50, 120, 100, 20);
        panel.add(name);

        nameText =new JLabel("");
        nameText.setBounds(180, 120, 150, 20);
        panel.add(nameText);

        address =new JLabel("Address");
        address.setBounds(50, 160, 150, 20);
        panel.add(address);

        addressText =new JLabel("");
        addressText .setBounds(180, 160, 150, 20);
        panel.add( addressText );


        try{
          
            database c=new database();
            ResultSet resultSet=c.statement.executeQuery("select * from new_customer where meter_no ='"+ meternocho.getSelectedItem()+"'");
            while(resultSet.next()){
                nameText.setText(resultSet.getString("name"));
                addressText.setText(resultSet.getString("address"));
            }
    
        
        }catch(Exception E){
            E.printStackTrace();
        }

       meternocho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
          
                    database c=new database();
                    ResultSet resultSet=c.statement.executeQuery("select * from new_customer where meter_no ='"+ meternocho.getSelectedItem()+"'");
                    while(resultSet.next()){
                        nameText.setText(resultSet.getString("name"));
                        addressText.setText(resultSet.getString("address"));
                    }
            
                
                }catch(Exception E){
                    E.printStackTrace();
                }
              
            }

        
       });

       unit =new JLabel("Unit Consumed");
       unit.setBounds(50, 200, 100, 20);
       panel.add(unit);

       unitText=new TextField();
       unitText.setBounds(180, 200, 150, 20);
       panel.add(unitText);

       month =new JLabel("Month");
       month.setBounds(50, 240, 100, 20);
       panel.add(month);

       monthcho=new  Choice();
       monthcho.add("---Select---");
       monthcho.add("January");
       monthcho.add("February");
       monthcho.add("March");
       monthcho.add("April");
       monthcho.add("May");
       monthcho.add("June");
       monthcho.add("July");
       monthcho.add("Augest");
       monthcho.add("Septamber");
       monthcho.add("October");
       monthcho.add("November");
       monthcho.add("December");
       monthcho.setBounds(180, 240, 150, 20);
       panel.add(monthcho);

       submit=new JButton("Submit");
       submit.setBounds(80,300,100,25);
       submit.setBackground(Color.BLACK);
       submit.setForeground(Color.WHITE);
       submit.addActionListener(this);
      panel. add( submit);

      cancel=new JButton("Cancel");
      cancel.setBounds(230,300,100,25);
      cancel.setBackground(Color.BLACK);
      cancel.setForeground(Color.WHITE);
      cancel.addActionListener(this);
     panel. add(cancel);

     setLayout(new BorderLayout());
       add(panel,"Center");

       ImageIcon newcustomer=new ImageIcon(ClassLoader.getSystemResource("icon/fix.jpg"));
       Image newcustomer2=newcustomer.getImage().getScaledInstance(260, 420,  Image.SCALE_DEFAULT);
       ImageIcon fnewcustomer=new ImageIcon(newcustomer2);
       JLabel newcustomerLabel=new JLabel(fnewcustomer);
       add( newcustomerLabel,"East");
    



        setSize(650, 400);
        setLocation(400, 200);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==submit){
      
        String smeterno=meternocho.getSelectedItem();
        String sunit=unitText.getText();
        String smonth=monthcho.getSelectedItem();

         int totalBill=0;
         int unit=Integer.parseInt(sunit);
         String query_tax="select * from tax";
         try {
            database c=new database();
            ResultSet resultSet=c.statement.executeQuery(query_tax);
            while(resultSet.next()){
                totalBill+=unit*Integer.parseInt(resultSet.getString("cost_per_unit"));
                totalBill+=Integer.parseInt(resultSet.getString("meter_rent"));
                totalBill+=Integer.parseInt(resultSet.getString("service_charg"));
                totalBill+=Integer.parseInt(resultSet.getString("service_tax"));
                totalBill+=Integer.parseInt(resultSet.getString("swacch_bharat"));
                totalBill+=Integer.parseInt(resultSet.getString("fixed_tax"));
            }
            
             
         } catch (Exception E) {
            E.printStackTrace();
         }
         String query_total_bill="insert into bill values('"+smeterno+"','"+smonth+"','"+sunit+"','"+totalBill+"','Not Paid')";
         try{
            database c=new database();
            c.statement.executeUpdate(query_total_bill);

            JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully ..");
            setVisible(false);

         }catch(Exception E){
            E.printStackTrace();
         }
        }
       else{
        setVisible(false);
       }
        
    }
    
    public static void main(String[] args) {
        new calculator();
    }

}
