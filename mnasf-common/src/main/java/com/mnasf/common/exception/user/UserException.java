package com.mnasf.common.exception.user;

import com.mnasf.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author mnasf
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
