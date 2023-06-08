package com.crud.front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.service.AAction;
import com.crud.service.ACategory;
import com.crud.service.ADupl;
import com.crud.service.AFindId;
import com.crud.service.AJoin;
import com.crud.service.ALogin;
import com.crud.service.AMail;
import com.crud.service.AMailCheck;
import com.crud.service.AMarketDelete;
import com.crud.service.AMarketDetail;
import com.crud.service.AMarketEdit;
import com.crud.service.AMarketEditView;
import com.crud.service.AMarketList;
import com.crud.service.AResult;
import com.crud.service.AUserDelete;
import com.crud.service.AUserDetail;
import com.crud.service.AUserEdit;
import com.crud.service.AUserEditView;
import com.crud.service.AUserList;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("*.admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		adminDo(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		adminDo(request, response);
	}

	
	protected void adminDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String path = request.getServletPath();
		
		
		AAction service = null;
		
		
		
		
		if(path.equals("/home.admin")) {
			
			
			
			request.getRequestDispatcher("/admin/admin_login.jsp").forward(request, response);
			
			
		}
		
		
		else if(path.equals("/login.admin")) {
			
			service = new ALogin();
			
			service.exec(request, response);
			
			
						
			
			
			
			/*
			 * 로그인을 하면 result.admin으로 가서 던진 값중에 이메일을 세션으로 저장해서 result에서 한번 더 db를 타고 뿌려줌.
			 * 
			 * 
			 */
			
		}
		

		
		
		
		
		else if(path.equals("/join_form.admin")) {
			
			
			request.getRequestDispatcher("/admin/admin_join.jsp").forward(request, response);
			
			
			
		}
		
		else if(path.equals("/logout.admin")) {
			
			request.getSession().invalidate();
			
			request.getRequestDispatcher("/admin/admin_login.jsp").forward(request, response);
			
			
			
		}
		
		
		else if(path.equals("/login_id_form.admin")) {
			
			
			request.getRequestDispatcher("/admin/login_id.jsp").forward(request, response);
			
			
			
		}
		
		else if(path.equals("/id.admin")) {
			
			
			service = new ADupl();
			
			service.exec(request, response);
			
			
		}
		
		else if(path.equals("/login_id.admin")) {
			
			service = new AFindId();
			
			service.exec(request, response);
			
			
			
		}
		
		
		else if(path.equals("/login_find_id.admin")) {
			
			service = new AFindId();
			
			service.exec(request, response);
			
			
			
		}
		
		
		else if(path.equals("/login_pass_form.admin")) {
			
			
			request.getRequestDispatcher("/admin/login_pass.jsp").forward(request, response);
			
			
			
		}
		
		else if(path.equals("/join.admin")) {
			
			service = new AJoin();
			
			service.exec(request, response);
			
			
			request.getRequestDispatcher("/result.admin").forward(request, response);
			
			
		}
		else if(path.equals("/result.admin")) {
			
			service = new AResult();
			
			service.exec(request, response);
			
			
			
			
			request.getRequestDispatcher("/admin/admin_result.jsp").forward(request, response);
			
		}
		
		else if(path.equals("/userlist.admin")) {
			
			service = new AUserList();
			
			service.exec(request, response);
			
			request.getRequestDispatcher("/admin/admin_user.jsp").forward(request, response);
			
		
		
		}
		
		else if(path.equals("/userdetail.admin")) {
			
			service = new AUserDetail();
			
			service.exec(request, response);
			
			request.getRequestDispatcher("/admin/admin_user_detail.jsp").forward(request, response);
			
		
		
		}
		else if(path.equals("/useredit_form.admin")) {
			
			service = new AUserEditView();
			
			service.exec(request, response);
			
			request.getRequestDispatcher("/admin/admin_user_edit.jsp").forward(request, response);
			
		
		
		}
		
		else if(path.equals("/useredit.admin")) {
			
			service = new AUserEdit();
			
			service.exec(request, response);
			
			request.getRequestDispatcher("/userdetail.admin").forward(request, response);
			
		
		
		}
		
		else if(path.equals("/useredelete.admin")) {
			
			service = new AUserDelete();
			
			service.exec(request, response);
			
			request.getRequestDispatcher("/userlist.admin").forward(request, response);
			
		
		
		}
		
		else if(path.equals("/category.admin")) {
			
			service = new ACategory();
			
			service.exec(request, response);
			
			
			
		
		
		}
		else if(path.equals("/marketlist.admin")) {
			
			service = new AMarketList();
			
			service.exec(request, response);
			
			
			request.getRequestDispatcher("/admin/admin_market.jsp").forward(request, response);
		
		
		}
		
		else if(path.equals("/marketdetail.admin")) {
			
			service = new AMarketDetail();
			
			service.exec(request, response);
			
			
			request.getRequestDispatcher("/admin/admin_market_detail.jsp").forward(request, response);
		
		
		}
		else if(path.equals("/marketedit_form.admin")) {
			
			service = new AMarketEditView();
			
			service.exec(request, response);
			
			
			request.getRequestDispatcher("/admin/admin_market_edit.jsp").forward(request, response);
		
		
		}		
		
		else if(path.equals("/marketedit.admin")) {
			
			service = new AMarketEdit();
			
			service.exec(request, response);
			
			
			request.getRequestDispatcher("/marketdetail.admin").forward(request, response);
		
		
		}		
		
		
		else if(path.equals("/marketdelete.admin")) {
			
			service = new AMarketDelete();
			
			
			service.exec(request, response);
			
			
			request.getRequestDispatcher("/marketlist.admin").forward(request, response);
		
		
		}	
		
		
		else if(path.equals("/mailcheck.admin")) {
			
			service = new AMailCheck();
			
			
			service.exec(request, response);
			
			
			
		
		
		}		
		else if(path.equals("/mail_form.admin")) {
			
			
			
			
			request.getRequestDispatcher("/admin/admin_mail.jsp").forward(request, response);
			
		
		
		}	
		
		else if(path.equals("/pass_form.admin")) {
			
			
			
			
			request.getRequestDispatcher("/admin/admin_new_pass.jsp").forward(request, response);
			
		
		
		}	
		
		else if(path.equals("/pass.admin")) {
			
			
			service = new AMail();
			
			service.exec(request, response);
			
			
			
			out.println("<script>location.href='home.admin';</script>");
			
			
			
			
		
		
		}	
		
		
		
	}

	
}
