package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void testSimpleTaskTrue() {

        SimpleTask task = new SimpleTask(87, "Сдать табеля");

        boolean actual = task.matches("Сдать");

        Assertions.assertTrue(actual);

    }

    @Test
    public void testSimpleTaskFalse() {

        SimpleTask task = new SimpleTask(87, "Сдать табеля");

        boolean actual = task.matches("Позвонить");

        Assertions.assertFalse(actual);


    }

    @Test
    public void testEpicTrue() {
        String[] subtasks = {"Табеля отправить", "Проверить почту"};
        Epic task = new Epic(97, subtasks);

        boolean actual = task.matches("почту");

        Assertions.assertTrue(actual);

    }

    @Test
    public void testEpicFalse() {

        String[] subtasks = {"Табеля отправить", "Проверить почту"};
        Epic task = new Epic(97, subtasks);

        boolean actual = task.matches("Приказ");

        Assertions.assertFalse(actual);


    }

    @Test
    public void testMeetingTopicTrue() {

        Meeting task = new Meeting(132, "Программирование и тестирование", "Написание автотестов", "29 февраля в 15 часов 30 минут");

        boolean actual = task.matches("тестирование");

        Assertions.assertTrue(actual);

    }

    @Test
    public void testMeetingProjectTrue() {

        Meeting task = new Meeting(132, "Программирование и тестирование", "Тестирование кода. Автотесты", "29 февраля в 15 часов 30 минут");

        boolean actual = task.matches("Автотесты");

        Assertions.assertTrue(actual);

    }


    @Test
    public void testMeetingFalse() {

        Meeting task = new Meeting(132, "Программирование и тестирование", "Тестирование кода. Автотесты", "29 февраля в 15 часов 30 минут");

        boolean actual = task.matches("Проектирование");

        Assertions.assertFalse(actual);


    }
}

