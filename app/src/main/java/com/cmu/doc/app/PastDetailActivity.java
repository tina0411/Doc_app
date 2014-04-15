package com.cmu.doc.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class PastDetailActivity extends ActionBarActivity {

    private TextView detail = null;
    private Button ret = null;

    private String data[][] = new String[][] {{"Priscription","PDF","01/09/2013 15:30"},{"CT","Photo","01/21/2013 13:30"}};

    private ListView datalist = null;
    private List<Map<String,String>> list = new ArrayList<Map<String,String>>();
    private SimpleAdapter simpleAdapter = null;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.past_detail);
        this.detail = (TextView) super.findViewById(R.id.p_detail);
        this.ret = (Button) super.findViewById(R.id.p_ret);
        this.detail.setText("Appointment 1");

        this.datalist = (ListView) super.findViewById(R.id.doclist);
        for (int x = 0;x < this.data.length;x++) {
            Map<String,String> map = new HashMap<String, String>();
            map.put("doc", this.data[x][0]);
            map.put("type", this.data[x][1]);
            map.put("doc_time", this.data[x][2]);
            this.list.add(map);
        }
        this.simpleAdapter = new SimpleAdapter(this, this.list, R.layout.data_list,
                new String[]{"doc","type","doc_time"}, new int[]{R.id.doc, R.id.type, R.id.doc_time});
        this.datalist.setAdapter(this.simpleAdapter);
        this.datalist.setOnItemClickListener(new OnItemClickListenerImpl());
        this.ret.setOnClickListener(new OnClickListenerImpl());
    }

    private class OnItemClickListenerImpl implements OnItemClickListener{
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, String> map = (Map<String, String>) PastDetailActivity.this.
                    simpleAdapter.getItem(position);  //just save for now for later use, not for this assignment
            Intent it = new Intent(PastDetailActivity.this, PastDetailActivity.class);
            PastDetailActivity.this.startActivity(it);
            PastDetailActivity.this.finish();
        }
    }

    private class OnClickListenerImpl implements OnClickListener {

        //if user press return button, the current activity will be finished
        //and return to the previous activity
        //because startActivityForResult is used in the previous activity
        public void onClick(View v){
            Intent it = new Intent(PastDetailActivity.this, PastActivity.class);
            PastDetailActivity.this.startActivity(it);
            PastDetailActivity.this.finish();
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
