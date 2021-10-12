package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Function_UI extends JPanel implements ActionListener{
    // Containter for Card Layout
    CardLayout main_UI = new CardLayout();

    // Create Login Panel
    JButton register_LoginPage = new JButton("Register");
    JButton login_LoginPage = new JButton("Login");
    LoginPanel LoginUI = new LoginPanel(register_LoginPage, login_LoginPage);

    // Create Register Panel
    JButton register_RegisterPage = new JButton("Register");
    JButton back_RegisterPage = new JButton("Back");

    JTextField name_enterField_RegisterPage = new JTextField();
    JTextField email_enterField_RegisterPage = new JTextField();
    JTextField securityPassword_enterField_RegisterPage = new JTextField();

    String[] acc_type = {"--------","Potential Tenant","Owner","Agent"};
    JComboBox<String> acc_type_selection_RegisterPage = new JComboBox<String>(acc_type);

    JLabel errorMessage_RegistrationPage = new JLabel();
    RegisterPanel RegisterUI = new RegisterPanel(register_RegisterPage, 
                                                    back_RegisterPage, 
                                                    name_enterField_RegisterPage, 
                                                    email_enterField_RegisterPage, 
                                                    securityPassword_enterField_RegisterPage, 
                                                    errorMessage_RegistrationPage, 
                                                    acc_type_selection_RegisterPage
                                                );

    // Create Pop Out window when registration successful
    JButton ok_PopOutRegister = new JButton("OK");
    RegisterPopOutWindow registerPopOutWindow = new RegisterPopOutWindow(ok_PopOutRegister);

    public Function_UI(JFrame frame){
        
        // Add all UI in one card layout panel
        this.setLayout(main_UI);
        this.add(LoginUI, "LoginUI");
        this.add(RegisterUI, "RegisterUI");
        main_UI.show(this, "LoginUI");

        // Add listener to all button
        register_LoginPage.addActionListener(this);

        register_RegisterPage.addActionListener(this);
        back_RegisterPage.addActionListener(this);
        ok_PopOutRegister.addActionListener(this);
        
    }

    // All Button action
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == register_LoginPage){
            main_UI.show(this, "RegisterUI");
            name_enterField_RegisterPage.setText("");
            email_enterField_RegisterPage.setText("");
            securityPassword_enterField_RegisterPage.setText("");
            acc_type_selection_RegisterPage.setSelectedItem("--------");

        }

        else if(e.getSource() == back_RegisterPage){
            main_UI.show(this, "LoginUI");
        }
        else if(e.getSource() == register_RegisterPage){
            
            if(name_enterField_RegisterPage.getText().equals("") || 
                email_enterField_RegisterPage.getText().equals("") || 
                securityPassword_enterField_RegisterPage.getText().equals("") ||
                acc_type_selection_RegisterPage.getSelectedItem().toString().equals("--------")
                ){
                errorMessage_RegistrationPage.setText("Please Complete all your registration information.");
            }
            else{
                main_UI.show(this, "LoginUI");
                registerPopOutWindow.setVisible(true);
            }
            
        }

        else if(e.getSource() == ok_PopOutRegister){
            registerPopOutWindow.setVisible(false);
        }

        
    }

}
