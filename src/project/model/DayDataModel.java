package project.model;

import java.time.LocalDate;
import java.util.List;

public class DayDataModel {
    private Integer id;
    private LocalDate day;
    private List<Patient> patients;


    public DayDataModel(int id, LocalDate day, List<Patient> patients) {
        this.id = id;
        this.day = day;
        this.patients = patients;
    }
    public DayDataModel(LocalDate id) {
        this.day = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }
}
