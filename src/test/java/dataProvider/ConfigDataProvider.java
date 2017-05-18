package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	
	public ConfigDataProvider(){
		File src=new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			 pro=new Properties();
			 pro.load(fis);
		} catch (Exception e) {
			System.out.println("exception is "+e.getMessage());
		}
	}
	public String getApplicationUrl(){
		String URL=pro.getProperty("url");
		return URL;
	}
	public String getChromePath(){
		String chromepath=pro.getProperty("chromePath");
		return chromepath;
	}
	public String getIePath(){
		String iePath=pro.getProperty("iepath");
		return iePath;
	}
	public String getFirefoxPath() {
		String geckopath=pro.getProperty("firefoxgeckopath");
		return geckopath;

	}
	

}
