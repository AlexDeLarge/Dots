package com.oreilly.android.intro.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/** A list of dots. */
public class Dots {
	/** DotChangeListener. */
	public interface DotsChangeListener {
		/** @param dots the dots that changed. */
		void onDotsChange(Dots dots);
	}
	
	private final LinkedList<Dot> dots = new LinkedList<Dot>();
	private final List<Dot> safeDots = Collections.unmodifiableList(dots);
	private DotsChangeListener dotsChangeListener;
	
	/** @param l the new change listener. */
	public void setDotsChangeListener(DotsChangeListener l) {
	dotsChangeListener = l;
	}
	/** @return the most recently added dot, or null. */
	public Dot getLastDot() {
	return (dots.size() <= 0) ? null : dots.getLast();
	}
	/** @return the list of dots. */
	public List<Dot> getDots() { return safeDots; }
	/**
	* @param x dot horizontal coordinate.
	* @param y dot vertical coordinate.
	* @param color dot color.
	* @param diameter dot size.
	*/
	public void addDot(float x, float y, int color, int diameter) {
		dots.add(new Dot(x, y, color, diameter));
		notifyListener();
	}
	/** Delete all the dots. */
	public void clearDots() {
		dots.clear();
		notifyListener();
	}
	
	private void notifyListener() {
		if (null != dotsChangeListener) {
			dotsChangeListener.onDotsChange(this);
		}
	}
}
