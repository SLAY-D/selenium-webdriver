import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainClass {

        @Test
        public void FirstTest(){
                System.setProperty("webdriver.chrome.driver","C:\\Users\\spuki\\IdeaProjects\\maven_pr1\\drivers\\chromedriver.exe");
                WebDriver driver = new ChromeDriver();

                driver.get("https://habr.com/ru/all/");
                driver.manage().window().setSize(new Dimension(1280,1025));

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                driver.findElement(
                        By.xpath("//*[@class='tm-header-user-menu__item tm-header-user-menu__search']")).click();

                Assert.assertEquals(driver.findElement(By.xpath("//input[@name='q']")), driver.switchTo().activeElement());

                driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium WebDriver");

                driver.findElement(By.xpath("//*[@class='tm-svg-img tm-svg-icon']")).click();

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                driver.findElement(By.linkText("Что такое Selenium?")).click();

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                Assert.assertEquals("28 сентября 2012 в 17:14",
                        driver.findElement(By.xpath("//*[@title='2012-09-28, 17:14']")).getText());

                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                driver.findElement(By.xpath("//a[@href='/ru/' and @class='footer-menu__item-link router-link-active']")).click();

                driver.quit();

        }

        @Test
    public void testMailAuth(){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\spuki\\IdeaProjects\\maven_pr1\\drivers\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.get("https://mail.ru/");
            driver.manage().window().setSize(new Dimension(1280,1025));

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.findElement(By.xpath("//*[@name='login']")).click();

            driver.findElement(By.xpath("//*[@name='login']")).clear();

            driver.findElement(By.xpath("//*[@name='login']")).sendKeys("professionaltester");

            driver.findElement(By.xpath("//*[@data-testid='enter-password']")).click();

            driver.findElement(By.xpath("//*[@name='password']")).click();

            driver.findElement(By.xpath("//*[@name='password']")).clear();

            driver.findElement(By.xpath("//*[@name='password']")).sendKeys("toptester123");

            driver.findElement(By.xpath("//*[@data-testid='login-to-mail']")).click();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.findElement(By.xpath("//*[@class='ph-project__user-name svelte-1hiqrvn']")).click();

            Assert.assertEquals("Тестовый Тестич",
                        driver.findElement(By.xpath("//*[@class='ph-name svelte-1vf03eq']")).getText());

            driver.findElement(By.xpath("//*[@class='ph-text svelte-1vf03eq' and text()='Выйти']")).click();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.findElement(By.xpath("//*[@data-testid='mailbox-create-link' and text()='Создать почту']")).isDisplayed();

            driver.quit();

        }


    }
