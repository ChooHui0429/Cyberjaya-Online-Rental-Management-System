package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import dataclass.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Methods involving read or writing account data
 * 
 * @author Tan Choo Hui
 * @author Lim Tian Hee
 */
public class UserAccountToJson {

    /**
     * Register new user to pending
     * 
     * @param name             String
     * @param email            String
     * @param securityPassword String
     * @param acc_type         String
     * 
     * @author Tan Choo Hui
     * @author Lim Tian Hee
     */
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

    /**
     * Register new admin
     * 
     * @param newAccData VerifiedUser
     * 
     * @author Tan Choo Hui
     * @author Lim Tian Hee
     */
    public static VerifiedUser regAdminToJson(VerifiedUser newAccData) throws IOException {

        // Create Json instance
        Gson gson = new Gson();

        // Create a reader
        Reader reader = Files.newBufferedReader(Paths.get("data/accountData.json"));

        // Convert JSON array to list of account datas
        List<VerifiedUser> accountDatas = gson.fromJson(reader, new TypeToken<List<VerifiedUser>>() {
        }.getType());
        reader.close();

        Boolean validUserID = false;
        String userID = new String();

        // Check database to prevent duplicate user ID
        while (validUserID == false) {
            Random rndGenerator = new Random();
            int id = rndGenerator.nextInt(10000);
            String string_id = String.format("%04d", id);
            String pre_userID = newAccData.getName().replace(" ", "") + "#" + string_id + "_Admin";

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

        newAccData.setuserID(userID);
        newAccData.setloginPassword(PasswordRandGenerator.generateStrongPassword());

        // Add new account data into created list
        accountDatas.add(newAccData);

        // Create writer
        Writer writer = Files.newBufferedWriter(Paths.get("data/accountData.json"));
        // Convert register datas to Json file
        gson.toJson(accountDatas, writer);
        writer.close();
        return newAccData;
    }

    /**
     * Check for identical existing email
     * 
     * @param newAccData VerifiedUser
     * @return String - status of any identical existing email
     * 
     * @author Tan Choo Hui
     * @author Lim Tian Hee
     */
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
