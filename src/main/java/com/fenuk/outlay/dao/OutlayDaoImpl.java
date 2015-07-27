package com.fenuk.outlay.dao;

import org.springframework.stereotype.Repository;

import com.fenuk.outlay.model.Outlay;

@Repository("employeeDao")
public class OutlayDaoImpl extends AbstractDao<Integer, Outlay> implements OutlayDao {

	public Outlay findById(int id) {
		return getByKey(id);
	}

	public void saveOutlay(Outlay outlay) {
		persist(outlay);
	}

}
