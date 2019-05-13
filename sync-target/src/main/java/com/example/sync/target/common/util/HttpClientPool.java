package com.example.sync.target.common.util;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * @author yuming
 * @date 2019/1/20
 */
class HttpClientPool {
    private static PoolingHttpClientConnectionManager connectionManager;

    static {
        connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(200);
        // 主机最大连接数,即指向目标ip的最大连接数
        connectionManager.setDefaultMaxPerRoute(20);
    }

    static CloseableHttpClient getClient() {
        return HttpClients.custom().setConnectionManager(connectionManager).build();
    }
}
