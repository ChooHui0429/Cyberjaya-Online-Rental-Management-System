package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import dataclass.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UserAccountToJson {

    // Import User Registration for pending
    public static void regUserToJson(String name, String email, String securityPassword, String acc_type) {
        try {
            // Create Json instance
            Gson gson = new Gson();

            // Create a reader
            Reader reader = Files.newBufferedReader(Paths.get("data/registerData.json"));

            // Convert JSON array to list of register datas
            List<UserAccount> registerDatas = gson.fromJson(reader, new TypeToken<List<UserAccount>>() {
            }.getType());
            reader.close();

            // Add new register data into created list
            UserAccount new_registerData = new UserAccount();
            new_registerData.setName(name);
            new_registerData.setEmail(email);
            new_registerData.setSecurityPassword(securityPassword);
            new_registerData.setAccType(acc_type);
            registerDatas.add(new_registerData);

            // Create writer
            Writer writer = Files.newBufferedWriter(Paths.get("data/registerData.json"));
            // Convert register datas to Json file
            gson.toJson(registerDatas, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Import New Admin to Account Data
    public static void regAdminToJson(VerifiedUser newAccData) {
        try {
            // Create Json instance
            Gson gson = new Gson();

            // Create a reader
            Reader reader = Files.newBufferedReader(Paths.get("data/accountData.json"));

            // Convert JSON array to list of account datas
            List<VerifiedUser> accountDatas = gson.fromJson(reader, new TypeToken<List<VerifiedUser>>() {
            }.getType());
            reader.close();

            // Add new account data into created list
            VerifiedUser new_accountData = newAccData;
            accountDatas.add(new_accountData);

            // Create writer
            Writer writer = Files.newBufferedWriter(Paths.get("data/accountData.json"));
            // Convert register datas to Json file
            gson.toJson(accountDatas, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get all the data from user input
    // TODO: combine with regAdminToJson
    public static VerifiedUser regAdmingetObjectData(VerifiedUser accountData, String name, String email,
            String securityPassword) throws IOException {

        accountData.setName(name);
        accountData.setEmail(email);
        accountData.setSecurityPassword(securityPassword);
        accountData.setAccType("Admin");

        Boolean validUserID = false;

        // Create Json instance
        Gson gson = new Gson();

        // Create a reader
        Reader reader = Files.newBufferedReader(Paths.get("data/accountData.json"));

        // Convert JSON array to list of account datas
        List<VerifiedUser> accountDatas = gson.fromJson(reader, new TypeToken<List<VerifiedUser>>() {
        }.getType());
        reader.close();

        String userID = new String();

        // Check database to prevent duplicate user ID
        while (validUserID == false) {
            java.util.Random rndGenerator = new java.util.Random();
            int id = rndGenerator.nextInt(10000);
            String string_id = String.format("%04d", id);
            String pre_userID = name.replace(" ", "") + "#" + string_id + "_Admin";

            if (accountDatas.size() == 0) {
                validUserID = true;
                userID = pre_userID;
            } else {
                for (int i = 0; i < accountDatas.size(); i++) {
                    if (pre_userID.equals(accountDatas.get(i).getuserID())) {
                        validUserID = false;
                    } else {
                        validUserID = true;
                        userID = pre_userID;
                    }
                    ;
                }
            }
        }

        accountData.setuserID(userID);
        accountData.setloginPassword(PasswordRandGenerator.generateStrongPassword());

        return accountData;
    }

    // Email Checker to prevent multiple account with a single email address.
    public static String registrationEmailChecker(String email) throws IOException {
        String exist_notify = new String();
        // Check exist of email
        Boolean exist_email = false;
        // Create Json instance
        Gson gson = new Gson();

        // Create a reader
        Reader readerRegister = Files.newBufferedReader(Paths.get("data/registerData.json"));
        Reader readerAccount = Files.newBufferedReader(Paths.get("data/accountData.json"));
        // Convert JSON array to list
        List<UserAccount> registerDatas = gson.fromJson(readerRegister, new TypeToken<List<UserAccount>>() {
        }.getType());
        List<VerifiedUser> accountDatas = gson.fromJson(readerAccount, new TypeToken<List<VerifiedUser>>() {
        }.getType());
        readerRegister.close();
        readerAccount.close();

        // Check email exist or not in database
        for (UserAccount registerData : registerDatas) {
            if (email.equals(registerData.getEmail())) {
                exist_email = true;
                exist_notify = "The email is registed in system. Please register with another email.";
                break;
            }
        }
        if (!exist_email) {
            for (VerifiedUser accountData : accountDatas) {
                if (email.equals(accountData.getEmail())) {
                    exist_email = true;
                    exist_notify = "The email is registed in system. Please register with another email.";
                    break;
                }
            }
        }
        if (!exist_email) {
            exist_notify = "";
        }
        return exist_notify;
    }
}
