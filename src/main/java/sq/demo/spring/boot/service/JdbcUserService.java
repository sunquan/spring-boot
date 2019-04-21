package sq.demo.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import sq.demo.spring.boot.model.User;

import java.util.List;

@Service
public class JdbcUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> getUserMapper(){
        return (rs, rownum) ->{
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("name"));
            u.setAge(rs.getInt("age"));
            u.setSex(rs.getInt("sex"));
            return u;
        };
    }

    public User getUserById(int id){
        String sql = "select * from user where id = ?";
        Object[] params = new Object[]{id};
        return jdbcTemplate.queryForObject(sql, params, getUserMapper());
    }

    public List<User> getUserAll(){
        String sql = "select * from user";
        return jdbcTemplate.query(sql, getUserMapper());
    }

    public void add(User user){
        String sql = "insert into user(name, age, sex)values(?,?,?)";
        jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getSex());
    }
}
