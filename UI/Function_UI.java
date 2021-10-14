package UI;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import DataClass.AccountData;
import DataClass.RegisterData;
import DataClass.UserContactNumData;
import Funtion.ApproveUser;
import Funtion.CheckAccount;
import Funtion.LoginChecking;
import Funtion.RegisterDataToJson;
import Funtion.RemoveUser;
import Funtion.UserProfileUpdate;



public class Function_UI extends JPanel implements ActionListener, MouseListener {

    // Containter for Card Layout
    CardLayout main_UI = new CardLayout();

    // Store for log in account
    String login_acc = new String();

    // Create Login Panel
    JButton register_LoginPage = new JButton("Register");
    JButton login_LoginPage = new JButton("Login");

    JTextField id_enterField_LoginPage = new JTextField();
    JTextField password_enterField_LoginPage = new JTextField();

    JLabel error_message_LoginPage = new JLabel();
    JLabel find_acc_LoginPage = new JLabel("<html><u>Click here to check user ID and password</u></html>");

    LoginPanel LoginUI = new LoginPanel(
        register_LoginPage, 
        login_LoginPage, 
        id_enterField_LoginPage, 
        password_enterField_LoginPage,
        error_message_LoginPage,
        find_acc_LoginPage);

    // Create Register Panel
    JButton register_RegisterPage = new JButton("Register");
    JButton back_RegisterPage = new JButton("Back");

    JTextField name_enterField_RegisterPage = new JTextField();
    JTextField email_enterField_RegisterPage = new JTextField();
    JTextField securityPassword_enterField_RegisterPage = new JTextField();

    String[] acc_type_RegisterPage = {"--------","Potential Tenant","Owner","Agent"};
    JComboBox<String> acc_type_selection_RegisterPage = new JComboBox<String>(acc_type_RegisterPage);

    JLabel errorMessage_RegistrationPage = new JLabel();
    RegisterPanel RegisterUI = new RegisterPanel(
        register_RegisterPage, 
        back_RegisterPage, 
        name_enterField_RegisterPage, 
        email_enterField_RegisterPage, 
        securityPassword_enterField_RegisterPage, 
        errorMessage_RegistrationPage, 
        acc_type_selection_RegisterPage);

    // Create Pop Out window when registration successful
    JButton ok_PopOutRegister = new JButton("OK");
    RegisterPopOutWindow registerPopOutWindow = new RegisterPopOutWindow(ok_PopOutRegister);

    // Create PopOut for Check Account menu
    JButton back_checkAccUI = new JButton("Back");
    JButton check_checkAccUI = new JButton("Check");

    JTextField email_enterField_checkAccUI = new JTextField();
    JTextField password_enterField_checkAccUI = new JTextField();

    JLabel error_message_checkAccUI = new JLabel();

    CheckAccUI checkAccUI = new CheckAccUI(
        back_checkAccUI, 
        check_checkAccUI, 
        email_enterField_checkAccUI, 
        password_enterField_checkAccUI, 
        error_message_checkAccUI);

    // Create PopOut for Check Account result
    JButton ok_checkResultPopOut = new JButton("OK");

    JLabel notice_checkResultPopOut = new JLabel();

    CheckResultPopOut checkResultPopOut = new CheckResultPopOut(ok_checkResultPopOut, notice_checkResultPopOut);

    // Create Admin Home Page Panel
    JButton approveRegister_AdminPage = new JButton("Approve Registration");
    JButton createAdmin_AdminPage = new JButton("Create New Admin");
    JButton removeAccount_AdminPage = new JButton("Remove Account");
    JButton manageProperties_AdminPage = new JButton("Manage Properties");
    JButton viewReport_AdminPage = new JButton("View Report");
    JButton Logout_AdminPage = new JButton("Logout");

    JLabel welcome_name_AdminPage = new JLabel();

    AdminPage adminUI = new AdminPage(
        approveRegister_AdminPage, 
        createAdmin_AdminPage, 
        removeAccount_AdminPage, 
        manageProperties_AdminPage, 
        viewReport_AdminPage, 
        Logout_AdminPage,
        welcome_name_AdminPage);

    // Create Admin Register Panel
    JButton register_AdminRegPage = new JButton("Register");
    JButton back_AdminRegPage = new JButton("Back");

