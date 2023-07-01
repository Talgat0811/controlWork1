import project.util.FileService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            new Server("localhost", 9890).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}