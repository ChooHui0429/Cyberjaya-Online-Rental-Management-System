package Funtion;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import DataClass.AccountData;

public class RemoveUser {
    public static void RejectUserData(String name, String email, String securityPassword, String acc_type,
            String userID, String loginPassword) throws IOException {

        // Removed account data
        AccountData accountData = new AccountData();

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
            Reader reader = Files
                    .newBufferedReader(Paths.get("Cyberjaya-Online-Rental-Management-System/Data/removedData.json"));

            // Convert JSON array to list of removed datas
            List<AccountData> removedDatas = gson.fromJson(reader, new TypeToken<List<AccountData>>() {
            }.getType());
            reader.close();

            // Add new removed account data into created list
            removedDatas.add(accountData);

            // Create writer
            Writer writer = Files
                    .newBufferedWriter(Paths.get("Cyberjaya-Online-Rental-Management-System/Data/removedData.json"));
            // Convert removed account data to Json file
            gson.toJson(removedDatas, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DeleteAccountData(accountData);

    }

    public static void DeleteAccountData(AccountData removeData) {
        try {
            // Create Json instance
            Gson gson = new Gson();

            // Create a reader
            Reader reader = Files
                    .newBufferedReader(Paths.get("Cyberjaya-Online-Rental-Management-System/Data/accountData.json"));

            // Convert JSON array to list of account datas
            List<AccountData> accountDatas = gson.fromJson(reader, new TypeToken<List<AccountData>>() {
            }.getType());
            reader.close();

            // Remove account data
            List<AccountData> selectedAccountDatas = new ArrayList<AccountData>();
            String removeDataEmail = removeData.getEmail();
            for (AccountData accountData : accountDatas) {
                if (accountData.getEmail().equals(removeDataEmail)) {
                    selectedAccountDatas.add(accountData);
                }
            }
            accountDatas.removeAll(selectedAccountDatas);

            // Create writer
            Writer writer = Files
                    .newBufferedWriter(Paths.get("Cyberjaya-Online-Rental-Management-System/Data/accountData.json"));
            // Convert register datas to Json file
            gson.toJson(accountDatas, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
