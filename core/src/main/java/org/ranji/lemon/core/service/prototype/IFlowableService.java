package org.ranji.lemon.core.service.prototype;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;

/**
 * 工作流程接口
 * @author RanJi
 *
 */
public interface IFlowableService {
	public ProcessEngine getProcessEngineInstance();
	
	public RepositoryService getRepositoryServiceInstance();
}
