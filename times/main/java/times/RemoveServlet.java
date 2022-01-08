package times;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/remove"})
public class RemoveServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String userName = request.getParameter("userName");
		int date = Integer.parseInt(request.getParameter("date"));
		int hour = Integer.parseInt(request.getParameter("hour"));
		int minute = Integer.parseInt(request.getParameter("minute"));
		int duration = Integer.parseInt(request.getParameter("duration"));
		String description = request.getParameter("description");
		String status = null;

		try {
			status = DataStore.getInstance().removeTime(userName, date, hour, minute, duration, description);
		} catch (Exception var11) {
			response.getOutputStream().println(var11.toString());
		}

		String json = "{\n";
		json = json + "\"status\": " + status + "\n";
		json = json + "}";
		response.getOutputStream().println(json);
	}
}