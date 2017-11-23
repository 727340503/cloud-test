package com.cherrypicks.tcc.cms.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cherrypicks.tcc.cms.dao.MerchantDao;
import com.cherrypicks.tcc.model.Merchant;

@Repository
public class MerchantDaoImpl extends AbstractBaseDao<Merchant> implements MerchantDao {

	@Override
	public List<Merchant> findByFilter(Map<String, Object> criteriaMap, String sortField, String sortType, int... args) {
		return null;
	}


}
