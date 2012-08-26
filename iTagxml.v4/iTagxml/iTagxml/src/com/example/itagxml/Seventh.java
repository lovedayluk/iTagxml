package com.example.itagxml;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;


import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Seventh extends BaseActivity{

	private Button b1 = null,b6=null;
	private EditText et = null;
	private String purl=null;
	private String key=null;
	private TextView name=null;
	private Button sumit=null;
	private Picdb picdb;
	private Tagdb tagdb= new Tagdb(this);
	private String[] info=null;
	private Button cancel;
	private Cursor myCursor;	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
        final Bundle bundle = this.getIntent().getExtras();
//        String message = bundle.getString("message");
		setContentView(R.layout.seventh);
		if(bundle.getBoolean("flag")){
			Intent intent = new Intent();
	        intent.setType("image/*");
	        intent.setAction(Intent.ACTION_GET_CONTENT); 
	        startActivityForResult(intent, 1);
	        
		}
		
        
		
		b1 = (Button) findViewById(R.id.button1);
		b6 = (Button) findViewById(R.id.button6);
		et = (EditText) findViewById(R.id.editText1);
		name=(TextView) findViewById(R.id.textView1);
		sumit=(Button)findViewById(R.id.button3);
		cancel=(Button)findViewById(R.id.button4);
		ImageView imageView = (ImageView) findViewById(R.id.imageView2);
		GridView gridview = (GridView) findViewById(R.id.gridView1);
		
		//ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>(); 
		/*myCursor=tagdb.select_uri(purl);
		@SuppressWarnings("deprecation")
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.gridrow,myCursor,
				new String[]{ tagdb.tag },new int[]{ R.id.textView1 });
		gridview.setAdapter(adapter);*/
		b6.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//Toast.makeText(this, myCursor.getColumnNames()[0], Toast.LENGTH_LONG).show();
			}
		
		});
		
		b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent();
				if(!bundle.getBoolean("flag"))
				intent.setClass(Seventh.this, Four.class);
				else
					intent.setClass(Seventh.this,MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		imageView.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent();
		        intent.setType("image/*");
		        intent.setAction(Intent.ACTION_GET_CONTENT); 
		        startActivityForResult(intent, 1);
			}
		});
		
		et.setOnKeyListener(new OnKeyListener() {
			
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO 自动生成的方法存根
				 key = et.getText().toString();
				return false;
			}
		});
		
		sumit.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO 自动生成的方法存根
				//if(bundle.getBoolean("flag"))
				//{
				key = et.getText().toString();
				info=key.split(" ");                 // 通过分割符号将字符串分割并保存到info数组中
				
				//tagdb.getWritableDatabase().execSQL("insert into tagdb values(null, 1, 1)");
					for(int i=0;i<info.length;i++){
						Log.v("info Message", info[i]);
				          tagdb.getWritableDatabase().execSQL("insert into tagdb values (null, ?, ?)", this.getStringArray(info[i],purl));
					}
					Toast.makeText(getBaseContext(), "添加成功", Toast.LENGTH_SHORT);
				
			}

			private Object[] getStringArray(String key, String purl) {
				// TODO 自动生成的方法存根
				String part[] = {key,purl};
				return part;
			}

		});
		
		cancel.setOnClickListener(new OnClickListener()
		{

			public void onClick(View v) {
				// TODO 自动生成的方法存根
				et.setText("");
			}
			
		});
		
	}
	


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			Uri uri = data.getData();
			Log.e("uri", uri.toString());
			purl=uri.toString();
			ContentResolver cr = this.getContentResolver();
			try {
				Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
				ImageView imageView = (ImageView) findViewById(R.id.imageView2);
				imageView.setImageBitmap(bitmap);
			} catch (FileNotFoundException e) {
				Log.e("Exception", e.getMessage(),e);
			}
		}
		
	}
	
}
