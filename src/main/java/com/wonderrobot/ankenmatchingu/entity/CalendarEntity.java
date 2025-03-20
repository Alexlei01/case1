package com.wonderrobot.ankenmatchingu.entity;
// CalendarEntity.vm

import java.util.List;

public class CalendarEntity extends BaseEntity {

    private List<CalendarDayEntity> calendarDayEntity;

    public List<CalendarDayEntity> getCalendarDayEntity() {
        return calendarDayEntity;
    }

    public void setCalendarDayEntity(List<CalendarDayEntity> calendarDayEntity) {
        this.calendarDayEntity = calendarDayEntity;
    }
}
