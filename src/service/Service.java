package service;

import project.model.DayDataModel;
import project.model.MonthDataModel;

import java.util.List;

public class Service {
    private List<DayDataModel> dayDataModels;
    private List<MonthDataModel> monthDataModels;

    public Service(List<DayDataModel> dayDataModels, List<MonthDataModel> monthDataModels) {
        this.dayDataModels = dayDataModels;
    }

}
