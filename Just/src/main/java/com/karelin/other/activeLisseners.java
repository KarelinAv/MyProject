package com.karelin.other;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class activeLisseners implements HttpSessionListener {
	public static int count = 0;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		count++;

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		count--;

	}

}
