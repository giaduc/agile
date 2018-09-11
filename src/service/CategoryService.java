package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.util.HibernateUtil;
import model.Category;

public class CategoryService implements IRepository<Category> {

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.getTransaction();

		try {
			transaction.begin();
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Category> query = builder.createQuery(Category.class);
			Root<Category> root = query.from(Category.class);
			query.select(root);
			Query q = session.createQuery(query);
			categories = q.getResultList();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return categories;
	}

	@Override
	public Category findBy(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Category e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Category e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Category e) {
		// TODO Auto-generated method stub

	}

}
