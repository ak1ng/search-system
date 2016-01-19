package com.daimamingong.common.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtils {

    private static final String parameterJoin = "&";
    private static final String parameterEqual = "=";

    public static String makeUrl(String baseUrl, Map<String, String> parameterMap) {
        StringBuilder parasb = new StringBuilder(baseUrl);
        if (null != parameterMap) {
            parasb.append("?");
            for (Map.Entry<String, String> entry : parameterMap.entrySet()) {
                parasb.append(entry.getKey()).append(parameterEqual).append(entry.getValue()).append(parameterJoin);
            }
        }
        return parasb.substring(0, parasb.length() - 1);
    }

    public static String appendParameter(String baseUrl, Map<String, String> parameterMap) {
        StringBuffer parasb = new StringBuffer(baseUrl);
        if (null != parameterMap) {
            parasb.append(parameterJoin);
            for (Map.Entry<String, String> entry : parameterMap.entrySet()) {
                String val;
                try {
                    val = URLEncoder.encode(entry.getValue(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    val = entry.getValue();
                }
                parasb.append(entry.getKey()).append(parameterEqual).append(val).append(parameterJoin);
            }
        }
        return parasb.substring(0, parasb.length() - 1);
    }

    public static String get(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("Accept-Encoding", "gzip,deflate");
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.57 Safari/537.36");
            response = httpclient.execute(httpGet);
            InputStream inputStream = response.getEntity().getContent();
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            StringBuffer resultString = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                resultString.append(line);
            }
            return resultString.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response)
                    response.close();
                httpclient.close();
            } catch (IOException ignore) {
                ignore.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        String s = get("http://localhost:8080/videoinfo/get/1");
        System.out.println(s);
    }

    public static String get(String url, Map<String, String> params) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            String newUrl = appendParameter(url, params);
            HttpGet httpGet = new HttpGet(newUrl);
            response = httpclient.execute(httpGet);
            InputStream inputStream = response.getEntity().getContent();
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuffer resultString = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                resultString.append(line);
            }
            return resultString.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response)
                    response.close();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String post(String url, Map<String, String> params) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            for (String key : params.keySet()) {
                nameValuePairs.add(new BasicNameValuePair(key, params.get(key)));
            }
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("User-Agent", "");
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));

            response = httpclient.execute(httpPost);
            InputStream inputStream = response.getEntity().getContent();
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            StringBuilder resultString = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                resultString.append(line);
            }
            return new String(resultString.toString().getBytes(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response)
                    response.close();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 上标
     */
    public static String sbPost(String url, Map<String, String> params) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            for (String key : params.keySet()) {
                nameValuePairs.add(new BasicNameValuePair(key, params.get(key)));
            }
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));

            response = httpclient.execute(httpPost);
            InputStream inputStream = response.getEntity().getContent();
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    inputStream));

            String line;
            StringBuilder resultString = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                resultString.append(line);
            }
            return resultString.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response)
                    response.close();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String commonPost2(String url, Map<String, String> params) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            for (String key : params.keySet()) {
                nameValuePairs
                        .add(new BasicNameValuePair(key, params.get(key)));
            }
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));

            response = httpclient.execute(httpPost);
            InputStream inputStream = response.getEntity().getContent();
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    inputStream));

            String line;
            StringBuilder resultString = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                resultString.append(line);
            }
            return resultString.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response)
                    response.close();
                httpclient.close();
            } catch (Exception ignore) {
            }
        }
        return null;
    }
}
