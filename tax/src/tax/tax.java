package tax;

public class tax {
	public static void main(String[] args){
		double single,windower,married,household,income;
		int i;
		System.out.printf("taxable Single    Married   Married   Head of\n");
		System.out.printf("Income            Joint     Separate  a House\n\n");
		for(i=50000;i<=60000;i=i+50){
			income=i*1.0;
			single=4090+(i-29700)*0.25;
			if(i<59400)
				windower=1460+(i-14600)*0.15;
			else
				windower=8180+(i-59400)*0.25;
			if(i<59975)
				married=4090+(i-29700)*0.25;
			else
				married=11658.75+(i-59975)*0.28;
			household=5447.50+(i-39800)*0.25;
			System.out.printf("%5.0f%10.2f%10.2f%10.2f%10.2f\n",income,single,windower,married,household);
		}
	}
}
