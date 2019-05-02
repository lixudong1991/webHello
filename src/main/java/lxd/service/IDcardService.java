package lxd.service;

import lxd.entity.IDcard;

import java.util.List;

public interface IDcardService {
    List<IDcard> getAllIdcard()throws Exception;
}
