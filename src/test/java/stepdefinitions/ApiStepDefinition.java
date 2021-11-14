package stepdefinitions;

import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import helpers.common.BaseHelper;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import utility.TestProperties;

import java.util.Objects;

import static utility.ComplexReportFactory.getTest;

public class ApiStepDefinition extends BaseHelper {

    private Response response;

    @Given("^I make a GET request with source language as \"([^\"]*)\" and word as \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iMakeAGETRequestWithForOriginCheck(String source_lang,String word_id, String fields, String strictMatch) {
        Headers headers = new Headers(headerListOrigin);
        RequestSpecification request = RestAssured.given().headers(headers);
        response = request.when().get(TestProperties.get("baseurl") + "/entries/" + source_lang + "/" + word_id +"?fields=" + fields + "&strictMatch=" +strictMatch);
        Assert.assertNotNull(response);
        Objects.requireNonNull(getTest()).log(LogStatus.PASS, "Request - " + TestProperties.get("baseurl") + "/entries/" + source_lang + "/" + word_id +"?fields=" + fields + "&strictMatch=" +strictMatch);
    }

        @And("^I check status code is \"([^\"]*)\"$")
    public void iValidateStatusCode(String result) {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, Integer.parseInt(result));
        Objects.requireNonNull(getTest()).log(LogStatus.PASS, "Status code is " +statusCode);
    }


    @Given("^I make a GET request with source language as \"([^\"]*)\" and target language as \"([^\"]*)\" and word as \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iMakeAGETRequestForTranslationCheck(String source_lang_translate, String target_lang_translate,String word_id, String strictMatch, String fields) {
        Headers headers = new Headers(headerListTranslation);
        RequestSpecification request = RestAssured.given().headers(headers);
        response = request.when().get(TestProperties.get("baseurl") + "/" + fields + "/" + source_lang_translate + "/" + target_lang_translate + "/" + word_id + "?strictMatch=" + strictMatch+ "&fields=" + fields);
        Assert.assertNotNull(response);
        Objects.requireNonNull(getTest()).log(LogStatus.PASS, "Request - " + TestProperties.get("baseurl") + "/" + fields + "/" + source_lang_translate + "/" + target_lang_translate + "/" + word_id + "?strictMatch=" + strictMatch+ "&fields=" + fields);
    }

    @Given("^I make GET request with source language as \"([^\"]*)\" and target language as \"([^\"]*)\" and word as \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iMakeAGETRequestForTranslationCheckFor400(String source_lang_translate, String target_lang_translate,String word_id, String strictMatch, String fields) {
        Headers headers = new Headers(headerListTranslation);
        RequestSpecification request = RestAssured.given().headers(headers);
        response = request.when().get(TestProperties.get("baseurl") + "/" + fields + "/" + source_lang_translate + "/" + target_lang_translate + "/" + word_id + "?abc=" + strictMatch + "&def=" + fields);
        Assert.assertNotNull(response);
        Objects.requireNonNull(getTest()).log(LogStatus.PASS, "Request - " + TestProperties.get("baseurl") + "/" + fields + "/" + source_lang_translate + "/" + target_lang_translate + "/" + word_id + "?abc=" + strictMatch+ "&def=" + fields);
    }

}
