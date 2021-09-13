import duke.Deadline;
import duke.Event;
import duke.Parser;
import duke.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class containing tests to check the correctness of the program.
 */
public class DukeTest {

    /**
     * Checks if todo tasks are created correctly
     */
    @Test
    public void todoCreation_todoTask_success(){
        assertEquals(new Todo(" return book").toString(), "[T][ ] return book");
    }

    /**
     * Checks if event tasks are created correctly
     */
    @Test
    public void eventCreation_eventTask_success(){
        assertEquals(new Event(" return book", "23/08/2021 16:00-20:00").toString(),
                "[E][ ] return book (at: 23 Aug 2021 16:00 to 20:00)");
    }

    /**
     * Checks if deadline tasks are displayed correctly to users
     */
    @Test
    public void deadlineCreation_deadlineTask_success(){
        assertEquals(new Deadline(" return book", "23/08/2021 17:00").toString(),
                "[D][ ] return book (by: 23 Aug 2021 17:00)");
    }

    /**
     * Checks if deadline tasks are saved in the correct format in user's hard disk
     */
    @Test
    public void deadlinePrintToFile_deadlineTask_success(){
        assertEquals(new Deadline(" return book", "23/08/2021 17:00").toPrintToFile(),
                "[D][ ] return book (by: 23/08/2021 17:00)");
    }

    /**
     * Checks if Parse.parseCommand() works correctly
     */
    @Test
    public void parseCommand_doneTask_success() {
        assertEquals(Parser.parseCommand("done 1"), "done");
    }
}