package initialization;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import utility.Util;

public class Initialization {
    @BeforeTest
    public void beforeTest(){
        Configuration.timeout = 15000;

        String user = Config.getUser();
        System.out.println(user);

        String browser = Config.getBrowser();
        System.out.println(browser);

        String browser_version = Config.getBrowserVersion();
        System.out.println('v' + browser_version);

        if (browser.equalsIgnoreCase("chrome")) {
            Configuration.browser = browser;
            String chromedriver_version = getChromeDriverVersion(Integer.parseInt(browser_version));

            //WebDriverManager: http://automation-remarks.com/selenium-webdriver-manager/index.html
            WebDriverManager.chromedriver().version(chromedriver_version).setup();
        }

        Configuration.reportsFolder = System.getProperty("user.dir")+"/reports";
    }

    // TODO: move the dataset into a separate file or database(ex.: SQLite)
    private String getChromeDriverVersion(int cv){ //Parameter - Chrome's version
        String chromedriver_version = "2.35";
        //Set version of Chromedriver that supports your version of browser
        /*chromedriver releases:
            https://sites.google.com/a/chromium.org/chromedriver/downloads
            https://chromedriver.storage.googleapis.com/2.26/notes.txt
        */
        if(Util.between(cv, 65,67)) {
            chromedriver_version = "2.38";
        }else if(Util.between(cv, 64,66)){
            chromedriver_version = "2.37";
        }else if(Util.between(cv, 62,64)){
            chromedriver_version = "2.35";
        } else if(Util.between(cv, 61,63)){
            chromedriver_version = "2.34";
        } else if(Util.between(cv, 60,62)){
            chromedriver_version = "2.33";
        } else if(Util.between(cv, 58,60)){
            chromedriver_version = "2.32";
        } else if(Util.between(cv, 56,58)){
            chromedriver_version = "2.29";
        } else if(Util.between(cv, 54,56)){
            chromedriver_version = "2.27";
        } else if(Util.between(cv, 52,54)){
            chromedriver_version = "2.24";
        } else if(Util.between(cv, 49,52)){
            chromedriver_version = "2.22";
        }
        return chromedriver_version;
    }
}
