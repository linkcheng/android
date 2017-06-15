package com.example.linkcheng.criminalintent;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by link on 2017/6/13.
 */

public class CriminalIntentJSONSerializer {
    private Context mContext;
    private String mFilename;

    public CriminalIntentJSONSerializer(Context c, String s) {
        mContext = c;
        mFilename = s;
    }

    public void saveCrimes(ArrayList<Crime> crimes) throws JSONException, IOException {
        // 构建 json 字符串
        JSONArray array = new JSONArray();
        for (Crime c : crimes) {
            array.put(c.toJSON());
        }

        // 写文件
        Writer writer = null;
        try {
            OutputStream out = mContext.openFileOutput(mFilename, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public ArrayList<Crime> loadCrimes() throws IOException, JSONException {
        ArrayList<Crime> crimes = new ArrayList<>();
        BufferedReader reader = null;

        try {
            // 打开文件，把内容读取到 stringbuilder 中
            InputStream in = mContext.openFileInput(mFilename);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuffer jsonString = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }

            // 使用 JSONTokener 解析 json
            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            // 通过 jsonarray 创建 crimes
            for (int i = 0; i < array.length(); i++) {
                crimes.add(new Crime(array.getJSONObject(i)));
            }
        } catch (FileNotFoundException e) {
            // do nothing
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return crimes;
    }
}
