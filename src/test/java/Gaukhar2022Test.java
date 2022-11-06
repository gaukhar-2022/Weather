import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Gaukhar2022Test {

    //TC_1_1  - Тест кейс:
    //1. Открыть страницу https://openweathermap.org/
    //2. Набрать в строке поиска город Paris
    //3. Нажать пункт меню Search
    //4. Из выпадающего списка выбрать Paris, FR
    //5. Подтвердить, что заголовок изменился на "Paris, FR"

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url); //когда передадим url, то с помощью команды get сможем открыть драйвер
        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget'] //button[@type = 'submit']")
        );
        searchButton.click();

        Thread.sleep(1000);

        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        parisFRChoiceInDropdownMenu.click();


        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );

        Thread.sleep(2000);
        String actualResult = h2CityCountryHeader.getText();


        Assert.assertEquals(actualResult, expectedResult);


//        Thread.sleep(5000);


        driver.quit(); //это команда, чтобы мы вышли из браузера


    }

//    @Test
//    public void testName(){
//
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();


//     driver.quit(); это команда, чтобы мы вышли из браузера
//     driver.close(); это команда, чтобы мы закрыли сессию браузера. Команды эти отвечают за selenium




//    TC_11_01
//    Открыть базовую ссылку
//    Нажать на пункт меню Guide
//    Подтвердить, что вы перешли на страницу со ссылкой
//    https://openweathermap.org/guide и что title этой страницы OpenWeatherMap API guide - OpenWeatherMap

    @Test
    public void testH1TagText_WhenSearchingGuideMenu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String itemMenu = "Guide";
        String expectedResult = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);

        Thread.sleep(5000);

        WebElement GuideMenu = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']/ul/li[1]/a")
        );


        GuideMenu.click();

        String actualResult = driver.getTitle();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

//        /html/body/nav/ul[1]/div/ul/li[1]/a

        //*[@id="desktop-menu"]/ul/li[1]/a




    }

//    TC_11_02
//    Открыть базовую ссылку
//    Нажать на единицы измерения Imperial: °F, mph
//    Подтвердить, что температура для города показана в Фарингейтах
    @Test
    public void testTagText_WhenUnitMeasureShownCityInF() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String unitMeasure = "Imperial: °F, mph";
//        String expectedResult = "Imperial: °F, mph";
        String expectedResult = "F";

        driver.get(url);



        Thread.sleep(5000);

        WebElement UnitMeasure = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//div[1]/div/div/div[1]/div[2]/div[3]")
        );

        UnitMeasure.click();


        WebElement UnitMeasure1 = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']/div[2]/div/div/div/div/span")
        );

        String unitMeasureText = UnitMeasure1.getText();

        String actualResult = unitMeasureText.substring(unitMeasureText.length() - 1);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();


    }

//    TC_11_03
//    Открыть базовую ссылку
//    Подтвердить, что внизу страницы есть панель с текстом
//    “We use cookies which are essential for the site to work. We also use non-essential cookies to help us
//    improve our services. Any data collected is anonymised. You can allow all cookies or
//    manage them individually.”
//    Подтвердить, что на панели внизу страницы есть 2 кнопки
//    “Allow all” и “Manage cookies”

    @Test
    public void testTag_ConfirmPanelTextAndPanelTwoButtons() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult1 = "We use cookies which are essential for the site to work. We also use non-essential cookies to help us" +
                " improve our services. Any data collected is anonymised. You can allow all cookies or" +
                " manage them individually.";

        String expectedResult2 = "Allow all";
        String expectedResult3 = "Manage cookies";

        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement panel = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//div//div//div//div/p")
        );


        WebElement button_allow = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//div//div//div//div//div/button")
        );

        WebElement button_manageCookies = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//div//div//div//div/div/a")
        );

         //panel
        String actualResult1 = panel.getText();
        Assert.assertEquals(actualResult1, expectedResult1);

        //button Allow
        String actualResult2 = button_allow.getText();
        Assert.assertEquals(actualResult2, expectedResult2);

        //button Manage cookies
        String actualResult3 = button_manageCookies.getText();
        Assert.assertEquals(actualResult3, expectedResult3);


        driver.quit();

    }


//    TC_11_04
//    Открыть базовую ссылку
//    Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”
    @Test
    public void testTag_SearchingMenuSupportHasThreeSubmenu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String menu = "Support";
        String expectedResult = "FAQ”, “How to start” и “Ask a question";

        driver.get(url);

        Thread.sleep(5000);

        WebElement Support = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']")
        );

        Support.click();

        Thread.sleep(5000);

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }


//    TC_11_05
//   Открыть базовую ссылку
//   Нажать пункт меню Support → Ask a question
//   Заполнить поля Email, Subject, Message
//   Не подтвердив CAPTCHA, нажать кнопку Submit
//    Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”






}

