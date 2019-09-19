package com.ripple.infrasvc.dal.repository;

import com.ripple.infrasvc.dal.model.User;
import com.ripple.infrasvc.dal.model.VirtualMachine;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
@Repository
public interface VMRepository extends JpaRepository<VirtualMachine, Integer> {

    boolean existsByvmName(String name);

    VirtualMachine findByvmName(String name);

    List<VirtualMachine> findAllByUser(User userId);

    List<VirtualMachine> findByUserOrderByHardDiskDesc(User userId, Pageable pageable);

    List<VirtualMachine> findAllByOrderByHardDiskDesc(Pageable pageable);

}
