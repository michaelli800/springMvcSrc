package com.dawninfotek.sample.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class LogHttpServletResponseWrapper extends HttpServletResponseWrapper {

    public LogHttpServletResponseWrapper(HttpServletResponse response) {
		super(response);
		// TODO Auto-generated constructor stub
	}

	private int httpStatus = 200;


    @Override
    public void sendError(int sc) throws IOException {
        httpStatus = sc;
        super.sendError(sc);
    }

    @Override
    public void sendError(int sc, String msg) throws IOException {
        httpStatus = sc;
        super.sendError(sc, msg);
    }


    @Override
    public void setStatus(int sc) {
        httpStatus = sc;
        super.setStatus(sc);
    }

    public int getStatus() {
        return httpStatus;
    }

}