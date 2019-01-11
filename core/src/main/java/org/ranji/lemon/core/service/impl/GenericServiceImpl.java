package org.ranji.lemon.core.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ranji.lemon.core.mapper.GenericMapper;
import org.ranji.lemon.core.pagination.PagerModel;
import org.ranji.lemon.core.service.prototype.IGenericService;
import org.ranji.lemon.core.system.SystemContext;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the"License"); 
 * you may not use this file except in compliance with the License.  
 * You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
 * See the License for the specific language governing permissions and limitations under the License.
 * Copyright [2017] [RanJi] [Email-jiran1221@163.com]
 * 
 * 通用Service实现类
 * @author RanJi
 * @date 2019-01-07
 * @since JDK1.8
 * @version 1.0
 */
public abstract class GenericServiceImpl<T, ID extends Serializable> implements IGenericService<T, ID> {

	@Autowired
	protected GenericMapper<T, ID> mapper;

	@Override
	public void save(T entity) {
		mapper.save(entity);
	}

	@Override
	public void update(T entity) {
		mapper.update(entity);
	}

	@Override
	public void delete(ID id) {
		mapper.delete(id);
	}

	@Override
	public void deleteAll() {
		mapper.deleteAll();
	}

	@Override
	public void deleteByIDS(List<ID> ids) {
		mapper.deleteByIDS(ids);
	}

	@Override
	public T find(ID id) {
		return mapper.find(id);
	}

	@Override
	public List<T> findAll(Map<String, Object> params) {
		return mapper.findAll(params);
	}

	@Override
	public List<T> findAll() {
		return this.findAll(null);
	}

	@Override
	public PagerModel<T> findPaginated(Map<String, Object> params) {
		//-- 1.不管传或不传参数都会追加至少两个分页参数
		if(params==null || params.size()==0) 
			params = new HashMap<String,Object>();
		params.put("offset", SystemContext.getOffset());
		params.put("limit", SystemContext.getPageSize());
		
		int total = mapper.getTotalOfItems(params);
		List<T> data = mapper.findPaginated(params);
		
		PagerModel<T> pm = new PagerModel<T>();
		pm.setData(data);
		pm.setTotal(total);
		
		return pm; 
	}
	
	@Override
	public PagerModel<T> findPaginated() {
		return this.findPaginated(null);
	}
	
	
}
