package com.fenuk.outlay.dao;

import com.fenuk.outlay.model.Outlay;

public interface OutlayDao {

	Outlay findById(int id);

	void saveOutlay(Outlay outlay);

}
