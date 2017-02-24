package com.seo.dj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seo.dj.common.config.ApiConfiguration;
import com.seo.dj.domain.BlockServiceInfo;
import com.seo.dj.repository.BlockServiceDao;

@Service
public class BlockServiceImpl implements BlockService {
	@Autowired
	private BlockServiceDao blockServiceDao;
	@Autowired
	private ApiConfiguration apiConfiguration;
	
	@Override
	public List<BlockServiceInfo> getBlockServices() {
		System.out.println(apiConfiguration.getHost());
		return blockServiceDao.selectBlockservices();
	}

}
