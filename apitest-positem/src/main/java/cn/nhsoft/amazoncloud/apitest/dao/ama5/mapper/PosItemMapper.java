package cn.nhsoft.amazoncloud.apitest.dao.ama5.mapper;

import cn.nhsoft.amazoncloud.apitest.dao.ama5.model.PosItem;
import cn.nhsoft.amazoncloud.apitest.dao.ama5.model.PosItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PosItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pos_item
     *
     * @mbggenerated Mon Jun 01 22:38:21 CST 2020
     */
    int countByExample(PosItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pos_item
     *
     * @mbggenerated Mon Jun 01 22:38:21 CST 2020
     */
    int deleteByExample(PosItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pos_item
     *
     * @mbggenerated Mon Jun 01 22:38:21 CST 2020
     */
    int insert(PosItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pos_item
     *
     * @mbggenerated Mon Jun 01 22:38:21 CST 2020
     */
    int insertSelective(PosItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pos_item
     *
     * @mbggenerated Mon Jun 01 22:38:21 CST 2020
     */
    List<PosItem> selectByExample(PosItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pos_item
     *
     * @mbggenerated Mon Jun 01 22:38:21 CST 2020
     */
    int updateByExampleSelective(@Param("record") PosItem record, @Param("example") PosItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pos_item
     *
     * @mbggenerated Mon Jun 01 22:38:21 CST 2020
     */
    int updateByExample(@Param("record") PosItem record, @Param("example") PosItemExample example);
}