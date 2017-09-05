<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="${CONFIG.serverName}.dao.${entity.className}Dao">

    <sql id="table"> ${entity.tableName}</sql>
    <sql id="columns"> <#list entity.allfieldList as e>${e.columnName}<#if e_has_next>,</#if></#list></sql>

    <sql id="listcolumns"> o.*,s.@TODO</sql>

    <resultMap id="${entity.firstLowName}" type="${entity.className}">
    <#list entity.allfieldList as e>
        <result property="${e.fieldName}" column="${e.columnName}"/>
    </#list>
    </resultMap>

    <!--单条插入-->
    <insert id="insert" parameterType="${entity.className}" keyProperty="id" useGeneratedKeys="true">
        insert into
        <include refid="table"/>
        <trim prefix="(" suffix=")" suffixOverrides=",">
            version,createtime,deleted,
        <#list entity.myfieldList as e>
            <if test="${e.fieldName} != null">${e.columnName}<#if e_has_next>,</#if></if>
        </#list>
        </trim>
        values
        <trim prefix="(" suffix=")" suffixOverrides=",">
            0,${r"#{"}${"createTime"}${r"}"},${r"#{"}${"deleted"}${r"}"},
        <#list entity.myfieldList as e>
            <if test="${e.fieldName} != null">${r"#{"}${e.fieldName}${r"}"}<#if e_has_next>,</#if></if>
        </#list>
        </trim>
    </insert>

    <!--批量插入-->
    <insert id="insertBatch" parameterType="java.util.List" useGeneratedKeys="true">
        insert into
        <include refid="table"/>
        (
        <include refid="columns"/>
        )
        values
        <foreach collection="list" item="item" index="index" separator=",">
            (null,0,${r"#{"}${"item.createTime"}${r"}"},${r"#{"}${"item.deleted"}${r"}"},<#list entity.myfieldList as e>${r"#{"}
            item.${e.fieldName}${r"}"}<#if e_has_next>,</#if></#list>)
        </foreach>
    </insert>

    <!-- 根据主键查询 -->
    <select id="selectById" parameterType="long" resultMap="${entity.firstLowName}">
        select
        <include refid="columns"/>
        from
        <include refid="table"/>
        where
        id=${r"#{"}${"id"}${r"}"}
    </select>

    <!-- 根据主键批量查询 -->
    <select id="selectByIds" parameterType="java.util.List" resultMap="${entity.firstLowName}">
        select
        <include refid="columns"/>
        from
        <include refid="table"/>
        where id in
        <foreach collection="list" separator="," item="id" open="(" close=")">
        ${r"#{"}${"id"}${r"}"}
        </foreach>
    </select>


    <!-- 单条更新:version+1 实现乐观锁 -->
    <update id="update" parameterType="${entity.className}">
        update
        <include refid="table"/>
        <set>
            version = ${r"#{"}${"version"}${r"}"}+1 ,
            deleted = ${r"#{"}${"deleted"}${r"}"},
        <#list entity.myfieldList as e>            ${e.columnName} = ${r"#{"}${e.fieldName}${r"}"}<#if e_has_next>
            ,</#if>
        </#list>
        </set>
        <where>
            id = ${r"#{"}${"id"}${r"}"} and version = ${r"#{"}${"version"}${r"}"}
        </where>
    </update>

    <!-- 根据id彻底删除 -->
    <delete id="deleteById" parameterType="long">
        delete from
        <include refid="table"/>
        where
        id=${r"#{"}${"id"}${r"}"}
    </delete>

    <!-- 根据主键批量删除 -->
    <delete id="deleteByIds" parameterType="java.util.List">
        delete from
        <include refid="table"/>
        where
        id in
        <foreach collection="list" separator="," item="id" open="(" close=")">
        ${r"#{"}${"id"}${r"}"}
        </foreach>
    </delete>

    <!--片段list字段查询器-->
    <sql id="selectorFields">
        select
        <if test="fields != null">
        ${r"${"}${"fields"}${r"}"}
        </if>
        <if test="fields == null">
            <include refid="columns"/>
        </if>
        from
        <include refid="table"/>
        o
    </sql>

    <!--片段list字段查询器 ，仅供多表关联名称-->
    <sql id="selectorFieldsForPage">
        select
        <if test="fields != null">
        ${r"${"}${"fields"}${r"}"}
        </if>
        <if test="fields == null">
            <include refid="listcolumns"/>
        </if>
        from
        <include refid="table"/>
        o
        LEFT JOIN t_@TODO s ON o.@TODO=s.id
    </sql>

    <!--片段list条件判断-->
    <sql id="selectorWhere">
        <where>
            <if test="deleted != null and deleted !=''"> and o.deleted=${r"#{"}${"deleted"}${r"}"}</if>
        <#list entity.myfieldList as e>
            <if test="${e.fieldName} != null and ${e.fieldName} !=''">
                <if test="${e.fieldName}Like == false"> and o.${e.columnName}=${r"#{"}${e.fieldName}${r"}"}</if>
                <if test="${e.fieldName}Like == true"> and o.${e.columnName} like
                    CONCAT('%',${r"#{"}${e.fieldName}${r"}"},'%')
                </if>
            </if>
        </#list>
            <!--<if test="startTime != null"> and birthday <![CDATA[   >=  ]]>${r"#{"}${"startTime"}${r"}"} </if>
			<if test="endTime != null"> and  birthday <![CDATA[   <  ]]> ${r"#{"}${"endTime"}${r"}"}</if>
			-->
        </where>
    </sql>

    <!--片段list排序-->
    <sql id="selectorOrder">
        <if test="orderFields != null and orderFields.size >0">
            order by
            <foreach collection="orderFields" separator="," item="orderField">
                o.${r"${"}${"orderField.fieldName"}${r"}"} ${r"${"}${"orderField.order"}${r"}"}
            </foreach>
        </if>
    </sql>

    <!--片段list分页-->
    <sql id="selectorLimit">
        <if test="startRow != null">
            limit  ${r"#{"}${"startRow"}${r"}"},${r"#{"}${"pageSize"}${r"}"}
        </if>
    </sql>

    <!--查询所有记录-->
    <select id="selectList" parameterType="${entity.className}Query" resultMap="${entity.firstLowName}">
        <include refid="selectorFields"/>
        <include refid="selectorWhere"/>
        <include refid="selectorOrder"/>
    </select>

    <!-- 分页  优化后的  先limit 再 查-->
    <select id="selectListPage" parameterType="${entity.className}Query" resultMap="${entity.firstLowName}">
        select
        <if test="fields != null">
        ${r"${"}${"fields"}${r"}"}
        </if>
        <if test="fields == null">
            <include refid="listcolumns"/>
        </if>
        from (
        SELECT * from
        <include refid="table"/>
        o
        <include refid="selectorWhere"/>
        <include refid="selectorOrder"/>
        <include refid="selectorLimit"/>
        ) o
        LEFT JOIN t_school s ON o.school = s.id
        LEFT JOIN sys_area_province p ON o.province = p.provinceno
        LEFT JOIN sys_area_city c ON o.city = c.cityno
        LEFT JOIN sys_area_town t ON o.town = t.townno
    </select>

    <!--总条数-->
    <select id="selectListTotal" parameterType="${entity.className}Query" resultType="long">
        select count(1) from
        <include refid="table"/>
        o
        <include refid="selectorWhere"/>
    </select>

    <!--///////////////////////////////自定义/////////////////////////-->
    <!--获取最大排序号-->
    <select id="selectMaxSeq" resultType="int">
        select max(seq) from
        <include refid="table"/>
    </select>

    <!--校验Name是否存在-->
    <select id="selectCheckNameExit" resultType="long">
        select count(1) from
        <include refid="table"/>
        <where>
            <if test="name != null and  name !=''"> and name=${r"#{"}${"name"}${r"}"}</if>
            <if test="id != null and  id !=''"> and id!=${r"#{"}${"id"}${r"}"}</if>
        </where>
    </select>
</mapper>