    JTextField name_enterField_AdminRegPage = new JTextField();
    JTextField email_enterField_AdminRegPage = new JTextField();
    JTextField securityPassword_enterField_AdminRegPage = new JTextField();

    JLabel errorMessage_AdminRegPage = new JLabel();

    RegisterAdminPanel RegAdminUI = new RegisterAdminPanel(
        register_AdminRegPage, 
        back_AdminRegPage, 
        name_enterField_AdminRegPage, 
        email_enterField_AdminRegPage, 
        securityPassword_enterField_AdminRegPage, 
        errorMessage_AdminRegPage);

    // Create admin registration Popout window
    JButton ok_PopoutAdminreg = new JButton("ok");

    JLabel notice_id_PopoutAdminreg = new JLabel();
    JLabel notice_password_PopoutAdminreg = new JLabel();

    AdminRegistrationPopOut adminregPopout = new AdminRegistrationPopOut(
        ok_PopoutAdminreg, 
        notice_id_PopoutAdminreg, 
        notice_password_PopoutAdminreg);

    // Create Admin Approve User Page panel
    JButton back_adminAprUI = new JButton("back");
    JButton approveUserBtn_adminAprUI = new JButton("Approve");
    JButton rejectUserBtn_adminAprUI = new JButton("Reject");

    // Table Column Name
    String[] columnName_adminAprUI = {"Name", "Email", "Security Password", "Account Type", ""};
    DefaultTableModel tableModel_adminAprUI = new DefaultTableModel(columnName_adminAprUI, 0){
        @Override
        public Class<?> getColumnClass(int column){
            switch(column){
                case 0:
                    return String.class;
                case 1:
                    return String.class;
                case 2:
                    return String.class;
                case 3:
                    return String.class;
                case 4:
                    return Boolean.class;
                default:
                    return String.class;
            }
        }
    };
    JTable data_display_adminAprUI = new JTable(tableModel_adminAprUI);
    
    JLabel notice_adminAprUI = new JLabel("");

    AdminApproveUserPage adminAprUI = new AdminApproveUserPage(
        back_adminAprUI, 
        rejectUserBtn_adminAprUI,
        approveUserBtn_adminAprUI,  
        data_display_adminAprUI,
        notice_adminAprUI);

    // Create Admin Remove User Page panel
    JButton back_adminRemoveUI = new JButton("back");
    JButton removeUserBtn_adminRemoveUI = new JButton("Remove");

    // Table Column Name
    String[] columnName_adminRemoveUI = {"User ID", "Login Password", "Name", "Email", "Security Password", "Account Type", ""};
    DefaultTableModel tableModel_adminRemoveUI = new DefaultTableModel(columnName_adminRemoveUI, 0){
        @Override
        public Class<?> getColumnClass(int column){
            switch(column){
                case 0:
                    return String.class;
                case 1:
                    return String.class;
                case 2:
                    return String.class;
                case 3:
                    return String.class;
                case 4:
                    return String.class;
                case 5:
                    return String.class;
                case 6:
                    return Boolean.class;
                default:
                    return String.class;
            }
        }
    };
    JTable data_display_adminRemoveUI = new JTable(tableModel_adminRemoveUI);
    JLabel notice_adminRemoveUI = new JLabel("");

    AdminRemoveUserPage adminRemoveUI = new AdminRemoveUserPage(
        back_adminRemoveUI, 
        removeUserBtn_adminRemoveUI, 
        data_display_adminRemoveUI,
        notice_adminRemoveUI);

    // Create User Home page panel
    JButton viewProperties_userUI = new JButton("View Properties");
    JButton rentedProperty_userUI = new JButton("Rented Properties");
    JButton logout_userUI = new JButton("Logout");
    JButton editProfile_userUI = new JButton("Edit Profile");

    JLabel welcome_name_userUI = new JLabel();

    UserPage userUI = new UserPage(
        viewProperties_userUI, 
        rentedProperty_userUI, 
        logout_userUI, 
        editProfile_userUI, 
        welcome_name_userUI);

    // Create User Edit Profile Panel
    JButton update_userEditProfileUI = new JButton("Update");

    JTextField name_enterField_userEditProfileUI = new JTextField();
    JTextField email_enterField_userEditProfileUI = new JTextField();
    JTextField contactNumber_enterField_userEditProfileUI = new JTextField();
    
