package com.cmu.doc.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PastActivity extends ActionBarActivity {

    private String data[][] = new String[][] {{"Kimmel","01/02/2013","13:30"},
            {"Kimmel","01/02/2013","13:30"},{"Kimmel","01/02/2013","13:30"}};

    private ListView datalist = null;
    private List<Map<String,String>> list = new ArrayList<Map<String,String>>();
    private SimpleAdapter simpleAdapter = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.past);
        this.datalist = (ListView) super.findViewById(R.id.datalist);
        for (int x = 0;x < this.data.length;x++) {
            Map<String,String> map = new HashMap<String, String>();
            map.put("name", this.data[x][0]);
            map.put("date", this.data[x][1]);
            map.put("time", this.data[x][2]);
            this.list.add(map);
        }
        this.simpleAdapter = new SimpleAdapter(this, this.list, R.layout.data_list,
                new String[]{"name","date","time"}, new int[]{R.id.name, R.id.date, R.id.time});
        this.datalist.setAdapter(this.simpleAdapter);
        this.datalist.setOnItemClickListener(new OnItemClickListenerImpl());
    }

    private class OnItemClickListenerImpl implements OnItemClickListener{
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, String> map = (Map<String, String>) PastActivity.this.
                    simpleAdapter.getItem(position);  //just save for now for later use, not for this assignment
            Intent it = new Intent(PastActivity.this, PastDetailActivity.class);
            PastActivity.this.startActivity(it);
            PastActivity.this.finish();
        }
    }


    public void past(View view){
        Intent intent = new Intent(this, PastActivity.class);
        startActivity(intent);

    }

    public void future(View view){
        Intent intent = new Intent(this, FutureActivity.class);
        startActivity(intent);

    }

    public void info(View view){
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);

    }

}
