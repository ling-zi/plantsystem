package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PlantSer;
import domain.Plant;

public class PlantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PlantServlet() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		if ("add".equals(type)) {
			PlantAdd(request, response);
		}
	}

	// 添加植物
	private void PlantAdd(HttpServletRequest request, HttpServletResponse response) {
		PlantSer ps = new PlantSer();
		String pname = request.getParameter("pname");
		String phylum = request.getParameter("phylum");
		String pfamily = request.getParameter("pfamily");
		String pgenus = request.getParameter("pgenus");
		String pdesc = request.getParameter("pdesc");
		String pphotos = request.getParameter("pphotos");
		Plant plant = new Plant(pname, pphotos, pdesc, pfamily, pgenus, phylum);
		boolean b = ps.addplant(plant);
		try {
			if (b) {
				request.getRequestDispatcher("addplant.jsp").forward(request, response);
			}
			else {
				response.sendRedirect(request.getContextPath() + "/404.jsp");
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
