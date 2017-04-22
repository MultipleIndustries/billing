package com.multiple.common.concurrency;

import java.util.TimerTask;

public class TimeoutTask extends TimerTask {

	private ConcurrencyManager concMgr;
	private TransactionKey lockKey;
	
	public TimeoutTask(ConcurrencyManager concMgr, TransactionKey lockKey) {
		this.concMgr = concMgr;
		this.lockKey = lockKey;
	}

	@Override
	public void run() {
		concMgr.timeout(lockKey);
	}

}
