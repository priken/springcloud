package com.test.service.impl;

import com.test.entity.Book;
import com.test.entity.Borrow;
import com.test.entity.BorrowDetail;
import com.test.entity.User;
import com.test.mapper.BorrowMapper;
import com.test.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    BorrowMapper mapper;


    @Override
    public BorrowDetail getBorrowDetailByUid(int uid) {
        List<Borrow> borrow = mapper.getBorrowByUid(uid);  //返回的只有uid  bid  想获取详细信息可以通过HTTP远程调用
        RestTemplate template = new RestTemplate();    //RestTemplate支持远程调用
        //通过getForObject请求其他服务
        User user = template.getForObject("http://localhost:8301/user/" + uid, User.class);
        List<Book> bookList = borrow
                .stream()
                .map(b -> template.getForObject("http://localhost:8101/book/" + b.getBid(), Book.class))
                .collect(Collectors.toList());
        return new BorrowDetail(user, bookList);
    }
}
