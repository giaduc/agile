package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Category;

public class CategoryService extends DAO implements IRepository<Category> {

	private static final Logger LOGGER = LogManager.getLogger(CategoryService.class);
	
	private static final String SELECT_ALL = "SELECT * FROM CATEGORY";

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<>();
		try {
			Statement stm = CONN.createStatement();
			ResultSet rs = stm.executeQuery(SELECT_ALL);

			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");

				Category c = new Category(id, name);
				categories.add(c);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return categories;
	}

	@Override
	public Optional<Category> findBy(String id) {
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
