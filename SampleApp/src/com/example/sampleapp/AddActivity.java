package com.example.sampleapp;

import java.util.Calendar;

import com.example.sampleapp.components.ExtendedListItem;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AddActivity extends ActionBarActivity {

	TextView imieTV;
	EditText imieET;
	TextView nazwiskoTV;
	EditText nazwiskoET;
	TextView dataUrodzeniaTV;
	Button dataUrodzenia;
	TextView adresEmailTV;
	EditText adresEmailET;
	TextView numerTelefonuTV;
	EditText numerTelefonuET;
	Button zapisz;
	ExtendedListItem test;

	Activity thisActivity = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout addLayout = new LinearLayout(this);
		addLayout.setOrientation(LinearLayout.VERTICAL);
		setContentView(addLayout);

		imieTV = new TextView(this);
		imieTV.setText("Imie");
		addLayout.addView(imieTV);

		imieET = new EditText(this);
		imieET.setHint("Imie");
		addLayout.addView(imieET);

		nazwiskoTV = new TextView(this);
		nazwiskoTV.setText("Nazwisko");
		addLayout.addView(nazwiskoTV);

		nazwiskoET = new EditText(this);
		nazwiskoET.setHint("Nazwisko");
		addLayout.addView(nazwiskoET);

		dataUrodzeniaTV = new TextView(this);
		dataUrodzeniaTV.setText("Data urodzenia");
		addLayout.addView(dataUrodzeniaTV);

		initDataUrodzenia();
		addLayout.addView(dataUrodzenia);

		adresEmailTV = new TextView(this);
		adresEmailTV.setText("Adres email");
		addLayout.addView(adresEmailTV);

		adresEmailET = new EditText(this);
		adresEmailET.setHint("Adres email");
		adresEmailET.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
		addLayout.addView(adresEmailET);

		numerTelefonuTV = new TextView(this);
		numerTelefonuTV.setText("Numer telefonu");
		addLayout.addView(numerTelefonuTV);

		numerTelefonuET = new EditText(this);
		numerTelefonuET.setHint("Numer telefonu");
		numerTelefonuET.setInputType(InputType.TYPE_CLASS_PHONE);
		addLayout.addView(numerTelefonuET);

		zapisz = new Button(this);
		zapisz.setText("Zapisz");
		addLayout.addView(zapisz);
		
		test = new ExtendedListItem(this);
		addLayout.addView(test);
	}

	private void initDataUrodzenia() {
		dataUrodzenia = (Button) LayoutInflater.from(this).inflate(
				R.layout.edit_date, null);
		Calendar calendar = Calendar.getInstance();
		calendar.get(Calendar.YEAR);
		dataUrodzenia.setText(calendar.get(Calendar.YEAR) + "-"
				+ calendar.get(Calendar.MONTH) + "-"
				+ calendar.get(Calendar.DAY_OF_MONTH));

		dataUrodzenia.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				OnDateSetListener onDateSetListener = new OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int year,
							int monthOfYear, int dayOfMonth) {
						dataUrodzenia.setText(year + "-" + (monthOfYear + 1)
								+ "-" + dayOfMonth);
					}
				};

				Dialog dialog = new DatePickerDialog(thisActivity,
						onDateSetListener, 1990, 9, 21);
				dialog.show();

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_add, container,
					false);
			return rootView;
		}
	}

}
