package techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {


    private Driver() {
        /*
    POM de Driver classindan object oluşturarak getDriver method kullanimini engellemeliyiz
    Bu nedenle Singleton Pattern kullanımı benimsenmiştir
    Singleton Pattern : Bir classin farklı classlardan object oluşturarak kullanılmasının engellemek için kullanılır
     */
    }

    static WebDriver driver;

    public static WebDriver getDriver (){
        if (driver==null){
           switch (ConfigReader.getProperty("browser")){
               case "chrome":
                    driver=new ChromeDriver();
                    break;
               case "edge":
                   driver=new EdgeDriver();
                   break;
               case "safari":
                   driver=new SafariDriver();
                   break;
               case "firefox" :
                   driver=new FirefoxDriver();
                   break;
               default:
                   driver=new ChromeDriver();
           }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().window().maximize();
        }
        return driver;
    }


    /*
    Driveri her çağırdığımızda yeni bir pencere açmaması için bir if bloğu ile ayarlama yaptık
    if (driver==null) ile eger driver a değer atanmamış ise driveri başlat dedik driver açık iken tekrar çağırılırsa
    driver a değer atanmış olduğu için if block çalışmayacak ve dolayısıyla bu method mevcut driver i tekrar return edecek
    Böylece aynı driver üzerinden test senaryolarımıza devam edebileceğiz
     */

    /*
    Page Object Model de driver icin TestBase classina extends yaparak kullanmak yerine Driver classi
    oluşturarak bu classdan static method aracılığı ile driver oluşturup kullanmak tercih edilir
    */

    public static void closeDriver(){
        if (driver!=null){
            driver.close();
            driver=null;
        }
    }




}
