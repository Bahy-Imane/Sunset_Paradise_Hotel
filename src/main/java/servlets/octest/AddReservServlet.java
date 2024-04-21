package servlets.octest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import DAOmodeles.octest.ReservationDAO;
import db_connection.ReservationDaoImp;
import modeles.octest.Reservation;

@WebServlet("/AddReservServlet")
public class AddReservServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReservationDAO reservationDAO;

    public void init() {
        reservationDAO = new ReservationDaoImp();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        String startDateString = request.getParameter("startDate");
        String endDateString = request.getParameter("endDate");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parsedStartDate = dateFormat.parse(startDateString);
            Date parsedEndDate = dateFormat.parse(endDateString);

            java.sql.Date startDate = new java.sql.Date(parsedStartDate.getTime());
            java.sql.Date endDate = new java.sql.Date(parsedEndDate.getTime());

            Reservation reservation = new Reservation(roomId, startDate, endDate);
            reservationDAO.createReservation(reservation);

            response.sendRedirect(request.getContextPath() + "/ReservationServlet");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
