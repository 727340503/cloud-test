package com.cherrypicks.tcc.cms.api.controller;

import org.apache.commons.lang.StringUtils;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cherrypicks.tcc.cms.api.vo.ResultVO;
import com.cherrypicks.tcc.cms.service.IBaseService;
import com.cherrypicks.tcc.cms.service.MerchantService;
import com.cherrypicks.tcc.model.Merchant;
import com.cherrypicks.tcc.util.DateUtil;

@RestController
public class MerchantController extends BaseController<Merchant>{
	
	@Autowired
	private MerchantService merchantService;

	@Override
	@Autowired
	public void setBaseService(IBaseService<Merchant> merchantService) {
		// TODO Auto-generated method stub
		super.setBaseService(merchantService);
	}
	
	
	@PostMapping("/getmerchantDetail")
	public ResultVO getMerchantDetail(final Long id) {
		ResultVO result = new ResultVO();
		result.setResult(merchantService.findById(id));
		
		return result;
	}
	
	@PostMapping("/addMerchant")
	public ResultVO addMerchant(@RequestBody final Merchant merchant) {
		
		ResultVO result = new ResultVO();
		result.setResult(merchantService.add(merchant));
		
		return result;
	}
	
	@PostMapping("/updateMerchant")
	public ResultVO updateMerchant(final Long userId,final Long id, final String merchantCode,final String securityKey,final String loginMethod,final Integer issueStampMethod,final Integer status,final Boolean isCouponManagement,final String timeZone) {
		
		Merchant merchant = merchantService.findById(id);
		if(StringUtils.isNotBlank(merchantCode)) {
			merchant.setMerchantCode(merchantCode);
		}
		if(StringUtils.isNotBlank(securityKey)) {
			merchant.setSecurityKey(securityKey);
		}
		if(StringUtils.isNotBlank(loginMethod)) {
			merchant.setLoginMethod(loginMethod);
		}
		if(null != issueStampMethod) {
			merchant.setIssueStampMethod(issueStampMethod);
		}
		if(null != status) {
			merchant.setStatus(status);
		}
		if(null != isCouponManagement) {
			merchant.setIsCouponManagement(isCouponManagement);
		}
		if(StringUtils.isNotBlank(timeZone)) {
			merchant.setTimeZone(timeZone);
		}
		merchant.setUpdatedBy(String.valueOf(userId));
		merchant.setUpdatedTime(DateUtil.getCurrentDate());
		
		ResultVO result = new ResultVO();
		result.setResult(merchantService.update(merchant));
		return result;
	}
	
	
}
