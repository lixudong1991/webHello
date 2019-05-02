package lxd.dao;

import lxd.entity.People;

public interface PeopleDao {
    People findPeopleByIdentity(String id)throws Exception;
}
