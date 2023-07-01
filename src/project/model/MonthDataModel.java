package project.model;
import java.util.List;

public class MonthDataModel {
    private List<DayDataModel> dataModelList;

    public MonthDataModel(List<DayDataModel> days) {
        this.dataModelList = days;
    }
    public List<DayDataModel> getDataModelList() {
        return dataModelList;
    }

    public void setDataModelList(List<DayDataModel> dataModelList) {
        this.dataModelList = dataModelList;
    }


}
