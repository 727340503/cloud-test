package com.cherrypicks.tcc.cms.service;

import com.cherrypicks.tcc.model.Coupon;
import com.cherrypicks.tcc.model.Merchant;

public interface CouponService extends IBaseService<Coupon>{

	Merchant getMerchant();
	
	Merchant addMerchant();
}
