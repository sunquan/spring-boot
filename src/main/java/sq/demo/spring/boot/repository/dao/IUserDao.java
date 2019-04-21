package sq.demo.spring.boot.repository.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sq.demo.spring.boot.repository.entity.UserEntity;

@Repository
public interface IUserDao {
    UserEntity getById(@Param("id") int id);

    void add(UserEntity user);
}
