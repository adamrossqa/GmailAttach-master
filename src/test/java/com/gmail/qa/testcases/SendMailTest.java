package com.gmail.qa.testcases;

import com.gmail.qa.base.Browser;
import com.gmail.qa.bo.Letter;
import com.gmail.qa.pages.HomePage;
import com.gmail.qa.pages.InboxPage;
import com.gmail.qa.pages.LogInPage;
import com.gmail.qa.pages.NewMessagePage;
import net.bytebuddy.utility.RandomString;
//import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;

public class SendMailTest extends AbstractTest {

	@Test
	public void wrightAndSendEmailMessageTest() throws FileNotFoundException {
		Letter letter = new Letter(prop.getProperty("subject") + RandomString.make(3), prop.getProperty("email"), prop.getProperty("text"));
		HomePage homePage = new LogInPage().open().logIn(account).clickComposeButton().sendMessage(letter);
		Assert.assertTrue(homePage.isLetterPresent(letter));
	}


	@AfterClass(description = "close browser")
	public void kill() {
		Browser.kill();
	}
}
