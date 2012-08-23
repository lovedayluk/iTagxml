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
import android.widget.TextView;

public class Second extends BaseActivity{

	private Button b1 = null;
	private Button b2 = null;
	private ImageView iv = null;
	private TextView tag;
	private TextView number;
	private Tagdb tagdb=new Tagdb(this);
	private Cursor mycursor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// TODO 锟皆讹拷锟斤拷傻姆锟斤拷锟斤拷锟斤拷
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		tag = (TextView) findViewById(R.id.textView1);
		number = (TextView) findViewById(R.id.textView2);
		
		//锟斤拷锟截的接匡拷
		b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO 锟皆讹拷锟斤拷傻姆锟斤拷锟斤拷锟斤拷
				Intent intent = new Intent();
				intent.setClass(Second.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		//锟斤拷锟斤拷慕涌锟�
		b2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO 锟皆讹拷锟斤拷傻姆锟斤拷锟斤拷锟斤拷
				
			}
		});
		
		iv = (ImageView) findViewById(R.id.imageView2);
		
		//从数据库中拿出tag
		String sql="select * tag from tagdb";
		//if(tagdb.getReadableDatabase().execSQL(sql))
		mycursor=tagdb.select();
		tag.setText(mycursor.getString(1));
		
		//统计number
		
		iv.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO 锟皆讹拷锟斤拷傻姆锟斤拷锟斤拷锟斤拷
				Intent intent = new Intent();
				intent.setClass(Second.this, Third.class);
				startActivity(intent);
				finish();
			}
		});
		
	}

}
