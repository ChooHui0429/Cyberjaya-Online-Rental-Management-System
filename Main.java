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
        ImageIcon logo = new ImageIcon("icons/appLogo.png");
        frame.setIconImage(logo.getImage());

        RootUI rootUI = new RootUI(frame);
        frame.add(rootUI);
        frame.setVisible(true);
    }
}