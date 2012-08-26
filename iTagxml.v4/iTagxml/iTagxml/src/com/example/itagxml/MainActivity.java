package com.example.itagxml;

import java.io.FileNotFoundException;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class MainActivity extends BaseActivity {

	private Button b1 = null;
	private Button b2 = null;
	private Button b3 = null;
	private Picdb picdb;
	private Tagdb tagdb;
	protected final static int quit=Menu.FIRST;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        picdb=new Picdb(this);
        tagdb=new Tagdb(this);
        
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
     

        //tagdb.getWritableDatabase().execSQL("insert into tagdb values (null, ?, ?)", this.getStringArray(pid,pt));
       
        //Toast.makeText(this, this.getStringArray(pid,pt), 1).show();
        b2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO ï¿½Ô¶ï¿½ï¿½ï¿½ÉµÄ·ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, Second.class);
				startActivity(intent);
				finish();
			}
		});
        
    	b3.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent();
	        	Bundle bundle=new Bundle();
	        	bundle.putBoolean("flag", true);
	        	intent.putExtras(bundle);
				intent.setClass(MainActivity.this, Seventh.class);
				startActivity(intent);
//				Intent intent = new Intent();
//		        intent.setType("image/*");
//		        intent.setAction(Intent.ACTION_GET_CONTENT); 
//		        startActivityForResult(intent, 1);
				//Intent intent = new Intent();
				//intent.setClass(MainActivity.this, Seventh.class);
				//startActivity(intent);
				finish();
			}
		});
        
        
    }
    
    @Override
   	protected void onDestroy() {
   		// TODO Auto-generated method stub
       	Log.v("Test", "Detory");
   		super.onDestroy();
   		if (tagdb != null) {
   			tagdb.close();
   			tagdb = null;
   		}
   			
   	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
		return false;
        //getMenuInflater().inflate(R.menu.activity_main, menu);
        //return true;
    	//menu.add(0,quit,0,"ÍË³ö");  
    	//return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	//int item_id=item.getItemId();//µÃµ½µ±Ç°Ñ¡ÖÐMenuItemµÄID
	//switch(item_id){
		//case 0:{
		//	Toast toast=Toast.makeText(this, "ÕýÔÚÍË³ö", Toast.LENGTH_SHORT);
		//	toast.show();
			//MainActivity.
		//}
	//}
	return true;
    }
    
   
    
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			Uri uri = data.getData();
			Log.e("uri", uri.toString());
			ContentResolver cr = this.getContentResolver();
			try {
				Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
				ImageView imageView = (ImageView) findViewById(R.id.imageView2);
				
				imageView.setImageBitmap(bitmap);
			} catch (FileNotFoundException e) {
				Log.e("Exception", e.getMessage(),e);
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
    
}
