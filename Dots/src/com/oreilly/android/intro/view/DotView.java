package com.oreilly.android.intro.view;

import com.oreilly.android.intro.model.Dots;

import android.content.Context;
import android.view.View;

public class DotView extends View {
	private final Dots dots;
	
	public DotView(Context context, Dots dots) {
		super(context);
		this.dots = dots;
		setMinimumWidth(180);
		setMinimumHeight(200);
		setFocusable(true);

	}
}
