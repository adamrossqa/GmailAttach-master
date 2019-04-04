package com.gmail.qa.pages;

import com.gmail.qa.bo.Letter;
import com.gmail.qa.utils.PropertyLoader;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

public class NewMessagePage extends AbstractPage {

	private static final By ADDRESS_INPUT_LOCATOR = By.xpath("//textarea[@name='to']");
	private static final By SUBJECT_INPUT_LOCATOR = By.xpath("//input[@name='subjectbox']");
	private static final By BODY_INPUT_LOCATOR = By.xpath("//div[@aria-label='Message Body']");
	private static final By SEND_BUTTON_LOCATOR = By.xpath("//div[@role='button' and contains(@data-tooltip,'Send')]");
	private static final By ATTACH_FILES_LOCATOR = By.xpath("//input[@name=\"Filedata\"]");
	private static final By NEW_MESSAGE_LOCATOR = By.xpath("//div[@class=\"brc\"]");
	private static final By DOWNLOAD_FILE_BUTTON_LOCATOR = By.xpath("//div[@data-tooltip=\"Download\"]");

	public HomePage sendMessage(Letter letter) throws FileNotFoundException {
		browser.type(ADDRESS_INPUT_LOCATOR, letter.getRecipient());
		browser.type(SUBJECT_INPUT_LOCATOR, letter.getSubject());
		browser.type(BODY_INPUT_LOCATOR, letter.getContent());
		browser.writeToFile();
		browser.type(ATTACH_FILES_LOCATOR, "/Users/adamross/Downloads/GmailAttach-master/src/main/java/com/gmail/qa/config/attachmentTest.txt");
		browser.click(SEND_BUTTON_LOCATOR);
		browser.click(NEW_MESSAGE_LOCATOR);
		browser.click(DOWNLOAD_FILE_BUTTON_LOCATOR);
		return new HomePage();
	}

}