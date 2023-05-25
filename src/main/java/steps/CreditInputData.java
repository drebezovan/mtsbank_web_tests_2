package steps;

import lombok.Data;

import java.util.List;

@Data
public class CreditInputData {
    String posterName;
    private List<String> creditSum;
    private List<String> creditPeriod;
    private List<String> typeOfIncome;
    private List<String> objectName;
    private List<String> city;
    private List<String> creditGoal;
}