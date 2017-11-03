package sfp.mbeandemo;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class MBeanDemo {
	
	private static final int DEFAULT_NO_THREADS = 10;
	private static final String DEFAULT_SCHEMA = "default";

	public static void main(String[] args) throws Exception {

		// Get the MBean server
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		// register the MBean
		SystemConfig mBean = new SystemConfig(DEFAULT_NO_THREADS, DEFAULT_SCHEMA);
		ObjectName name = new ObjectName("panthaKKKKKKKKKKKKKKKKKKKKkkk:type=" + SystemConfig.class.getSimpleName());
		mbs.registerMBean(mBean, name);
		do {
			Thread.sleep(3000);
			System.out.println("Thread Count=" + mBean.getThreadCount() + ":::Schema Name=" + mBean.getSchemaName());
		} while (mBean.getThreadCount() != 0);
	}
}
