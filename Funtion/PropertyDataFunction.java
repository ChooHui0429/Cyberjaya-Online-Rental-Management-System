package Funtion;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import DataClass.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PropertyDataFunction {
    public static void NewPropertyUpload(String owner_name, Integer rentalFee, String size, Integer NumRoom,
            Integer NumBathroom, String condition, String contactNum, String address, String facilities,
            String rentalAskFor, String propertyType, String status) throws IOException {

        // Create Json instance
        Gson gson = new Gson();
        // Create a reader
        Reader reader = Files.newBufferedReader(Paths.get("Data/propertyData.json"));

        // Convert JSON array to list of property datas
        List<PropertyData> propertyDatas = gson.fromJson(reader, new TypeToken<List<PropertyData>>() {
        }.getType());
        reader.close();

        // Create new property data
        PropertyData new_data = new PropertyData();
        Integer id_Num = 0;
        Boolean id_valid = false;

        // Check property data to prevent duplicate data id
        if (propertyDatas.size() != 0) {
            while (!id_valid) {
                Boolean id_exist = false;
                String id_string = String.format("%04d", id_Num);
                String new_ID = owner_name + "#" + id_string;
                for (PropertyData propertyData : propertyDatas) {
                    if (propertyData.getPropertyID().equals(new_ID)) {
                        id_Num = id_Num + 1;
                        id_exist = true;
                        break;
                    }
                }
                if (!id_exist) {
                    id_valid = true;
                    new_data.setPropertyID(new_ID);
                }
            }
        } else {
            String id_string = String.format("%04d", id_Num);
            String new_ID = owner_name + "#" + id_string + "_" + propertyType;
            new_data.setPropertyID(new_ID);
        }

        new_data.setRentalFee(rentalFee);
        new_data.setCategory(propertyType);
        new_data.setStatus(status);
        new_data.setAddress(address);
        new_data.setSize(size);
        new_data.setNumberRoom(NumRoom);
        new_data.setNumberBathroom(NumBathroom);
        new_data.setFacilities(facilities);
        new_data.setCondition(condition);
        new_data.setRentalAskFor(rentalAskFor);
        new_data.setContactNumber(contactNum);
        new_data.setAgentOwnerAcc(owner_name);

        propertyDatas.add(new_data);

        // Create writer
        Writer writer = Files.newBufferedWriter(Paths.get("Data/propertyData.json"));
        // Convert property datas to Json file
        gson.toJson(propertyDatas, writer);
        writer.close();
    }

    public static PropertyData GetSelectedProperty(String propertyID) throws IOException {
        // Create Json instance
        Gson gson = new Gson();
        // Create a reader
        Reader reader = Files.newBufferedReader(Paths.get("Data/propertyData.json"));

        // Convert JSON array to list of property datas
        List<PropertyData> propertyDatas = gson.fromJson(reader, new TypeToken<List<PropertyData>>() {
        }.getType());
        reader.close();

        PropertyData selected_data = new PropertyData();
        for (PropertyData propertyData : propertyDatas) {
            if (propertyData.getPropertyID().equals(propertyID)) {
                selected_data = propertyData;
                break;
            }
        }

        return selected_data;
    }

    public static void PropertyUpdate(String propertyID, String size, Integer rentalfee, Integer NumRoom,
            Integer NumBathroom, String condition, String contactNum, String address, String facilities,
            String rentalAskFor, String propertyType, String status) throws IOException {

        // Create Json instance
        Gson gson = new Gson();
        // Create a reader
        Reader reader = Files.newBufferedReader(Paths.get("Data/propertyData.json"));

        // Convert JSON array to list of property datas
        List<PropertyData> propertyDatas = gson.fromJson(reader, new TypeToken<List<PropertyData>>() {
        }.getType());
        reader.close();

        // Update property Data
        for (PropertyData propertyData : propertyDatas) {
            if (propertyData.getPropertyID().equals(propertyID)) {
                propertyData.setCategory(propertyType);
                propertyData.setStatus(status);
                propertyData.setAddress(address);
                propertyData.setSize(size);
                propertyData.setNumberRoom(NumRoom);
                propertyData.setNumberBathroom(NumBathroom);
                propertyData.setFacilities(facilities);
                propertyData.setCondition(condition);
                propertyData.setRentalAskFor(rentalAskFor);
                propertyData.setContactNumber(contactNum);
                propertyData.setRentalFee(rentalfee);
            }
        }

        // Create writer
        Writer writer = Files.newBufferedWriter(Paths.get("Data/propertyData.json"));
        // Convert property datas to Json file
        gson.toJson(propertyDatas, writer);
        writer.close();
    }
}
