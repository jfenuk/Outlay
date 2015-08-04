package com.fenuk.outlay.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fenuk.outlay.model.Outlay;

@Repository
public class OutlayJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String INSERT_QUERY = "insert into outlay (amount, category) values(?, ?)";
	private static final String UPDATE_QUERY = "update outlay set amount= ?, category=? where id=?";
	private static final String DELETE_QUERY = "delete from outlay where id=?";
	private static final String GET_BY_ID_QUERY = "select id, amount, category from outlay where id = ?";
	// private static final String GET_BY_NAME_QUERY = "select id, name, salary
	// from employee where name = ?";

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	public int save(Outlay o) {
		return jdbcTemplate.update(INSERT_QUERY, new Object[] { o.getAmount(), o.getCategory() });
	}

	public int update(Outlay o) {

		return jdbcTemplate.update(UPDATE_QUERY, new Object[] { o.getAmount(), o.getCategory(), o.getId() });
	}

	public int delete(Outlay o) {
		return jdbcTemplate.update(DELETE_QUERY, new Object[] { o.getId() });
	}

	public Outlay getById(int id) {

		Outlay o = this.jdbcTemplate.queryForObject(GET_BY_ID_QUERY, new Object[] { id }, new RowMapper<Outlay>() {
			public Outlay mapRow(ResultSet rs, int rowNum) throws SQLException {

				Outlay o = new Outlay(rs.getInt("id"), rs.getLong("amount"), rs.getString("category"));

				return o;
			}
		});
		return o;
	}

	/*
	 * public Employee getByName(String name) {
	 * 
	 * Employee e = this.jdbcTemplate.queryForObject(GET_BY_NAME_QUERY, new
	 * Object[] { name }, new RowMapper<Employee>() { public Employee
	 * mapRow(ResultSet rs, int rowNum) throws SQLException {
	 * 
	 * Employee e = new Employee(rs.getInt("id"), rs.getString("name"),
	 * rs.getFloat("salary"));
	 * 
	 * return e; } }); return e; }
	 */}
