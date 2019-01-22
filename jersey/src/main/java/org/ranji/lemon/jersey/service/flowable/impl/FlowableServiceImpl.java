package org.ranji.lemon.jersey.service.flowable.impl;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.ranji.lemon.jersey.service.flowable.prototype.IFlowableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowableServiceImpl implements IFlowableService {
	
	@Autowired
	private ProcessEngine processEngine;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Override
	public ProcessEngine getProcessEngineInstance() {
		return processEngine;
	}

	@Override
	public RepositoryService getRepositoryServiceInstance() {
		return repositoryService;
	}

}
