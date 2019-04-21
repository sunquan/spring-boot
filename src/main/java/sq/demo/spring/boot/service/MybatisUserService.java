package sq.demo.spring.boot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sq.demo.spring.boot.model.User;
import sq.demo.spring.boot.repository.dao.IUserDao;
import sq.demo.spring.boot.repository.entity.UserEntity;

import java.util.List;

@Service
public class MybatisUserService {

    private static final Logger LOG = LoggerFactory.getLogger(MybatisUserService.class);

    @Autowired
    private IUserDao userDao;

    public UserEntity getUserById(int id){
        return userDao.getById(id);
    }

    public void add(UserEntity user){
        userDao.add(user);
    }

    public void addUsersWithoutTransaction(List<UserEntity> users){
        users.forEach(u -> {
            userDao.add(u);
        });
    }

    @Transactional
    public void addUsersWithTransaction(List<UserEntity> users){
        LOG.info("-------addUsersWithTransaction");
        users.forEach(u -> {
            userDao.add(u);
        });
    }
}
