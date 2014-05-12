package com.example.sampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sampleapp.configuration.GeneratedListView;
import com.example.sampleapp.model.Contact;

public class MainActivity extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Contact kowal = new Contact();
		kowal.setImie("Jan");
		kowal.setNazwisko("Kowal");
		kowal.setWiek(65L);
		Contact nowak = new Contact();
		nowak.setImie("W³adys³");
		nowak.setNazwisko("Nowak");
		nowak.setWiek(32L);
		Contact kulpa = new Contact();
		kulpa.setImie("Sebastian");
		kulpa.setNazwisko("Kulpa");
		kulpa.setWiek(23L);
		Contact[] contacts = {kowal, nowak, kulpa};

		GeneratedListView<Object> gv = new GeneratedListView<Object>(this);
		gv.generate(contacts);
		setContentView(gv.getListView());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_add) {
			Intent addIntent = new Intent(this, AddActivity.class);
			startActivity(addIntent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
