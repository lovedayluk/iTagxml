package com.example.itagxml;

import java.awt.Image;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import com.lovedayluk.database.DataBaseHelper;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher.ViewFactory;

public class Four extends BaseActivity {
	
	private Button btn_back = null;
	private Button btn_find = null;
	private Button btn_left = null;
	private Button btn_del = null;
	private Button btn_set = null;
	private Button btn_add = null;
	private Button btn_right = null;
	
	String tag = "";
	private DataBaseHelper database;
	private Cursor cursor;
	ArrayList<HashMap<String, Object>> listData;
	
	/*private Integer[]   imagelist = {
			R.drawable.bakeneko,
			R.drawable.camera,
			R.drawable.bg,
			R.drawable.ic_action_search,
			R.drawable.icon_arrow_right,
			R.drawable.icon_add,
	};*/
	
	private int index = 0;
	
	private ImageView image = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.four);
		final Bundle bundle = getIntent().getExtras();
		//上一张照片的uri
		String purl=bundle.getString("purl");
		Intent i = getIntent();
		index = i.getIntExtra("SelectedPicture", 0);
		
		btn_back = (Button) findViewById(R.id.button1);
		btn_find = (Button) findViewById(R.id.button2);
		btn_left = (Button) findViewById(R.id.button3);
		btn_add = (Button) findViewById(R.id.button4);
		btn_set = (Button) findViewById(R.id.button5);
		btn_del = (Button) findViewById(R.id.button6);
		btn_right = (Button) findViewById(R.id.button7);
		image = (ImageView) findViewById(R.id.imageView1);
		image.setImageBitmap(getPic(purl));
//		btn_left.setOnClickListener(this);
//		btn_right.setOnClickListener(this);
		
		//通过tag获取该tag里面的uri
		getUris();
		
		
		btn_back.setOnClickListener(new OnClickListener() {
			
				public void onClick(View v) {
					Intent intent = new Intent();
					String tag= bundle.getString("tag");
					Bundle bundle = new Bundle();
					bundle.putString("tag", tag);
					intent.putExtras(bundle);
					intent.setClass(Four.this, Third.class);
					startActivity(intent);
					finish();
				}
			});
		btn_find.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
			}
		});
		
		btn_add.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent();
	        	Bundle bundle=new Bundle();
	        	bundle.putBoolean("flag", false);
	        	intent.putExtras(bundle);
				intent.setClass(Four.this, Seventh.class);
				startActivity(intent);
//				Intent intent = new Intent();
//				intent.setClass(Four.this, Seventh.class);
//				startActivity(intent);
				finish();
			}
		});
		
		btn_set.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(Four.this, Sixth.class);
				startActivity(intent);
				finish();
			}
		});
		
		btn_del.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(Four.this, Fifth.class);
				startActivity(intent);
				finish();
			}
		});
		
//		mswitcher.setFactory(this);
//		mswitcher.setImageResource(imagelist[index]);
//		
	}
	
	/**
	 * 通过tag获取全部的uri
	 * @param null
	 * @return string[]
	 */
	public String[] getUris(){
			Cursor c = database.select_tag(tag);
			startManagingCursor(c);
			listData = new ArrayList<HashMap<String, Object>>();
			while (c.moveToNext()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("_id", c.getInt(c.getColumnIndex("_id")));
					map.put("tag", c.getString(c.getColumnIndex("tag")));
					map.put("uri", c.getString(c.getColumnIndex("uri")));
				//Log.v("uri", c.getString(c.getColumnIndex("uri")));
				listData.add(map);
			}  
		return null;
	}

//	public View makeView() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void onClick(View v) {
//		// TODO Auto-generated method stub
//		
//	}

//	public View makeView() {
//		DisplayMetrics dm = new DisplayMetrics();
//		getWindowManager().getDefaultDisplay().getMetrics(dm);
//		int height = dm.heightPixels;
//		ImageView i = new ImageView(this);
//		i.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.MATCH_PARENT,height/2));
//
//		
//		//i.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.MATCH_PARENT,450));
//        i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
//        return i;
//	}
//	public void onClick(View v) {
//		switch (v.getId()){
//			case R.id.button3:
//				index++;
//				if(index >= imagelist.length) index = 0;
//				mswitcher.setImageResource(imagelist[index]);
//				break;
//			case R.id.button7:
//				index--;
//				if( index<0 ) index = imagelist.length - 1;
//				mswitcher.setImageResource(imagelist[index]);
//				break;
//		}
//	}
//	
	/**
	 * 通过purl获得图片
	 * @param purl
	 * @return
	 */
	protected Bitmap getPic(String purl) {
		Uri uri = Uri.parse(purl);
		ContentResolver cr= this.getContentResolver();
		Bitmap temp_bm = null;
		try {
			temp_bm = BitmapFactory.decodeStream(cr.openInputStream(uri));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return temp_bm;
	}
}
