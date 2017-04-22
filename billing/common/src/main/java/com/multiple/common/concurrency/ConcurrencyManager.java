package com.multiple.common.concurrency;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.multiple.common.model.User;
import com.multiple.common.util.PropsValues;
import com.multiple.kernel.exception.CustomException;
/**
 * Used to manage locks on records. A service will typically create an instance
 * of this class for itself by calling the constructor and passing its
 * transactionType.
 */
@Component
public class ConcurrencyManager {

	@Autowired
	PropsValues props;
	
	public  int warn_timeout = 0;
	public  int timeout = 0;
	
	@PostConstruct
	void postconstruct()
	{
		warn_timeout = props.CONCURRENCY_SESSION_WARNING;
		timeout = props.CONCURRENCY_SESSION_EXPIRE;
		System.out.println("******************************************************************* Post construct successfull an we got timeout :"+ warn_timeout+" and expire : "+timeout+"**************************************************************" );
	}
	
	public static boolean enabled = true;


	/**
	 * A Map containing the locks on records. The Transaction ID will be the Key
	 */
	private Map<TransactionKey, LockDetails> locks;


	/**
	 * Create a new instance of the ConcurrencyManager
	 * 
	 * @param transactionType
	 *            The Transaction for which concurrency needs to be managed
	 */
	public ConcurrencyManager() {
		this.locks = Collections.synchronizedMap(new HashMap<TransactionKey, LockDetails>());
	}

	/**
	 * Tries to get the lock for the specified transaction
	 * 
	 * @param transactionId
	 *            A valid transaction Id
	 * @param user
	 *            A valid User
	 * @throws RecordLockedException
	 *             if the record is already locked
	 */
	public synchronized void lock(long transactionId, User user,String transactionType, String token) throws RecordLockedException {
		TransactionKey key = new TransactionKey(transactionId,transactionType, token);
		if (!enabled) {
			return;
		}
		if (transactionId <= 0) {
			throw new IllegalArgumentException("Invalid TransactionId");
		} else if (user == null || user.getUserId() == 0) {
			throw new IllegalArgumentException("User must not be null");
		}

		LockDetails lockDetail = locks.get(key);
		if (lockDetail != null && !lockDetail.isClientConnected()) {
			releaseLock(transactionId);
		}

		if (isLocked(key,user)) {
			throw new RecordLockedException(locks.get(key),CustomException.RECORD_LOCK_EXCEPTION.getCode());
		} else {
			LockDetails lockDetails = new LockDetails(key, user, this);
			locks.put(key, lockDetails);
//			pushLockedMessage(lockDetails);
		}
	}

	public synchronized void forceLock(long transactionId, User user,String transactionType, String token) {
		TransactionKey key = new TransactionKey(transactionId,transactionType,token);
		if (transactionId <= 0) {
			throw new IllegalArgumentException("Invalid TransactionId");
		} else if (user == null || user.getUserId() == 0) {
			throw new IllegalArgumentException("User must not be null");
		}

		if (isLocked(key,user)) {
			releaseLock(transactionId);
		}
		LockDetails lockDetails = new LockDetails(key, user, this);
		locks.put(key, lockDetails);
//		pushLockedMessage(lockDetails);
	}

//	private void pushLockedMessage(LockDetails lockDetails) {
//		MessageBroker msgBroker = MessageBroker.getMessageBroker(BeanIds.MESSAGE_BROKER);
//		AsyncMessage msg = new AsyncMessage();
//		msg.setDestination("conc-msg");
//		msg.setBody(lockDetails);
//		msg.setMessageId(UUIDUtils.createUUID());
//		msg.setHeader("broadcast", true);
//		msg.setHeader("locked", true);
//		msgBroker.routeMessageToService(msg, null);
//	}

	public boolean isLocked(TransactionKey transactionKey, User user) {
		LockDetails lockDetails = locks.get(transactionKey);
		if(lockDetails != null && user.getUserId() != lockDetails.getOwner().getUserId())
		{
			return true;
		}
		else if(lockDetails != null && (user.getMacId()!=null || lockDetails.getOwner().getMacId()!=null) && !(user.getMacId() != null && user.getMacId().equals(lockDetails.getOwner().getMacId())))
		{
			return true;
		}
		else {
			return false;
		}
	}

