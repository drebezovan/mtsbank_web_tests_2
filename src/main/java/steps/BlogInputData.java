package steps;

import lombok.Data;

import java.util.List;
@Data
public class BlogInputData {
    private List<String> category;
    private String posterName;
    private String categoryName;
}
