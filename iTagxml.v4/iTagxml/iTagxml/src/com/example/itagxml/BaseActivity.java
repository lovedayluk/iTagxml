package com.example.itagxml;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class BaseActivity extends Activity {

public static final String TAG = "BaseActivity" ;
public static ArrayList<Activity> activityList = new ArrayList<Activity>();

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
activityList.add(this);
Log.i(TAG, activityList.toString()) ;
}
protected String[] getStringArray(String pid,String text) {
	String part[] = {pid,text};
	return part;
}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
menu.add(0, 0, 0, "�˳�����");
return super.onCreateOptionsMenu(menu);
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
if (item.getItemId() == 0) {
exitApp();
}
return super.onOptionsItemSelected(item);
}

@Override
protected void onDestroy() {
super.onDestroy();

activityList.remove(this);
Log.i(TAG, activityList.toString()) ;
}

/**
* ����ȫȫ�˳�Ӧ�ó���
*/
public void exitApp() {
AlertDialog.Builder builder = new AlertDialog.Builder(this);
builder.setTitle("��ʾ");
builder.setMessage("��ȷ��Ҫ�˳�������?");
builder.setPositiveButton("ȷ��", new OnClickListener() {

public void onClick(DialogInterface dialog, int which) {
   if (activityList.size() > 0) {
       for (Activity activity : activityList) {
       activity.finish();
   }
    android.os.Process.killProcess(android.os.Process.myPid());
   }
}
});
builder.setNegativeButton("ȡ��", null);
builder.show();
}

}