package lxd.service.impl;

import lxd.entity.People;
import lxd.dao.PeopleDao;
import lxd.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("peopleService")
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    PeopleDao peopleDao;
    @Override
    public People getPeopleByIDcard(String id) throws Exception {
        return peopleDao.findPeopleByIdentity(id);
    }
}
