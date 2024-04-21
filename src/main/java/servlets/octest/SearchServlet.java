import java.io.IOException;
import java.util.List;

import DAOmodeles.octest.RoomDAO;
import db_connection.RoomDaoImp;
import modeles.octest.Room;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RoomDAO roomDAO;

    public void init() {
        roomDAO = new RoomDaoImp();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomType = request.getParameter("roomType");

        List<Room> rooms = roomDAO.searchRoom(roomType);

        request.setAttribute("rooms", rooms);

        request.getRequestDispatcher("search_results.jsp").forward(request, response);
    }
}
