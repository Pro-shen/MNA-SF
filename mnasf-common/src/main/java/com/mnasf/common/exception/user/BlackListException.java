package com.mnasf.common.exception.user;

/**
 * 黑名单IP异常类
 * 
 * @author mnasf
 */
public class BlackListException extends UserException
{
    private static final long serialVersionUID = 1L;

    public BlackListException()
    {
        super("login.blocked", null);
    }
}
