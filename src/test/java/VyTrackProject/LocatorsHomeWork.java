import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.Arrays;
import java.util.EventListenerProxy;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsHomeWork {

    public static void main(String[] args) throws Exception {
        // GoogleSearch();
        // EtsySearch();
        VytrackTitle();

    }

    public static void GoogleSearch() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        List<String> searchStrs = Arrays.asList("Java", "JUnit", "REST Assured");

        for (String each : searchStrs) {
            driver.get("https://www.google.com/");
            driver.findElement(By.name("q")).sendKeys(each, Keys.ENTER);


            String firstUrl = driver.findElement(By.xpath("//cite[@class='iUh30']")).getText();
            Thread.sleep(1000);
            System.out.println(firstUrl);

            driver.findElement(By.xpath("//h3[@class='LC20lb']")).click();
            String secondUrl = driver.getCurrentUrl();
            Thread.sleep(1000);
            System.out.println(secondUrl);

            if (firstUrl.equals(secondUrl))
                System.out.println("Test Passed");
            else
                System.out.println("Test Failed");
        }
        driver.quit();
    }

    public static void EtsySearch() throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("wooden spoon", Keys.ENTER);

        String number1 = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']")).getText();
        System.out.println(number1);

        driver.findElement(By.xpath("//span[text()='All']")).click();
        String number2 = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']")).getText();
        System.out.println(number2);
        if (Integer.parseInt(number1.substring(0, 6).replace(",", "")) < Integer.parseInt(number2.substring(0, 6).replace(",", "")))
            System.out.println("Passed");
        else
            System.out.println("Failed");
        driver.navigate().back();
        driver.navigate().back();


        WebElement emptyBox = driver.findElement(By.id("gh-ac"));

        if (emptyBox.getText().equals("")) {
            System.out.println("Box is empty");
        } else
            System.out.println("no it is not");

        driver.quit();

    }

    public static void VytrackTitle() throws Exception {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        //user credentials in array
        String credentials[][] = {{"user39", "UserUser123"}, {"storemanager77", "UserUser123"}, {"salesmanager140", "UserUser123"}};

        driver.get("http://qa2.vytrack.com/user/login");

        for (int i = 0; i < credentials.length; i++) {
            //enters the credential to the website by pulling from the 2d array and logins to the app
            driver.findElement(By.id("prependedInput")).sendKeys(credentials[i][0]);
            driver.findElement(By.id("prependedInput2")).sendKeys(credentials[i][1]);
            driver.findElement(By.id("_submit")).click();
            Thread.sleep(4000);
            //finds the dropdown menu and goes to the configuration
            driver.findElement(By.xpath("//li[@id='user-menu']")).click();

            driver.findElement(By.linkText("My Configuration")).click();

            driver.navigate().refresh();

            //gets the page title
            String pageTitle = driver.getTitle();
            //gets the profile name
            String profileTitle=driver.findElement(By.xpath("//a[@href='javascript: void(0);']")).getText();
            //compare page title and profile name
            if(pageTitle.contains(profileTitle)){
                System.out.println("Passed");
            } else {
                System.out.println("Failed");
            }


            //goes to the profile and logs out from the app
            driver.findElement(By.xpath("//li[@class='dropdown user-menu-dropdown']")).click();
            driver.findElement(By.linkText("Logout")).click();
            //clears the login credentials from previous login
            driver.findElement(By.id("prependedInput")).clear();
            driver.findElement(By.id("prependedInput2")).clear();
            Thread.sleep(2000);

        }
    }


    public static void VytrackShorcut() throws Exception {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
    }

}