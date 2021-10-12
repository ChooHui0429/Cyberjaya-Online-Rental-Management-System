package UI;
import javax.swing.*;
import java.awt.*;

public class RegisterPopOutWindow extends JFrame{
    public RegisterPopOutWindow(JButton ok){
        // Pop Out Notice for Successful register
        this.setLayout(new GridLayout(3,1,5,5));
        this.setTitle("Cyberjaya Online Rental Management System");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(750,700);
        ImageIcon logo = new ImageIcon("Cyberjaya-Online-Rental-Management-System/Icons/Logo.png");
        this.setIconImage(logo.getImage());

        JPanel notice_panel = new JPanel();
        notice_panel.setLayout(new GridLayout(2,1,1,1));
        JLabel notice1 = new JLabel("Please always check at the 'check user ID and password' for the registration status by using Email and Security Password");
        notice1.setHorizontalAlignment(JLabel.CENTER);
        JLabel notice2 = new JLabel("Once the account is approved by admin, the User ID and password will be given there");
        notice2.setHorizontalAlignment(JLabel.CENTER);
        notice_panel.add(notice1);
        notice_panel.add(notice2);
        this.add(notice_panel);

        // Resize image
        ImageIcon Notice_image = new ImageIcon("Cyberjaya-Online-Rental-Management-System/Icons/PopOutRegister.jpg");
        Image Image_Get_image = Notice_image.getImage();
        Image Notice_image_resize = Image_Get_image.getScaledInstance(320, 220, java.awt.Image.SCALE_SMOOTH);
        Notice_image = new ImageIcon(Notice_image_resize);

        JLabel Notice_image_display = new JLabel();
        Notice_image_display.setIcon(Notice_image);
        Notice_image_display.setHorizontalAlignment(JLabel.CENTER);
        this.add(Notice_image_display);

        // Button for registration pop out window
        JPanel button_panel = new JPanel();
        button_panel.add(ok);
        this.add(button_panel);
    }
}
