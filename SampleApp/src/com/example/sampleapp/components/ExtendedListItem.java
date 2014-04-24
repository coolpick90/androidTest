package com.example.sampleapp.components;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExtendedListItem extends LinearLayout {

	private LinearLayout leftLayout;
	private LinearLayout rightLayout;
	private TextView bigText;
	private TextView smallText;
	private TextView rightText;

	public ExtendedListItem(Context context) {
		super(context);
		leftLayout = new LinearLayout(context);
		leftLayout.setOrientation(LinearLayout.VERTICAL);
		leftLayout.setLayoutParams(new LinearLayout.LayoutParams(700, LayoutParams.WRAP_CONTENT));
		leftLayout.setPadding(30, 30, 0, 30);
		rightLayout = new LinearLayout(context);
		rightLayout.setOrientation(LinearLayout.VERTICAL);
		rightLayout.setLayoutParams(new LinearLayout.LayoutParams(300, LayoutParams.MATCH_PARENT));
		bigText = new TextView(context);
		smallText = new TextView(context);
		bigText.setTextSize(TypedValue.COMPLEX_UNIT_PX, 100);
		smallText.setTextSize(TypedValue.COMPLEX_UNIT_PX, 50);
		leftLayout.addView(bigText);
		leftLayout.addView(smallText);
		addView(leftLayout);
		addView(rightLayout);
		rightText = new TextView(context);
		rightText.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
		rightLayout.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
		rightLayout.addView(rightText);

	}
	
	public void setBigText(String text) {
		bigText.setText(text);
	}
	
	public void setSmallText(String text) {
		smallText.setText(text);
	}
	
	public void setRightText(Long age) {
		rightText.setText("Wiek: " + age + " lat");
	}
}
