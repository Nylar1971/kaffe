/*
 * ksem.h
 *
 * Copyright (c) 200
 *	University of Utah.  All Rights Reserved.
 *
 * See the file "license.terms" for information on usage and redistribution 
 * of this file. 
 */

#include "ksem.h"
#include "support.h"

#ifndef THREAD_SYSTEM_HAS_KSEM

/*
 * Initialize the just-allocated Ksem.  This function is only invoked
 * by the threading system when a new thread is allocated.
 */
void
ksem_init(Ksem* sem)
{
	assert(sem != NULL);
	
	jmutex_initialise(&(sem->mux));
	jcondvar_initialise(&(sem->cv));
	sem->count = 0;
}

/**
 * Use a stored wakeup from the semaphore.  Block if none
 * are available.  Can wait with a timeout.  (If timeout is 0, then
 * do not timeout in wait.)
 * Spurious wakeups are not handled here.
 *
 * @param sem Semaphore to wait for.
 * @param timeout The number of milliseconds to wait if different of 0.
 * If timeout is null, wait indefinitely.
 * @return true if the semaphore was acquired, returns false if
 * we timed-out in wait and semaphore still wasn't available.
 */
jboolean
ksem_get(Ksem* volatile sem, jlong timeout)
{
	jboolean r;

	assert(sem != NULL);
	
	r = true;

	if (timeout == 0)
		timeout = NOTIMEOUT;

	dprintf("ksem_get sp=%p\n", &r);

	KMUTEX(lock)(&sem->mux);
	/* If no stored wakeups, then sleep. */
	if (sem->count == 0) {
	  (void)KCONDVAR(wait)(&sem->cv, &sem->mux, timeout);
	}

	/* Use a stored wakeup if available. */
	if (sem->count == 1) {
		sem->count = 0;
		r = true;
	}
	else {
		/* Still no stored wakeup means we waited and timedout. */
		r = false;
	}
	assert(sem->count == 0);
	KMUTEX(unlock)(&sem->mux);
	return (r);
}

/*
 * Store a wakeup in the semaphore.  Wakeup one thread blocked
 * on the cv (if any).
 */
void
ksem_put(Ksem* volatile sem)
{
	assert(sem != NULL);
	KMUTEX(lock)(&sem->mux);
        sem->count = 1;
	KCONDVAR(signal)(&sem->cv, &sem->mux);
	KMUTEX(unlock)(&sem->mux);
}

void
ksem_destroy(Ksem* sem)
{
	assert(sem != NULL);
	KMUTEX(destroy)(&(sem->mux));
	KCONDVAR(destroy)(&(sem->cv));
}

#endif
