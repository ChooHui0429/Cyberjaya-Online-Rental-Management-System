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

import dataclass.AccountData;
import dataclass.RegisterData;

public class ApproveUser {

    // Get all the data from table for add new account data
    public static void approveUserData(String name, String email, String securityPassword, String acc_type)
            throws IOException {

        // New account data
        AccountData accountData = new AccountData();

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
        List<AccountData> accountDatas = gson.fromJson(reader, new TypeToken<List<AccountData>>() {
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
        approveUserDataToJson(accountData);
        deleteApprovedData(accountData);

    }

    // Get all the data from table for add new rejected data
    public static void rejectUserData(String name, String email, String securityPassword, String acc_type)
            throws IOException {

        // Collect register data
        RegisterData registerData = new RegisterData();

        registerData.setName(name);
        registerData.setEmail(email);
        registerData.setSecurityPassword(securityPassword);
        registerData.setAccType(acc_type);

        rejectUserDataToJson(registerData);
        deleteRejectedData(registerData);
    }

    // Add new account data
    public static void approveUserDataToJson(AccountData newAccData) {
        try {
            // Create Json instance
            Gson gson = new Gson();

            // Create a reader
            Reader reader = Files.newBufferedReader(Paths.get("data/accountData.json"));

            // Convert JSON array to list of account datas
            List<AccountData> accountDatas = gson.fromJson(reader, new TypeToken<List<AccountData>>() {
            }.getType());
            reader.close();

            // Add new account data into created list
            AccountData new_accountData = newAccData;
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

    // Remove approved register data
    public static void deleteApprovedData(AccountData newAccData) {
        try {
            // Create Json instance
            Gson gson = new Gson();

            // Create a reader
            Reader reader = Files.newBufferedReader(Paths.get("data/registerData.json"));

            // Convert JSON array to list of register datas
            List<RegisterData> registerDatas = gson.fromJson(reader, new TypeToken<List<RegisterData>>() {
            }.getType());
            reader.close();

            // Remove approved register data
            List<RegisterData> approvedRegisterDatas = new ArrayList<RegisterData>();
            String approvedDataEmail = newAccData.getEmail();
            for (RegisterData registerData : registerDatas) {
                if (registerData.getEmail().equals(approvedDataEmail)) {
                    approvedRegisterDatas.add(registerData);
                }
            }
            registerDatas.removeAll(approvedRegisterDatas);

            // Create writer
            Writer writer = Files.newBufferedWriter(Paths.get("data/registerData.json"));
            // Convert register datas to Json file
            gson.toJson(registerDatas, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add new rejected data
    public static void rejectUserDataToJson(RegisterData newRejectData) {
        try {
            // Create Json instance
            Gson gson = new Gson();

            // Create a reader
            Reader reader = Files.newBufferedReader(Paths.get("data/rejectedData.json"));

            // Convert JSON array to list of rejected datas
            List<RegisterData> rejectedDatas = gson.fromJson(reader, new TypeToken<List<RegisterData>>() {
            }.getType());
            reader.close();

            // Add new rejected data into created list
            RegisterData new_rejectData = newRejectData;
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

    // Remove rejected register data
    public static void deleteRejectedData(RegisterData newRejectData) {
        try {
            // Create Json instance
            Gson gson = new Gson();

            // Create a reader
            Reader reader = Files.newBufferedReader(Paths.get("data/registerData.json"));

            // Convert JSON array to list of register datas
            List<RegisterData> registerDatas = gson.fromJson(reader, new TypeToken<List<RegisterData>>() {
            }.getType());
            reader.close();

            // Remove rejected register data
            List<RegisterData> approvedRegisterDatas = new ArrayList<RegisterData>();
            String approvedDataEmail = newRejectData.getEmail();
            for (RegisterData registerData : registerDatas) {
                if (registerData.getEmail().equals(approvedDataEmail)) {
                    approvedRegisterDatas.add(registerData);
                }
            }
            registerDatas.removeAll(approvedRegisterDatas);

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
