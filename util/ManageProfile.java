package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import dataclass.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Methods involving user profile
 * 
 * @author Tan Choo Hui
 * @author Lim Tian Hee
 */
public class ManageProfile {
    /**
     * Updates user profile
     * 
     * @param userID            String
     * @param new_Name          String
     * @param new_Email         String
     * @param new_ContactNumber String
     * 
     * @author Tan Choo Hui
     * @author Lim Tian Hee
     */
    public static void updateProfile(String userID, String new_Name, String new_Email, String new_ContactNumber)
            throws IOException {

        // Create Json instance
        Gson gson = new Gson();

        // Create a reader
        Reader readerAcc = Files.newBufferedReader(Paths.get("data/accountData.json"));
        Reader readerContactNum = Files.newBufferedReader(Paths.get("data/userContactNumber.json"));

        // Convert JSON array to list
        List<VerifiedUser> accountDatas = gson.fromJson(readerAcc, new TypeToken<List<VerifiedUser>>() {
        }.getType());
        readerAcc.close();
        List<UserContactNumber> userContactDatas = gson.fromJson(readerContactNum,
                new TypeToken<List<UserContactNumber>>() {
                }.getType());
        readerContactNum.close();

        // Update Account Data
        for (VerifiedUser accountData : accountDatas) {
            if (userID.equals(accountData.getuserID())) {
                accountData.setName(new_Name);
                accountData.setEmail(new_Email);
            }
        }

        // Update User Contact Data
        for (UserContactNumber userContactData : userContactDatas) {
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

    /**
     * Get user account data by id
     * 
     * @param userID String
     * @return VerifiedUser
     * 
     * @author Tan Choo Hui
     * @author Lim Tian Hee
     */
    public static VerifiedUser getAccData(String userID) throws IOException {
        VerifiedUser acc_data = new VerifiedUser();
        // Create Json instance
        Gson gson = new Gson();

        // Create a reader
        Reader reader = Files.newBufferedReader(Paths.get("data/accountData.json"));

        // Convert JSON array to list of account datas
        List<VerifiedUser> accountDatas = gson.fromJson(reader, new TypeToken<List<VerifiedUser>>() {
        }.getType());
        reader.close();

        // Find related account data for login account
        for (VerifiedUser accountData : accountDatas) {
            if (userID.equals(accountData.getuserID())) {
                acc_data = accountData;
                break;
            }
        }

        return acc_data;
    }

    /**
     * Get user's contact info
     * 
     * @param userID String
     * @return UserContactNumber
     * 
     * @author Tan Choo Hui
     * @author Lim Tian Hee
     */
    public static UserContactNumber getContactData(String userID) throws IOException {
        UserContactNumber contact_data = new UserContactNumber();
        contact_data.setContactNumber("");
        contact_data.setUserID("");
        // Create Json instance
        Gson gson = new Gson();

        // Create a reader
        Reader reader = Files.newBufferedReader(Paths.get("data/userContactNumber.json"));

        // Convert JSON array to list of user contact datas
        List<UserContactNumber> userContactDatas = gson.fromJson(reader, new TypeToken<List<UserContactNumber>>() {
        }.getType());
        reader.close();

        // Find related user contact number data for login account
        for (UserContactNumber userContactData : userContactDatas) {
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
