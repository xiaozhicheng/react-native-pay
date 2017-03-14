##React-Native-Pay
用于微信，支付宝支付

###如何安装

1.首先安装npm包

	npm install react-native-paysdk --save
2.link

	rnpm link react-native-paysdk
手动link~（如果不能够自动link）

####Android

	// file: android/settings.gradle
		...
 
		include ':react-native-wx'
		project(':react-native-wx').projectDir = new File(settingsDir, '../node_modules/react-native-wx/android')


	// file: android/app/build.gradle
	...
	 
	dependencies {
	    ...
	    compile project(':react-native-wx')
	}

android/app/src/main/java/<你的包名>/MainApplication.java中添加如下两行：


	...
	import cn.reactnativepay.payment.PayPackage;  // 在public class MainApplication之前import 
	 
	public class MainApplication extends Application implements ReactApplication {
	 
	  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
	    @Override
	    protected boolean getUseDeveloperSupport() {
	      return BuildConfig.DEBUG;
	    }
	 
	    @Override
	    protected List<ReactPackage> getPackages() {
	      return Arrays.<ReactPackage>asList(
	          new PayPackage(), // 然后添加这一行 
	          new MainReactPackage()
	      );
	    }
	  };
	 
	  @Override
	  public ReactNativeHost getReactNativeHost() {
	      return mReactNativeHost;
	  }
	}

###如何使用
####Android
		
1.支付宝
	申请自己支付宝商户账号，获取到PARTNER，SELLER，RSA_PRIVATE三个值
	
	import RnPay from 'react-native';

	onAliPay(){
		var params = {
			money:'',
			subject:'',
			partner:'',
			body:'',
			sellerId:'',
			outTraceNo:'',
			notifyUrl:'',
			privateRsa:''
		}
		RnPay.onAliPay(params)
			.then((res)=>{
			})
			.catch(e=>{
			})
     }

2.微信
	申请商户，并获取到APPID，

	import RnPay from 'react-native';

	onWxPay(){
		var params = {
			money:'',
			appid:'',
			partnerid:'',
			parpayid:'',
			packageValue:'',
			noncestr:'',
			timestamp:'',
			sign:''
		}
		RnPay.onWxPay(params)
			.then((res)=>{
			})
			.catch(e=>{
			})
     }

以上所有未知参数 皆可从后台人员获知
