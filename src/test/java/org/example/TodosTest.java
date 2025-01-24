package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TodosSearchTwoMatches() {
        SimpleTask simpleTask = new SimpleTask(3, "Проверить тесты");

        String[] subtasks = {"Прослушать лекцию", "Просмотреть презентацию", "Написать тесты"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(555, "Написание автотестов", "Автотест", "Во вторник в 13 часов 15 минут"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("тесты");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TodosSearchZero() {
        SimpleTask simpleTask = new SimpleTask(3, "Проверить тесты");

        String[] subtasks = {"Прослушать лекцию", "Просмотреть презентацию", "Написать тесты"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(555, "Написание автотестов", "Автотест", "Во вторник в 13 часов 15 минут"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("код");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TodosSearchOneMatch() {
        SimpleTask simpleTask = new SimpleTask(3, "Проверить тесты");

        String[] subtasks = {"Прослушать лекцию", "Просмотреть презентацию", "Написать тесты"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(555, "Написание автотестов", "Автотест", "Во вторник в 13 часов 15 минут"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Прослушать");

        Assertions.assertArrayEquals(expected, actual);
    }
}
