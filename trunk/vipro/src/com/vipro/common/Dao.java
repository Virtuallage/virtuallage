package com.vipro.common;

/**
 * 
 * @author cvl
 *
 * @param <S>
 */
public interface Dao<S> {

	public void insert(S o);
	public void update(S o);
	public void delete(S o);
}
