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
import java.io.FileReader;
import java.util.Properties;

public class Hooks extends BaseUtil {

    public static final String USERNAME = "twoolard";
    public static final String ACCESS_KEY = "84a41d20-3dd5-4405-8040-4d3cb9197047";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    public String sessionId;
    public String jobName;
    protected static final String FirefoxConfig_FILE_RELATIVE_PATH = "src/test/resources/config/FirefoxConfig";
    protected static final String ChromeConfig_FILE_RELATIVE_PATH = "src/test/resources/config/ChromeConfig";
    protected static final String IEConfig_FILE_RELATIVE_PATH = "src/test/resources/config/IEConfig";
    protected static final String SafariConfig_FILE_RELATIVE_PATH = "src/test/resources/config/SafariConfig";


    private BaseUtil base;
    public Hooks(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(Scenario scenario) throws Exception{

        try(FileReader reader = new FileReader(IEConfig_FILE_RELATIVE_PATH)){
            Properties properties = new Properties();
            properties.load(reader);

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platform", properties.getProperty("platform"));
            caps.setCapability("browserName", properties.getProperty("browserName"));
            caps.setCapability("version", properties.getProperty("version"));
            caps.setCapability("parentTunnel","sauce_admin");
            caps.setCapability("tunnelIdentifier", "OptumSharedTunnel-Prd");

            jobName = scenario.getName();
            caps.setCapability("name", jobName);

            base.driver = new RemoteWebDriver(new URL(URL), caps);
            base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            sessionId = (((RemoteWebDriver) base.driver).getSessionId()).toString();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @After
    public void TearDown(Scenario scenario) throws Exception {
        base.driver.quit();
        SauceUtils.UpdateResults(USERNAME, ACCESS_KEY, !scenario.isFailed(), sessionId);
        System.out.println("SauceOnDemandSessionID=" + " " + sessionId + "job-name=" + " " + jobName + "Tested on" + " ");

    }
}
