package com.example.sampleapp.configuration;

import java.lang.reflect.InvocationTargetException;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sampleapp.components.ExtendedListItem;

public class GeneratedListView<T> {

	private ListView listView;
	private Context context;

	public GeneratedListView(Context context) {
		this.context = context;
	}
	
	public void generate(T[] elements) {
		listView = new ListView(context);
		GeneratedListAdapter adapter = new GeneratedListAdapter(context, elements);
		listView.setAdapter(adapter);
	}

	public ListView getListView() {
		return listView;
	}
	
	class GeneratedListAdapter extends ArrayAdapter<T> {
		
		private Context context;
		private T[] values;

		public GeneratedListAdapter(Context context, T[] values) {
			super(context, -1, values);
			this.context = context;
			this.values = values;
		}
		
		public View getView(int position, View convertView, ViewGroup parent) {
			T elem = values[position];
			ExtendedListItem eli = new ExtendedListItem(context);
			try {
				eli.setBigText((String) elem.getClass().getMethod("getNazwisko").invoke(elem));
				eli.setSmallText((String) elem.getClass().getMethod("getImie").invoke(elem));
				eli.setRightText((Long) elem.getClass().getMethod("getWiek").invoke(elem));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return eli;
		}
	}
}
