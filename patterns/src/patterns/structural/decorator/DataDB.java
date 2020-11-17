package patterns.structural.decorator;

import java.util.Random;

public class DataDB {

	private String name;
	private String password;
	private String url;

	public DataDB() {
		Random random = new Random();
		StringBuilder myName = new StringBuilder();
		StringBuilder myPassword = new StringBuilder();
		String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
		String digits = "0123456789";
		for (int countSymbols = 0; countSymbols < 20; countSymbols++) {
			myName.append(alphabet.charAt(random.nextInt(alphabet.length())));
		}
		for (int countDigits = 0; countDigits < 10; countDigits++) {
			myPassword.append(digits.charAt(random.nextInt(digits.length())));
		}
		String myUrl = "https://";
		setName(myName.toString());
		setPassword(myPassword.toString());
		setUrl(myUrl);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
