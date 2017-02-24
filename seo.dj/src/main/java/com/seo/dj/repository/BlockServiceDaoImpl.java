package com.seo.dj.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.seo.dj.domain.BlockServiceInfo;

@Repository
public class BlockServiceDaoImpl implements BlockServiceDao{
	
    public List<BlockServiceInfo> selectBlockservices(){
        System.out.println("Repository Layer getUsers called");
        List<BlockServiceInfo> blockServiceInfos = new ArrayList<>();
        BlockServiceInfo blockServiceInfo = new BlockServiceInfo();
        blockServiceInfo.setAppKey("TEST");
        
        blockServiceInfos.add(blockServiceInfo);
        
        return blockServiceInfos;
    }
}
