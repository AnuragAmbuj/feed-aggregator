package com.feedzard.utilities;

import com.feedzard.logging.Log;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import static java.util.logging.Level.FINE;

/**
 * Created by aambuj on 11-09-2016.
 */
public class ImageURLExtractor {

    public static String getImageURLFromFeedTitle(String feedLink) throws MalformedURLException {
        String data[] = feedLink.split("/>");
        data[0] = data[0]+"/>";
        //System.out.println(data[0]);
        //System.out.println(data[1]);
        Document document = Jsoup.parse(data[0]);
        String link = document.select("img").first().attr("src");
        return link;
    }

}
