<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.gasq.cloud.provider.${CONFIG.serverName}.dao.${entity.className}Dao">

    <sql id="table"> ${entity.tableName} </sql>
    <sql id="columns"> <#list entity.allfieldList as e>${e.columnName}<#if e_has_next>,</#if></#list> </sql>

    <resultMap id="${entity.firstLowName}" type="${entity.fullClassName}">
<#list entity.allfieldList as e>        <result property="${e.fieldName}" column="${e.columnName}" />
        </#list>
    </resultMap>

    <!--单条插入-->
    <#if CONFIG.idType==0><insert id="insert" parameterType="${entity.fullClassName}" keyProperty="id" useGeneratedKeys="true"></#if><#if CONFIG.idType==1><insert id="insert" parameterType="${entity.fullClassName}">
        <selectKey keyProperty="id" resultType="string" order="BEFORE">select replace(uuid(),'-','')</selectKey></#if>
        insert into
        <include refid="table" />
        <trim prefix="(" suffix=")" suffixOverrides=","><#if CONFIG.idType==1>id,</#if>
            <#if CONFIG.extendBaseEntity=="true">status,enable,create_time,update_time,create_user_id,create_user_name,</#if>
<#list entity.myfieldList as e>            <if test="${e.fieldName} != null">${e.columnName}<#if e_has_next>,</#if></if>
            </#list>
        </trim>
        values
        <trim prefix="(" suffix=")" suffixOverrides=","><#if CONFIG.idType==1>${r"#{"}${"id"}${r"}"},</#if>
            <#if CONFIG.extendBaseEntity=="true">'no','yes',now(),null,${r"#{"}${"createUserId"}${r"}"},${r"#{"}${"createUserName"}${r"}"},</#if>
