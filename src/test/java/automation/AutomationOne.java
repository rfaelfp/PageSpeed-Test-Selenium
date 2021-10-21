package automation;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationOne {

    Modelo modelo = new Modelo();

    @Test
    public static Modelo searchScoreSite(String site) {

        Modelo modelo = new Modelo();

        try {
            WebDriver driver = new ChromeDriver();
    
            driver.navigate().to("https://developers.google.com/speed/pagespeed/insights/");
    
            Assert.assertEquals("PageSpeed Insights", driver.getTitle());
    
            WebElement searchInput = driver.findElement(By.xpath("//*[@id='page-speed-insights']/div[1]/form/div/input"));
    
            searchInput.sendKeys(site);
    
            WebElement searchButton = driver
                    .findElement(By.xpath("//*[@id='page-speed-insights']/div[1]/form/div/div/div"));
            searchButton.click();
            System.out.println("Analisando: " + site);
    
            new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=':5']")));

            WebElement resultMobile;
            Boolean isPresent = driver.findElements(By.xpath("//*[@id='page-speed-insights']/div[2]/div[3]/div[2]/div[1]/div[1]")).size() > 0;
            
            if(isPresent) {
                resultMobile = driver.findElement(
                        By.xpath("//*[@id='page-speed-insights']/div[2]/div[3]/div[2]/div[1]/div[2]/div/div[1]/a/div[2]"));
                        System.out.print("Resultado Mobile -> " + resultMobile.getText());
    
            } else {
                resultMobile = driver.findElement(
                        By.xpath("//*[@id='page-speed-insights']/div[2]/div[3]/div[2]/div[1]/div[1]/div/div[1]/a/div[2]"));
                        System.out.print("Resultado Mobile -> " + resultMobile.getText());
            }
    
            
                Thread.sleep(1000);
    
            WebElement buttonDesktopOption = driver.findElement(By.xpath("//*[@id=':8']"));
            buttonDesktopOption.click();
    
            WebElement resultDesktop;
            if(isPresent) {
                resultDesktop = driver.findElement(
                    By.xpath("//*[@id='page-speed-insights']/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/a/div[2]"));
                System.out.println("\nResultado Desktop -> " + resultDesktop.getText());
    
            } else {
                resultDesktop = driver.findElement(
                    By.xpath("//*[@id='page-speed-insights']/div[2]/div[3]/div[2]/div[2]/div[1]/div/div[1]/a/div[2]"));
                System.out.println("\nResultado Desktop -> " + resultDesktop.getText());
    
            }
    
    
            modelo.setSite(site);
            modelo.setResultDesktop(resultDesktop.getText());
            modelo.setResultMobile(resultMobile.getText());
    
            driver.close();
    
            return modelo;
            
        } catch (Exception e) {
            modelo.setSite(site);
            modelo.setResultDesktop("Erro");
            modelo.setResultMobile("Erro");
            return modelo;
        }
    }
}
