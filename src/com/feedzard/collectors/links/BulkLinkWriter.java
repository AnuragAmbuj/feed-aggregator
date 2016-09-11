package com.feedzard.collectors.links;

import com.feedzard.collectors.symbols.FLStoreFactory;
import com.feedzard.feedaggregator.models.Feed;
import com.feedzard.feedaggregator.models.FeedMessage;
import com.feedzard.logging.Log;

import java.io.File;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by aambuj on 06-09-2016.
 */
public class BulkLinkWriter {

    Feed feed;

    private BulkLinkWriter(Feed feed) {
        this.feed = feed;
    }


    public void initialize(Feed feed) {
        if (feed == null) {
            feed = new Feed("", "", "", "", "", "");
        } else {
            this.feed = feed;
        }
    }

    public void writeFeedLinksToFLStore() throws Exception {

        if (feed == null || feed.getTitle().equals("")) {
            Log.writeLine(Level.SEVERE,"Null feed encountered");
        } else {
            PrintWriter printWriter = null;
            try {
                printWriter = new PrintWriter(FLStoreFactory.LINK_FEED_FILE);
            } catch (Exception e) {
                throw new Exception("Permission Error");
            }
            for (FeedMessage feedMessage : feed.getMessages()) {
                printWriter.println(feedMessage.getLink());
            }
            printWriter.close();
        }

    }

    public static BulkLinkWriter getBulkLinkWriterInstance(Feed feed){
        BulkLinkWriter bulkLinkWriter = new BulkLinkWriter(feed);
        bulkLinkWriter.initialize(feed);
        try {
            bulkLinkWriter.writeFeedLinksToFLStore();
        } catch (Exception e) {
            //TODO
        }
        return bulkLinkWriter;
    }

}
