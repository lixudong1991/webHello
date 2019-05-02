package lxd.service;

import lxd.entity.People;

public interface PeopleService {
    People getPeopleByIDcard(String id)throws Exception;
}
