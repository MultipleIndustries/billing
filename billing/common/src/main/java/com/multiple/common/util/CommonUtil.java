package com.multiple.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {
	
	@Autowired
	private CacheManager cacheManager;
	
	public void deleteCache(String cacheName)
	{
		if(cacheManager!=null){
			Cache cache=cacheManager.getCache(cacheName);
			if(cache!=null)
				cache.clear();
		}
	}

}
