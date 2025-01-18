package  electricity.billing.system;
import java.awt.Image;
import javax.swing.*;
//import java.awt.*;

public class splash  extends JFrame{
    splash(){
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/splash/front.jpg"));
        Image imageone=imageIcon.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2=new ImageIcon(imageone);
        JLabel imagLabel=new JLabel(imageIcon2);
        add(imagLabel);

         setSize(600, 400);
         setLocation(500, 200); 
         setVisible(true);
         try {
            Thread.sleep(2000);
            setVisible(false);
            new Login();
         }
          catch (Exception e) {
            e.printStackTrace();
          
         }
         
    }
    public static void main(String[] args) {
        new splash();
    }
    
    }