    JLabel error_message_userEditProfileUI = new JLabel();

    UserEditProfile userEditProfileUI = new UserEditProfile(
        update_userEditProfileUI,
        name_enterField_userEditProfileUI,
        email_enterField_userEditProfileUI,
        contactNumber_enterField_userEditProfileUI,
        error_message_userEditProfileUI);

    // Create Agent or Owner Home Page panel
    JButton uploadProperty_agentOwnerUI = new JButton("Upload New Property");
    JButton modifiedProperties_agentOwnerUI = new JButton("Modified Properties");
    JButton rentedPropertie_agentOwnerUI = new JButton("Rented Propertie");
    JButton logout_agentOwnerUI = new JButton("Logout");
    JLabel title_agentOwnerUI = new JLabel("");
    JLabel welcome_name_agentOwnerUI = new JLabel("");

    AgentOwnerPage agentOwnerUI = new AgentOwnerPage(
        uploadProperty_agentOwnerUI, 
        modifiedProperties_agentOwnerUI, 
        rentedPropertie_agentOwnerUI,
        logout_agentOwnerUI,
        title_agentOwnerUI,
        welcome_name_agentOwnerUI);

    public Function_UI(JFrame frame){
        
        // Add all UI in one card layout panel
        this.setLayout(main_UI);
        this.add(LoginUI, "LoginUI");
        this.add(RegisterUI, "RegisterUI");
        this.add(adminUI, "AdminUI");
        this.add(RegAdminUI, "RegAdminUI");
        this.add(adminAprUI, "adminAprUI");
        this.add(adminRemoveUI, "adminRemoveUI");
        this.add(userUI, "userUI");
        this.add(userEditProfileUI,"userEditProfileUI");
        this.add(agentOwnerUI, "agentOwnerUI");
        

        // Make Login page as first page when open the app 
        main_UI.show(this, "LoginUI");

        //Add mouse listener to label
        find_acc_LoginPage.addMouseListener(this);

        // Add action listener to all button
        // Button for Login page
        register_LoginPage.addActionListener(this);
        login_LoginPage.addActionListener(this);

        // Button for user registration page
        register_RegisterPage.addActionListener(this);
        back_RegisterPage.addActionListener(this);

        // Button for user registration pop out
        ok_PopOutRegister.addActionListener(this);

        // Button for Check account menu pop out
        back_checkAccUI.addActionListener(this);
        check_checkAccUI.addActionListener(this);

        // Button for Check account result pop out
        ok_checkResultPopOut.addActionListener(this);

        // Button for Admin Home Page
        approveRegister_AdminPage.addActionListener(this);
        createAdmin_AdminPage.addActionListener(this);
        removeAccount_AdminPage.addActionListener(this);
        manageProperties_AdminPage.addActionListener(this); 
        viewReport_AdminPage.addActionListener(this);
        Logout_AdminPage.addActionListener(this);

        // Button for Admin registration Page
        register_AdminRegPage.addActionListener(this);
        back_AdminRegPage.addActionListener(this);
  
        // Button for Admin registration pop out
        ok_PopoutAdminreg.addActionListener(this);

        // Button for Admin approve user page
        approveUserBtn_adminAprUI.addActionListener(this);
        rejectUserBtn_adminAprUI.addActionListener(this);
        back_adminAprUI.addActionListener(this);

        // Button for Admin remove user page
        back_adminRemoveUI.addActionListener(this); 
        removeUserBtn_adminRemoveUI.addActionListener(this);

        // Button for User Home page
        viewProperties_userUI.addActionListener(this);
        rentedProperty_userUI.addActionListener(this);
        logout_userUI.addActionListener(this);
        editProfile_userUI.addActionListener(this);

        // Button for User Edit Profile Page
        update_userEditProfileUI.addActionListener(this);

        // Button for Agent or Owner Home page
        uploadProperty_agentOwnerUI.addActionListener(this); 
        modifiedProperties_agentOwnerUI.addActionListener(this); 
        rentedPropertie_agentOwnerUI.addActionListener(this);
        logout_agentOwnerUI.addActionListener(this);
    }

