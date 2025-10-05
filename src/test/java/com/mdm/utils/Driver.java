package com.mdm.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v134.network.Network;
import org.openqa.selenium.devtools.v134.network.model.Request;
import org.openqa.selenium.devtools.v134.network.model.RequestId;
import org.openqa.selenium.devtools.v134.network.model.Response;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}

    private static WebDriver driver;

    public static String csvContent;

    public static Request req;

    //sets the driver object
    public static WebDriver getDriver(){
        if (driver == null){
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

                   //Chrome Dev Tools integration---------------------------------------------

                    DevTools devTools = ((HasDevTools) driver).getDevTools();
                    devTools.createSession();
                    // enable network monitoring
                    devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

                    devTools.addListener(Network.responseReceived(), responseReceived -> {
                        Response response = responseReceived.getResponse();

                        if (response.getUrl().contains("/devices/export/")) {
                            RequestId requestId = responseReceived.getRequestId();
                            //String requestId = responseReceived.getRequestId().toString();
                            Network.GetResponseBodyResponse body = devTools.send(Network.getResponseBody(requestId));

                            // Get the response as a String
                            csvContent = body.getBody();
                            if (body.getBase64Encoded()) {
                                csvContent = new String(Base64.getDecoder().decode(csvContent), StandardCharsets.UTF_8);
                            }

                            System.out.println("✅ CSV content caught:");
                            System.out.println(csvContent);

                        }
                    });

                    //-----------------------------------------------------------------------

                    driver.manage().window().maximize();
                    //driver.manage().window().setSize(new Dimension(1920,1080));
                    driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    /*EdgeOptions option = new EdgeOptions();
                    option.addArguments("--remote-allow-origins=*");
                    option.addArguments("--deny-permission-prompts");*/
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            }
        }

        return driver;
    }

    //used for closing browser
    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
