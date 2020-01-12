package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<ListCellData> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /***tab控制页面切换***/
        TabHost tabHost=findViewById(android.R.id.tabhost);
        tabHost.setup();
        LayoutInflater inflater=LayoutInflater.from(this);
        inflater.inflate(R.layout.tab1,tabHost.getTabContentView());
        inflater.inflate(R.layout.tab2,tabHost.getTabContentView());
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("生成").setContent(R.id.left));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("历史").setContent(R.id.right));
        /***生成界面***/

        /***打开文件管理器***/
        ImageButton openTheFile=findViewById(R.id.openTheFile);
        openTheFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"正在打开文件管理器，请稍后",Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, 1);

            }
        });
        /***自定义***/
        Button zidingyi=findViewById(R.id.zidingyi);
        zidingyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"正在打开自定义功能，请稍后",Toast.LENGTH_SHORT).show();
            }
        });
        /***历史界面***/

        listView=findViewById(R.id.listview);
        listView.setAdapter(new ListCellAdapter(this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListCellData item= (ListCellData) adapterView.getItemAtPosition(i);
                String title=item.getTitle().toString();
                int speed=item.getSpeed();
                String speedStr=speed+"";
                String instrument=item.getInstrument().toString();
                Toast.makeText(MainActivity.this,title+speedStr+instrument,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,DetailActivity.class);
                Bundle bundle=new Bundle();
                bundle.putCharSequence("title",title);
                bundle.putInt("speed",speed);
                bundle.putCharSequence("instrument",instrument);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        /***注释是其他几个listView使用的方法***/
//        int pic=R.drawable.music;
//        String[] ctype=new String[]{"1","2","3","4","5","1","2","3","4","5"};
//        List<Map<String,Object>> listItem=new ArrayList<Map<String,Object>>();
//        for(int i=0;i<ctype.length;i++){
//            Map<String,Object> map=new HashMap<String, Object>();
//            map.put("image",pic);
//            map.put("name",ctype[i]);
//            listItem.add(map);
//        }
//        SimpleAdapter adapter=new SimpleAdapter(this,listItem,R.layout.item_main,new String[]{"name","image"},
//                new int[]{R.id.title,R.id.image} );
//        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ctype);
//        ListView listView=findViewById(R.id.listview);
//        adapter=new ArrayAdapter<ListCellData>(this,android.R.layout.simple_list_item_1);
//        adapter.add(new ListCellData(pic,"1",1,"1"));
//        adapter.add(new ListCellData(pic,"2",2,"1"));
//        adapter.add(new ListCellData(pic,"3",3,"1"));
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Map<String,Object> map= (Map<String, Object>) adapterView.getItemAtPosition(i);
//                Toast.makeText(MainActivity.this,map.get("name").toString(),Toast.LENGTH_SHORT).show();
//            }
//        });
    }

}
