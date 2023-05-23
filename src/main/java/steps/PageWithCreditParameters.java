package steps;

import java.util.HashMap;
import java.util.Map;

public interface PageWithCreditParameters {
    String getParameter(String nameOfParameter);

    default Map<String, String> getCreditParams() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("valueOfMonthlyPayment", this.getParameter("Ежемесячный платеж"));
        hashMap.put("valueOfBet", this.getParameter("Ставка"));
        hashMap.put("valueOfCreditSum", this.getParameter("Сумма кредита"));
        return hashMap;
    }
}
