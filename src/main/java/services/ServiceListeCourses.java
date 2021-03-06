package services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import bean.Course;
import dao.IListeCoursesDAO;

@Service
public class ServiceListeCourses implements IServiceListeCourses {

	@Autowired
	private IListeCoursesDAO dao;
	
	@Transactional(readOnly=true)
	public List<Course> rechercherCourses() {
		return dao.rechercherCourses();
	}

}
