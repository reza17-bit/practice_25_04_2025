package testcase;
import base.BaseApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ApiUtils;

public class ApiTest extends base.BaseApi {

    @Test
    public void testGetEndpoint() {
        Response response = ApiUtils.getRequest("/endpoint");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}