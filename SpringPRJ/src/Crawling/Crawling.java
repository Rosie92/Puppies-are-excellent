package Crawling;

import java.io.IOException;

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;

public class Crawling {

	@RequestMapping(value="Crawling.do")
	public static void main(String[] args) throws IOException {
		// 교보문고 크롤링
		String url = "https://blog.naver.com/PostList.nhn?blogId=animalandhuman&from=postList&categoryNo=32";

		Document doc = null;
		doc = Jsoup.connect(url).get();

		// 
		Elements element = doc.select("div.clearfix");
		/*PC-THEME-ANIMAL-EDIT-AREA*/

		System.out.println(element);

		
}
}