import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/calc")
public class Calculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int firstOperand;
        int secondOperand;
        try {
            firstOperand = Integer.parseInt(req.getParameter("x"));
            secondOperand = Integer.parseInt(req.getParameter("y"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }
        int result = 0;
        switch (req.getParameter("op")) {
            case "minus":
                result = firstOperand - secondOperand;
                break;
            case "plus":
                result = firstOperand + secondOperand;
                break;
        }
        req.setAttribute("result", result);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
