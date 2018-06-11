# SharedPreferencesHelper
[![](https://jitpack.io/v/plenalam/SharedPreferencesHelper.svg)](https://jitpack.io/#plenalam/SharedPreferencesHelper)
Android SharedPreferences 操作类

## 部署
project的build.gradle添加
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
app build.gradle添加
```
	dependencies {
	        implementation 'com.github.plenalam:SharedPreferencesHelper:0.0.1'
	}
```
## 使用
新建SharedPreferencesHelper继承BaseSharedPreferencesHelper

并定义自己的DEFAULTNAME和KEYSTORE
```
public class SharedPreferencesHelper extends BaseSharedPreferencesHelper {
    private static SharedPreferencesHelper defaultSharedPreferencesHelper;

    @Override
    public void initDefaultValue() {
        DEFAULTNAME = "mydefaultname";
        KEYSTORE = "1234567887654321";
    }

    public SharedPreferencesHelper(Context context, String name) {
        super(context, name);
    }

    public static SharedPreferencesHelper getDefaultSharedPreferencesHelper() {
        context = MyApplication.getInstance();
        return new SharedPreferencesHelper(MyApplication.getInstance(), DEFAULTNAME);
    }
}

```
#### 存数据
```
SharedPreferencesHelper.getDefaultSharedPreferencesHelper()
  .put("key", "value")
  .put("intkey", 12)
  .putEncryptSting("password", "123455")
  .commit();
```
#### 取数据
```
SharedPreferencesHelper.getDefaultSharedPreferencesHelper().get("key",null);
```
