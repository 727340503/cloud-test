package com.cherrypicks.tcc.cms.api.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

import com.cherrypicks.tcc.cms.api.hystrix.MerchantFeignHystrixFallback;
import com.cherrypicks.tcc.cms.vo.ResultVO;
import com.cherrypicks.tcc.config.MerchantFeignConfig;
import com.cherrypicks.tcc.model.Merchant;

import feign.Param;
import feign.RequestLine;

@FeignClient(name="tcc-merchant",configuration=MerchantFeignConfig.class,fallbackFactory=MerchantFeignHystrixFallback.class)
public interface MerchantFeignClient {

	@RequestLine("POST /getmerchantDetail")
	public Merchant findById(@Param("id") Long id);
	
	@RequestLine("POST /addMerchant")
	public ResultVO addMerchant(@RequestBody Merchant merchant);
	
}
