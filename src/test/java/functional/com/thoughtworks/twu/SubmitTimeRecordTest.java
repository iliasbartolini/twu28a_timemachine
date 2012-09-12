package functional.com.thoughtworks.twu;

import constants.TestData;
import org.junit.Before;

public class SubmitTimeRecordTest extends  BaseTest{

    public SubmitTimeRecordTest() throws Exception{
        super();
    }

    @Before
    public void setup() {
        super.setUpAndroid();
        webDriver.get(dashboardUrl);
        super.submitCredentials(TestData.validPasswordString);
        webDriver.get(timeRecordUrl);

    }
}
