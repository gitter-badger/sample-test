package service.impl;

import dao.UserMapper;
import model.User;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        return userMapper.create(user) > 0;
    }

    @Override
    public int calRank(User user) {
        if (user.getAge() < 10) {
            return 0;
        }

        if (user.getAge() < 20) {
            return 1;
        }

        if (user.getAge() < 30) {
            return 2;
        }

        return 4;
    }

    @Override
    public User queryUser(String userName, String password) {
        return userMapper.query(userName, password);
    }
}
