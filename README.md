React-Native-Pay
用于微信，支付宝支付

如何安装

1.首先安装npm包
	npm install react-native-paysdk --save
2.link
	rnpm link react-native-paysdk或者 react-native link react-native-paysdk


手动link~（如果不能够自动link）
Android

	file: android/settings.gradle
		...
 
		include ':react-native-paysdk'
		project(':react-native-paysdk').projectDir = new File(settingsDir, '../node_modules/react-native-paysdk/android')


	file: android/app/build.gradle
	...
	 
	dependencies {
	    ...
	    compile project(':react-native-paysdk')
	}

android/app/src/main/java/<你的包名>/MainApplication.java中添加如下两行：

	...
	import cn.reactmodule.PayPackage;  // 在public class MainApplication之前import
	 
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


如何使用

1.支付宝(签名由后端生成返回)
    [链接点进去可以看到后端各语言生成orderString方式](https://doc.open.alipay.com/docs/doc.htm?spm=a219a.7629140.0.0.RLJecF&treeId=54&articleId=106370&docType=1)

	import RNPay from 'react-native-paysdk';

	onAliPay(){
		var params = {
			orderString:''
		}
		RNPay.onAliPay(params)
			.then((res)=>{
			})
			.catch(e=>{
			})
     }

     orderString是后台对参数已经加签后的值

2.微信
	import RnPay from 'react-native-paysdk';

	onWxPay(){
		var params = {
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

    所有未知参数 皆可从后台人员获知
