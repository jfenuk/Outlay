package com.fenuk.outlay.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenuk.outlay.dao.OutlayDao;
import com.fenuk.outlay.model.Outlay;

@Service("outlayService")
@Transactional
public class OutlayServiceImpl implements OutlayService {

	@Autowired
	private OutlayDao dao;

	public Outlay findById(int id) {
		return dao.findById(id);
	}

	public void saveOutlay(Outlay outlay) {
		dao.saveOutlay(outlay);
	}

	public void updateOutlay(Outlay outlay) {

		Outlay entity = dao.findById(outlay.getId());
		if (entity != null) {

			entity.setAmount(outlay.getAmount());
		}
	}
}
