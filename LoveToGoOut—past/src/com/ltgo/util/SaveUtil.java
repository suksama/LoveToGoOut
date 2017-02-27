package com.ltgo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

import sun.misc.BASE64Decoder;

public class SaveUtil {

	public String SaveImage(ServletContext context, String photo) {
		String path = null;
		String workspace = "D:/WorkSpace/WEBws/LoveToGoOut/WebContent/images/";
		//合并需要修改workspace地址
		String ext = ".png";
		String fileName = UUID.randomUUID().toString();
		try {
			byte[] photoimg = new BASE64Decoder().decodeBuffer(photo);
			for (int i = 0; i < photoimg.length; ++i) {
				if (photoimg[i] < 0) {
					photoimg[i] += 256;
				}
			}

			System.out.println("图片的大小：" + photoimg.length);
			path = context.getRealPath("/images");
			System.out.println("path"+path);
			File dir = new File(path);
			if (!dir.exists()) {
				dir.mkdir();
			}
			File image = new File(workspace);
			if (!image.exists()) {
				image.mkdir();
			}
			File file = new File(path, fileName + ext);
			File file1 = new File(workspace, fileName + ext);
			if (!file.exists()) {
				file.createNewFile();
			}
			if (!file1.exists()) {
				file1.createNewFile();
			}
			FileOutputStream out = new FileOutputStream(file);
			FileOutputStream out1 = new FileOutputStream(file1);
			out.write(photoimg);
			out1.write(photoimg);
			out.flush();
			out1.flush();
			out.close();
			out1.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("images"+"/"+ fileName + ext);
		return "images"+"/"+ fileName + ext;

	}
}
