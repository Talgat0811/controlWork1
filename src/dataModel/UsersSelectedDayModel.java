package dataModel;
import project.model.SelectedDay;

import java.util.List;

public class UsersSelectedDayModel {
    private List<SelectedDay> days;
    private SelectedDay day;

    public SelectedDay getDay() {
        return day;
    }

    public void setDay(SelectedDay day) {
        this.day = day;
    }

    public List<SelectedDay> getDays() {
        return days;
    }

    public void setDays(List<SelectedDay> days) {
        this.days = days;
    }
    public UsersSelectedDayModel(SelectedDay day) {
        this.day = day;
    }
    public UsersSelectedDayModel getUserSelectedDayModel(String bookId) {
        int id = Integer.parseInt(bookId);
        SelectedDay day = days.stream()
                .filter(e -> id == e.getDay())
                .findAny()
                .orElse(days.get(0));
        return new UsersSelectedDayModel(day);

    }

}
