package ihm;



import bll.RepasManagerSingleton;
import bo.Repas;
import dal.DALException;
import dal.DAOFact;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AjoutRepas")
public class AjoutRepas extends HttpServlet {


	public AjoutRepas() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutRepas.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date dateRepas = convertToDate(request.getParameter("dateRepas"));
		dateRepas = AddTimeToDate(request.getParameter("heureRepas"),dateRepas);
		try {
			RepasManagerSingleton.getInstance().ajouterUnRepas(dateRepas,request.getParameter("aliments") );
		} catch (DALException e) {
			e.printStackTrace();
		}

		response.getWriter().append(dateRepas.toString());

	}

	private Date convertToDate(String date){

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date dateRepas = sdf.parse(date);
			return  dateRepas;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}
	private Date AddTimeToDate(String time, Date date){

		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");


		var timeSplit =  time.split(":");
		int[] arrayIntTime = Arrays.asList(timeSplit).stream().mapToInt(Integer::parseInt).toArray();

		try {
			Date timeDate = sdf.parse(time);


//			Calendar calendarTime  = Calendar.getInstance();
//			calendarTime.setTimeInMillis(timeDate.getTime());
//

			Calendar calendarDate=Calendar.getInstance();
			calendarDate.setTimeInMillis(date.getTime());

			calendarDate.set(Calendar.HOUR_OF_DAY, arrayIntTime[0]);
			calendarDate.set(Calendar.MINUTE, arrayIntTime[1]);

			Date dateFinale = new Date(calendarDate.getTimeInMillis());
			return  dateFinale;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}


}
