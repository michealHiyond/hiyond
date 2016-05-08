package test.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 
 * @author Hiyond
 *
 */
public class JsoupTest {

	public static void main(String[] args) {
		testJsoup();
	}
	
	public static void testJsoup(){
		long t0 = System.currentTimeMillis();
		System.out.println("start");
		String url = "http://www.jd.com";
		try {
			Document doc = Jsoup.connect(url).get();
			System.out.println(doc.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println((System.currentTimeMillis()-t0));
	}
	
}
