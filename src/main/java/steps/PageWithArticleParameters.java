package steps;

import java.util.HashMap;
import java.util.Map;

public interface PageWithArticleParameters {
    String getArticleCategory();
    String getArticleReadingTime();
    String getArticleName();
    String getArticleDate();
    default Map<String, String> getArticleParams() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("articleCategory", this.getArticleCategory());
        hashMap.put("articleReadingTime", this.getArticleReadingTime());
        hashMap.put("articleName", this.getArticleName());
        hashMap.put("articleDate", this.getArticleDate());
        return hashMap;
    }
}