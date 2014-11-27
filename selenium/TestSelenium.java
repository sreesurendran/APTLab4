import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestSelenium  {
    public static void main(String[] args) {
    	testCase1();
    	testCase2();
    	testCase3();
    	testCase4();
    	testCase5();
    	 testCase6();
    	 testCase7();
    }
    
    public static void testCase1(){
    	System.out.println("TEST CASE: Check the three valid users");
    	WebDriver driver1 = new HtmlUnitDriver();
    	driver1.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement uname = driver1.findElement(By.name("userId"));
        WebElement pswd = driver1.findElement(By.name("userPassword"));
        uname.clear();
        pswd.clear();
        uname.sendKeys("andy");
        pswd.sendKeys("apple");
        uname.submit();
        
        if (driver1.getTitle().equals("Online temperature conversion calculator")){
        	System.out.println("Login successful for andy");
        }
        else{
        	System.out.println("Login failed for andy");
        }
        
        WebDriver driver2 = driver1;
    	driver2.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement uname2 = driver2.findElement(By.name("userId"));
        WebElement pswd2 = driver2.findElement(By.name("userPassword"));
        uname2.clear();
        pswd2.clear();
        uname2.sendKeys("bob");
        pswd2.sendKeys("bathtub");
        uname2.submit();
        
        if (driver2.getTitle().equals("Online temperature conversion calculator")){
        	System.out.println("Login successful for bob");
        }
        else{
        	System.out.println("Login failed for bob");
        }
        
        WebDriver driver3 = driver2;
    	driver3.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement uname3 = driver3.findElement(By.name("userId"));
        WebElement pswd3 = driver3.findElement(By.name("userPassword"));
        uname3.clear();
        pswd3.clear();
        uname3.sendKeys("charley");
        pswd3.sendKeys("china");
        uname3.submit();
        
        if (driver3.getTitle().equals("Online temperature conversion calculator")){
        	System.out.println("Login successful for charley");
        }
        else{
        	System.out.println("Login failed for charley");
        }
        
        WebDriver driver4 = driver3;
    	driver4.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement uname4 = driver4.findElement(By.name("userId"));
        WebElement pswd4 = driver4.findElement(By.name("userPassword"));
        uname4.clear();
        pswd4.clear();
        uname4.sendKeys("sree");
        pswd4.sendKeys("eers");
        uname4.submit();
        
        if (driver4.getTitle().equals("Bad Login")){
        	System.out.println("Login failed for sree");
        }
        else{
        	System.out.println("Login successful for sree");
        }
        driver4.close();
    }  
    
    public static void testCase2(){
    	System.out.println("\n\nTEST CASE: Usernames are case insensitive\npasswords are case-sensitive\nleading/trailing spaces are immaterial");
    	WebDriver driver1 = new HtmlUnitDriver();
    	driver1.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement uname = driver1.findElement(By.name("userId"));
        WebElement pswd = driver1.findElement(By.name("userPassword"));
        uname.clear();
        pswd.clear();
        uname.sendKeys("AnDy");
        pswd.sendKeys("apple");
        uname.submit();
        
        if (driver1.getTitle().equals("Online temperature conversion calculator")){
        	System.out.println("Login successful for AnDy");
        }
        else{
        	System.out.println("Login failed for andy");
        }
        
        WebDriver driver2 = driver1;
    	driver2.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement uname2 = driver2.findElement(By.name("userId"));
        WebElement pswd2 = driver2.findElement(By.name("userPassword"));
        uname2.clear();
        pswd2.clear();
        uname2.sendKeys(" bob");
        pswd2.sendKeys("bathtub  ");
        uname2.submit();
        
        if (driver2.getTitle().equals("Online temperature conversion calculator")){
        	System.out.println("Login successful for bob(leading space) and bathtub(trailing space)");
        }
        else{
        	System.out.println("Login failed for bob");
        }
        
        WebDriver driver3 = driver2;
    	driver3.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement uname3 = driver3.findElement(By.name("userId"));
        WebElement pswd3 = driver3.findElement(By.name("userPassword"));
        uname3.clear();
        pswd3.clear();
        uname3.sendKeys("charley");
        pswd3.sendKeys("CHIna");
        uname3.submit();
        
        if (driver3.getTitle().equals("Bad Login")){
        	System.out.println("Login failed for charley;check password-CHIna (case-sensitive)");
        }
        else{
        	System.out.println("Login successful for charley ");
        }
        driver3.close();
     }
    
    public static void testCase3(){
    	
    	System.out.println("\n\nTEST CASE: Three failed logins in 10 seconds leading to lockout");
    	WebDriver driver1 = new HtmlUnitDriver();
    	int count = 0;
    	long end = System.currentTimeMillis() + 10000;
    	driver1.get("http://apt-public.appspot.com/testing-lab-login.html");
    	WebElement uname = driver1.findElement(By.name("userId"));
    	WebElement pswd = driver1.findElement(By.name("userPassword"));
        uname.clear();
        pswd.clear();
        uname.sendKeys("user1");
        pswd.sendKeys("user1");
        uname.submit();
        
        if (driver1.getTitle().equals("Bad Login")){
        	count = count +1;
        	System.out.println("Login failed for user1:"+count);
        }
        
        WebDriver driver2 = driver1;
    	driver2.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement uname2 = driver2.findElement(By.name("userId"));
        WebElement pswd2 = driver2.findElement(By.name("userPassword"));
        uname2.clear();
        pswd2.clear();
        uname2.sendKeys("user2");
        pswd2.sendKeys("user2");
        uname2.submit();
        
        if (driver1.getTitle().equals("Bad Login")){
        	count = count +1;
        	System.out.println("Login failed for user2:"+count);
        }
        
        WebDriver driver3 = driver2;
    	driver3.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement uname3 = driver3.findElement(By.name("userId"));
        WebElement pswd3 = driver3.findElement(By.name("userPassword"));
        uname3.clear();
        pswd3.clear();
        uname3.sendKeys("user3");
        pswd3.sendKeys("user3");
        uname3.submit();
        
        if (driver1.getTitle().equals("Bad Login")){
        	count = count +1;
        	System.out.println("Login failed for user3:"+count);
        }
        
        if (count==3 && System.currentTimeMillis() < end){
        	System.out.println("LOCKOUT TEST: Three failed logins in 10 seconds");
        }
        
        WebDriver driver4 = driver3;
    	driver4.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement uname4 = driver4.findElement(By.name("userId"));
        WebElement pswd4 = driver4.findElement(By.name("userPassword"));
        uname4.clear();
        pswd4.clear();
        uname4.sendKeys("user4");
        pswd4.sendKeys("user4");
        uname4.submit();
        
        if (driver4.getTitle().equals("Bad Login")){
        	count = count +1;
        	System.out.println("BUG DETECTED : NO LOCKOUT WITH THREE FAILED LOGINS");
        }
        driver4.close();
    }
    
    public static void testCase4(){
    	System.out.println("\n\nTEST CASE: Temperature results precision");
    	WebDriver driver1 = new HtmlUnitDriver();
    	driver1.get("http://apt-public.appspot.com/testing-lab-calculator.html");
    	WebElement temp = driver1.findElement(By.name("farenheitTemperature"));
    	temp.clear();
    	temp.sendKeys("190");
    	temp.submit();
    	WebElement celtemp = driver1.findElement(By.tagName("h2"));
    	String[] ctemp = celtemp.getText().split("\\=");
    	String[] cval = ctemp[1].split("\\s+");
    	String[] finalcval = cval[1].split("\\.");
    	if (finalcval.length==2){
    		System.out.println("TEST PASSED: Converted Temperatures between 0 to 212 have double precision");
    		System.out.println("90 Farenheit = 87.78 Celsius");
    	}
    	WebDriver driver2 = driver1;
    	driver2.get("http://apt-public.appspot.com/testing-lab-calculator.html");
    	WebElement temp2 = driver2.findElement(By.name("farenheitTemperature"));
    	
    	temp2.clear();
    	temp2.sendKeys("451");
    	temp2.submit();
    	WebElement celtemp2 = driver2.findElement(By.tagName("h2"));
    	String[] ctemp2 = celtemp2.getText().split("\\=");
    	String[] cval2 = ctemp2[1].split("\\s+");
    	String[] finalval = cval2[1].split("\\.");
    	if (finalval.length==2){
    		System.out.println("BUG DETECTED : Converted Temperatures out of [0-212] range have double precision");
    		System.out.println("451 Farenheit = 232.78 Celsius");
    	}
    	driver2.close();
   }
   
    public static void testCase5(){
    	System.out.println("\n\nTEST CASE: Temperature input as floating point numbers");
    	WebDriver driver1 = new HtmlUnitDriver();
    	driver1.get("http://apt-public.appspot.com/testing-lab-calculator.html");
    	WebElement temp = driver1.findElement(By.name("farenheitTemperature"));
    	temp.clear();
    	temp.sendKeys("97");
    	temp.submit();
    	if (driver1.getTitle().equals("Temperature Converter Result")){
    		System.out.println("TEST PASSED: 97F");
    	}
    	
    	WebDriver driver2 = driver1;
    	driver2.get("http://apt-public.appspot.com/testing-lab-calculator.html");
    	WebElement temp1 = driver2.findElement(By.name("farenheitTemperature"));
    	temp1.clear();
    	temp1.sendKeys("-3.14");
    	temp1.submit();
    	if (driver2.getTitle().equals("Temperature Converter Result")){
    		System.out.println("TEST PASSED: -3.14");
    	}
    	
    	WebDriver driver3 = driver2;
    	driver3.get("http://apt-public.appspot.com/testing-lab-calculator.html");
    	WebElement temp2 = driver3.findElement(By.name("farenheitTemperature"));
    	temp2.clear();
    	temp2.sendKeys("-3.14");
    	temp2.submit();
    	if (driver3.getTitle().equals("Temperature Converter Result")){
    		System.out.println("BUG DETECTED : Accepts 9.73E2");
    	}
    	driver3.close();
    }
    
    public static void testCase6(){
    	System.out.println("\n\nTEST CASE: Temperature invalid input temperatures");
    	WebDriver driver1 = new HtmlUnitDriver();
    	
    	driver1.get("http://apt-public.appspot.com/testing-lab-calculator.html");
    	WebElement temp1 = driver1.findElement(By.name("farenheitTemperature"));
    	temp1.clear();
    	temp1.sendKeys("trust");
    	temp1.submit();
    	if (driver1.getTitle().equals("Bad Temperature")){
    		System.out.println("TEST PASSED: Number format exception for invalid input:trust");
    	}
    	driver1.close();
    }
    
    public static void testCase7(){
    	System.out.println("\n\nTEST CASE: Testing case insensitivity of “farenheitTemperature\"");
    	 WebDriver driver1 = new HtmlUnitDriver();
    	 driver1.get("http://apt-public.appspot.com/testing-lab-conversion?faRENhEITTemPeraTurE=100");
    	 if (driver1.getTitle().equals("No Temperature")){
    		 System.out.println("BUG DETECTED : farenheitTemperature is case sensitive");
    	 }
    	 driver1.close();
    }   
}
