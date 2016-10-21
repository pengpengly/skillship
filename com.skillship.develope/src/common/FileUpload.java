package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.struts2.ServletActionContext;



public class FileUpload{
	
	//上传文件存放路径   
    private final static String UPLOADDIR = "uploadfile";   
   
    //上传文件集合   
    private List<File> file;   
    //上传文件名集合   
    private List<String> fileFileName;   
    //上传文件内容类型集合   
    private List<String> fileContentType;   
    
    
    
    
    
    
    
    
    
    
    public List<String> upload()throws FileNotFoundException, IOException{
    	 System.out.println(this.getFileFileName()); 
    	 
    	 List<String> ls=new ArrayList();
         for (int i = 0; i < file.size(); i++) {   
             //循环上传每个文件   
             ls.add(uploadFile(i));   
         }  
         
         return ls;
    }
    
    
    
    //执行上传功能   
    private String uploadFile(int i) throws FileNotFoundException, IOException {   
        String filepath="";
    	try {   
            InputStream in = new FileInputStream(file.get(i));   
            String dir = ServletActionContext.getRequest().getRealPath(UPLOADDIR);  
            File fileLocation = new File(dir);  
            //此处也可以在应用根目录手动建立目标上传目录  
            if(!fileLocation.exists()){  
                boolean isCreated  = fileLocation.mkdir();  
                if(!isCreated) {  
                    //目标上传目录创建失败,可做其他处理,例如抛出自定义异常等,一般应该不会出现这种情况。  
                    return "文件夹创建失败";  
                }  
            }  
            String fileName=this.getFileFileName().get(i);  
            
            String newfileName=getRandomFileName(fileName);
            
            File uploadFile = new File(dir, newfileName);   
            
            OutputStream out = new FileOutputStream(uploadFile);   
            byte[] buffer = new byte[1024 * 1024];   
            int length;   
            while ((length = in.read(buffer)) > 0) {   
                out.write(buffer, 0, length);   
            }   
            in.close();   
            out.close();
            filepath=UPLOADDIR+"/"+newfileName;
        } catch (FileNotFoundException ex) {   
            System.out.println("上传失败!");  
            ex.printStackTrace();   
        } catch (IOException ex) {   
            System.out.println("上传失败!");  
            ex.printStackTrace();   
        }   
        return  filepath;
        
    }   
    
    
    //
    private  String getRandomFileName(String sfilename) {  
    	  
        SimpleDateFormat simpleDateFormat;  
  
        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");  
  
        Date date = new Date();  
  
        String str = simpleDateFormat.format(date);  
  
        Random random = new Random();  
  
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数  
  
        String ext=sfilename.substring(sfilename.lastIndexOf("."),sfilename.length());

        StringBuffer sb=new StringBuffer();
        
        
        String filename=sb.append(rannum).append(str).append(ext).toString();

       return filename; 
    }  
    
    
    public List<File> getFile() {   
        return file;   
    }   

    public void setFile(List<File> file) {   
        this.file = file;   
    }   

   public List<String> getFileFileName() {   
       return fileFileName;   
   }   

    public void setFileFileName(List<String> fileFileName) {   
        this.fileFileName = fileFileName;   
    }   

    public List<String> getFileContentType() {   
        return fileContentType;   
    }   

    public void setFileContentType(List<String> fileContentType) {   
        this.fileContentType = fileContentType;   
    }   
    
    
    
    
    
}
