package com.cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.biz.TblNewPswBiz;
import com.cn.biz.TblUsersBiz;
import com.cn.biz.impl.TblNewPswBizImpl;
import com.cn.biz.impl.TblUsersBizImpl;
import com.cn.entity.TblTeacher;

public class Teacher_SetNewPasswordServlet extends HttpServlet {

	private TblNewPswBiz tblNewPswBiz = new TblNewPswBizImpl();
	private TblUsersBiz tblUsersBiz = new TblUsersBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String errMsg = "";
		
		HttpSession session =request.getSession();
		TblTeacher oldtblteacher = ((TblTeacher) session.getAttribute("tuser"));
		TblTeacher newtblteacher = new TblTeacher();
		newtblteacher.setTeacherID(oldtblteacher.getTeacherID());
		newtblteacher.setTeacherName(oldtblteacher.getTeacherName());
		
		boolean i = false;
		String op = tblNewPswBiz.checkpswTea(oldtblteacher).getOldPassword();
		
		String oldPassword =  request.getParameter("oldPassword");
		if (oldPassword == null || "".equals(oldPassword)){
			errMsg = errMsg + "�����벻��Ϊ��<br/>";
		}else{
			if(oldPassword.equals(op)){
				i = true;
				newtblteacher.setOldPassword(oldPassword);
			}else{
				errMsg = errMsg + "�����벻��ȷ<br/>";
			}
		}
		
		String newPassword =  request.getParameter("newPassword");
		if (newPassword == null || "".equals(newPassword)){
			errMsg = errMsg + "�����벻��Ϊ��<br/>";
		}else{
			newtblteacher.settPassword(newPassword);
		}
		
		String rePassword =  request.getParameter("rePassword");
		if (rePassword == null || "".equals(rePassword)){
			errMsg = errMsg + "��ȷ������<br/>";
		}else{
			if(newPassword.equals(rePassword)){
			}else{
				errMsg = errMsg + "ȷ�����벻һ��<br/>";
			}
		}
		
		
		if("".equals(errMsg)){
			if(i){
				boolean flag = tblNewPswBiz.newpswTea(newtblteacher);
				if(flag){
					request.setAttribute("errMsg", "�޸�����ɹ������µ�¼");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}else{
					request.setAttribute("errMsg", "�޸�ʧ��");
					request.getRequestDispatcher("teacher_SetNewPasaword.jsp").forward(request, response);
				}
			}
		}else{
			request.setAttribute("errMsg", errMsg);
			request.getRequestDispatcher("teacher_SetNewPasaword.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
