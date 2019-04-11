package com.shumsg.tools;

import com.shumsg.model.entity.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.shumsg.model.UserConstRepository.LOGIN_WITH_SCHOOL;

/**
 * @program: management
 * @description: 上海大学登录接口
 * @author: ggmr
 * @create: 2018-07-29 17:45
 */
public class AuthTool {
    public static boolean getAuth(String studentId, String password) {
        try {

            String xmlFile = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                    "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                    "<soap:Body>" +
                    "<CheckUserLogin xmlns=\"www.lib.shu.edu.cn\">" +
                    "<UserID>" + studentId + "</UserID>" +
                    "<password>" + password + "</password>" +
                    "</CheckUserLogin>" +
                    "</soap:Body>" +
                    "</soap:Envelope>";
            StringBuilder responseStr = getMsg(xmlFile);
            int site1 = responseStr.indexOf("<CheckUserLoginResult>");
            char number = responseStr.charAt(site1 + 22);
            return number == '1';
        } catch (Exception e) {
            System.err.println("libLogin WebService Exception,无法链接图书馆学号/一卡通服务进行登录。如多次出现，请检查网络是否故障，或者请向信息化办公室求证libLogin WebService服务是否正常");
            return false;
        }
    }

    public static User getInfo(String studentId) {
        try {
            String xmlFile = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                    "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                    "<soap:Body>" +
                    "<GetStudentInfo xmlns=\"www.lib.shu.edu.cn\">" +
                    "<UserID>" + studentId + "</UserID>" +
                    "</GetStudentInfo>" +
                    "</soap:Body>" +
                    "</soap:Envelope>";
            StringBuilder responseStr = getMsg(xmlFile);

            User user = new User();
            int site1 = responseStr.indexOf("<GetStudentInfoResult><string>");
            String sub1 = responseStr.substring(site1 + 30);

            int site11 = sub1.indexOf("</string>");
            user.setActualName(sub1.substring(0, site11));

            int site2 = sub1.indexOf("<string>");
            String sub2 = sub1.substring(site2 + 8);

            int site3 = sub2.indexOf("<string>");
            String sub3 = sub2.substring(site3 + 8);

            int site33 = sub3.indexOf("</string>");

            user.setRegisterWay(LOGIN_WITH_SCHOOL);
            user.setSchool("上海大学");
            user.setDepartment(sub3.substring(0, site33));
            user.setStudentCardId(studentId);
            return user;
        } catch (Exception e) {
            System.err.println("验证过程中发生异常,一般是由于工号/学号无效!");
            return null;
        }
    }

    private static StringBuilder getMsg(String xmlFile) throws IOException {
        String urlStr = "http://202.120.121.204:8888/WebService/shulibLogin.asmx?WSDL";

        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        // 可以发送数据
        conn.setDoOutput(true);
        // 可以接收数据
        conn.setDoInput(true);
        // POST方法
        conn.setRequestMethod("POST");
        conn.connect();
        // 写入的POST数据
        OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8);
        osw.write(xmlFile);
        osw.flush();
        osw.close();
        // 读取响应数据
        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder responseStr = new StringBuilder();
        String tempStr;
        while ((tempStr = in.readLine()) != null) {
            responseStr.append(tempStr);
        }
        return responseStr;
    }
}
