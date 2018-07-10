package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.biz.TblCourseBiz;
import com.cn.biz.impl.TblCourseBizImpl;
import com.cn.util.PageBean;

public class Admin_CourselistServlet extends HttpServlet {

	private TblCourseBiz tblCourseBiz = new TblCourseBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String sPageNum = request.getParameter("pageNum");
		int pageNum = 1;
		
		try {
			pageNum = Integer.parseInt(sPageNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageBean pageBean = tblCourseBiz.CourseViewByPageFun(pageNum, 10);
		
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("admin_CourseList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}