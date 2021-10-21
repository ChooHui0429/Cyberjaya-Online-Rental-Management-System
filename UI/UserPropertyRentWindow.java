package UI;

import javax.swing.*;
import java.awt.*;

public class UserPropertyRentWindow extends JFrame {
    public UserPropertyRentWindow(JButton back, JButton rent, JLabel title_ID, JLabel rentalFee, JLabel size,
            JLabel NumRoom, JLabel NumBathroom, JLabel Condition, JLabel ContactNum, JLabel address, JLabel facilities,
            JLabel rentalAskFor, JLabel propertyType, JLabel owner) {
        // Main Frame for User Property Rent Window
        this.setTitle("Cyberjaya Online Rental Management System");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(850, 850);
        ImageIcon logo = new ImageIcon("Icons/Logo.png");
        this.setIconImage(logo.getImage());
        this.setResizable(false);

        this.setLayout(new GridLayout(3, 1, 1, 1));

        // ID for User Property Rent Window
        title_ID.setHorizontalAlignment(JLabel.CENTER);
        title_ID.setFont(new Font("MV Boli", Font.BOLD, 25));
        this.add(title_ID);

        JPanel info_display = new JPanel();
        info_display.setLayout(new GridLayout(11, 1, 1, 1));
        info_display.add(size);
        info_display.add(NumRoom);
        info_display.add(NumBathroom);
        info_display.add(rentalFee);
        info_display.add(Condition);
        info_display.add(ContactNum);
        info_display.add(address);
        info_display.add(facilities);
        info_display.add(rentalAskFor);
        info_display.add(propertyType);
        info_display.add(owner);

        this.add(info_display);

        // Button for User Property Rent Window
        JPanel button_panel = new JPanel();
        button_panel.add(back);
        button_panel.add(rent);
        this.add(button_panel);

    }
}
