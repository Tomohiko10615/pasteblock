package com.pasteblock.pasteblock.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pasteblock.pasteblock.app.models.entity.Blocker;

public interface IBlockerDao extends PagingAndSortingRepository<Blocker, Long> {

}
