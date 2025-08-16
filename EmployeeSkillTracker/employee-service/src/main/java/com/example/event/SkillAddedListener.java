package com.example.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SkillAddedListener {

    @EventListener
    public void onSkillAdded(SkillAddedEvent event) {
        System.out.println("EVENT: New skill added for employeeId=" + event.getEmployeeId()
                + " -> " + event.getSkill());
    }
}