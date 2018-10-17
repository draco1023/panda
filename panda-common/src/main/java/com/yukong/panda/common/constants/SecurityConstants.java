package com.yukong.panda.common.constants;

/**
 * @author: yukong
 * @date: 2018/10/9 15:10
 * @description: 安全配置常量
 */
public interface SecurityConstants {

    /**
     * token的header key
     */
   String TOKEN_HEADER = "Authorization";

   String CLOUD_PREFIX = "cloud_";

    /**
     * jwt 加密key
     */
   String SIGN_KEY = "CLOUD";

    /**
     * sys_oauth_client_details 字段
     */
   String CLIENT_FIELDS = "client_id, client_secret, resources_ids, scope, authorized_grant_types,"
           + "web_server_redirect_uri, authorities, access_token_validity,"
           + "refresh_token_validity, addition_information, autoapprove";

    /**
     * jdbcClientDetailsService查询sql
     */
   String BASE_FIND_STATEMENT = "select " + CLIENT_FIELDS + " from sys_oauth_client_details";

    /**
     * 默认查询语句
     */
   String DEFAULT_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by client_id";

    /**
     * 根据client_id查询
     */
   String DEFAULT_FIND_STATEMENT_BY_CLIENT_ID = BASE_FIND_STATEMENT + " where client_id = ?";

}
