package com.optum.stepDefs;

import com.optum.base.BaseUtil;
import com.optum.base.SauceUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Hooks extends BaseUtil {

    public static final String USERNAME = "twoolard";
    public static final String ACCESS_KEY = "84a41d20-3dd5-4405-8040-4d3cb9197047";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    public String sessionId;
    public String jobName;

    private BaseUtil base;
    public Hooks(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(Scenario scenario) throws Exception{

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "OS X 10.12");
        caps.setCapability("browserName", "safari");
        caps.setCapability("version", "10.0");
        caps.setCapability("parentTunnel", "sauce_admin");
        caps.setCapability("tunnelIdentifier", "OptumSharedTunnel-Prd");

        jobName = scenario.getName();
        caps.setCapability("name", jobName);

        base.driver = new RemoteWebDriver(new URL(URL), caps);
        base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sessionId = (((RemoteWebDriver) base.driver).getSessionId()).toString();

    }

    @After
    public void TearDown(Scenario scenario) throws Exception {
        base.driver.quit();
        SauceUtils.UpdateResults(USERNAME, ACCESS_KEY, !scenario.isFailed(), sessionId);
        System.out.println("SauceOnDemandSessionID=" + sessionId + "job-name=" + jobName);

    }
}
