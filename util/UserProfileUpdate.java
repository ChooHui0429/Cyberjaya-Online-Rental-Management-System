package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import dataclass.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UserProfileUpdate {

    public static void saveUpdateData(String userID, String new_Name, String new_Email, String new_ContactNumber)
            throws IOException {

        // Create Json instance
        Gson gson = new Gson();

        // Create a reader
        Reader readerAcc = Files.newBufferedReader(Paths.get("data/accountData.json"));
        Reader readerContactNum = Files.newBufferedReader(Paths.get("data/userContactNumber.json"));

        // Convert JSON array to list
        List<AccountData> accountDatas = gson.fromJson(readerAcc, new TypeToken<List<AccountData>>() {
        }.getType());
        readerAcc.close();
        List<UserContactNumData> userContactDatas = gson.fromJson(readerContactNum,
                new TypeToken<List<UserContactNumData>>() {
                }.getType());
        readerContactNum.close();

        // Update Account Data
        for (AccountData accountData : accountDatas) {
            if (userID.equals(accountData.getuserID())) {
                accountData.setName(new_Name);
                accountData.setEmail(new_Email);
            }
        }

        // Update User Contact Data
        for (UserContactNumData userContactData : userContactDatas) {
            if (userID.equals(userContactData.getUserID())) {
                userContactData.setContactNumber(new_ContactNumber);
            }
        }

        // Create writer
        Writer writerContactNum = Files.newBufferedWriter(Paths.get("data/userContactNumber.json"));
        // Convert new user contact datas to Json file
        gson.toJson(userContactDatas, writerContactNum);
        writerContactNum.close();

        // Create writer
        Writer writerAcc = Files.newBufferedWriter(Paths.get("data/accountData.json"));
        // Convert new account datas to Json file
        gson.toJson(accountDatas, writerAcc);
        writerAcc.close();

    }

    public static AccountData getAccData(String userID) throws IOException {
        AccountData acc_data = new AccountData();
        // Create Json instance
        Gson gson = new Gson();

        // Create a reader
        Reader reader = Files.newBufferedReader(Paths.get("data/accountData.json"));

        // Convert JSON array to list of account datas
        List<AccountData> accountDatas = gson.fromJson(reader, new TypeToken<List<AccountData>>() {
        }.getType());
        reader.close();

        // Find related account data for login account
        for (AccountData accountData : accountDatas) {
            if (userID.equals(accountData.getuserID())) {
                acc_data = accountData;
                break;
            }
        }

        return acc_data;
    }

    public static UserContactNumData getContactData(String userID) throws IOException {
        UserContactNumData contact_data = new UserContactNumData();
        contact_data.setContactNumber("");
        contact_data.setUserID("");
        // Create Json instance
        Gson gson = new Gson();

        // Create a reader
        Reader reader = Files.newBufferedReader(Paths.get("data/userContactNumber.json"));

        // Convert JSON array to list of user contact datas
        List<UserContactNumData> userContactDatas = gson.fromJson(reader, new TypeToken<List<UserContactNumData>>() {
        }.getType());
        reader.close();

        // Find related user contact number data for login account
        for (UserContactNumData userContactData : userContactDatas) {
            if (userID.equals(userContactData.getUserID())) {
                contact_data = userContactData;
                break;
            }
        }

        // If not exist create new data into user contact number data
        if (contact_data.getUserID().equals("")) {
            contact_data.setUserID(userID);
            userContactDatas.add(contact_data);

            // Create writer
            Writer writer = Files.newBufferedWriter(Paths.get("data/userContactNumber.json"));
            // Convert new user contact datas to Json file
            gson.toJson(userContactDatas, writer);
            writer.close();
        }
        return contact_data;
    }
}
