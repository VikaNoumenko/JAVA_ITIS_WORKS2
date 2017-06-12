package ru.itis.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itis.dao.AutoDao;
import ru.itis.models.Auto;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 20.05.2017
 * AutoDaoJdbcImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Repository
public class AutoDaoJdbcImpl implements AutoDao {

    //language=SQL
    private final String SQL_SELECT_AUTO =
            "SELECT * FROM auto";

    //language=SQL
    private final String SQL_INSERT_AUTO =
            "INSERT INTO auto(model, color, carmileage, used) " +
                    "VALUES(:model, :color, :carmileage, :used)";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

//    @Autowired
//    private SessionFactory sessionFactory;

    @Autowired
    public AutoDaoJdbcImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private RowMapper<Auto> autoRowMapper = new RowMapper<Auto>() {
        @Override
        public Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Auto.Builder()
                    .setId(rs.getInt("id"))
                    .setModel(rs.getString("model"))
                    .setColor(rs.getString("color"))
                    .setCarMileage(rs.getDouble("carmileage"))
                    .setUsed(rs.getBoolean("used")).build();
        }
    };

    @Override
    public List<Auto> findAll() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_AUTO, autoRowMapper);
    }

    @Override
    public Auto find(int id) {
        return null;
    }

    @Override
    public int save(Auto model) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("model", model.getModel());
        params.addValue("color", model.getColor());
        params.addValue("carmileage", model.getCarMileage());
        params.addValue("used", model.getIsUsed());

        KeyHolder holder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(SQL_INSERT_AUTO, params, holder, new String[]{"id"});
        Number number = holder.getKey();
        return number.intValue();
    }

    @Override
    public void update(Auto model) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Auto> findAllByUserAndByUsed(int userId, boolean isUsed) {
//        Session session = getSession();
//        session.beginTransaction();
//        List<Auto> autos = session.createQuery("from Auto auto where auto.owner.id = :userId and used = :isUsed")
//                .setParameter("userId", userId).setParameter("isUsed", isUsed).list();
//        session.getTransaction().commit();
//        return autos;
        return null;
    }

//    private Session getSession() {
//        Session session;
//        try {
//            session = sessionFactory.getCurrentSession();
//        } catch (HibernateException e) {
//            session = sessionFactory.openSession();
//        }
//
//        return session;
//    }
}
