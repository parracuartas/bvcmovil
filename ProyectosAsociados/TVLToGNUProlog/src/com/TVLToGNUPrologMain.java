/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.common.Util;
import com.feature.FeatureGroup;
import com.identifiers.ChildrenId;
import com.identifiers.LongId;
import com.values.TvlBoolean;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yuxi
 */
public class TVLToGNUPrologMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String textFile = Util.readFile("C:\\Users\\yuxi\\Desktop\\tvlexample.tvl");
        FeatureGroup fg = new FeatureGroup(textFile);
        fg.toString();
    }
}