    // All Button action
    @Override
    public void actionPerformed(ActionEvent e){

        // Button event for Login page
        if(e.getSource() == register_LoginPage){
            // Makesure all the textfield are empty 
            name_enterField_RegisterPage.setText("");
            email_enterField_RegisterPage.setText("");
            securityPassword_enterField_RegisterPage.setText("");
            acc_type_selection_RegisterPage.setSelectedItem("--------");

            // Switch to register page
            main_UI.show(this, "RegisterUI");
        }
        else if(e.getSource() == login_LoginPage){
            // Makesure all textfield filled
            if (id_enterField_LoginPage.getText().equals("") || password_enterField_LoginPage.getText().equals("")){
                error_message_LoginPage.setText("Please Enter a correct User ID and password");
            }
            // Account type and login to respective menu
            else{
                try {
                    String acc_type_or_invalid = LoginChecking.loginChecker(id_enterField_LoginPage.getText(), password_enterField_LoginPage.getText());
                    if (acc_type_or_invalid.equals("Admin")){
                        String name = LoginChecking.userNameReturn(id_enterField_LoginPage.getText());
                        welcome_name_AdminPage.setText(name);
                        login_acc = id_enterField_LoginPage.getText();
                        // Switch to Admin home page
                        main_UI.show(this, "AdminUI");
                    }
                    else if (acc_type_or_invalid.equals("Potential Tenant")){
                        String name = LoginChecking.userNameReturn(id_enterField_LoginPage.getText());
                        welcome_name_userUI.setText(name);
                        login_acc = id_enterField_LoginPage.getText();
                        // Switch to User home page
                        main_UI.show(this, "userUI");  
                    }
                    else if (acc_type_or_invalid.equals("Owner")){
                        String name = LoginChecking.userNameReturn(id_enterField_LoginPage.getText());
                        welcome_name_agentOwnerUI.setText(name);
                        login_acc = id_enterField_LoginPage.getText();
                        title_agentOwnerUI.setText("Owner");
                        // Switch to Agent or Owner Home page
                        main_UI.show(this, "agentOwnerUI");
                    }
                    else if (acc_type_or_invalid.equals("Agent")){
                        String name = LoginChecking.userNameReturn(id_enterField_LoginPage.getText());
                        title_agentOwnerUI.setText("Agent");
                        login_acc = id_enterField_LoginPage.getText();
                        welcome_name_agentOwnerUI.setText(name);
                        // Switch to Agent or Owner Home page
                        main_UI.show(this, "agentOwnerUI");  
                    }
                    else{
                        error_message_LoginPage.setText(acc_type_or_invalid);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }  
        }

        // Button event for user registration page
        else if(e.getSource() == back_RegisterPage){
            // Makesure all the textfield are empty 
            id_enterField_LoginPage.setText("");
            password_enterField_LoginPage.setText("");

            // Switch to login page
            main_UI.show(this, "LoginUI");   
        }
        else if(e.getSource() == register_RegisterPage){
            // Makesure all te required information are filled, else pop out error message
            if(
                name_enterField_RegisterPage.getText().equals("") || 
                email_enterField_RegisterPage.getText().equals("") || 
                securityPassword_enterField_RegisterPage.getText().equals("") ||
                acc_type_selection_RegisterPage.getSelectedItem().toString().equals("--------")
                ){

                errorMessage_RegistrationPage.setText("Please Complete all your registration information.");
            }

            else{
                // Check email to prevent duplication
                String exist_email;
                try {
                    exist_email = RegisterDataToJson.RegistrationEmailChecker(email_enterField_RegisterPage.getText());
                    if (exist_email.equals("")){
                        // Register new data
                        RegisterDataToJson.RegUserdataToJson(
                            name_enterField_RegisterPage.getText(), 
                            email_enterField_RegisterPage.getText(), 
                            securityPassword_enterField_RegisterPage.getText(), 
                            acc_type_selection_RegisterPage.getSelectedItem().toString());
                            // Makesure all the textfield are empty 
                            id_enterField_LoginPage.setText("");
                            password_enterField_LoginPage.setText("");
            
                            // Switch to login page
                            main_UI.show(this, "LoginUI");

                            // Pop out guide for new user
                            registerPopOutWindow.setVisible(true);
                    }
                    else{
                        errorMessage_RegistrationPage.setText(exist_email);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } 
        }

        // Button event for user registration pop out
        else if(e.getSource() == ok_PopOutRegister){
            // close the guide
            registerPopOutWindow.setVisible(false);
        }

        // Button event for Check Account Menu Pop Out
        else if(e.getSource() == back_checkAccUI){
            // Close Check Account Pop Out
            checkAccUI.setVisible(false);
        }
        else if(e.getSource() == check_checkAccUI){
            // Makesure all textfield are filled
            if (email_enterField_checkAccUI.getText().equals("") || password_enterField_checkAccUI.getText().equals("")){
                error_message_checkAccUI.setText("Please Enter a correct Email and security password");
            }
            // Account Checking
            else{
                try {
                    String check_result = CheckAccount.AccountChecker(email_enterField_checkAccUI.getText(), password_enterField_checkAccUI.getText());
                    notice_checkResultPopOut.setText(check_result);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                // Close Check Account Menu Pop Out
                checkAccUI.setVisible(false);
                // Open Check Account Result Pop Out
                checkResultPopOut.setVisible(true);
            }
        }

        // Button event for Check Account Result Pop Out
        else if(e.getSource() == ok_checkResultPopOut){
            // Close Check Account Result Pop Out
            checkResultPopOut.setVisible(false);
        }

        // Button event for Admin Home Page
        else if(e.getSource() == approveRegister_AdminPage){
            // Create Json instance
            Gson gson = new Gson();

            // Create a reader 
            Reader reader;
            try {
                reader = Files.newBufferedReader(Paths.get("Cyberjaya-Online-Rental-Management-System/Data/registerData.json"));
                // Convert JSON array to list of register datas
                List<RegisterData> registerDatas = gson.fromJson(reader, new TypeToken<List<RegisterData>>(){}.getType());
                reader.close();

                // check new registration
                if (registerDatas.size() == 0){
                    notice_adminAprUI.setText("There is no new user registration");
                }
                // insert data into table
                else{
                    for (RegisterData registerData : registerDatas){
                        Object[] data = new Object[5];
                        data[0] = registerData.getName();
                        data[1] = registerData.getEmail();
                        data[2] = registerData.getSecurityPassword();
                        data[3] = registerData.getAccType();
                        data[4] = false;
                        tableModel_adminAprUI.addRow(data);
                    }
                }  
            } catch (IOException e1) {
                e1.printStackTrace();
            }
             
            // Switch to Admin Approve User Page
            main_UI.show(this, "adminAprUI");
        }
        else if(e.getSource() == createAdmin_AdminPage){

            // Makesure all the textfield are empty 
            name_enterField_AdminRegPage.setText("");
            email_enterField_AdminRegPage.setText("");
            securityPassword_enterField_AdminRegPage.setText("");

            // Switch to admin register page
            main_UI.show(this, "RegAdminUI");
        }
        else if(e.getSource() == removeAccount_AdminPage){
            // Create Json instance
            Gson gson = new Gson();

            // Create a reader 
            Reader reader;
            try {
                reader = Files.newBufferedReader(Paths.get("Cyberjaya-Online-Rental-Management-System/Data/accountData.json"));
                // Convert JSON array to list of account datas
                List<AccountData> accountDatas = gson.fromJson(reader, new TypeToken<List<AccountData>>(){}.getType());
                reader.close();

                // insert data into table
                for (AccountData accountData : accountDatas){
                    Object[] data = new Object[7];
                    data[0] = accountData.getuserID();
                    data[1] = accountData.getloginPassword();
                    data[2] = accountData.getName();
                    data[3] = accountData.getEmail();
                    data[4] = accountData.getSecurityPassword();
                    data[5] = accountData.getAccType();
                    data[6] = false;
                    tableModel_adminRemoveUI.addRow(data);
                } 
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            // Switch to Admin Remove User Page
            main_UI.show(this, "adminRemoveUI");
        }





        
        else if(e.getSource() == Logout_AdminPage){
            // Makesure all the textfield are empty 
            id_enterField_LoginPage.setText("");
            password_enterField_LoginPage.setText("");

            // Switch to login page
            main_UI.show(this, "LoginUI");
        }

        // Button event for Admin registration Page
        else if(e.getSource() == register_AdminRegPage){
            // Makesure all te required information are filled, else pop out error message
            if(
                name_enterField_AdminRegPage.getText().equals("") || 
                email_enterField_AdminRegPage.getText().equals("") || 
                securityPassword_enterField_AdminRegPage.getText().equals("")
                ){
                errorMessage_AdminRegPage.setText("Please Complete all your registration information.");
            }
            else{
                String exist_email;
                try{
                    exist_email = RegisterDataToJson.RegistrationEmailChecker(email_enterField_AdminRegPage.getText());
                    if(exist_email.equals("")){
                        // Register new data
                        AccountData newAccData = new AccountData();
                        try {
                            newAccData = RegisterDataToJson.RegAdmingetObjectData(newAccData, name_enterField_AdminRegPage.getText(), email_enterField_AdminRegPage.getText(), securityPassword_enterField_AdminRegPage.getText());
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        RegisterDataToJson.RegAdmindataToJson(newAccData);

                        // Switch to Admin home page
                        main_UI.show(this, "AdminUI");

                        // Pop out window
                        notice_id_PopoutAdminreg.setText("User ID : " + newAccData.getuserID());
                        notice_password_PopoutAdminreg.setText("Password :" + newAccData.getloginPassword());
                        adminregPopout.setVisible(true);
                    }
                    else{
                        errorMessage_AdminRegPage.setText(exist_email);
                    }
                }catch (IOException e1) {
                    e1.printStackTrace();
                }  
            }
        }
        else if(e.getSource() == back_AdminRegPage){
            // Switch to Admin Home Page
            main_UI.show(this, "AdminUI");   
        }

        // Button event for Admin registration pop out
        else if(e.getSource() == ok_PopoutAdminreg){
            // close the notice
            adminregPopout.setVisible(false); 
        }

        // Button event for Admin approve user page
        else if(e.getSource() == approveUserBtn_adminAprUI){
            // Control the notify message boolean
            Boolean checkerControl = false;
            // If there is no new register user, show notice
            if(tableModel_adminAprUI.getRowCount() == 0){
                notice_adminAprUI.setText("There is no new user registration.There is no selection available");
            }
            // Check selected row for approved registration and create account for them and remove from register data
            else{
                for(int i = 0; i < tableModel_adminAprUI.getRowCount(); i++){
                    Boolean checked = Boolean.valueOf(tableModel_adminAprUI.getValueAt(i, 4).toString());
                    if (checked){
                        checkerControl = true;
                        String name = tableModel_adminAprUI.getValueAt(i, 0).toString();
                        String email = tableModel_adminAprUI.getValueAt(i, 1).toString();
                        String securityPassword = tableModel_adminAprUI.getValueAt(i, 2).toString();
                        String acc_type = tableModel_adminAprUI.getValueAt(i, 3).toString();
                        try {
                            ApproveUser.ApproveUserData(name, email, securityPassword, acc_type);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        tableModel_adminAprUI.removeRow(i);
                    }
                }
                // If there is no selection, show notice
                if (!checkerControl){
                    notice_adminAprUI.setText("There is no selection available");
                }
                // If there is no new register user, show notice
                else{
                    if (tableModel_adminAprUI.getRowCount() == 0){
                        notice_adminAprUI.setText("There is no new user registration");
                    }
                }
            }
        }
        else if(e.getSource() == rejectUserBtn_adminAprUI){
            // Control the notify message boolean
            Boolean checkerControl = false;
            // If there is no new register user, show notice
            if(tableModel_adminAprUI.getRowCount() == 0){
                notice_adminAprUI.setText("There is no new user registration.There is no selection available");
            }
            // Check selected row for rejected registration and add into rejected data and remove from register data
            else{
                for(int i = 0; i < tableModel_adminAprUI.getRowCount(); i++){
                    Boolean checked = Boolean.valueOf(tableModel_adminAprUI.getValueAt(i, 4).toString());
                    if (checked){
                        checkerControl = true;
                        String name = tableModel_adminAprUI.getValueAt(i, 0).toString();
                        String email = tableModel_adminAprUI.getValueAt(i, 1).toString();
                        String securityPassword = tableModel_adminAprUI.getValueAt(i, 2).toString();
                        String acc_type = tableModel_adminAprUI.getValueAt(i, 3).toString();
                        try {
                            ApproveUser.RejectUserData(name, email, securityPassword, acc_type);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        tableModel_adminAprUI.removeRow(i);
                    }
                }
                // If there is no selection, show notice
                if (!checkerControl){
                    notice_adminAprUI.setText("There is no selection available");
                }
                // If there is no new register user, show notice
                else{
                    if (tableModel_adminAprUI.getRowCount() == 0){
                        notice_adminAprUI.setText("There is no new user registration");
                    }
                }
            }
        }
        else if(e.getSource() == back_adminAprUI){
            // Switch to Admin Home Page
            main_UI.show(this, "AdminUI");  
        }

        // Button event for Admin remove user page
        else if(e.getSource() == removeUserBtn_adminRemoveUI){
            // Control the notify message boolean
            Boolean checkerControl = false;
            // Check selected row for remove account and add into removed data and remove from account data
            for(int i = 0; i < tableModel_adminRemoveUI.getRowCount(); i++){
                Boolean checked = Boolean.valueOf(tableModel_adminRemoveUI.getValueAt(i, 6).toString());
                if (checked){
                    checkerControl = true;
                    String userID = tableModel_adminRemoveUI.getValueAt(i, 0).toString();
                    String loginPassword = tableModel_adminRemoveUI.getValueAt(i, 1).toString();
                    String name = tableModel_adminRemoveUI.getValueAt(i, 2).toString();
                    String email = tableModel_adminRemoveUI.getValueAt(i, 3).toString();
                    String securityPassword = tableModel_adminRemoveUI.getValueAt(i, 4).toString();
                    String acc_type = tableModel_adminRemoveUI.getValueAt(i, 5).toString();
                    try {
                        RemoveUser.RejectUserData(name, email, securityPassword, acc_type, userID, loginPassword);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    tableModel_adminRemoveUI.removeRow(i);
                }
            }
            // If there is no selection, show notice
            if (!checkerControl){
                notice_adminAprUI.setText("There is no selection available");
            }   
        }
        else if(e.getSource() == back_adminRemoveUI){
            // Switch to Admin Home Page
            main_UI.show(this, "AdminUI"); 
        }

        // Button event for User Home page
        else if(e.getSource() == editProfile_userUI){
            try {
                AccountData acc_data = UserProfileUpdate.getAccData(login_acc);
                UserContactNumData contact_data = UserProfileUpdate.getContactData(login_acc);

                name_enterField_userEditProfileUI.setText(acc_data.getName());
                email_enterField_userEditProfileUI.setText(acc_data.getEmail());
                contactNumber_enterField_userEditProfileUI.setText(contact_data.getContactNumber());

            } catch (IOException e1) {
                e1.printStackTrace();
            }
            // Switch to User Edit Profile Page
            main_UI.show(this, "userEditProfileUI"); 
        }
        else if(e.getSource() == logout_userUI){
            // Makesure all the textfield are empty 
            id_enterField_LoginPage.setText("");
            password_enterField_LoginPage.setText("");

            // Switch to login page
            main_UI.show(this, "LoginUI");
        }

        // Button event for User Edit Profile Page
        else if(e.getSource() == update_userEditProfileUI){
            // Show error message when there is empty text field 
            if (name_enterField_userEditProfileUI.getText().equals("") || email_enterField_userEditProfileUI.getText().equals("") || contactNumber_enterField_userEditProfileUI.getText().equals("")){
                error_message_userEditProfileUI.setText("Please Complete all your information.");
            }
            else{
                try {
                    UserProfileUpdate.SaveupdateData(
                        login_acc, 
                        name_enterField_userEditProfileUI.getText(),
                        email_enterField_userEditProfileUI.getText(),
                        contactNumber_enterField_userEditProfileUI.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                // Switch to User home page
                main_UI.show(this, "userUI");
            }  
        }

        // Button event for Agent or Owner Home page
        else if(e.getSource() == logout_agentOwnerUI){
            // Makesure all the textfield are empty 
            id_enterField_LoginPage.setText("");
            password_enterField_LoginPage.setText("");

            // Switch to login page
            main_UI.show(this, "LoginUI");
        }  
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == find_acc_LoginPage){
            // Open Check Account Pop Out
            email_enterField_checkAccUI.setText("");
            password_enterField_checkAccUI.setText("");
            checkAccUI.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {   
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == find_acc_LoginPage){
            find_acc_LoginPage.setForeground(Color.GREEN);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == find_acc_LoginPage){
            find_acc_LoginPage.setForeground(Color.BLUE);
        }
    }
}
