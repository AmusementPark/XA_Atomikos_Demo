package zsh.demos.xa.conf;

import java.util.Properties;

public class DataSourceProperty {
	private String url;
	private String username;
	private String password;
//	private String driverClassName;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Properties toProperties() {
		Properties properties = new Properties();
		properties.setProperty("url", url);
		properties.setProperty("user", username);
		properties.setProperty("password", password);
		return properties;
	}
}
