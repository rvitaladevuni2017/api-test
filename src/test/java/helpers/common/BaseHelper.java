package helpers.common;

import io.restassured.http.Header;
import utility.TestProperties;
import java.util.LinkedList;
import java.util.List;

public class BaseHelper {
    protected  static List<Header> headerListOrigin;
    protected  static List<Header> headerListTranslation;

    public BaseHelper() {
        headerListOrigin = new LinkedList<>();
        headerListOrigin.add(new Header("app_id", TestProperties.get("app_id_origin")));
        headerListOrigin.add(new Header("app_key", TestProperties.get("app_key_origin")));

        headerListTranslation = new LinkedList<>();
        headerListTranslation.add(new Header("app_id", TestProperties.get("app_id_translation")));
        headerListTranslation.add(new Header("app_key", TestProperties.get("app_key_translation")));


    }
}
