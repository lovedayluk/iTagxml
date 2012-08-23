package com.example.itagxml;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher.ViewFactory;

public class Four extends BaseActivity implements OnClickListener,ViewFactory{
	
	private Button b1 = null;
	private Button b2 = null;
	private Button b3 = null;
	private Button b4 = null;
	private Button b5 = null;
	private Button b6 = null;
	private Button b7 = null;
	
	private Integer[]   imagelist = {
			R.drawable.bakeneko,
			R.drawable.camera,
			R.drawable.bg,
			R.drawable.ic_action_search,
			R.drawable.icon_arrow_right,
			R.drawable.icon_add,
	};
	
	private int index = 0;
	
	private ImageSwitcher mswitcher = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// TODO 锟皆讹拷锟斤拷傻姆锟斤拷锟斤拷锟斤拷
		super.onCreate(savedInstanceState);
		setContentView(R.layout.four);
		
		Intent i = getIntent();
		index = i.getIntExtra("SelectedPicture", 0);
		
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);
		b4 = (Button) findViewById(R.id.button4);
		b5 = (Button) findViewById(R.id.button5);
		b6 = (Button) findViewById(R.id.button6);
		b7 = (Button) findViewById(R.id.button7);
		mswitcher = (ImageSwitcher) findViewById(R.id.IS);
		
		b3.setOnClickListener(this);
		b7.setOnClickListener(this);
		
		b1.setOnClickListener(new OnClickListener() {
			
				public void onClick(View v) {
					// TODO 锟皆讹拷锟斤拷傻姆锟斤拷锟斤拷锟斤拷
					Intent intent = new Intent();
					intent.setClass(Four.this, Third.class);
					startActivity(intent);
					finish();
				}
			});
		b2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
				
			}
		});
		
		b4.setOnClickListener(new OnClickListener() {
			
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
		
		b5.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
				Intent intent = new Intent();
				intent.setClass(Four.this, Sixth.class);
				startActivity(intent);
				finish();
			}
		});
		
		b6.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
				Intent intent = new Intent();
				intent.setClass(Four.this, Fifth.class);
				startActivity(intent);
				finish();
			}
		});
		
		mswitcher.setFactory(this);
		mswitcher.setImageResource(imagelist[index]);
		
	}
	public View makeView() {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int height = dm.heightPixels;
		ImageView i = new ImageView(this);
		i.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.MATCH_PARENT,height/2));

		
		//i.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.MATCH_PARENT,450));
        i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return i;
	}
	public void onClick(View v) {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		switch (v.getId()){
			case R.id.button3:
				index++;
				if(index >= imagelist.length) index = 0;
				mswitcher.setImageResource(imagelist[index]);
				break;
			case R.id.button7:
				index--;
				if( index<0 ) index = imagelist.length - 1;
				mswitcher.setImageResource(imagelist[index]);
				break;
		}
	}
	
}
