package com.example.itagxml;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Second extends BaseActivity{

	private Button b1 = null;
	private Button b2 = null;
	private ImageView iv = null;
	private TextView tag;
	private TextView number;
	private Tagdb tagdb=new Tagdb(this);
	private Cursor mycursor;
	private ListView listview=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// TODO 閿熺殕璁规嫹閿熸枻鎷峰偦濮嗛敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		tag = (TextView) findViewById(R.id.textView1);
		number = (TextView) findViewById(R.id.textView2);
		listview = (ListView) findViewById(R.id.listView1);
		
		//閿熸枻鎷烽敓鎴殑鎺ュ尅鎷�
		b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO 閿熺殕璁规嫹閿熸枻鎷峰偦濮嗛敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
				Intent intent = new Intent();
				intent.setClass(Second.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		//閿熸枻鎷烽敓鏂ゆ嫹鎱曟秾閿燂拷
		b2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO 閿熺殕璁规嫹閿熸枻鎷峰偦濮嗛敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
				
			}
		});
		
		iv = (ImageView) findViewById(R.id.imageView2);
		mycursor=tagdb.select();
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.list,mycursor,
				new String[]{ tagdb.tag },new int[]{ R.id.textView1 });
		listview.setAdapter(adapter);
		
		
		//缁熻number
		
		iv.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO 閿熺殕璁规嫹閿熸枻鎷峰偦濮嗛敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
				Intent intent = new Intent();
				intent.setClass(Second.this, Third.class);
				startActivity(intent);
				finish();
			}
		});
		
	}

}
