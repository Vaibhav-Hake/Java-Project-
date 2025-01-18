package  electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class meter_info extends  JFrame implements  ActionListener {
    JLabel heading, meterno, meterText,meterLoc,meterType,phasecode,billtype,day,note1,note;
    Choice meterLocCho,meterTy,phasecho,billcho;
    JButton submit;
    String meterno1;
   

    public meter_info(String meterno1) {
        super("Meter Information");
        this.meterno1=meterno1;

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(255,186,3));
        add(panel);
         
        heading =new JLabel("Meter Information");
        heading.setBounds(180, 10, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(heading);

        meterno =new JLabel("Meter No");
        meterno.setBounds(50, 80, 100, 20);
        panel.add(meterno);

        meterText=new  JLabel(meterno1);
        meterText.setBounds(180, 80, 150, 20);
        panel.add(meterText);

        meterLoc =new JLabel("Meter Location");
        meterLoc.setBounds(50, 120, 100, 20);
        panel.add(meterLoc);
     
        meterLocCho=new  Choice();
        meterLocCho.add("---Select---");
        meterLocCho.add("Outside");
        meterLocCho.add("Inside");
        meterLocCho.setBounds(180, 120, 150, 20);
        panel.add( meterLocCho);

        meterType =new JLabel("Meter Type");
        meterType.setBounds(50, 160, 100, 20);
        panel.add(meterType);

        meterTy=new  Choice();
        meterTy.add("---Select---");
        meterTy.add("Electric Meter");
        meterTy.add("Solar Meter");
        meterTy.add("Smart Meter");
        meterTy.setBounds(180, 160, 150, 20);
        panel.add(meterTy);

        phasecode =new JLabel("Phase Code");
        phasecode.setBounds(50, 200, 100, 20);
        panel.add(phasecode);

        phasecho=new  Choice();
        phasecho.add("---Select---");
        phasecho.add("011");
        phasecho.add("022");
        phasecho.add("033");
        phasecho.add("044");
        phasecho.add("055");
        phasecho.add("066");
        phasecho.add("077");
        phasecho.add("088");
        phasecho.add("099");
        phasecho.setBounds(180, 200, 150, 20);
        panel.add(phasecho);

        billtype =new JLabel("Bill Type");
        billtype.setBounds(50, 240, 100, 20);
        panel.add(billtype);

        billcho=new  Choice();
        billcho.add("---Select---");
        billcho.add("Normal");
        billcho.add("Industrial");
        billcho.setBounds(180, 240, 150, 20);
        panel.add(billcho);

        day=new JLabel("30 Days Billing Time...........");
        day.setBounds(50, 280, 150, 20);
        panel.add(day); 

        note=new JLabel("Note:-");
        note.setBounds(50, 320, 100, 20);
        panel.add(note);

        note1=new JLabel("By Default Bill is calculated for 30 days only....");
        note1.setBounds(80, 340, 300, 20);
        panel.add(note1);

        submit=new JButton("Submit");
        submit.setBounds(220,390,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
       panel. add( submit);

       
       setLayout(new BorderLayout());
       add(panel,"Center");

       ImageIcon newcustomer=new ImageIcon(ClassLoader.getSystemResource("icon/gh.png"));
       Image newcustomer2=newcustomer.getImage().getScaledInstance(230, 200,  Image.SCALE_DEFAULT);
       ImageIcon fnewcustomer=new ImageIcon(newcustomer2);
       JLabel newcustomerLabel=new JLabel(fnewcustomer);
       add( newcustomerLabel,"East");
    



        setSize(700, 500);
        setLocation(400, 200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==submit){
        String smeterno=meterno1;
        String smeterLoc=meterLocCho.getSelectedItem();
        String smeterTyp=meterTy.getSelectedItem();
        String sphasecode=phasecho.getSelectedItem();
        String sbillType=billcho.getSelectedItem();
        String sday="30";
        String query_meterinfo="Insert into meter_info values('"+smeterno+"','"+smeterLoc+"','"+smeterTyp+"','"+sphasecode+"','"+sbillType+"','"+sday+"')";
        try{
               database c=new database();
               c.statement.executeUpdate(query_meterinfo);
               JOptionPane.showMessageDialog(null, "Meter Information Submitted SuccessFully....");
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
        new meter_info("");
    }

}
