import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldFindQueryInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(55, "Позвонить родителям");

        simpleTask.matches("Позвонить");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFalseQueryNotFoundInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(55, "Позвонить родителям");

        simpleTask.matches("Заказать");

        boolean expected = false;
        boolean actual = simpleTask.matches("Заказать");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInTopicMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        meeting.matches("Выкатка");

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInProjectMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        meeting.matches("НетоБанка");

        boolean expected = true;
        boolean actual = meeting.matches("НетоБанка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFalseQueryInMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        meeting.matches("вторник");

        boolean expected = false;
        boolean actual = meeting.matches("вторник");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFalseQueryInMeetingAnywhere() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        meeting.matches("онлайн");

        boolean expected = false;
        boolean actual = meeting.matches("онлайн");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInSubTasksEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        epic.matches("Хлеб");

        boolean actual = epic.matches("Хлеб");

        Assertions.assertTrue(actual);
    }


    @Test
    public void shouldFindZeroQueryInSubTasksEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        epic.matches("Кефир");


        boolean actual = epic.matches("Кефир");

        Assertions.assertFalse(actual);
    }
}
