import com.sun.net.httpserver.HttpExchange;
import project.model.DayDataModel;
import project.model.MonthDataModel;
import project.model.Patient;
import project.server.BasicServer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Server extends BasicServer {
    public Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/", this::mainHandler);
    }
    public void mainHandler(HttpExchange exchange) {
        renderTemplate(exchange, "main.ftlh",getMonthModel());
    }
    public MonthDataModel getMonthModel() {
        List<DayDataModel> days = new ArrayList<>();
        for(int i = 1; i<32;i++){
            days.add(new DayDataModel(i, LocalDate.of(2023, 7,i),getPatients(i)));
        }
        return new MonthDataModel(days);
    }
    public List<Patient> getPatients(int i){
        List<Patient> patients = new ArrayList<>();
         Patient patient = new Patient(i,Generator.makeName(),Generator.makeName(),Generator.makeDataBorth(),true,Generator.makeDescription());
         patients.add(patient);
         return patients;
    }

}
