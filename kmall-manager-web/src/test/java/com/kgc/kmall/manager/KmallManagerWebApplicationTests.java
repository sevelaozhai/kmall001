package com.kgc.kmall.manager;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KmallManagerWebApplicationTests {

	@Test
	void contextLoads() {
		try {
			String file = this.getClass().getResource("/tracker.conf").getFile();
			ClientGlobal.init("E:\\java比较杂项的资料\\分布式\\kmall003\\kmall-manager-web\\src\\main\\resources\\tracker.conf");
			TrackerClient trackerClient = new TrackerClient();
			TrackerServer trackerServer = trackerClient.getTrackerServer();
			StorageClient storageClient = new StorageClient(trackerServer, null);
			String orginalFilename = "C:\\Users\\haohao\\Desktop\\1KgX-hqwsysz0581782.jpg";
			String[] upload_file = storageClient.upload_file(orginalFilename, "jpg", null);
			String path = "http://192.168.163.128";
			for (int i = 0; i < upload_file.length; i++) {
				String s = upload_file[i];
				System.out.println("s = " + s);
				path += "/" + s;
			}
			System.out.println(path);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
