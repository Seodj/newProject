package com.seo.dj.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seo.dj.mapper.BlockServiceMapper;
import com.seo.dj.model.BlockServiceInfo;

@Repository
public class BlockServiceDaoImpl implements BlockServiceDao{
	@Autowired
	private BlockServiceMapper blockServiceMapper;
	
    public List<BlockServiceInfo> selectBlockservices(){
        System.out.println("Repository Layer getUsers called");
        return blockServiceMapper.selectBlockServices();
    }
}
