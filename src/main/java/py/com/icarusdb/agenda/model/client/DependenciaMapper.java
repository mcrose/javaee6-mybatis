package py.com.icarusdb.agenda.model.client;

import py.com.icarusdb.agenda.model.Dependencia;

public interface DependenciaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dependencia
     *
     * @mbggenerated Tue Sep 10 14:19:39 PYT 2013
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dependencia
     *
     * @mbggenerated Tue Sep 10 14:19:39 PYT 2013
     */
    int insert(Dependencia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dependencia
     *
     * @mbggenerated Tue Sep 10 14:19:39 PYT 2013
     */
    int insertSelective(Dependencia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dependencia
     *
     * @mbggenerated Tue Sep 10 14:19:39 PYT 2013
     */
    Dependencia selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dependencia
     *
     * @mbggenerated Tue Sep 10 14:19:39 PYT 2013
     */
    int updateByPrimaryKeySelective(Dependencia record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dependencia
     *
     * @mbggenerated Tue Sep 10 14:19:39 PYT 2013
     */
    int updateByPrimaryKey(Dependencia record);
}