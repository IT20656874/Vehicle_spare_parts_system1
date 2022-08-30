package paymentManagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbPayment.PaymentDb;
import paymentDetails.Payment;

@WebServlet("/PaymentManagement")
public class PaymentManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public PaymentManagement() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	Payment p=new Payment();
	PaymentDb pd=new PaymentDb();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("submit")!=null) {
			p.setName(request.getParameter("name"));
			p.setId(request.getParameter("id"));
			p.setAmount(request.getParameter("amount"));		
			p.setCardNo(request.getParameter("cardno"));
			p.setCsv(request.getParameter("csv"));
			p.setExpdate(request.getParameter("exdate"));
			
			pd.insertPayment(p);
			response.sendRedirect("pendingPayment.jsp");
			
		}
		else if(request.getParameter("edit")!=null) {
			String ids =request.getParameter("pid");
			
			request.setAttribute("pid",ids);
			request.getRequestDispatcher("editPayment.jsp").forward(request,response);
			
		}
		else if(request.getParameter("update")!=null) {
			p.setName(request.getParameter("name"));
			p.setId(request.getParameter("pid"));
			p.setAmount(request.getParameter("amount"));		
			p.setCardNo(request.getParameter("cardno"));
			p.setCsv(request.getParameter("csv"));
			p.setExpdate(request.getParameter("exdate"));
			
			
			pd.updatePayment(p);
			response.sendRedirect("pendingPayment.jsp");
			
		}
		else if(request.getParameter("delete")!=null) {
			String pid=request.getParameter("pid");
			pd.deletePayment(pid);
			response.sendRedirect("pendingPayment.jsp");
			
		}
		else if(request.getParameter("pay")!=null) {
			String pid=request.getParameter("pid");
			pd.updatePaymentStatus(pid);
			response.sendRedirect("paiPayment.jsp");
			
		}
	}

}
