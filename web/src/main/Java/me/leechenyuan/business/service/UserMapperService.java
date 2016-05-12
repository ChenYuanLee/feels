package me.leechenyuan.business.service;

import me.leechenyuan.business.data.dao.UserMapper;
import me.leechenyuan.business.data.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by lideda on 2016/5/11.
 */
@Component("userMapperService")
@Transactional
public class UserMapperService {
    @Resource
    private UserMapper userMapper;
    public User getUserById(int userId){
        return this.userMapper.selectByPrimaryKey(userId);
    }
    public int increaseScore(int aUserId,int bUserId,int score,boolean ifThrow){
        this.userMapper.increaseScore(aUserId,score);
        if(ifThrow){
            throw new IllegalArgumentException("this is an excep");
        }
        this.userMapper.increaseScore(bUserId,-score);
        return 0;
    }
}
