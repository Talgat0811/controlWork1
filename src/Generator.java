import project.model.Patient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Generator {
    private static final List<String> loremWords;
    private static final Random r = new Random();

    static {
        loremWords = prepareLorem();
        loremWords.removeIf(String::isBlank);
        loremWords.removeIf(String::isEmpty);
    }

    public static boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public static LocalDate makeDataBorth() {
        LocalDate start = LocalDate.of(1970, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, LocalDate.now());
        return start.plusDays(new Random().nextInt((int) days + 1));
    }
    private static List<String> prepareLorem() {
        try {
            var rawLorem = Files.readString(Paths.get("src\\lorem.txt"));
            return Arrays.stream(rawLorem.split("\\s"))
                    .map(String::toLowerCase)
                    .map(String::strip)
                    .distinct().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    public static String makeDescription() {
        return makeGibberish(20, 10);
    }
    public static List<Patient> getPatients(int i){
        Random random = new Random();
        int count = random.nextInt(1,10);
        List<Patient> patients = new ArrayList<>();
        for(int j = 1; j<count; j++){
            patients.add(new Patient(i,Generator.makeName(),Generator.makeName(),Generator.makeDataBorth(),Generator.getRandomBoolean(),Generator.makeDescription(),getRndLocalTime()));
        }
        return patients;
    }
    public static LocalTime getRndLocalTime(){
        LocalTime time1 = LocalTime.of(8, 0, 0);
        LocalTime time2 = LocalTime.of(15, 0, 0);
        Random rand = new Random();

        int hours = rand.nextInt((time2.getHour() - time1.getHour()) + 1) + time1.getHour();
        int minutes =  rand.nextInt((time2.getMinute() - time1.getMinute()) + 1) + time1.getMinute();
        int seconds = rand.nextInt((time2.getSecond() - time1.getSecond()) + 1) + time1.getSecond();

        LocalTime random = LocalTime.of(hours,minutes,seconds);
        return random;
    }

    private static String makeGibberish(int randomAmount, int min) {
        if (randomAmount <= 0) {
            randomAmount = 1;
        }

        var wordCount = r.nextInt(randomAmount)+min;
        if (wordCount < 1) {
            wordCount = 1;
        }
        var gibberish = Stream.generate(Generator::takeOneWord).limit(wordCount).collect(Collectors.joining(" ")).strip();
        gibberish = Character.toUpperCase(gibberish.charAt(0)) + gibberish.substring(1);
        if (gibberish.endsWith(",")) {
            gibberish = gibberish.substring(0, gibberish.length() - 2);
        }
        return  gibberish.endsWith(".") ? gibberish : gibberish + ".";
    }

    public static String makeName() {
        return makeGibberish(3,2);
    }

    private static String takeOneWord() {
        return loremWords.get(r.nextInt(loremWords.size()));
    }

    static final Pattern removeExtra = Pattern.compile("[.,;]+?");
    public static String makeEmail() {
        var prefix = removeExtra.matcher(makeGibberish(2,0)).replaceAll("").toLowerCase();
        var suffix = removeExtra.matcher(makeGibberish(2,0)).replaceAll("").toLowerCase();
        var email =  prefix + "@" + suffix;
        return email.replace(" ", "");
    }

    public static String makePassword() {
        return removeExtra.matcher(makeGibberish(0,1))
                .replaceAll("")
                .replace(" ", "");
    }
}