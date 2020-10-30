package com.gem.daos;

import java.util.List;

public interface DaoContract<T, I>  {
	public List<T> findAll();
	public T findById(I i);
	public int create(T t);
	public int delete(I i) ;
}
