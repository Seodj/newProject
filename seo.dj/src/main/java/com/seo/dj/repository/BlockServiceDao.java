package com.seo.dj.repository;

import java.util.List;

import com.seo.dj.domain.BlockServiceInfo;

public interface BlockServiceDao {
	
	public List<BlockServiceInfo> selectBlockservices();
	
}
