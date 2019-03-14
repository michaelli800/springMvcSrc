package com.lginfor.common.http;


import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@WebListener
public class LogSessionListener implements HttpSessionListener {

	private final AtomicLong sessionCount = new AtomicLong();

	private static final Logger logger = LoggerFactory.getLogger(LogSessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent se) {

		int timeout = 10;
		long count = sessionCount.incrementAndGet();
		String infor = se.getSession().getId() + "sessionCreated - add one session into counter" + count;
		boolean needSet = false;
		if (needSet) {
			se.getSession().setMaxInactiveInterval(timeout);
		}
		System.out.println(infor);
		logger.error(infor);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
				
		long count = sessionCount.decrementAndGet();
		String infor = se.getSession().getId() + "sessionDestroyed - deduct one session from counter" + count;
		
		System.out.println(infor);
		logger.error(infor);
	}

}
