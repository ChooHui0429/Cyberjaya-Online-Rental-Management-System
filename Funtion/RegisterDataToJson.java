package Funtion;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import DataClass.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RegisterDataToJson {
    public static void dataToJson(String name, String email, String securityPassword, String acc_type){
        try{
            // Create Json instance
            Gson gson = new Gson();

            // Create a reader 
            Reader reader = Files.newBufferedReader(Paths.get("Cyberjaya-Online-Rental-Management-System/Data/registerData.json"));

            // Convert JSON array to list of register datas
            List<RegisterData> registerDatas = gson.fromJson(reader, new TypeToken<List<RegisterData>>(){}.getType());
            reader.close();

            // Add new register data into created list
            RegisterData new_registerData = new RegisterData();
            new_registerData = getObjectData(new_registerData, name, email, securityPassword, acc_type);
            registerDatas.add(new_registerData);

            // Create writer
            Writer writer = Files.newBufferedWriter(Paths.get("Cyberjaya-Online-Rental-Management-System/Data/registerData.json"));
            // Convert register datas to Json file
            gson.toJson(registerDatas, writer);
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    // Get all the data from user input
    public static RegisterData getObjectData(RegisterData registerData, 
                                                String name, 
                                                String email, 
                                                String securityPassword, 
                                                String acc_type
                                            ){
        registerData.setName(name);
        registerData.setEmail(email);
        registerData.setSecurityPassword(securityPassword);
        registerData.setAccType(acc_type);

        return registerData;
    }
}
