package com.st.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



public class AccessInterceptor implements HandlerInterceptor {

	
	//����ִ����ʱִ��
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	//������ͼʱ���ø÷���
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	/**
	 * ��Ҫ�����ص�����Contollerִ��֮ǰ, ִ�и÷���
	 * 
	 * ���÷�������falseʱ, ��������, 
	 * ���÷�������trueʱ, �������.
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		//1.ȡ����ǰ����ĵ�ַ   *.action
		String url = request.getRequestURI();
		//     /RBAC/access/view/insertProduct.action
		url = url.substring(url.indexOf("access/"));
		//2.��ѯȨ�޵�ƥ��
		HttpSession session = request.getSession();
		Map<String, String> accesses = (Map<String, String>) session.getAttribute("access");
		
		
		
		//3.�����Ȩ�޷���
		//���û��Ȩ����ת��һ����ʾҳ��
		
		String urlname = accesses.get(url);
		
		if (urlname == null) {
			//û��Ȩ��
			response.sendRedirect("../../accesserror.jsp");
			return false;
		}else {
			//��Ȩ��
			
		}
		
		/*HttpSession session = request.getSession();
		Staff staff =  (Staff) session.getAttribute("staff");
		
		//�û��ѵ�¼
		if (staff!=null) {
			//����
			return true;
		}else {
			//Ա��δ��¼
			//��ת��¼ҳ��  ���ض���
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}*/
		
		return true;
	}

	
}