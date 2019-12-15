package com.scs.web.space.api.service;

import com.scs.web.space.api.util.Result;

import java.util.List;

public interface AccountService {
    Result getUserAccounts(int id);

    List list() ;

    void ActivationMobile(String email);

}
