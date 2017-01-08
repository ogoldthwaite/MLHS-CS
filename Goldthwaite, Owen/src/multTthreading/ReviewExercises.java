package multTthreading;

public class ReviewExercises {

	public static void main(String[] args) 
	{
//		GreetingRunnable r1 = new GreetingRunnable("Hello, World!");
//		GreetingRunnable r2 = new GreetingRunnable("Goodbye, World!");
//		r1.run();
//		r2.run();					
		
	}

}

/*  R23.1 - The code does not run in parallel because a thread for both r1 and r2 is never made. The code isnt actually using mutlithreading
 * it's just calling the run method instead.
 *  R23.2 - Yes, both situations are possible. The whole point of threading is that they two threads can run indepentendly of each other. 
 *  Just because one of them is sleeping, or not sleeping, does not mean the other one cannot do the same, or different.
 *  R23.3 - If GUIs only had one thread then whenever the user tried to do something to the GUI, for example making it bigger, he would have
 *  to wait for the thread to finish whatever is going on in the backround of the thread, like processing data or something. With 
 *  multithreading, both these things can happen at once.
 *  R23.4 - The stop method is deprecated because it just stops the thread instantly, meaning that the thread did not "Clean up". The thread
 *  could have stuff open that needs to be closed. To do this you need to call interrupt and then take the proper steps to make sure
 *  the thread does not deprecate.
 *  R23.5 -  A thread should be terminated after it has finished everything that it needs to do. For example, if a thread processes files
 *  of some sort than it should process all the files, once complete it should then terminate and stop.
 *  R23.6 - If it works for you now in the future you may change something about your thread or call interrupt in a different way so in which
 *  the interrupted exception is not properly handled which could cause problems in the future. Maybe.
 *  R23.7 - A race condition occurs when two different threads try to use an object at the same time and negatively effect the outcome of a 
 *  the program because the thread can stop at the wrong point during its execution. This can be stopped by using a lock.
 *  R23.8 - Deadlock occurs when a thread is locked and inside the locked portion of the thread some condition or something is never met and 
 *  the thread stays locked for ever. This can be avoided by using the temporary unlock thing that I forget the name of with await().
 *  R23.9 - A thread that uses sleep just stops running for at least a certain amount of time with no way to properly wake it up which would 
 *  not help with a lock situation. Await allows a thread to stop running until it is signaled with signal method to run again. This makes
 *  it much better for stopping deadlock.
 *  R23.10 - If a thread causes await with no other signal to stop waiting than it will just keep waiting forever, although other threads will
 *  still run as normal but the thread that called await will not.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */



