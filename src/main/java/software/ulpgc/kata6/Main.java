package software.ulpgc.kata6;

import software.ulpgc.kata6.adapters.CalculateWorkingDateAdapter;
import software.ulpgc.kata6.adapters.CalculateWorkingDaysAdapter;
import software.ulpgc.kata6.control.CalculateWorkingDateCommand;
import software.ulpgc.kata6.control.CalculateWorkingDaysCommand;
import software.ulpgc.kata6.model.Calendar;
import spark.Request;
import spark.Response;

public class Main {
    public static void main(String[] args) {
        new WebService(commandFactory()).init();
    }

    private static CommandFactory commandFactory() {
        return new CommandFactory()
                .add("working-date", Main::createWorkingDateCommand)
                .add("working-days", Main::createWorkingDaysCommand)
                ;
    }

    private static CalculateWorkingDateCommand createWorkingDateCommand(Request request, Response response) {
        return new CalculateWorkingDateCommand(
                CalculateWorkingDateAdapter.adapt(request),
                new Calendar(),
                CalculateWorkingDateAdapter.adapt(response)
        );
    }

    private static CalculateWorkingDaysCommand createWorkingDaysCommand(Request request, Response response) {
        return new CalculateWorkingDaysCommand(
                CalculateWorkingDaysAdapter.adapt(request),
                new Calendar(),
                CalculateWorkingDaysAdapter.adapt(response)
        );
    }



}