<#list entity.myfieldList as e>            <if test="${e.fieldName} != null">${r"#{"}${e.fieldName}${r"}"}<#if e_has_next>,</#if></if>
            </#list>
        </trim>
    </insert>

    <!--批量插入-->
    <insert id="insertBatch" parameterType="java.util.List" <#if CONFIG.idType==0>useGeneratedKeys="true"</#if>>
        insert into
        <include refid="table" />
        (<include refid="columns" />)
        values
        <foreach collection="list" item="item" index="index" separator=",">
            (<#if CONFIG.idType==0>null</#if><#if CONFIG.idType==1>(select replace(uuid(),'-',''))</#if>,<#if CONFIG.extendBaseEntity=="true">'no','yes',now(),null,${r"#{"}${"item.createUserId"}${r"}"},${r"#{"}${"item.createUserName"}${r"}"},null,null,</#if><#list entity.myfieldList as e>${r"#{"}item.${e.fieldName}${r"}"}<#if e_has_next>,</#if></#list>)
        </foreach>
    </insert>

    <!-- 根据主键查询 -->
    <select id="selectById" resultMap="${entity.firstLowName}">
        <include refid="selectorFields" />
        where
        id=${r"#{"}${"id"}${r"}"}
    </select>

    <!-- 根据主键批量查询 -->
    <select id="selectByIds" resultMap="${entity.firstLowName}" >
        <include refid="selectorFields" />
        where id in
        <foreach collection="ids" separator="," item="id" open="(" close=")">
            ${r"#{"}${"id"}${r"}"}
        </foreach>
    </select>


    <!-- 单条更新 -->
    <update id="update" parameterType="${entity.fullClassName}">
        update
        <include refid="table" />
        <set>
        <#if CONFIG.extendBaseEntity=="true">
            <if test="status != null and status !=''">status = ${r"#{"}${"status"}${r"}"},</if>
            <if test="enable != null and enable !=''">enable = ${r"#{"}${"enable"}${r"}"},</if>
            update_time = now(),
            <if test="updateUserId != null and updateUserId !=''">update_user_id = ${r"#{"}${"updateUserId"}${r"}"},</if>
            <if test="updateUserName != null and updateUserName !=''">update_user_id = ${r"#{"}${"updateUserName"}${r"}"},</if>
        </#if>
<#list entity.myfieldList as e>            <if test="${e.fieldName} != null <#if e.fieldTypeClassName!="class java.util.Date">and ${e.fieldName} !=''</#if>">${e.columnName} = ${r"#{"}${e.fieldName}${r"}"}<#if e_has_next>,</#if></if>
            </#list>
        </set>
        <where>
            id = ${r"#{"}${"id"}${r"}"}
        </where>
    </update>

    <!-- 根据id假删除 -->
    <update id="deleteById" parameterType="<#if CONFIG.idType==0>long</#if><#if CONFIG.idType==1>string</#if>">
        update <include refid="table" /> set status='yes'<#if CONFIG.extendBaseEntity=="true">,update_time = now()</#if> where id=${r"#{"}${"id"}${r"}"}
    </update>

    <!-- 根据主键批量假删除 -->
    <update id="deleteByIds" parameterType="java.util.List">
        update <include refid="table" /> set status='yes'<#if CONFIG.extendBaseEntity=="true">,update_time = now()</#if> where id in <foreach collection="list" separator="," item="id" open="(" close=")"> ${r"#{"}${"id"}${r"}"} </foreach>
    </update>

    <!-- 根据id彻底删除 -->
    <delete id="removeById" parameterType="<#if CONFIG.idType==0>long</#if><#if CONFIG.idType==1>string</#if>">
        delete from <include refid="table" /> where id=${r"#{"}${"id"}${r"}"}
    </delete>

    <!-- 根据主键批量彻底删除 -->
    <delete id="removeByIds" parameterType="java.util.List">
        delete from <include refid="table" /> where id in <foreach collection="list" separator="," item="id" open="(" close=")"> ${r"#{"}${"id"}${r"}"} </foreach>
    </delete>

    <!--片段list字段查询器-->
    <sql id="selectorFields">
        select
        <if test="fields != null and fields !=''">
            ${r"${"}${"fields"}${r"}"}
        </if>
        <if test="fields == null or fields == ''">
            <include refid="columns" />
        </if>
        from  <include refid="table" />
    </sql>

    <!--片段list条件判断 注意:如果用 like查询，建议去掉前面的'%'，不然索引无效-->
    <sql id="selectorWhere">
        <where><#if CONFIG.extendBaseEntity=="true">
            <if test="status != null and status !=''"> and status=${r"#{"}${"status"}${r"}"} </if>
            <if test="enable != null and enable !=''"> and enable=${r"#{"}${"enable"}${r"}"} </if>
            <if test="startCreateTime != null"> and create_time <![CDATA[   >=  ]]>${r"#{"}${"startCreateTime"}${r"}"} </if>
            <if test="endCreateTime != null"> and  create_time <![CDATA[   <  ]]> ${r"#{"}${"endCreateTime"}${r"}"} </if>
            <if test="startUpdateTime != null"> and update_time <![CDATA[   >=  ]]>${r"#{"}${"startUpdateTime"}${r"}"} </if>
            <if test="endUpdateTime != null"> and  update_time <![CDATA[   <  ]]> ${r"#{"}${"endUpdateTime"}${r"}"} </if>
            <if test="createUserId != null and createUserId !=''">and createUserId=${r"#{"}${"createUserId"}${r"}"} </if>
            <if test="updateUserId != null and updateUserId !=''">and updateUserId=${r"#{"}${"updateUserId"}${r"}"} </if></#if>
<#list entity.myfieldList as e>            <if test="${e.fieldName} != null <#if e.fieldTypeClassName!="class java.util.Date">and ${e.fieldName} !=''</#if>">
                <if test="${e.fieldName}Like == false"> and ${e.columnName}=${r"#{"}${e.fieldName}${r"}"}</if>
                <if test="${e.fieldName}Like == true"> and ${e.columnName} like  CONCAT('%',${r"#{"}${e.fieldName}${r"}"},'%')</if>
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
                ${r"${"}${"orderField.fieldName"}${r"}"} ${r"${"}${"orderField.order"}${r"}"}
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
    <select id="selectList" parameterType="${entity.fullClassName}Query" resultMap="${entity.firstLowName}">
        <include refid="selectorFields" />
        <include refid="selectorWhere" />
        <include refid="selectorOrder" />
    </select>

    <!-- 分页 -->
    <select id="selectListPage" parameterType="${entity.fullClassName}Query" resultMap="${entity.firstLowName}">
        <include refid="selectorFields" />
        <include refid="selectorWhere" />
        <include refid="selectorOrder" />
        <include refid="selectorLimit" />
    </select>

    <!--总条数-->
    <select id="selectListTotal" parameterType="${entity.fullClassName}Query" resultType="long">
        select count(1) from <include refid="table" />
        <include refid="selectorWhere" />
    </select>

    <!--///////////////////////////////自定义/////////////////////////-->
    <!--校验Name是否存在-->
    <select id="selectCheckNameExit" resultType="long">
        select count(1) from <include refid="table" />
        <where>
            and name=${r"#{"}${"name"}${r"}"}
            <if test="id != null and  id !=''"> and id!=${r"#{"}${"id"}${r"}"}</if>
        </where>
    </select>
</mapper>