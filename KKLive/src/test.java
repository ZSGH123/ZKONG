import java.util.Locale;
import java.util.ResourceBundle;


public class test {

	public static void main(String[] args) {
		Locale[] locale=Locale.getAvailableLocales();//����
		for (Locale locale2 : locale) {
			System.out.println("������"+locale2.getCountry()+"���ԣ�"+locale2.getLanguage());
		}
		ResourceBundle resourceBundle=ResourceBundle.getBundle("message",Locale.US);
		System.out.println(resourceBundle.getString("username"));

	}

}
