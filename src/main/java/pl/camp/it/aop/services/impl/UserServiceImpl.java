package pl.camp.it.aop.services.impl;

import org.springframework.stereotype.Service;
import pl.camp.it.aop.model.User;
import pl.camp.it.aop.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public User getUser1() {
        System.out.println("wyskonywanie metody getUser1 z UserServiceImpl");
        return new User(1, "janusz", "janusz123");
    }

    @Override
    public User getUser2() {
        System.out.println("wyskonywanie metody getUser2 z UserServiceImpl");
        return new User(2, "zbyszek", "zbyszek123");
    }

    @Override
    public User getUser3() {
        System.out.println("wyskonywanie metody getUser3 z UserServiceImpl");
        return new User(3, "wiesiek", "wiesiek123");
    }
}
