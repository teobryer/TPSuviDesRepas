package ihm;

import bll.RepasManagerSingleton;
import bo.Repas;
import dal.DALException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Consultation")
public class Consultation extends HttpServlet {

    public Consultation() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            List<Repas> listeRepas = RepasManagerSingleton.getInstance().recupererTousLesRepas();
            System.out.println(listeRepas);
            req.setAttribute("listeRepas",listeRepas);
        } catch (DALException e) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/consultation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //   super.doPost(req, resp);
    }
}
