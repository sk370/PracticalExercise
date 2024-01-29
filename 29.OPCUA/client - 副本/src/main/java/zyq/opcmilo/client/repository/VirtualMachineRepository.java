package zyq.opcmilo.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zyq.opcmilo.client.pojo.entity.VirtualMachine;

//@Repository
public interface VirtualMachineRepository extends JpaRepository<VirtualMachine,Integer> {
}
