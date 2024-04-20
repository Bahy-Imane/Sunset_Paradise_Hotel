package servlets.octest;


@WebServlet("/AddReservationServlet")
public class AddReservationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReservationDAO reservationDAO;

    public void init() {
        reservationDAO = new MySQLReservationDAO();
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

            Reservation reservation = new Reservation(roomId, startDate, endDate, userId);
            reservationDAO.createReservation(reservation);

            response.sendRedirect(request.getContextPath() + "/ReservationServlet");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
