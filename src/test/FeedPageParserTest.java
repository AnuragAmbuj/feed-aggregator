package test;

import com.feedzard.collectors.feeds.FeedPageParser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by aambuj on 11-09-2016.
 */
public class FeedPageParserTest {
    public static void main(String args[]){
        FeedPageParser feedPageParser = new FeedPageParser();
        try {
            feedPageParser.initializePageParsing(new URL("http://www.news18.com/news/india/kashmir-civil-society-urges-president-to-initiate-dialogue-1290640.html"));
            feedPageParser.readHTMLPage();
            String content = feedPageParser.getTextContent();
            System.out.println(content);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
