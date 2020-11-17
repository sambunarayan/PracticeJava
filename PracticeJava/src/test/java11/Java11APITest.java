package test.java11;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Java11APITest {

	public static void main(String[] args) throws URISyntaxException {
		// String blank Test
		String blank = "";
		String spaceBlank = " ";
		String zenSpaceBalnk = "@";
		System.out.println("bank->" + blank.isBlank());
		System.out.println("spaceBlank->" + spaceBlank.isBlank());
		System.out.println("zenSpaceBalnk->" + zenSpaceBalnk.isBlank());
		
		// Optional isEmpty
		Optional<String> op1 = Optional.ofNullable("data");
		if (op1.isEmpty()) {
			System.out.println("Don't reach here.");
		}
		Optional<String> op2 = Optional.ofNullable(null);
		if (op2.isEmpty()) {
			System.out.println("op2 is empty. isPresent -> " + op2.isPresent());
		}
		
		// Predicate not
		var list = List.of("a", "b", "c");
		list.stream().filter(Predicate.not(s->s.equals("b"))).forEach(System.out::print);
		System.out.println();
		
		// HTTP/2
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(URI.create("https://www.naver.com")).GET().build();
		try {
			var response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.headers());
			System.out.println(response.body());
			Desktop desktop = Desktop.getDesktop();
			desktop.browse(response.uri());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
