package com.devsumo.examples.fuse.java.ftpserver;

import org.apache.ftpserver.FtpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class FtpServerManager implements ApplicationListener<ApplicationEvent> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FtpServerManager.class);
	
	private FtpServer ftpServer;
	
	public void setFtpServer(FtpServer ftpServer) {
		this.ftpServer = ftpServer;
	}
	
	public FtpServer getFtpServer() {
		return ftpServer;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		LOGGER.info("Received " + event);
		if(event instanceof ContextRefreshedEvent) {
			try {
				LOGGER.info("Starting FTP server");
				ftpServer.start();
			} catch(Exception eFtp) {
				LOGGER.error("Failed to start FTP server", eFtp);
			}
		}
	}

}
