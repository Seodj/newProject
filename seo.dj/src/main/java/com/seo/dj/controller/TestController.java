package com.seo.dj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seo.dj.domain.BlockServiceInfo;
import com.seo.dj.service.BlockService;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private BlockService blockService;
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public List<BlockServiceInfo> getBlockServices() {
        System.out.println("Controller Layer - users method is called");
        return blockService.getBlockServices();
    }
}
