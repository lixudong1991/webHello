package lxd.service.impl;

import lxd.entity.IDcard;
import lxd.dao.IDcardDao;
import lxd.service.IDcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iDcardService")
public class IDcardServiceImpl implements IDcardService {
    @Autowired
    IDcardDao iDcardDao;
    @Override
    public List<IDcard> getAllIdcard() throws Exception {
        return iDcardDao.findAllIDcard();
    }
}
