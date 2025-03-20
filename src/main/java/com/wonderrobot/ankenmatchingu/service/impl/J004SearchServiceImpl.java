package com.wonderrobot.ankenmatchingu.service.impl;

import com.wonderrobot.ankenmatchingu.entity.JobDetail;
import com.wonderrobot.ankenmatchingu.mapper.J004SearchMapper;
import com.wonderrobot.ankenmatchingu.service.J004SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class J004SearchServiceImpl implements J004SearchService {

    @Autowired
    private J004SearchMapper j004SearchMapper;

    @Override
    public List<JobDetail> searchJobs(String projectCycleStart, String projectCycleEnd, String emailSendTimeStart, String emailSendTimeEnd, String searchText) {
        return j004SearchMapper.searchJobs(projectCycleStart, projectCycleEnd, emailSendTimeStart, emailSendTimeEnd, searchText);
    }
}