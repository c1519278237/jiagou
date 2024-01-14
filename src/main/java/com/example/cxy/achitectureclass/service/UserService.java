package com.example.cxy.achitectureclass.service;

import com.example.cxy.achitectureclass.common.service.LogicService;
import com.example.cxy.achitectureclass.dao.UserDao;
import com.example.cxy.achitectureclass.dto.LoginResponseDto;
import com.example.cxy.achitectureclass.dto.UserInfoDto;
import com.example.cxy.achitectureclass.entity.Business;
import com.example.cxy.achitectureclass.entity.Customer;
import com.example.cxy.achitectureclass.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Objects;


@Service
public class UserService extends LogicService<UserDao, User, Long> {

    @Resource
    private UserDao userDao;

    public UserService(@Autowired UserDao dao) {
        super(dao);
    }

    /**
     *
     * @param username 用户名
     * @param password 密码
     * @return boolean 是否登录城
     */
    public LoginResponseDto login(String username, String password) {
        User userByUsername = userDao.findUserByUsername(username);
        boolean equals = userByUsername.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()));
        if(equals){
           return new LoginResponseDto().setType(userByUsername.getType()).setSuccess(true);
        }
        throw new RuntimeException("用户名或密码错误");
    }

    public boolean register(UserInfoDto userInfoDto) {
        User userByUsername = userDao.findUserByUsername(userInfoDto.getUsername());
        if (Objects.nonNull(userByUsername)){
            throw new RuntimeException("用户名已经存在");
        }
        Integer type = userInfoDto.getType();
        switch (type){
            case 0:
                Customer customer = new Customer();
                customer.setCustomerName(userInfoDto.getName());
                customer.setUsername(userInfoDto.getUsername());
                customer.setPassword(userInfoDto.getPassword());
                customer.setType(0);
                customer.setAddr(userInfoDto.getAddr());
                customer.setEmail(userInfoDto.getEmail());
                getDAO().save(customer);
                break;
            case 1:
                Business business = new Business();
                business.setRealName(userInfoDto.getName());
                business.setUsername(userInfoDto.getUsername());
                business.setPassword(userInfoDto.getPassword());
                business.setType(0);
                business.setAddr(userInfoDto.getAddr());
                business.setEmail(userInfoDto.getEmail());
                getDAO().save(business);
                break;
            default:
                throw new RuntimeException("no such type");
        }
        return true;
    }
}
