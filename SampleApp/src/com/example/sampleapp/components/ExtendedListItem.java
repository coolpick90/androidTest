package com.example.sampleapp.components;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ExtendedListItem extends RelativeLayout {

	private TextView bigText;
	private TextView smallText;
	private TextView rightText;

	public ExtendedListItem(Context context) {
		super(context);
		setPadding(30, 30, 30, 30);
		bigText = new TextView(context);
		smallText = new TextView(context);
		rightText = new TextView(context);
		bigText.setTextSize(TypedValue.COMPLEX_UNIT_PX, 100);
		smallText.setTextSize(TypedValue.COMPLEX_UNIT_PX, 50);
		rightText.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);

		RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
		RelativeLayout.LayoutParams q = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
		RelativeLayout.LayoutParams r = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

		bigText.setId(View.generateViewId());
		smallText.setId(View.generateViewId());
		rightText.setId(View.generateViewId());
		
		q.addRule(RelativeLayout.BELOW, this.getId());
		bigText.setLayoutParams(q);
        addView(bigText);
        
        p.addRule(RelativeLayout.BELOW, bigText.getId());
		smallText.setLayoutParams(p);
        addView(smallText);
        
        r.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, bigText.getId());
		rightText.setLayoutParams(r);
        addView(rightText);
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
