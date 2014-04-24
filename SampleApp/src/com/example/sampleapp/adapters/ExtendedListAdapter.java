package com.example.sampleapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.sampleapp.components.ExtendedListItem;
import com.example.sampleapp.model.Contact;

public class ExtendedListAdapter extends ArrayAdapter<Contact> {
	
	private Context context;
	private Contact[] values;

	public ExtendedListAdapter(Context context, int resource, Contact[] values) {
		super(context, resource, values);
		this.context = context;
		this.values = values;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		Contact contact = values[position];
		ExtendedListItem eli = new ExtendedListItem(context);
		eli.setBigText(contact.getNazwisko());
		eli.setSmallText(contact.getImie());
		eli.setRightText(contact.getWiek());
		return eli;
	}
}
