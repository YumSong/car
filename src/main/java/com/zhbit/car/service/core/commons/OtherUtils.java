package com.zhbit.car.service.core.commons;

import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 零散工具类
 * Created by lgj on 2016/9/13.
 */
public class OtherUtils {

    /**
     * 校验手机格式
     * @param phone     手机号
     * @return
     */
    public static boolean checkPhone(String phone) {
        String re = "(^(13\\d|14[57]|15[^4,\\D]|17[678]|18\\d)\\d{8}|170[059]\\d{7})$";
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(phone);
        while (matcher.find()) {
            return true;
        }
        return false;
    }

    /**
     * 生成固定位数的随机数
     * @param length    长度
     * @return
     */
    public static String generateNumber(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append("0123456789".charAt(random.nextInt("0123456789".length())));
        }
        return sb.toString();
    }


    /**
     * 删除Html标签
     *
     * @param inputString
     * @return
     */
    public static String htmlRemoveTag(String inputString) {
        if (inputString == null)
            return null;
        String htmlStr = inputString; // 含html标签的字符串
        String textStr = "";
        Pattern p_script;
        Matcher m_script;
        Pattern p_style;
        Matcher m_style;
        Pattern p_html;
        Matcher m_html;
        try {
            //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
            //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签
            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签
            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签
            textStr = htmlStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textStr;// 返回文本字符串
    }


    /**
     * 从业资格证查询
     *
     * @param xingMing
     * @param shenFenZheng
     * @return
     * @throws IOException
     */
//    public static List<PractitionersInfo> congYeRenYuanZigeZheng(String xingMing, String shenFenZheng) throws IOException {
//        HttpClient client = new DefaultHttpClient();
//        HttpPost post = new HttpPost("http://58.62.172.116:40081/Modules/Practitioner/Certification.aspx");
//        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
//        formParams.add(new BasicNameValuePair("ctl00$MainContent$txtPersonName", xingMing));
//        formParams.add(new BasicNameValuePair("ctl00$MainContent$txtIdentityCardNumber", shenFenZheng));
//        formParams.add(new BasicNameValuePair("ctl00$MainContent$btnSubmits", "查询"));
//        formParams.add(new BasicNameValuePair("__VIEWSTATE",
//                "/wEPDwULLTE5NTA0MTgyODIPZBYCZg9kFgICAQ9kFgICAQ9kFgICAQ9kFgQCBQ8WAh4GaGVpZ2h0BQM4NSVkAgYPFgIeB1Zpc2libGVoZGRPBX+Qa7qaBWazFz5KU0tSrOjo8NIAabtJWveC1CzTpw=="));
//        formParams.add(new BasicNameValuePair("__EVENTVALIDATION",
//                "/wEdAAQAor7reT9ZIyIaT8kFwnu3FIJj/k5V2CIlE6PLIQgxR+zLokK3ldQVi8Vftcm4dsB09JyAJnd58EGqMFa6Es3tDOpeREhOZb5O0HJBud0roPXNA4mYnty2lY21xh4t/VY="));
//        post.setEntity(new UrlEncodedFormEntity(formParams, "utf-8"));
//        HttpResponse response = client.execute(post);
//        HttpEntity entity = response.getEntity();
//        String webString = EntityUtils.toString(entity);
//        post.releaseConnection();
//        String regex = "/Modules/Practitioner/CertifiselectResult\\.aspx\\?DianNaoHao=\\d+";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(webString);
//        String url = null;
//        while (matcher.find()) {
//            url = matcher.group();
//        }
//        HttpGet httpGet = new HttpGet("http://58.62.172.116:40081/" + url);
//        HttpResponse httpResponse = client.execute(httpGet);
//        HttpEntity entity1 = httpResponse.getEntity();
//        String webString1 = EntityUtils.toString(entity1);
//        httpGet.releaseConnection();
//        String webString2 = webString1.replaceAll("\\s*|\t|\r|\n", "");
//        String regex1 = "<td>[\\s\\S]*?</td>";
//        Pattern pattern1 = Pattern.compile(regex1);
//        Matcher matcher1 = pattern1.matcher(webString2);
//        List<String> list1 = new ArrayList<>();
//        while (matcher1.find()) {
//            list1.add(matcher1.group().replaceAll("<td>", "").replaceAll("</td>", ""));
//        }
//        PractitionersInfo practitionersInfo = new PractitionersInfo();
//        List<PractitionersInfo> practitionersInfoList = new ArrayList<>();
//        if(list1.size()>0){
//            List<String> list = list1.subList(3, 15);
//            practitionersInfo.setName(list.get(0));
//            practitionersInfo.setSex(list.get(1));
//            practitionersInfo.setBirthday(list.get(2));
//            practitionersInfo.setPractNum(list.get(3));
//            practitionersInfo.setCardAddress(list.get(4));
//            practitionersInfo.setFirstPractDate(list.get(5));
//            practitionersInfo.setGetPractDate(list.get(6));
//            practitionersInfo.setPractEffectiveDate(list.get(7));
//            practitionersInfo.setIssuingOffice(list.get(8));
//            practitionersInfo.setServiceOffice(list.get(9));
//            practitionersInfo.setPractOrderNum(list.get(11));
//            practitionersInfoList.add(practitionersInfo);
//        }
//        return practitionersInfoList;
//    }

}
