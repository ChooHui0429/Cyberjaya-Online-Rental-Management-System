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

public class RemoveUser {
    public static void removeUserFromData(String name, String email, String securityPassword, String acc_type,
            String userID, String loginPassword) throws IOException {

        // Removed account data
        VerifiedUser accountData = new VerifiedUser();

        accountData.setName(name);
        accountData.setEmail(email);
        accountData.setSecurityPassword(securityPassword);
        accountData.setAccType(acc_type);
        accountData.setloginPassword(loginPassword);
        accountData.setuserID(userID);

        try {
            // Create Json instance
            Gson gson = new Gson();

            // Create a reader
            Reader reader = Files.newBufferedReader(Paths.get("data/removedData.json"));

            // Convert JSON array to list of removed datas
            List<VerifiedUser> removedDatas = gson.fromJson(reader, new TypeToken<List<VerifiedUser>>() {
            }.getType());
            reader.close();

            // Add new removed account data into created list
            removedDatas.add(accountData);

            // Create writer
            Writer writer = Files.newBufferedWriter(Paths.get("data/removedData.json"));
            // Convert removed account data to Json file
            gson.toJson(removedDatas, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        deleteVerifiedUser(accountData);

    }

    public static void deleteVerifiedUser(VerifiedUser removeData) {
        try {
            // Create Json instance
            Gson gson = new Gson();

            // Create a reader
            Reader reader = Files.newBufferedReader(Paths.get("data/accountData.json"));

            // Convert JSON array to list of account datas
            List<VerifiedUser> accountDatas = gson.fromJson(reader, new TypeToken<List<VerifiedUser>>() {
            }.getType());
            reader.close();

            // Remove account data
            List<VerifiedUser> selectedVerifiedUsers = new ArrayList<VerifiedUser>();
            String removeDataEmail = removeData.getEmail();
            for (VerifiedUser accountData : accountDatas) {
                if (accountData.getEmail().equals(removeDataEmail)) {
                    selectedVerifiedUsers.add(accountData);
                }
            }
            accountDatas.removeAll(selectedVerifiedUsers);

            // Create writer
            Writer writer = Files.newBufferedWriter(Paths.get("data/accountData.json"));
            // Convert register datas to Json file
            gson.toJson(accountDatas, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
