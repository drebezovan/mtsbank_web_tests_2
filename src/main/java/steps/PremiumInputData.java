package steps;

import lombok.Data;

import java.util.List;

@Data
public class PremiumInputData {
    private String categoryName;
    private List<String> category;
    private List<String> posterName;
}