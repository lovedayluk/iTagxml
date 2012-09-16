package com.example.itagxml;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class Sixth extends BaseActivity{
	
	private Button b1 = null;
	private Button b3 = null;
	private Button b4 = null;
	private Button b6 = null;
	private ListView  lv = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sixth);
		
		b1 = (Button) findViewById(R.id.button1);
		b3 = (Button) findViewById(R.id.button3);
		b4 = (Button) findViewById(R.id.button4);
		b6 = (Button) findViewById(R.id.button6);
		
		b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent();
				intent.setClass(Sixth.this, Four.class);
				startActivity(intent);
				finish();
			}
		});
		
		lv = (ListView) findViewById(R.id.listView1);
		lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent();
				intent.setClass(Sixth.this, Sixth2.class);
				//intent.putExtra(name, value);
				finish();
			}
		});
		
		
	}
	

}
