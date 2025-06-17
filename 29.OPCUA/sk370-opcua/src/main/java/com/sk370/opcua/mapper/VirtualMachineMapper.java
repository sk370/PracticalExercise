package com.sk370.opcua.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sk370.opcua.entity.NodeStructure;
import com.sk370.opcua.entity.VirtualMachine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author sk370
 * 2019-07-03
 */
public interface VirtualMachineMapper extends BaseMapper<VirtualMachine> {

    /**
     * 保存或更新
     *
     * @param virtualMachine 节点结构
     * @author sk370
     * 2019-07-03
     */
    void saveOrUpdate(@Param("virtualMachine") VirtualMachine virtualMachine);

    /**
     * 批量保存
     *
     * @param virtualMachineList 节点结构集合
     * @author sk370
     * 2019-07-03
     */
    void batchSave(@Param("virtualMachineList") List<VirtualMachine> virtualMachineList);

    /**
     * 批量保存或更新
     *
     * @param virtualMachineList 节点结构集合
     * @author sk370
     * 2019-07-03
     */
    void batchSaveOrUpdate(@Param("nodeStructureList") List<VirtualMachine> virtualMachineList);

    /**
     * 查询所有节点
     *
     * @return List
     * @author sk370
     * 2019-07-03
     */
    List<VirtualMachine> selectAll();
}