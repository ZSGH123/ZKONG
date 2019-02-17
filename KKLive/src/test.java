import java.util.Locale;
import java.util.ResourceBundle;


public class test {

	public static void main(String[] args) {
		Locale[] locale=Locale.getAvailableLocales();//地区
		for (Locale locale2 : locale) {
			System.out.println("地区："+locale2.getCountry()+"语言："+locale2.getLanguage());
		}
		ResourceBundle resourceBundle=ResourceBundle.getBundle("message",Locale.US);
		System.out.println(resourceBundle.getString("username"));

	}

}
