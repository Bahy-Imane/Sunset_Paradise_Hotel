package servlets.octest;

import java.util.List;

import DAOmodeles.octest.RoomDAO;
import db_connection.RoomDaoImp;
import modeles.octest.Room;

@WebServlet("/RoomsServlet")
public class RoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoomDAO roomDAO;  

    public RoomsServlet() {
        super();
        roomDAO = new RoomDaoImp();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    List<Room> rooms = roomDAO.showRoom();

	        request.setAttribute("rooms", rooms);

	        request.getRequestDispatcher("room_search.jsp").forward(request, response);
	    
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}