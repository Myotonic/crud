package com.crud.estimateService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface EstimateService {
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
