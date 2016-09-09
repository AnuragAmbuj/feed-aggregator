package com.feedzard.feedaggregator.factory;

import com.feedzard.feedaggregator.models.Feed;
import com.feedzard.feedaggregator.reader.RSSFeedReader;

import javax.xml.stream.XMLStreamException;
import java.net.MalformedURLException;

/**
 * Created by aambuj on 06-09-2016.
 */
public class IndiaFeedFactory {
    public static final String INDIA_FEED_URL = "http://www.news18.com/rss/india.xml";
    public Feed getFeed() throws MalformedURLException, XMLStreamException {
        return RSSFeedReader.getSafeInstance(INDIA_FEED_URL).readFeed();
    }
}
