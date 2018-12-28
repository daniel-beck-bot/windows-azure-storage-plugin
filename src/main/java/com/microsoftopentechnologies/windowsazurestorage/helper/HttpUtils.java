/*
 Copyright 2017 Microsoft Open Technologies, Inc.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package com.microsoftopentechnologies.windowsazurestorage.helper;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import java.io.File;
import java.io.UnsupportedEncodingException;

public final class HttpUtils {
    private static final HttpClient CLIENT = new HttpClient(new MultiThreadedHttpConnectionManager());

    public static HttpClient getClient() {
        return CLIENT;
    }

    public static PutMethod getStoragePutMethod(String url, File file) {
        PutMethod method = new PutMethod(url);
        //TODO add user-agent
//            method.addRequestHeader("User-Agent", pluginUserAgent);
//        method.addRequestHeader("x-ms-blob-type", "BlockBlob");
//        RequestEntity entity = new FileRequestEntity(file, null);
        RequestEntity entity = null;
        try {
            entity = new StringRequestEntity("fewaf", null, null);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        method.setRequestEntity(entity);
        return method;
    }

    private HttpUtils() {
    }
}
