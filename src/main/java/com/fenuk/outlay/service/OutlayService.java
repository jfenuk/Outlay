package com.fenuk.outlay.service;

import com.fenuk.outlay.model.Outlay;

public interface OutlayService {

	Outlay findById(int id);

	void saveOutlay(Outlay outlay);

	void updateOutlay(Outlay outlay);

}
