package criminal.criminal.util;

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

import criminal.criminal.model.Crime;

/**
 * Created by asus on 2015/11/6.
 * 负责读取Crime数组列表中的数据，进行数据格式转换，然后写入JSON文件
 */
public class CriminialJSONSerializer {

    private Context mContext;
    private String mFileName;

    public CriminialJSONSerializer(Context c,String f){
        mContext = c;
        mFileName = f;
    }

    //存储数据到文件
    public void saveCrimes(ArrayList<Crime> crimes) throws JSONException,IOException{

        JSONArray array = new JSONArray();
        for (Crime c:crimes)
            array.put(c.toJSON());

        Writer writer = null;
        try {
            OutputStream out = mContext.openFileOutput(mFileName,Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        }finally {
            if (writer != null)
                writer.close();
        }
    }

    //从文件中加载数据
    public ArrayList<Crime> loadCrimes() throws IOException,JSONException{
        ArrayList<Crime> crimes = new ArrayList<Crime>();
        BufferedReader reader = null;
        try {
            // open and read the file into a StringBuilder
            InputStream in = mContext.openFileInput(mFileName);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine())!=null){
                //line breaks are omitted and irrelevent
                jsonString.append(line);
            }
            //Parse the JSON using JSONTokener
            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString())
                    .nextValue();
            //Build the array of crimes from JSONObjects
            for (int i=0;i<array.length();i++){
                crimes.add(new Crime(array.getJSONObject(i)));
            }
        }catch (FileNotFoundException e){
            //Ignore this one,it happens when starting fresh
        }finally {
            if (reader!=null)
                reader.close();
        }
        return crimes;
    }


}
