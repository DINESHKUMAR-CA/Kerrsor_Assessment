package Kerrsor.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigReader {

	private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);
	private static final Properties properties = new Properties();

	public ConfigReader() {

		try {

			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Configuration/config.properties");
			properties.load(fis);
			logger.info("Configuration file loaded successfully");

		} catch (Exception e) {
			logger.error("Uh...Oh..Failed to load config.properties file: {}", e.getMessage());
			throw new RuntimeException("Failed to load config.properties file", e);
		}
	}

	public static String getProperty(String key) {

		return properties.getProperty(key,"Property Not Found");
	}

}
