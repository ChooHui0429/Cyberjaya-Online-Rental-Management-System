package util;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dataclass.VerifiedUser;
import dataclass.UserAccount;

/**
 * Methods involving user approval
 * 
 * @author Tan Choo Hui
 * @author Lim Tian Hee
 */
public class UserApproval {
    /**
     * Approve a user registration, generates a verified account
     * 
     * @param name             String
     * @param email            String
     * @param securityPassword String
     * @param acc_type         String
     * 
     * @author Tan Choo Hui
     * @author Lim Tian Hee
     */
    public static void approveUser(String name, String email, String securityPassword, String acc_type)
            throws IOException {

        // New account data
        VerifiedUser accountData = new VerifiedUser();

        accountData.setName(name);
        accountData.setEmail(email);
        accountData.setSecurityPassword(securityPassword);
        accountData.setAccType(acc_type);

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
            String pre_userID = name.replace(" ", "") + "#" + string_id + "_" + acc_type;

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
        approveUserToJson(accountData);
        deleteApprovedUser(accountData);

    }

    /**
     * Reject a user registration
     * 
     * @param name             String
     * @param email            String
     * @param securityPassword String
     * @param acc_type         String
     * 
     * @author Tan Choo Hui
     * @author Lim Tian Hee
     */
    public static void rejectUser(String name, String email, String securityPassword, String acc_type)
            throws IOException {

        // Collect register data
        UserAccount registerData = new UserAccount();

        registerData.setName(name);
        registerData.setEmail(email);
        registerData.setSecurityPassword(securityPassword);
        registerData.setAccType(acc_type);

        rejectUserToJson(registerData);
        deleteRejectedUser(registerData);
    }

    /**
     * Writes a user to verified user json
     * 
     * @param newAccData VerifiedUser
     * 
     * @author Tan Choo Hui
     * @author Lim Tian Hee
     */
    public static void approveUserToJson(VerifiedUser newAccData) {
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
            // Convert account datas to Json file
            gson.toJson(accountDatas, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes a user from verified user json
     * 
     * @param newAccData VerifiedUser
     * 
     * @author Tan Choo Hui
     * @author Lim Tian Hee
     */
    public static void deleteApprovedUser(VerifiedUser newAccData) {
        try {
            // Create Json instance
            Gson gson = new Gson();

            // Create a reader
            Reader reader = Files.newBufferedReader(Paths.get("data/registerData.json"));

            // Convert JSON array to list of register datas
            List<UserAccount> registerDatas = gson.fromJson(reader, new TypeToken<List<UserAccount>>() {
            }.getType());
            reader.close();

            // Remove approved register data
            List<UserAccount> approvedUserAccounts = new ArrayList<UserAccount>();
            String approvedDataEmail = newAccData.getEmail();
            for (UserAccount registerData : registerDatas) {
                if (registerData.getEmail().equals(approvedDataEmail)) {
                    approvedUserAccounts.add(registerData);
                }
            }
            registerDatas.removeAll(approvedUserAccounts);

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
     * Adds a user to rejected user json
     * 
     * @param newRejectData UserAccount
     * 
     * @author Tan Choo Hui
     * @author Lim Tian Hee
     */
    public static void rejectUserToJson(UserAccount newRejectData) {
        try {
            // Create Json instance
            Gson gson = new Gson();

            // Create a reader
            Reader reader = Files.newBufferedReader(Paths.get("data/rejectedData.json"));

            // Convert JSON array to list of rejected datas
            List<UserAccount> rejectedDatas = gson.fromJson(reader, new TypeToken<List<UserAccount>>() {
            }.getType());
            reader.close();

            // Add new rejected data into created list
            UserAccount new_rejectData = newRejectData;
            rejectedDatas.add(new_rejectData);

            // Create writer
            Writer writer = Files.newBufferedWriter(Paths.get("data/rejectedData.json"));
            // Convert rejected datas to Json file
            gson.toJson(rejectedDatas, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Remove a user from rejected user json
     * 
     * @param newRejectData UserAccount
     * 
     * @author Tan Choo Hui
     * @author Lim Tian Hee
     */// Remove rejected register data
    public static void deleteRejectedUser(UserAccount newRejectData) {
        try {
            // Create Json instance
            Gson gson = new Gson();

            // Create a reader
            Reader reader = Files.newBufferedReader(Paths.get("data/registerData.json"));

            // Convert JSON array to list of register datas
            List<UserAccount> registerDatas = gson.fromJson(reader, new TypeToken<List<UserAccount>>() {
            }.getType());
            reader.close();

            // Remove rejected register data
            List<UserAccount> approvedUserAccounts = new ArrayList<UserAccount>();
            String approvedDataEmail = newRejectData.getEmail();
            for (UserAccount registerData : registerDatas) {
                if (registerData.getEmail().equals(approvedDataEmail)) {
                    approvedUserAccounts.add(registerData);
                }
            }
            registerDatas.removeAll(approvedUserAccounts);

            // Create writer
            Writer writer = Files.newBufferedWriter(Paths.get("data/registerData.json"));
            // Convert register datas to Json file
            gson.toJson(registerDatas, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
