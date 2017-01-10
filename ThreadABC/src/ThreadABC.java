
public class ThreadABC implements Runnable{
	private static int numa,numb,timea,timeb,scorea,scoreb;
	private int i=1;
	public static void main(String args[]){
		System.out.println("             ThreadA                   ThreadB");
		System.out.println("Round  sleep  Random  Points     sleep  Random  Points");
		System.out.println("       time   integer obtained   time   integer obtained");
		ThreadABC ThreadC = new ThreadABC();
	    new Thread(ThreadC).start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread ThreadA = new RanThread("Thread A");
		Thread ThreadB = new RanThread("Thread B");
		((RanThread) ThreadA).setScore(scorea);
		((RanThread) ThreadB).setScore(scoreb);
		ThreadA.start();
	    ThreadB.start();
	    try{
	    	ThreadA.join();
	    	ThreadB.join();
	    }catch(InterruptedException e){}
        numa=((RanThread) ThreadA).getNum();
        numb=((RanThread) ThreadB).getNum();
        timea=((RanThread) ThreadA).getTime();
        timeb=((RanThread) ThreadB).getTime();
        if(numa>numb)
        	((RanThread) ThreadA).addScore();
        else
        	if(numa<numb)
        		((RanThread) ThreadB).addScore();
        scorea=((RanThread) ThreadA).getScore();
        scoreb=((RanThread) ThreadB).getScore();
		System.out.printf("%d      %-7d%-8d%-11d%-7d%-8d%-11d\n",i++,timea,numa,scorea,timeb,numb,scoreb);
		if(i<10)
			run();
		else{
			System.out.println("\ntatal points---ThreadA:"+scorea+",ThreadB:"+scoreb);
			if(scorea>scoreb)
				System.out.println("\nA is the winner");
			else
				if(scoreb>scorea)
					System.out.println("\nB is the winner");
				else
					run();
		}
				
	}
}

class RanThread extends Thread{
	private int num,time,score=0;
	private String Tname;
	
	RanThread(String name){
		Tname=name;
	}
	
	@Override
	public void run(){
			try {
			num=(int)(Math.random()*(11));
		     //System.out.println(Tname+"'number is:"+num);
			time=((int)(Math.random()*2000));
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	}
	public int getTime(){
		return time;
	}
	
	public int getNum() {
		return num;
	}

	public void setScore(int score){
		this.score=score;
	}
	
	public void addScore(){
		score++;
	}
	public int getScore() {
		return score;
	}	
}
