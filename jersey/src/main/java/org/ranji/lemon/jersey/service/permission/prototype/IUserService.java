package org.ranji.lemon.jersey.service.permission.prototype;

import org.ranji.lemon.core.service.prototype.IGenericService;
import org.ranji.lemon.jersey.model.permission.User;

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
 * Permission权限模块中的IUserService接口类
 * @author RanJi
 * @date 2019-01-07
 * @since JDK1.8
 * @version 1.0
 */
public interface IUserService extends IGenericService<User, Integer> {
	//-- 该方法没有任何的实际意义，仅仅是为了告诉大家如何自定义一些需要的方法而已，基本的方法不用自定义，都已经实现了
	public void selfMethod(User user);
}