	public synchronized boolean requestLockRelease(int transactionId, User requestedBy) {
//		if (!isLocked(transactionId)) {
//			return false;
//		} else {
//			MessageBroker msgBroker = MessageBroker.getMessageBroker(BeanIds.MESSAGE_BROKER);
//			LockDetails lockDetails = locks.get(transactionId);
//			AsyncMessage msg = new AsyncMessage();
//			msg.setDestination("conc-msg");
//			// msg.setBody(new LockReleaseRequest(lockDetails, requestedBy));
//			msg.setMessageId(UUIDUtils.createUUID());
//			msg.setHeader("userId", lockDetails.getOwner().getUserid());
//			msg.setHeader("releaseRequest", true);
//			msgBroker.routeMessageToService(msg, null);
			return true;
//		}
	}

	public synchronized void releaseLock(Object request) {
//		 locks.remove(request.getLockDetails().getTransactionId());
//		MessageBroker msgBroker = MessageBroker.getMessageBroker(BeanIds.MESSAGE_BROKER);
//		AsyncMessage msg = new AsyncMessage();
//		msg.setDestination("conc-msg");
//		msg.setBody(request);
//		msg.setMessageId(UUIDUtils.createUUID());
//		// msg.setHeader("userId", request.getRequestedBy().getUserid());
//		msg.setHeader("requestGranted", true);
//		msgBroker.routeMessageToService(msg, null);
	}

	public synchronized void releaseLock(TransactionKey key) {
		LockDetails lockDetails = locks.remove(key);
		lockDetails.cancelTimers();
//		MessageBroker msgBroker = MessageBroker.getMessageBroker(BeanIds.MESSAGE_BROKER);
//		AsyncMessage msg = new AsyncMessage();
//		msg.setDestination("conc-msg");
//		msg.setBody(lockDetails);
//		msg.setMessageId(UUIDUtils.createUUID());
//		msg.setHeader("broadcast", true);
//		msg.setHeader("lockReleased", true);
//		msgBroker.routeMessageToService(msg, null);
	}

	/**
	 * Removes the lock on the transaction, only if the owner is the same as the
	 * specified user
	 * 
	 * @param transactionId
	 * @param ownerId
	 * @return <code>true</code> if the lock was removed (or non-existent),
	 *         <code>false</code> otherwise
	 */
	public synchronized boolean releaseLock(TransactionKey transactionId, int ownerId) {
		LockDetails lockDetails = locks.get(transactionId);
		if (lockDetails == null) {
			return true;
		}
		if (lockDetails.getOwner().getUserId() == ownerId) {
			releaseLock(transactionId);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Extends the lock on the transaction, only if the owner is the same as the
	 * specified user
	 * 
	 * @param transactionId
	 * @param ownerId
	 * @return <code>true</code> if the lock was extended, <code>false</code>
	 *         otherwise
	 */
	public synchronized boolean extendLock(TransactionKey transactionId, int ownerId) {
		LockDetails lockDetails = locks.get(transactionId);
		if (lockDetails == null) {
			return false;
		}
		if (lockDetails.getOwner().getUserId() == ownerId) {
			lockDetails.extendTimers(this);
			return true;
		} else {
			return false;
		}
	}

	public synchronized void sendTimeoutWarning(TransactionKey lockKey) {
		LockDetails lockDetails = locks.get(lockKey);
//		MessageBroker msgBroker = MessageBroker.getMessageBroker(BeanIds.MESSAGE_BROKER);
//		AsyncMessage msg = new AsyncMessage();
//		msg.setDestination("conc-msg");
//		msg.setBody(lockDetails);
//		msg.setMessageId(UUIDUtils.createUUID());
//		msg.setHeader("userId", lockDetails.getOwner().getUserid());
//		msg.setHeader("timeoutWarning", true);
//		msgBroker.routeMessageToService(msg, null);
	}

	public synchronized void timeout(TransactionKey lockKey) {
		LockDetails lockDetails = locks.get(lockKey);
		releaseLock(lockKey);
//		MessageBroker msgBroker = MessageBroker.getMessageBroker(BeanIds.MESSAGE_BROKER);
//		AsyncMessage msg = new AsyncMessage();
//		msg.setDestination("conc-msg");
//		msg.setBody(lockDetails);
//		msg.setMessageId(UUIDUtils.createUUID());
//		msg.setHeader("userId", lockDetails.getOwner().getUserid());
//		msg.setHeader("timeout", true);
//		msgBroker.routeMessageToService(msg, null);
	}

	public synchronized LockDetails getLockInfo(TransactionKey key) {
		return locks.get(key);
	}

	public synchronized Collection<LockDetails> getAllLockDetails() {
		return locks.values();
	}

}
