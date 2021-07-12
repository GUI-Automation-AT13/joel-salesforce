package salesforce;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

public class CreateAnAssetTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  WebDriverWait wait;

  @BeforeEach
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "E:\\JalaSoft\\12.-GUI automation\\chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
    wait = new WebDriverWait(driver, 30);
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  public void login() {
    driver.get("https://login.salesforce.com//");
    driver.manage().window().setSize(new Dimension(1295, 860));
    driver.findElement(By.id("username")).sendKeys("jrojas@freeorg01.com");
    driver.findElement(By.id("password")).sendKeys("fundacionjalaat13");
    driver.findElement(By.id("Login")).click();
  }

  @Test
  public void allAttributes13() {
    login();
    vars.put("asset", "Activos");
    vars.put("assetName", "nombre 6");
    vars.put("serialNumber", "Serial Number");
    vars.put("quantity", "10");
    vars.put("price", "100");
    vars.put("description", "Description");
    vars.put("installDate", "8/7/2021");
    vars.put("purchaseDate", "15/7/2021");
    vars.put("usageDate", "25/7/2021");
    driver.get("https://none773-dev-ed.lightning.force.com/lightning/o/Asset/list?filterName=Recent//");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".forceActionLink > div")));
    driver.findElement(By.cssSelector(".forceActionLink > div")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, \'uiInputText\')][.//label])[1]/input")));
    driver.findElement(By.xpath("(//div[contains(@class, \'uiInputText\')][.//label])[1]/input")).sendKeys(vars.get("assetName").toString());
    driver.findElement(By.xpath("(//div[contains(@class, \'uiInputText\')][.//label])[2]/input")).sendKeys(vars.get("serialNumber").toString());
    driver.findElement(By.xpath("(//input[contains(@class, \'uiInputSmartNumber\')])[1]")).sendKeys(vars.get("quantity").toString());
    driver.findElement(By.xpath("(//input[contains(@class, \'uiInputSmartNumber\')])[2]")).sendKeys(vars.get("price").toString());
    driver.findElement(By.xpath("//textarea")).sendKeys(vars.get("description").toString());
    driver.findElement(By.xpath("//div[@class=\'slds-form-element__control\']//input[@type=\'checkbox\']")).click();
    driver.findElement(By.xpath("//a[@class=\'select\']")).click();
    driver.findElement(By.xpath("//a[@title=\'Shipped\']")).click();
    driver.findElement(By.xpath("(//div[contains(@class,\'uiInputDate\')]/div/input)[1]")).sendKeys(vars.get("installDate").toString());
    driver.findElement(By.xpath("(//div[contains(@class,\'uiInputDate\')]/div/input)[2]")).sendKeys(vars.get("purchaseDate").toString());
    driver.findElement(By.xpath("(//div[contains(@class,\'uiInputDate\')]/div/input)[3]")).sendKeys(vars.get("usageDate").toString());
    driver.findElement(By.xpath("(//div[@class=\'autocompleteWrapper slds-grow\']/input)[1]")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role=\'listbox\']//a)[1]")));
    driver.findElement(By.xpath("(//div[@role=\'listbox\']//a)[1]")).click();
    driver.findElement(By.xpath("(//div[@class=\'autocompleteWrapper slds-grow\']/input)[2]")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\'listContent\']//a)[3]")));
    driver.findElement(By.xpath("(//div[@class=\'listContent\']//a)[3]")).click();
    driver.findElement(By.xpath("(//div[@class=\'autocompleteWrapper slds-grow\']/input)[3]")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\'listContent\']//a)[7]")));
    driver.findElement(By.xpath("(//div[@class=\'listContent\']//a)[7]")).click();
    driver.findElement(By.xpath("//button[@title=\'Guardar\']")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1/div/span")));
    Assertions.assertEquals (driver.findElement(By.xpath("//h1/div/span")).getText(), (vars.get("assetName").toString()));
    delete();
    logout();
  }

  @Test
  public void necessaryAttributes13() {
    login();
    vars.put("asset", "Activos");
    vars.put("assetName", "nombre 6");
    driver.get("https://none773-dev-ed.lightning.force.com/lightning/o/Asset/list?filterName=Recent//");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".forceActionLink > div")));
    driver.findElement(By.cssSelector(".forceActionLink > div")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, \'uiInputText\')][.//label])[1]/input")));
    driver.findElement(By.xpath("(//div[contains(@class, \'uiInputText\')][.//label])[1]/input")).sendKeys(vars.get("assetName").toString());
    driver.findElement(By.xpath("(//div[@class=\'autocompleteWrapper slds-grow\']/input)[1]")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role=\'listbox\']//a)[1]")));
    driver.findElement(By.xpath("(//div[@role=\'listbox\']//a)[1]")).click();
    driver.findElement(By.xpath("//button[@title=\'Guardar\']")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1/div/span")));
    Assertions.assertEquals (driver.findElement(By.xpath("//h1/div/span")).getText(), (vars.get("assetName").toString()));
    delete();
    logout();
  }

  public void logout() {
    driver.get("https://none773-dev-ed.lightning.force.com/lightning/o/Asset/list?filterName=Recent//");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".profileTrigger > .uiImage")));
    driver.findElement(By.cssSelector(".profileTrigger > .uiImage")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile-card-indent']//a[contains(@class,'uiOutputURL')]")));
    driver.findElement(By.xpath("//div[@class='profile-card-indent']//a[contains(@class,'uiOutputURL')]")).click();
  }

  public void delete() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,\'branding-actions\')]/li/div//a[@role=\'button\']")));
    driver.findElement(By.xpath("//ul[contains(@class,\'branding-actions\')]/li/div//a[@role=\'button\']")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role=\'menu\']//a[./div[@title=\'Eliminar\']]")));
    driver.findElement(By.xpath("//div[@role=\'menu\']//a[./div[@title=\'Eliminar\']]")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,\'modal-container\')]//button[contains(@class,\'default\')]")));
    driver.findElement(By.xpath("//div[contains(@class,\'modal-container\')]//button[contains(@class,\'default\')]")).click();
  }
}
