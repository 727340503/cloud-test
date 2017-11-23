package com.cherrypicks.tcc.cms.api.hystrix.impl;


import org.springframework.stereotype.Component;

import com.cherrypicks.tcc.cms.api.feign.MerchantFeignClient;
import com.cherrypicks.tcc.cms.api.hystrix.MerchantFeignHystrixFallback;
import com.cherrypicks.tcc.cms.vo.ResultVO;
import com.cherrypicks.tcc.model.Merchant;

@Component
public class MerchantFeignClientHystrixFallbackImpl implements MerchantFeignHystrixFallback{

	
	@Override
	public MerchantFeignClient create(Throwable arg) {
		
		System.out.println("error------"+arg.getMessage());
		
		return new MerchantFeignClient() {
			
			@Override
			public Merchant findById(Long id) {
				
				System.out.println("call this api");
				
				throw new RuntimeException("Merchant服务异常！！！！");
			}
			
			@Override
			public ResultVO addMerchant(Merchant merchant) {
				
				System.out.println("call this api------>addMerchant");
				
				throw new RuntimeException("Merchant服务异常！！！！");
			}
		};
	}

}
