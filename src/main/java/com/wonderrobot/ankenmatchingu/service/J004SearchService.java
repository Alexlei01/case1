package com.wonderrobot.ankenmatchingu.service;

import com.wonderrobot.ankenmatchingu.entity.JobDetail;
import java.util.List;

public interface J004SearchService {
    List<JobDetail> searchJobs(String projectCycleStart, String projectCycleEnd, String emailSendTimeStart, String emailSendTimeEnd, String searchText);
}