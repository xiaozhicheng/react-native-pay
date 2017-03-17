package com.reactnativepay.alipay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.reactnativepay.PayListener;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 支付SDK
 */
public class AliPay {
    private Activity activity;
    private PayListener listener;

    public static final int SDK_PAY_FLAG = 1;
    public static final int SDK_CHECK_FLAG = 2;

    public AliPay(Activity activity) {
        this.activity = activity;
    }

    public void pay(AlipayInfo info,PayListener listener) {
        this.listener=listener;
        orderNum=info.getOutTraceNo();
        // 订单
        String orderInfo = getOrderInfo(info);
        // 对订单做RSA 签名
        String sign = SignUtils.sign(orderInfo,info.getPrivateRsa());
        try {
            // 仅需对sign 做URL编码
            sign = URLEncoder.encode(sign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 完整的符合支付宝参数规范的订单信息
        final String payInfo = orderInfo + "&sign=\"" + sign + "\"&"
                + getSignType();

        Log.i("ksdinf",payInfo);

        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(activity);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(payInfo,true);

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }


    /**
     * 获取签名方式
     *
     */
    public String getSignType() {
        return "sign_type=\"RSA\"";
    }


    /**
     * 获取支付宝SDK版本号
     */
    public String getSDKVersion() {
        PayTask payTask = new PayTask(activity);
        return  payTask.getVersion();
    }

    /**
     * 创建订单信息
     * @param alipayInfo 支付信息
     */
    private String getOrderInfo(AlipayInfo alipayInfo) {
        // 签约合作者身份ID
        String orderInfo = "partner=" + "\"" + alipayInfo.getPartner() + "\"";

        // 签约卖家支付宝账号
        orderInfo += "&seller_id=" + "\"" +alipayInfo.getSellerId() + "\"";

        // 商户网站唯一订单号
        orderInfo += "&out_trade_no=" + "\"" + alipayInfo.getOutTraceNo() + "\"";

        // 商品名称
        orderInfo += "&subject=" + "\"" + alipayInfo.getSubject() + "\"";

        // 商品详情
        orderInfo += "&body=" + "\"" + alipayInfo.getBody() + "\"";

        // 商品金额
        orderInfo += "&total_fee=" + "\"" + alipayInfo.getMoney() + "\"";

        // 服务器异步通知页面路径
        orderInfo += "&notify_url=" + "\"" + alipayInfo.getNotifyUrl()
                + "\"";

        // 服务接口名称， 固定值
        orderInfo += "&service=\"mobile.securitypay.pay\"";

        // 支付类型， 固定值
        orderInfo += "&payment_type=\"1\"";

        // 参数编码， 固定值
        orderInfo += "&_input_charset=\"utf-8\"";

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        orderInfo += "&it_b_pay=\"30m\"";

        // extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
        // orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
        orderInfo += "&return_url=\"m.alipay.com\"";

        // 调用银行卡支付，需配置此参数，参与签名， 固定值 （需要签约《无线银行卡快捷支付》才能使用）
        // orderInfo += "&paymethod=\"expressGateway\"";

        return orderInfo;
    }

    /**订单号**/
    private String orderNum;
    @SuppressLint("HandlerLeak") private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);
                    // 支付宝返回此次支付结果及加签，建议对支付宝签名信息拿签约时支付宝提供的公钥做验签
                    String resultInfo = payResult.getResult();
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        listener.onPaySuccess(resultInfo);
                    } else {
                        // 判断resultStatus 为非“9000”则代表可能支付失败
                        // “8000”代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            listener.onPayConfirm(resultInfo);
                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            listener.onPayFail(resultInfo);
                        }
                    }
                    break;
                }
                case SDK_CHECK_FLAG: {
                    Toast.makeText(activity, "检查结果为：" + msg.obj,
                            Toast.LENGTH_SHORT).show();
                    break;
                }
                default:
                    break;
            }
        };
    };
}
