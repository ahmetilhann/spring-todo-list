package academy.learnprogramming.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
public class TodoItem {

    private int id;
    private String title;
    private String detail;
    private LocalDate localDate;

    public TodoItem(String title, String detail, LocalDate localDate) {
        this.title = title;
        this.detail = detail;
        this.localDate = localDate;
    }
}
