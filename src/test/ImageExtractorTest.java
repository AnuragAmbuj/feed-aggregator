package test;

import com.feedzard.feedaggregator.factory.IndiaFeedFactory;
import com.feedzard.feedaggregator.factory.TechFeedFactory;
import com.feedzard.feedaggregator.models.Feed;
import com.feedzard.feedaggregator.models.FeedMessage;
import com.feedzard.feedaggregator.reader.RSSFeedReader;
import com.feedzard.utilities.ImageURLExtractor;
import com.feedzard.utilities.ImageViewer;
import com.feedzard.utilities.ResourceDecoder;

import javax.xml.stream.XMLStreamException;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by aambuj on 11-09-2016.
 */
public class ImageExtractorTest {
    public static void main(String args[]){
        try {
            RSSFeedReader reader = RSSFeedReader.getSafeInstance(TechFeedFactory.TECH_FEED_URL);
            Feed feed = reader.readFeed();
            FeedMessage message = feed.getMessages().get(1);
            String imageUrl = ImageURLExtractor.getImageURLFromFeedDescription(message.getDescription());
            Image img = ResourceDecoder.decodeImageFromURL(new URL(imageUrl));
            ImageViewer.showImage(img);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
