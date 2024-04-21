package Servlets;




import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RoomDao;
import Db_Connection.RoomDaoImp;
import modeles.Room;




@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoomDao roomDAO;  

    public RoomServlet() {
        super();
        roomDAO = new RoomDaoImp();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    List<Room> rooms = roomDAO.showRoom();

	        request.setAttribute("rooms", rooms);

	        request.getRequestDispatcher("search_room.jsp").forward(request, response);
	    
	}


	protected void doPost(HttpRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}