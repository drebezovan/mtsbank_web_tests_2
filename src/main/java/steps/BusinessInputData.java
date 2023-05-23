package steps;

import lombok.Data;

import java.util.List;
@Data
public class BusinessInputData {
    private List<String> placeholderName;
    String categoryName;
    String telephone;
    String email;
    String organizationName;
    private List<String> nameOfSelectorField;
    String fullName;
    String errorMsg;
}
