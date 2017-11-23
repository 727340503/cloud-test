package com.cherrypicks.tcc.cms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cherrypicks.tcc.cms.api.vo.ResultVO;
import com.cherrypicks.tcc.cms.service.CouponService;
import com.cherrypicks.tcc.cms.service.IBaseService;
import com.cherrypicks.tcc.model.Coupon;

@RestController
public class CouponController extends BaseController<Coupon>{
	
	@Autowired
	private CouponService couponService;

	@Override
	@Autowired
	public void setBaseService(IBaseService<Coupon> couponService) {
		// TODO Auto-generated method stub
		super.setBaseService(couponService);
	}
	
	
	@GetMapping("/getmerchantDetail")
	public ResultVO getMerchantDetail(final Long id) {
		ResultVO result = new ResultVO();
		result.setResult(couponService.getMerchant());
		
		return result;
	}
	
	@GetMapping("/addMerchant")
	public ResultVO addMerchant() {
		
		ResultVO result = new ResultVO();
		result.setResult(couponService.addMerchant());
		
		return result;
	}
	
}
