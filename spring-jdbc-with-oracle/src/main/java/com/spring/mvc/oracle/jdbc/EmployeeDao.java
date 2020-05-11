package com.spring.mvc.oracle.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDao implements Dao<Employee> {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Employee employee) {
        String sql = "insert into Employee values (sq_employee.nextval, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, employee.getFirstName(), employee.getStartDate(), employee.getJobRole(),
                employee.getDepartmet(), employee.getComment());
    }

    @Override
    public Employee load(long id) {
        List<Employee> employees = jdbcTemplate.query("select * from Employee where id =?",
                new Object[]{id}, new EmployeeMapper());

        if (employees.size() == 1) {
            return employees.get(0);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update("delete from PERSON where id = ?", id);
    }

    @Override
    public void update(Employee employee) {
        throw new UnsupportedOperationException();
    }


    @Override
    public List<Employee> loadAll() {
        return jdbcTemplate.query("select * from Employee", new EmployeeMapper());
    }

    public class EmployeeMapper implements RowMapper<Employee> {
    	public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(resultSet.getLong("ID"));
            employee.setFirstName(resultSet.getString("FIRST_NAME"));
            employee.setStartDate(resultSet.getString("START_DATE"));
            employee.setJobRole(resultSet.getString("JOB_ROLE"));
            employee.setDepartmet(resultSet.getString("DEPARTMENT"));
            employee.setComment(resultSet.getString("EMP_COMMENT"));
            
            return employee;
        }
    }
    
    }

