package com.example.itagxml;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class Sixth2 extends BaseActivity{
	
	private EditText et = null;
	private CheckBox ck = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sixth2);
		et = (EditText) findViewById(R.id.editText1);
		ck = (CheckBox) findViewById(R.id.checkBox1);
		
		et.setOnKeyListener(new OnKeyListener() {
			
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO �Զ����ɵķ������
				String key = et.getText().toString();
				return false;
			}
		});
		
		ck.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO �Զ����ɵķ������
				
				if (ck.isChecked()) {
					
				}
				
				else {
					
				}
				
			}
		});
		/*
		Intent i = getIntent();
		i.getCharExtra(name, defaultValue);
		*/
	}
	
}
