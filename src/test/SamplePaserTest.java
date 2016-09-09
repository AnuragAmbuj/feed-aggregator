package test;

import com.feedzard.collectors.links.BulkLinkWriter;
import com.feedzard.feedaggregator.models.Feed;
import com.feedzard.feedaggregator.models.FeedMessage;
import com.feedzard.feedaggregator.parser.RSSFeedParser;
import com.feedzard.logging.Log;

import javax.xml.stream.XMLStreamException;
import java.net.MalformedURLException;
import java.util.logging.Level;

/**
 * Created by aambuj on 05-09-2016.
 */
public class SamplePaserTest {
    public static void main(String args[]){
        try {
            RSSFeedParser reader = RSSFeedParser.getSafeInstance("http://www.news18.com/rss/india.xml");
            Feed feed = reader.readFeed();
            BulkLinkWriter bulkLinkWriter = BulkLinkWriter.getBulkLinkWriterInstance(feed);
            for(FeedMessage message:feed.getMessages()){
                System.out.println("_______________________________________________________");
                System.out.println(message.getFeedId()+": "+message.getTitle()+ " by "+message.getAuthor());
                System.out.println(message.getDescription());
                System.out.println(message.getLink());
                System.out.println("_______________________________________________________");
            }
        } catch (MalformedURLException e) {
            Log.writeLine(Level.SEVERE," Nothing much to say");
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
