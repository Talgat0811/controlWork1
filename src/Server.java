import com.sun.net.httpserver.HttpExchange;
import dataModel.UsersSelectedDayModel;
import project.server.BasicServer;
import project.util.FileService;
import project.util.Utils;

import java.io.IOException;
import java.util.Map;


public class Server extends BasicServer {
    public Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/", this::mainHandler);
        registerGet("/myPatient",this::myPatientHandler);

    }

    private void myPatientHandler(HttpExchange exchange) {
        String queryParams =getQueryParams(exchange);
        Map<String,String> params = Utils.parseUrlEncoded(queryParams,"&");
        String dayid = params.getOrDefault("id","null");
        UsersSelectedDayModel usersSelectedDayModel = new FileService().readJsonFile();
        renderTemplate(exchange, "myPatient.ftlh",usersSelectedDayModel.getUserSelectedDayModel(dayid));
    }

    private void mainHandler(HttpExchange exchange) {
        UsersSelectedDayModel usersSelectedDayModel = new FileService().readJsonFile();
        renderTemplate(exchange,"main.ftlh",usersSelectedDayModel);
    }

}
