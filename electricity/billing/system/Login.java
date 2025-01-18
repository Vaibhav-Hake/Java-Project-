package  electricity.billing.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JTextField UserText,password;
Choice LoginChoice;
JButton LoginButton,CancelButton,SignupButton;
    Login(){
        super("Login");
        getContentPane().setBackground(Color.LIGHT_GRAY );
        JLabel username=new JLabel("UserName");
        username.setBounds(300, 50, 100, 20);
        add(username);

        UserText=new JTextField();
        UserText.setBounds(400, 50, 150, 20);
        add(UserText);

        JLabel Password=new JLabel("Password");
        Password.setBounds(300, 90, 100, 20);
        add(Password);
         
        password=new JTextField();
        password.setBounds(400, 90, 150, 20);
        add(password);

        JLabel Login=new JLabel("Login In As");
        Login.setBounds(300, 130, 100, 20);
        add(Login);

      LoginChoice=new Choice();
      LoginChoice.add("--Select--");
      LoginChoice.add("Admin");
      LoginChoice.add("Customer");
      LoginChoice.setBounds(400, 130, 150, 20);
      add(LoginChoice);
  
      LoginButton=new JButton("Login");
      LoginButton.setBounds(350,170,100,20);
      LoginButton.addActionListener(this);
      add(LoginButton);

      CancelButton=new JButton("Cancel");
      CancelButton.setBounds(470,170,100,20);
      CancelButton.addActionListener(this);
      add(CancelButton);

      SignupButton=new JButton("SignUp");
      SignupButton.setBounds(410,210,100,20);
      SignupButton.addActionListener(this);
      add(SignupButton);

        ImageIcon profile=new ImageIcon(ClassLoader.getSystemResource("icon/pic.png"));
        Image profile2=profile.getImage().getScaledInstance(270, 270,  Image.SCALE_DEFAULT);
        ImageIcon fprofile=new ImageIcon(profile2);
        JLabel profiLabel=new JLabel(fprofile);
        profiLabel.setBounds(5,5,250,250);
        add(profiLabel);

     
        setSize(600, 300);
        setLocation(500, 200);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==LoginButton){
            String susername=UserText.getText();
            String spassword=password.getText();
            String suser=LoginChoice.getSelectedItem();
            try{
                database c=new database();
                String query="select * from name where username='"+susername+"'and  Password='"+ spassword+"'and serType='"+suser+"'";
                ResultSet resultset=c.statement.executeQuery(query);

                if(resultset.next()){
                    String meter=resultset.getString("meter_no");
                    setVisible(false);
                    new main_class(suser,meter);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                }


            }catch(Exception E){
                E.printStackTrace();
            }

        }
        else if (e.getSource()==CancelButton) {
            setVisible(false);
            
        }
        else if (e.getSource()==SignupButton) {
            setVisible(false);
            new signup();

            
        }
        
    }
    public static void main(String[] args) {
        new Login();
}
}