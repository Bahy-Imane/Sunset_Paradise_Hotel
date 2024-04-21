package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RoomDao;
import Db_Connection.RoomDaoImp;
import modeles.Room;



@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RoomDao roomDAO;

    public void init() {
        roomDAO = new RoomDaoImp();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomType = request.getParameter("roomType");

        List<Room> rooms = roomDAO.searchRoom(roomType);

        request.setAttribute("rooms", rooms);

        request.getRequestDispatcher("search_rlt.jsp").forward(request, response);
    }
}
