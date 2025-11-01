package com.example.accesdades.ra2.ac1.acess_dades.Repository;

import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.accesdades.ra2.ac1.acess_dades.Model.student;



@Repository
public class studentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    private static final class StudentRowMappper implements RowMapper<student>{
        
        @Override
        
        public student mapRow(ResultSet rs, int rowNum) throws SQLException{
           
            //Crea un objecte de student 
            student student = new student();

            student.setId(rs.getLong("id"));
            student.setNom(rs.getString("name"));
            student.setCognom(rs.getString("cognom"));
            student.setAge(rs.getInt("age"));
            student.setCicle(rs.getString("cicle"));
            student.setAny(rs.getInt("any"));        

            return student;
        }
    }

    public List<student> findAll(){
        String sql = "select * from students";
        return jdbcTemplate.query(sql, new StudentRowMappper());
    }
    
    public int save(){
        String sql = "insert into students(name,age) value(?,?)";
        int numReg = jdbcTemplate.update(sql, "Akasha",18);
        return numReg;
    }
}
