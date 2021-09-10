package tech.pdai.springboot.sms.ali.service;

import java.util.Collections;
import java.util.List;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.teaopenapi.models.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.pdai.springboot.sms.ali.config.SmsConfig;
import tech.pdai.springboot.sms.ali.util.JsonUtil;

/**
 * @author pdai
 */
@Slf4j
@Service
public class SmsServiceImpl {

    private final SmsConfig smsConfig;

    /**
     * @param smsConfig smsConfig
     */
    public SmsServiceImpl(final SmsConfig smsConfig) {
        this.smsConfig = smsConfig;
    }

    /**
     * demo.
     *
     * @param param param
     */
    public void sendSMSDefault(String param) {
        try {
            log.info(param);
            sendSms(Collections.singletonList("13110101010"),
                    "SM_xxxxxxx", "Java全栈", param);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * send sms.
     *
     * @param pNos          phone num
     * @param templateCode  template code
     * @param signName      sign name
     * @param templateParam template param
     * @throws Exception Exception
     */
    public void sendSms(List<String> pNos, String templateCode, String signName, String templateParam)
            throws Exception {
        Config config = new Config()
                .setAccessKeyId(smsConfig.getAccessKeyId())
                .setAccessKeySecret(smsConfig.getAccessKeySecret())
                .setEndpoint(smsConfig.getDomain())
                .setConnectTimeout(10000)
                .setReadTimeout(10000);
        com.aliyun.dysmsapi20170525.Client client = new com.aliyun.dysmsapi20170525.Client(config);
        for (String pNo : pNos) {
            SendSmsRequest sendSmsRequest = new SendSmsRequest()
                    .setPhoneNumbers(pNo)
                    .setSignName(signName)
                    .setTemplateCode(templateCode)
                    .setTemplateParam(templateParam);
            log.info(JsonUtil.toJson(client.sendSms(sendSmsRequest)));
        }
    }

    /**
     * send sms.
     *
     * @param pNo           phone num
     * @param templateCode  template code
     * @param signName      sign name
     * @param templateParam template param
     * @throws Exception Exception
     */
    public void sendSms(String pNo, String templateCode, String signName, String templateParam)
            throws Exception {
        sendSms(Collections.singletonList(pNo), templateCode, signName, templateParam);
    }

}
