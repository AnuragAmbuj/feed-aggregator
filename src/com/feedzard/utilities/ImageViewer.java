package com.feedzard.utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 * Created by aambuj on 11-09-2016.
 */
public class ImageViewer {
    public static void showImage(Image image){
        JFrame frame = new JFrame("Image Viewer");
        frame.setSize(640,480);
        JLabel jLabel = new JLabel("Label");
        jLabel.setSize(640,480);
        jLabel.setIcon(new ImageIcon(image));
        frame.add(jLabel);
        frame.setVisible(true);
    }
}
