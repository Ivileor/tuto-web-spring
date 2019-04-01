package dao;

import java.util.List;

import bean.Course;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

@Repository
public class ListeCoursesDAO implements IListeCoursesDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Course> rechercherCourses() {
		final CriteriaBuilder ICriteriaBuilder = entityManager.getCriteriaBuilder();
		
		final CriteriaQuery<Course> ICriteriaQuery = ICriteriaBuilder.createQuery(Course.class);
		final Root<Course> IRoot = ICriteriaQuery.from(Course.class);
		ICriteriaQuery.select(IRoot);
		final TypedQuery<Course> ITypedQuery = entityManager.createQuery(ICriteriaQuery);
		
		return ITypedQuery.getResultList();
	}

}
