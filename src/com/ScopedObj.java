package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScopedObj
 */
@WebServlet("/ScopedObj")
public class ScopedObj extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ScopedObj() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// REQUEST SCOPE
		/*
		 * WORKS WELL WITH FORWARDS SO FAR. response.getReques().forward ... blah blah
		 * blah FOR sendRedirect scope is request hence data is lost, unless data scope
		 * changes to either SESSION OR APPLICATION SCOPE FOR SESSION: exist till
		 * session times out depends on server and if cookie is set as well but no
		 * necessarily as encodeURL can be used. data still exist for different pages as
		 * session is not dead but with redirects it will fail as it is a different
		 * request to a page. HENCE WE go with Application scope. FOR APPLICATION SCOPE:
		 * exist along the whole application..different pages..new windows..
		 * 
		 * Using scope for servlets as to jsp:usebean scope="". YEAH!
		 * 
		 */
		// create a log object
		String check = request.getParameter("Scope");

		// Redirect or forward
		String options = request.getParameter("Select");

		// debug options
		System.out.println("options value:" + options);

		// save status message
		

		if (check.equals("request")) {
			Log logger = new Log("Payment Failure!");
			request.setAttribute("request_log", logger); // passing values between request
			// try with redirects
			// response.encodeRedirectUrl(request.getContextPath()+"/RequestScope.jsp");

			// response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/RequestScope.jsp"));
			// //DATA STILL LOST! ENCODES NOT THE RIGHT METHOD FOR REDIRECTS

			// select forwards
			if (options.equals("forwards")) {
				Log.ds = Status.toString(Status.REQUEST_FORWARDS);
				System.out.println(Log.ds); // debug status
				getServletContext().getRequestDispatcher("/RequestScope.jsp").forward(request, response);// working with
																											// FORWARDS
			}

			// select redirect
			if (options.equals("redirect")) {
				Log.ds = Status.toString(Status.REQUEST_REDIRECT);
				System.out.println(Log.ds); // debug status
				response.sendRedirect(request.getContextPath() + "/RequestScope.jsp"); // DATA IS LOST! Simulate NO
																				// cookie FEEL
			}
		} else {
			PrintWriter out = response.getWriter();
			out.println("Page Load error");
		}

		// SESSION SCOPE WITH REDIRECTS
		if (check.equals("session")) {

			Log logger = new Log("Refund Failure");
			// mark object for session tracking
			HttpSession session = request.getSession();
			session.setAttribute("session_log", logger); // marked

			// redirect to page to display failure.
			// select request route
			if (options.equals("redirect")) {
				Log.ds = Status.toString(Status.SESSION_REDIRECT);
				System.out.println(Log.ds); // debug status
				response.sendRedirect(request.getContextPath() + "/" + "SessionScope.jsp");
				return; //exit servlet
			}

			// select forward route
			if (options.equals("forwards")) {
				Log.ds = Status.toString(Status.SESSION_FORWARDS);
				System.out.println(Log.ds); // debug status
				request.getRequestDispatcher("/SessionScope.jsp").forward(request, response);

			}

			// WORKING PERFECTLY WITH SESSION. DATA NOT LOST AS TO REQUEST SCOPE.
			// BECAUSE TYPE IS HTTPSESSION. TYPE DEFINES OPERATIONS. POLYMORPHISM WOKRING
			// HERE.
			// OKAY LET'S NAME IT AS Request as well to disprove doubt.

		} else {
			PrintWriter out = response.getWriter();
			out.println("Page Load error");
		}

		// APPLICATION SCOPE
		if (check.equals("application")) {
			Log logger = new Log("empty cart");
			// mark object for application scope
			ServletContext context = getServletContext(); // from container point of view
			context.setAttribute("application_log", logger); // you have been marked as application scope

			// select request route
			if (options.equals("redirect")) {
				Log.ds = Status.toString(Status.APPLICATION_REDIRECT);
				System.out.println(Log.ds); // debug status
				response.sendRedirect(request.getContextPath() + "/" + "ApplicationScope.jsp");
			}

			// select forwards route
			if (options.equals("forwards")) {
				Log.ds = Status.toString(Status.APPLICATION_FORWARDS);
				System.out.println(Log.ds); // debug status
				getServletContext().getRequestDispatcher("/ApplicationScope.jsp").forward(request, response);

			}

		} else {
			PrintWriter out = response.getWriter();
			out.println("Page Load error");
		}

		// WITH FORWARDS THE HACK IS THE DATA EXIST AS TO APPLICATION SCOPE AS PAGE IS
		// RUN FROM THE CONTEXT HENCE STILL EXIST FROM SOURCE...

		// System.out.println((String)request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
