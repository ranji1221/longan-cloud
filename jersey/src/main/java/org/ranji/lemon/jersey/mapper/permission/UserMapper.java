package org.ranji.lemon.jersey.mapper.permission;

import org.ranji.lemon.core.mapper.GenericMapper;
import org.ranji.lemon.jersey.model.permission.User;
import org.springframework.stereotype.Repository;
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
 * Permission权限模块中的UserMapper类，其实就是UserDao接口类
 * @author RanJi
 * @date 2019-01-07
 * @since JDK1.8
 * @version 1.0
 */

/*
 * 如何写自己的Mapper接口:
 * 1. 自定义Mapper接口，并定义需要的接口方法,切记是接口。
 * 2. 在接口上方增加@Mapper接口和@Repository标注
 * 3. Mapper类扫描若在CoreApplication中的启动类配置中自动扫描，则上述的标签是完全可以去掉的
 * 4. 之所以加@Repository是为了防止其他的项目也有相同名字的Mapper，所以利用这个标签起个名字。
 * 	注意：这个地方需要注意的是本来应该使用@Mapper标签，但是这个标签不能取名字，为了防止可能项目中有类名冲突的问题而定义使用了这个标签
	有关Mapper类扫描的事情则交给CoreApplication中的启动类配置中自动扫描
*/

@Repository("jerseyUserMapper")  
public interface UserMapper extends GenericMapper<User,Long> {
	//-- 通用的方法都有了，若需要一些特殊的方法，可以自己定义特殊的方法
	//-- 该方法没有任何实际的意义，仅仅是为了告知开发人员如果需要可以自定义接口方法，并在配置文件中去实现它
	public void selfMethod(User user);
}
