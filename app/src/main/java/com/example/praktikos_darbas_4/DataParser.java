package com.example.praktikos_darbas_4;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DataParser {
    public static List<CurrencyItem> parseXml(InputStream xmlInputStream) throws Exception {
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(xmlInputStream, null);
        List<CurrencyItem> items = new ArrayList<>();
        int eventType = parser.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && parser.getName().equals("Cube")) {
                String currency = parser.getAttributeValue(null, "currency");
                String rateString = parser.getAttributeValue(null, "rate");

                if (currency != null && rateString != null) {
                    double rate = Double.parseDouble(rateString);
                    items.add(new CurrencyItem(currency, rate));
                }
            }
            eventType = parser.next();
        }
        return items;
    }
}
