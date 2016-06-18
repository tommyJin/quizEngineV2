package uk.ac.ncl.csc8499.controller.teacher;

import com.jfinal.ext.route.ControllerBind;
import com.jfinal.kit.PathKit;
import com.jfinal.upload.UploadFile;
import uk.ac.ncl.csc8499.controller.BaseController;
import uk.ac.ncl.csc8499.model.ConstantParas;
import uk.ac.ncl.csc8499.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by tommy on 2016/5/27.
 */
@ControllerBind(controllerKey = "/teacher/upload")
public class UploadController extends BaseController {
    public void upload_img(){
        User u = getCurrentUser();
        System.out.println("enter upload img");
        UploadFile file = getFile("imgFile", "tmp", 1024 * 1024);
        String oldName = file.getFileName();
        String fileExt = oldName.substring(oldName.lastIndexOf(".") + 1).toLowerCase();
        boolean isFail =true;
        HashMap<String, String> extMap = new HashMap<String, String>();
        extMap.put("image", "gif,jpg,jpeg,png,bmp");
        if(Arrays.<String>asList(extMap.get(getPara("dir")).split(",")).contains(fileExt)){
            isFail=false;
        }
        if (isFail) {
            setAttr("error", ConstantParas.upload_failed);
            setAttr("message", ConstantParas.upload_failed_wrong_format);
        }
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." +fileExt;
            String savePath= PathKit.getWebRootPath()+"/pic/"+ u.get("username")+"/" +newFileName;
            File ff=new File(PathKit.getWebRootPath()+"/pic/"+ u.get("username")+"/");
            if(!ff.exists())
                ff.mkdirs();
            System.out.println(savePath);
            writeTo(file.getFile(), new File(savePath));
            setAttr("error", 0);
            setAttr("url", "/pic/"+ u.get("username")+"/"+newFileName);
            System.out.println(savePath);
        } catch (Exception e) {
            setAttr("error", ConstantParas.upload_failed);
            setAttr("message", ConstantParas.upload_failed_unknown);
        }
        renderJson();
    }

    private void writeTo(File f, File newFile) throws IOException {
        FileInputStream fis = new FileInputStream(f);
        FileOutputStream fos = new FileOutputStream(newFile);
        try{
            byte[] buf = new byte[8192];
            do{
                int rc = fis.read(buf);
                if(rc == -1)
                    break;
                fos.write(buf, 0, rc);
                if(rc < buf.length)
                    break;
            }while(true);
        }finally{
            fis.close();
            fos.close();
        }
    }

    public void download(){
        String path = getPara("path");
        String img = PathKit.getWebRootPath() + "/pic/" + path.replaceAll("_", "/");
//        ZipUtil.zip(img, PathKit.getWebRootPath() + "/img/temp/" + path);
        renderFile(img);
    }
}

