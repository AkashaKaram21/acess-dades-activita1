package com.example.accesdades.ra2.ac1.acess_dades.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.accesdades.ra2.ac1.acess_dades.Model.student;

@Repository
public class studentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final class StudentRowMapper implements RowMapper<student> {
        @Override
        public student mapRow(ResultSet rs, int rowNum) throws SQLException {
            student student = new student();

            student.setId(rs.getLong("id"));
            student.setNom(rs.getString("nom"));
            student.setCognom(rs.getString("cognom"));
            student.setAge(rs.getInt("age"));
            student.setCicle(rs.getString("cicle"));
            student.setAny_curs(rs.getInt("any_curs"));

            return student;
        }
    }

    public List<student> findAll() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }
    
    public int save() {
        String sql = "INSERT INTO students(nom, cognom, age, cicle, any_curs) VALUES (?, ?, ?, ?, ?)";
        
        Object[][] estudiantes = {
            {"Akasha", "Karam", 18, "DAW", 2024},
            {"María", "García", 19, "DAM", 2024},
            {"Carlos", "López", 20, "DAW", 2024},
            {"Ana", "Martínez", 18, "ASIX", 2024},
            {"Pedro", "Rodríguez", 19, "DAW", 2024},
            {"Laura", "Fernández", 20, "DAM", 2024},
            {"Javier", "Sánchez", 18, "ASIX", 2024},
            {"Elena", "Pérez", 19, "DAW", 2024},
            {"David", "Gómez", 20, "DAM", 2024},
            {"Sofía", "Hernández", 18, "DAW", 2024}
        };
        
        int totalRegistros = 0;
        for (Object[] estudiante : estudiantes) {
            int numReg = jdbcTemplate.update(sql, estudiante);
            totalRegistros += numReg;
        }
        return totalRegistros;
    }
}
