package com.feedzard.utilities;

import javafx.scene.media.VideoTrack;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by aambuj on 11-09-2016.
 */
public class ResourceDecoder {

    public static Image decodeImageFromURL(URL url) throws IOException {
        Image image = ImageIO.read(url);
        return image;
    }

    public static Graphics decodeImageGraphicsFromURL(URL url) throws IOException{
        Image image = ImageIO.read(url);
        return image.getGraphics();
    }

    public static VideoTrack getVideoTrackFromFeed(URL url){
        //TODO
        return null;
    }
}
