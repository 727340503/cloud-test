package com.cherrypicks.tcc.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cherrypicks.tcc.cms.dao.IBaseDao;
import com.cherrypicks.tcc.cms.service.MerchantService;
import com.cherrypicks.tcc.model.Merchant;



@Service
public class MerchantServiceImpl extends AbstractBaseService<Merchant> implements MerchantService {

	@Override
	@Autowired
	public void setBaseDao(IBaseDao<Merchant> merchantDao) {
		super.setBaseDao(merchantDao);
	}
	
}
