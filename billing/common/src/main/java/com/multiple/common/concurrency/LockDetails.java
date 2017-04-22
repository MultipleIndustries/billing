package com.multiple.common.concurrency;

import java.util.Date;
import java.util.Timer;

import com.multiple.common.model.User;

public class LockDetails {

	
	
	private User owner;
	private TransactionKey key;
	private Date createdOn;
	private Timer timeoutWarnTimer;
	private Timer timeoutTimer;

	public LockDetails() {
	}

	public LockDetails(TransactionKey key, User user, ConcurrencyManager concMgr) {
		this.owner = user;
		this.key = key;
		this.createdOn = new Date();
		createTimers(concMgr);
	}


	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}


	public TransactionKey getKey() {
		return key;
	}

	public void setKey(TransactionKey key) {
		this.key = key;
	}

	public Timer getTimeoutTimer() {
		return timeoutTimer;
	}

	public void setTimeoutTimer(Timer timeoutTimer) {
		this.timeoutTimer = timeoutTimer;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public Timer getTimeoutWarnTimer() {
		return timeoutWarnTimer;
	}

	public void setTimeoutWarnTimer(Timer timeoutWarnTimer) {
		this.timeoutWarnTimer = timeoutWarnTimer;
	}

	public void cancelTimers() {
		if (timeoutWarnTimer != null) {
			timeoutWarnTimer.cancel();
		}
		if (timeoutTimer != null) {
			timeoutTimer.cancel();
		}
	}

	public void extendTimers(ConcurrencyManager concMgr) {
		cancelTimers();
		createTimers(concMgr);
	}

	public void createTimers(ConcurrencyManager concMgr) {
		timeoutWarnTimer = new Timer();
		timeoutWarnTimer.schedule(new TimeoutWarningTask(concMgr, key), concMgr.warn_timeout);
		timeoutTimer = new Timer();
		timeoutTimer.schedule(new TimeoutTask(concMgr, key), concMgr.timeout);
	}

	public boolean isClientConnected() {
		return true;
	}
}
