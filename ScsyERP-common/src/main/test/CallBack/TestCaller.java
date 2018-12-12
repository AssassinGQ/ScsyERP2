package CallBack;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;
import java.util.zip.GZIPInputStream;

public class TestCaller {
    @Test
    public void test(){
        long timestamp = 1544061578000L;
        System.out.println(new Date().getTime());
//        final Button button = new Button("test");
//        button.OnClick(new OnClickListener() {
//            public void clickCallBack(String button_name) {
//                System.out.println("In callBackMethod:"+button_name+" is on click");
//            }
//        });
    }

    @Test
    public void testJSONArray(){
        JSONArray jsonArray_pre = new JSONArray();
        jsonArray_pre.add(1);
        jsonArray_pre.add(2);
        jsonArray_pre.add(3);
        jsonArray_pre.add(4);
        System.out.println(jsonArray_pre.toJSONString());
        JSONArray jsonArray_after = JSONArray.parseArray(jsonArray_pre.toJSONString());
        System.out.println(jsonArray_after.toJSONString());
    }

    @Test
    public void testJSONObject(){
        TestBean testBean = new TestBean("a", 1L, 2.2, TestEnum.Enum1);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(testBean, new ParserConfig());
        System.out.println(jsonObject.toJSONString());
    }

    @Test
    public void testRenameTo(){
        String path = "D:\\v";
        File rootFile = new File(path);
        File[] files = rootFile.listFiles();
        for(int i = 0; i < files.length; i++){
            if(files[i].isFile() && !files[i].isDirectory()){
                String file_name = files[i].getName();
                System.out.println("Handling : " + file_name);
                String[] tmp = file_name.split("\\.");
                file_name = tmp[0];
                String file_fix = tmp[1];
                if(file_name.startsWith("SVID")){
                    file_name = file_name.replace("SVID_", "");
                }else if(file_name.startsWith("连")){
                    file_name = file_name.replace("连接", "");
                    file_name = file_name.trim();
                    String[] strstmp, strs1, strs2;
                    strstmp = file_name.split(" ");
                    if(file_name.indexOf("-") == -1) {
                        strs1 = strstmp[0].split("_");
                        strs2 = strstmp[1].split("_");
                    }
                    else {
                        strs1 = strstmp[0].split("-");
                        strs2 = strstmp[1].split("-");
                    }
                    String year = strs1[0];
                    String month = strs1[1].length() == 1 ? "0"+strs1[1] : strs1[1];
                    String day = strs1[2].length() == 1 ? "0"+strs1[2] : strs1[2];
                    String hour = strs2[0].length() == 1 ? "0"+strs2[0] : strs2[0];
                    String min = strs2[1].length() == 1 ? "0"+strs2[1] : strs2[1];
                    String sec = strs2[2].length() == 1 ? "0"+strs2[2] : strs2[2];
                    file_name = year + month + day + "_" + hour + min + sec;
                }
                file_name += "." + file_fix;
                files[i].renameTo(new File(path + "\\" + file_name));
            }
        }
    }

    private void printArray(String[] strings){
        System.out.print("[");
        for(int i = 0; i < strings.length; i++) {
            if(i != 0){
                System.out.print(", ");
            }
            System.out.print(strings[i]);
        }
        System.out.println("]");
    }

    @Test
    public void testNewDate(){
        Date date = new Date();
        System.out.println(date);
    }

