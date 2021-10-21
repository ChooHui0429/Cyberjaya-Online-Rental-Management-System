package Funtion;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import DataClass.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CheckAccount {
    public static String AccountChecker(String email, String password) throws IOException {
        String result = new String();

        // Create Json instance
        Gson gson = new Gson();
        // Create reader
        Reader readerRegister = Files
                .newBufferedReader(Paths.get("Cyberjaya-Online-Rental-Management-System/Data/registerData.json"));
        Reader readerAccount = Files
                .newBufferedReader(Paths.get("Cyberjaya-Online-Rental-Management-System/Data/accountData.json"));
        Reader readerReject = Files
                .newBufferedReader(Paths.get("Cyberjaya-Online-Rental-Management-System/Data/rejectedData.json"));
        Reader readerRemove = Files
                .newBufferedReader(Paths.get("Cyberjaya-Online-Rental-Management-System/Data/removedData.json"));

        // Convert JSON array to list
        List<RegisterData> registerDatas = gson.fromJson(readerRegister, new TypeToken<List<RegisterData>>() {
        }.getType());
        List<AccountData> accountDatas = gson.fromJson(readerAccount, new TypeToken<List<AccountData>>() {
        }.getType());
        List<RegisterData> rejectedDatas = gson.fromJson(readerReject, new TypeToken<List<RegisterData>>() {
        }.getType());
        List<AccountData> removedDatas = gson.fromJson(readerRemove, new TypeToken<List<AccountData>>() {
        }.getType());
        readerRegister.close();
        readerAccount.close();
        readerReject.close();
        readerRemove.close();

        // Create Check Boolean
        Boolean acc_exist = false;

        // Check Status of respective email account
        for (RegisterData registerData : registerDatas) {
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
            for (AccountData accountData : accountDatas) {
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
            for (RegisterData rejectedData : rejectedDatas) {
                if (email.equals(rejectedData.getEmail())) {
                    if (password.equals(rejectedData.getSecurityPassword())) {
                        acc_exist = true;
                        result = "Your registration is rejected by admin. Please register again with correct information required.";
                        // Remove rejected data for new registration
                        List<RegisterData> selectedrejectedDatas = new ArrayList<RegisterData>();
                        selectedrejectedDatas.add(rejectedData);
                        rejectedDatas.removeAll(selectedrejectedDatas);
                        // Create writer
                        Writer writer = Files.newBufferedWriter(
                                Paths.get("Cyberjaya-Online-Rental-Management-System/Data/rejectedData.json"));
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
            for (AccountData removedData : removedDatas) {
                if (email.equals(removedData.getEmail())) {
                    if (password.equals(removedData.getSecurityPassword())) {
                        acc_exist = true;
                        result = "Your account is removed by admin. Please register new account.";
                        // Remove removed data for new registration
                        List<AccountData> selectedremovedDatas = new ArrayList<AccountData>();
                        selectedremovedDatas.add(removedData);
                        removedDatas.removeAll(selectedremovedDatas);
                        // Create writer
                        Writer writer = Files.newBufferedWriter(
                                Paths.get("Cyberjaya-Online-Rental-Management-System/Data/removedData.json"));
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
