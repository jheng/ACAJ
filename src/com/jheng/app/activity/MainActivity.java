package com.jheng.app.activity;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jheng.app.R;
import com.jheng.app.entity.Employee;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

public class MainActivity extends ActionBarActivity
{
	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void startSearch(View v)
	{
		EditText txtId = (EditText) findViewById(R.id.editText1);
		int id = Integer.parseInt(txtId.getText().toString());
		String url = "http://192.168.1.2:8777/m/employee/" + id;
		AsyncHttpClient client = new AsyncHttpClient();
		client.get(url, new JsonHttpResponseHandler()
		{

			@Override
			public void onSuccess(int statusCode, Header[] headers,
					JSONObject resp)
			{
				Employee emp = new Gson().fromJson(resp.toString(),
						Employee.class);
				TextView txtName = (TextView) findViewById(R.id.txtName);
				TextView txtGroup = (TextView) findViewById(R.id.txtGroup);
				txtName.setText(emp.getEmpName());
				txtGroup.setText(emp.getProjectGroup().getGroupName());
			}

			@Override
			public void onFailure(int statusCode, Header[] headers,
					String responseString, Throwable throwable)
			{
				Log.e("Test", throwable.getMessage());
			}
		});
	}
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		android.os.Debug.stopMethodTracing();
	}
}
