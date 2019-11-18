package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.iap.Response;

import vo.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.*;

public class address extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public address() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Addressdao add = new Addressdao();
		List<Province> provList = null;
		try {
			provList = add.getAllProvince();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String jsonStr = gs.toJson(provList);
		//out.print(jsonStr);
		Map<String,String> pm = new HashMap<String,String>();
		StringBuilder str = new StringBuilder();  
		for(Province pro:provList){
			//pm.put(pro.getName(),pro.getCode());
			str.append(pro.getName());
			str.append(",");
		}
		//String s1 = request.getParameter("proc");
		out.print(str);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String method = req.getParameter("method");
		if (null != method && !"".equals(method))
		{
			if ("initProvince".equals(method))
			{
				try {
					initProvince(req, resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if ("getCity".equals(method))
			{
				try {
					getCity(req, resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if("getArea".equals(method)) {
				try {
					getArea(req,resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
 
	/**
	 * 查询对应区县
	 * @param req
	 * @param resp
	 * @throws Exception 
	 */
	private void getArea(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String cityCode = req.getParameter("cityCode");
		Addressdao add = new Addressdao();
		//List<Area> areaList = add.getAllArea(cityCode);
		
		//String jsonStr = gs.toJson(areaList);
		//out.print(jsonStr);
		
	}
 
	/**
	 * 查询对应城市
	 * @param req
	 * @param resp
	 * @throws Exception 
	 */
	private void getCity(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
 
		String provCode = req.getParameter("provCode");
		Addressdao add = new Addressdao();
		//List<City> cityList = add.getAllCity(provCode);
		//String json = JSON.toJSONString(cityList);
		//String jsonStr = gs.toJson(cityList);
		//out.print(jsonStr);
		//Map<String,String> pm = new HashMap<String,String>();
		//for(City ct :cityList ){
			
		//}
 
	}
 
	/**
	 * 初始化地址栏
	 * 
	 * @param req
	 * @param resp
	 * @throws Exception 
	 */
	private void initProvince(HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
 
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		Addressdao add = new Addressdao();
		List<Province> provList = add.getAllProvince();
		//String jsonStr = gs.toJson(provList);
		//out.print(jsonStr);
		Map<String,String> pm = new HashMap<String,String>();
		for(Province pro:provList){
			pm.put(pro.getName(),pro.getCode());
		}
		String s1 = req.getParameter("proc");
		out.print(pm.get(s1));
		
	}
	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
