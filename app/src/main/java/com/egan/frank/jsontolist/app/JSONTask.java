package com.egan.frank.jsontolist.app;

import android.util.Log;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

public class JSONTask {
    public JSONObject getJSONfromURL(String channel) {
        JSONObject json = null;
        if (channel != null)
            try {
                URL embeddedURL = new URL("https://gdata.youtube.com/feeds/api/users/" +
                        channel + "/uploads?v=2&alt=jsonc");
                json = new JSONObject(IOUtils.toString(embeddedURL));
                //JSONArray jsonArray = json.getJSONObject("data").getJSONArray("items");
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("IOException", e.toString());
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e("JSONException", e.toString());
            }

        return json;
    }
}
