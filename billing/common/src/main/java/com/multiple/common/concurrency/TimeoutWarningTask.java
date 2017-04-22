package com.multiple.common.concurrency;

import java.util.TimerTask;

public class TimeoutWarningTask extends TimerTask {

	private ConcurrencyManager concMgr;
	private TransactionKey lockKey;
	
	public TimeoutWarningTask(ConcurrencyManager concMgr, TransactionKey lockKey) {
		this.concMgr = concMgr;
		this.lockKey = lockKey;
	}

	@Override
	public void run() {
		concMgr.sendTimeoutWarning(lockKey);
	}

}