    @Test
    public void testGzip() throws UnsupportedEncodingException {
        String base64 = "SFRUUC8xLjEgMjAwIE9LDQpEYXRlOiBUaHUsIDA2IERlYyAyMDE4IDA0OjIyOjQwIEdNVA0KQ29udGVudC1UeXBlOiB0ZXh0L2h0bWw7IGNoYXJzZXQ9dXRmLTgNCkNvbm5lY3Rpb246IGtlZXAtYWxpdmUNClZhcnk6IEFjY2VwdC1FbmNvZGluZw0KVmFyeTogQWNjZXB0LUVuY29kaW5nDQpFeHBpcmVzOiBUaHUsIDE5IE5vdiAxOTgxIDA4OjUyOjAwIEdNVA0KUHJhZ21hOiBuby1jYWNoZQ0KQ2FjaGUtQ29udHJvbDogbm8tY2FjaGUsIG5vLXN0b3JlLCBtYXgtYWdlPTAsIG11c3QtcmV2YWxpZGF0ZQ0KWC1WaWEtSlNMOiAxN2M2NWI4LC0NClgtQ2FjaGU6IGJ5cGFzcw0KQ29udGVudC1MZW5ndGg6IDk0NzINCg0KeyJvdXRwdXQiOiJvS0VCQ1BxSmpDbjV0SVA0STFvTitmNDhBbERwRWJOZklic3VBV3h2anluODVwQ2g3UG5JNnBERVRINXFUMnJnVDRsZ0tGVFZsU09LbmdnQ3NrSjM3ZmFFXC9McGJnazZpbDhqdHlsSHpJR1hCSkdcL2c0czBYd0hNYjdvd3lqeU13ME1FVWNYKzNXUE9iREVTcDMxQW9zU2J4Q2pvV1pnblM0Skh1MlNYWWhuZ2pDSWhvUkFjak9lN1hvUkU0YkhVQ0FtT1dQaFV5NjN0MlJGWEh2ZW1ZVTlRSTdOWnhvN2NkUlFuTmtsSWJJSmdlZXBxSFkyMnlCU0VybWxIS2RTaEx1YjRHSHd2ZnRtNlJNc2RrSkQ2QnpnYkZubUpwa2h0WnVtN09ra2RpOVA2U2d2aUlOWUFhNUVPakpmV0hBM2tValdRVWJcLzNYNVwvTFJETnRXVHZvZWcwUUFMb3BpMVNHb2w3MXRjNlprRHdhQXh2bGswXC90TVY1a2hxS2NhZFd0eVBKT3crYUlzUVBRMDR6S1AzYmVXWkhMckFkdDRjUkNWRVpncjREMHZSSlFDVzJrMkFvaCsyb1d4dVBcL290a0RwXC9Ya1Q4M0JKUktJdStSNEtlZmNyc2hYZFdXR3l5U2dPdzlSSEZSdUFKekhRYlZ2VzVMcEE5RXJEVjNcL2tjSzF2WkZCMVk4VkhDVk5BcGM4blwvUDNsRUl5bDU2M3E3TVM4cTNQdDdJN2VSV3c3NEtqcUpPUmFrZUxpUkllWVhZSXZzdldoV3BxbTVycGE5M1NGOUxMWlJkM3A5bG5idjdGMjlDU1FESlBSTmJhRHo4WkxRT1h1cDBXODlpN29DSE1OWlFFOFwvN254TkpseksyYWUrK2FBRXF5U3YwXC9OUWNvZ29ZVkc4ZFhZNHJtNFRqQ0RVUERXK1RFd0lGTG5xN1FCZTU5bUpSenYyaFBNZDJwXC9ubjh5bFBSNjI2cEdwR3ZTS0VHZDFaOXNLU053ckhrd2FoZ01UUmZVbWNWRjZpWmdWVCtvSEtEUFZhWlJRVzREeDBCZ0kxSCs5MjYzK1wvY1wvdjNPZlU0U2duVGo4bWEyZ3hSTWhPNnNpNVFCbUtEU3NuckJEZWhNZGwrR09nejlxSDh5WkdhXC9XMWRwVlhWRzBXdzJnbU4wNDBxdHZIcXVFMkd5cGwxZU1cL2dUYkRpTkpUWmh5MlRsdWdFV1JyazhzbFZ0SUFNeE1GcVBJakZ2a096UGZlaU9GMVNFeXJoNUdwNFNpcWJFajVMYW1QU2xFbElDejZJRzh3VmV6U216SUs1enU5d0RYdDhVT1Q0RXNBcVZYamE1cVRmVDg1cENoN1BuSTZwREVUSDVxVDJyZ2pIZEFMZ0xzZEpEdE5RblBxRzdXRjFaN2NidDkzekozanBDSUZUQmJqVDFRNXRpY212SFRnMDNQWWVQYlA1SGpLbXdrQjBmQVhqaktNQVJTUDFvT1FEOFkybG40SzVNT0NMdThlWEw3ellabEVKVWFhbmYwUUlCb0NcLzRDRG5YUkJQWmxPUkRXWG92Tlh4Wk45SFg5eFErRThlQXF3QXBINkUwc09rT1ZcL1dFU05YelwvTlBsR2lxVThzSkRFR0lTcEgrYzV5MDJpeHorQk51XC9RVTdhYUQ4Qm9cL2RoTnlZNElzQUZPTHBNamp1XC9YYVdyVmJmZDRpVFl0MFFueDBneVNoOUFsMTdTSlBiTjFpRHdUU1pzeU5GYVl5SlVySkQ1QXVyUjJaUXNTenpUUkdzOGpBMVkxblJpcVFFNGhDZENmZ2k3eWxvaGdLVHJtbnA4UmpYckJITUNPYmpsM0RGeThBUUFKUHVHWUtqdEVuTlRvMGJDZ1llVnVTRWdjZU5US0hCU2syaHVFQ25yck8xS092NlVsTzh2cEJoVUUzalczWlJablV3ekxTaWNUejdYWXdqUjRBVW0wOFIrQkdHNEVjUWJqQnM1RFwvRXB5VUVcL3lXb3hFdWZSc2xPOUsrMGNwUnNDXC9rc0ZJMEw3Znc5eGNndVh4N25yMVppajZRZkFmeFk4NXpSbWVCRXlvRTdkSlwvbUI5SG1cL1hUTHdESG01akNIK3ZxMGFNT1FzSXZlXC9kMFVkOUFkNDArSWVBRUMzVDk2a3VpZTVkR0E3QlBlWjJ6Wk8xejFJMHVnSitrdWZ5K295d0lISWxZcTBWcWNPUWg2RWxoYVVLOFoxTkxNOG8wWkc0VDJhNmh2QTZRRDRBTE5iQWhVNUZYZ2d6cjJTUWxOS3RMQnhEblNYUGVZNDhrbjh2dXpiYkhDeDRKajh6aTdwM3hhZ1pVbHVERTM5WkgzMmhqbTNYMCs0dVwvc2pHYSt5R1J2YkEzcEdCYVRpaHZXVkcyb0I1Y1FPYWZTY1ZydVRsdkxkd2NGazdEXC9qMWlJajJxVVkrN0p2cnNKQXBnc1lpY3dybE1RN1JGaUE2YW5TSndVZnRxYlYwWXgzV25YNlZ0UWpqZWRKUlJqa3pxMDBkeW81VHY5WCsxeU1qbUx6SU12VlFSSGNZb29vMmV4YzAxb2JYeXlWdE42c09pTWJrYVNlUnRcL1JDQmNkRHgyQVdtd3YyN1Fpb0YzdDVNN1M1R2QzQjdnOTZ4c3J2a2pXT3M4bUFFdnpDenNBbWtsZGlZWXd4ZW04MGJGczg5aVVkU2Y1R3BYdW9MSDJMM2Y3c2dVcG5sb3JRd1JSeGY3ZFk4NXNNUktuZlVDaXh2ZDVMVWx6NkJpVm56UHpNNlpyTUVheTkzZDRXOGptSnRadjhRV3kzYTJcL3NOUjllWGRtdFVxaE5JTUsxVmZqRWhHeTYwc2ZzNk9jK29udzFnSlNWV0xPa3Z2YlFPRXpnWFIzQTlCVnY5SVE5dEg2SlZDaEJib2E3QkJjdVZoRUtnTmtLR0I5KzdFSmN3TWdQcWIrTGozN2E3U2NWalVDOXk3a0ZpQUo1b0xKaUl1TGFCTUVxYXhCNm9acDlKTUNlM0kyS3ByTkJaS3A5QVprbjhDYXhkRmc3Tng3aGNaOXJlWlpvTFhVRVRQXC9QYUZUR2dHc0c4ckE2SHo5emhCVmQrNlkrcm9tRUtBYlBydmZ0bWRYZmcxUHhTMUhaWW9FNFVwM3R2cFhZeTZzM0h3Q1ZCTjBXWEZ5ejcrcEZGUmlacTgxZVZaZStQdGhTSTltRHB6cGxickhUXC91Ym52XC9xSlMwTGx2aXZLUHA0ZDl3UENJNUF4dzR2bHN1eERLXC9yb0RJckxqMWhiQllBbm5cLzFnV205S1Rlc1RQdWhPRFZ3V0NEN2JPYmhvRjh3Vkl0bStLTjNPSHdWcmNWc0pITEI4bXNvWmJGS2ZTRmVWQktoNFdWajJjaWpxcXhWN3kwaksxeTUrVHJTQkNwbmROQ0ZjMU5nSzN4eFZseTd2V3JBYkdDZU0rWStpbU1YblA2T3A0ZEpQQmRrRWNpQ1BEV2c4TUxtanZBSUlvbHBsMmtOT01IVmVyZWhIK1RJYU1EcGlYTU1LVFhGenI2R211SHBMTUxXd3JWM3pMSXNXN0RlUWJWV2FDTUFXM1JxTXRaVG5ZeWFVYnlpMUhhaEZ3b3VOVW5vTFNQVGhEZVFqNmJ5VVhkRFJHYXZxUjFscFBHTnpDVEUyMW04OHpyeFBmNU5KVndsM3JaRVl2dmJuK1wvUjBPeVwvRW9XNk5VdVZUS1k2YmZuRDVcL1VwdjRcLzNmV0Y2RWVNa2RFc3cxQ056TkNLWVVvUjJzdnhcL20razAwcnBEa01QYXMyXC8yazlRWktMU0g2S2tqTlNkdHdMVXlHZ1hlb0pyVklSRm95TGR1V0JxeTlCdWJMUlFJcE9zanZLaysxYk9FYUJBcFc1NzZtK3drSzlDQ3UwMHJzMnlqRTk0RGN4MEtNTlp6VnlDSmZ3M2JaUEtnbVFtdks5YWhZQzZuMVh1Y2pqNXhOZno1dXUyN2N1dkZNWktKdzlvTEc0a3JDN3Bqb3N0RitHZ1pzSVo5ejMyWlNnY293Y2s3UXVJT2dJRDdSNFhHOTZ1TG5KYkt5c2RtQk91bDB3ZlpZXC84MmYweTVjV1R6XC81VjZnQVwvMElHRDhDWlk3YUZrSGl5dFhPb1hSR3hTbFd2NytNY0NhMU1kTmJlelRtV2hrMUg2S01ISGJYcW9RSGdLNmc0SjdqVmxmWjFZS0RUNzRlalIrbUtcL3ZhWk5sUjd4SE1EaWVFeDFxRzhMS29zV2loTlA3ZTB5WUFkd3ZLMzNBK0JKQ3pFMlVrdzdmNkpYV0NCN01kTUtidUF6bUpub0xUeDJRU2FJTkRyWXhkSEg5aEZmaThQXC9PQXNqK1lTMnJ1K1Y3MlJrZTJOeGF6YmI4MTh4TmlVdXZsU0xsNkpNRElTUGtPS0lMdEQ0OVJGN3p2Q0d6MmM2NTdqUUJhczJXK0d6eUJ1UDdSMkhpNldpSVh5emwrWFcyb1dBS0JTUTVxeE5FelFXd0xSQzFjdFJmRFRSWGdVb2pNQk9DT29LNHk4QWpEdGhCM3lRTHlGM2dmcUVSODlpOVU2VzJzYmt5THJyeUI0YURUZXM4dnNGK0FDbVdCTDFBUFVrcXdDSVV1V1FHWldYOWkwQ1QrU2hZOGFuSHBMa05RZ01NdXNyNU5YMExVaG9sXC9RY1RPYkMwMEYrXC9RVXhMWFZsYUk2Vm5VeHJlV2x5Vko1Y3VtN2RUWTFCRGdiT2pCV1orUG9EeElaVENxTUd1OGlaWXcxakx3dWpWWVNDWDh5QitCMStka3YrU2dvZWpiWUE2Q0RraVNyVWh2Kzl0bGhcL3ZDYlJVWVNpTGxqNE1DcldcL0NYcEJGakhINFg1cTRyR0o0ajVoQWZRc001bjRWUmdkSHdadDlHYzBOK3VYU1BaRG1EUmM0NnJ5WGpCVU1HbXBMUVFFQitPaHNubnZiYkFlMkM5RUxZTnNyaFhQRTJZQ0pwRFlQaitJWndUbEFVbnhFdytWQzdjXC9IcktoVzJoUWhwbTViRkowM1ZvejRxSjNzY3M1OUlvN0pSV3F6cmh4R0dmNXZ5aW5sUEptZWNLczFiY2t0RDFjMmlWS0RvUlNQZDN6XC9uRlNVdEZ5c3dxM3dua0hqaENLU3NFZm9FSXdJNGpGZXJ4UnZhWFhXa2lzK3NBbGZ6RjZseDZ4YWlybGVTNE5hWWdIcnlKMGFRNCtzOEhrYml0VEVhd2NzWTdBZCtndHhheEJjaWwrNTZLZ09raFJua04xNW02cDRcL2R6N2ZwUXhpdmtpOHdHcXpQOWRoZzBlZFhYbnpsQmZsc3ZXNzVFTGMzUUtiTjljMUpVZmd5XC81SFpWSU5nWGZLOERoWEFUQXFoUGpWXC95ZkZWNU5zZlhUdXdtTVwvTVdOUVwveG1rXC9SNHNFZ053RHVoN2VIMHBlVkRqUWRWa0c2cndNUDJkWU5xWUFQdHY2dGh4SFZwUjZuM2VIZzJVZFFnSWdcL3dZT21UU2JhT1NWUVRYR2tRVmNMeXgzYlp5aGZVMmlZRjhCQ2NiaDFhS0VaUWFxTDdscFNyZWIyTG90RnV1NENsZ3RLcklldXVReHBIZ3VocE1vSktKVkh0RHg2cEY3czB0UEZQZzRDYzh4VnQ3cUFoWXhmVjA1N1NzRWluaTFESEQzeHBmaExNMDFYRm56bVNWYURFSVdGYWxzcmQyZFFUS3l4M3Z1TmRDcFFYM0ZSTVJJXC9BQVVhYlhvbGpTZzFDNWtvVzJES3RWRzNia21MWDlaQ01QNjFHNk53NVZpVGN4RW1MYk5GZ1g5YjMyMTNKRGpxMEZ0QUd3TEt2YkxUTmRZajNUV21ibTR4UnNyUXJWTURIVTBMSmVmQldYWVlNbXE5dXRDVlNBOG9nWjFyQ0tRc3ZVbCtjTEJyTWt1UExieXZIUVY4dktVcXZQQVZmSmpvOEtYYmZIUDZaV2NvcThUdXBuZDloTVVoMmlxTUs5WkxOZmhJdDBVOVZcLzlUVEV4WHIxRVFEaGNMaUpXSGlxaTNhYk03SGt4OXVhZXhiYWhmUUs0eUxOOFlmaUN3UXhPUVpySGNaV2NqSlpHWjFmdWI2NVROeDBjVys2dW8wOWNZM2FMRm5sOENmOHg2YXhqZHFiY1wvZ1ppR2xoR2pKZGh4N3JCdFRVZzdKNERqMEpwTGg4SG9GWklCUERXTmJ1XC9SVDdxR3orK0ZyZHpKOUs0V0dsVHBwUWFsYVA4bDNvbWRUOFV0UjJXS0JPRktkN2I2VjJNdXJOeDhBbFFUZEZseGNzK1wvcVJSVVltUXJtckpFTkVSclpGTHVwb3lTK2ZmSVdRZ0FHd2J6cXdxYUhiQ2cxT3JUXC9SbUpOaTEzZUJoMjhOYTNWcXNnV3BVUzF1SytOVkdZVnJmXC80ck5DRUVaN1ZhVTlYbGs5MzdyaWVOWjJGUU14VXdKMTJUaW5lT2dEMDN6VUR0dktVNjZ2elhKK3g1NkVLdlp6V0xDUCs4XC9BNE0xN0dxbWgySXdrN3p4blBXN0JUaU5GeldNMXBwcTRuTDBTbHczNzBZbXRZQlhnUTdEZldheFluVXcrY3FtXC9SUEVhck1uQ2hBTytkMGVPS2c2S0tLVXF2UEFWZkpqbzhLWGJmSFA2Wldjb3E4VHVwbmQ5aE1VaDJpcU1LOVpMTmZoSXQwVTlWXC85VFRFeFhyMUVRRG0rdXNzM01ubGEybW5oeGcrZ3BRQldlVzlYWGQ5NmZxM21DSnFYVGlsNVNYK09tRnE5OElSaUlyTmszdUdMQVh3YkxPMzRjOHBiWjg1TGN3cmdlZFBFXC9XY0d2a25CY0ZJb2N3NnVvK3JTUkd2OGYrUHl5SStLczhEQWZQRkdPdnRMaTJUbENGR3BzV1BRZEg1SHFuMDFrK3FjNEZvZlVLZENkTTJCQlNsb01zYk8zUjhCMGdmeTI0RGpPUHFnc1lHM2VzMWFFWkdJM1ljV1NPN1BjNmNHQm1rRDFjZEpHbW4yeno4ajdMbjF6ckQxa2psTFBTSHNGMHFZZTVjN2lyUDdVREpJaTg0dVl1cjhWK0J4ZDRwQm1zZHhsWnlNbGtablYrNXZybE0zSFJ4YjdxNmpUMXhqZG9zV2VYd0pcL3pIcHJHTjJwdHorQm1JYVdFYU1sMkhFYmxvdWxLRm50Mm5oc2tmNXd4MmxXUVpydXY3RG8yTDduMEMwMGgxSTFvQjJMZDFicmY1VUNHSlwvYSt5VjhJUHB1bFFtemsxdlRKc2labXlock1FM3JTQW5ZZHNJT1ZKTUtFODI5XC8reFVrY2duYUpZQjhRQzFJblhkQmlERlZrNFRLMGdmZXNBSTJKYVNySEllWmNXeDlWR3ZlZWZPdG1ja01tamFpb3lFQ3NsT2k5MWF6VXdDRUdqUm5vK2p4dDRWMUJwNFg5Y1wvbDA1YVZNdjVSQmJNYm9cLzkyY3ZpNnhpSElEZTJDWEcxT0dGaFVHb3BoS2FwTThBc2FSOE54dVl4cnFXTjc0Z3BvT3hndmhpdmE4aXYwcDEzV0VNMkUzUDBtMDZVSHVEeVE4OFFsR29IV3hkMWFYMm5LKzhCMUJYR3dqVHRIZ2VsS1NSYzRhQ1pXVTNOUHlpRkpZMHlYT1h5TFF1emlCU1Bscjdtd2JWTmZVN1I3ZmJuTDU4dTZwa1krN0p2cnNKQXBnc1lpY3dybE1RNHorNEI1dlRUK2VkV0hOMnc5OENYMmtCWkpPZGV3SXFDVEZGR0VPM1R1WFwvK3dUYnFxZmljWnJsQzgrZ3RZd0VtVTU4S1BtMTI2dVdYZGZKUEhCZmVLcFlPU1pIbEdKVnJ6Yk9qNzZ4Y1NyRkVuUlgyblhvdVgwejFpVjRrUFgxUlwvU0NHbit3RExTRUQ5T3FmVU84TXErSUlcLzYwVnpcL2t5b0NNM1pyNEVleFwvRElnaSt4SVFVWlwvTGxHditQbitxYnRmZnBWYm9WQjd4RDlDSEdtWWtmY2NJZjV4cXA4dWZNWHVMcTJEY3BPS1RZVE1mMTNKamY5aVJCSXI2eDdiR09OV3ZlUEtYVlhUVXcrdzhNWlZMOFB5TldNc0xXdDBzejBhK0dVNmZZYmFSSTVSZEYyOHU5TTh1U1FlWG5zSGk4XC90UU1raUx6aTVpNnZ4WDRIRjNpa0dheDNHVm5JeVdSbWRYN20rdVV6Y2RIRnZ1cnFOUFhHTjJpeFo1ZkFuXC9NZW1zWTNhbTNQNEdZaHBZUm95WFljS0dUZUJqTlRwWFl4VVwvUHNVaTdNcXVMbmNKMUx6OUNuZXZSb1ZBK2hRaTRlNGNMUDRVeXlGVW0xbnllWDBZSG8yUVJ5SUk4TmFEd3d1YU84QWdpaVdtWGFRMDR3ZFY2dDZFZjVNaG93T21JOEhOR3V3aHhzTllLS3N6M05EdUJoSXpqcXlSM1drclJ5V2N0TElkeG02QkRYXC9kOFJpbFZYdmxzdXYrQlVnSDdyY1JWYkE0QTFqaEU1OEo5dkZcL0ZpcG90WDlZR2hvM3FOaUkxc0JYbkNtS2NIZVJuXC9ESFNVQUxKRVV1NTZUOWhUTzdsYk1nQ1FnTkk4TWpXamFUTDhOOER4T2FKdGp5TFY5b0hoaEdhTk1UeTE1RzkxekxhemhBdHkxTzVjbldiM1ZFdXZZVWxLblJzbzdNa3dqYk4rY0NUMkJlamE3bUIxTVJyQlZtXC9zUFF3M3NnYWRad05UQ3ZVK1cwT3dMUHRybUZDck5WNnZYamxlTEp1XC9kYXFYN2tlbkRsV2loQjBZdzRcL0VybzNHZ2tYMHI0YzYySkFBSWplQ2dFTXduUGlKbVpWS1BwTzJRbU1SbURRUGo1anNzMUF4Z3pFZkF3eVwvc2l3TjkwN1U5NkdhMHZmZ2FtN3pTT2pDaGZlU1ZQU2lzN0p4dVV4UDgzSHpFQlwvZ2RHejFDalRWVUtvb1F3ZmFmdnZDSHhSVzVsNTUzSktZSzZrOUhoU3F1K1dnS3J1b2pCZFduYzhRTXU0cFJHeTU4MlFyeW1lQU9lWWQ0Z0t0Wmg0Y3VjaVwvcnhia09BcFBCMXlubEx0N1FOVVFkQU1BMEQyMmwrN0srZ0NOazhDU2hcL1gxSFNsVVVrdkhibVwvbXRvY2RMdFdjVUQrMUF5U0l2T0xtTHFcL0ZmZ2NYZUtRWnJIY1pXY2pKWkdaMWZ1YjY1VE54MGNXKzZ1bzA5Y1kzYUxGbmw4Q2Y4eDZheGpkcWJjXC9nWmlHbGhHakpkaHlnTVd3Mnc5UnNSZUFhZlZxSnZKSEF0SlVHZzlHUjR3b2RGaVBwYlwvUHVHZnYwUkRpOFdrOENDNnVwN2hiMjNHN1pCSElnancxb1BEQzVvN3dDQ0tKYVpkcERUakIxWHEzb1JcL2t5R2pBNllqd2MwYTdDSEd3MWdvcXpQYzBPNEdFak9PckpIZGFTdEhKWnkwc2gzR2JvRU5mOTN4R0tWVmUrV3k2XC80RlNBZnV0eEZWc0RnRFdPRVRud24yOFg4V0lHbjE5ZWJkMzQ1N3E0cEJTT1RITjBBdXp3Qm1MckptQWdWT3VOZFwvamhyTXpZdkFNN1NiRnd5WEZuXC93T09HUFo4SEtQdThKZ0UxT1l0RnBrVTNrTzRDK2tMRUNzSkR0QmhnVE9nd2pzaklnTmo2SXBidHcxeDV0YlwvaHNQNWFKT3czS3lUNnV2OFh2ckNMRkR0a28rRkROdW0yS0x0VnJIcUM4V0VhVzhvZWpETlRcL0t3R1p5VUhMMExPb2FhRENXeGw0T1pYN2xweUlyMkVcL1BDbDBES2hNV0hkNUt2dFBNMFF4WDRVSlNUMXF6empaZVBWbVRcL2hQY3RDUFh5N29HRWJMclN4K3pvNXo2aWZEV0FsSlZZczZTKzl0QTRUT0JkSGNEMEZXXC8waEQyMGZvbFVLRUZ1aHJzRUZ5NVdFUXFmdmFhTU5ZcUZENXJPTHdOWWEwWlwvWVBQSzVZYnJmU1I3Vkdic2JTamJYemRmcDkwMmlnS0l2cFJqMnc3ZmxcLzNIeHEyTFk5XC93N1FPZ3JFZTFhNHVtRTJYNWFPRUdQQk5Femtyb1FRdzRkb21QajNuamJkb3RrSkZuYythOW9vVFRKdWRNczZlYnh6eXZ2QXAxblBWWG9LcXlmM000Y0RnSDl2ZlJPN1YwcVlNXC9XSlNmZmZSZzZqdHBlSUtwZzFKNXoxTHh3MEhVVDhSZDJMZkkxb1lTd1hXbWUzV3FUb0ZCbXMzUVFDcG1RWXkxbE9kakpwUnZLTFVkcUVYQ2k0MVNlZ3RJOU9FTjVDUHB2SlJkME5FWnErcEhXV2s4WTNNSk1UYldienpPdk1KKzN6WkZGRFgwbFdVTVNmXC9aMDF3cXI5NE5oekNNK3VEQ3hhV28zdFdVZlpqNDZqekFuTTlTT2tGZnA2dnFSWlRud28rYlhicTVaZDE4azhjRjk0cWxnNUprZVVZbFd2TnM2UHZyRnhLc1VTZEZmYWRlaTVmVFBXSlhpUTlmVkg5SUlhZjdBTXRJUVAwNnA5UTd3eXI0Z2pcL3JSWFArVEtnSXpkbXZnUjdIOE1pQ0w3RWhCUm44dVVhXC80K2Y2cGhWSmhhVVVjWG9IK1dvbE9VQ3RuVFVuenNZMGJEK3FWeEd3bXhmM2R1Q0VOaE14XC9YY21OXC8ySkVFaXZySHRzWTJwb056V2w0MldNZDlQV3dnd1VLUW9cL3RRTWtpTHppNWk2dnhYNEhGM2lrR2F4M0dWbkl5V1JtZFg3bSt1VXpjZEhGdnVycU5QWEdOMml4WjVmQW5cL01lbXNZM2FtM1A0R1locFlSb3lYWWNsUGtPQm1KUUJlQTF4elNLQ052VW9zTFJMZmNnMk5rVW8wTWI3Q09EUGs4c2tKM21ZTGI3RW9CNDZpakJyMnZNMlFSeUlJOE5hRHd3dWFPOEFnaWlXbVhhUTA0d2RWNnQ2RWY1TWhvd09tSThITkd1d2h4c05ZS0tzejNORHVCaEl6anF5UjNXa3JSeVdjdExJZHhtNkJEWFwvZDhSaWxWWHZsc3V2K0JVZ0g3cmNSVmJBNEExamhFNThKOXZGXC9GaTdDRjZxaENlWW5pS1p1alk1VkVwNjZ0S1BoV1wvQ3hrUm13d1A3dmlINkpITTJMd0RPMG14Y01seFpcLzhEamhqMm9rcDRGV2U2UlBFVXdkK01nTGFJa2dod0tMUGxEZk9PR0pXNUw3VlwvdklkKzJ1MG5GWTFBdmN1NUJZZ0NlYUN5WWlMaTJnVEJLbXNRZXFHYWZTVEFudHlOaXFhelFXU3FmUUdaSlwvQW1zWFJYOWhQb2Y0VjdOOWQ3aVNSdVY4SUVwWnE2aTdmSEJYa21NUCtcL0ZlcWZZQTJQaVV6N0t5SDFQWmkrN1EwY2RKWDFIUGE1XC9FMXVacVwvSVFkM3NhdTBBV05ubVl2M3lpRnhOMTNcLzR5WkdLdU9Zdm1pRytCM0lFckxoeEx2Z3BFdTRGU1N3Y3hFdCswZ01pcldYazNxSngxT1ZmOWw1RU5TUmVWREJIdnhOVkNnMXlNYjZJVnZ4dHlkbHRReGFFY1JlMGxnN0dGVjIxem5XSlAyUTZkMnpEOWNcL2NpVGV6cEhOdXlmY1BiUFgwYjg2RWh1XC96bUdvVDYwSmgwT1ZvR0hxYlN0bEsrRWw0b3M2aEdQbFdIeHVUV3JMT2ZkNDFPbjJrTnRja0wwbmxkMm53YktqaXp4UHZJVXJoOXZOMFZGeFg5TXVublg3SlFmZlR2WndidDZ0VWVzYks3NUkxanJQSmdCTDh3czdBSnBKWFltR01NWHB2Tkd4YlBQWWxIVW4rUnFWN3FDeDlpOTMrN0lGS1o1YUswTUVVY1grM1dQT2JERVNwMzFBb3NRNEFFbERBR21scVRTak10bVNtRGhkYWxNcmh4STZyOERMZEFWcllXQnJMdW5tcWhpbGNkdm9vYVEwbjNOVzkxZ3ErRlE2WGdTNFo2WWhHN0pwQ013bTlUWU05NFROcDlQZVZ1enhkd1lrQnVGd3dBUFlOa2VOM1FXVWpTZUVqMGVkc3Nkc0hRc0UyTlFiTnhQT1ExcTFGUGhGUWJ2UEFHa3lsMUV5cGE3aHVaSXpUTEpKSFh4Q2p5MmFmVmZHSzBGWEVKYjBCakdJc3dEVHhSVWdSNkdERlF2NUVHaGttaENLU1VNU0NycTBYZUpiK1M3RkJFMm92aTdqTnVCdzVQMXd0OHh5VmlcL3A3b0x4XC9FOHZkT3o4eVJtck93ZmNvb2tOUXV1bHlMODlOcHNRb2hmZjR6Ulo2c3NsTFV1dDBKSkdZT0c5bGI4aENDUm82OG1Id09mclhsbWVnZUFEWlNqeHVvdzFMWW1GamZlWlhuaCszbjJQVkFQUVN5NDZ0QW4yNXJTSEhHQ2J0MldWdUpnTGVyMDZ5TjdTUHBqZ0c4d1JjaTVLcVRwZnFTWGFWTTR0XC96WjlEZGlDQ0RqQURqRHpGbGYwVFhTa3VjbHNLaUY5RTdOZz0ifQ==";
        byte[] bytes = Base64.getDecoder().decode(base64);
        String raw = new String(bytes);
        String[] raws = raw.split("\\{");
        String outputJson = "{" + raws[1];
        JSONObject jsonObject = JSONObject.parseObject(outputJson);
        String output = jsonObject.getString("output");
        System.out.println(new String(Base64.getDecoder().decode(output), "UTF-8"));
//        System.out.println(raws.length);
//        String cutted = raw.substring(346);
//        System.out.println(new String(uncompress(cutted.trim().getBytes())));
    }

    private static byte[] uncompress(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
}
