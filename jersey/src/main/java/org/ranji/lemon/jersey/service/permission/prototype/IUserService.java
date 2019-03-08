package org.ranji.lemon.jersey.service.permission.prototype;

import java.util.Set;

import org.ranji.lemon.core.service.prototype.IGenericService;
import org.ranji.lemon.jersey.model.permission.Permission;
import org.ranji.lemon.jersey.model.permission.Role;
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
public interface IUserService extends IGenericService<User, Long> {
	//-- 除了父接口中的方法，下面的方面是我们根据业务的需要而自己写的需要实现的方法
	
	/**
	 * 修改某用户的密码
	 * @param userId
	 * @param newPassword
	 */
    public void changePassword(Long userId, String newPassword);
    /**
     * 为某用户分配角色
     * @param userId
     * @param roleIds
     */
    public void assignRoles(Long userId, Long... roleIds);
    /**
     * 解除某用户所拥有的角色
     * @param userId
     * @param roleIds
     */
    public void relieveRoles(Long userId, Long... roleIds);
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username);  
    /**
     * 根据用户名查询其所拥有的角色
     * @param username
     * @return
     */
    public Set<Role> findRoles(String username);// 根据用户名查找其角色  
    /**
     * 根据用户名查询其所有的权限
     * @param username
     * @return set集合可以排重，所以利用这个特性
     */
    public Set<Permission> findPermissions(String username); 
}