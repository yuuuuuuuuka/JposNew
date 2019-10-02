package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Bean.TopBean;

/**
 * Servlet implementation class SampleClass
 */
@WebServlet("/Sumple")
public class Sumple extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Sumple() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

		//Bean�N���X��DB�̒l���Z�b�g����H
		//TopBean topBean = new TopBean();//�C���X�^���X
		//Bean��set���\�b�h
		//		topBean.setOsi2_id();
		//
		//		request.setAttribute("topBean", topBean);
		//
		//		getServletContext().getRequestDispatcher("/Complete.jsp")
		//				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//		doGet(request, response);

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

			// DB�f�[�^�擾
			while (rs.next()) {

				//Bean�C���X�^���X����
				TopBean topBean = new TopBean();
				topBean.osi2_id = rs.getInt(1);
				topBean.osi2_name = rs.getString(2);
				topBean.osi2_code = rs.getString(3);

				request.setCharacterEncoding("Shift_JIS");

				request.setAttribute("fromServlet", topBean.osi2_id);
				request.setAttribute("fromServletn", topBean.osi2_name);
				request.setAttribute("fromServletc", topBean.osi2_code);


				//�@StringBuilder�N���X���g����������̒ǉ������o�͂̏ꍇ
				//���Ώە�����.append(�ǉ��Ώ� )��
				//	     				response.getWriter().append(rs.getString("id"));
				//	     				response.getWriter().append(rs.getString("name"));
				//	     				response.getWriter().append(rs.getString("code"));

				//�A��L�g�킸HTML�����ŏo�͂̏ꍇ
				//PrintWriter rw = response.getWriter();
				//				rw.println("<P> ID = " + rs.getString(1) + "</P>");
				//				rw.println("<P>NAME =" + rs.getString(2) + "</P>");
				//				rw.println("<P>PASS =" + rs.getString(3) + "</P>");

				//	     				response.getWriter().append("<BR>");
			}

			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		//jsp�֑J��
		//request.setCharacterEncoding("Shift_JIS");
		//		String osi2_id = request.getParameter("osi2_id");
		//		String osi2_name = request.getParameter("osi2_name");
		//		String osi2_code = request.getParameter("osi2_code");

		//		request.setAttribute("fromServlet", osi2_id);
		//		request.setAttribute("fromServletn", osi2_name);
		//		request.setAttribute("fromServletc", osi2_code);
		RequestDispatcher dispatch = request.getRequestDispatcher("./Complete.jsp");
		dispatch.forward(request, response);

	}
	//�����܂�DB����

}
