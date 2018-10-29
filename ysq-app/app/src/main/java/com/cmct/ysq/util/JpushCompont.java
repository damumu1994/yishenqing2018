package com.cmct.ysq.util;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 极光推送
 */
public class JpushCompont {

    public static final Logger logger = LoggerFactory.getLogger(JpushCompont.class);

    private static final JPushClient jpushClient = new JPushClient(MyConstants.JPUSH_DevSecret, MyConstants.JPUSH_AppKey, 3);
    private static JpushCompont jpushCompont;

    public static synchronized JpushCompont getIntance() {
        if (jpushCompont == null) {
            jpushCompont = new JpushCompont();
        }
        return jpushCompont;
    }

    private JpushCompont() {
    }

    private static class MyRun implements Runnable {

        private Object object;
        private String alert;
        private String[] regIds;
        private String tag;

        public MyRun(Object object, String alert, String regId, String tag) {
            this.object = object;
            this.regIds = StringUtils.split(regId, ",");
            this.tag = tag;
            if (alert == null) {
                this.alert = "";
            } else {
                this.alert = alert;
            }
        }

        private int i = 0;

        @Override
        public void run() {

            try {
                if (StringUtils.isEmpty(alert)) {
                    return;
                }
                final String title = "全民皆商";
                if (StringUtils.isEmpty(tag)) {
                    return;
                }
                if (MyConstants.ifDebug) {
                    tag = "TEST_" + tag;
                }
                String json = JsonUtil.getJson(object);

                //IOS 和 Android 通知
                Notification notifi = Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(alert)
                                .setSound("Windows_Logon_Sound.wav")
                                .addExtra("json", json)
                                .setContentAvailable(true)
                                .build())
                        .addPlatformNotification(AndroidNotification
                                .newBuilder()
                                .setAlert(alert)
                                .setBuilderId(2)
                                .setTitle(title).addExtra("json", json).build())
                        .build();

                Audience.Builder audience = Audience
                        .newBuilder()
                        .addAudienceTarget(AudienceTarget.tag(tag));

                if (regIds.length > 0) {
                    audience.addAudienceTarget(AudienceTarget.registrationId(regIds));
                }

                PushPayload pushPayload = PushPayload.newBuilder()
                        .setPlatform(Platform.android_ios())
                        .setAudience(audience.build()).setNotification(notifi)
                        .build();
                pushPayload.resetOptionsApnsProduction(false);

                PushResult result = jpushClient.sendPush(pushPayload);
                if (MyConstants.ifDebug) {
                    logger.debug("TAG - " + tag + " - RESULT: " + result.toString());
                }
                i = 0;
            } catch (APIConnectionException e) {
                // Connection error, should retry later
                logger.error("Connection error, retrying....");
                i += 1;
                if (i <= 2) {
                    this.run();
                }
            } catch (APIRequestException e) {
                // Should review the error, and fix the request
                //没有满足条件的推送目标
                if (e.getErrorCode() != 1011) {
                    logger.error("Should review the error, and fix the request", e);
                    logger.info("HTTP Status: " + e.getStatus());
                    logger.info("Error Code: " + e.getErrorCode());
                    logger.info("Error Message: " + e.getErrorMessage());
                } else {
                    logger.error("JPUSH 1011 - TAG - " + tag);
                }
            }
        }
    }

    /**
     * 发送通知框信息
     *
     * @param object 不可超过2000个字节 这里1个汉字3字节
     * @param alert
     * @param regId
     * @param tag
     * @return
     */
    public boolean sendMessage(Object object, String alert, String regId, String tag) {
        MyConstants.executorService.submit(new MyRun(object, alert, regId, tag));
        return true;
    }

    /**
     * 不展示到通知栏
     *
     * @param object
     * @param regId
     * @param tag
     * @return
     */
    public boolean sendMessageNotAlert(Object object, String regId, String tag) {
        MyConstants.executorService.submit(new MyRun(object, null, regId, tag));
        return true;
    }
}
