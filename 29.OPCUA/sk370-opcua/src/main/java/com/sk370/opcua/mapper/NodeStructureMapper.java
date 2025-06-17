package com.sk370.opcua.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sk370.opcua.entity.NodeStructure;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author sk370
 * 2019-07-03
 */
public interface NodeStructureMapper extends BaseMapper<NodeStructure> {

    /**
     * 保存或更新
     *
     * @param nodeStructure 节点结构
     * @author sk370
     * 2019-07-03
     */
    void saveOrUpdate(@Param("nodeStructure") NodeStructure nodeStructure);

    /**
     * 批量保存
     *
     * @param nodeStructureList 节点结构集合
     * @author sk370
     * 2019-07-03
     */
    void batchSave(@Param("nodeStructureList") List<NodeStructure> nodeStructureList);

    /**
     * 批量保存或更新
     *
     * @param nodeStructureList 节点结构集合
     * @author sk370
     * 2019-07-03
     */
    void batchSaveOrUpdate(@Param("nodeStructureList") List<NodeStructure> nodeStructureList);

    /**
     * 查询所有节点
     *
     * @return List
     * @author sk370
     * 2019-07-03
     */
    List<NodeStructure> selectAll();
}