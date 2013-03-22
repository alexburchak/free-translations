package net.abbreviations.core.service.impl;

import java.io.Serializable;
import org.springframework.transaction.annotation.Transactional;
import net.abbreviations.core.dao.BaseDAO;
import net.abbreviations.core.service.BaseService;

public abstract class BaseServiceImpl<ID extends Serializable, T> implements BaseService<ID, T> {
    protected abstract BaseDAO<ID, T> getDAO();

    @Transactional(readOnly = true)
    public T findById(ID id)
    {
        return getDAO().findById(id);
    }

    @Transactional
    public T save(T entity)
    {
        return getDAO().save(entity);
    }

    @Transactional
    public void remove(T entity)
    {
        getDAO().remove(entity);
    }
}