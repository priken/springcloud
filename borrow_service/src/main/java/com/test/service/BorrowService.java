package com.test.service;

import com.test.entity.Borrow;
import com.test.entity.BorrowDetail;

import java.util.List;

public interface BorrowService {
    BorrowDetail getBorrowDetailByUid(int uid);
}
