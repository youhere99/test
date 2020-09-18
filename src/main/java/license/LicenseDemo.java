package license;


import com.javax0.license3j.licensor.License;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class LicenseDemo {

    private static final String pubKey = "C:\\Users\\GEEK\\Desktop\\license3j\\pub.asc";
    private static final String serKey = "C:\\Users\\GEEK\\Desktop\\license3j\\ser.asc";
    private static final String license = "C:\\Users\\GEEK\\Desktop\\license3j\\demo.license";
    private static final String plant = "C:\\Users\\GEEK\\Desktop\\license3j\\plant.txt";
    private static final String encode = "utf-8";
    private static final String pass = "123456";


    public static void main(String[] args) throws Exception {
        File licenseFile = new File(license);
        // license 文件生成
        OutputStream os = new FileOutputStream(licenseFile);
        License license1 = new License();
        // license 的原文
        license1.setLicense(new File(plant), encode)
                // 私钥与之前生成密钥时产生的USER-ID
                .loadKey(serKey, "qiandu");
        // 生成密钥时输入的密码
        os.write(license1.encodeLicense(pass).getBytes(encode));
        os.close();
        // licence 文件验证
        License license2 = new License();
        if (license2
                .loadKeyRing(pubKey, null)
                .setLicenseEncodedFromFile(LicenseDemo.license, encode).isVerified()) {
            System.out.println(license2.getFeature("edition"));
            System.out.println(license2.getFeature("valid-until"));
        }

    }

}