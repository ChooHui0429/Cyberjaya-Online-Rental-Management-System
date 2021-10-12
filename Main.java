import javax.swing.*;
import UI.*;

public class Main{
    
    public static void main(String[] args){
        // Main Frame for whole UI
        JFrame frame = new JFrame();
        frame.setTitle("Cyberjaya Online Rental Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550,550);
        ImageIcon logo = new ImageIcon("Cyberjaya-Online-Rental-Management-System/Icons/Logo.png");
        frame.setIconImage(logo.getImage());

        Function_UI main_UI = new Function_UI(frame);

        frame.add(main_UI);
        frame.setVisible(true);          
    }
}