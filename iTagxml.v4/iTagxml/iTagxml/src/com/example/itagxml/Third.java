package com.example.itagxml;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;

public class Third extends BaseActivity{
	
	private Button b1 = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// TODO 锟皆讹拷锟斤拷傻姆锟斤拷锟斤拷锟斤拷
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);
		
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO 锟皆讹拷锟斤拷傻姆锟斤拷锟斤拷锟斤拷
				Intent intent = new Intent();
				intent.setClass(Third.this, Second.class);
				startActivity(intent);
				finish();
			}
		});
		
		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageApdater(this));
		gridview.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
				Intent intent = new Intent();
				intent.setClass(Third.this, Four.class);
				intent.putExtra("SelectedPicture", arg2);
				startActivity(intent);
				//finish();
			}
		});
	}

}


class ImageApdater extends BaseAdapter{

	private Context mcontext ;
	
	private Integer[] mimagesid = {
		R.drawable.bakeneko,
		R.drawable.bakeneko,
		R.drawable.bakeneko,
		R.drawable.bakeneko,
		R.drawable.bakeneko,
		R.drawable.bakeneko,
	};
	
	public ImageApdater(Context c){
		mcontext = c;
	}
	
	public int getCount() {
		// TODO 锟皆讹拷锟斤拷傻姆锟斤拷锟斤拷锟斤拷
		return mimagesid.length;
	}

	public Object getItem(int position) {
		// TODO 锟皆讹拷锟斤拷傻姆锟斤拷锟斤拷锟斤拷
		return position;
	}

	public long getItemId(int position) {
		// TODO 锟皆讹拷锟斤拷傻姆锟斤拷锟斤拷锟斤拷
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO 锟皆讹拷锟斤拷傻姆锟斤拷锟斤拷锟斤拷
		ImageView imageview = new ImageView(mcontext);
		imageview.setImageResource(mimagesid[position]);
		imageview.setLayoutParams(new GridView.LayoutParams(85, 85) );
		imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
		return imageview;
		}
	
}
