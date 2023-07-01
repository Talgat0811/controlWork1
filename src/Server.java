import com.sun.net.httpserver.HttpExchange;
import project.model.DayDataModel;
import project.model.MonthDataModel;
import project.model.Patient;
import project.server.BasicServer;
import project.util.Utils;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class Server extends BasicServer {
    public Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/", this::mainHandler);
        registerGet("/myPatient",this::myPatientsHndler);
    }

    private void myPatientsHndler(HttpExchange exchange) {
        String queryParams =getQueryParams(exchange);
        Map<String,String> params = Utils.parseUrlEncoded(queryParams,"&");
        String dayId = params.getOrDefault("dayId","null");
        DayDataModel dataModel =getDayDataModel(dayId);
        renderTemplate(exchange, "/myPatient.ftlh",dataModel);

    }

    public void mainHandler(HttpExchange exchange) {
        renderTemplate(exchange, "main.ftlh",getMonthModel());
    }

    public List<Patient> getPatients(int i){
        List<Patient> patients = new ArrayList<>();
         Patient patient = new Patient(i,Generator.makeName(),Generator.makeName(),Generator.makeDataBorth(),Generator.getRandomBoolean(),Generator.makeDescription());
         patients.add(patient);
         return patients;
    }
    public MonthDataModel getMonthModel() {
        List<DayDataModel> days = new ArrayList<>();
        for(int i = 1; i<32;i++){
            days.add(new DayDataModel(i, LocalDate.of(2023, 7,i),getPatients(i)));
        }
        return new MonthDataModel(days);
    }
    public List<DayDataModel> getDaysDataModel() {
        List<DayDataModel> days = new ArrayList<>();
        for(int i = 1; i<32;i++){
            days.add(new DayDataModel(i, LocalDate.of(2023, 7,i),getPatients(i)));
        }
        return days;
    }
    public DayDataModel getDayDataModel(String dayId){
        List<DayDataModel> days = getDaysDataModel();
        int id = Integer.parseInt(dayId);
        for(DayDataModel day : days){
            if(id==day.getId()){
                return day;
            }
        }
        return null;
    }

}
