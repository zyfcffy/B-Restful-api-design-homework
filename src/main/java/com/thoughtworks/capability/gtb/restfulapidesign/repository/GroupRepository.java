package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupRepository {
    private static final int GROUP_NUM = 6;

    private static final List<Group> groupList = new ArrayList<>(GROUP_NUM);

    static {
        for (int i = 1; i <= GROUP_NUM; i++) {
            Group group = Group.builder()
                    .id(i)
                    .name("Team" + i)
                    .build();
            groupList.add(group);
        }
    }

    public List<Group> findAll(){
        return groupList;
    }
}
