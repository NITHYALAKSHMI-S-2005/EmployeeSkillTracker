package com.example.event;

import com.example.model.Skill;
import org.springframework.context.ApplicationEvent;

public class SkillAddedEvent extends ApplicationEvent {
    private final Long employeeId;
    private final Skill skill;

    public SkillAddedEvent(Object source, Long employeeId, Skill skill) {
        super(source);
        this.employeeId = employeeId;
        this.skill = skill;
    }

    public Long getEmployeeId() { return employeeId; }
    public Skill getSkill() { return skill; }
}