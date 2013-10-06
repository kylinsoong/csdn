import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Case00934945Reproduce")
public class Case00934945Reproduce extends HttpServlet {

	private static final long serialVersionUID = -5930212000191466661L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		try {
			System.out.println("Case 00934945 reproduce");
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.jbpm.task");
			EntityManager em = emf.createEntityManager();
			String queryName = "UnescalatedDeadlines";
			Query query = em.createNamedQuery(queryName);
			List list = query.getResultList();
			System.out.println("Test Success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		doGet(req, resp);
	}

}
