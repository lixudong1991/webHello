package lxd.dao;

import lxd.entity.IDcard;

import java.util.List;

public interface IDcardDao {
    List<IDcard> findAllIDcard()throws Exception;
}
