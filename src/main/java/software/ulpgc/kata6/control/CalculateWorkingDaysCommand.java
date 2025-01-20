package software.ulpgc.kata6.control;

import software.ulpgc.kata6.model.Calendar;

import java.time.LocalDate;

public class CalculateWorkingDaysCommand implements Command {
    private final Input input;
    private final Calendar calendar;
    private final Output output;

    public CalculateWorkingDaysCommand(Input input, Calendar calendar, Output output) {
        this.input = input;
        this.calendar = calendar;
        this.output = output;
    }

    @Override
    public void execute() {
        int days = 0;
        for (LocalDate localDate : calendar.from(input.start())) {
            if (localDate.isAfter(input.end())) break;
            days++;
        }
        output.days(days);
    }

    public interface Input {
        LocalDate start();
        LocalDate end();
    }

    public interface Output {
        void days(int days);
    }
}
