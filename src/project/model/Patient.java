package project.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Patient {
    private int id;
    private String name;
    private String lastName;
    private LocalDate date;
    private boolean type;
    private String analyze;
    private LocalTime time;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Patient(int id, String name, String lastName, LocalDate date, boolean type, String analyze, LocalTime time) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.date = date;
        this.type = type;
        this.analyze = analyze;
        this.time = time;
    }
    public Patient(){};



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getAnalyze() {
        return analyze;
    }

    public void setAnalyze(String analyze) {
        this.analyze = analyze;
    }
}