package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import dataclass.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CheckAccount {
    public static String accountChecker(String email, String password) throws IOException {
        String result = new String();

        // Create Json instance
        Gson gson = new Gson();
        // Create reader
        Reader readerRegister = Files.newBufferedReader(Paths.get("data/registerData.json"));
        Reader readerAccount = Files.newBufferedReader(Paths.get("data/accountData.json"));
        Reader readerReject = Files.newBufferedReader(Paths.get("data/rejectedData.json"));
        Reader readerRemove = Files.newBufferedReader(Paths.get("data/removedData.json"));

        // Convert JSON array to list
        List<UserAccount> registerDatas = gson.fromJson(readerRegister, new TypeToken<List<UserAccount>>() {
        }.getType());
        List<VerifiedUser> accountDatas = gson.fromJson(readerAccount, new TypeToken<List<VerifiedUser>>() {
        }.getType());
        List<UserAccount> rejectedDatas = gson.fromJson(readerReject, new TypeToken<List<UserAccount>>() {
        }.getType());
        List<VerifiedUser> removedDatas = gson.fromJson(readerRemove, new TypeToken<List<VerifiedUser>>() {
        }.getType());
        readerRegister.close();
        readerAccount.close();
        readerReject.close();
        readerRemove.close();

        // Create Check Boolean
        Boolean acc_exist = false;

        // Check Status of respective email account
        for (UserAccount registerData : registerDatas) {
            if (email.equals(registerData.getEmail())) {
                if (password.equals(registerData.getSecurityPassword())) {
                    acc_exist = true;
                    result = "Your registration is still under pending.";
                    break;
                } else {
                    acc_exist = true;
                    result = "Security password incorrect. Please Check your Email and Security password carefully.";
                    break;
                }
            }
        }
        if (!acc_exist) {
            for (VerifiedUser accountData : accountDatas) {
                if (email.equals(accountData.getEmail())) {
                    if (password.equals(accountData.getSecurityPassword())) {
                        acc_exist = true;
                        result = "Your UserID : " + accountData.getuserID() + "      Your Password : "
                                + accountData.getloginPassword();
                        break;
                    } else {
                        acc_exist = true;
                        result = "Security password incorrect. Please Check your Email and Security password carefully.";
                        break;
                    }
                }
            }
        }
        if (!acc_exist) {
            for (UserAccount rejectedData : rejectedDatas) {
                if (email.equals(rejectedData.getEmail())) {
                    if (password.equals(rejectedData.getSecurityPassword())) {
                        acc_exist = true;
                        result = "Your registration is rejected by admin. Please register again with correct information required.";
                        // Remove rejected data for new registration
                        List<UserAccount> selectedrejectedDatas = new ArrayList<UserAccount>();
                        selectedrejectedDatas.add(rejectedData);
                        rejectedDatas.removeAll(selectedrejectedDatas);
                        // Create writer
                        Writer writer = Files.newBufferedWriter(Paths.get("data/rejectedData.json"));
                        // Convert rejected datas to Json file
                        gson.toJson(rejectedDatas, writer);
                        writer.close();
                        break;
                    } else {
                        acc_exist = true;
                        result = "Security password incorrect. Please Check your Email and Security password carefully.";
                        break;
                    }
                }
            }
        }
        if (!acc_exist) {
            for (VerifiedUser removedData : removedDatas) {
                if (email.equals(removedData.getEmail())) {
                    if (password.equals(removedData.getSecurityPassword())) {
                        acc_exist = true;
                        result = "Your account is removed by admin. Please register new account.";
                        // Remove removed data for new registration
                        List<VerifiedUser> selectedremovedDatas = new ArrayList<VerifiedUser>();
                        selectedremovedDatas.add(removedData);
                        removedDatas.removeAll(selectedremovedDatas);
                        // Create writer
                        Writer writer = Files.newBufferedWriter(Paths.get("data/removedData.json"));
                        // Convert rejected datas to Json file
                        gson.toJson(removedDatas, writer);
                        writer.close();
                        break;
                    } else {
                        acc_exist = true;
                        result = "Security password incorrect. Please Check your Email and Security password carefully.";
                        break;
                    }
                }
            }
        }
        if (!acc_exist) {
            result = "Your email is not found in the system. Please apply registration at register page.";
        }
        return result;
    }
}
