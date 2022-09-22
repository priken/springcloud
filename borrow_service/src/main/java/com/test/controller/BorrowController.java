package com.test.controller;

import com.test.entity.Borrow;
import com.test.entity.BorrowDetail;
import com.test.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BorrowController {

    @Resource
    BorrowService service;

    @RequestMapping("/borrow/{uid}")
    public BorrowDetail getBorrowById(@PathVariable("uid") int uid){

        return service.getBorrowDetailByUid(uid);
    }

}
