package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
/**
 * Servlet implementation class TmpDb
 */
@WebServlet("/TmpDb")
public class TmpDb extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//�����R�[�h�ϊ�
		response.setContentType("text/html; charset=Shift-JIS");

		//getParameter�œ��͂��擾�H
		request.setCharacterEncoding("Shift-JIS");
//        System.out.println("id: " + request.getParameter("id"));
//        System.out.println("name: " + request.getParameter("name"));
//        System.out.println("code: " + request.getParameter("code"));

        String osi_id = request.getParameter("id");
        String osi_name = request.getParameter("name");
        String osi_code = request.getParameter("code");

      System.out.println("id: " + osi_id);
      System.out.println("name: " + osi_name);
      System.out.println("code: " + osi_code);

        // -- ��������DB�֕ۑ����� --

     // �f�[�^�\�[�X���̎擾
     		Context context = null;
     		DataSource ds = null;
     		try {
     			context = new InitialContext();
     			ds = (DataSource) context.lookup("java:/comp/env/jdbc/pos");
     		} catch (NamingException e) {
     			e.printStackTrace();
     			response.getWriter().append(e.toString());
     			return;
     		}

     	try {


     			// �R�l�N�V�����擾
     			Connection conn = ds.getConnection();

     			// �X�e�[�g�����g�̍쐬
     			Statement stmt = conn.createStatement();

     			// SQL�̎��s

     			//ResultSet sql = stmt.executeUpdate("insert into osi2_table values (44,'��','sssss')");
     			//			ResultSet rs = stmt.executeQuery("select * from osi2_table");

     			//String sql = ("insert into osi2_table values (" +  osi_id + "," +"'" + osi_name + "'," + "'"+ osi_code +"'"+");");
     			//System.out.println(sql);
   		       //int num = stmt.executeUpdate(sql);

     		      String sql = "select * from osi2_table";
     		      ResultSet rs = stmt.executeQuery(sql);



//     		     request.setAttribute("fromServlet", rs);
//      			RequestDispatcher dispatch = request.getRequestDispatcher("../Complete.jsp");
//      			dispatch.forward(request, response);




     			// �f�[�^�擾�A�o��
     			while (rs.next()) {

     				rs.getString(1);
					rs.getString(2);
					rs.getString(3);

     				//�@StringBuilder�N���X���g����������̒ǉ������o�͂̏ꍇ
     				//���Ώە�����.append(�ǉ��Ώ� )��
//     				response.getWriter().append(rs.getString("id"));
//     				response.getWriter().append(rs.getString("name"));
//     				response.getWriter().append(rs.getString("code"));

     				//�A��L�g�킸HTML�����ŏo�͂̏ꍇ
     				PrintWriter rw = response.getWriter();
     				rw.println("<P>-----------------------------------------</P>");
     				rw.println("<P> ID = " + rs.getString(1) + "</P>" );
     				rw.println("<P>NAME =" + rs.getString(2) + "</P>" );
     				rw.println("<P>PASS =" + rs.getString(3) +"</P>");
     				rw.println("<P>-----------------------------------------</P>");

     				response.getWriter().append("<BR>");
     			}


     			rs.close();
     			stmt.close();

     		} catch (Exception e) {
     			e.printStackTrace();
     		}
     	}
	//�����܂�DB����



}
