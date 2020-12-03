package seleniumTestProjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BankTests {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Aziza Sultana\\eclipse-workspace\\JavaProject\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://localhost:9999/statements");

		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	public String checkBalanceBefore(String balanceBefore) {
		try {
			String[] str = balanceBefore.split("Balance before:");
			if (str.length > 1)
				balanceBefore = balanceBefore.split("Balance before:")[1];
			else
				balanceBefore = "";
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Balance Before: " + balanceBefore);
		return balanceBefore;
	}

	public String checkBalanceAfter(String balanceAfter) {

		try {
			String[] str = balanceAfter.split("Balance after");
			if (str.length > 1) {
				balanceAfter = balanceAfter.split("Balance after")[1];
				balanceAfter = balanceAfter.split("« Previous")[0];
			} else {
				balanceAfter = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Balance After: " + balanceAfter);
		return balanceAfter;
	}

	@Test
	public void balanceBeforeTestWithoutDateRange() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101101");

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("0.00 EUR");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestWithoutDateRange() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101101");

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("1430.00 EUR");
		assertTrue(verifyBalanceAfter);

	}

	@Test
	public void balanceBeforeTestFromCurrentDateToCurrentDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101101");

		WebElement selectFromDate = driver.findElement(By.xpath("//*[@id=\"from_datepicker\"]/span"));
		selectFromDate.click();

		WebElement nextFromLink = driver.findElement(By.xpath("//*[@id=\"from_datepicker\"]/span"));
		nextFromLink.click();

		WebElement selectToDate = driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/span"));
		selectToDate.click();

		WebElement nextToLink = driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/span"));
		nextToLink.click();

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("0.00 EUR");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestFromCurrentDateToCurrentDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101101");

		WebElement selectFromDate = driver.findElement(By.xpath("//*[@id=\"from_datepicker\"]/span"));
		selectFromDate.click();

		WebElement nextFromLink = driver.findElement(By.xpath("//*[@id=\"from_datepicker\"]/span"));
		nextFromLink.click();

		WebElement selectToDate = driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/span"));
		selectToDate.click();

		WebElement nextToLink = driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/span"));
		nextToLink.click();

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("0.00 EUR");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestFromAccountOpeningDateToCurrentDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101101");

		WebElement dateFromBox = driver.findElement(By.name("from_date"));
		dateFromBox.click();

		dateFromBox.sendKeys("2020-01-01 00:00:00");

		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		WebElement selectToDate = driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/span"));
		selectToDate.click();

		WebElement nextToLink = driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/span"));
		nextToLink.click();

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("0.00 EUR");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestFromAccountOpeningDateToCurrentDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101101");

		WebElement dateFromBox = driver.findElement(By.name("from_date"));
		dateFromBox.click();

		dateFromBox.sendKeys("2020-01-01 00:00:00");

		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		WebElement selectToDate = driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/span"));
		selectToDate.click();

		WebElement nextToLink = driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/span"));
		nextToLink.click();

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("1430.00 EUR");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestFromAccountOpeningDateToMidOfYear() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101101");

		WebElement dateFromBox = driver.findElement(By.name("from_date"));
		dateFromBox.click();

		dateFromBox.sendKeys("2020-01-01 00:00:00");

		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		WebElement dateToBox = driver.findElement(By.name("to_date"));
		dateToBox.click();

		dateToBox.sendKeys("2020-06-30 00:00:00");

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("0.00 EUR");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestFromAccountOpeningDateToMidOfYear() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101101");

		WebElement dateFromBox = driver.findElement(By.name("from_date"));
		dateFromBox.click();

		dateFromBox.sendKeys("2020-01-01 00:00:00");

		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		WebElement dateToBox = driver.findElement(By.name("to_date"));
		dateToBox.click();

		dateToBox.sendKeys("2020-06-30 00:00:00");

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("1400.00 EUR");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestFromMidOfYearToCurrentDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101103");

		WebElement dateFromBox1 = driver.findElement(By.name("from_date"));
		dateFromBox1.click();

		dateFromBox1.sendKeys("2020-07-01 00:00:00");

		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		WebElement selectToDate = driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/span"));
		selectToDate.click();

		WebElement nextToLink = driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/span"));
		nextToLink.click();

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("1030.00 EUR");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestFromMidOfYearToCurrentDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101103");

		WebElement dateFromBox1 = driver.findElement(By.name("from_date"));
		dateFromBox1.click();

		dateFromBox1.sendKeys("2020-07-01 00:00:00");

		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		WebElement selectToDate = driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/span"));
		selectToDate.click();

		WebElement nextToLink = driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/span"));
		nextToLink.click();

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("180.00 EUR");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestFromMidOfYearToMidOfYear() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101104");

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2020-05-01 00:00:00");

		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("2020-08-31 00:00:00");

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("150.00 EUR");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestFromMidOfYearToMidOfYear() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101104");

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2020-05-01 00:00:00");

		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("2020-08-31 00:00:00");

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("80.00 EUR");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestWithAllFieldEmpty() {

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("0.00 EUR");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestWithAllFieldEmpty() {

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("4600.00 EUR");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestWithInvalidAccountIDAndWithoutDateRange() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("abcd");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestWithInvalidAccountIDAndWithoutDateRange() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("abcd");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestWithInvalidAccountIDAndValidDateRange() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("abcdaad");

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2020-03-01 00:00:00");
		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("2020-06-30 00:00:00");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestWithInvalidAccountIDAndValidDateRange() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("abcdaad");

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2020-03-01 00:00:00");
		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("2020-06-30 00:00:00");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestWithInvalidAccountIDAndOnlyValidFromDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("abcdaad");

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2020-03-01 00:00:00");
		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestWithInvalidAccountIDAndOnlyValidFromDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("abcdaad");

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2020-03-01 00:00:00");
		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestWithInvalidAccountIDAndOnlyValidToDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("abcdaad");

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("2020-05-30 00:00:00");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestWithInvalidAccountIDAndOnlyValidToDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("abcdaad");

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("2020-05-30 00:00:00");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestWithInvalidAccountIDAndWithFromDateSmallerAndToDateGreater() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("abcdaad");

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2020-10-13 00:00:00");
		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("2020-06-01 00:00:00");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestWithInvalidAccountIDAndWithFromDateSmallerAndToDateGreater() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("abcdaad");

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2020-10-13 00:00:00");
		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("2020-06-01 00:00:00");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestWithValidAccountIDAndWithInvalidDateRange() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101102");

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2025-10-30 00:00:00");
		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("2029-06-01 00:00:00");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("0.00 EUR");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestWithValidAccountIDAndWithInvalidDateRange() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101102");

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2025-10-30 00:00:00");
		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("2029-06-01 00:00:00");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("0.00 EUR");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestWithValidAccountIDAndWithFromDateSmallerAndToDateGreater() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101104");

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2020-10-13 00:00:00");
		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("2020-06-01 00:00:00");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("0.00 EUR");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestWithValidAccountIDAndWithFromDateSmallerAndToDateGreater() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101104");

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2020-10-13 00:00:00");
		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("2020-06-01 00:00:00");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("0.00 EUR");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestWithValidAccountIDAndOnlyValidFromDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101104");

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2020-07-01 00:00:00");
		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("220.00 EUR");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestWithValidAccountIDAndOnlyValidFromDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101104");

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2020-07-01 00:00:00");
		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		System.out.println("Balance After: " + balanceAfter.split("Balance after")[1]);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("100.00 EUR");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestWithValidAccountIDAndOnlyValidToDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101104");

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("2020-06-30 00:00:00");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("100.00 EUR");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestWithValidAccountIDAndOnlyValidToDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101104");

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("2020-06-30 00:00:00");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("220.00 EUR");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestWithValidAccountIDAndInvalidFromDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101104");

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2025-06-01 00:00:00");
		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("0.00 EUR");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestWithValidAccountIDAndInvalidFromDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101104");

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2025-06-01 00:00:00");
		driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("0.00 EUR");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestWithValidAccountIDAndInvalidToDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101104");

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("1990-06-30 00:00:00");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("0.00 EUR");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestWithValidAccountIDAndInvalidToDate() {

		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101104");

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("1990-06-30 00:00:00");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("0.00 EUR");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestWithValidFromDate() {

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2020-07-01 00:00:00");

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("4880.00 EUR");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestWithValidFromDate() {

		WebElement dateFromBox2 = driver.findElement(By.name("from_date"));
		dateFromBox2.click();

		dateFromBox2.sendKeys("2020-07-01 00:00:00");

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("690.00 EUR");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void balanceBeforeTestWithValidToDate() {

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("2020-01-15 00:00:00");

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText = driver.findElement(By.xpath("/html/body/div/div[1]"));
		String balanceBefore = balanceText.getText();

		balanceBefore = checkBalanceBefore(balanceBefore);

		Boolean verifyBalanceBefore = balanceBefore.equalsIgnoreCase("0.00 EUR");
		assertTrue(verifyBalanceBefore);
	}

	@Test
	public void balanceAfterTestWithValidToDate() {

		WebElement dateToBox2 = driver.findElement(By.name("to_date"));
		dateToBox2.click();

		dateToBox2.sendKeys("2020-01-15 00:00:00");

		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		WebElement balanceText1 = driver.findElement(By.xpath("/html/body/div/div[2]/div"));
		String balanceAfter = balanceText1.getText();

		balanceAfter = checkBalanceAfter(balanceAfter);

		Boolean verifyBalanceAfter = balanceAfter.equalsIgnoreCase("590.00 EUR");
		assertTrue(verifyBalanceAfter);
	}

	@Test
	public void paginationTest() {

		List<WebElement> pagination = driver.findElements(By.xpath("/html/body/div/div[2]/div/div[2]/ul/nav"));

		WebElement prevButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/ul/nav/ul/li[1]/span"));

		WebElement nextButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/ul/nav/ul/li[4]/a"));

		if (pagination.size() > 0) {
			for (int i = 0; i < pagination.size(); i++) {
				if (nextButton.isEnabled()) {
					nextButton.click();
					System.out.println("pagination exists");
				}
			}
		} else {
			System.out.println("pagination does not exist");
		}
	}
}
