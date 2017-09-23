package com.optum.stepDefs;

import com.optum.base.BaseUtil;
import com.optum.base.SauceUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.FileReader;
import java.util.Properties;

public class Hooks extends BaseUtil {

    public static final String USERNAME = "twoolard";
    public static final String sauceBrowser = "Sauce";
    public String browserType = "";


    public static final String ACCESS_KEY = "84a41d20-3dd5-4405-8040-4d3cb9197047";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    public String sessionId;
    public String jobName;
    protected static final String FirefoxConfig_FILE_RELATIVE_PATH = "src/test/resources/config/FirefoxConfigSauce";
    protected static final String ChromeConfig_FILE_RELATIVE_PATH = "src/test/resources/config/ChromeConfigSauce";
    protected static final String IEConfig_FILE_RELATIVE_PATH = "src/test/resources/config/IEConfigSauce";
    protected static final String SafariConfig_FILE_RELATIVE_PATH = "src/test/resources/config/SafariConfigSauce";
    protected static final String Firefox_Local_RELATIVE_PATH = "src/test/resources/config/FireFox";


    private BaseUtil base;
    public Hooks(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(Scenario scenario) throws Exception{

        try(FileReader reader = new FileReader(Firefox_Local_RELATIVE_PATH)){
            Properties properties = new Properties();
            properties.load(reader);
            browserType = properties.getProperty("browserType");
            if(browserType == sauceBrowser){
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platform", properties.getProperty("platform"));
                caps.setCapability("browserName", properties.getProperty("browserName"));
                caps.setCapability("version", properties.getProperty("version"));
                caps.setCapability("parentTunnel", properties.getProperty("parentTunnel"));
                caps.setCapability("tunnelIdentifier", properties.getProperty("tunnelIdentifier"));

                jobName = scenario.getName();
                caps.setCapability("name", jobName);
                base.driver = new RemoteWebDriver(new URL(URL), caps);
                sessionId = (((RemoteWebDriver) base.driver).getSessionId()).toString();


            } else {
                base.driver = new FirefoxDriver();
            }

            jobName = scenario.getName();
            base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @After
    public void TearDown(Scenario scenario) throws Exception {
        base.driver.quit();
        if (browserType == sauceBrowser){
            SauceUtils.UpdateResults(USERNAME, ACCESS_KEY, !scenario.isFailed(), sessionId);
            System.out.println("SessionID:" + sessionId + " " + "job-name:" + jobName + " " + "Tested on:" + browserType);

        } else{
            System.out.println("job-name:" + jobName + " " + "Tested on:" + browserType);

        }

    }
}
