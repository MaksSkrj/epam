import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/vote")
public class Vote extends HttpServlet {

    {
        try {
            init();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        Map<String, Integer> votes = new HashMap<>();
        votes.put("Football", 0);
        votes.put("Basketball", 0);
        votes.put("Volleyball", 0);
        context.setAttribute("votes", votes);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String variant = req.getParameter("op");
        HashMap<String, Integer> votes = (HashMap<String, Integer>) req.getSession().getServletContext().getAttribute("votes");

        votes.computeIfPresent(variant, (k, v) -> v + 1);

        req.setAttribute("votes", votes);
        req.getRequestDispatcher("resultVote.jsp").forward(req, resp);


    }
}
