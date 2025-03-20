package com.wonderrobot.ankenmatchingu.mapper;

import com.wonderrobot.ankenmatchingu.entity.JobDetail;
import java.util.List;

public interface J004SearchMapper {
    List<JobDetail> searchJobs(String projectCycleStart, String projectCycleEnd, String emailSendTimeStart, String emailSendTimeEnd, String searchText);
}