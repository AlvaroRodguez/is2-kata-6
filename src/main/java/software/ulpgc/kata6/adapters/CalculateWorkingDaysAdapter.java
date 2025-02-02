package software.ulpgc.kata6.adapters;

import software.ulpgc.kata6.control.CalculateWorkingDaysCommand;
import spark.Request;
import spark.Response;

import java.time.LocalDate;

public class CalculateWorkingDaysAdapter {
    public static CalculateWorkingDaysCommand.Input adapt(Request request) {
        return new CalculateWorkingDaysCommand.Input() {
            @Override
            public LocalDate start() {
                return LocalDate.parse(request.queryParams("from"));
            }

            @Override
            public LocalDate end() {
                return LocalDate.parse(request.queryParams("to"));
            }
        };
    }

    public static CalculateWorkingDaysCommand.Output adapt(Response response) {
        return new CalculateWorkingDaysCommand.Output() {
            @Override
            public void days(int days) {
                response.body(String.valueOf(days));
            }
        };
    }
}
