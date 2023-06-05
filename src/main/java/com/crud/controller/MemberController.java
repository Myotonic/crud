package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crud.service.AjaxMarketRead;
import com.crud.service.AnswerCreate;
import com.crud.service.ClassUpdate;
import com.crud.service.FaqDelete;
import com.crud.service.FaqUpdate;
import com.crud.service.ImgDelete;
import com.crud.service.ImgUpdate;
import com.crud.service.InquiryDelete;
import com.crud.service.InquiryDetail;
import com.crud.service.InquiryRead;
import com.crud.service.InquiryUpdate;
import com.crud.service.MArea;
import com.crud.service.MCategory;
import com.crud.service.MCategory1;
import com.crud.service.MCategory2;
import com.crud.service.MCity;
import com.crud.service.MEditName;
import com.crud.service.MEditPass;
import com.crud.service.MExpertJoin;
import com.crud.service.MLogin;
import com.crud.service.MLogout;
import com.crud.service.MRange;
import com.crud.service.MUserJoin;
import com.crud.service.MarketBuy;
import com.crud.service.MarketCreate;
import com.crud.service.MarketDelete;
import com.crud.service.MarketDetail;
import com.crud.service.MarketInquiry;
import com.crud.service.MarketRead;
import com.crud.service.MarketService;
import com.crud.service.MarketUpdate;
import com.crud.service.MemberDrop;
import com.crud.service.MemberService;
import com.crud.service.MemberValue;
import com.crud.service.MyPageMarket;
import com.crud.service.TimeDelete;
import com.crud.service.TimeUpdate;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.crud")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		action(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action(request, response);
	}
	protected void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String path = request.getServletPath();
		MemberService service = null;
		MarketService marketService =null;
		//마켓뷰
		if(path.equals("/marketView.crud")) {
			marketService = new MarketRead(); marketService.exec(request, response);
			request.getRequestDispatcher("/market/marketView.jsp").forward(request, response);
		}
		//마켓 아작스
		else if(path.equals("/ajaxMarketRead.crud")) {
			marketService = new AjaxMarketRead(); marketService.exec(request, response);
		}
		//마켓 클릭시 디테일
		else if(path.equals("/marketDetail.crud")) {
			marketService = new MarketDetail(); marketService.exec(request, response);
			request.getRequestDispatcher("/market/marketDetail.jsp").forward(request, response);
		}
		//구입버튼 누르면 구입폼으로
		else if(path.equals("/marketBuyForm.crud")) {
			request.getRequestDispatcher("marketBuyFrom.jsp").forward(request, response);
		}
		//구입상세페이지에서 구입하면 db에 등록
		else if(path.equals("/marketBuy.crud")) {
			marketService = new MarketBuy(); marketService.exec(request, response);
			out.print("<script>location.href='"+request.getContextPath()+"/';</script>");
		}
		//마켓 디테일 페이지에서 문의버튼(문의폼 모달) 누르고 문의 작성후 등록
		else if(path.equals("/marketInquiry.crud")) {
			marketService = new MarketInquiry(); marketService.exec(request, response);
			out.print("<script>location.href='"+request.getContextPath()+"/';</script>");
		}
		//마켓 생성 폼
		else if (path.equals("/marketCreateForm.crud")) {
		    String mDivision = request.getParameter("mDivision");
		    if (mDivision != null && mDivision.equals("상품")) {
		    	request.setAttribute("division", mDivision);
		    	request.getRequestDispatcher("/market/marketCreateFrom.jsp").forward(request, response);
		    } else {
		    	request.setAttribute("division", mDivision);
		    	request.getRequestDispatcher("/market/classCreateFrom.jsp").forward(request, response);
		    }
		}
		//마켓 생성
		else if(path.equals("/marketCreate.crud")) {
			marketService = new MarketCreate(); marketService.exec(request, response);
			out.print("<script>location.href='"+request.getContextPath()+"/marketView.crud';</script>");
		}
		//나의 마켓 확인
		else if(path.equals("/myPageMarket.crud")) {
			marketService = new MyPageMarket(); marketService.exec(request, response);
			request.getRequestDispatcher("myPageMarket.jsp").forward(request, response);
		}
		//마켓 수정 폼
		else if(path.equals("/marketUpdateForm.crud")) {
			request.getRequestDispatcher("marketUpdateForm.jsp").forward(request, response);
		}
		//마켓 수정
		else if(path.equals("/marketUpdate.crud")) {
			marketService = new MarketUpdate(); marketService.exec(request, response);
			out.print("<script>location.href='"+request.getContextPath()+"/';</script>");
		}
		//상세 수정 faq
		else if(path.equals("/faqUpdate.crud")) {
			marketService = new FaqUpdate(); marketService.exec(request, response);
			out.print("<script>location.href='"+request.getContextPath()+"/';</script>");
		}
		//상세 수정 img
		else if(path.equals("/imgUpdate.crud")) {
			marketService = new ImgUpdate(); marketService.exec(request, response);
			out.print("<script>location.href='"+request.getContextPath()+"/';</script>");
		}
		//상세 수정 class
		else if(path.equals("/classUpdate.crud")) {
			marketService = new ClassUpdate(); marketService.exec(request, response);
			out.print("<script>location.href='"+request.getContextPath()+"/';</script>");
		}
		//상세 수정 time
		else if(path.equals("/timeUpdate.crud")) {
			marketService = new TimeUpdate(); marketService.exec(request, response);
			out.print("<script>location.href='"+request.getContextPath()+"/';</script>");
		}
		
		//마켓 삭제
		else if(path.equals("/marketDelete.crud")) {
			marketService = new MarketDelete(); marketService.exec(request, response);
			out.print("<script>location.href='"+request.getContextPath()+"/';</script>");
		}
		//상세 삭제 faq
		else if(path.equals("/faqDelete.crud")) {
			marketService = new FaqDelete(); marketService.exec(request, response);
			out.print("<script>location.href='"+request.getContextPath()+"/';</script>");
		}
		//상세 삭제 img
		else if(path.equals("/imgDelete.crud")) {
			marketService = new ImgDelete(); marketService.exec(request, response);
			out.print("<script>location.href='"+request.getContextPath()+"/';</script>");
		}
		//상세 삭제 time
		else if(path.equals("/timeDelete.crud")) {
			marketService = new TimeDelete(); marketService.exec(request, response);
			out.print("<script>location.href='"+request.getContextPath()+"/';</script>");
		}
		//나의 문의 확인
		else if(path.equals("/inquiryView.crud")) {
			marketService = new InquiryRead(); marketService.exec(request, response);
			request.getRequestDispatcher("/inquiryView.jsp").forward(request, response);
		}
		//문의 디테일
		else if(path.equals("/inquiryDetail.crud")) {
			marketService = new InquiryDetail(); marketService.exec(request, response);
			request.getRequestDispatcher("/inquiryDetail.jsp").forward(request, response);
		}
		//문의 수정 폼
		else if(path.equals("/inquiryUpdateForm.crud")) {
			request.getRequestDispatcher("inquiryUpdateForm.jsp").forward(request, response);
		}
		//문의 수정
		else if(path.equals("/inquiryUpdate.crud")) {
			marketService = new InquiryUpdate(); marketService.exec(request, response);
			out.print("<script>location.href='"+request.getContextPath()+"/';</script>");
		}
		//문의 삭제
		else if(path.equals("/inquiryDelete.crud")) {
			marketService = new InquiryDelete(); marketService.exec(request, response);
			out.print("<script>location.href='"+request.getContextPath()+"/';</script>");
		}
		//전문가 문의확인, 답변달수있는 폼같이
		else if(path.equals("/inquiryView.crud")) {
			marketService = new InquiryRead(); marketService.exec(request, response);
			request.getRequestDispatcher("/inquiryExpertAnswer.jsp").forward(request, response);
		}
		//전문가 답변 엑션
		else if(path.equals("/answerCreate.crud")) {
			marketService = new AnswerCreate(); marketService.exec(request, response);
			out.print("<script>location.href='"+request.getContextPath()+"/';</script>");
		}
		
		if(path.equals("/main.crud")) {
			request.getRequestDispatcher("/member/main.jsp").forward(request, response);
		}else if(path.equals("/user_joinV.crud")) {
			request.getRequestDispatcher("/member/user_join.jsp").forward(request, response);
		}else if(path.equals("/user_join.crud")) {
			service = new MUserJoin();
			service.exec(request, response);
			out.println("<script>location.href='"+request.getContextPath()+"/member/main.jsp';</script>");
		}else if(path.equals("/expert_joinC1.crud")) {
			service = new MCategory1();
			service.exec(request, response);
			request.getRequestDispatcher("/member/expert_join001.jsp").forward(request, response);
		}else if(path.equals("/expert_joinC2.crud")) {
			service = new MCategory2();
			service.exec(request, response);
			request.getRequestDispatcher("/member/expert_join002.jsp").forward(request, response);
		}else if(path.equals("/expert_joinC.crud")) {
			service = new MCategory();
			service.exec(request, response);
			request.getRequestDispatcher("/member/expert_join003.jsp").forward(request, response);
		}else if(path.equals("/expert_joinArea.crud")) {
			service = new MArea();
			service.exec(request, response);
//			request.getRequestDispatcher(request.getContextPath()+"/expert_joinCity.crud").forward(request, response);
			request.getRequestDispatcher("/expert_joinCity.crud").forward(request, response);
		}else if(path.equals("/expert_joinCity.crud")) {
			service = new MCity();
			service.exec(request, response);
			request.getRequestDispatcher("/member/expert_join004.jsp").forward(request, response);
		}else if(path.equals("/expert_joinRange.crud")) {
			service = new MRange();
			service.exec(request, response);
			
			HttpSession session = request.getSession(false); // 세션이 존재하는 경우에만 세션을 반환
			if (session != null && session.getAttribute("member") != null) {	//member 세션 값이 있다면
				request.getRequestDispatcher("/member/expert_upgrade.jsp").forward(request, response);
			}else{	//member 세션 값이 없다면
				request.getRequestDispatcher("/member/expert_join005.jsp").forward(request, response);
			}
		}else if(path.equals("/expert_join.crud")) {
			service = new MExpertJoin();
			service.exec(request, response);
			out.println("<script>location.href='"+request.getContextPath()+"/member/main.jsp';</script>");
		}else if(path.equals("/login.crud")) {
			service = new MLogin();
			service.exec(request, response);
			out.println("<script>location.href='"+request.getContextPath()+"/member/main.jsp';</script>");
			/* request.getRequestDispatcher("/member/main.jsp").forward(request, response); */
		}else if(path.equals("/MemberValue.crud")) {
			service = new MemberValue();
			service.exec(request, response);
			request.getRequestDispatcher("/member/main.jsp").forward(request, response);
		}else if(path.equals("/MyPage.crud")) {
			String memberValue = (String) request.getSession().getAttribute("memberValue");
			if (memberValue != null) {
			    if (memberValue.equals("expert")) {
			        request.getRequestDispatcher("/member/expert_mypage.jsp").forward(request, response);
			    } else if (memberValue.equals("user")) {
			        request.getRequestDispatcher("/member/user_mypage.jsp").forward(request, response);
			    } else {
			        request.getSession().invalidate();
			        out.println("<script>alert('잘못된 회원 유형입니다'); "
			                + "location.href='" + request.getContextPath() + "/loginV'; </script>");
			    }
			} else {
			    request.getSession().invalidate();
			    out.println("<script>alert('로그아웃 되었습니다'); "
			            + "location.href='" + request.getContextPath() + "/loginV'; </script>");
			}
		}else if(path.equals("/loginV.crud")) {
			request.getRequestDispatcher("/member/login.jsp").forward(request, response);
		}else if(path.equals("/logout.crud")) {
			service = new MLogout();
			service.exec(request, response);
			out.println("<script>location.href='"+request.getContextPath()+"/member/main.jsp';</script>");
		}else if(path.equals("/AccountSetting.crud")) {
			request.getRequestDispatcher("/member/account.jsp").forward(request, response);
		}else if(path.equals("/editNameV.crud")) {
			request.getRequestDispatcher("/member/account_editName.jsp").forward(request, response);
		}else if(path.equals("/editName.crud")) {
			service = new MEditName();
			service.exec(request, response);
			out.println("<script>location.href='"+request.getContextPath()+"/member/account.jsp';</script>");
		}else if(path.equals("/editPassV.crud")) {
			request.getRequestDispatcher("/member/account_editPass.jsp").forward(request, response);
		}else if(path.equals("/editPasss.crud")) {
			service = new MEditPass();
			service.exec(request, response);
			out.println("<script>location.href='"+request.getContextPath()+"/member/account.jsp';</script>");
		}else if(path.equals("/AccountDropV.crud")) {
			request.getRequestDispatcher("/member/account_drop.jsp").forward(request, response);
		}else if(path.equals("/AccountDrop.crud")) {
			service = new MemberDrop();
			service.exec(request, response);
			out.println("<script>location.href='"+request.getContextPath()+"/member/main.jsp';</script>");
		}
	}

}
