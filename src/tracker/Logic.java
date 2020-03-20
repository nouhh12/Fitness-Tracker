package tracker;

import java.text.DecimalFormat;
import java.util.ArrayList;

interface base{
	public float getCaloriesBurnt(int time,String exerciseType);
	public float heartRateIncrease(int time,String exerciseType);
	public String getCalories(int j);
	public String getHeartRate(int k);
}
class Track implements base{
	ArrayList<String> activities=new ArrayList<String>();
	DecimalFormat df = new DecimalFormat("####.000"); //used to format the number of decimals in the float values
	public String[] historyCalories=new String[4];	//this is used to store whole sentence for every activity which is 
	public String[] historyHeartRate=new String[4];//later displayed after sorting
	float heartRate=80,caloriesBurnt=0,totalCalories=0,totalHeartRate=80;
	float hrInc=0;int time;
	public float[] totalCal=new float[] {0,0,0,0};	//each activity has an index in the array and then the indices are
	public float[] hrIncrease=new float[] {0,0,0,0};//compared in the sorting 
	private static int i=0;
	public float getCaloriesBurnt(int time,String exerciseType) {
		String lineOfCalories;
		switch(exerciseType) {
		case "Swimming":
			caloriesBurnt=4*time; totalCal[0]+=caloriesBurnt;
			totalCalories+=caloriesBurnt;
			lineOfCalories="Calories Burnt: "+totalCal[0]+" calories";
			historyCalories[0]=lineOfCalories; activities.add("Swimming");
			break;
		case "Running":
			caloriesBurnt=5*time; totalCal[1]+=caloriesBurnt;
			totalCalories+=caloriesBurnt;
			lineOfCalories="Calories Burnt: "+totalCal[1]+" calories";
			historyCalories[1]=lineOfCalories; activities.add("Running");
			break;
		case "Kick_Boxing":
			caloriesBurnt=3*time; totalCal[2]+=caloriesBurnt;
			totalCalories+=caloriesBurnt;
			lineOfCalories="Calories Burnt: "+totalCal[2]+" calories";
			historyCalories[2]=lineOfCalories; activities.add("Kick Boxing");
			break;
		case "Strength_Training":
			caloriesBurnt=5*time; totalCal[3]+=caloriesBurnt;
			totalCalories+=caloriesBurnt;
			lineOfCalories="Calories Burnt: "+totalCal[3]+" calories";
			historyCalories[3]=lineOfCalories; activities.add("Strength Training");
			break;
		}
		return caloriesBurnt;
	}
	public float heartRateIncrease(int time,String exerciseType) {
		String lineOfHeartRate;float old;
		switch(exerciseType) {
		case "Swimming":
			old=heartRate;
			heartRate+=(heartRate*time*0.002);
			hrInc=heartRate-old;
			hrIncrease[0]+=hrInc;
			lineOfHeartRate="Heart rate increase: "+df.format(hrIncrease[0])+" beats/minute.";
			historyHeartRate[0]=lineOfHeartRate;
			break;
		case "Running":
			old=heartRate;
			heartRate+=(heartRate*time*0.003);
			hrInc=heartRate-old;
			hrIncrease[1]+=hrInc;
			lineOfHeartRate="Heart rate increase: "+df.format(hrIncrease[1])+" beats/minute.";
			historyHeartRate[1]=lineOfHeartRate;
			break;
		case "Kick_Boxing":
			old=heartRate;
			heartRate+=(heartRate*time*0.005);
			hrInc=heartRate-old;
			hrIncrease[2]+=hrInc;
			lineOfHeartRate="Heart rate increase: "+df.format(hrIncrease[2])+" beats/minute.";
			historyHeartRate[2]=lineOfHeartRate;
			break;
		case "Strength_Training":
			old=heartRate;
			heartRate+=(heartRate*time*0.006);
			hrInc=heartRate-old;
			hrIncrease[3]+=hrInc;
			lineOfHeartRate="Heart rate increase: "+df.format(hrIncrease[3])+" beats/minute.";
			historyHeartRate[3]=lineOfHeartRate;
			break;
		}
		return hrInc;
	}
	/*public String getActivity() {
		return activities.get(i++);
	}*/
	public String getCalories(int j) {
		return historyCalories[j];
	}
	public String getHeartRate(int k) {
		return historyHeartRate[k];
	}
}