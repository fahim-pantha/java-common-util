package sfp.mbeandemo;

import java.util.ArrayList;
import java.util.List;

class SystemConfig implements SystemConfigMBean {
	List<String> list = new ArrayList<>();
	private int threadCount;
	private String schemaName;

	public SystemConfig(int numThreads, String schema) {
		this.threadCount = numThreads;
		this.schemaName = schema;
	}

	@Override
	public void setThreadCount(int noOfThreads) {
		this.threadCount = noOfThreads;
	}

	@Override
	public int getThreadCount() {
		return this.threadCount;
	}

	@Override
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	@Override
	public String getSchemaName() {
		return this.schemaName;
	}

	@Override
	public String doConfig() {
		return "No of Threads=" + this.threadCount + " and DB Schema Name=" + this.schemaName;
	}

	@Override
	public int getListCount() {
		return list.size();
	}
}

