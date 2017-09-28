package com.company.stepDefs;

import com.company.base.BaseUtil;
import com.company.base.SauceUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileReader;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks extends BaseUtil {
    public static final String USERNAME = System.getenv("SAUCE_USERNAME");
    public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
    public static final String sauceBrowser = "Sauce";
    public String browserType = "";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    public String sessionId;
    public String jobName;
    protected static final String Config_FILE_RELATIVE_PATH = "src/test/resources/config/FireFox";

    private BaseUtil base;

    public Hooks(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(Scenario scenario) throws Exception {

        try (FileReader reader = new FileReader(Config_FILE_RELATIVE_PATH)) {
            DesiredCapabilities caps = new DesiredCapabilities();
            Properties properties = new Properties();
            properties.load(reader);
            browserType = properties.getProperty("browserType");
            if (browserType.equals(sauceBrowser)) {
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
                if (properties.getProperty("browserName").equals("firefox")) {
                    base.driver = new FirefoxDriver();

                } else if (properties.getProperty("browserName").equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/ui/config/chromedriver.exe");

                    ChromeOptions options = new ChromeOptions();

                    options.addArguments("test-type");

                    options.addArguments("no-sandbox");

                    options.addArguments("disable-extensions");

                    options.addArguments("start-maximized");

                    options.addArguments("--js-flags=--expose-gc");

                    options.addArguments("disable-plugins");

                    options.addArguments("--enable-precise-memory-info");

                    options.addArguments("--disable-popup-blocking");

                    options.addArguments("--disable-default-apps");

                    options.addArguments("test-type=browser");

                    options.addArguments("disable-infobars");

                    caps.setCapability(ChromeOptions.CAPABILITY, options);

                    base.driver = new ChromeDriver(options);
                } else if (properties.getProperty("browserName").equals("IE")) {
                    System.setProperty("webdriver.ie.driver", "src/main/resources/ui/config/IEDriverServer.exe");

                    caps.setCapability("EnableNativeEvents", false);

                    caps.setCapability("ignoreZoomSetting", true);

                    caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

                    base.driver = new InternetExplorerDriver(caps);
                }
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
        if (browserType.equals(sauceBrowser)) {
            SauceUtils.UpdateResults(USERNAME, ACCESS_KEY, !scenario.isFailed(), sessionId);
            System.out.println("SessionID:" + sessionId + " " + "job-name:" + jobName + " " + "Tested on:" + browserType);

            if (scenario.isFailed()) {
                byte[] screenshot = getScreenshot(base.driver);
                scenario.embed(screenshot, "image/png");
            }
        } else {
            System.out.println("job-name:" + jobName + " " + "Tested on:" + browserType);

            if (scenario.isFailed()) {
                byte[] screenshot = getScreenshot(base.driver);
                scenario.embed(screenshot, "image/png");
            }

        }

    }

    public byte[] getScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}



