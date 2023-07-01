package project.model;

import java.time.LocalDate;
import java.util.List;

public class DayDataModel {
    private int id;
    private LocalDate day;
    private List<Patient> patients;


    public DayDataModel(int id, LocalDate day, List<Patient> patients) {
        this.id = id;
        this.day = day;
        this.patients = patients;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }
}
