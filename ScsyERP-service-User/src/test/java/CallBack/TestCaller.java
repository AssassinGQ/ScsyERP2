package CallBack;

import cn.AssassinG.ScsyERP.User.facade.entity.Admin;
import org.junit.Test;

import java.io.File;
import java.util.Date;

public class TestCaller {
    @Test
    public void test(){
//        System.out.println(new Date().getTime());
        System.out.println(Admin.class.getSimpleName());
//        final Button button = new Button("test");
//        button.OnClick(new OnClickListener() {
//            public void clickCallBack(String button_name) {
//                System.out.println("In callBackMethod:"+button_name+" is on click");
//            }
//        });
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
}
