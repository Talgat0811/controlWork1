package project.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dataModel.UsersSelectedDayModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATHofSelectedDay = Paths.get("data\\json\\selectedDay.json");
    public  UsersSelectedDayModel readJsonFile() {
        UsersSelectedDayModel model = null;
        try {
            String json = Files.readString(PATHofSelectedDay);
            model = GSON.fromJson(json, UsersSelectedDayModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;
    }



}
