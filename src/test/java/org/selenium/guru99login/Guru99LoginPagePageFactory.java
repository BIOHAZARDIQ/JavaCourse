package org.selenium.guru99login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.SeleniumConfiguration;

/**
 * Guru99 Login page implemented with Page Factory pattern
 * Note: see differences with {@link Guru99LoginPagePageObject}
 */
public class Guru99LoginPagePageFactory extends SeleniumConfiguration {
    /**
     * All WebElements are identified by @FindBy annotation in Page Factory
     */
    @FindBy(name="uid")
    WebElement user99GuruName;

    @FindBy(name="password")
    WebElement password99Guru;

    @FindBy(className="barone")
    WebElement titleText;

    @FindBy(name="btnLogin")
    WebElement login;

    public Guru99LoginPagePageFactory(WebDriver driver){
        this.driver = driver;

        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    //Set user name in textbox
    public void setUserName(String strUserName){
        user99GuruName.sendKeys(strUserName);
    }

    //Set password in password textbox
    public void setPassword(String strPassword){
        password99Guru.sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin(){
        login.click();
    }

    //Get the title of Login Page
    public String getLoginTitle(){
        return    titleText.getText();
    }

    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUserName username of guru99 web
     * @param strPassword password of guru99 web
     */
    public void loginToGuru99(String strUserName,String strPassword){
        //Fill user name
        this.setUserName(strUserName);

        //Fill password
        this.setPassword(strPassword);

        //Click Login button
        this.clickLogin();
    }
}
