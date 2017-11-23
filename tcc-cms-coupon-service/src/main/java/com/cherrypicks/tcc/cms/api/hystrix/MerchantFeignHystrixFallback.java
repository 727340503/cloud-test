package com.cherrypicks.tcc.cms.api.hystrix;

import com.cherrypicks.tcc.cms.api.feign.MerchantFeignClient;

import feign.hystrix.FallbackFactory;

public interface MerchantFeignHystrixFallback extends FallbackFactory<MerchantFeignClient>{

}
