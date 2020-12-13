package academy.learnprogramming.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {

    private static int idValue = 1;

    private final List<TodoItem> items = new ArrayList<>();

    public TodoData() {
        addItem(new TodoItem("first", "first detail", LocalDate.now()));
        addItem(new TodoItem("second", "second detail", LocalDate.now()));
        addItem(new TodoItem("third", "third detail", LocalDate.now()));
    }

    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem toAdd) {
        toAdd.setId(idValue);
        items.add(toAdd);
        idValue++;
    }

    public void removeItem(int id) {
        ListIterator<TodoItem> itemListIterator = items.listIterator();

        while (itemListIterator.hasNext()) {
            TodoItem todoItem = itemListIterator.next();
            if (todoItem.getId() == id) {
                itemListIterator.remove();
                break;
            }
        }
    }

    public TodoItem getTodoItem(int id) {
        for (TodoItem todoItem : items) {
            if (todoItem.getId() == id) {
                return todoItem;
            }
        }

        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate) {
        ListIterator<TodoItem> itemListIterator = items.listIterator();

        while (itemListIterator.hasNext()) {
            TodoItem todoItem = itemListIterator.next();
            if (todoItem.equals(toUpdate)) {
                itemListIterator.set(toUpdate);
                break;
            }
        }
    }

}
