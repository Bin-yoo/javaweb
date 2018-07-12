package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.biz.TblAddBiz;
import com.cn.biz.impl.TblAddBizImpl;
import com.cn.entity.TblCourse;
import com.cn.entity.TblStudent;

public class Admin_AddCourseServlet extends HttpServlet {

	private TblAddBiz tblAddBiz = new TblAddBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		TblCourse tblCourse = new TblCourse();
		
		String errMsg = "";
		
		String courseName = request.getParameter("courseName");
		if (courseName == null || "".equals(courseName)){
			errMsg = errMsg + "�γ����Ʋ���Ϊ��<br/>";
		}else{
			tblCourse.setCourseName(courseName);
		}
		
		String sTeacherId = request.getParameter("teacherId");
		try {
			if (sTeacherId == null || "".equals(sTeacherId)){
				errMsg = errMsg + "��ʦ��Ų���Ϊ��<br/>";
			}else{
				Integer teacherId = Integer.parseInt(sTeacherId);
				tblCourse.setTeacherID(teacherId);
			}
		} catch (Exception e) {
			errMsg = errMsg + "��ʦ��ű�����������<br/>";
			e.printStackTrace();
		}
			
		String courseTime = request.getParameter("courseTime"); 									
		if (courseTime == null || "".equals(courseTime)){
			errMsg = errMsg + "�Ͽ�ʱ�䲻��Ϊ��<br/>";
		}else{
			tblCourse.setCourseTime(courseTime);
		}
		
		String sCourseBegin = request.getParameter("courseBegin");
		try {
			if (sCourseBegin == null || "".equals(sCourseBegin)){
				errMsg = errMsg + "����ʱ�䲻��Ϊ��<br/>";
			}else{
				Date courseBegin = Date.valueOf(sCourseBegin);
				tblCourse.setCourseBegin(courseBegin);
			}
		} catch (Exception e) {
			errMsg = errMsg + "����ʱ���������yyyy-MM-dd��ʽ<br/>";
			e.printStackTrace();
		}
		
		String classRoom = request.getParameter("classRoom");
		if (classRoom == null || "".equals(classRoom)){
			errMsg = errMsg + "�Ͽεص㲻��Ϊ��<br/>";
		}else{
			tblCourse.setCourseRoom(classRoom);
		}
		
		String sCourseWeek = request.getParameter("courseWeek");
		try {
			Integer courseWeek = Integer.valueOf(sCourseWeek);
			tblCourse.setCourseWeek(courseWeek);
		} catch (Exception e) {
			errMsg = errMsg + "��ʱ����Ϊ��<br/>";
			e.printStackTrace();
		}
		
		String courseType = request.getParameter("courseType");
		if (courseType == null || "".equals(courseType)){
		}else{
			tblCourse.setCourseType(courseType);
		}
		
		String sCollegeId = request.getParameter("collegeId");
		try {
			Integer collegeId = Integer.valueOf(sCollegeId);
			tblCourse.setCollegeID(collegeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sPoint = request.getParameter("point");
		try {
			if (sPoint == null || "".equals(sPoint)){
				errMsg = errMsg + "ѧ�ֲ���Ϊ��<br/>";
			}else{
				Integer point = Integer.parseInt(sPoint);
				tblCourse.setPoint(point);
			}
		} catch (Exception e) {
			errMsg = errMsg + "ѧ�ֱ�����������<br/>";
			e.printStackTrace();
		}
		
		if ("".equals(errMsg)){
			boolean flag = tblAddBiz.addCourse(tblCourse);
			if (flag){
				response.sendRedirect("admin_Courselist");
			}else{
				errMsg = errMsg + "����ʧ��<br/>";
				request.setAttribute("tblCourse", tblCourse);
				request.setAttribute("errMsg", errMsg);
				request.getRequestDispatcher("admin_AddCourse.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("tblCourse", tblCourse);
			request.setAttribute("errMsg", errMsg);
			request.getRequestDispatcher("admin_AddCourse.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
