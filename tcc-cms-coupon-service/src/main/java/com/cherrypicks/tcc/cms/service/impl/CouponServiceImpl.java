package com.cherrypicks.tcc.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cherrypicks.tcc.cms.api.feign.MerchantFeignClient;
import com.cherrypicks.tcc.cms.service.CouponService;
import com.cherrypicks.tcc.cms.vo.ResultVO;
import com.cherrypicks.tcc.model.Coupon;
import com.cherrypicks.tcc.model.Merchant;
import com.cherrypicks.tcc.util.DateUtil;
import com.cherrypicks.tcc.util.JsonUtil;

@Service
public class CouponServiceImpl extends AbstractBaseService<Coupon> implements CouponService {
	
	
	@Autowired
	private MerchantFeignClient merchantFeignClient;

	@Override
	public Merchant getMerchant() {
		return merchantFeignClient.findById(7L);
	}

	@Override
	@Transactional
	public Merchant addMerchant() {
		
		Merchant merchant = new Merchant();
		merchant.setMerchantCode("123");
		merchant.setSecurityKey("321");
		merchant.setLoginMethod("1,2");
		merchant.setIssueStampMethod(1);
		merchant.setStatus(1);
		merchant.setIsCouponManagement(false);
		merchant.setTimeZone("Asia/Chongqing");
		merchant.setIsDeleted(false);
		merchant.setCreatedBy(String.valueOf(1L));
		merchant.setCreatedTime(DateUtil.getCurrentDate());
		
		ResultVO result = merchantFeignClient.addMerchant(merchant);
		
		return JsonUtil.convert(result.getResult(),Merchant.class);
	}
	
	
	
}
