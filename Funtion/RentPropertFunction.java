package Funtion;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import DataClass.PropertyData;
import DataClass.RentPropertyData;

public class RentPropertFunction {
    public static void NewRentData(String acc_ID, String propertyID) throws IOException{
        RentPropertyData new_data = new RentPropertyData();
        new_data.setUserID(acc_ID);
        new_data.setPropertyID(propertyID);
        
        new_data.setStatus("In Progress");

        // Create Json instance
        Gson gson = new Gson();

        // Create a reader 
        Reader readerpropertyDatas = Files.newBufferedReader(Paths.get("Cyberjaya-Online-Rental-Management-System/Data/propertyData.json"));

        // Convert JSON array to list of property datas
        List<PropertyData> propertyDatas = gson.fromJson(readerpropertyDatas, new TypeToken<List<PropertyData>>(){}.getType());
        readerpropertyDatas.close();

        for (PropertyData propertyData : propertyDatas){
            if(propertyData.getPropertyID().equals(propertyID)){
                new_data.setOwnerAgentID(propertyData.getAgentOwnerAcc());
                break;
            }
        }

        

        // Create a reader 
        Reader readerRentPropertyDatas = Files.newBufferedReader(Paths.get("Cyberjaya-Online-Rental-Management-System/Data/RentPropertyData.json"));

        // Convert JSON array to list of Rent Property datas
        List<RentPropertyData> rentPropertyDatas = gson.fromJson(readerRentPropertyDatas, new TypeToken<List<RentPropertyData>>(){}.getType());
        readerRentPropertyDatas.close();

        // Add new data
        rentPropertyDatas.add(new_data);

        // Create writer
        Writer writer = Files.newBufferedWriter(Paths.get("Cyberjaya-Online-Rental-Management-System/Data/RentPropertyData.json"));
        // Convert property datas to Json file
        gson.toJson(rentPropertyDatas, writer);
        writer.close();
    }
    
}
