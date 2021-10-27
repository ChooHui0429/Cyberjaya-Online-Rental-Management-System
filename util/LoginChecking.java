package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import dataclass.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LoginChecking {
    public static String loginChecker(String userID, String password) throws IOException {
        String acc_type_or_invalid = new String();

        // Create Json instance
        Gson gson = new Gson();

        // Create a reader
        Reader reader = Files.newBufferedReader(Paths.get("./data/accountData.json"));

        // Convert JSON array to list of account datas
        List<VerifiedUser> accountDatas = gson.fromJson(reader, new TypeToken<List<VerifiedUser>>() {
        }.getType());
        reader.close();

        // Check the login validity
        for (VerifiedUser accountData : accountDatas) {
            if (userID.equals(accountData.getuserID())) {
                if (password.equals(accountData.getloginPassword())) {
                    acc_type_or_invalid = accountData.getAccType();
                    break;
                } else {
                    acc_type_or_invalid = "Password incorrect. Please Check your user ID and password carefully.";
                    break;
                }
            } else {
                acc_type_or_invalid = "User ID doesn't exist. Please Check your user ID and password carefully.";
            }
        }
        return acc_type_or_invalid;
    }

    public static String userNameReturn(String userID) throws IOException {
        String name = new String();
        // Create Json instance
        Gson gson = new Gson();

        // Create a reader
        Reader reader = Files.newBufferedReader(Paths.get("./data/accountData.json"));

        // Convert JSON array to list of account datas
        List<VerifiedUser> accountDatas = gson.fromJson(reader, new TypeToken<List<VerifiedUser>>() {
        }.getType());
        reader.close();

        for (VerifiedUser accountData : accountDatas) {
            if (userID.equals(accountData.getuserID())) {
                name = accountData.getName();
            }
        }
        return name;
    }
}
