package com.student.Student.dao;

import com.student.Student.entites.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class StudentDaoImpl implements StudentDao {

    private static final Logger log = LoggerFactory.getLogger(StudentDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper<Student> rowMapper = (rs, rowNum) -> {
        Student student = new Student();
        student.setStudent_id(rs.getInt("student_id"));
        student.setFirst_name(rs.getString("first_name"));
        student.setLast_name(rs.getString("last_name"));
        student.setAge(rs.getInt("age"));
        student.setAddress(rs.getString("address"));
        return student;
    };

    @Override
    public List<Student> list() {
        String sql = "Select student_id, first_name,last_name,age,address from student";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Optional<Integer> create(Student student) {
        String sql = "insert into student(student_id, first_name,last_name,age,address)values(?,?,?,?,?)";
        Optional<Integer> insert = Optional.of(jdbcTemplate.update(sql, student.getStudent_id(), student.getFirst_name(), student.getLast_name(),
                student.getAge(), student.getAddress()));
        insert.ifPresent(updatedRows -> {
            if (updatedRows == 1) {
                log.info("New student created: " + updatedRows);
            }
        });
        return insert;
    }

    @Override
    public Optional<Integer> update(Student student, int id) {
        String sql = "update student set first_name = ?, last_name = ?, age = ?, address = ? where student_id = ?";
        Optional<Integer> update = Optional.of(jdbcTemplate.update(sql, student.getFirst_name(), student.getLast_name(),
                student.getAge(), student.getAddress(), student.getStudent_id()));
        update.ifPresent(updatedRows -> {
            if (updatedRows == 1) {
                log.info("Student updated Successfully: " + updatedRows);
            }
        });
        return update;
    }

    @Override
    public Optional<Integer> delete(int id) {
        Optional<Integer> deleted = Optional.of(jdbcTemplate.update("delete from student where student_id = ?", id));
        deleted.ifPresent(updatedRows -> {
            if (updatedRows == 1) {
                log.info("Student deleted Successfully: " + id);
            }
        });
        return deleted;
    }

    @Override
    public Optional get(int id) {
        String sql = "Select student_id, first_name,last_name,age,address from student where student_id = ?";
        Student student = null;
        try {
            student = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (DataAccessException ex) {
            log.info("Student not found " + id);
        }
        return Optional.ofNullable(student);
    }
}
