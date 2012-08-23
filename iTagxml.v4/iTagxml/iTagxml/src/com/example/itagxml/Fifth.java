package com.example.itagxml;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Fifth extends BaseActivity{
	
	private Button b1 = null;
	private Button b2 = null;
	private Button b3 = null;
	private Button b4 = null;
	private Button b6 = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fifth);
		
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);
		b4 = (Button) findViewById(R.id.button4);
		b6 = (Button) findViewById(R.id.button6);
		
		b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent();
				intent.setClass(Fifth.this, Four.class);
				startActivity(intent);
				finish();
			}
		});
		
		
		b6.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent();
				intent.setClass(Fifth.this, Fifth2.class);
				startActivity(intent);
				finish();
			}
		});
		
	}
	
}
