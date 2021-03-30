package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
@SuppressWarnings("unchecked")
public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter mAdapter;
    public ArrayList<DataFile> objectslist= new ArrayList<>();
    private onClickInterface onClickinterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(false);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        get_json();

        // specify an adapter (see also next example)
        mAdapter = new MyRecyclerAdapter(this, objectslist,onClickinterface);
        mRecyclerView.setAdapter(mAdapter);

    }
    public void get_json(){
        String json="null";
        try{

            /*InputStream is = getAssets().open("Countries.json");

            int size = is.available();
             byte buffer[] = new byte[size];
             is.read();
             is.close();
             json = new String(buffer,"UTF-8");
            */
            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(getAssets().open("Countries.json")));
            StringBuffer sb = new StringBuffer();
            String temp;
            while ((temp = jsonReader.readLine()) != null)
                sb.append(temp);
            String myjsonstring = sb.toString();
            JSONArray ja = new JSONArray(myjsonstring);
            for(int i = 0;i<ja.length();i++){
                JSONObject jo = ja.getJSONObject(i);
                DataFile d = new DataFile(jo.getString("name"),jo.getString("capital"),jo.getString("region"),jo.getString("subregion"),jo.getLong("population"));
                objectslist.add(d);
            }
            Log.d("happyfeel", "happyfeel"+objectslist.size());

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}