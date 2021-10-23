import javax.swing.*;
import components.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Main Frame for whole UI
        JFrame frame = new JFrame();
        frame.setTitle("Cyberjaya Online Rental Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 850);
        ImageIcon logo = new ImageIcon("icons/Logo.png");
        frame.setIconImage(logo.getImage());

        Function_UI main_UI = new Function_UI(frame);
        frame.add(main_UI);
        frame.setVisible(true);
    }
}